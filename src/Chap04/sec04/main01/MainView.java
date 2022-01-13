package Chap04.sec04.main01;

import java.lang.Thread.State;
import java.util.Calendar;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        MyThread thread = new MyThread(stage);
        BorderPane root = new BorderPane();
        TextField textField = new TextField();
        MyThread2 thread2 = new MyThread2(textField);
        Button button = new Button("Click");
        button.setOnAction((event) -> {
            textField.setText("Clicked");
            if (thread2.getState() == State.NEW) {
                thread2.start();
            }
        });
        root.setTop(button);
        root.setCenter(textField);
        Scene scene = new Scene(root, 320, 120);
        stage.setScene(scene);
        stage.show();
        thread.start();


    }

    public static class MyThread extends Thread {

        private final Stage stage;

        public MyThread(Stage stage) {
            this.stage = stage;
        }

        @Override
        public synchronized void run() {
            while (true) {
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    break;
                }
                Platform.runLater(() -> {
                        Date time = Calendar.getInstance().getTime();
                        stage.setTitle(time.toString());
                    }

                );
            }
        }


    }

    public static class MyThread2 extends Thread {

        private final TextField textField;
        private int count;

        public MyThread2(TextField textField) {
            this.textField = textField;
        }

        @Override
        public void run() {
            for (int i = 1; i < 11; i++) {
                count = i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
                Platform.runLater(() -> textField.setText(count + " seconds after clicking"));

            }
        }
    }

    public static void main(String[] args) {
        Application.launch(MainView.class);
    }


}
