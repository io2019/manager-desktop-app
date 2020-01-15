package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Film;
import model.Log;
import model.Showroom;
import model.Showtime;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private APIController controller = new APIController();
    private Parent root;
    private FXMLLoader loader;
    private Stage stage;

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
    private ListView<Log> logsList;

    @FXML
    private Button deleteFilmButton;

    @FXML
    private Button addShowButton;

    @FXML
    private Button filmRefreshButton;

    @FXML
    private DatePicker startDate;

    @FXML
    private DatePicker endDate;

    @FXML
    private Button logOkButton;

    @FXML
    private Button roomRefreshButton;

    @FXML
    private Button showRefreshButton;

    @FXML
    void refreshFilms() {
        // todo "api call"
//        Call<List<Film>> callSync = this.controller.api.getFilms();
//        try {
//            List<Film> films = callSync.execute().body();
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
    void refreshRooms() {
        // todo "api call"
//        Call<List<Showroom>> callSync = this.controller.api.getRooms();
//        try {
//            List<Showroom> rooms = callSync.execute().body();
//            this.roomPane.setItems(null);
//            this.roomPane.setItems(FXCollections.observableList(rooms));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ObservableList<Showroom> tmp = this.roomPane.getItems();
        this.roomPane.setItems(null);
        this.roomPane.setItems(tmp);
    }

    @FXML
    void refreshShows() {
        // todo "api call"
//        Call<List<Showtime>> callSync = this.controller.api.getShows();
//        try {
//            List<Showtime> shows = callSync.execute().body();
//            this.showPane.setItems(null);
//            this.showPane.setItems(FXCollections.observableList(shows));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ObservableList<Showtime> tmp = this.showPane.getItems();
        this.showPane.setItems(null);
        this.showPane.setItems(tmp);
    }

    @FXML
    void addFilm(ActionEvent event) {
        try {
            this.loader = new FXMLLoader();
            this.loader.setLocation(getClass().getClassLoader().getResource("addFilm.fxml"));
            this.root = this.loader.load();

            AddFilm addfilm = this.loader.getController();
            addfilm.setList(this.filmsPane.getItems());


            this.stage = new Stage();
            stage.setTitle("Dodaj nowy film");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void editFilm(ActionEvent event) {
        try {
            loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("editFilm.fxml"));
            root = loader.load();

            EditFilm editFilm = loader.getController();
            editFilm.set(this.filmsPane.getSelectionModel().getSelectedItem(), this.filmsPane.getItems());

            stage = new Stage();
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
        this.filmsPane.getItems().remove(this.filmsPane.getSelectionModel().getSelectedIndex());
        // todo "delete on API"

    }

    @FXML
    void addRoom(ActionEvent event) {
        try {
            loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("addRoom.fxml"));
            root = loader.load();

            AddRoom addRoom = loader.getController();
            addRoom.set(this.roomPane.getItems());

            stage = new Stage();
            stage.setTitle("Dodaj salę");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void editRoom(ActionEvent event) {
        try {
            loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("editRoom.fxml"));
            root = loader.load();

            EditRoom editRoom = loader.getController();
            editRoom.set(this.roomPane.getItems(), this.roomPane.getSelectionModel().getSelectedItem());

            stage = new Stage();
            stage.setTitle("Edytuj salę");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    @FXML
    void getLogs(ActionEvent event) {
        Date start = Date.from(this.startDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date end = Date.from(this.endDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Call<List<Log>> callSync = this.controller.api.getLogs(start, end);
        try {
            Response<List<Log>> response = callSync.execute();
            List<Log> logs = response.body();
            this.logsList.setItems(null);
            this.logsList.setItems(FXCollections.observableList(logs));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


}
