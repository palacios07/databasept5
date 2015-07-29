package com.example.jpalaci5.addevent;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class SignUpActivity extends ActionBarActivity implements View.OnClickListener {

    Button mSignUp;
    EditText mEmail, mPassword, mBirthYear, mZipcode;
    //RadioButton mMale, mFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mEmail = (EditText)findViewById(R.id.email);
        mPassword = (EditText)findViewById(R.id.password);
        mBirthYear = (EditText)findViewById(R.id.birthYear);
        mZipcode = (EditText)findViewById(R.id.zipcode);
        //mMale = (RadioButton)findViewById(R.id.male);
       // mFemale = (RadioButton)findViewById(R.id.female);
        mSignUp = (Button)findViewById(R.id.bSignUp);

        mSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.bSignUp:

                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                int birthyear = 1995;//Integer.parseInt(mBirthYear.getText().toString());
                String zipcode = mZipcode.getText().toString();


                User user = new User(email, password, birthyear, zipcode);
                registerUser(user);

                break;
        }
    }
    private void registerUser(User user){
        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.storeUserDataInBackground(user, new GetUserCallBack() {
            // this can also be changed to also make sure if there were any problems storing the users information using Boolean
            @Override
            public void done(User returnedUser) {
                startActivity(new Intent(SignUpActivity.this, EnterEventActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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
