package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
//import javafx.scene.control.Label;
import main.Classes.Block;
import main.Classes.Cilinder;
import main.Classes.Circle;
import main.Classes.Figure;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Block block = new Block();
        Cilinder cilinder = new Cilinder();
        Circle circle = new Circle();

//        ArrayList<Figure> figures = new ArrayList<Figure>();
//        figures.add(block);

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        ComboBox comboBox = new ComboBox();
        comboBox.getItems().add(block);
        comboBox.getItems().add(cilinder);
        comboBox.getItems().add(circle);

        HBox hbox = new HBox(comboBox);

        Scene scene1 = new Scene(hbox, 200, 120);
        primaryStage.setScene(scene1);

//        Label label = new Label("" + block.calculateContent(5, 5, 5));
//        Scene scene = new Scene(label, 400, 200);
//        primaryStage.setScene(scene);

        primaryStage.show();

        Figure figure = new Figure();
//        figure.createFigure(comboBox.getCursor().toString());
    }


    public static void main(String[] args) {
        launch(args);
        Block block = new Block();
        Cilinder cilinder = new Cilinder();
        Circle circle = new Circle();
        Figure figure = new Figure();

        figure.createFigure(circle);
    }
//
//public String calculateContentTEST() {
//    double length;
//    double width;
//    double height;
//    double content;
//
//    System.out.println("Wat is de lengte?");
//    Scanner scan = new Scanner(System.in);
//    length = Double.valueOf(scan.nextLine());
//
//    System.out.println("Wat is de breete?");
//    scan = new Scanner(System.in);
//    width = Double.valueOf(scan.nextLine());
//
//    System.out.println("Wat is de hoogte?");
//    scan = new Scanner(System.in);
//    height = Double.valueOf(scan.nextLine());
//
//    Block block = new Block(length, width, height);
//    content = block.calculateContent(length, width, height);
//
//    System.out.println(content);
//    return "" + content;
//}
}

