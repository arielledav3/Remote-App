package com.example.arielledavenport.davenporta4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
    implements CompoundButton.OnCheckedChangeListener{

    private static final String TAG = "MainActivity";
    String btn_id;
    String chan;
    TextView show_result;
    String name;
    Button ch1;
    TextView on;
    int value;
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_dvr;
    Button btn_conf;
    TextView volume1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch switch1 = (Switch) findViewById(R.id.toggle);
        switch1.setOnCheckedChangeListener(this);

        show_result = (TextView)findViewById(R.id.channel);

        volume1 = (TextView)findViewById(R.id.volume);
        on = (TextView)findViewById(R.id.onoff);

        btn_0 = (Button)findViewById(R.id.btn_0);
        btn_0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                show_result.append("0");
            }
        });

        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insert("1");
            }
        });

        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insert("2");
            }
        });

        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insert("3");
            }
        });

        btn_4 = (Button)findViewById(R.id.btn_4);
        btn_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insert("4");
            }
        });

        btn_5 = (Button)findViewById(R.id.btn_5);
        btn_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insert("5");
            }
        });

        btn_6 = (Button)findViewById(R.id.btn_6);
        btn_6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insert("6");
            }
        });

        btn_7 = (Button)findViewById(R.id.btn_7);
        btn_7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insert("7");
            }
        });

        btn_8 = (Button)findViewById(R.id.btn_8);
        btn_8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insert("8");
            }
        });

        btn_9 = (Button)findViewById(R.id.btn_9);
        btn_9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insert("9");
            }
        });

        btn_dvr = (Button)findViewById(R.id.btn_dvr);
        btn_dvr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        Main2Activity.class);
                startActivity(myIntent);
            }
        });

        btn_conf = (Button)findViewById(R.id.btn_conf);
        btn_conf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        Main3Activity.class);
                startActivity(myIntent);
            }
        });




        ch1 = (Button)findViewById(R.id.btn_amc);
        ch1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = getIntent();
                name = intent.getStringExtra("conf");
                chan = intent.getStringExtra("num");
                btn_id = intent.getStringExtra("buttons");
                if(intent == null) {
                    show_result.setText("41");
                }else{
                    show_result.setText(chan);
                    ch1.setText(name);
                }

            }
        });

        Button ch2 = (Button)findViewById(R.id.btn_wgn);
        ch2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                show_result.setText("009");
            }
        });

        Button ch3 = (Button)findViewById(R.id.btn_fx);
        ch3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                show_result.setText("058");
            }
        });

        Button chUp = (Button)findViewById(R.id.btn_chp);
        chUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                channelUp();
            }
        });

        Button chDown = (Button)findViewById(R.id.btn_chm);
        chDown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                channelDown();
            }
        });

        SeekBar seek = (SeekBar)findViewById(R.id.slide);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                volume1.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });
    }




    protected void insert(String j){
        show_result.append(j) ;
    }

    protected void channelUp(){
       int oldChan = Integer.parseInt(show_result.getText().toString());
        int newChan = oldChan + 001;
        String str = Integer.toString(newChan);
        show_result.setText(str);

    }

    protected void channelDown(){
        int oldChan = Integer.parseInt(show_result.getText().toString());
        int newChan = oldChan - 1;
        String str = Integer.toString(newChan);
        show_result.setText(str);

    }

    @Override
    public void onCheckedChanged(CompoundButton button, boolean isChecked){
        Toast.makeText(this, button.getTag() + " is " + (isChecked ? "on" : "off"),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSwitchClicked(View view) {
        Switch sw = (Switch) view;
        Log.d(TAG, "onSwitchClicked() " + sw.getTag() + " " + (sw.isChecked() ? "on" : "off"));
        if(sw.isChecked()){
            on.setText("On");
        }else{
            on.setText("Off");
        }
    }


}
