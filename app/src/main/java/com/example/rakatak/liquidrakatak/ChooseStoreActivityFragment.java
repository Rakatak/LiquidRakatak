package com.example.rakatak.liquidrakatak;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class ChooseStoreActivityFragment extends Fragment {


    Button btnBerlin;
    Button btnTampa;
    Button btnTorino;
    Button btnDuluth;
    TextView currentStore;
    String mCurrentSelectedStore;

    public ChooseStoreActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_choose_store, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        currentStore = (TextView) getView().findViewById(R.id.currentStore);
        prepareButtonMenu();



        currentStore.setText(mCurrentSelectedStore);

        btnBerlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentSelectedStore = "Berlin";
                currentStore.setText(mCurrentSelectedStore);            }
        });
        btnTampa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentSelectedStore = "Tampa";
                currentStore.setText(mCurrentSelectedStore);
            }
        });
        btnDuluth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentSelectedStore = "Duluth";
                currentStore.setText(mCurrentSelectedStore);            }
        });
        btnTorino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentSelectedStore = "Torino";
                currentStore.setText(mCurrentSelectedStore);            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCurrentSelectedStore = "Berlin";

        if (savedInstanceState != null) {
            mCurrentSelectedStore = savedInstanceState.getString("Current Store");
        }

    }

    public void prepareButtonMenu(){
        btnBerlin = (Button) getView().findViewById(R.id.btnBerlin);
        btnTampa = (Button) getView().findViewById(R.id.btnTampa);
        btnTorino = (Button) getView().findViewById(R.id.btnTorino);
        btnDuluth = (Button) getView().findViewById(R.id.btnDuluth);

        final LinearLayout tableLayout = (LinearLayout) getView().findViewById(R.id.storeTable2);
        ViewTreeObserver vto = tableLayout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                tableLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int btnWidth = tableLayout.getMeasuredWidth() / 2 - 3;
                Log.d("Output", "RESULT    " + btnWidth);

                btnBerlin.setHeight(btnWidth);
                btnTampa.setHeight(btnWidth);
                btnTorino.setHeight(btnWidth);
                btnDuluth.setHeight(btnWidth);
                btnBerlin.setWidth(btnWidth);
                btnTampa.setWidth(btnWidth);
                btnTorino.setWidth(btnWidth);
                btnDuluth.setWidth(btnWidth);
            }
        });

    }
    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Current Store", mCurrentSelectedStore);
    }
}
