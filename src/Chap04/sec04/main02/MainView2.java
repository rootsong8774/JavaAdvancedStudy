package Chap04.sec04.main02;

import java.util.Calendar;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView2 extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        stage.setTitle("Current Time");
        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.show();

        Task<String> task = new Task<>() {
            @Override
            protected synchronized String call() {
                while (true) {

                    try {
                        Platform.runLater(() -> {
                            Date time = Calendar.getInstance().getTime();

                            updateValue(time.toString());
                        });
                        wait(1000);
                    } catch (InterruptedException e) {
                        break;
                    }

                }

                return null;
            }
        };

        new Thread(task).start();
        stage.titleProperty().bind(task.valueProperty());
    }

    public static void main(String[] args) {
        Application.launch(MainView2.class);
    }
}
