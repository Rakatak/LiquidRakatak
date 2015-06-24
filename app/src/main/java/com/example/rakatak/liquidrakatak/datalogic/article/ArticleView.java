package com.example.rakatak.liquidrakatak.datalogic.article;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.example.rakatak.liquidrakatak.R;

/**
 * Created by Robin on 20.06.2015.
 */
public class ArticleView extends ImageView{

    public int drawId;
    private Context context;
    public GridLayout.LayoutParams layoutP;

    public ArticleView(Context context) {
        super(context);
    }

    public ArticleView(Context context, int drawId) {
        super(context);
        this.context = context;
        this.drawId = drawId;
        this.layoutP = new GridLayout.LayoutParams();
        scaleImage();


    }

    private void scaleImage(){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        this.setScaleType(ScaleType.FIT_XY);
        this.setImageResource(drawId);
        layoutP.width = display.getWidth()/3 - (int)(display.getWidth() * 0.04655) ;
        layoutP.height = (int) (layoutP.width * 1.30);
        layoutP.setMargins(10, 10, 15 , 15);
        this.setLayoutParams(layoutP);
    }


}
