package com.example.viewpagerwithbottomindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class BottomIndicatorView extends View {
    private int mCount;
    private int mCurrentPosition;
    private int mIndicatorRadius;
    private int mIndicatorPadding;
    private Paint mPaint;

    private int mIndicatorColor = Color.WHITE; // default color

    public BottomIndicatorView(Context context) {
        this(context, null);
    }

    public BottomIndicatorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomIndicatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mIndicatorRadius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
        mIndicatorPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics());

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
    }

    public void setCount(int count) {
        mCount = count;
        requestLayout();
    }

    public void setCurrentPosition(int position) {
        mCurrentPosition = position;
        invalidate();
    }

    public void setIndicatorColor(int color) {
        mIndicatorColor = color;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getPaddingLeft() + getPaddingRight() + (mIndicatorRadius * 2 * mCount) + (mIndicatorPadding * (mCount - 1));
        int height = getPaddingTop() + getPaddingBottom() + (mIndicatorRadius * 2);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int cx = mIndicatorRadius;
        int cy = getHeight() / 2;

        for (int i = 0; i < mCount; i++) {
            if (i == mCurrentPosition) {
                mPaint.setColor(mIndicatorColor);
            } else {
                mPaint.setColor(Color.GRAY);
            }
            canvas.drawCircle(cx, cy, mIndicatorRadius, mPaint);
            cx += mIndicatorRadius * 2 + mIndicatorPadding;
        }
    }
}
