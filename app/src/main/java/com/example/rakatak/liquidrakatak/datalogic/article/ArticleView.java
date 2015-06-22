package com.example.rakatak.liquidrakatak.datalogic.article;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
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

    public ArticleView(Context context) {
        super(context);
    }

    public ArticleView(Context context, int drawId) {
        super(context);
        this.context = context;
        this.drawId = drawId;
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);




        lp.setMargins(50, 50, 50, 50);
        lp.setMarginEnd(50);
        lp.setMarginStart(50);
        this.setImageResource(drawId);
//        this.setScaleType(ScaleType.FIT_XY);
        this.setLayoutParams(lp);
        this.getLayoutParams().height = 260;
        this.getLayoutParams().width = 200;

    }

    private void scaleImage(){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
    }


}
