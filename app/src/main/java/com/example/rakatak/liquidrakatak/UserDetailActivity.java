package com.example.rakatak.liquidrakatak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by robins on 15.06.15.
 */
public class UserDetailActivity extends ActionBarActivity {

    TextView nameView;
    TextView emailView;
    Button logoutButton;
    UserStore userStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        nameView = (TextView) findViewById(R.id.displayName);
        emailView = (TextView) findViewById(R.id.displayEmail);
        logoutButton = (Button) findViewById(R.id.btnLogout);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO handle logout logic
                userStore.setUserLoggedIn(false);
                Intent intent = new Intent(getApplicationContext() , LoginActivity.class);
                startActivity(intent);

            }
        });


    }

}
