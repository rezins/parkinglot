package positionlot.model;

public class Lot {

    int index , slot;

    String register_number;

    String color;

    public Lot(int index, int slot, String register_number, String color) {
        this.index = index;
        this.slot = slot;
        this.register_number = register_number;
        this.color = color;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getRegister_number() {
        return register_number;
    }

    public void setRegister_number(String register_number) {
        this.register_number = register_number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
