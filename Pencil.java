// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP103 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP103 - 2023T2, Assignment 2
 * Name: Amy Booth
 * Username: boothamy
 * ID: 300653766
 */

import ecs100.*;
import java.util.*;

/** Pencil   */
public class Pencil{
    private Stroke stroke;

    /**
     * Setup the GUI
     */
    public void setupGUI(){
        UI.setMouseMotionListener(this::doMouse);
        UI.addButton("Quit", UI::quit);
        UI.setLineWidth(3);
        UI.setDivider(0.0);
    }

    /**
     * Respond to mouse events
     */
    public void doMouse(String action, double x, double y) {
        if (action.equals("pressed")){
            stroke = new Stroke(x,y);
            }
        else if (action.equals("dragged")){
            stroke.addPoint(x,y);
            stroke.draw();
            }
        else if (action.equals("released")){
            stroke.draw();
        }
    }

    public static void main(String[] arguments){
        new Pencil().setupGUI();
    }

}