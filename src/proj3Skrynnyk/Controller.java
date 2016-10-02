package proj3Skrynnyk;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML public CompositionPanel compositionPanel;
    @FXML public MenuBar menuBar;
    @FXML public Menu fileMenu;
    @FXML public Menu actionMenu;

    private MidiPlayer player = new MidiPlayer(1, 80);

    @FXML
    public void handleMouseClick(MouseEvent event)
    {
        double x = event.getX();
        double y = event.getY();

        compositionPanel.addNote(x, y);

    }

    @FXML
    public void playComposition()
    {
        this.player.play();
    }

    @FXML
    public void stopComposition()
    {
        this.player.stop();
    }

    @FXML
    public void cleanUpOnExit()
    {
        this.stopComposition();

        Platform.exit();
        System.exit(0);
    }

}
