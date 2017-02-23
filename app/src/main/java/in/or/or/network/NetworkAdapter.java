package in.or.or.network;

import android.content.Context;

import java.util.ArrayList;

import in.or.or.model.Category;
import retrofit2.Call;

public class NetworkAdapter {
    private static NetworkAdapter INSTANCE;
    private ApiService mApiService = null;
    private Context mContext;

    public static NetworkAdapter getInstance(Context context) {
        if (null == INSTANCE) {
            INSTANCE = new NetworkAdapter(context);
        }
        return INSTANCE;
    }

    private NetworkAdapter(Context context) {
        mContext = context;
        mApiService = new RestClient().getService();
    }

    public void getCategories(ResponseCallback<ArrayList<Category>> responseCallback) {
        Call<ArrayList<Category>> call = mApiService.getCategories();
        call.enqueue(responseCallback);
    }
} 