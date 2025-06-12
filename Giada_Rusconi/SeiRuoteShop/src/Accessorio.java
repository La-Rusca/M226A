import java.util.Objects;

/**
 * Classe per gli accessori di auto e moto
 *
 * @author Giada Rusconi
 * @version Giugno 2026
 */
public class Accessorio {
    private String nome;
    private double costo;

    public Accessorio(String nome, double costo) {
        this.nome = nome;
        this.costo = costo;
    }

    public String getNome() {
        return nome;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Costo: " + costo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accessorio that = (Accessorio) o;
        return Double.compare(costo, that.costo) == 0 && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, costo);
    }
}

