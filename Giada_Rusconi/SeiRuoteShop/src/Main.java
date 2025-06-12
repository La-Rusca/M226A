import jdk.jshell.SourceCodeAnalysis;
import javax.swing.plaf.ScrollPaneUI;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        System.out.println("*************************************************");
        System.out.println("           BENVENUTO IN SEIRUOTESHOP             ");
        System.out.println("*************************************************");

        boolean continua = true;

        while (continua) {
            System.out.println("\n*** MENU PRINCIPALE ***");
            System.out.println("1. Configura Auto");
            System.out.println("2. Configura Moto");
            System.out.println("3. Carica Configurazioni Salvate");
            System.out.println("4. Esci");

            System.out.print("Inserisci un'opzione: ");
            int scelta = Integer.parseInt(scanner.nextLine());

            if (scelta == 1) {
                configuraAuto();
            }
            else if (scelta == 2) {
                configuraMoto();
            }
            else if (scelta == 3) {
                System.out.println("");
                fileManager.MostraConfigurazioni();
            }
            else if (scelta == 4) {
                System.out.println("Chiusura configuratore...");
                System.out.println("Arrivederci!");
                continua = false;
            }
        }
        scanner.close();
    }

    public static void configuraAuto() {
        System.out.println("\n*** CONFIGURAZIONE AUTO ***");

        Auto auto = selezionaAuto(getAuto());
        Colore colore = selezionaColore(getColori());
        Motore motore = selezionaMotore(getMotori());
        List<Accessorio> accessori = selezionaAccessori();

        ConfigurazioneAuto config = new ConfigurazioneAuto(auto, colore, motore, accessori);
        System.out.println("\n" + config);
        int numero = fileManager.contaConfigurazioni() + 1;
        fileManager.salvaConfigurazioneAuto(config, numero);
    }

    public static void configuraMoto() {
        System.out.println("\n*** CONFIGURAZIONE MOTO ***");

        Moto moto = selezionaMoto(getMoto());
        Colore colore = selezionaColore(getColori());
        Motore motore = selezionaMotore(getMotori());
        List<Accessorio> accessori = selezionaAccessori();

        ConfigurazioneMoto config = new ConfigurazioneMoto(moto, colore, motore, accessori);
        System.out.println("\n" + config);
        int numero = fileManager.contaConfigurazioni() + 1;
        fileManager.salvaConfigurazioneMoto(config, numero);
    }

    public static Auto selezionaAuto(List<Auto> autoList) {
        System.out.println("\nScegli un'auto:");
        for (int i = 0; i < autoList.size(); i++) {
            int num = i+1;
            System.out.print(num + autoList.get(i).toString());
        }

        System.out.print("Inserisci scelta (0 per tornare indietro): ");
        int scelta = leggiSceltaUtente(0, autoList.size());

        if (scelta == 0) return null;
        return autoList.get(scelta - 1);
    }

    public static Moto selezionaMoto(List<Moto> motoList) {
        System.out.println("\nScegli una moto:");
        for (int i = 0; i < motoList.size(); i++) {
            int num = i + 1;
            System.out.print(num + motoList.get(i).toString());
        }

        System.out.print("Inserisci scelta (0 per tornare indietro): ");
        int scelta = leggiSceltaUtente(0, motoList.size());

        if (scelta == 0) return null;
        return motoList.get(scelta - 1);
    }

    public static Colore selezionaColore(List<Colore> coloriList) {
        System.out.println("\nScegli un colore:");
        for (int i = 0; i < coloriList.size(); i++) {
            int num = i + 1;
            System.out.print(num + coloriList.get(i).toString());
        }
        System.out.print("Scelta (0 per tornare indietro): ");
        int scelta = leggiSceltaUtente(0, coloriList.size());

        if (scelta == 0) return null;
        return coloriList.get(scelta - 1);
    }

    public static  Motore selezionaMotore(List<Motore> motoriList) {
        System.out.println("\nScegli un motore:");
        for (int i = 0; i < motoriList.size(); i++) {
            int num = i + 1;
            System.out.print(num + motoriList.get(i).toString());
        }
        System.out.print("Scelta (0 per tornare indietro): ");
        int scelta = leggiSceltaUtente(0, motoriList.size());

        if (scelta == 0) return null;
        return motoriList.get(scelta - 1);
    }

    public static List<Accessorio> selezionaAccessori() {
        List<Accessorio> disponibili = getAccessori();
        List<Accessorio> selezionati = new ArrayList<>();

        System.out.println("\n*** Accessori Disponibili ***");
        for (int i = 0; i < disponibili.size(); i++) {
            int num = i + 1;
            System.out.print(num + disponibili.get(i).toString());
        }

        System.out.print("Inserisci i numeri degli accessori separati da virgola (0 per nessuno): ");
        String input = scanner.nextLine().trim();

        if (input.equals("0") || input.isEmpty()) return selezionati;

        String[] scelte = input.split(",");
        for (String scelta : scelte) {
            int num = Integer.parseInt(scelta.trim()) - 1;
            if (num >= 0 && num < disponibili.size()) {
                    selezionati.add(disponibili.get(num));
            }
            else {
                System.out.println("");
            }
        }
        return selezionati;
    }


    public static int leggiSceltaUtente(int min, int max) {
        int scelta = -1;
        while (true) {
            try {
                scelta = Integer.parseInt(scanner.nextLine().trim());
                if (scelta >= min && scelta <= max) return scelta;
            } catch (NumberFormatException ie) {}
            System.out.print("Inserisci un numero valido tra : " + min + " e " + max);
        }
    }

    // Varie liste con dati generati da intelligenza artificiale

    public static List<Auto> getAuto() {
        List<Auto> auto = new ArrayList<>();
        auto.add(new Auto(25000.0, 1, "Fiat", "500", 1001, false));
        auto.add(new Auto(27000.0, 2, "Volkswagen", "Golf", 1002, true));
        auto.add(new Auto(32000.0, 3, "BMW", "Serie 1", 1003, false));
        auto.add(new Auto(45000.0, 4, "Audi", "A3", 1004, false));
        auto.add(new Auto(29000.0, 5, "Mercedes", "Classe A", 1005, true));
        auto.add(new Auto(23000.0, 6, "Renault", "Clio", 1006, false));
        auto.add(new Auto(28000.0, 7, "Peugeot", "208", 1007, false));
        auto.add(new Auto(21000.0, 8, "Ford", "Focus", 1008, false));
        auto.add(new Auto(26000.0, 9, "Opel", "Corsa", 1009, true));
        auto.add(new Auto(33000.0, 10, "Toyota", "Corolla", 1010, false));
        auto.add(new Auto(37000.0, 11, "Mazda", "3", 1011, true));
        auto.add(new Auto(41000.0, 12, "Kia", "Ceed", 1012, false));
        auto.add(new Auto(22000.0, 13, "Hyundai", "i20", 1013, true));
        auto.add(new Auto(34000.0, 14, "Honda", "Civic", 1014, false));
        auto.add(new Auto(39000.0, 15, "Alfa Romeo", "Giulietta", 1015, true));
        auto.add(new Auto(31000.0, 16, "Skoda", "Octavia", 1016, false));
        auto.add(new Auto(27000.0, 17, "Seat", "Leon", 1017, false));
        auto.add(new Auto(24000.0, 18, "Citroen", "C3", 1018, false));
        auto.add(new Auto(43000.0, 19, "Tesla", "Model 3", 1019, true));
        auto.add(new Auto(38000.0, 20, "Nissan", "Leaf", 1020, true));
        return auto;
    }

    public static List<Moto> getMoto() {
        List<Moto> moto = new ArrayList<>();
        moto.add(new Moto(8000.0, "Yamaha", "MT-07", 2001, false));
        moto.add(new Moto(9500.0, "Kawasaki", "Z650", 2002, true));
        moto.add(new Moto(11000.0, "Honda", "CB650R", 2003, false));
        moto.add(new Moto(12000.0, "Suzuki", "GSX-8S", 2004, false));
        moto.add(new Moto(13000.0, "Ducati", "Monster", 2005, true));
        moto.add(new Moto(12500.0, "Triumph", "Trident", 2006, false));
        moto.add(new Moto(9000.0, "BMW", "G 310 R", 2007, false));
        moto.add(new Moto(10000.0, "KTM", "Duke 390", 2008, true));
        moto.add(new Moto(8700.0, "Benelli", "Leoncino", 2009, false));
        moto.add(new Moto(7500.0, "CFMOTO", "NK 650", 2010, false));
        moto.add(new Moto(10500.0, "Aprilia", "Tuono 660", 2011, true));
        moto.add(new Moto(9800.0, "Moto Guzzi", "V7", 2012, false));
        moto.add(new Moto(10200.0, "Harley-Davidson", "Street 750", 2013, true));
        moto.add(new Moto(12000.0, "Indian", "Scout", 2014, true));
        moto.add(new Moto(9500.0, "Royal Enfield", "Interceptor 650", 2015, false));
        moto.add(new Moto(8400.0, "Mash", "X-Ride 650", 2016, false));
        moto.add(new Moto(8700.0, "SWM", "Gran Milano", 2017, false));
        moto.add(new Moto(8900.0, "Voge", "500R", 2018, true));
        moto.add(new Moto(10300.0, "Zontes", "T310", 2019, false));
        moto.add(new Moto(7600.0, "Fantic", "Caballero", 2020, false));
        return moto;
    }

    public static List<Colore> getColori() {
        List<Colore> colori = new ArrayList<>();
        colori.add(new Colore("Bianco", 0.0, false));
        colori.add(new Colore("Bianco", 200.0, true));
        colori.add(new Colore("Nero", 0.0, false));
        colori.add(new Colore("Nero", 200.0, true));
        colori.add(new Colore("Grigio", 0.0, false));
        colori.add(new Colore("Grigio", 200.0, true));
        colori.add(new Colore("Argento", 100.0, false));
        colori.add(new Colore("Argento", 300.0, true));
        colori.add(new Colore("Blu", 150.0, false));
        colori.add(new Colore("Blu", 350.0, true));
        colori.add(new Colore("Rosso", 150.0, false));
        colori.add(new Colore("Rosso", 350.0, true));
        colori.add(new Colore("Verde", 120.0, false));
        colori.add(new Colore("Verde", 320.0, true));
        colori.add(new Colore("Giallo", 180.0, false));
        colori.add(new Colore("Giallo", 380.0, true));
        colori.add(new Colore("Arancione", 200.0, false));
        colori.add(new Colore("Arancione", 400.0, true));
        colori.add(new Colore("Viola", 220.0, false));
        colori.add(new Colore("Viola", 420.0, true));
        colori.add(new Colore("Azzurro", 160.0, false));
        colori.add(new Colore("Azzurro", 360.0, true));
        colori.add(new Colore("Marrone", 150.0, false));
        colori.add(new Colore("Marrone", 350.0, true));
        colori.add(new Colore("Rosa", 170.0, false));
        colori.add(new Colore("Rosa", 370.0, true));
        return colori;
    }

    public static List<Motore> getMotori() {
        List<Motore> motori = new ArrayList<>();
        motori.add(new Motore("1.0 EcoBoost", "Benzina", 2000.0, 125, 170));
        motori.add(new Motore("1.5 TSI", "Benzina", 2500.0, 150, 200));
        motori.add(new Motore("2.0 TDI", "Diesel", 3000.0, 190, 400));
        motori.add(new Motore("1.6 MultiJet", "Diesel", 2200.0, 120, 280));
        motori.add(new Motore("1.2 PureTech", "Benzina", 2100.0, 130, 190));
        motori.add(new Motore("Electric Drive", "Elettrico", 4000.0, 136, 300));
        motori.add(new Motore("2.5 Skyactiv-G", "Benzina", 3200.0, 194, 258));
        motori.add(new Motore("3.0 V6", "Benzina", 5000.0, 340, 450));
        motori.add(new Motore("Hybrid 2.0", "Ibrido", 3500.0, 180, 320));
        motori.add(new Motore("Electric Sport", "Elettrico", 6000.0, 204, 450));
        return motori;
    }

    public static List<Accessorio> getAccessori() {
        List<Accessorio> accessori = new ArrayList<>();
        accessori.add(new Accessorio("Navigatore GPS", 800.0));
        accessori.add(new Accessorio("Sedili riscaldati", 400.0));
        accessori.add(new Accessorio("Sensori di parcheggio", 300.0));
        accessori.add(new Accessorio("Telecamera posteriore", 500.0));
        accessori.add(new Accessorio("Sistema audio premium", 1000.0));
        accessori.add(new Accessorio("Tetto panoramico", 1200.0));
        accessori.add(new Accessorio("Cruise control adattivo", 700.0));
        accessori.add(new Accessorio("Climatizzatore automatico", 600.0));
        accessori.add(new Accessorio("Caricatore wireless", 200.0));
        accessori.add(new Accessorio("Keyless entry", 350.0));
        accessori.add(new Accessorio("Fari full LED", 650.0));
        accessori.add(new Accessorio("Cerchi in lega", 900.0));
        accessori.add(new Accessorio("Vetri oscurati", 450.0));
        accessori.add(new Accessorio("Sistema di frenata d'emergenza", 750.0));
        accessori.add(new Accessorio("Display touch 10\"", 850.0));
        accessori.add(new Accessorio("Sistema di mantenimento corsia", 600.0));
        accessori.add(new Accessorio("Interni in pelle", 1300.0));
        accessori.add(new Accessorio("Specchietti elettrici", 300.0));
        accessori.add(new Accessorio("Sistema di assistenza al parcheggio", 550.0));
        accessori.add(new Accessorio("Head-Up Display", 950.0));
        return accessori;
    }
}
