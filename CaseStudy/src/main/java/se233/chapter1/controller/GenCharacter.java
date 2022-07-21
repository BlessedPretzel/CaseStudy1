package se233.chapter1.controller;

import se233.chapter1.model.character.BasedCharacter;
import se233.chapter1.model.character.BattleMage;
import se233.chapter1.model.character.MagicCharacter;
import se233.chapter1.model.character.PhysicalCharacter;

import java.util.Random;

public class GenCharacter {
    public static BasedCharacter setUpCharacter() {
        BasedCharacter character;
        Random random = new Random();
        int type = random.nextInt(3);
        int baseDef = random.nextInt(50)+1;
        int baseRes = random.nextInt(50)+1;
        switch (type) {
            case 0:
            character = new MagicCharacter("MagicChar1","assets/wizard.png", baseDef, baseRes);
            break;
            case 1:
            character = new PhysicalCharacter("PhysicalChar1", "assets/knight.png", baseDef, baseRes);
            break;
            default:
            character = new BattleMage("BattleMage","assets/battlemage.png", baseDef, baseRes);
        }
        return character;
    }

}
