package se233.chapter1.view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import se233.chapter1.Launcher;
import se233.chapter1.model.item.Armor;
import se233.chapter1.model.item.Weapon;


import se233.chapter1.controller.AllCustomHandler;

public class EquipPane extends ScrollPane {
    private Weapon currentWeapon;
    private Armor currentArmor;
    public EquipPane() {}
    private Pane getDetailsPane() {
        Pane equipInfoPane = new VBox(10);
        equipInfoPane.setBorder(null);
        ((VBox)equipInfoPane).setAlignment(Pos.CENTER);
        equipInfoPane.setPadding(new Insets(25,25,25,25));

        Label weaponLbl, armorLbl;
        StackPane weaponImgGroup = new StackPane();
        StackPane armorImgGroup = new StackPane();
        ImageView bg1 = new ImageView();
        ImageView bg2 = new ImageView();

        ImageView weaponImg = new ImageView();
        ImageView armorImg = new ImageView();

        // get blank.png and add blank.png
        bg1.setImage(new Image(Launcher.class.getResource("assets/blank.png").toString()));
        bg2.setImage(new Image(Launcher.class.getResource("assets/blank.png").toString()));
        weaponImgGroup.getChildren().add(bg1);
        armorImgGroup.getChildren().add(bg2);

        if (currentWeapon!=null) {
            weaponLbl = new Label("Weapon:\n"+currentWeapon.getName());
            weaponImg.setImage(new Image(Launcher.class.getResource(currentWeapon.getImgPath()).toString()));
            weaponImgGroup.getChildren().add(weaponImg);
        }
        else {
            weaponLbl = new Label("Weapon: \n ");
            weaponImg.setImage(new Image(Launcher.class.getResource("assets/blank.png").toString()));
        }
        if (currentArmor!=null) {
            armorLbl = new Label("Armor:\n"+currentArmor.getName());
            armorImg.setImage(new Image(Launcher.class.getResource(currentArmor.getImgPath()).toString()));
            armorImgGroup.getChildren().add(armorImg);
        }
        else {
            armorLbl = new Label("Armor: \n ");
            armorImg.setImage(new Image(Launcher.class.getResource("assets/blank.png").toString()));
        }

        weaponImgGroup.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                AllCustomHandler.onDragOver(dragEvent, "Weapon");
            }
        });
        armorImgGroup.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                AllCustomHandler.onDragOver(dragEvent, "Armor");
            }
        });

        weaponImgGroup.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                AllCustomHandler.onDragDropped(dragEvent, weaponLbl, weaponImgGroup);
            }
        });
        armorImgGroup.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                AllCustomHandler.onDragDropped(dragEvent, armorLbl, armorImgGroup);
            }
        });
        equipInfoPane.getChildren().addAll(weaponLbl, weaponImgGroup, armorLbl, armorImgGroup);
        return equipInfoPane;
    }

    public void drawPane(Weapon currentWeapon, Armor currentArmor) {
        this.currentWeapon = currentWeapon;
        this.currentArmor = currentArmor;
        Pane invInfo = getDetailsPane();
        this.setStyle("-fx-background-color:Red;");
        this.setContent(invInfo);
    }
}