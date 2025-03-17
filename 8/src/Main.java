public class Main {
    public static void main(String[] args) {
        Planet terra = new Planet("Terra", 5.972e24, 1.08321e12, 5.514, 6.371e6, true, 8000000000L, false, 0.3);
        Planet giove = new Planet("Giove", 1.898e27, 1.43128e15, 1.33, 6.9911e7, false, 0, true, 0.5);
        Planet marte = new Planet("Marte", 6.4171e23, 1.6318e11, 3.93, 3.3895e6, false, 0, false, 0.25);

        System.out.println(terra);
        System.out.println("Gravità della Terra: " + terra.Acceleration() + " m/s²");

        System.out.println(giove);
        System.out.println("Gravità di Giove: "+ giove.Acceleration() + " m/s²");

        System.out.println(marte);
        System.out.println("Gravità di Marte: " + marte.Acceleration() + " m/s²");
    }
}