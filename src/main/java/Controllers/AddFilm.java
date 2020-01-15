package Controllers;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Film;

public class AddFilm {

    private ObservableList<Film> obs;

    @FXML
    private Text errorText;

    @FXML
    private TextField titleTextBox;

    @FXML
    private Button okButton;

    @FXML
    void confirm(ActionEvent event) {
        Film film;
        String text = this.titleTextBox.getText();
        if (!text.equals("")) {
            film = new Film(0, text);
            this.obs.add(film);
            this.close();

        } else {
            this.errorText.setVisible(true);
        }
    }

    void setList(ObservableList<Film> films) {
        this.obs = films;
    }

    void close() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }


}
