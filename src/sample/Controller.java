package sample;

import a.a.a.c.B;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    public void encryptClicked(){
        System.out.print("Encrypt Clicked");
    }

    public void buttonToggle(){

    }

    @FXML protected void genericHandleButton1(ActionEvent event){
        Button button = (Button)event.getSource();
        if (button.getText() == "1") {
            button.setText("9");
            button.setStyle("-fx-background-color: white");
        } else {
            button.setText("1");
            button.setStyle("-fx-background-color: crimson");
        }

}

    @FXML protected void genericHandleButton2(ActionEvent event){
        Button button = (Button)event.getSource();
        if (button.getText() == "2") {
            button.setText("8");
            button.setStyle("-fx-background-color: white");
        } else {
            button.setText("2");
            button.setStyle("-fx-background-color: crimson");
        }

    }

    @FXML protected void genericHandleButton3(ActionEvent event){
        Button button = (Button)event.getSource();
        if (button.getText() == "3") {
            button.setText("7");
            button.setStyle("-fx-background-color: white");
        } else {
            button.setText("3");
            button.setStyle("-fx-background-color: crimson");
        }

    }

    @FXML protected void genericHandleButton4(ActionEvent event){
        Button button = (Button)event.getSource();
        if (button.getText() == "4") {
            button.setText("6");
            button.setStyle("-fx-background-color: white");
        } else {
            button.setText("4");
            button.setStyle("-fx-background-color: crimson");
        }

    }

}
