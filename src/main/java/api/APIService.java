package api;

import api.responses.Response;
import model.Film;
import retrofit2.Call;
import retrofit2.http.*;
import model.*;

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
    Call<Response> postFilm(@Body Film film);

    @POST("/showtimes")
    Call<Response> postShow(@Body Showtime showtime);

    @POST("/showrooms")
    Call<Response> postRoom(@Body Showroom showroom);

    @GET("/movies/{id}")
    Call<Film> getFilm(@Path("id") long id);

    @GET("/showtimes/{id}")
    Call<Showtime> getShow(@Path("id") long id);

    @GET("/showrooms/{id}")
    Call<Showroom> getRoom(@Path("id") long id);

    @PUT("/movies/{id}")
    Call<Response> putFilm(@Path("id") long id, @Body Film film);

    @PUT("/showrooms/{id}")
    Call<Response> putRoom(@Path("id") long id, @Body Showroom showroom);

    @PUT("/showtimes/{id}")
    Call<Response> putShow(@Path("id") long id, @Body Showtime showtime);

    @GET("/logs")
    Call<List<Log>> getLogs(@Query("startDate") Date startDate, @Query("endDate") Date endDate);

    @PATCH("/orders/{id}")
    Call<Response> patchOrder(@Path("id") long id, @Body Order order);

    @GET("/orders")
    Call<List<Order>> getOrders(@Query("startDate") Date startDate, @Query("endDate") Date endDate);

//    @POST("/showtimes")
//    Call<Response>

    @GET("/showtimes")
    Call<List<Showtime>> findShowtimesBetween(@Query("startDate") Date startDate, @Query("endDate") Date endDate);

    @GET("/v2/api-docs")
    Call<List<String>> getApiDocs();


}
