package Chap04.sec04.main03;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainView extends Application {

    /**
     * 사각형을 움직이도록 하기 위한 쓰레드 객체 - 전역변수 설정 이유 ‣ 버튼1에서 객체생성 ‣ 버튼2, 버튼3에서 객체를 불러와 실행을 해야 한다. ☞ 버튼1, 버튼2,
     * 버튼3에서 객체를 공유하기 위해 전역변수로 설정함 ※ start() 함수 내에 final 변수로 설정을 할 경우 버튼1에서 객체생성 한 값을 연결할 수 없다. -
     * final은 값의 변경이 불가하기 때문
     */
    private Thread thread = null;

    @Override
    public void start(Stage stage) {

        /** 메인 Root Node */
        BorderPane root = new BorderPane();
        stage.setTitle("현재시간");

        /** 사각형 중앙 메인 컨테이너 */
        AnchorPane pane1 = new AnchorPane();
        pane1.setStyle("-fx-background-color:pink;");
        root.setCenter(pane1);
        pane1.setPrefSize(400, 400);

        /** 사각형(Rectangle) 객체생성 - 중앙 pane1 컨테이너에 추가 */
        Rectangle rect = new Rectangle(40, 40);
        rect.setFill(Color.BLUEVIOLET);
        pane1.getChildren().add(rect);

        /** Top - 시작, 일시정지, 종료 버튼 생성 */
        FlowPane pane2 = new FlowPane();
        pane2.setStyle("-fx-padding:10px;");
        pane2.setHgap(10); /** 컨트롤 간의 간격을 10px로 지정 */
        root.setTop(pane2);
        Button btn1 = new Button("시작");
        Button btn2 = new Button("일시정지");
        Button btn3 = new Button("종료");
        btn2.setDisable(true);
        btn3.setDisable(true);
        btn1.setPrefWidth(100);
        btn2.setPrefWidth(100);
        btn3.setPrefWidth(100);
        pane2.getChildren().addAll(btn1, btn2, btn3);

        /** Bottom - 프로그레스바 객체생성 */
        ProgressBar progressBar = new ProgressBar();
        progressBar.setProgress(0);
        // 프로그레스바의 너비길이를 Root Node의 너비와 바인드
        progressBar.prefWidthProperty().bind(root.widthProperty());
        progressBar.setStyle("-fx-padding:10px;");
        root.setBottom(progressBar);

        /** 화면구성완료 */
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();

        /** 쓰레드1 - 윈도우 타이틀에 시간정보 나타내기 */
        Service service = new Service() {
            @Override
            protected Task createTask() {
                return new Task<String>() {
                    @Override
                    protected String call() {
                        while (true) {
                            /** 1초마다 시간정보를 받아 updateValue() 함수에 저장 */
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                break;
                            }
                            Date time = Calendar.getInstance().getTime();
                            System.out.println(time);
                            updateValue(String.valueOf(time));
                        }
                        return null;
                    }
                };
            }
        };
        service.start();
        /** Stage titleProperty 속성을 Service valueProperty 속성에 바인딩 */
        stage.titleProperty().bind(service.valueProperty());

        /** 이동 방향에 대한 정보를 저장하기 위한 변수 */
        final Map<String, Double> posInfoMap = new HashMap<>();
        posInfoMap.put("vX", 4.0);
        posInfoMap.put("vY", 4.0);

        /** 시작 버튼 이벤트1 */
        btn1.setOnAction(event -> {
            /** 버튼 제어 및 자료 초기화 */
            btn1.setDisable(true);
            btn2.setDisable(false);
            btn3.setDisable(false);
            progressBar.setProgress(0);
            rect.relocate(0, 0);

            /** 사각형 이동 쓰레드 */
            Thread thread = new Thread(() -> {
/** 너비정보는 IllegalStateException이 발생하지 않아 JavaFx 쓰레드 영역 외 공간에서 사용하였음.
 */
                double width = pane1.widthProperty().get();
                double height = pane1.heightProperty().get();
                double rWidth = rect.widthProperty().get();
                double rHeight = rect.heightProperty().get();
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {

                        /** ‘진행’ 중에 interrupt() 된 상태
                         1. 종료 버튼 클릭
                         ‣ 쓰레드명이 'destory-thread-now'일 경우 종료처리
                         2. 일시정지 버튼 클릭
                         ‣ 아닐 경우 join()으로 쓰레드 대기처리
                         . 자기 쓰레드를 자기가 join()할 경우 interrupt()될 때까지 쓰레드는 대기상태로 된다.
                         */

                        // 1. 종료버튼 클릭일 경우의 처리
                        String name = Thread.currentThread().getName();
                        if ("destory-thread-now".equals(name)) {
                            System.out.println("쓰레드 종료");
                            break;
                        }

                        // 2. 일시정지버튼 클릭일 경우의 처리
                        try {
                            System.out.println("일시정지 interrupt()");
                            Thread.currentThread().join();
                        } catch (InterruptedException e1) {

                            /** ‘일시정지’ 중에 ‘종료’ 또는 ‘재시작’으로 interrupt()된 상태
                             1. 종료 버튼 클릭 - 위와 같음
                             2. ‘재시작’ 버튼 클릭
                             - 다시 실행상태로 된다.
                             */

                            // 1. 종료버튼 클릭일 경우의 처리
                            String name2 = Thread.currentThread().getName();
                            if ("destory-thread-now".equals(name2)) {
                                System.out.println("쓰레드 종료");
                                break;
                            }

                            System.out.println("재시작 interrupt()");
                        }
                    }

                    /** 위치설정 - JavaFx 쓰레드 내에서 실행 */
                    Platform.runLater(() -> {
                        String name = Thread.currentThread().getName();
                        System.out.println("쓰레드2 = " + name);
                        /** 사각형 위치정보 및 x, y 방향 증감 값 조회 */
                        double rX = rect.layoutXProperty().get(); // x좌표
                        double rY = rect.layoutYProperty().get(); // y좌료
                        double vX = posInfoMap.get("vX"); // x방향 증감 값
                        double vY = posInfoMap.get("vY"); // y방향 증감 값
                        /** top, left, bottom, right 경계검사 */
                        if (rX < 0) {
                            vX = 4; // left 경계선 검사
                        }
                        if (rY < 0) {
                            vY = 4; // top 경계선 검사
                        }
                        if (rX + rWidth > width) {
                            vX = -4;    // right 경계선 검사
                        }
                        if (rY + rHeight > height) {
                            vY = -4;    // bottom 경계선 검사
                        }
                        /** 사각형 위치정보 입력, 증갑 값 posInfoMap에 저장 */
                        posInfoMap.put("vX", vX);
                        posInfoMap.put("vY", vY);
                        rect.setLayoutX(rX + vX);
                        rect.setLayoutY(rY + vY);
                        /** 프로그레스바 진행 값 저장 - 0.001씩 증가시킴 */
                        progressBar.setProgress(progressBar.getProgress() + 0.001);
                    });
                }
            });
            MainView.this.thread = thread;
            thread.start();
        });

        /** ‘일시정지’ 버튼 이벤트 처리 */
        btn2.setOnAction(event -> {
            if ("일시정지".equals(btn2.getText())) {
                btn2.setText("재시작");
            } else if ("재시작".equals(btn2.getText())) {
                btn2.setText("일시정지");
            }
            /** interrupt() 시킬 경우 - 내부에서 join()되어 일시정지 된다. */
            thread.interrupt();
        });

        /** 프로그레스바 이벤트 */
        progressBar.progressProperty().addListener((observable, oldValue, newValue) -> {
            /** 프로그레스바의 값이 1일 경우 완전히 경과가 끝난 상태로 종료 처리 */
            if (newValue.doubleValue() >= 1) {
                btn3.fire();  /** '종료‘ 버튼의 이벤트 함수를 실행시킴 */
            }
        });

        /** '종료‘ 버튼 이벤트 처리 */
        btn3.setOnAction(event -> {
            btn1.setDisable(false);
            btn2.setDisable(true);
            btn3.setDisable(true);
            /** 종료 시키기 위해 쓰레드명을 변경 후 interrupt() 시킴 */
            thread.setName("destory-thread-now");
            thread.interrupt();
        });
    }


}