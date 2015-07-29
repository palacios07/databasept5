package com.example.jpalaci5.addevent;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class EnterEventActivity extends ActionBarActivity implements View.OnClickListener{

    Button bLogout;

    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_event);


        bLogout = (Button)findViewById(R.id.logout);
        bLogout.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(authenticate()== true){

            //startActivity(new Intent(EnterEventActivity.this, AddEventActivity.class));
           //displayUserDetails();
        }
        else{
            //startActivity(new Intent(EnterEventActivity.this, AddEventActivity.class));
        }
    }

    private boolean authenticate(){

        return userLocalStore.getUserLoggedIn();
    }

    private void displayUserDetails(){
    //User user = userLocalStore.getLoggedInUser();

       // etUsername.setText(user.username);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.logout:

                userLocalStore.clearData();
                userLocalStore.setUserLoggedIn(false);

                startActivity(new Intent(this, AddEventActivity.class));
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enter_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
