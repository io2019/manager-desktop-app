package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class EditFilm implements Initializable {

    private Film film;

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
    void confirm() {


        String[] split = this.durationTextBox.getText().split(":");
        try {
            Long time = Long.parseLong(split[1]);
            time += (Long.parseLong(split[0]) * 60);

            this.film.setTitle(this.titleTextBox.getText());
            this.film.setAgeRestriction(Integer.parseInt(this.ageRestrictionTextBox.getText()));
            this.film.setCategory(this.categoryComboBox.getValue());
            this.film.setDescription(this.descriptionTextBox.getText());
            this.film.setDirector(this.directorTextBox.getText());
            this.film.setDuration(time.toString());

            Call<Void> call = APIController.api.putFilm(this.film.getId(), film);
            try {
                call.execute();
                for (int i = 0; i < obs.size(); i++) {
                    if (obs.get(i).getId().equals(this.film.getId())) {
                        this.obs.set(i, this.film);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        this.close();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void set(Film film, ObservableList<Film> obs) {
        this.film = film;
        this.obs = obs;
        this.titleTextBox.setText(film.getTitle());
        this.ageRestrictionTextBox.setText(String.valueOf(film.getAgeRestriction()));
        this.descriptionTextBox.setText(film.getDescription());

        String minutes, hours;
        try {
            minutes = String.valueOf(Long.parseLong(film.getDuration()) % 60);
            hours = String.valueOf(Long.parseLong(film.getDuration()) / 60);
            this.durationTextBox.setText(hours + ":" + minutes);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        this.directorTextBox.setText(film.getDirector());

        this.categoryComboBox.setItems(FXCollections.observableList(MovieCategories.categories));
        for (int i = 0; i < this.categoryComboBox.getItems().size(); i++) {
            if (this.categoryComboBox.getItems().get(i).equals(film.getCategory())) {
                this.categoryComboBox.getSelectionModel().select(i);
            }
        }
    }

    void close() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
}
