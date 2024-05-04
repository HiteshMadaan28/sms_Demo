package com.example.sms_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText phonenubmer,message;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = findViewById(R.id.button);
        phonenubmer = findViewById(R.id.editText);
        message = findViewById(R.id.editText2);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = phonenubmer.getText().toString();
                String msg = message.getText().toString();

                try{
                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(number,null,msg,null,null);

                    Toast.makeText(getApplicationContext(),"Message Sent",Toast.LENGTH_LONG).show();

                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Some Field is empty",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}