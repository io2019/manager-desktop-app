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
import model.ShowtimeRequest;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.time.*;
import java.util.Date;

public class AddShow {

    private ObservableList<Showtime> obs;


    @FXML
    private ComboBox<Showroom> roomComboBox;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button okButton;

    @FXML
    private ComboBox<Film> filmComboBox;

    @FXML
    private TextField timeTextBox;

    @FXML
    void confirm(ActionEvent event) {
        if (!this.datePicker.getEditor().getText().isEmpty()) {
            LocalDateTime date = this.datePicker.getValue().atStartOfDay();
            long hours, minutes;
            try {
                String[] split = this.timeTextBox.getText().split(":");
                date = date.plusHours(Long.parseLong(split[0]));
                date = date.plusMinutes(Long.parseLong(split[1]));


                ShowtimeRequest show = new ShowtimeRequest();
                show.setMovieId(this.filmComboBox.getValue().getId());
                show.setShowroomId(this.roomComboBox.getValue().getId());
                show.setDateTime(date);

                Call<Object> call = APIController.api.postShow(show);
                try {
                    Response<Object> response = call.execute();
                    System.out.println(response.code());
                } catch (IOException e ) {
                    e.printStackTrace();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();;
            }
            close();
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
