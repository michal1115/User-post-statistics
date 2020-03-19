package model.users;

import com.google.gson.JsonObject;
import com.sun.tools.javac.util.List;
import exceptions.InvalidEmailFormatException;
import exceptions.InvalidLatitudeException;
import exceptions.InvalidLongitudeException;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;
import model.posts.Post;
import model.users.Address;
import utils.DistanceCounter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = "posts")
public class User {
    final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    private Set<Post> posts = new HashSet<Post>();//set is used to prevent inserting same Post

    public User(int id,
                String name,
                String username,
                String email,
                Address address,
                String phone,
                String website,
                Company company){

        this.id = id;
        this.name = name;
        this.username = username;
        this.address = address;
        setEmail(email);
        this.phone = phone;
        this.website = website;
        this.company = company;
    }
    @SneakyThrows
    public void setEmail(String email) {
        //check if email is in correct format
        if (! email.matches(EMAIL_REGEX)){
            throw new InvalidEmailFormatException();
        }
        this.email = email;
    }

    public User(JsonObject userJson) {
        this(Integer.parseInt(userJson.get("id").getAsString()),
                userJson.get("name").getAsString(),
                userJson.get("username").getAsString(),
                userJson.get("email").getAsString(),
                new Address(userJson.get("address").getAsJsonObject()),
                userJson.get("phone").getAsString(),
                userJson.get("website").getAsString(),
                new Company(userJson.get("company").getAsJsonObject()));
    }

    public void addPost(Post post){
        posts.add(post);
    }

    public void removePost(Post post){
        posts.remove(post);
    }

    public Double getDistance(User other){
        return DistanceCounter.getDistance(this, other);
    }
}
