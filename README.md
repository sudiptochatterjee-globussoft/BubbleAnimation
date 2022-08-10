# BubbleAnimation
Animation Library to animate bubbles in android screen

https://user-images.githubusercontent.com/60606550/183654327-ede0f91d-3ded-485f-860f-aac311c73369.mp4

=> Layout xml

add view as-

``` java

 <com.sid.ballanimation.FloatingBubbleView
 
        android:id="@+id/bubble"
        
        android:layout_width="match_parent"
        
        android:layout_height="match_parent"
        
        app:ballDrawable="@drawable/circle_medium"   //drawable or image
        
        app:maxAlpha="240"                           //transparency
        
        app:maxBall="30"                             //maximum ball count
        
        app:maxRadius="80"                           //max size of drawables 
        
        app:minAlpha="15"                            //min transparency
        
        app:minBall="15"                             //min ball count
        
        app:minRadius="40"                           //smallest drawable size
        
        app:minVel="1"                               //ball speed min
        
        app:maxVel="3"/>                             //ball speed max
