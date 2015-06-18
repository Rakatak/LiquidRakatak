package com.example.rakatak.liquidrakatak;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    UserStore userStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userStore = new UserStore(this);
        userStore.setUserLoggedIn(false);

        try {
            DataBaseHelper dbHelper = new DataBaseHelper(getApplicationContext());
            dbHelper.createDataBase();
        } catch (IOException e) {
            System.exit(0);
        }
        Button btnOne = (Button) findViewById(R.id.startbutton);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext() , MenuActivity.class);
                startActivity(intent);
            }
        });
    }

}
