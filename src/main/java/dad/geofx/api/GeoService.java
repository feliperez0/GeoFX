package dad.geofx.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class GeoService {

    private static final String BASE_URL = "https://api.ipify.org/";

    private final GeoInterface service;

    public GeoService() {
        ConnectionPool pool = new ConnectionPool(1, 5, TimeUnit.SECONDS);

        OkHttpClient client = new OkHttpClient.Builder().connectionPool(pool).build();

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        service = retrofit.create(GeoInterface.class);
    }

    public String getIpAddress() {
        Call<String> call = service.getIpInfo();

        try {
            retrofit2.Response<String> response = call.execute();

            if (response.isSuccessful()) {
                return response.body();
            } else {
                System.out.println("Error al realizar la solicitud. Código de respuesta: " + response.code());
                System.out.println("Respuesta: " + response.errorBody().string());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
