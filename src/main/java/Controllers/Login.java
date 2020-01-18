package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button okButton;

    @FXML
    private void login() throws IOException {
        if (this.passwordField.getText().isEmpty() || this.usernameField.getText().isEmpty()) {
            return;
        }

        APIController.build(this.usernameField.getText(), this.passwordField.getText());

        // todo "login process"

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("KINOPOL");
        stage.show();
        Stage s = (Stage) this.okButton.getScene().getWindow();
        s.close();
    }

}
