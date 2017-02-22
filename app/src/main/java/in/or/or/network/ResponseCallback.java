package in.or.or.network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class ResponseCallback<T> implements Callback<T> {

    public abstract void onResponse(T response);

    public abstract void onFailure(Throwable t);


    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful() && response.body() != null) {
            onResponse(response.body());
        } else {
            onFailure(null);
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        ResponseCallback.this.onFailure(t);
    }

}