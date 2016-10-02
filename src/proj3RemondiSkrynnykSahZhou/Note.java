
/**
 * File: Note.java
 * Names: Alex Skrynnyk, Mike Remondi, Vivek Sah, Edward Zhou
 * Class: CS361
 * Project: 3
 * Date: October 2, 2016
 */


package proj3RemondiSkrynnykSahZhou;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by alexskrynnyk on 10/1/16.
 */
public class Note {
    public static final int NOTE_DURATION = 100;
    private int pitch;
    private int tick;

    private Rectangle rectangle;

    public Note(int pitch, int tick) {
        this.pitch = pitch;
        this.tick = tick;
        this.rectangle = this.generateRectangle();
    }

    public int getPitch() { return this.pitch; }

    public int getTick() { return this.tick; }

    public Rectangle generateRectangle() {
        Rectangle r = new Rectangle();
        r.setX(tick);
        r.setY(1280 - pitch * 10);
        r.setWidth(NOTE_DURATION);
        r.setHeight(10);
        r.setFill(Color.BLUE);
        r.setStroke(Color.BLACK);
        r.setStrokeWidth(1);
        return r;
    }

    public Rectangle getRectangle() { return this.rectangle; }
}
