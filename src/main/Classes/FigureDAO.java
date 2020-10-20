package main.Classes;

import main.DAB.DBUtil;

import javax.xml.transform.Result;
import java.io.*;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FigureDAO {

    public static ArrayList readAllFigures() throws SQLException, ClassNotFoundException {
        ArrayList<Figure> figures = new ArrayList<>();
        ArrayList<Block> blocks = BlockDAO.readAllBlocks();
        ArrayList<Cilinder> cilinders = CilinderDAO.readAllCilinders();
        ArrayList<Hemisphere> hemispheres = HemisphereDAO.readAllHemispheres();
        ArrayList<Pyramid> pyramids = PyramidDAO.readAllPyramids();
        ArrayList<Sphere> spheres = SphereDAO.readAllSpheres();

        figures.addAll(blocks);
        figures.addAll(cilinders);
        figures.addAll(hemispheres);
        figures.addAll(pyramids);
        figures.addAll(spheres);

        return figures;
    }

    public static double readAllFiguresForTotalVolume() throws SQLException, ClassNotFoundException {
        double totalVolume = 0;

        ArrayList<Block> blocks = BlockDAO.readAllBlocks();
        ArrayList<Cilinder> cilinders = CilinderDAO.readAllCilinders();
        ArrayList<Hemisphere> hemispheres = HemisphereDAO.readAllHemispheres();
        ArrayList<Pyramid> pyramids = PyramidDAO.readAllPyramids();
        ArrayList<Sphere> spheres = SphereDAO.readAllSpheres();

        for (Block b : blocks) {
            totalVolume += b.calculateVolume(b.getLength(), b.getWidth(), b.getHeight());
        }
        for (Cilinder c : cilinders) {
            totalVolume += c.calculateVolume(c.getHeight(), c.getRadius());
        }
        for (Hemisphere h : hemispheres) {
            totalVolume += h.calculateVolume(h.getRadius());
        }
        for (Pyramid p : pyramids) {
            totalVolume += p.calculateVolume(p.getHeight(), p.getBaseLength());
        }
        for (Sphere s : spheres) {
            totalVolume += s.calculateVolume(s.getRadius());
        }
        return totalVolume;
    }

//    public static void writeFigureToFile() throws SQLException, ClassNotFoundException {
//
//        Block block = new Block(5, 30, 10);
//        try {
//            FileOutputStream f = new FileOutputStream(new File("C:\\Users\\WesleyB\\Documents\\TempmyObjects.ser"));
//            ObjectOutputStream o = new ObjectOutputStream(f);
//
//            o.writeObject(block);
//
//            o.close();
//            f.close();
//
//            FileInputStream fi = new FileInputStream(new File("C:\\Users\\WesleyB\\Documents\\TempmyObjects.ser"));
//            ObjectInputStream oi = new ObjectInputStream(fi);
//
//            // Read objects
//            Block prBlock = (Block) oi.readObject();
//
//            System.out.println(block.toString());
//
//            oi.close();
//            fi.close();
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        } catch (IOException e) {
//            System.out.println("Error initializing stream");
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }

}
