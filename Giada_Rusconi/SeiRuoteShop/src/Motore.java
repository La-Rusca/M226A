import java.util.Objects;

/**
 * Classe per i motori delle auto e moto
 *
 * @author Giada Rusconi
 * @version Giugno 2026
 */
public class Motore {
    private String nome;
    private String tipo;
    private double costo;
    private int potenza;
    private int coppia;

    public Motore(String nome, String tipo, double costo, int potenza, int coppia) {
        this.nome = nome;
        this.tipo = tipo;
        this.costo = costo;
        this.potenza = potenza;
        this.coppia = coppia;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCosto() {
        return costo;
    }

    public int getPotenza() {
        return potenza;
    }

    public int getCoppia() {
        return coppia;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Tipo: " + tipo + ", Costo: " + costo + ", Potenza: " + potenza + ", Coppia: " + coppia;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Motore motore = (Motore) o;
        return Double.compare(costo, motore.costo) == 0 && potenza == motore.potenza && coppia == motore.coppia && Objects.equals(nome, motore.nome) && Objects.equals(tipo, motore.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tipo, costo, potenza, coppia);
    }
}
