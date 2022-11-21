package tasks;

public enum Kolor {
    KIER(4), KARO(3), TREFL(2), PIK(1);

    private int value;

    Kolor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
