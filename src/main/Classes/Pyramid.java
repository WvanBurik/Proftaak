package main.Classes;

public class Pyramid extends Figure {

    private double height;
    private double baseLength;

    public Pyramid(double height, double baseLength) {
        this.height = height;
        this.baseLength = baseLength;
    }

    public Pyramid() {
    }

    @Override
    public String getType() {
        return "Pyramid";
    }

    public double getHeight() {
        return height;
    }

    public double getBaseLength() {
        return baseLength;
    }

    @Override
    public double calculateVolume(double... value) {
        double baseH = value[0];
        double baseL = value[1];

        double volumeOfPyramid = super.calculateVolume(baseH, (baseL * baseL));

        return volumeOfPyramid / 3;
    }
}
