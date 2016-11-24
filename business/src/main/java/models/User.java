package models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by diogojayme on 9/30/16.
 */

public class User {

    private long id;
    @SerializedName("name")
    private String firstName;

    private long crm;
    private String phone;
    private String email;
    private String password;

    public User(String firstName, String lastName, String password, String phone, String email) {
        this.id = System.currentTimeMillis();
        this.firstName = firstName;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCrm() {
        return crm;
    }

    public void setCrm(long crm) {
        this.crm = crm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
