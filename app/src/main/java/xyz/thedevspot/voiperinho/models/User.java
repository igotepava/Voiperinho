package xyz.thedevspot.voiperinho.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by foi on 06/01/16.
 */
public class User {

    @SerializedName("id")
    private int id;

    @SerializedName("username")
    private String username;

    @SerializedName("email_address")
    private String email;

    @SerializedName("avatar")
    private String avatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
