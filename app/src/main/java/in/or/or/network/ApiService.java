package in.or.or.network;

import java.util.ArrayList;

import in.or.or.model.Category;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("bins/7ky91")
    Call<ArrayList<Category>> getCategories();
}