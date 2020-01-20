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
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private TextField timeTextBox;

    @FXML
    void confirm(ActionEvent event) {


        LocalDateTime time = this.datePicker.getValue().atStartOfDay();
        String[] split = this.timeTextBox.getText().split(":");
        Long hours, minutes;
        try {
            hours = Long.parseLong(split[0]);
            minutes = Long.parseLong(split[1]);
            time = time.plusHours(hours);
            time = time.plusMinutes(minutes);

            this.showtime.setShowroom(this.roomComboBox.getValue());
            this.showtime.setFilm(this.filmComboBox.getValue());
            this.showtime.setDate(time.toString());

            Call<Void> call = APIController.api.putShow(this.showtime.getId(), this.showtime);
            try {
                Response<Void> response = call.execute();
                System.out.println(response.code());

                for (int i = 0; i < this.obs.size(); i++) {
                    if (this.obs.get(i).getId().equals(this.showtime.getId())) {
                        this.obs.set(i, this.showtime);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
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

        LocalDate t = (LocalDateTime.parse(this.showtime.getDate())).toLocalDate();
        this.datePicker.setValue(t);


        LocalDateTime time = LocalDateTime.parse(this.showtime.getDate());
        this.timeTextBox.setText(time.getHour() + ":" + time.getMinute());
    }

    private void close() {
        Stage stage = (Stage) this.okButton.getScene().getWindow();
        stage.close();
    }

}
