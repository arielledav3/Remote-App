package com.example.arielledavenport.davenporta4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
public class Main2Activity extends AppCompatActivity
        implements CompoundButton.OnCheckedChangeListener{

    private static final String TAG = "Main2Activity";
    TextView on;
    TextView state;
    Button btn_play;
    Button btn_stop;
    Button btn_pause;
    Button btn_forward;
    Button btn_rewind;
    Button btn_record;
    Button btn_switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Switch switch1 = (Switch) findViewById(R.id.slide);
        switch1.setOnCheckedChangeListener(this);

        on = (TextView)findViewById(R.id.onoff);

        state = (TextView)findViewById(R.id.state);
        btn_play = (Button)findViewById(R.id.btn_play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                state.setText("Play");
            }
        });

        btn_stop = (Button)findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                state.setText("Stopped");
            }
        });

        btn_pause = (Button)findViewById(R.id.btn_pause);
        btn_pause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                state.setText("Pause");
            }
        });

        btn_forward = (Button)findViewById(R.id.btn_forward);
        btn_forward.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                state.setText("Fast Forwarding");
            }
        });

        btn_rewind = (Button)findViewById(R.id.btn_rewind);
        btn_rewind.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                state.setText("Rewinding");
            }
        });

        btn_record = (Button)findViewById(R.id.btn_record);
        btn_record.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                state.setText("Recording");
            }
        });

        btn_switch = (Button)findViewById(R.id.btn_switch);
        btn_switch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Main2Activity.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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

    @Override
    public void onCheckedChanged(CompoundButton button, boolean isChecked){
        Toast.makeText(this, button.getTag() + " is " + (isChecked ? "on" : "off"),
                Toast.LENGTH_SHORT).show();
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
