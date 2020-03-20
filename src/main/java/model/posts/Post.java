package model.posts;

import com.google.gson.JsonObject;

import exceptions.InvalidEmailFormatException;
import exceptions.InvalidLatitudeException;
import exceptions.InvalidLongitudeException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(JsonObject postJson) {
        this(Integer.parseInt(postJson.get("userId").getAsString()),
                Integer.parseInt(postJson.get("id").getAsString()),
                postJson.get("title").getAsString(),
                postJson.get("body").getAsString());
    }
}
