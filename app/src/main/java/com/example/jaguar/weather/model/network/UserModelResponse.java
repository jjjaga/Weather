package com.example.jaguar.weather.model.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UserModelResponse {
    @SerializedName("location")
    @Expose
    public Location location;
    @SerializedName("current")
    @Expose
    public Current current;
    @SerializedName("forecast")
    @Expose
    public Forecast forecast;

    public class Location {
        public String getName() {
            return name;
        }

        @SerializedName("name")
        @Expose
        public String name;

        public String getRegion() {
            return region;
        }

        @SerializedName("region")
        @Expose
        public String region;
        @SerializedName("country")
        @Expose
        public String country;
        @SerializedName("lat")
        @Expose
        public float lat;
        @SerializedName("lon")
        @Expose
        public float lon;
        @SerializedName("tz_id")
        @Expose
        public String tzId;
        @SerializedName("localtime_epoch")
        @Expose
        public int localtimeEpoch;
        @SerializedName("localtime")
        @Expose
        public String localtime;
    }

    public class Current {
        @SerializedName("last_updated_epoch")
        @Expose
        public int lastUpdatedEpoch;
        @SerializedName("last_updated")
        @Expose
        public String lastUpdated;
        @SerializedName("temp_c")
        @Expose
        public float tempC;
        @SerializedName("temp_f")
        @Expose
        public float tempF;
        @SerializedName("is_day")
        @Expose
        public int isDay;
        @SerializedName("condition")
        @Expose
        public Condition condition;
        @SerializedName("wind_mph")
        @Expose
        public float windMph;
        @SerializedName("wind_kph")
        @Expose
        public float windKph;
        @SerializedName("wind_degree")
        @Expose
        public int windDegree;
        @SerializedName("wind_dir")
        @Expose
        public String windDir;
        @SerializedName("pressure_mb")
        @Expose
        public float pressureMb;
        @SerializedName("pressure_in")
        @Expose
        public float pressureIn;
        @SerializedName("precip_mm")
        @Expose
        public float precipMm;
        @SerializedName("precip_in")
        @Expose
        public float precipIn;
        @SerializedName("humidity")
        @Expose
        public int humidity;
        @SerializedName("cloud")
        @Expose
        public int cloud;
        @SerializedName("feelslike_c")
        @Expose
        public float feelslikeC;
        @SerializedName("feelslike_f")
        @Expose
        public float feelslikeF;
        @SerializedName("vis_km")
        @Expose
        public float visKm;
        @SerializedName("vis_miles")
        @Expose
        public float visMiles;
        @SerializedName("uv")
        @Expose
        public float uv;
        @SerializedName("gust_mph")
        @Expose
        public float gustMph;
        @SerializedName("gust_kph")
        @Expose
        public float gustKph;

        public class Condition {
            @SerializedName("text")
            @Expose
            public String text;

            public String getIcon() {
                return icon;
            }

            @SerializedName("icon")
            @Expose
            public String icon;
            @SerializedName("code")
            @Expose
            public int code;

        }
    }
    public class Forecast {
        @SerializedName("forecastday")
        @Expose
        public List<Forecastday> forecastday = null;
        public class Forecastday {
            @SerializedName("date")
            @Expose
            public String date;
            @SerializedName("date_epoch")
            @Expose
            public int dateEpoch;
            @SerializedName("day")
            @Expose
            public Day day;
            @SerializedName("astro")
            @Expose
            public Astro astro;
            public class Day {
                @SerializedName("maxtemp_c")
                @Expose
                public float maxtempC;
                @SerializedName("maxtemp_f")
                @Expose
                public float maxtempF;
                @SerializedName("mintemp_c")
                @Expose
                public float mintempC;
                @SerializedName("mintemp_f")
                @Expose
                public float mintempF;
                @SerializedName("avgtemp_c")
                @Expose
                public float avgtempC;
                @SerializedName("avgtemp_f")
                @Expose
                public float avgtempF;
                @SerializedName("maxwind_mph")
                @Expose
                public float maxwindMph;
                @SerializedName("maxwind_kph")
                @Expose
                public float maxwindKph;
                @SerializedName("totalprecip_mm")
                @Expose
                public float totalprecipMm;
                @SerializedName("totalprecip_in")
                @Expose
                public float totalprecipIn;
                @SerializedName("avgvis_km")
                @Expose
                public float avgvisKm;
                @SerializedName("avgvis_miles")
                @Expose
                public float avgvisMiles;
                @SerializedName("avghumidity")
                @Expose
                public float avghumidity;
                @SerializedName("condition")
                @Expose
                public Condition_ condition;
                @SerializedName("uv")
                @Expose
                public float uv;
            }
            public class Condition_ {
                @SerializedName("text")
                @Expose
                public String text;
                @SerializedName("icon")
                @Expose
                public String icon;
                @SerializedName("code")
                @Expose
                public int code;
            }

            public class Astro {
                @SerializedName("sunrise")
                @Expose
                public String sunrise;
                @SerializedName("sunset")
                @Expose
                public String sunset;
                @SerializedName("moonrise")
                @Expose
                public String moonrise;
                @SerializedName("moonset")
                @Expose
                public String moonset;

            }
        }
    }
}
