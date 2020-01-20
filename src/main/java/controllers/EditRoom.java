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

public class EditRoom {

    private ObservableList<Showroom> obs;
    private Showroom room;

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
        if (!this.noOfColumnsText.getText().isEmpty() && !this.roomName.getText().isEmpty() &&
            !this.noOfRowsText.getText().isEmpty()) {
            int cols, rows;
            try {
                cols = Integer.parseUnsignedInt(this.noOfColumnsText.getText());
                rows = Integer.parseUnsignedInt(this.noOfRowsText.getText());
                this.room.setName(this.roomName.getText());
                this.room.setNoOfColumns(cols);
                this.room.setNoOfRows(rows);

                for (int i = 0; i < this.obs.size(); i++) {
                    if (this.obs.get(i).getName().equals(this.room.getName())) {
                        this.obs.set(i, this.room);
                        // todo "the same but on api"
                        Call<Void> call = APIController.api.putRoom(this.room.getId(), this.room);

                        try {
                            Response<Void> response = call.execute();
                            System.out.println(response.code());
                        } catch (IOException e ){
                            e.printStackTrace();;
                        }
                    }
                }
                close();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void set(ObservableList<Showroom> obs, Showroom room) {
        this.room = room;
        this.obs = obs;

        this.roomName.setText(String.valueOf(this.room.getName()));
        this.noOfRowsText.setText(String.valueOf(this.room.getNoOfRows()));
        this.noOfColumnsText.setText(String.valueOf(this.room.getNoOfColumns()));
    }

    private void close() {
        Stage stage = (Stage) this.okButton.getScene().getWindow();
        stage.close();
    }
}
