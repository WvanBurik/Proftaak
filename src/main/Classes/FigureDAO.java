package main.Classes;

import main.DAB.DBUtil;

import javax.xml.transform.Result;
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

}
