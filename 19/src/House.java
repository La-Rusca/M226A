import java.util.ArrayList;

public class House {
    private ArrayList<Room> rooms;

    public House() {
        rooms = new ArrayList<>();
    }
    public void addRoom(Room room) {
        rooms.add(room);
    }
    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void stampa() {
        for (Room room : rooms) {
            System.out.println(room);
        }
    }
    @Override
    public String toString() {
        return "House= " + "rooms: " + rooms;
    }
}
