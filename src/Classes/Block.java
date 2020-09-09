package Classes;

public class Block extends Figure {

    double length;
    double width;
    double height;

    public Block(double length, double width, double height) {
        this.length     = length;
        this.width      = width;
        this.height     = height;
        this.content    = length * width * height;
    }

    @Override
    public String toString() {
        return "content=" + content;
    }
}
