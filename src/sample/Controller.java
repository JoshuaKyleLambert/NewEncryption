package sample;

import a.a.a.c.B;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {

    @FXML private TextField inputPath;
    @FXML private TextField outputPath;
    @FXML private Button key1Button1;
    @FXML private Button key1Button2;
    @FXML private Button key1Button3;
    @FXML private Button key1Button4;

    @FXML private Button key2Button1;
    @FXML private Button key2Button2;
    @FXML private Button key2Button3;
    @FXML private Button key2Button4;

    @FXML private Button key3Button1;
    @FXML private Button key3Button2;
    @FXML private Button key3Button3;
    @FXML private Button key3Button4;

    @FXML private Button key4Button1;
    @FXML private Button key4Button2;
    @FXML private Button key4Button3;
    @FXML private Button key4Button4;

    @FXML private Button bigKeyButton1;
    @FXML private Button bigKeyButton2;
    @FXML private Button bigKeyButton3;
    @FXML private Button bigKeyButton4;
    @FXML private Button bigKeyButton5;
    @FXML private Button bigKeyButton6;
    @FXML private Button bigKeyButton7;
    @FXML private Button bigKeyButton8;
    @FXML private Button bigKeyButton9;

    @FXML private TextArea previewWindow;



    public void encryptClicked(){
        System.out.println(getKey1());
        System.out.println(getKey2());
        System.out.println(getKey3());
        System.out.println(getKey4());
        System.out.println(getBigKey());

        if (inputPath.getText() != "" && outputPath.getText() != ""){
            BinaryBox bBox = new BinaryBox();
            StringBuilder plainBinary = bBox.buildBinaryString(inputPath.getText());
            Encryptor encryptor = new Encryptor(plainBinary, getKey1(),getKey2(),getKey3(),getKey4(),getBigKey());
            bBox.writeBinaryStringToFile(outputPath.getText(), encryptor.getOutputString());
        }
    }

    public void buttonToggle(){

    }

    @FXML protected void fileOpen(ActionEvent event){
        FileChooser fcInput = new FileChooser();
        fcInput.setInitialDirectory(new File(".\\"));
        fcInput.setTitle("Source File");
        inputPath.setText(fcInput.showOpenDialog(new Stage()).toString());
        BinaryBox bb = new BinaryBox();
        StringBuilder test = bb.buildBinaryString(inputPath.getText());
        System.out.println(test.toString());
        previewWindow.setText(test.toString());
    }

    @FXML protected void fileOutput(ActionEvent event){
        FileChooser fcOutput = new FileChooser();
        fcOutput.setInitialDirectory(new File(".\\"));

            fcOutput.setTitle("Save File Source");
            fcOutput.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Files", "*.*"),
                    new FileChooser.ExtensionFilter("txt", "*.txt"),
                    new FileChooser.ExtensionFilter("dat", "*.dat")
            );
            outputPath.setText(fcOutput.showSaveDialog(new Stage()).toString());
    }

    @FXML protected void binaryButtonHandler(ActionEvent event){
        Button button = (Button)event.getSource();
        if (button.getText() == "1") {
            button.setText("0");
            button.setStyle("-fx-background-color: white");
        } else {
            button.setText("1");
            button.setStyle("-fx-background-color: crimson");
        }

    }

    protected String getKey1(){
        return key1Button1.getText() + key1Button2.getText() + key1Button3.getText() + key1Button4.getText();
    }

    protected String getKey2(){
        return key2Button1.getText() + key2Button2.getText() + key2Button3.getText() + key2Button4.getText();
    }

    protected String getKey3(){
        return key3Button1.getText() + key3Button2.getText() + key3Button3.getText() + key3Button4.getText();
    }

    protected String getKey4(){
        return key4Button1.getText() + key4Button2.getText() + key4Button3.getText() + key4Button4.getText();
    }

    protected String getBigKey() {
        return bigKeyButton1.getText()
                + bigKeyButton2.getText()
                + bigKeyButton3.getText()
                + bigKeyButton4.getText()
                + bigKeyButton5.getText()
                + bigKeyButton6.getText()
                + bigKeyButton7.getText()
                + bigKeyButton8.getText()
                + bigKeyButton9.getText();
    }
}
