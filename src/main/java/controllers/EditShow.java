package controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Film;
import model.Showroom;
import model.Showtime;

public class EditShow {

    private ObservableList<Showtime> obs;
    private Showtime showtime;

    @FXML
    private ComboBox<Showroom> roomComboBox;

    @FXML
    private TextField titleTextBox;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button okButton;

    @FXML
    private ComboBox<Film> filmComboBox;

    @FXML
    void confirm(ActionEvent event) {
//        LocalDateTime date = Date.from(this.datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

        for (int i = 0; i < this.obs.size(); i++) {
            if (this.obs.get(i).getId() == this.showtime.getId()) {
//                this.showtime.setDate(date);
                this.showtime.setFilm(this.filmComboBox.getValue());
                this.showtime.setShowroom(this.roomComboBox.getValue());

                this.obs.set(i, this.showtime);
                // todo "api call"
            }
        }

        close();
    }

    public void set(Showtime showtime, ObservableList<Showtime> obs, ObservableList<Film> films, ObservableList<Showroom> rooms) {
        this.obs = obs;
        this.showtime = showtime;

        this.filmComboBox.setItems(films);
        this.roomComboBox.setItems(rooms);

        this.roomComboBox.getSelectionModel().select(this.showtime.getShowroom());
        this.filmComboBox.getSelectionModel().select(this.showtime.getFilm());
        this.datePicker.getEditor().setText(this.showtime.getDate().toString());
    }

    private void close() {
        Stage stage = (Stage) this.okButton.getScene().getWindow();
        stage.close();
    }

}
