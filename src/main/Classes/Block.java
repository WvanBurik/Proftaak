package main.Classes;

public class Block extends Figure {

    double length;
    double width;
    double height;

    public Block(double length, double width, double height) {
        this.length     = length;
        this.width      = width;
        this.height     = height;
    }

//    @Override
//    public double calculateContent(double ... value) {
////        content = value[0];
////
////        for(int i = 1; i < value.length; i++) {
////            this.content = content * value[i];
////        }
//
//   //    this.content = length * width * height;
//
//        return content;
//    }

    @Override
    public String toString() {
        return "content=" + content;
    }
}
