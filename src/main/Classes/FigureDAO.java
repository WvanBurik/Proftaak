package main.Classes;

import java.sql.SQLException;
import java.util.ArrayList;

public class FigureDAO {

    //Select all Figures from DB
    //Returns an ArrayList containing figures.
    public static ArrayList readAllFigures() throws SQLException, ClassNotFoundException {
        ArrayList<Figure> figures = new ArrayList<>();

        ArrayList<Block> blocks = Block.readAllFigures();
        ArrayList<Cilinder> cilinders = Cilinder.readAllFigures();
        ArrayList<Hemisphere> hemispheres = Hemisphere.readAllFigures();
        ArrayList<Pyramid> pyramids = Pyramid.readAllFigures();
        ArrayList<Sphere> spheres = Sphere.readAllFigures();

        figures.addAll(blocks);
        figures.addAll(cilinders);
        figures.addAll(hemispheres);
        figures.addAll(pyramids);
        figures.addAll(spheres);

        return figures;
    }


    //Select all Figures From DB and adds all volumes together.
    //Returns a double value of all volumes combined.
    public static double readAllFiguresForTotalVolume() throws SQLException, ClassNotFoundException {
        double totalVolume = 0;

        ArrayList<Block> blocks = Block.readAllFigures();
        ArrayList<Cilinder> cilinders = Cilinder.readAllFigures();
        ArrayList<Hemisphere> hemispheres = Hemisphere.readAllFigures();
        ArrayList<Pyramid> pyramids = Pyramid.readAllFigures();
        ArrayList<Sphere> spheres = Sphere.readAllFigures();

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

}
