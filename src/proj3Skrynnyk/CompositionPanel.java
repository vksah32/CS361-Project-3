package proj3Skrynnyk;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;

/**
 * Created by alexskrynnyk on 9/22/16.
 */
public class CompositionPanel extends Pane {

    private ArrayList<Note> composition;

    public CompositionPanel()
    {
        this.composition = new ArrayList<>();

        this.drawLines();
    }

    private void drawLines()
    {
        for(int i = 0; i < 127; i++)
        {
            Line line = new Line(0, i*10+1, 2000,i*10+1);
            line.setStrokeWidth(1);
            line.setStroke(Color.LIGHTGRAY);

            this.getChildren().add(line);
        }
    }

    public void addNote(double x, double y)
    {
        int tick = (int) x;
        int pitch = this.yToPitch(y);

        Note note = new Note(pitch, tick);

        this.composition.add(note);

        this.getChildren().add(note.getRectangle());
    }

    public int yToPitch(double y)
    {
        int units = (int) y % 10;
        int answer = (int) (y - units);

        int y1 = 128 - answer/10;

        return y1;
    }

}
