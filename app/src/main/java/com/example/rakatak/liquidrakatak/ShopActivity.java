package com.example.rakatak.liquidrakatak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.rakatak.liquidrakatak.datalogic.article.Article;
import com.example.rakatak.liquidrakatak.datalogic.article.ArticleEntries;
import com.example.rakatak.liquidrakatak.datalogic.article.ArticleView;


public class ShopActivity extends ActionBarActivity
        implements ShopNavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private ShopNavigationDrawerFragment mShopNavigationDrawerFragment;
    protected static final CharSequence LIQUID = "Liquid Products";
    protected final CharSequence SOLID = "Solid Products";
    protected final CharSequence GASEOUS = "Gaseous Products";


    private GridLayout mGridLayout;
    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        getWindow().setBackgroundDrawableResource(R.drawable.background_01);



        mGridLayout = (GridLayout) findViewById(R.id.articleGrid);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.setMargins(20, 20, 20 , 20);
//        mGridLayout.setLayoutParams(params);

        mShopNavigationDrawerFragment = (ShopNavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mShopNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));


    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        Article[] entry = null;
        switch (number) {
            case 1:
                mTitle = LIQUID;
                fillStoreArticles(number, mGridLayout);
                break;
            case 2:
                mTitle = SOLID;
                fillStoreArticles(number, mGridLayout);
                break;
            case 3:
                mTitle = GASEOUS;
                fillStoreArticles(number, mGridLayout);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mShopNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.menu_shop, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_shop, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((ShopActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }


    private void fillStoreArticles(int number, GridLayout gridLayout){
        int i = 0;
        gridLayout.removeAllViews();
        Article[] entry = null;

        switch (number) {
            case 1:
                entry = ArticleEntries.ALL_ARTICLES_XBOX;
                break;
            case 2:
                entry = ArticleEntries.ALL_ARTICLES_PS4;
                break;
            case 3:
                entry = ArticleEntries.ALL_ARTICLES_WII;
                break;
        }

        for (final Article item : entry){
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

            gridLayout.addView(rl, i);
            i++;
        }
    }
}
