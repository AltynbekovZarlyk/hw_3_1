package com.example.hw_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText theme;
    private EditText sms;
    private MaterialButton send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initsenders();
    }
    private void initview(){
        email = findViewById(R.id.EditText1);
        theme = findViewById(R.id.EditText2);
        sms = findViewById(R.id.EditText3);
        send = findViewById(R.id.button);
    }
    private void initsenders(){
        send.setOnClickListener(view -> {
         final Intent intent = new Intent(Intent.ACTION_SEND);
         intent.setType("plain/text");
         intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
         intent.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());
         intent.putExtra(Intent.EXTRA_TEXT, sms.getText().toString());
         startActivity(intent);
        });
    }
}