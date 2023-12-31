package com.mvcexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    // creating object of Model class
    private Model myModel;

    // creating object of Button class
    private Button Button1;
    private Button Button2;
    private Button Button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating relationship between the
        // observable Model and the
        // observer Activity
        myModel = new Model();
        myModel.addObserver(this);

        // assigning button IDs to the objects
        Button1 = findViewById(R.id.button);
        Button2 = findViewById(R.id.button2);
        Button3 = findViewById(R.id.button3);


        // transfer the control to Onclick() method
        // when a button is clicked by passing
        // argument "this"


        // calling setValueAtIndex() method
        // by passing appropriate arguments
        // for different buttons
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myModel.setValueAtIndex(0);
            }
        });
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myModel.setValueAtIndex(1);
            }
        });
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myModel.setValueAtIndex(2);
            }
        });


    }


    @SuppressLint("SetTextI18n")
    @Override
    // function to update the view after
    // the values are modified by the model
    public void update(Observable arg0, Object arg1) {
       // changing text of the buttons
        // according to updated values
        Button1.setText("Count: "+myModel.getValueAtIndex(0));
        Button2.setText("Count: "+myModel.getValueAtIndex(1));
        Button3.setText("Count: "+myModel.getValueAtIndex(2));

    }
}
