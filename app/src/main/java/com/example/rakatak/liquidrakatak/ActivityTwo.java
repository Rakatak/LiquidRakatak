package com.example.rakatak.liquidrakatak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ActivityTwo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);



        int age = getIntent().getIntExtra("Age", 100);

        TextView label = (TextView) findViewById(R.id.textViewTwo);

        label.setText("Your age is " + age + ". LOL!");


        Button btnTwo = (Button) findViewById(R.id.buttonTwo);
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                intent.putExtra("Country", "Germany");
                startActivity(intent);
            }
        });
    }

}
