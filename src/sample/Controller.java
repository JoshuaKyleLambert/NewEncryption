package sample;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    final private boolean ENCRYPT = true;
    final private boolean DECRYPT = false;
    private boolean mode = ENCRYPT;
    //TODO Create the Decryptor Class
    /* TODO
      set up mode button and proper behavior for binary
      buttons and encrypt button based on mode. use above
      booleans for the conditions.
       */
    @FXML
    private TextField inputPath;
    @FXML
    private TextField outputPath;
    @FXML
    private Button key1Button1;
    @FXML
    private Button key1Button2;
    @FXML
    private Button key1Button3;
    @FXML
    private Button key1Button4;

    @FXML
    private Button key2Button1;
    @FXML
    private Button key2Button2;
    @FXML
    private Button key2Button3;
    @FXML
    private Button key2Button4;

    @FXML
    private Button key3Button1;
    @FXML
    private Button key3Button2;
    @FXML
    private Button key3Button3;
    @FXML
    private Button key3Button4;

    @FXML
    private Button key4Button1;
    @FXML
    private Button key4Button2;
    @FXML
    private Button key4Button3;
    @FXML
    private Button key4Button4;

    @FXML
    private Button bigKeyButton1;
    @FXML
    private Button bigKeyButton2;
    @FXML
    private Button bigKeyButton3;
    @FXML
    private Button bigKeyButton4;
    @FXML
    private Button bigKeyButton5;
    @FXML
    private Button bigKeyButton6;
    @FXML
    private Button bigKeyButton7;
    @FXML
    private Button bigKeyButton8;
    @FXML
    private Button bigKeyButton9;

    @FXML
    private TextArea previewWindow;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        key1Button1.setText("0");
        key1Button1.setStyle("");
        key1Button2.setText("0");
        key1Button2.setStyle("");
        key1Button3.setText("0");
        key1Button3.setStyle("");
        key1Button4.setText("0");
        key1Button4.setStyle("");

        key2Button1.setText("0");
        key2Button1.setStyle("");
        key2Button2.setText("0");
        key2Button2.setStyle("");
        key2Button3.setText("0");
        key2Button3.setStyle("");
        key2Button4.setText("0");
        key2Button4.setStyle("");

        key3Button1.setText("0");
        key3Button1.setStyle("");
        key3Button2.setText("0");
        key3Button2.setStyle("");
        key3Button3.setText("0");
        key3Button3.setStyle("");
        key3Button4.setText("0");
        key3Button4.setStyle("");

        key4Button1.setText("0");
        key4Button1.setStyle("");
        key4Button2.setText("0");
        key4Button2.setStyle("");
        key4Button3.setText("0");
        key4Button3.setStyle("");
        key4Button4.setText("0");
        key4Button4.setStyle("");


        bigKeyButton1.setText("0");
        bigKeyButton1.setStyle("");
        bigKeyButton2.setText("0");
        bigKeyButton2.setStyle("");
        bigKeyButton3.setText("0");
        bigKeyButton3.setStyle("");
        bigKeyButton4.setText("0");
        bigKeyButton4.setStyle("");
        bigKeyButton5.setText("0");
        bigKeyButton5.setStyle("");
        bigKeyButton6.setText("0");
        bigKeyButton6.setStyle("");
        bigKeyButton7.setText("0");
        bigKeyButton7.setStyle("");
        bigKeyButton8.setText("0");
        bigKeyButton8.setStyle("");
        bigKeyButton9.setText("0");
        bigKeyButton9.setStyle("");

    }

    public void encryptClicked() {
        System.out.println(getKey1());
        System.out.println(getKey2());
        System.out.println(getKey3());
        System.out.println(getKey4());
        System.out.println(getBigKey());
        //TODO setup conditions for mode encrypt button
        if (!inputPath.getText().equals("") && !outputPath.getText().equals("")) {
            BinaryBox bBox = new BinaryBox();
            StringBuilder plainBinary = bBox.buildBinaryString(inputPath.getText());
            Encryptor encryptor = new Encryptor(plainBinary, getKey1(), getKey2(), getKey3(), getKey4(), getBigKey());
            bBox.writeBinaryStringToFile(outputPath.getText(), encryptor.getOutputString());
        }
    }

    public void close() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    protected void fileOpen(ActionEvent event) {
        FileChooser fcInput = new FileChooser();
        fcInput.setInitialDirectory(new File(".\\"));
        fcInput.setTitle("Source File");
        inputPath.setText(fcInput.showOpenDialog(new Stage()).toString());
        StringBuilder stringForPreview = new StringBuilder();
        try {
            int c;
            FileInputStream previewfile = new FileInputStream(inputPath.getText());
            while ((c = previewfile.read()) != -1)
                stringForPreview.append((char) c);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        previewWindow.setText(stringForPreview.toString());
    }

    @FXML
    protected void fileOutput(ActionEvent event) {
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

    @FXML
    protected void binaryButtonHandler(ActionEvent event) {
        Button button = (Button) event.getSource();
        if (button.getText().equals("1")) {
            button.setText("0");
            button.setStyle("");
        } else {
            button.setText("1");
            button.setStyle("-fx-background-color: crimson");
        }

        setPreviewWindow();

    }

    private void setPreviewWindow() {
        //todo setup conditions for setPreview button encryption mode
        if (!inputPath.getText().equals("")) {
            BinaryBox bBox = new BinaryBox();
            StringBuilder plainBinary = bBox.buildBinaryString(inputPath.getText());
            Encryptor encryptor = new Encryptor(plainBinary, getKey1(), getKey2(), getKey3(), getKey4(), getBigKey());
            previewWindow.setText(bBox.binarytoCharString(encryptor.getOutputString()));
        }
    }

    @FXML
    protected void reset() {
        initialize(null, null);
        setPreviewWindow();
    }

    private String getKey1() {
        return key1Button1.getText() + key1Button2.getText() + key1Button3.getText() + key1Button4.getText();
    }

    private String getKey2() {
        return key2Button1.getText() + key2Button2.getText() + key2Button3.getText() + key2Button4.getText();
    }

    private String getKey3() {
        return key3Button1.getText() + key3Button2.getText() + key3Button3.getText() + key3Button4.getText();
    }

    private String getKey4() {
        return key4Button1.getText() + key4Button2.getText() + key4Button3.getText() + key4Button4.getText();
    }

    private String getBigKey() {
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
