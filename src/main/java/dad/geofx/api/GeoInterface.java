package dad.geofx.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GeoInterface {
	
	@GET("/")
	Call<String> getIpInfo();

}