package Controllers;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Film;
import model.Showroom;
import model.Showtime;

import java.time.ZoneId;
import java.util.Date;

public class AddShow {

    private ObservableList<Showtime> obs;


    @FXML
    private ComboBox<Showroom> roomComboBox;

    @FXML
    private TextField idTextBox;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button okButton;

    @FXML
    private ComboBox<Film> filmComboBox;

    @FXML
    void confirm(ActionEvent event) {
        if (!this.datePicker.getEditor().getText().isEmpty()) {
            int id;
            try {
                id = Integer.parseUnsignedInt(this.idTextBox.getText());
                Date date = Date.from(this.datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                if (this.obs.stream().noneMatch(s -> s.getId() == id)) {
                    this.obs.add(new Showtime(id, this.filmComboBox.getValue(), this.roomComboBox.getValue(), date));
                    // todo "api call"
                }

                close();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void set(ObservableList<Showtime> obs, ObservableList<Film> films, ObservableList<Showroom> rooms) {
        this.obs = obs;

        this.filmComboBox.setItems(films);
        this.roomComboBox.setItems(rooms);

        this.filmComboBox.getSelectionModel().select(0);
        this.roomComboBox.getSelectionModel().select(0);
    }

    private void close() {
        Stage stage = (Stage) this.okButton.getScene().getWindow();
        stage.close();
    }

}
