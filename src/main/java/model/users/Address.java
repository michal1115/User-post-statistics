package model.users;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import exceptions.InvalidLatitudeException;
import exceptions.InvalidLongitudeException;

import lombok.*;

@Getter
@Setter
@ToString
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public Address(String street, String suite, String city, String zipcode, Geo geo){
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public Address(JsonObject addressJson) {
        /*for example, takes
            "address": {
              "street": "Kulas Light",
              "suite": "Apt. 556",
              "city": "Gwenborough",
              "zipcode": "92998-3874",
              "geo": {
                "lat": "-37.3159",
                "lng": "81.1496"
              }
            }

          and initializes object
         */

        this(addressJson.get("street").getAsString(),
                addressJson.get("suite").getAsString(),
                addressJson.get("city").getAsString(),
                addressJson.get("zipcode").getAsString(),
                new Geo(addressJson.get("geo").getAsJsonObject()));
    }
}

