package proj3RemondiSkrynnykSahZhou;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));

        Controller controller = new Controller();

        loader.setController(controller);

        Parent root = loader.load();

        Scene scene = new Scene(root, 600, 425);

        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(e -> controller.cleanUpOnExit());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
