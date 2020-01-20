package api;

import api.responses.Response;
import model.Film;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.*;
import model.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface APIService {

    @GET("/movies")
    Call<List<Film>> getFilms();

    @GET("/showtimes")
    Call<List<Showtime>> getShows();

    @GET("/showrooms")
    Call<List<Showroom>> getRooms();

    @POST("/movies")
    Call<Object> postFilm(@Body Film film);

    @POST("/showtimes")
    Call<Object> postShow(@Body ShowtimeRequest showtime);

    @POST("/showrooms")
    Call<Object> postRoom(@Body Showroom showroom);

    @GET("/movies/{id}")
    Call<Film> getFilm(@Path("id") long id);

    @GET("/showtimes/{id}")
    Call<Showtime> getShow(@Path("id") long id);

    @GET("/showrooms/{id}")
    Call<Showroom> getRoom(@Path("id") long id);

    @PUT("/movies/{id}")
    Call<Void> putFilm(@Path("id") long id, @Body Film film);

    @PUT("/showrooms/{id}")
    Call<Void> putRoom(@Path("id") long id, @Body Showroom showroom);

    @PUT("/showtimes/{id}")
    Call<Void> putShow(@Path("id") long id, @Body Showtime showtime);

    @GET("/logs")
    Call<List<Log>> getLogs(@Query("startDate") LocalDateTime startDate, @Query("endDate") LocalDateTime endDate);

    @PATCH("/orders/{id}")
    Call<Response> patchOrder(@Path("id") long id, @Body Order order);

    @GET("/orders")
    Call<List<Order>> getOrders(@Query("startDate") Date startDate, @Query("endDate") Date endDate);

//    @POST("/showtimes")
//    Call<Response>

    @GET("/showtimes")
    Call<List<Showtime>> findShowtimesBetween(@Query("startDate") LocalDateTime startDate, @Query("endDate") LocalDateTime endDate);

    @GET("/v2/api-docs")
    Call<Object> getApiDocs();


}
