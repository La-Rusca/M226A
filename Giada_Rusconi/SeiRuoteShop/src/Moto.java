import java.util.Objects;

/**
 * Classe per i modelli di moto
 *
 * @author Giada Rusconi
 * @version Giugno 2026
 */
public class Moto {
    private double prezzoBase;
    private String marca;
    private String modello;
    private int idUsati;
    private boolean random;

    public Moto(double prezzoBase, String marca, String modello, int idUsati, boolean random) {
        this.prezzoBase = prezzoBase;
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
        if (o == null || getClass() != o.getClass()) return false;
        Moto moto = (Moto) o;
        return Double.compare(prezzoBase, moto.prezzoBase) == 0 && idUsati == moto.idUsati && random == moto.random && Objects.equals(marca, moto.marca) && Objects.equals(modello, moto.modello);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prezzoBase, marca, modello, idUsati, random);
    }
}
