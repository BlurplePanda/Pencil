
/* Code for COMP103 - 2023T2, Assignment 2
 * Name: Amy Booth
 * Username: boothamy
 * ID: 300653766
 */

import ecs100.*;
import java.awt.*;
import java.util.*;

public class Stroke {
    private ArrayList<Double[]> points = new ArrayList<>();
    private double initX, initY;
    private Color colour;
    private double width;

    public Stroke(Color col, double w, double x, double y) {
        colour = col;
        width = w;
        initX = x;
        initY = y;
    }

    public void addPoint(double x, double y) {
        Double[] point = new Double[]{x,y};
        points.add(point);
    }

    public Color getColour() {
        return this.colour;
    }

    public double getWidth() {
        return this.width;
    }

    public void draw() {
        UI.setColor(colour);
        UI.setLineWidth(width);
        double lastX = initX;
        double lastY = initY;
        for (Double[] point : points) {
            UI.drawLine(lastX, lastY, point[0], point[1]);
            lastX = point[0];
            lastY = point[1];
        }
    }
}
