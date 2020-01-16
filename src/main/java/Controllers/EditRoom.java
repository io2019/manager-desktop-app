package Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Showroom;

import java.util.ArrayList;

public class EditRoom {

    private ObservableList<Showroom> obs;
    private Showroom room;

    @FXML
    private TextField roomNo;

    @FXML
    private Button okButton;

    @FXML
    private TextField numberOfSeatsText;

    @FXML
    void confirm(ActionEvent event) {
        if (!this.numberOfSeatsText.getText().isEmpty() && !this.roomNo.getText().isEmpty()) {
            int seats, no;
            try {
                seats = Integer.parseUnsignedInt(this.numberOfSeatsText.getText());
                no = Integer.parseUnsignedInt(this.roomNo.getText());


                for (int i = 0; i < this.obs.size(); i++) {
                    if (this.obs.get(i).getId() == this.room.getId()) {
                        this.room.setSeatsNumber(seats);
                        this.room.setSeats(new ArrayList<>(seats));
                        this.obs.set(i, this.room);
                        // todo "the same but on api"
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

        this.roomNo.setText(String.valueOf(this.room.getId()));
        this.numberOfSeatsText.setText(String.valueOf(this.room.getSeatsNumber()));
    }

    private void close() {
        Stage stage = (Stage) this.okButton.getScene().getWindow();
        stage.close();
    }
}
