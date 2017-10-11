package com.yuvaraj.floatseekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FloatSeekBar seekBar, seekBar1;
    ImageButton button, button2, add, minus;
    TextView textView,textView1;
    int clicked = 0;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(getApplicationContext(),"");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        textView = (TextView) findViewById(R.id.textView);
        textView1 = (TextView) findViewById(R.id.textView1);

        seekBar = (FloatSeekBar) findViewById(R.id.seekBar);
        seekBar1 = (FloatSeekBar) findViewById(R.id.seekBar1);

        button = (ImageButton) findViewById(R.id.button);
        button.setOnClickListener(this);
        button2 = (ImageButton) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        add = (ImageButton) findViewById(R.id.add);
        add.setOnClickListener(this);
        minus = (ImageButton) findViewById(R.id.minus);
        minus.setOnClickListener(this);

        seekBar.setMaxFloat(10000.0f);
        seekBar.setMinFloat(0.50f);
        seekBar.setValue(5.0f);
        seekBar.setSeekValueFloat(5.0f);

        seekBar1.setMaxFloat(10000.0f);
        seekBar1.setMinFloat(0.50f);
        seekBar1.setValue(5.0f);
        seekBar1.setSeekValueFloat(5.0f);

        textView.setText("" + seekBar.getSeekValueFloat());
        textView1.setText("" + seekBar1.getSeekValueFloat());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBars, int progress, boolean fromUser) {
                if (clicked == 1) {//add
                    clicked = 0;
                } else if (clicked == 2) {//minus
                    clicked = 0;
                } else {
                    seekBar.setSeekValueFloat(seekBar.getValue());
                    clicked = 0;
                }

                textView.setText("" + seekBar.getSeekValueFloat());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBars, int progress, boolean fromUser) {
                if (clicked == 1) {//add
                    clicked = 0;
                } else if (clicked == 2) {//minus
                    clicked = 0;
                } else {
                    seekBar1.setSeekValueFloat(seekBar1.getValue());
                    clicked = 0;
                }

                textView1.setText("" + seekBar1.getSeekValueFloat());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button2:
                clicked = 1;
                if (seekBar.getSeekValueFloat() < seekBar.getMaxFloat()) {
                    seekBar.setPlus(seekBar.getSeekValueFloat());
                    Log.e("seekbar value plus", "" + seekBar.getSeekValueFloat());
                    textView.setText("" + seekBar.getSeekValueFloat());
                }
                break;
            case R.id.button:
                clicked = 2;
                if (seekBar.getSeekValueFloat() > seekBar.getMinFloat()) {
                    seekBar.setMinus(seekBar.getSeekValueFloat());
                    Log.e("seekbar value minus", "" + seekBar.getSeekValueFloat());
                    textView.setText("" + seekBar.getSeekValueFloat());
                }
                break;
            case R.id.add:
                clicked = 1;
                if (seekBar1.getSeekValueFloat() < seekBar1.getMaxFloat()) {
                    seekBar1.setPlus(seekBar1.getSeekValueFloat());
                    Log.e("seekbar1 value plus", "" + seekBar1.getSeekValueFloat());
                    textView1.setText("" + seekBar1.getSeekValueFloat());
                }
                break;
            case R.id.minus:
                clicked = 2;
                if (seekBar1.getSeekValueFloat() > seekBar1.getMinFloat()) {
                    seekBar1.setMinus(seekBar1.getSeekValueFloat());
                    Log.e("seekbar1 value minus", "" + seekBar1.getSeekValueFloat());
                    textView1.setText("" + seekBar1.getSeekValueFloat());
                }
                break;
        }
    }

    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
