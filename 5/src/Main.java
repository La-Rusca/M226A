public class Main {
    public static void main(String[] args) {
        Square square1 = new Square();
        Square square2 = new Square(3);
        Square square3 = new Square(-2); // faccio una prova dell'errore

        System.out.println(square1.getDimension());
        System.out.println("Area: " + square1.getArea());
        System.out.println("Perimetro: " + square1.getPerimeter());
        square1.draw();

        System.out.println("\n" + square2.getDimension());
        System.out.println("Area: " + square2.getArea());
        System.out.println("Perimetro: " + square2.getPerimeter());
        square2.draw();

        System.out.println("\n" + square3.getDimension());
        System.out.println("Area: " + square3.getArea());
        System.out.println("Perimetro: " + square3.getPerimeter());
        square3.draw();
    }
}



