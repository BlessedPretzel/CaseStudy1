package se233.chapter1.model.character;

public class PhysicalCharacter extends BasedCharacter {
    public PhysicalCharacter(String name, String imgPath, int baseDef, int baseRes) {
        this.name = name;
        this.type = DamageType.phy;
        this.imgPath = imgPath;
        this.fullHp = 100;
        this.basePow = 30;
        this.baseDef = baseDef;
        this.baseRes = baseRes;
        this.hp = this.fullHp;
        this.pow = this.basePow;
        this.def = this.baseDef;
        this.res = this.baseRes;
    }
}
