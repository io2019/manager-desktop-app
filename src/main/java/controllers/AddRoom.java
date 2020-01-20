package controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Showroom;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class AddRoom {

    private ObservableList<Showroom> obs;

    @FXML
    private TextField roomName;

    @FXML
    private Button okButton;

    @FXML
    private TextField noOfColumnsText;

    @FXML
    private TextField noOfRowsText;

    @FXML
    void confirm(ActionEvent event) {
        if (!this.roomName.getText().isEmpty() && !this.noOfColumnsText.getText().isEmpty() &&
            !this.noOfRowsText.getText().isEmpty()) {
            int cols, rows;
            String no;
            try {
                cols = Integer.parseUnsignedInt(this.noOfColumnsText.getText());
                rows = Integer.parseUnsignedInt(this.noOfRowsText.getText());
                if (this.obs.stream().noneMatch(r -> r.getName().equals(this.roomName))) {
                    Showroom showroom = new Showroom(null, this.roomName.getText(), cols, rows);
                    obs.add(showroom);
                    Call<Object> call = APIController.api.postRoom(showroom);
                    try {
                        Response<Object> response = call.execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                this.close();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void set(ObservableList<Showroom> obs){
        this.obs = obs;
    }

    private void close() {
        Stage stage = (Stage) this.okButton.getScene().getWindow();
        stage.close();
    }

}
