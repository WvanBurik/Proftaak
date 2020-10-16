package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Classes.*;
import java.sql.*;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("VAT");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();

    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        launch(args);

        Figure figure = new Figure();
        Block block = new Block();
        Sphere sphere = new Sphere();
        Cilinder cilinder = new Cilinder();
        Pyramid pyramid = new Pyramid();
        Hemisphere hemisphere = new Hemisphere();

        double figureVolume, blockVolume, sphereVolume, cilinderVolume, pyramidVolume, hemisphereVolume;

        hemisphereVolume = hemisphere.calculateVolume(8);
        System.out.println("volume of " + hemisphere.getType() + " is : " + hemisphereVolume);

        sphereVolume = sphere.calculateVolume(48);
        System.out.println("volume of " + sphere.getType() + " is : " + sphereVolume);

        pyramidVolume = pyramid.calculateVolume(9, 10);
        System.out.println("volume of " + pyramid.getType() + " is : " + pyramidVolume);

        cilinderVolume = cilinder.calculateVolume(38, 35);
        System.out.println("volume of " + cilinder.getType() + " is : " + cilinderVolume);

        blockVolume = block.calculateVolume(5.5, 5.5, 5.5);
        System.out.println("volume of " + block.getType() + " is : " + blockVolume);


        ArrayList<Figure> figures = FigureDAO.readAllFigures();
        for (Figure f : figures) {
            System.out.println(f.toString());
        }

//        System.out.println(FigureDAO.readAllFiguresForTotalVolume());

//        System.out.println(figure.calculateTotalContent());
    }



//    public static void main(String[] args) {
//        Figure figure = new Figure();
//        Block block = new Block(5, 5, 5);
//        Cilinder cilinder = new Cilinder();
//        Sphere sphere = new Sphere(4);
//
//        System.out.println(block.calculateVolume(block.getHeight(), block.getLength(), block.getWidth()));
//        System.out.println(sphere.calculateVolume(sphere.getRadius()));
//        System.out.println(block.getType());
//
//    }

//

}

