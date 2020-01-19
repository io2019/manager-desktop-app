package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Login {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button okButton;

    @FXML
    private Text errorText;

    @FXML
    private void login() throws IOException {
        if (this.passwordField.getText().isEmpty() || this.usernameField.getText().isEmpty()) {
            return;
        }

        this.errorText.setVisible(false);
        APIController.build(this.usernameField.getText(), this.passwordField.getText());

        // todo "login process"
        if (this.auth()) {
            try {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("KINOPOL");
                stage.show();
                Stage s = (Stage) okButton.getScene().getWindow();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.errorText.setVisible(true);
        }
    }


    private boolean auth() {
        Call<Object> call = APIController.api.getApiDocs();
        try {
            Response<Object> response = call.execute();
            return response.code() == 200;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
