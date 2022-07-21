package se233.chapter1.model.character;

import se233.chapter1.model.item.Armor;
import se233.chapter1.model.item.Weapon;

public class BasedCharacter {
    protected String name, imgPath;
    protected DamageType type;
    protected int fullHp, basePow, baseDef, baseRes;
    protected int hp, pow, def, res;
    protected Weapon weapon;
    protected Armor armor;

    public String getName() { return name; }
    public String getImgPath() { return imgPath; }
    public int getHp() { return hp; }
    public int getFullHp() { return fullHp; }
    public DamageType getType() { return type; }
    public int getBaseDef() { return baseDef; }
    public int getBaseRes() {return baseRes; }
    public int getPow() { return pow; }
    public int getDef() { return def; }
    public int getRes() { return res; }
    public Weapon getWeapon() { return weapon; }
    public Armor getArmor() { return armor; }
    public int getBasePow() { return basePow; }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.pow = this.basePow + weapon.getPow();
    }

    public void equipArmor(Armor armor) {
        this.armor = armor;
        this.def = this.baseDef + armor.getDef();
        this.res = this.baseRes + armor.getRes();
    }

    public void resetPow() {
        this.pow = this.basePow;
    }

    public void resetDefRes() {
        this.def = this.baseDef;
        this.res = this.baseRes;
    }
}