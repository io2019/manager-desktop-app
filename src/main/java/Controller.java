import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import model.Film;
import model.Room;
import model.Show;

public class Controller {

    @FXML
    private TabPane panes;

    @FXML
    private ListView<Film> moviesPane;

    @FXML
    private Button addMovie;

    @FXML
    private ListView<Room> roomPane;

    @FXML
    private ListView<Show> showPane;

    public void addMovie() {}

}
