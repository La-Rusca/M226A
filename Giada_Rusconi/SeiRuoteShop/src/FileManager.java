import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/**
 * Classe per gestire il file delle configurazioni dei veicoli
 *
 * @author Giada Rusconi
 * @version Giugno 2026
 */
public class FileManager {
    private String nome_file = "configurazioni_veicoli.txt";
    private String separatore = "***";

    /**
     * Salva la configurazione delle auto nel file manager
     *
     * @param configurazione la configurazione dell'auto
     * @param numero il numero della configurazione
     */
    public void salvaConfigurazioneAuto(ConfigurazioneAuto configurazione, int numero) {
        Path path = Paths.get(nome_file);
        List<String> righe = new ArrayList<>();
        righe.add("CONFIGURAZIONE NUMERO:" + numero);
        righe.add(configurazione.toString());
        righe.add(separatore);

        // StandardOpenOption.APPEND fa in modo che i dati vengano aggiunti in fondo al file
        try {
            Files.write(path, righe, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Errore salvataggio: " + e.getMessage());
        }
    }

    /**
     * Salva la configurazione delle moto nel file manager
     *
     * @param configurazione la configurazione della moto
     * @param numero il numero della configurazione
     */
    public void salvaConfigurazioneMoto(ConfigurazioneMoto configurazione, int numero) {
        Path path = Paths.get(nome_file);
        List<String> righe = new ArrayList<>();
        righe.add("CONFIGURAZIONE_NUMERO:" + numero);
        righe.add(configurazione.toString());
        righe.add(separatore);

        try {
            Files.write(path, righe, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Errore salvataggio: " + e.getMessage());
        }
    }

    public void MostraConfigurazioni() {
        Path path = Paths.get(nome_file);
        if (!Files.exists(path)) {
            System.out.println("File non trovato");
            return;
        }

        try {
            List<String> linee = Files.readAllLines(path);
            for (String linea : linee) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file: " + e.getMessage());
        }
    }

    /**
     * Conta il numero di configurazioni in modo da generare il numero per salvarle
     *
     * @return 0 se errore oppure il numero di configurazioni
     */
    public int contaConfigurazioni() {
        Path path = Paths.get(nome_file);
        if (!Files.exists(path)) return 0;

        try {
            List<String> linee = Files.readAllLines(path);
            int count = 0;
            for (String l : linee) {
                if (l.equals(separatore)) count++;
            }
            return count;
        } catch (IOException e) {
            System.out.println("Errore nel conteggio: " + e.getMessage());
            return 0;
        }
    }
}
