package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import model.Film;
import model.Showroom;
import model.Showtime;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private APIController controller = new APIController();

    @FXML
    private Button editFilmButton;

    @FXML
    private Button editShowButton;

    @FXML
    private Button addFilmButton;

    @FXML
    private Button editRoomButton;

    @FXML
    private Button deleteShowButton;

    @FXML
    private ListView<Showroom> roomPane;

    @FXML
    private Button addRoomButton;

    @FXML
    private ListView<Showtime> showPane;

    @FXML
    private Button deleteRoomButton;

    @FXML
    private TabPane panes;

    @FXML
    private ListView<Film> filmsPane;

    @FXML
    private ScrollPane logList;

    @FXML
    private Button deleteFilmButton;

    @FXML
    private Button addShowButton;

    @FXML
    private Button filmRefreshButton;

    @FXML
    void refreshFilms() {
//        Call<List<Film>> callSync = this.controller.api.getFilms();
//        try {
//            Response<List<Film>> response = callSync.execute();
//            List<Film> films = response.body();
//            ObservableList<Film> tmp = this.filmsPane.getItems();
//            this.filmsPane.setItems(null);
//            this.filmsPane.setItems(FXCollections.observableList(films));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ObservableList<Film> tmp = this.filmsPane.getItems();
        this.filmsPane.setItems(null);
        this.filmsPane.setItems(tmp);
    }

    @FXML
    void addFilm(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("addFilm.fxml"));
            root = loader.load();

            AddFilm addfilm = loader.getController();
            addfilm.setList(this.filmsPane.getItems());


            Stage stage = new Stage();
            stage.setTitle("Dodaj nowy film");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void editFilm(ActionEvent event) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("editFilm.fxml"));
            root = loader.load();

            EditFilm editFilm = loader.getController();
            editFilm.set(this.filmsPane.getSelectionModel().getSelectedItem(), this.filmsPane.getItems());
//            this.filmDetails.setFilm(new Film(0, "DUPSKO"));
            Stage stage = new Stage();
            stage.setTitle("Edytuj film");
            stage.setScene(new Scene(root));
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void deleteFilm(ActionEvent event) {

    }

    @FXML
    void addRoom(ActionEvent event) {

    }

    @FXML
    void editRoom(ActionEvent event) {

    }

    @FXML
    void deleteRoom(ActionEvent event) {

    }

    @FXML
    void addShow(ActionEvent event) {

    }

    @FXML
    void editShow(ActionEvent event) {

    }

    @FXML
    void deleteShow(ActionEvent event) {

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
