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
    Call<List<Show>> getShows();

    @GET("/showrooms")
    Call<List<Room>> getRooms();

    @POST("/movies")
    Call<Response> postFilm(@Body Film film);

    @POST("/showtimes")
    Call<Response> postShow(@Body Show show);

    @POST("/showrooms")
    Call<Response> postRoom(@Body Room room);

    @GET("/movies/{id}")
    Call<Film> getFilm(@Path("id") long id);

    @GET("/showtimes/{id}")
    Call<Show> getShow(@Path("id") long id);

    @GET("/showrooms/{id}")
    Call<Room> getRoom(@Path("id") long id);

    @PUT("/movies/{id}")
    Call<Response> putFilm(@Path("id") long id, @Body Film film);

    @PUT("/showrooms/{id}")
    Call<Response> putRoom(@Path("id") long id, @Body Room room);

    @PUT("/showtimes/{id}")
    Call<Response> putShow(@Path("id") long id, @Body Show show);

    @GET("/logs?from={startDate}&to={endDate}")
    Call<List<Log>> getLogs(@Path("startDate") Date startDate, @Path("endDate") Date endDate);

    @PATCH("/orders/{id}")
    Call<Response> patchOrder(@Path("id") long id, @Body Order order);

    @GET("/orders?from={startDate}&to={endDate}")
    Call<List<Order>> getOrders(@Path("startDate") Date startDate, @Path("endDate") Date endDate);

//    @POST("/showtimes")
//    Call<Response>

}
