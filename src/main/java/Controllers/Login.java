package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

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

        if (this.auth()) {

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("KINOPOL");
            stage.show();
            Stage s = (Stage) this.okButton.getScene().getWindow();
            s.close();
        }
    }


    private boolean auth() {
        Call<List<String>> callSync = APIController.api.getApiDocs();
        try {
            Response<List<String>> response = callSync.execute();
            System.out.println(response.code());
            System.out.println(response.isSuccessful());
            return response.code() != 401;
        } catch (IOException e) {
            return true;
        } catch (Exception e) {
            return true;
        }

    }
}
