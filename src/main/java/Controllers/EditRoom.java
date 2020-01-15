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
        boolean tmp1 = this.numberOfSeatsText.getText().isEmpty();
        boolean tmp2 = this.roomNo.getText().isEmpty();
        if (!this.numberOfSeatsText.getText().isEmpty() && !this.roomNo.getText().isEmpty()) {
            int seats, no;
            try {
                seats = Integer.parseUnsignedInt(this.numberOfSeatsText.getText());
                no = Integer.parseUnsignedInt(this.roomNo.getText());
                

                this.obs.stream().filter(r -> r.getId() == no).findFirst().ifPresent( r -> {
                    r.setSeatsNumber(seats);
                    r.setSeats(new ArrayList<>(seats));
                });
                // todo "the same but on api"

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
