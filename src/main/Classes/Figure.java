package main.Classes;

public class Figure {
    double content;

    //Calculate method for each child class.
    public double calculateContent(double ... value) {
        content = value[0];

        for(int i = 1; i < value.length; i++) {
            this.content = content * value[i];
        }

        return content;
    }
}
