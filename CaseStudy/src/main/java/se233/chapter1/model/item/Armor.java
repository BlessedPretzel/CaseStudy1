package se233.chapter1.model.item;

public class Armor extends BasedEquipment{
    private int def, res;
    public Armor(String name, int def, int res, String imgPath) {
        this.name = name;
        this.def = def;
        this.res = res;
        this.imgPath = imgPath;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;}

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
