package se233.chapter1.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;
import se233.chapter1.Launcher;
import se233.chapter1.model.character.BasedCharacter;
import se233.chapter1.model.item.Armor;
import se233.chapter1.model.item.BasedEquipment;
import se233.chapter1.model.item.Weapon;

import java.util.ArrayList;

public class AllCustomHandler {

    // Handle character generation
    public static class GenCharacterHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            //Launcher.
            Launcher.setMainChar(GenCharacter.setUpCharacter());
            // EXERCISE 5.
            Launcher.setAllEquipment(GenItemList.setUpItemList());
            Launcher.setCurrentWeapon(null);
            Launcher.setCurrentArmor(null);
            Launcher.refreshPane();
        }
    }

    // When item is dragged
    public static void onDragDetected(MouseEvent event, BasedEquipment equipment, ImageView imgView) {
        Dragboard db = imgView.startDragAndDrop(TransferMode.ANY);
        db.setDragView(imgView.getImage());
        ClipboardContent content = new ClipboardContent();
        content.put(BasedEquipment.DATA_FORMAT, equipment);
        db.setContent(content);
        event.consume();
    }

    public static void onDragOver(DragEvent event, String type) {
        Dragboard db = event.getDragboard();
        BasedEquipment retrievedEquipment = (BasedEquipment)db.getContent(BasedEquipment.DATA_FORMAT);

        if (db.hasContent(BasedEquipment.DATA_FORMAT) && retrievedEquipment.getClass().getSimpleName().equals(type)) {
            event.acceptTransferModes(TransferMode.MOVE);
        }
    }

    public static void onDragDropped(DragEvent event, Label label, StackPane imgGroup) {
        boolean dragComplete = false;
        ArrayList<BasedEquipment> allEquipments = Launcher.getAllEquipment();
        Dragboard db = event.getDragboard();

        if (db.hasContent(BasedEquipment.DATA_FORMAT)) {
            BasedEquipment retrievedEquipment = (BasedEquipment)db.getContent(BasedEquipment.DATA_FORMAT);
            BasedCharacter character = Launcher.getMainChar();
            if ((retrievedEquipment.getClass().getSimpleName().equals("Weapon"))) {
                if (!character.getClass().getSimpleName().equals("BattleMage") && character.getType() != ((Weapon)retrievedEquipment).getType())
                    return;
                if (Launcher.getCurrentWeapon() != null)
                        allEquipments.add(Launcher.getCurrentWeapon());
                Launcher.setCurrentWeapon((Weapon) retrievedEquipment);
                character.equipWeapon((Weapon) retrievedEquipment);
            }
            else if (!character.getClass().getSimpleName().equals("BattleMage")){
                if (Launcher.getCurrentArmor() != null)
                    allEquipments.add(Launcher.getCurrentArmor());
                Launcher.setCurrentArmor((Armor) retrievedEquipment);
                character.equipArmor((Armor) retrievedEquipment);
            }
            else {
                event.setDropCompleted(false);
                return;
            }

            Launcher.setMainChar(character);
            Launcher.setAllEquipment(allEquipments);
            ImageView imgView = new ImageView();
            if (imgGroup.getChildren().size()!=1) {
                imgGroup.getChildren().remove(1);
                Launcher.refreshPane();
            }
            label.setText(retrievedEquipment.getClass().getSimpleName() + ":\n" + retrievedEquipment.getName());
            imgView.setImage(new Image(Launcher.class.getResource(retrievedEquipment.getImgPath()).toString()));
            imgGroup.getChildren().add(imgView);
            dragComplete = true;
        }
        event.setDropCompleted(dragComplete);
    }

    // onequipdone
    public static void removeItemInvPane(DragEvent event) {
        // Remove the equipped item from the list of equipment
        Dragboard db = event.getDragboard();
        ArrayList<BasedEquipment> allEquipments = Launcher.getAllEquipment();
        BasedEquipment retrievedEquipment = (BasedEquipment) db.getContent(BasedEquipment.DATA_FORMAT);
        int pos = -1;
        for (int i = 0; i<allEquipments.size();i++) {
            if (allEquipments.get(i).getName().equals(retrievedEquipment.getName())) {
                pos = i;
            }
        }
        if (pos != -1) {
            allEquipments.remove(pos);
        }
        Launcher.setAllEquipment(allEquipments);
        Launcher.refreshPane();
    }

    //EXERCISE 4.
    public static void unequipItem(BasedEquipment currentEquipment) {
        if (currentEquipment == null)
            return;
        ArrayList<BasedEquipment> allEquipments = Launcher.getAllEquipment();
        allEquipments.add(currentEquipment);
        String type = currentEquipment.getClass().getSimpleName();
        if (type.equals("Weapon")) {
            Launcher.setCurrentWeapon(null);
            Launcher.getMainChar().resetPow();
        }
        else {
            Launcher.setCurrentArmor(null);
            Launcher.getMainChar().resetDefRes();
        }

        Launcher.setAllEquipment(allEquipments);
        Launcher.refreshPane();
    }
}