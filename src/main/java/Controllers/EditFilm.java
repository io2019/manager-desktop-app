package Controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Film;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class EditFilm implements Initializable {

    private Film film;

    private ObservableList<Film> obs;

    @FXML
    private Text errorText;

    @FXML
    private TextField titleTextBox;

    @FXML
    private Button okButton;

    @FXML
    void confirm() {
        this.film.setTitle(this.titleTextBox.getText());
        for (int i = 0; i < obs.size(); i++) {
            if (obs.get(i).getId() == this.film.getId()) {
                this.obs.set(i, this.film);
            }
        }
        // todo "update on api"
        this.close();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void set(Film film, ObservableList<Film> obs) {
        this.film = film;
        this.obs = obs;
        this.titleTextBox.setText(film.getTitle());
    }

    void close() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
}
