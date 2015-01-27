package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    public TextField text;
    public Button startBtn;
    public Button StopBtn;
    private Thread t;

    public void showNumbers(ActionEvent actionEvent) {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    if (i == 0) {
                        text.setText("" + i);
                    } else {
                        text.setText(text.getText() + " " + i);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });
        t.setName("ShowThread");
        t.start();
    }

    public void stop(ActionEvent actionEvent) {
        if (t != null) {
            t.interrupt();
        }
    }
}
