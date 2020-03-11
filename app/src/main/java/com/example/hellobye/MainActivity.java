package com.example.hellobye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit1;
    EditText edit2;
    TextView textView;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                String message1 = edit1.getText().toString();
                if (message1.isEmpty()) message1 = getString(R.string.defaultBye);
                String message2 = edit2.getText().toString();
                if(message2.isEmpty()) message2 = getString(R.string.defaultRep);
                int rep = Integer.parseInt(message2);
                if(rep > 100) rep = 20;
                intent.putExtra("Message1",message1);
                intent.putExtra("Message2",rep);
                startActivityForResult(intent,2);
            }
        });
    }

    public void getViews(){
        textView = (TextView) findViewById(R.id.textView);
        edit1 = (EditText) findViewById(R.id.editText);
        edit2 = (EditText) findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.button);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
            if(requestCode==2){
                if(resultCode == RESULT_OK) {
                    edit1.getText().clear();
                    edit1.setHint(R.string.byeEditText);
                    edit2.getText().clear();
                    String message = data.getStringExtra("MESSAGE");
                    textView.setText(message);
                }
            }
    }
}
