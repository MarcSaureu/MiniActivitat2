package com.example.hellobye;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {
    TextView textView;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String concatenacio = getData();
        textView=(TextView) findViewById(R.id.textView4);
        textView.setText(concatenacio);
        button2=(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = textView.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("MESSAGE",message);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
    public String getData(){
        Bundle data = this.getIntent().getExtras();
        int numRep = data.getInt("Message2",2);
        String message = data.getString("Message1","Bye");

        String concatenacio = message;
        for(int i = 1; i < numRep; i++){
            concatenacio = concatenacio.concat(message);
        }
        return concatenacio;
    }
}
