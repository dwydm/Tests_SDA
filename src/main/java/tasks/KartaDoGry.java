package tasks;

public class KartaDoGry implements Comparable<KartaDoGry>{
    private Figura figura;
    private Kolor kolor;

    public KartaDoGry(Figura figura, Kolor kolor) {
        this.figura = figura;
        this.kolor = kolor;
    }

    @Override
    public int compareTo(KartaDoGry o) {
        if (this.figura.equals(o.figura)) {
            return this.kolor.getValue()- o.kolor.getValue();
        }
        return this.figura.compareTo(o.figura);
    }

    @Override
    public String toString() {
        return "KartaDoGry{"
                + "figura=" + figura
                + ", kolor=" + kolor +
                '}';
    }
}
