# Customized-FloatSeekBar
### SeekBar with Float values.

<img src="https://github.com/yuvaraj119/Customized-FloatSeekBar/blob/master/floatseekbar.gif" width="480" height="780">

# How to use

## In layout:
```
<com.yuvaraj.floatseekbar.FloatSeekBar
        android:id="@+id/seekBar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
        
```       
## In Activity:
```
        FloatSeekBar seekBar= (FloatSeekBar) findViewById(R.id.seekBar);

        ImageButton add = (ImageButton) findViewById(R.id.add);
        add.setOnClickListener(this);
        ImageButton minus = (ImageButton) findViewById(R.id.minus);
        minus.setOnClickListener(this);
        TextView textView=(TextView) findViewById(R.id.textView);

        seekBar.setMaxFloat(10000.0f);
        seekBar.setMinFloat(0.50f);
        seekBar.setValue(5.0f);
        seekBar.setSeekValueFloat(5.0f);
        
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
        
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
        case R.id.add:
                clicked = 1;
                if (seekBar.getSeekValueFloat() < seekBar.getMaxFloat()) {
                    seekBar.setPlus(seekBar1.getSeekValueFloat());
                    textView.setText("" + seekBar.getSeekValueFloat());
                }
                break;
            case R.id.minus:
                clicked = 2;
                if (seekBar.getSeekValueFloat() > seekBar.getMinFloat()) {
                    seekBar.setMinus(seekBar.getSeekValueFloat());
                    textView.setText("" + seekBar.getSeekValueFloat());
                }
                break;
        }
    }


```


