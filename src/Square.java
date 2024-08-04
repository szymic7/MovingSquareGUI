public class Square {
    private int x, y, a;

    public Square() {
        this.a = 40;    // default value
        this.x = 400 - a / 2;   // in the middle of the field when created
        this.y = 300 - a / 2;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
