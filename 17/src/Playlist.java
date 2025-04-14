/**
 * Classe Playlist che rappresenta una playlist
 *
 * @author Giada Rusconi
 * @version Aprile 2025
 */
import java.util.ArrayList;
import java.util.Objects;

public class Playlist {
    private String titolo;
    private ArrayList<Brano> brani;

    public Playlist(String titolo) {
        this.titolo = titolo;
        this.brani = new ArrayList<>();
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public ArrayList<Brano> getBrani() {
        return brani;
    }

    /**
     * Per sapere l'indice di un brano
     *
     */
    public Brano getBrano(int index) {
        if (index >= 0 && index < brani.size()) {
            return brani.get(index);
        } else {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(titolo, playlist.titolo) && Objects.equals(brani, playlist.brani);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo, brani);
    }
}

