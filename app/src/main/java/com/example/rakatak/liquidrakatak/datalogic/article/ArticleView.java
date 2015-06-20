package com.example.rakatak.liquidrakatak.datalogic.article;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Robin on 20.06.2015.
 */
public class ArticleView extends ImageView{

    public int drawId;

    public ArticleView(Context context) {
        super(context);
    }

    public ArticleView(Context context, int drawId) {
        super(context);
        this.drawId = drawId;
        this.setMaxHeight(225);
        this.setMaxWidth(181);
        this.setScaleType(ScaleType.FIT_XY);
        this.setImageResource(drawId);
        this.setMaxHeight(225);
        this.setMaxWidth(181);
    }
}
