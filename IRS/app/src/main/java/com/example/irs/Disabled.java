package com.example.irs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Disabled extends AppCompatActivity {

    private ImageView left;
    private ImageView right;
    private EditText numberInput;

    private TextView floornum;
    int floor=0;
    private boolean b;

    public void arrowupdate(boolean x) {
        if (x) {
            left.setVisibility(View.VISIBLE);
            right.setVisibility(View.INVISIBLE);
        } else {
            left.setVisibility(View.INVISIBLE);
            right.setVisibility(View.VISIBLE);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disabled);



        floornum=findViewById(R.id.floornum);
        left = findViewById(R.id.arrowleft);
        right = findViewById(R.id.arrowright);
        numberInput = findViewById(R.id.numberInput);


        numberInput.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});

        numberInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


                String numString = numberInput.getText().toString();

                if (!numString.equals("")) {
                    int num = Integer.parseInt(numberInput.getText().toString());
                    if(num>99&&num<400) {
                        if (num < 300 && num < 316)
                            floor = num / 10 % 10;
                        else {
                            floor = -1;
                        }
                        if(floor>3)
                            floornum.setText( "enter an existing room");
                        else {
                            arrowupdate(num >= 100 && num < 200 && num < 300);


                            if (num < 317) {
                                if (floor < 4) {
                                    floornum.setText("floor:" + floor);
                                }
                            } else
                                floornum.setText("out side");
                        }
                    }

                    else
                        floornum.setText( "enter an existing room");


                }

            }
        });

    }
}