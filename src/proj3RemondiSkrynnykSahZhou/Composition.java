package proj3RemondiSkrynnykSahZhou;

import java.util.ArrayList;

/**
 * Created by mremondi on 10/2/16.
 */
public class Composition {
    private double maxX = 0;
    private ArrayList<Note> composition = new ArrayList<>();
    private CompositionPanel compositionPanel;

    public Note addNote(double x, double y)
    {
        maxX = (x > maxX) ? x + Note.NOTE_DURATION : maxX;

        int tick = (int) x;
        int pitch = this.yToPitch(y);

        Note note = new Note(pitch, tick);
        this.composition.add(note);

        return note;
    }

    public int yToPitch(double y) {
        int units = (int) y % 10;
        int answer = (int) (y - units);

        int y1 = 128 - answer/10;

        return y1;
    }

    public ArrayList<Note> getComposition(){
        return composition;
    }

    public double getMaxX(){return maxX;}

}
