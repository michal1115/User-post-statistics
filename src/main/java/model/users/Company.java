package model.users;

import com.google.gson.JsonObject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    public Company(String name, String catchPhrase, String bs){
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public Company(JsonObject companyJson){
        /* for example, takes
        "company": {
            "name": "Romaguera-Crona",
            "catchPhrase": "Multi-layered client-server neural-net",
            "bs": "harness real-time e-markets"
        }

        and initializes object
         */

        this(companyJson.get("name").getAsString(),
                companyJson.get("catchPhrase").getAsString(),
                companyJson.get("bs").getAsString());
    }
}
