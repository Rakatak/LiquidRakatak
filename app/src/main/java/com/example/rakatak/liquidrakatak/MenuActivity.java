package com.example.rakatak.liquidrakatak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TableLayout;

import com.example.rakatak.liquidrakatak.datalogic.user.User;
import com.example.rakatak.liquidrakatak.datalogic.user.UserStore;


public class MenuActivity extends ActionBarActivity {


    Button btnLogin, btnShop, btnGPS, btnSearch;
    UserStore userStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        userStore = new UserStore(this);

        prepareButtonMenu();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userStore.getUserLoggedIn()){
                    User user = userStore.getLoggedUser();

                    Intent intent = new Intent(getApplicationContext(), UserDetailActivity.class);
                    intent.putExtra("name", user.name);
                    intent.putExtra("email", user.email);
                    intent.putExtra("password", user.password);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        btnGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext() , ChooseStoreActivity.class);
                startActivity(intent);
            }
        });
    }


    public void prepareButtonMenu(){
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnShop = (Button) findViewById(R.id.btnShop);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnGPS = (Button) findViewById(R.id.btnGPS);

        final TableLayout tableLayout = (TableLayout) findViewById(R.id.menuTable);
        ViewTreeObserver vto = tableLayout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                tableLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int btnWidth  = tableLayout.getMeasuredWidth()/2 - 3;
                Log.d("Output", "RESULT    " + btnWidth);

                btnLogin.setHeight(btnWidth);
                btnShop.setHeight(btnWidth);
                btnSearch.setHeight(btnWidth);
                btnGPS.setHeight(btnWidth);
                btnLogin.setWidth(btnWidth);
                btnShop.setWidth(btnWidth);
                btnSearch.setWidth(btnWidth);
                btnGPS.setWidth(btnWidth);
            }
        });

    }

}
