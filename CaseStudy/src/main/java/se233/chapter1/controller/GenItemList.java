package se233.chapter1.controller;

import se233.chapter1.model.character.DamageType;
import se233.chapter1.model.item.Armor;
import se233.chapter1.model.item.BasedEquipment;
import se233.chapter1.model.item.Weapon;

import java.util.ArrayList;

public class GenItemList {
    public static ArrayList<BasedEquipment> setUpItemList() {
        ArrayList<BasedEquipment> itemLists = new ArrayList<BasedEquipment>(7);
        itemLists.add(new Weapon("Sword",10, DamageType.phy, "assets/sword1.png"));
        itemLists.add(new Weapon("Gun",20, DamageType.phy, "assets/gun1.png"));
        itemLists.add(new Weapon("Staff",30, DamageType.magic, "assets/staff1.png"));
        // EXERCISE 1.
        itemLists.add(new Weapon("Boxing Gloves",5, DamageType.phy, "assets/gloves1.png"));
        itemLists.add(new Weapon("God Gauntlet",99, DamageType.magic, "assets/gauntlet1.png"));

        itemLists.add(new Armor("Shirt",0,50, "assets/shirt1.png"));
        itemLists.add(new Armor("Armor",50,0, "assets/armor1.png"));
        return itemLists;
    }
}