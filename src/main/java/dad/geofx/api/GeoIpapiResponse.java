package dad.geofx.api;

import java.util.List;

public class GeoIpapiResponse {
	private String ip;
	private String hostname;
	private String type;
	private String continent_code;
	private String continent_name;
	private String country_code;
	private String country_name;
	private String region_code;
	private String region_name;
	private String city;
	private String zip;
	private double latitude;
	private double longitude;
	private Location location;
	private TimeZone time_zone;
	private Currency currency;
	private Connection connection;
	private Security security;

	public String getIp() {
		return ip;
	}

	public String getHostname() {
		return hostname;
	}

	public String getType() {
		return type;
	}

	public String getContinent_code() {
		return continent_code;
	}

	public String getContinent_name() {
		return continent_name;
	}

	public String getCountry_code() {
		return country_code;
	}

	public String getCountry_name() {
		return country_name;
	}

	public String getRegion_code() {
		return region_code;
	}

	public String getRegion_name() {
		return region_name;
	}

	public String getCity() {
		return city;
	}

	public String getZip() {
		return zip;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public Location getLocation() {
		return location;
	}

	public TimeZone getTime_zone() {
		return time_zone;
	}

	public Currency getCurrency() {
		return currency;
	}

	public Connection getConnection() {
		return connection;
	}

	public Security getSecurity() {
		return security;
	}

}

class Location {
	private List<Language> languages;
	private String country_flag;
	private String country_flag_emoji;
	private String country_flag_emoji_unicode;
	private String calling_code;
	private boolean is_eu;

	public List<Language> getLanguages() {
		return languages;
	}

	public String getCountry_flag() {
		return country_flag;
	}

	public String getCountry_flag_emoji() {
		return country_flag_emoji;
	}

	public String getCountry_flag_emoji_unicode() {
		return country_flag_emoji_unicode;
	}

	public String getCalling_code() {
		return calling_code;
	}

	public boolean isIs_eu() {
		return is_eu;
	}

}

class Language {
	private String code;
	private String name;
	private String nativeLanguage;

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getNativeLanguage() {
		return nativeLanguage;
	}
	
}

class TimeZone {
	private String id;
	private String current_time;
	private int gmt_offset;
	private String code;
	private boolean is_daylight_saving;
	
	public String getId() {
		return id;
	}
	public String getCurrent_time() {
		return current_time;
	}
	public int getGmt_offset() {
		return gmt_offset;
	}
	public String getCode() {
		return code;
	}
	public boolean isIs_daylight_saving() {
		return is_daylight_saving;
	}

}

class Currency {
	private String code;
	private String name;
	private String plural;
	private String symbol;
	private String symbol_native;
	
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getPlural() {
		return plural;
	}
	public String getSymbol() {
		return symbol;
	}
	public String getSymbol_native() {
		return symbol_native;
	}
	
}

class Connection {
	private int asn;
	private String isp;
	
	public int getAsn() {
		return asn;
	}
	public String getIsp() {
		return isp;
	}
	
}

class Security {
	private boolean is_proxy;
	private String proxy_type;
	private boolean is_crawler;
	private String crawler_name;
	private String crawler_type;
	private boolean is_tor;
	private String threat_level;
	
	public boolean isIs_proxy() {
		return is_proxy;
	}
	public String getProxy_type() {
		return proxy_type;
	}
	public boolean isIs_crawler() {
		return is_crawler;
	}
	public String getCrawler_name() {
		return crawler_name;
	}
	public String getCrawler_type() {
		return crawler_type;
	}
	public boolean isIs_tor() {
		return is_tor;
	}
	public String getThreat_level() {
		return threat_level;
	}
	
}
