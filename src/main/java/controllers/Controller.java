package controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private APIController controller;
    private Parent root;
    private FXMLLoader loader;
    private Stage stage;

    @FXML
    private Button editShowButton;

    @FXML
    private Button addFilmButton;

    @FXML
    private DatePicker ordersEndDate;

    @FXML
    private DatePicker endDate;

    @FXML
    private Button editRoomButton;

    @FXML
    private TextField showStartMinutes;

    @FXML
    private Button logOkButton;

    @FXML
    private ListView<Showroom> roomPane;

    @FXML
    private DatePicker ordersStartDate;

    @FXML
    private ListView<Film> filmsPane;

    @FXML
    private ListView<Showtime> showPane;

    @FXML
    private DatePicker showtimeEndDate;

    @FXML
    private TabPane panes;

    @FXML
    private Button filmRefreshButton;

    @FXML
    private TextField showStartHours;

    @FXML
    private TextField showEndHours;

    @FXML
    private Button roomRefreshButton;

    @FXML
    private Button showRoomButton;

    @FXML
    private Button editFilmButton;

    @FXML
    private Button ordersOkButton;

    @FXML
    private ListView<Log> logsList;

    @FXML
    private DatePicker showtimeStartDate;

    @FXML
    private Button addRoomButton;

    @FXML
    private TextField showEndMinutes;

    @FXML
    private Button addShowButton;

    @FXML
    private DatePicker startDate;

    @FXML
    private ListView<Order> ordersList;

    @FXML
    private TextField logsStartTime;

    @FXML
    private TextField logsEndTime;



    @FXML
    void refreshFilms() {
        // todo "api call"
        Call<List<Film>> callSync = APIController.api.getFilms();
        try {
            List<Film> films = callSync.execute().body();
            this.filmsPane.setItems(null);
            this.filmsPane.setItems(FXCollections.observableList(films));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void refreshRooms() {
        // todo "api call"
        Call<List<Showroom>> callSync = APIController.api.getRooms();
        try {
            List<Showroom> rooms = callSync.execute().body();
            this.roomPane.setItems(null);
            this.roomPane.setItems(FXCollections.observableList(rooms));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void refreshShows() {
        // todo "api call"
        if (this.showtimeStartDate.getEditor().getText().isEmpty() || this.showtimeEndDate.getEditor().getText().isEmpty()) {
            Call<List<Showtime>> callSync = APIController.api.getShows();
            try {
                List<Showtime> shows = callSync.execute().body();
                this.showPane.setItems(null);
                this.showPane.setItems(FXCollections.observableList(shows));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(this.showEndHours.getText());
            LocalDateTime start = LocalDateTime.from(this.showtimeStartDate.getValue().atStartOfDay());

            start = start.plusHours(Long.parseLong(this.showStartHours.getText()));
            start = start.plusMinutes(Long.parseLong(this.showStartMinutes.getText()));

            LocalDateTime end = LocalDateTime.from(this.showtimeEndDate.getValue().atStartOfDay());

            end = end.plusHours(Long.parseLong(this.showEndHours.getText()));
            end = end.plusMinutes(Long.parseLong(this.showEndMinutes.getText()));

            Call<List<Showtime>> callSync = APIController.api.findShowtimesBetween(start, end);
            try {
                List<Showtime> shows = callSync.execute().body();
                this.showPane.setItems(null);
                this.showPane.setItems(FXCollections.observableList(shows));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void getOrders() {
        if (!(this.ordersEndDate.getEditor().getText().isEmpty() || this.ordersStartDate.getEditor().getText().isEmpty())) {
            try {
                Call<List<Order>> call = APIController.api.getOrders(this.ordersStartDate.getValue(), this.ordersEndDate.getValue());
                try {
                    Response<List<Order>> response = call.execute();
                    System.out.println(response.code());
                    this.ordersList.setItems(null);
                    this.ordersList.setItems(FXCollections.observableList(response.body()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
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
    void addShow(ActionEvent event) {
        try {
            loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("addShow.fxml"));
            root = loader.load();

            AddShow addShow = loader.getController();
            addShow.set(this.showPane.getItems(), this.filmsPane.getItems(), this.roomPane.getItems());

            stage = new Stage();
            stage.setTitle("Dodaj seans");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void editShow(ActionEvent event) {
        try {
            loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("editShow.fxml"));
            root = loader.load();

            EditShow editShow = loader.getController();
            editShow.set(this.showPane.getSelectionModel().getSelectedItem(), this.showPane.getItems(),
                    this.filmsPane.getItems(), this.roomPane.getItems());

            stage = new Stage();
            stage.setTitle("Edytuj seans");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void getLogs(ActionEvent event) {
        if (this.logsEndTime.getText().isEmpty() || this.logsStartTime.getText().isEmpty() ||
                this.startDate.getEditor().getText().isEmpty() || this.endDate.getEditor().getText().isEmpty()) {
            Call<List<Log>> call = APIController.api.getLogs();
            try {
                Response<List<Log>> response = call.execute();
                System.out.println(response.code());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String[] splitStart = this.logsStartTime.getText().split(":");
            String[] splitEnd = this.logsStartTime.getText().split(":");
            try {
                LocalDateTime start = this.startDate.getValue().atStartOfDay();
                start = start.plusHours(Long.parseLong(splitStart[0]));
                start = start.plusMinutes(Long.parseLong(splitStart[1]));

                LocalDateTime end = this.endDate.getValue().atStartOfDay();
                end = end.plusHours(Long.parseLong(splitEnd[0]));
                end = end.plusMinutes(Long.parseLong(splitEnd[1]));

                Call<List<Log>> call = APIController.api.getLogs(start, end);
                try {
                    Response<List<Log>> response = call.execute();
                    System.out.println(response.code());
                    this.logsList.setItems(FXCollections.observableList(response.body()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.refreshRooms();
        this.refreshFilms();
        this.refreshShows();
    }


}
