
/* Code for COMP103 - 2023T2, Assignment 2
 * Name: Amy Booth
 * Username: boothamy
 * ID: 300653766
 */

import ecs100.*;
import java.util.*;

public class Stroke {
    private ArrayList<Double[]> points = new ArrayList<>();
    private double initX, initY;

    public Stroke(double x, double y) {
        initX = x;
        initY = y;
        //addPoint(x,y);
    }

    public void addPoint(double x, double y) {
        Double[] point = new Double[]{x,y};
        points.add(point);
    }

    public void draw() {
        double lastX = initX;
        double lastY = initY;
        for (Double[] point : points) {
            UI.drawLine(lastX, lastY, point[0], point[1]);
            lastX = point[0];
            lastY = point[1];
        }
    }
}
