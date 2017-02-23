package in.or.or.network;

import in.or.or.utils.UrlConstants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


class RestClient {

    private Retrofit mRetrofit = null;

    public RestClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        mRetrofit = new Retrofit.Builder()
                .baseUrl(UrlConstants.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build();
    }


    public ApiService getService() {
        return mRetrofit.create(ApiService.class);
    }
} 