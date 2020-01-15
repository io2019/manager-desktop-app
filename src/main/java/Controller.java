import api.APIService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import model.Film;
import model.Room;
import model.Show;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Controller {

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
    private ListView<Room> roomPane;

    @FXML
    private Button addRoomButton;

    @FXML
    private ListView<Show> showPane;

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
        Call<List<Film>> callSync = this.controller.api.getFilms();
        try {
            Response<List<Film>> response = callSync.execute();
            List<Film> films = response.body();
            this.filmsPane.setItems(FXCollections.observableList(films));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void addFilm(ActionEvent event) {

    }

    @FXML
    void editFilm(ActionEvent event) {

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

}
