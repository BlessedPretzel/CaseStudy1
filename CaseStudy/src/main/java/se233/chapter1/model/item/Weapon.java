package se233.chapter1.model.item;

import se233.chapter1.model.character.DamageType;

public class Weapon extends BasedEquipment {
    private int pow;
    private DamageType type;

    public Weapon(String name, int pow, DamageType type, String imgPath) {
        this.name = name;
        this.pow = pow;
        this.type = type;
        this.imgPath = imgPath;
    }

    public int getPow() {
        return pow;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }

    public DamageType getType() {
        return type;
    }

    public void setType(DamageType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }
}