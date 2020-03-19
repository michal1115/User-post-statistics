package model.users;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import exceptions.InvalidLatitudeException;
import exceptions.InvalidLongitudeException;
import lombok.*;

@Getter
@ToString
public class Geo {
    private float lat;
    private float lng;

    public Geo(float lat, float lng){
        setLat(lat);
        setLng(lng);
    }
    @SneakyThrows
    public void setLat(float lat){
        if (lat < -90 || lat > 90){
            throw new InvalidLatitudeException();
        }
        this.lat = lat;
    }
    @SneakyThrows
    public void setLng(float lng){
        if (lng < -180 || lng > 180){
            throw new InvalidLongitudeException();
        }
        this.lng = lng;
    }

    public Geo(JsonObject geoJson){
        /*for example, takes
            "geo": {
                "lat": "-37.3159",
                "lng": "81.1496"
            }
            and initializes object
         */

        this(Float.parseFloat(geoJson.get("lat").getAsString()),
                Float.parseFloat(geoJson.get("lng").getAsString()));
    }
}

