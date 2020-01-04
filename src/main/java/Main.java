import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = (Parent) FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
//        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {

//        launch(args);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        UserService service = retrofit.create(UserService.class);
        Call<User> callSync = service.getUser("eugenp");

        try {
            Response<User> response = callSync.execute();
            User user = response.body();
            System.out.println(user.getLogin());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
