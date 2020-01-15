import api.APIService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIController {
    public APIService api;
    private OkHttpClient.Builder httpClient;
    private Retrofit retrofit;


    public APIController() {
        this.httpClient = new OkHttpClient.Builder();
        this.retrofit = new Retrofit.Builder().baseUrl("http://localhost")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        this.api = retrofit.create(APIService.class);
    }
}
