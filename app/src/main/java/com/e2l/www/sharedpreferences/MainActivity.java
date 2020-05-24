package com.e2l.www.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RelativeLayout relativeLayout;
    int backgroundColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        relativeLayout=(RelativeLayout) findViewById(R.id.relLayout);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref",0);

        final SharedPreferences.Editor editor = pref.edit();

        backgroundColor = pref.getInt("backgroundColor",0);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i){

                    case R.id.white :
                        backgroundColor = getResources().getColor(R.color.white);
                        relativeLayout.setBackgroundColor(backgroundColor);


                    case R.id.blue :
                        backgroundColor = getResources().getColor(R.color.blue);
                        relativeLayout.setBackgroundColor(backgroundColor);

                    case R.id.yellow :
                        backgroundColor = getResources().getColor(R.color.yellow);
                        relativeLayout.setBackgroundColor(backgroundColor);
                }

                editor.putInt("backgroundColor",backgroundColor);
                editor.commit();
            }
        });
    }
}
