package com.sid.ballanimation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FloatingBubbleView extends View {
    private int xMin = -500, xMax, yMin = -500, yMax, minBubble, maxBubble, minRadius, maxRadius, minAlpha, maxAlpha, minVel = 1, maxVel = 5;
    private ArrayList<Bubble> bubbles;
    Context context;
    int bubbleDrawable;
    Drawable bubbleDrawable1;
    TypedArray typedArray;
    Handler handler = new Handler();

    public FloatingBubbleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initialize(attrs);
        bubbles = new ArrayList<>();
        for (int i = 0; i < minBubble + (int) (Math.random() * maxBubble); i++) {
            bubbleDrawable1 = null;
            bubbles.add(this.addBubble());
        }
    }

    public FloatingBubbleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FloatingBubbleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public FloatingBubbleView(Context context) {
        super(context);
    }

    private void initialize(AttributeSet attrs) {
        if (attrs != null) {
            typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.FloatingBubbleView, 0, 0);
            try {
                minBubble = typedArray.getInt(R.styleable.FloatingBubbleView_minBall, 12);
                maxBubble = typedArray.getInt(R.styleable.FloatingBubbleView_maxBall, 20);
                minRadius = typedArray.getInt(R.styleable.FloatingBubbleView_minRadius, 20);
                maxRadius = typedArray.getInt(R.styleable.FloatingBubbleView_maxRadius, 80);
                minVel = typedArray.getInt(R.styleable.FloatingBubbleView_minVel, minVel);
                maxVel = typedArray.getInt(R.styleable.FloatingBubbleView_maxVel, maxVel);
                bubbleDrawable = typedArray.getResourceId(R.styleable.FloatingBubbleView_ballDrawable, R.drawable.circle_medium);
                minAlpha = typedArray.getInt(R.styleable.FloatingBubbleView_minAlpha, 4);
                maxAlpha = typedArray.getInt(R.styleable.FloatingBubbleView_maxAlpha, 250);

            } finally {
                typedArray.recycle();
            }
        }
    }

    public Bubble addBubble() {
        Bubble bubble;
        bubbleDrawable1 = context.getResources().getDrawable(bubbleDrawable, null);
        bubbleDrawable1.setAlpha(minAlpha + (int) (Math.random() * (maxAlpha - 5)));
        int velX = minVel + (int) (Math.random() * maxVel);
        int velY = minVel + (int) (Math.random() * maxVel);
        int radius = minRadius + (int) (Math.random() * maxRadius);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        bubble = new Bubble((int) (Math.random() * width), (int) (Math.random() * height), radius, velX, velY, bubbleDrawable1);
        return bubble;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        for (int i = 0; i < bubbles.size(); i++) {
            bubbles.get(i).draw(canvas);
        }
        for (int i = 0; i < bubbles.size(); i++)
            bubbles.get(i).update(xMin, xMax, yMin, yMax);
        invalidate();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.xMax = w + 500;
        this.yMax = h + 500;
    }
}
