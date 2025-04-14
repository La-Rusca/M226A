/**
 * Classe Brano che rappresenta un brano
 *
 * @author Giada Rusconi
 * @version Aprile 2025
 */
import java.util.Objects;

public class Brano {
    private String titolo;
    private String autore;

    public Brano(String titolo, String autore) {
        this.titolo = titolo;
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String toString() {
        return "Titolo: " + titolo + ", Autore: " + autore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brano brano = (Brano) o;
        return Objects.equals(titolo, brano.titolo) && Objects.equals(autore, brano.autore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo, autore);
    }
}


