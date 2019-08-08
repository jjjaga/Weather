package com.example.jaguar.weather.common

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserModelResponse {
    @SerializedName("location")
    @Expose
    lateinit var location: Location
    @SerializedName("current")
    @Expose
    lateinit var current: Current
    @SerializedName("forecast")
    @Expose
    lateinit var forecast: Forecast

    inner class Location {

        @SerializedName("name")
        @Expose
        lateinit var name: String

        @SerializedName("region")
        @Expose
        lateinit var region: String
        @SerializedName("country")
        @Expose
        lateinit var country: String
        @SerializedName("lat")
        @Expose
        var lat: Float = 0.toFloat()
        @SerializedName("lon")
        @Expose
        var lon: Float = 0.toFloat()
        @SerializedName("tz_id")
        @Expose
        lateinit var tzId: String
        @SerializedName("localtime_epoch")
        @Expose
        var localtimeEpoch: Int = 0
        @SerializedName("localtime")
        @Expose
        lateinit var localtime: String
    }

    inner class Current {
        @SerializedName("last_updated_epoch")
        @Expose
        var lastUpdatedEpoch: Int = 0
        @SerializedName("last_updated")
        @Expose
        lateinit var lastUpdated: String
        @SerializedName("temp_c")
        @Expose
        var tempC: Float = 0.toFloat()
        @SerializedName("temp_f")
        @Expose
        var tempF: Float = 0.toFloat()
        @SerializedName("is_day")
        @Expose
        var isDay: Int = 0
        @SerializedName("condition")
        @Expose
        lateinit var condition: Condition
        @SerializedName("wind_mph")
        @Expose
        var windMph: Float = 0.toFloat()
        @SerializedName("wind_kph")
        @Expose
        var windKph: Float = 0.toFloat()
        @SerializedName("wind_degree")
        @Expose
        var windDegree: Int = 0
        @SerializedName("wind_dir")
        @Expose
        lateinit var windDir: String
        @SerializedName("pressure_mb")
        @Expose
        var pressureMb: Float = 0.toFloat()
        @SerializedName("pressure_in")
        @Expose
        var pressureIn: Float = 0.toFloat()
        @SerializedName("precip_mm")
        @Expose
        var precipMm: Float = 0.toFloat()
        @SerializedName("precip_in")
        @Expose
        var precipIn: Float = 0.toFloat()
        @SerializedName("humidity")
        @Expose
        var humidity: Int = 0
        @SerializedName("cloud")
        @Expose
        var cloud: Int = 0
        @SerializedName("feelslike_c")
        @Expose
        var feelslikeC: Float = 0.toFloat()
        @SerializedName("feelslike_f")
        @Expose
        var feelslikeF: Float = 0.toFloat()
        @SerializedName("vis_km")
        @Expose
        var visKm: Float = 0.toFloat()
        @SerializedName("vis_miles")
        @Expose
        var visMiles: Float = 0.toFloat()
        @SerializedName("uv")
        @Expose
        var uv: Float = 0.toFloat()
        @SerializedName("gust_mph")
        @Expose
        var gustMph: Float = 0.toFloat()
        @SerializedName("gust_kph")
        @Expose
        var gustKph: Float = 0.toFloat()

        inner class Condition {
            @SerializedName("text")
            @Expose
            lateinit var text: String

            @SerializedName("icon")
            @Expose
            lateinit var icon: String
            @SerializedName("code")
            @Expose
            var code: Int = 0

        }
    }

    inner class Forecast {
        @SerializedName("forecastday")
        @Expose
        lateinit var forecastday: List<Forecastday>

        inner class Forecastday {
            @SerializedName("date")
            @Expose
            lateinit var date: String
            @SerializedName("date_epoch")
            @Expose
            var dateEpoch: Int = 0
            @SerializedName("day")
            @Expose
            lateinit var day: Day
            @SerializedName("astro")
            @Expose
            lateinit var astro: Astro

            inner class Day {
                @SerializedName("maxtemp_c")
                @Expose
                var maxtempC: Float = 0.toFloat()
                @SerializedName("maxtemp_f")
                @Expose
                var maxtempF: Float = 0.toFloat()
                @SerializedName("mintemp_c")
                @Expose
                var mintempC: Float = 0.toFloat()
                @SerializedName("mintemp_f")
                @Expose
                var mintempF: Float = 0.toFloat()
                @SerializedName("avgtemp_c")
                @Expose
                var avgtempC: Float = 0.toFloat()
                @SerializedName("avgtemp_f")
                @Expose
                var avgtempF: Float = 0.toFloat()
                @SerializedName("maxwind_mph")
                @Expose
                var maxwindMph: Float = 0.toFloat()
                @SerializedName("maxwind_kph")
                @Expose
                var maxwindKph: Float = 0.toFloat()
                @SerializedName("totalprecip_mm")
                @Expose
                var totalprecipMm: Float = 0.toFloat()
                @SerializedName("totalprecip_in")
                @Expose
                var totalprecipIn: Float = 0.toFloat()
                @SerializedName("avgvis_km")
                @Expose
                var avgvisKm: Float = 0.toFloat()
                @SerializedName("avgvis_miles")
                @Expose
                var avgvisMiles: Float = 0.toFloat()
                @SerializedName("avghumidity")
                @Expose
                var avghumidity: Float = 0.toFloat()
                @SerializedName("condition")
                @Expose
                lateinit var condition: Condition_
                @SerializedName("uv")
                @Expose
                var uv: Float = 0.toFloat()
            }

            inner class Condition_ {
                @SerializedName("text")
                @Expose
                lateinit var text: String
                @SerializedName("icon")
                @Expose
                lateinit var icon: String
                @SerializedName("code")
                @Expose
                var code: Int = 0
            }

            inner class Astro {
                @SerializedName("sunrise")
                @Expose
                lateinit var sunrise: String
                @SerializedName("sunset")
                @Expose
                lateinit var sunset: String
                @SerializedName("moonrise")
                @Expose
                lateinit var moonrise: String
                @SerializedName("moonset")
                @Expose
                lateinit var moonset: String

            }
        }
    }
}