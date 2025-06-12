import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe per la configurazione di una moto
 *
 * @author Giada Rusconi
 * @version Giugno 2026
 */
public class ConfigurazioneMoto {
    private Moto moto;
    private Colore colore;
    private Motore motore;
    private List<Accessorio> accessori;

    public ConfigurazioneMoto(Moto moto, Colore colore, Motore motore, List<Accessorio> accessori) {
        this.moto = moto;
        this.colore = colore;
        this.motore = motore;
        if (accessori != null) {
            this.accessori = new ArrayList<>(accessori);
        } else {
            this.accessori = new ArrayList<>();
        }

    }

    /**
     * Calcola il prezzo finale della configurazione
     *
     * @return il prezzo totale con componenti inclusi
     */
    public double calcolaPrezzoTotale() {
        double prezzoTotale = 0;

        if (moto != null) {
            prezzoTotale += moto.getPrezzoBase();
        }

        if (colore != null) {
            prezzoTotale += colore.getCosto();
        }

        if (motore != null) {
            prezzoTotale += motore.getCosto();
        }

        for (Accessorio accessorio : accessori) {
            prezzoTotale += accessorio.getCosto();
        }

        return prezzoTotale;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("*** CONFIGURAZIONE MOTO ***\n");

        if (moto != null) {
            sb.append(String.format("Moto: %s %s - €%.2f\n", moto.getMarca(), moto.getModello(), moto.getPrezzoBase()));
        }

        if (colore != null) {
            String glitterText = null;
            if (colore.isGlitter()) {
                glitterText = " (con glitter)";
            }
            else {
                glitterText = "";
            }
            sb.append(String.format("Colore: %s%s - €%.2f\n", colore.getColore(), glitterText, colore.getCosto()));
        }

        if (motore != null) {
            sb.append(String.format("Motore: %s (%s) - %d CV, %d Nm - €%.2f\n", motore.getNome(), motore.getTipo(), motore.getPotenza(), motore.getCoppia(), motore.getCosto()));
        }

        sb.append("Accessori:\n");
        if (accessori.isEmpty()) {
            sb.append("  Nessun accessorio selezionato\n");
        } else {
            for (Accessorio accessorio : accessori) {
                sb.append(String.format("  - %s: €%.2f\n",
                        accessorio.getNome(), accessorio.getCosto()));
            }
        }

        sb.append(String.format("\nPREZZO TOTALE: €%.2f", calcolaPrezzoTotale()));

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigurazioneMoto that = (ConfigurazioneMoto) o;
        return Objects.equals(moto, that.moto) && Objects.equals(colore, that.colore) && Objects.equals(motore, that.motore) && Objects.equals(accessori, that.accessori);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moto, colore, motore, accessori);
    }
}
