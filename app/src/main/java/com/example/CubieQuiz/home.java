package com.example.CubieQuiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void startquiz(View view){
        Intent i = new Intent(this, quiz.class);
        startActivity(i);
    }
    public void clickhelp(View view){
        Intent i =new Intent(this,help.class);
        startActivity(i);
    }

    public void onLogout(View view){
        Intent i=new Intent (this,MainActivity.class);
        startActivity(i);
    }
}