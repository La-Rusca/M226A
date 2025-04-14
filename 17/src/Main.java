public class Main {
    public static void main(String[] args) {

        Brano brano1 = new Brano("Shape of You", "Ed Sheeran");
        Brano brano2 = new Brano("Blinding Lights", "The Weeknd");
        Brano brano3 = new Brano("Levitating", "Dua Lipa");

        Playlist playlist = new Playlist("Mia Playlist");
        playlist.getBrani().add(brano1);
        playlist.getBrani().add(brano2);
        playlist.getBrani().add(brano3);

        Player player = new Player("X1000", "Sony", playlist);

        player.Play();
        player.Successivo();
        player.SelezionaBrano(3);
        player.Precedente();
    }
}
