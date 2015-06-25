package com.example.rakatak.liquidrakatak;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rakatak.liquidrakatak.datalogic.article.Article;


public class ArticleDetailActivity extends ActionBarActivity {

    private Article article;
    private TextView mArticlePrice;
    private TextView mArticleTitle;
    private TextView mArticlePlatform;
    private TextView mArticleAvailable;
    protected Button mPurchaseBtn;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        article = (Article) getIntent().getSerializableExtra("article");
        mImageView = (ImageView) findViewById(R.id.articleImage);
        mArticleAvailable = (TextView) findViewById(R.id.articleAvailable);
        mArticleTitle = (TextView) findViewById(R.id.articleTitle);
        mArticlePrice = (TextView) findViewById(R.id.articlePrice);
        mArticlePlatform = (TextView) findViewById(R.id.articlePlatform);
        mPurchaseBtn = (Button) findViewById(R.id.btnPurchase);

        final String formPrice = Double.toString(article.getPrice()).replace(".", ",");

        mImageView.setImageResource(article.getImageId());
        mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        mArticleTitle.setText(article.getTitle());
        mArticlePrice.setText("Price: " + formPrice + "€");
        mArticlePlatform.setText("Platform: " + article.getPlatform());
        mArticleAvailable.setText("Available: " + (article.getAvailability() ? "yes" : "no"));
        mPurchaseBtn.setText((article.getAvailability() ? "Purchase" : "Pre-order"));

        mPurchaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert(article);

            }
        });
    }

    private void alert(Article article){
        AlertDialog.Builder alert = new AlertDialog.Builder(ArticleDetailActivity.this);
        alert.setTitle((article.getAvailability() ? "Purchased " : "Pre-ordered ") + article.getTitle());
        alert.setMessage("Will be shipped " + (article.getAvailability() ? "immediately" : "as soon as available")).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_article_detail, menu);
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
