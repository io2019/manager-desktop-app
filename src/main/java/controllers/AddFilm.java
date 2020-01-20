package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Film;
import model.Utils;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

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
            String[] split = this.durationTextBox.getText().split(":");
            Long time;
            try {
                time = Long.parseLong(split[1]);
                time += (Long.parseLong(split[0]) * 60);
                film = new Film(null, this.titleTextBox.getText(), this.categoryComboBox.getValue(), time.toString(),
                        this.descriptionTextBox.getText(), this.directorTextBox.getText(), age);

                Call<Object> call = APIController.api.postFilm(film);
                try {
                    Response<Object> response = call.execute();
                    this.obs.add(film);
                    System.out.println(response.code());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            this.close();

        }
    }

    void setList(ObservableList<Film> films) {
        this.obs = films;
        this.categoryComboBox.setItems(FXCollections.observableList(Utils.categories));
    }

    void close() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }


}
