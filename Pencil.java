// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP103 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP103 - 2023T2, Assignment 2
 * Name: Amy Booth
 * Username: boothamy
 * ID: 300653766
 */

import ecs100.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/** Pencil   */
public class Pencil{
    private Stroke stroke;
    private Stack<Stroke> drawn = new Stack<>();
    private Stack<Stroke> undone = new Stack<>();

    private Color colour = Color.black;
    private double width = 3;

    /**
     * Setup the GUI
     */
    public void setupGUI(){
        UI.setMouseMotionListener(this::doMouse);
        UI.addButton("Undo", this::undo);
        UI.addButton("Redo", this::redo);
        UI.addSlider("Brush width", 1, 10, 3, this::setWidth);
        UI.addButton("Brush colour", this::setColor);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(0.0);
    }

    /**
     * Respond to mouse events
     */
    public void doMouse(String action, double x, double y) {
        if (action.equals("pressed")){
            stroke = new Stroke(colour, width, x,y);
            }
        else if (action.equals("dragged")){
            stroke.addPoint(x,y);
            stroke.draw();
            }
        else if (action.equals("released")){
            stroke.draw();
            drawn.push(stroke);
            undone.clear();
        }
    }

    public void display() {
        UI.clearGraphics();
        for (Stroke stroke : drawn) {
            stroke.draw();
        }
    }

    public void undo() {
        if (!drawn.isEmpty()) {
            Stroke toUndo = drawn.pop();
            undone.push(toUndo);
            display();
            setColourLast();
        }
    }

    public void redo() {
        if (!undone.isEmpty()) {
            Stroke toRedo = undone.pop();
            drawn.push(toRedo);
            display();
            setColourLast();
        }
    }

    public void setColourLast() {
        if(!drawn.isEmpty()) {
            colour = drawn.peek().getColour();
            width = drawn.peek().getWidth();
        }
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setColor() {
        colour = JColorChooser.showDialog(UI.getFrame(), "Choose a colour", Color.black);
    }

    public static void main(String[] arguments){
        new Pencil().setupGUI();
    }

}