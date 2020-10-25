package main.classes;

import main.dao.BlockDAO;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Block extends Figure {

    private static final long serialVersionUID = 1L;
    private double length;
    private double width;
    private double height;

    public Block(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Block(String id, double length, double width, double height) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Block() {
    }

    public static void deleteFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        BlockDAO blockDAO = new BlockDAO();
        blockDAO.deleteFigure(selectedIdx);
    }

    public static void createBlock(double length, double width, double height) throws SQLException, ClassNotFoundException {
        BlockDAO blockDAO = new BlockDAO();
        blockDAO.insertFigure(length, width, height);
    }

    public static ArrayList readAllFigures() throws SQLException, ClassNotFoundException {
        BlockDAO blockDAO = new BlockDAO();
        return blockDAO.readAllFigures();
    }

    public static Block readFigure(String selectedIdx) throws SQLException, ClassNotFoundException {
        BlockDAO blockDAO = new BlockDAO();
        return blockDAO.readFigure(selectedIdx);
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


    @Override
    public String toString() {
        return "Block{" +
                "{id=" + id +
                "}length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public static void writeFigureToFile(Block block) {
        try {
            FileOutputStream f = new FileOutputStream(new File("D:\\Block.ser"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(block);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
        Block.writeFigureToTxt(block);
    }

    private static void writeFigureToTxt(Block block) {
        try {
            FileOutputStream f = new FileOutputStream(new File("D:\\Block.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(block);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
}
