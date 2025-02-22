/**
 *Esercizio 4.9
 *Confronta stringhe passate da argomento, le memorizza in un array e le stampa
 *
 * @author Giada Rusconi
 * @version 17.02.2025
 */

public class Main {
    public static void main(String[] args) {
        String[] array = new String[args.length];
        System.out.print("Stampa di args: ");
        for (int f = 0; f < args.length; f++) {
            String parola = args[f];
            array[f] = args[f];
            System.out.print(parola + " ");
        }

        for (int g = 0; g < array.length - 1; g++) {
            for (int x = 0; x < array.length - 1 - g; x++) {
                if (array[x].length() > array[x + 1].length()) {
                    String scambio = array[x];
                    array[x] = array[x + 1];
                    array[x + 1] = scambio;
                }
            }
        }

        System.out.println("");

        for (String x : array) {
            System.out.println(x);
        }
    }
}