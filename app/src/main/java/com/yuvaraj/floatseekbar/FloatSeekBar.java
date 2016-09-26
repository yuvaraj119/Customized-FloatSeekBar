package com.yuvaraj.floatseekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.SeekBar;

/**
 * Created by CIPL0349 on 9/23/2016.
 */

public class FloatSeekBar extends SeekBar {

    private float max = 1.0f;
    private float min = 0.50f;
    private float seekValueFloat = 0f;

    public FloatSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public FloatSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FloatSeekBar(Context context) {
        super(context);
    }

    public void setSeekValueFloat(float value) {
        this.seekValueFloat = value;
    }

    public float getSeekValueFloat() {
        return this.seekValueFloat;
    }

    public void setPlus(float value) {
        setValue(value + min);
        seekValueFloat = value + min;
    }

    public void setMinus(float value) {
        setValue(value - min);
        seekValueFloat = value - min;
    }

    public float getMinFloat() {
        return this.min;
    }

    public float getMaxFloat() {
        return this.max;
    }

    public void setMaxFloat(float value) {
        this.max = value;
        setMax(Math.round(value));
    }

    public void setMinFloat(float value) {
        this.min = value;
    }

    public float getValue() {
        return Math.round((max - min) * ((float) getProgress() / (float) getMax()) + min);
    }

    public void setValue(float value) {
        setProgress(Math.round(value));
    }

    /*private void applyAttrs(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FloatSeekBar);
        final int N = a.getIndexCount();
        for (int i = 0; i < N; ++i) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.FloatSeekBar_floatMax:
                    //this.max = a.getFloat(attr, 1.0f);
                    break;
                case R.styleable.FloatSeekBar_floatMin:
                    this.min = a.getFloat(attr, 0.50f);
                    break;
            }
        }
        a.recycle();
    }*/
}
