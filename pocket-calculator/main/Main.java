package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        stage.setScene(new Scene(controller.getRoot(), 300, 350));
        stage.setTitle("Calculator");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
