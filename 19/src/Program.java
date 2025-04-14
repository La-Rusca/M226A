import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        House house = new House();
        house.addRoom(new Room("Salotto",3.3f));
        house.addRoom(new Room("Atrio",-20.4f));
        house.stampa();
    }
}