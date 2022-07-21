package se233.chapter1.model.character;

// EXERCISE 2.
public class BattleMage extends BasedCharacter {
    public BattleMage(String name, String imgPath, int baseDef, int baseRes) {
        this.name = name;
        this.type = DamageType.magic;
        this.imgPath = imgPath;
        this.fullHp = 40;
        this.basePow = 40;
        this.baseDef = baseDef;
        this.baseRes = baseRes;
        this.hp = this.fullHp;
        this.pow = this.basePow;
        this.def = this.baseDef;
        this.res = this.baseRes;
    }
}