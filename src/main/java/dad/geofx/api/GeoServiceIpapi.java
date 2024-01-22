package dad.geofx.api;

import java.util.concurrent.TimeUnit;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeoServiceIpapi {

	private static final String BASE_URL = "https://ipapi.com/";

	private final GeoInterfaceIpapi service;

	public GeoServiceIpapi() {
		ConnectionPool pool = new ConnectionPool(1, 5, TimeUnit.SECONDS);

		OkHttpClient client = new OkHttpClient.Builder().connectionPool(pool).build();

		Gson gson = new GsonBuilder().setLenient().create();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();

		service = retrofit.create(GeoInterfaceIpapi.class);
	}

	public GeoInterfaceIpapi getService() {
		return service;
	}

	public GeoIpapiResponse getIpInfo(String ipAddress) {
		Call<GeoIpapiResponse> call = service.getIpInfo(ipAddress);

		try {
			Response<GeoIpapiResponse> response = call.execute();

			if (response.isSuccessful()) {
				return response.body();
			} else {
				System.out.println("Error al realizar la solicitud. Código de respuesta: " + response.code());
				System.out.println("Respuesta: " + response.errorBody().string());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
