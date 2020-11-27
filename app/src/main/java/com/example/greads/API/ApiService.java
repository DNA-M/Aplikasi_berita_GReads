package com.example.greads.API;

        import com.example.greads.model.Response_News_Model;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Query;

public interface ApiService {

    @GET("/v2/top-headlines")
    Call<Response_News_Model> getListNews(@Query("country") String country, @Query("category") String category, @Query("apiKey") String apiKey);

    @GET("/v2/top-headlines")
    Call<Response_News_Model> getListAllNews(@Query("country") String country, @Query("apiKey") String apiKey);

    @GET("everything")
    Call<Response_News_Model> getListSearchNews(@Query("q") String keyword, @Query("language") String language, @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);

}