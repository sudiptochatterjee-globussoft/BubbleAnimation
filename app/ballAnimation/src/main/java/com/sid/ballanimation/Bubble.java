package com.sid.ballanimation;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class Bubble {
    private float bubbleRadius;
    private float bubbleX;
    private float bubbleY;
    private float bubbleSpeedX;
    private float bubbleSpeedY;
    private RectF bubbleBounds;
    private Drawable d;


    public Bubble(float bubbleX, float bubbleY, float radius, int bubbleSpeedX, int bubbleSpeedY, Drawable d){
        this.bubbleX=bubbleX;
        this.bubbleY=bubbleY;
        this.bubbleRadius=radius;
        this.bubbleSpeedX=bubbleSpeedX;
        this.bubbleSpeedY=bubbleSpeedY;
        this.bubbleBounds=new RectF();
        this.d = d;
    }

    public void update(int xMin,int xMax, int yMin, int yMax){
        this.bubbleX+=this.bubbleSpeedX;
        this.bubbleY+=this.bubbleSpeedY;
        if(this.bubbleX+this.bubbleRadius > xMax){
            this.bubbleSpeedX=-this.bubbleSpeedX;
            this.bubbleX=xMax-this.bubbleRadius;
        }
        else
            if(this.bubbleX-this.bubbleRadius<xMin){
                this.bubbleSpeedX=-this.bubbleSpeedX;
                this.bubbleX = xMin+this.bubbleRadius;
            }

        if(this.bubbleY+this.bubbleRadius>yMax){
            this.bubbleSpeedY= -bubbleSpeedY;
            this.bubbleY=yMax-this.bubbleRadius;
        }
        else
            if(this.bubbleY-this.bubbleRadius<yMin){
                this.bubbleSpeedY= -this.bubbleSpeedY;
                this.bubbleY = yMin+this.bubbleRadius;
            }
    }
    public void draw(Canvas canvas){
        this.bubbleBounds.set(this.bubbleX-this.bubbleRadius,this.bubbleY-this.bubbleRadius,this.bubbleX+this.bubbleRadius,this.bubbleY+this.bubbleRadius);
        d.setBounds((int)(this.bubbleX-this.bubbleRadius),(int)(this.bubbleY-this.bubbleRadius),(int)(this.bubbleX+this.bubbleRadius),(int)(this.bubbleY+this.bubbleRadius));
        d.draw(canvas);
    }
}
