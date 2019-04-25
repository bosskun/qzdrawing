package com.akihitoq.qzdrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Draw extends View {
    Paint paint = new Paint();
    PointF pointF;
    public ArrayList<PointF> lpointf = new ArrayList<>();
    public ArrayList<ArrayList<PointF>> listOfLine = new ArrayList<>();
    public Draw(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
//        canvas.drawLine(0,0,100,100, paint);
//        canvas.drawLine(100,0,0,100, paint);
        for (int l1 = 0; l1 < listOfLine.size() ; l1++){
            for (int l2 = 0; l2 < listOfLine.get(l1).size() -1 ; l2++){
                canvas.drawLine(listOfLine.get(l1).get(l2).x, listOfLine.get(l1).get(l2).y,
                        listOfLine.get(l1).get(l2+1).x, listOfLine.get(l1).get(l2+1).y, paint);
            }
        }
//            for (int l1 = 0; l1 < listOfLine.size(); l1++){
//                Rect rect = new Rect();
//                rect.left = (int) listOfLine.get(l1).get(0).x;
//                rect.top = (int) listOfLine.get(l1).get(0).y;
//                rect.right = (int) listOfLine.get(l1).get(listOfLine.get(l1).size()-1).x;
//                rect.bottom = (int) listOfLine.get(l1).get(listOfLine.get(l1).size()-1).y;
//                paint.setColor(new Color().BLUE);
//                canvas.drawRect(rect,paint);
//            }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                pointF = new PointF(x, y);
                lpointf = addPointToList(lpointf, pointF);
                listOfLine.add(lpointf);
                this.invalidate();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                pointF = new PointF(x, y);
                lpointf = addPointToList(lpointf, pointF);
                listOfLine.remove(listOfLine.size()-1);
                listOfLine.add(lpointf);
                this.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP: {
                listOfLine.add(lpointf);
                lpointf = new ArrayList<>();
                this.invalidate();
                break;
            }
        }
        Toast.makeText(this.getContext(),"X: "+String.valueOf(x)+" , Y: "+String.valueOf(y),Toast.LENGTH_SHORT).show();
        this.invalidate();
        return true;
    }

    private ArrayList<PointF> addPointToList(ArrayList<PointF> lpointf, PointF pointF){
        if (lpointf.size() >= 0) {
            //lpointf.remove(0);
            lpointf.add(pointF);
        }
        return lpointf;
    }
}
