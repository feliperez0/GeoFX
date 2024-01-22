package dad.geofx.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GeoInterfaceIpapi {
	
	@GET("ip_api.php")
	Call<GeoIpapiResponse> getIpInfo(@Query("ip") String ipAddress);
	
}