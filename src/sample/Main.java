package sample;

import main.Classes.Block;

import java.util.Scanner;

public class Main {

//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }


    public static void main(String[] args) {
        // launch(args);
        double length;
        double width;
        double height;
        double content;

        System.out.println("Wat is de lengte?");
        Scanner scan = new Scanner(System.in);
        length = Double.valueOf(scan.nextLine());

        System.out.println("Wat is de breete?");
        scan = new Scanner(System.in);
        width = Double.valueOf(scan.nextLine());

        System.out.println("Wat is de hoogte?");
        scan = new Scanner(System.in);
        height = Double.valueOf(scan.nextLine());

        Block block = new Block(length, width, height);
        content = block.calculateContent(length, width, height);

        System.out.println(content);
    }
}
