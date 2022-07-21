package se233.chapter1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import se233.chapter1.controller.GenCharacter;
import se233.chapter1.controller.GenItemList;
import se233.chapter1.model.character.BasedCharacter;
import se233.chapter1.model.item.Armor;
import se233.chapter1.model.item.BasedEquipment;
import se233.chapter1.model.item.Weapon;
import se233.chapter1.view.CharacterPane;
import se233.chapter1.view.EquipPane;
import se233.chapter1.view.InventoryPane;

import java.util.ArrayList;

public class Launcher extends Application {

    private static Scene mainScene;
    private static BasedCharacter mainChar;
    private static ArrayList<BasedEquipment> allEquipment;
    private static Weapon currentWeapon;
    private static Armor currentArmor;
    private static CharacterPane charPane;
    private static EquipPane equipPane;
    private static InventoryPane invPane;

    public static Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public static Armor getCurrentArmor() {
        return currentArmor;
    }

    public static void setAllEquipment(ArrayList<BasedEquipment> allEquipment) {
        Launcher.allEquipment = allEquipment;
    }

    public static ArrayList<BasedEquipment> getAllEquipment() {
        return allEquipment;
    }
    public static void setCurrentWeapon(Weapon retrievedEquipment) {
        currentWeapon = retrievedEquipment;
    }

    public static void setCurrentArmor(Armor retrievedEquipment) {
        currentArmor = retrievedEquipment;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //primaryStage set up
        primaryStage.setTitle("TEST RPG");
        primaryStage.setResizable(false);
        primaryStage.show();

        mainChar = GenCharacter.setUpCharacter();
        allEquipment = GenItemList.setUpItemList();
        //Main pane
        Pane mainPane = getMainPane();
        mainScene = new Scene(mainPane);
        primaryStage.setScene(mainScene);
    }

    public Pane getMainPane() {
        BorderPane mainPane = new BorderPane();
        charPane = new CharacterPane();
        equipPane = new EquipPane();
        invPane = new InventoryPane();
        refreshPane();
        mainPane.setCenter(charPane);
        mainPane.setLeft(equipPane);
        mainPane.setBottom(invPane);
        return mainPane;
    }

    public static void refreshPane() {
        charPane.drawPane(mainChar);
        equipPane.drawPane(currentWeapon,currentArmor);
        invPane.drawPane(allEquipment);
    }

    public static BasedCharacter getMainChar() { return mainChar;}

    public static void setMainChar(BasedCharacter mainChar) {
        Launcher.mainChar = mainChar;
    }

    public static void main(String[] args) {
        launch(args);
    }
}