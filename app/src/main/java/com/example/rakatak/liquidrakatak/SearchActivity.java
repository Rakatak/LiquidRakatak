package com.example.rakatak.liquidrakatak;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rakatak.liquidrakatak.datalogic.article.Article;
import com.example.rakatak.liquidrakatak.datalogic.article.ArticleEntries;
import com.example.rakatak.liquidrakatak.datalogic.article.ArticleView;

import java.util.ArrayList;


public class SearchActivity extends ActionBarActivity {

    /**
     * The serialization (saved instance state) Bundle key representing the
     * current dropdown position.
     */
    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

    private GridLayout mGridLayout;
    private TextView mEnter;
    private FrameLayout mContainerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mContainerLayout = (FrameLayout) findViewById(R.id.container);
        mGridLayout = (GridLayout) findViewById(R.id.articleGrid);
        mEnter = (TextView) findViewById(R.id.enter);

        getWindow().setBackgroundDrawableResource(R.drawable.background_01);

        try {
            handleIntent(getIntent());
        } catch (InterruptedException e){
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        try {
            handleIntent(intent);
        } catch (InterruptedException e){
        }
    }

    private void handleIntent(Intent intent) throws InterruptedException {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.d("LOOOOOOL", query);
            mContainerLayout.removeView(mEnter);

            if (query.length() < 3){
                Toast toast = Toast.makeText(SearchActivity.this, "Please enter more than three characters.", Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.TOP, 0, 0);
//                toast.setView(mGridLayout);
                toast.show();
            } else {

                displayArticles(getArticles(query.toLowerCase()));
            }

        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore the previously serialized current dropdown position.
        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
            getSupportActionBar().setSelectedNavigationItem(
                    savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Serialize the current dropdown position.
        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM,
                getSupportActionBar().getSelectedNavigationIndex());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        searchView.setIconified(false);
        searchView.onActionViewExpanded();
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
        } else if (id == R.id.search) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Article> getArticles(String mQuery){
        ArrayList<Article> temp = new ArrayList<Article>();
        int i = 0;

        for (Article item : ArticleEntries.ALL_ARTICLES_PS4){
            if (item.getTitle().toLowerCase().contains(mQuery)){
                temp.add(item);
                i++;
            }
        }
        for (Article item : ArticleEntries.ALL_ARTICLES_XBOX){
            if (item.getTitle().toLowerCase().contains(mQuery)){
                temp.add(item);
                i++;
            }
        }
        for (Article item : ArticleEntries.ALL_ARTICLES_WII){
            if (item.getTitle().toLowerCase().contains(mQuery)){
                temp.add(item);
                i++;
            }
        }

        return temp;
    }

    private void displayArticles(ArrayList<Article> articles){
            int i = 0;
            mGridLayout.removeAllViews();

            for (final Article item : articles){
                ArticleView av = new ArticleView(getApplicationContext(), item.getImageId());
                av.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), ArticleDetailActivity.class);
                        intent.putExtra("article", item);
                        startActivity(intent);
                    }
                });
                LinearLayout rl = new LinearLayout(getApplicationContext());
                rl.setOrientation(LinearLayout.VERTICAL);
                TextView tv = new TextView(getApplicationContext());
                tv.setText(Double.toString(item.getPrice()).replace(".", ",") + "€");
                tv.setId(R.id.articlePrice);
                rl.addView(av, 0);
                rl.addView(tv, 1);
                rl.setId(R.id.articleBox);

                mGridLayout.addView(rl, i);
                i++;

        }

    }

}
