package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Classes.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Block block = new Block();
//        Cilinder cilinder = new Cilinder();
//        Sphere sphere = new Sphere();

//        ArrayList<Figure> figures = new ArrayList<Figure>();
//        figures.add(block);
//
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("VAT");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
//
//        ArrayList<Block> blocks = BlockDAO.readAllBlocks();
//
//
//        ComboBox comboBox = new ComboBox();
//        for (Block b : blocks) {
//            comboBox.getItems().add(b.toString());
//        }
//
//        HBox hbox = new HBox(comboBox);
//
//        Scene scene1 = new Scene(hbox, 200, 120);
//        primaryStage.setScene(scene1);
//
////        Label label = new Label("" + block.calculateContent(5, 5, 5));
//        Scene scene = new Scene(label, 400, 200);

//
//        primaryStage.show();
//
//        Figure figure = new Figure();
////        figure.createFigure(comboBox.getCursor().toString());
        // 6. Create the main view and add the high level layout
        // 3.1. Create the menu for the general layout
//        VBox menu = new VBox();
//        menu.setStyle("-fx-background-color: #000000;");
//        menu.setPadding(new Insets(20, 20, 20, 20));
//        menu.setSpacing(10);
//        BorderPane layout = new BorderPane();
//        // 3.2. Create the menu buttons
//        Button testButton = new Button("add new cilinder");
//        Button deleteAllCilinders = new Button("Delete All cilinders");
//
//        // 3.3. Add the buttons to the menu
//        menu.getChildren().addAll(testButton, deleteAllCilinders);
//        layout.setTop(menu);
//
//
//        Scene view = new Scene(layout, 600, 400);
//
//        // 7. Show the application
//        primaryStage.setScene(view);
//        primaryStage.show();
//        testButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override public void handle(ActionEvent e) {
//                try {
//                    insertCilinder();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                } catch (ClassNotFoundException classNotFoundException) {
//                    classNotFoundException.printStackTrace();
//                }
//            }
//        });
//        deleteAllCilinders.setOnAction(new EventHandler<ActionEvent>() {
//            @Override public void handle(ActionEvent e) {
//                try {
//                    CilinderDAO.deleteAllCilinders();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                } catch (ClassNotFoundException classNotFoundException) {
//                    classNotFoundException.printStackTrace();
//                }
//            }
//        });

    }


//    public static void main(String[] args) {
//        launch(args);
//        Block block = new Block();
//        Cilinder cilinder = new Cilinder();
//        Sphere sphere = new Sphere();
//        Figure figure = new Figure();
//
//
//
//        figure.createFigure(sphere);
//    }
    // Hier zet ik een comment om te testen of alles werkt

//    public static void main(String[] args) {
//        launch(args);
//    }

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

        //Block
//        BlockDAO.insertBlock(2, 5.5, 3.5);
////        BlockDAO.deleteAllBlocks();
//        ArrayList<Block> blocks = BlockDAO.readAllBlocks();
//        for (Block b : blocks) {
//            System.out.println(b.toString());
//        }

        //Cilinder


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

