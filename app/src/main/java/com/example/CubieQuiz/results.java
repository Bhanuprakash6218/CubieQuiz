package com.example.CubieQuiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class results extends AppCompatActivity {

    TextView tv,tv4;
    Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        tv = (TextView)findViewById(R.id.tvres3);
        tv4=(TextView)findViewById(R.id.tvres4);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        StringBuffer sb = new StringBuffer();
        sb.append(quiz.correct );
        StringBuffer sb4 = new StringBuffer();
        if(quiz.correct==4){
            sb4.append("You are Genius");
        }
        else {
            sb4.append("Better Luck Next Time");
        }
        tv.setText(sb);
        tv4.setText(sb4);

        quiz.correct=0;
        quiz.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), home.class);
                startActivity(in);
            }
        });

    }
}