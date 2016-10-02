package proj3RemondiSkrynnykSahZhou;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Created by alexskrynnyk on 9/22/16.
 */
public class CompositionPanel extends Pane {


    public CompositionPanel()
    {
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
    public void addNote(Note note)
    {
        this.getChildren().add(note.getRectangle());
    }


}
