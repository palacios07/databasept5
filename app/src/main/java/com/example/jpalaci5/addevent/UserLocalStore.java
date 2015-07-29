package com.example.jpalaci5.addevent;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jpalaci5 on 7/20/2015.
 */
public class UserLocalStore {


    public static final String SP_EMAIL = "userDetails";
    SharedPreferences userLocalDatabase;    // allows us to save data into  the phone

    /**
     * this will be used to get the shared preference
     * @param context
     */
    public UserLocalStore(Context context)
    {
        userLocalDatabase = context.getSharedPreferences(SP_EMAIL, 0);
    }

    /**
     * this will allow us to edit whats in the shared preference
     * @param user
     */
    public void storeUserData(User user)
    {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("email", user.email);
        spEditor.putString("password", user.password);
        spEditor.putInt("birthyear", user.birthyear);
        spEditor.putString("zipcode", user.zipcode);
        //spEditor.putInt("gender", user.gender);
        spEditor.commit();

    }

    /**
     * this will get the logged in users info
     * @return
     */
    public User getLoggedInUser(){
        String email= userLocalDatabase.getString("email", "");
        String password= userLocalDatabase.getString("password", "");
        int birthyear= userLocalDatabase.getInt("birthyear", -1);
        String zipcode= userLocalDatabase.getString("zipcode", "");
      //  int gender= userLocalDatabase.getInt("gender", -1);

        User storedUser = new User(email, password, birthyear, zipcode);
        return storedUser;
    }


    /**
     * this will check if the user is logged in or logout to see if it needs to be set the user info
     * @param loggedIn
     */
    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();

    }

    public boolean getUserLoggedIn(){
        if (userLocalDatabase.getBoolean("loggedIn", false)== true){
            return true;
        }
        else { return false;}
    }

    /**
     * this will clear the user data when the user logs out
     */
    public void clearData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
