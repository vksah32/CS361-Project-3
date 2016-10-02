
/**
 * File: Controller.java
 * Names: Alex Skrynnyk, Mike Remondi, Vivek Sah, Edward Zhou
 * Class: CS361
 * Project: 3
 * Date: October 2, 2016
 */



package proj3RemondiSkrynnykSahZhou;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Controller {
    public static final int VOLUME = 127;
    public static final int CHANNEL = 0;
    public static final int TRACK_INDEX = 0;

    @FXML
    public CompositionPanel compositionPanel;
    @FXML public MenuBar menuBar;
    @FXML public Menu fileMenu;
    @FXML public Menu actionMenu;

    private Composition composition = new Composition();
    private MidiPlayer player = new MidiPlayer(100, 60);

    private Line line;
    private TranslateTransition transition;

    @FXML
    public void handleMouseClick(MouseEvent event)
    {
        double x = event.getX();
        double y = event.getY();

        Note note = this.composition.addNote(x, y);
        this.compositionPanel.addNote(note);
    }

    public void buildSequence(Composition composition){
        for (Note note: composition.getComposition()){
            this.player.addNote(note.getPitch(), VOLUME, note.getTick(), Note.NOTE_DURATION, CHANNEL, TRACK_INDEX);
        }
    }

    public void beginAnimation(){
        line = new Line(0, 0, 0, 1280);
        line.setStroke(Color.RED);
        compositionPanel.getChildren().addAll(line);
        line.setStrokeWidth(1);
        transition = new TranslateTransition(new Duration(
                composition.getMaxX() * 10), line);
        transition.setToX(composition.getMaxX());
        transition.setInterpolator(Interpolator.LINEAR);
        transition.play();
        transition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                compositionPanel.getChildren().remove(line);
            }
        });
        this.buildSequence(this.composition);
    }

    public void stopAnimation(){
        transition.stop();
        compositionPanel.getChildren().remove(line);
    }

    @FXML
    public void playComposition() {
        if (transition != null) {
            stopComposition();
        }
        if(composition.getComposition().size() > 0){
            beginAnimation();
            this.player.play();
        }
        
    }

    @FXML
    public void stopComposition()
    {
        if (transition != null) {
            stopAnimation();
        }
        this.player.stop();
        this.player.clear();
    }

    @FXML
    public void cleanUpOnExit()
    {
        Platform.exit();
        System.exit(0);
    }

}
