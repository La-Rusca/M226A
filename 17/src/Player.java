/**
 * Classe Player che rappresenta un player
 *
 * @author Giada Rusconi
 * @version Aprile 2025
 */
import java.util.Objects;

public class Player {
    private String modello;
    private String marca;
    private Playlist playlist;
    private int posizioneAttuale;

    public Player(String modello, String marca, Playlist playlist) {
        this.modello = modello;
        this.marca = marca;
        this.playlist = playlist;
        this.posizioneAttuale = 0;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public String toString() {
        return modello + "\n" + marca + "\n" + playlist;
    }

    /**
     * Stampa a video il titolo e la posizione della traccia
     *
     */
    public void Play() {
        Brano branoCorrente = playlist.getBrano(posizioneAttuale);
        if (branoCorrente != null) {
            System.out.println("Titolo traccia: " + branoCorrente.getTitolo() + ", Posizione: " + (posizioneAttuale + 1));
        } else {
            System.out.println("Brani non disponibile");
        }
    }

    /**
     * Permette di passare al brano successivo
     *
     */
    public void Successivo() {
        if (posizioneAttuale < playlist.getBrani().size() - 1) {
            posizioneAttuale++;
            Play();
        } else {
            System.out.println("Ultimo brano");
        }
    }

    /**
     * Permette di passare al brano precedente
     *
     */

    public void Precedente() {
        if (posizioneAttuale > 0) {
            posizioneAttuale--;
            Play();
        } else {
            System.out.println("Primo brano");
        }
    }

    /**
     * Permette di selezionare un brano passando la sua posizione nell'array
     *
     * return 
     */
    public void SelezionaBrano(int n) {
        if (n >= 1 && n <= playlist.getBrani().size()) {
            posizioneAttuale = n - 1;
            Play();
        } else {
            System.out.println("Indice sbagliato");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return posizioneAttuale == player.posizioneAttuale && Objects.equals(modello, player.modello) && Objects.equals(marca, player.marca) && Objects.equals(playlist, player.playlist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modello, marca, playlist, posizioneAttuale);
    }
}

