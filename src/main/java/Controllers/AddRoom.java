package Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Showroom;

import java.awt.*;
import java.util.ArrayList;

public class AddRoom {

    private ObservableList<Showroom> obs;

    @FXML
    private TextField roomNo;

    @FXML
    private Button okButton;

    @FXML
    private TextField numberOfSeatsText;

    @FXML
    void confirm(ActionEvent event) {
        if (!this.roomNo.getText().isEmpty() && !this.numberOfSeatsText.getText().isEmpty()) {
            int seats, no;
            try {
                seats = Integer.parseUnsignedInt(this.numberOfSeatsText.getText());
                no = Integer.parseUnsignedInt(this.roomNo.getText());

                if (this.obs.stream().noneMatch(r -> r.getId() == no)) {
                    obs.add(new Showroom(no, seats, new ArrayList<>(seats)));
                    // todo "add room on api"
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
