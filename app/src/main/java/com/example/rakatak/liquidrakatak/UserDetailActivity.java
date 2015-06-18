package com.example.rakatak.liquidrakatak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rakatak.liquidrakatak.datalogic.user.UserStore;

/**
 * Created by robins on 15.06.15.
 */
public class UserDetailActivity extends ActionBarActivity {

    TextView nameView;
    TextView emailView;
    Button logoutButton;
    UserStore userStore;

    private String mEmail;
    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        userStore = new UserStore(this);


        nameView = (TextView) findViewById(R.id.displayName);
        emailView = (TextView) findViewById(R.id.displayEmail);
        logoutButton = (Button) findViewById(R.id.btnLogout);

        mName = getIntent().getStringExtra("name");
        mEmail = getIntent().getStringExtra("email");

        nameView.setText(mName);
        emailView.setText(mEmail);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO handle logout logic

                userStore.setUserLoggedIn(false);
                userStore.clearUserData();

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                startActivity(intent);

            }
        });


    }
    @Override
     public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
