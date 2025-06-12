import java.util.Objects;

/**
 * Classe per i colori di auto e moto
 *
 * @author Giada Rusconi
 * @version Giugno 2026
 */
public class Colore {
    private String colore;
    private double costo;
    private boolean glitter;

    public Colore(String colore, double costo, boolean glitter) {
        this.colore = colore;
        this.costo = costo;
        this.glitter = glitter;
    }

    public String getColore() {
        return colore;
    }

    public double getCosto() {
        return costo;
    }

    public boolean isGlitter() {
        return glitter;
    }

    @Override
    public String toString() {
        String glit = "";
        if (glitter) {
            glit = "Si";
        }
        else {
            glit = "No";
        }
        return "Colore: " + colore + ", Costo: " + costo + ", Glitter: " + glit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colore colore1 = (Colore) o;
        return Double.compare(costo, colore1.costo) == 0 && glitter == colore1.glitter && Objects.equals(colore, colore1.colore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colore, costo, glitter);
    }
}
