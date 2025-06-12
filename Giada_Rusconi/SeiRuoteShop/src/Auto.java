import java.util.Objects;

/**
 * Classe per i modelli di auto
 *
 * @author Giada Rusconi
 * @version Giugno 2026
 */
public class Auto {
    private double prezzoBase;
    private int id;
    private String marca;
    private String modello;
    private int idUsati;
    private boolean random;

    public Auto(double prezzoBase, int id, String marca, String modello, int idUsati, boolean random) {
        this.prezzoBase = prezzoBase;
        this.id = id;
        this.marca = marca;
        this.modello = modello;
        this.idUsati = idUsati;
        this.random = random;
    }

    public double getPrezzoBase() {
        return prezzoBase;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modello: " + modello + ", Prezzo base: " + prezzoBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Double.compare(prezzoBase, auto.prezzoBase) == 0 && id == auto.id && idUsati == auto.idUsati && random == auto.random && Objects.equals(marca, auto.marca) && Objects.equals(modello, auto.modello);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prezzoBase, id, marca, modello, idUsati, random);
    }
}
