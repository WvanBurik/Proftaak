package Classes;

public class Figure {
    double content;

    public double calculateContent(double ... value) {
        content = value[0];

        for(int i = 1; i < value.length; i++) {
            this.content = content * value[i];
        }
        //Calculate content based in input

        return content;
    }
}
