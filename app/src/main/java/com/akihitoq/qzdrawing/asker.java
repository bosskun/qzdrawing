package com.akihitoq.qzdrawing;

import android.graphics.Canvas;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class asker extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    Draw  draw ;
    TextView tv_xy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        draw = new Draw(this);
        setContentView(draw);
    }
}
