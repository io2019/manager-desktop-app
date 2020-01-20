package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Film;
import model.MovieCategories;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddFilm {

    private ObservableList<Film> obs;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private TextField durationTextBox;

    @FXML
    private TextField ageRestrictionTextBox;

    @FXML
    private TextField titleTextBox;

    @FXML
    private Button okButton;

    @FXML
    private TextArea descriptionTextBox;

    @FXML
    private TextField directorTextBox;

    @FXML
    void confirm(ActionEvent event) {
        Film film;
        if (! (this.categoryComboBox.getValue().isEmpty() || this.durationTextBox.getText().isEmpty() ||
                this.ageRestrictionTextBox.getText().isEmpty() || this.titleTextBox.getText().isEmpty())) {
            int age = Integer.parseInt(this.ageRestrictionTextBox.getText());
            Duration duration = Duration.between(
                    LocalTime.MIN,
                    LocalTime.parse( this.durationTextBox.getText() + ":00")
            );
            film = new Film(null, this.titleTextBox.getText(), this.categoryComboBox.getValue(), duration.toString(),
                    this.descriptionTextBox.getText(), this.directorTextBox.getText(), age);
            this.obs.add(film);
            // todo "add on api"
            Call<Object> call = APIController.api.postFilm(film);
            try {
                Response<Object> response = call.execute();
                System.out.println(response.code());
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.close();

        }
    }

    void setList(ObservableList<Film> films) {
        this.obs = films;
        this.categoryComboBox.setItems(FXCollections.observableList(MovieCategories.categories));
    }

    void close() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }


}
