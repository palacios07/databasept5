package com.example.jpalaci5.addevent;

/**
 * Created by jpalaci5 on 7/20/2015.
 */
public class User {

    String email;
    String password;
    String zipcode;
    int birthyear;
    //int gender;


    /**
     * creating a new user
     * @param email
     * @param password
     * @param birthyear
     * @param zipcode
     */
    public User(String email, String password, int birthyear, String zipcode)
    {
        this.email = email;
        this.password = password;
        this.birthyear = birthyear;
        this.zipcode = zipcode;
       // this.gender = gender;
    }

    /**
     * when the user log in
     * @param email
     * @param password
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.birthyear = -1;
        this.zipcode = "";
        //this.gender = -1;
    }
}
