package se233.chapter1.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import se233.chapter1.Launcher;
import se233.chapter1.controller.AllCustomHandler;
import se233.chapter1.model.character.BasedCharacter;

public class CharacterPane extends ScrollPane {
    private BasedCharacter character;
    public CharacterPane() {}
    private Pane getDetailsPane() {
        Pane charInfoPane = new VBox(10);
        charInfoPane.setBorder(null);
        charInfoPane.setPadding(new Insets(25, 25,25,25));

        Label name, type, hp, atk, def ,res;
        ImageView mainImg = new ImageView();

        if (this.character!=null) {
            name = new Label("Name: "+character.getName());
            mainImg.setImage(new Image(Launcher.class.getResource(character.getImgPath()).toString()));
            type = new Label("Type: "+character.getType().toString());
            hp = new Label("HP: "+character.getHp());
            atk = new Label("ATK: "+character.getPow());
            def = new Label("DEF: "+character.getDef());
            res = new Label("RES: "+character.getRes());


        }
        else {
            name = new Label("Name:");
            mainImg.setImage(new Image(Launcher.class.getResource("assets/unknown.png").toString()));
            type = new Label("Type:");
            hp = new Label("HP:");
            atk = new Label("ATK:");
            def = new Label("DEF:");
            res = new Label("RES:");
        }

        Button genCharacter = new Button();
        genCharacter.setText("Generate Character");
        genCharacter.setOnAction(new AllCustomHandler.GenCharacterHandler());

        Button unequipWeapon = new Button();
        unequipWeapon.setText("Unequip Weapon");
        unequipWeapon.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AllCustomHandler.unequipItem(Launcher.getCurrentWeapon());
            }
        });

        Button unequipArmor = new Button();
        unequipArmor.setText("Unequip Armor");
        unequipArmor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AllCustomHandler.unequipItem(Launcher.getCurrentArmor());
            }
        });

        charInfoPane.getChildren().addAll(name, mainImg, type, atk, def, res, genCharacter, unequipWeapon, unequipArmor);
        return charInfoPane;
    }

    public void drawPane(BasedCharacter character) {
        this.character = character;
        Pane charInfo = getDetailsPane();
        this.setStyle("-fx-background-color:Red;");
        this.setContent(charInfo);
    }
}