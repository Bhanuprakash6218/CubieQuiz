package com.example.CubieQuiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int TIME_INTERVAL=2000;
    private long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getstarted(View view) {
        Intent i = new Intent(this, quiz.class);
        startActivity(i);
    }

    public void about(View view) {
        Intent i = new Intent(this, about.class);
        startActivity(i);
    }
    public void onBackPressed(){
        if(backPressed+TIME_INTERVAL>System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }
        else{
            Toast.makeText(getBaseContext(),"Press Back Again to Exit",Toast.LENGTH_SHORT).show();
        }
        backPressed=System.currentTimeMillis();
    }
}