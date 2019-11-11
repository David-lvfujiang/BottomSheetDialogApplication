package com.example.bottomsheetdialogapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * @Author: david.lvfujiang
 * @Date: 2019/11/6
 * @Describe:
 */

public class MyView extends FloatingActionButton {
    int startX, startY;
    Scroller scroller;


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        scroller =new Scroller(context);

    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(scroller.getCurrX(),scroller.getCurrY());
            invalidate();
        }
        super.computeScroll();
    }

    @Override
    public boolean onTouchEvent(MotionEvent mv) {
        View parent=  (View)getParent();
        switch (mv.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = (int) mv.getX();
                startY = (int) mv.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int upX = (int) (mv.getX() - startX);
                int upY = (int) (mv.getY() - startY);
                parent.scrollBy(-upX, -upY);
                break;
            case MotionEvent.ACTION_UP:
              // parent.scrollTo(left, right);
                scroller.startScroll(parent.getScrollX(),parent.getScrollY(),-parent.getScrollX(),-parent.getScrollY(),1000);
                invalidate();
                break;
        }
        return super.onTouchEvent(mv);
    }
}
