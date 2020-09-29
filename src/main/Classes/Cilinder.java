package main.Classes;

public class Cilinder extends Figure {

    double height;
    double radius;

    @Override
    public String getType() {
        return "Cilinder";
    }

    public Cilinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    public Cilinder() {
    }

    public void createCilinder() {
        //Create cilinder
        System.out.println("create cilinder");
    }

    @Override
    public String toString() {
        return "Cilinder{" +
                "height=" + height +
                ", radius=" + radius +
                ", content=" + volume +
                '}';
    }
}
