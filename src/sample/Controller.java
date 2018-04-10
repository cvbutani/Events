package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField javaPrint;
    @FXML private Button finishButton;
    @FXML private Button startButton;
    @FXML private CheckBox selectCheckBox;
    @FXML private Label ourLabel;

    @FXML
    public void initialize(){
        startButton.setDisable(true);
        finishButton.setDisable(true);
    }
    @FXML
    public void onClickButton(ActionEvent e){
        if(e.getSource().equals(startButton)){
            System.out.println("Hello, " + javaPrint.getText());
        }else if(e.getSource().equals(finishButton)){
            System.out.println("Bye, "+ javaPrint.getText());
        }
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(10000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            ourLabel.setText("We did something !!!!");
                        }
                    });
                }catch(InterruptedException event){

                }
            }
        };
        new Thread(task).start();
        if(selectCheckBox.isSelected()){
            javaPrint.clear();
            startButton.setDisable(true);
            finishButton.setDisable(true);
        }
    }
    @FXML
    public void holdKeyRelease(){
        String text = javaPrint.getText();
        boolean disableButton = text.isEmpty() || text.trim().isEmpty();
        startButton.setDisable(disableButton);
        finishButton.setDisable(disableButton);
    }

    public void handleChange(){
        System.out.println("The checkbox is: " + (selectCheckBox.isSelected() ? "Checked" : "Not Checked"));
    }
}
