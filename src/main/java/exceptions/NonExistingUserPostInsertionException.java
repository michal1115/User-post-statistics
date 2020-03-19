package exceptions;

import model.posts.Post;
import model.users.User;

import java.util.Map;

public class NonExistingUserPostInsertionException extends Exception {
    private Map<Integer, User> users;
    private Post post;

    @Override
    public String getMessage() {
        return super.getMessage() + "\nWhen trying to insert post \n" +  post.toString()
                + "\n\nCurrent users map key state:\n"
                + users.keySet().toString();
    }
    public NonExistingUserPostInsertionException(Map<Integer, User> users, Post post){
        this.post = post;
        this.users = users;
    }
}
