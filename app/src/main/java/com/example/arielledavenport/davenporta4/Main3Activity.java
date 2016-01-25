package com.example.arielledavenport.davenporta4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

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
    TextView show_result;
    RadioButton rad_but;
    RadioGroup rad_sec;
    Button save;
    EditText editconf;
    String select_id;
    int num;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        show_result = (TextView)findViewById(R.id.show_result);
        editconf = (EditText)findViewById(R.id.editconf);

        btn_0 = (Button)findViewById(R.id.btn_0);
        btn_0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insert("0");
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

        rad_sec = (RadioGroup)findViewById(R.id.rad_sec);
        save = (Button)findViewById(R.id.btn_save);



        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                num = rad_sec.getCheckedRadioButtonId();

                rad_but = (RadioButton)findViewById(num);

                if(editconf.getText().toString().trim().equals("") || editconf.getText().toString().trim().length() < 2){
                    Toast.makeText(getApplicationContext(), "Label is empty or shorter than 2 characters!", Toast.LENGTH_LONG).show();
                }
                if(rad_sec.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Select Button!", Toast.LENGTH_LONG ).show();

                }else {
                    //make intent
                    Intent myIntent = new Intent(Main3Activity.this,
                            MainActivity.class);
                    myIntent.putExtra("conf", editconf.getText().toString());
                    myIntent.putExtra("num", show_result.getText().toString());
                    myIntent.putExtra("buttons", rad_but.getText().toString());

                    startActivity(myIntent);

                }
            }
        });
        cancel = (Button)findViewById(R.id.btn_cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make intent
                Intent myIntent = new Intent(Main3Activity.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main3, menu);
        return true;
    }

    protected void insert(String j){
        show_result.append(j) ;
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

}
