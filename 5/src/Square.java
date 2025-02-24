public class Square {
    public int side;

    public Square() {
        this.side = 5;
    }

    public Square(Integer side) {
        if (side <= 0) {
            this.side = 5;
        }
        else {
            this.side = side;
        }
    }

    public int getArea() {
        return side * side;
    }

    public int getPerimeter() {
        return side * 4;
    }

    public void draw() {
        for (int f = 0; f < side; f++) {
            for (int g = 0; g < side; g++) {
                if (f == 0 || f == side - 1 || g == 0 || g == side - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public String getDimension() {
        return "Quadrato " + side + "x" + side;
    }
}









