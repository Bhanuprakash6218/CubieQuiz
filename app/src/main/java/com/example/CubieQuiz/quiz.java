package com.example.CubieQuiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class quiz extends AppCompatActivity {

    TextView tv;
    ImageView image;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    String questions[] = {
            "All the cubes below have a different image on each side. Select the choice that represents a rotation of the given cube.",
            "All the cubes below have a different image on each side. Select the choice that represents a rotation of the given cube.",
            "All the cubes below have a different image on each side. Select the choice that represents a rotation of the given cube.",
            "All the cubes below have a different image on each side. Select the choice that represents a rotation of the given cube."


    };
    String answers[] = {"C", "B","D","A"};
    String opt[] = {
            "sampleq1c1", "sampleq1c2", "sampleq1c3a","sampleq1c4",
            "sampleq2c1", "sampleq2c2a", "sampleq2c3", "sampleq2c4",
            "sampleq3c1a", "sampleq3c2", "sampleq3c3", "sampleq3c4",
            "sampleq4c1", "sampleq4c2", "sampleq4c3", "sampleq4c4a"

    };
    String mImages[]={
            "sampleq1",
            "sampleq2",
            "sampleq3",
            "sampleq4"
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final TextView score = (TextView) findViewById(R.id.textView4);
        final TextView questionNumber=(TextView)findViewById(R.id.textView6);

        submitbutton = (Button) findViewById(R.id.button3);
        quitbutton = (Button) findViewById(R.id.buttonquit);
        tv = (TextView) findViewById(R.id.tvque);
        image=(ImageView) findViewById(R.id.imageview5);


        radio_g = (RadioGroup) findViewById(R.id.answersgrp);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        image.setBackgroundResource(getResources().getIdentifier(mImages[flag],"drawable",getPackageName()));

        rb1.setBackgroundResource(getResources().getIdentifier(opt[0],
                "drawable",
                getPackageName()));
        rb2.setBackgroundResource(getResources().getIdentifier(opt[1],
                "drawable",
                getPackageName()));;
        rb3.setBackgroundResource(getResources().getIdentifier(opt[2],
                "drawable",
                getPackageName()));;
        rb4.setBackgroundResource(getResources().getIdentifier(opt[3 ],
                "drawable",
                getPackageName()));;

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String anstext=uans.getText().toString();

                if (anstext.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;
                questionNumber.setText((flag+1)+" out of "+String.valueOf(questions.length));


                if (score != null)
                    score.setText("" + correct);

                if (flag < questions.length) {
                    tv.setText(questions[flag]);
                    image.setBackgroundResource(getResources().getIdentifier(mImages[flag],"drawable",getPackageName()));
                    rb1.setBackgroundResource(getResources().getIdentifier(opt[flag * 4 ],
                            "drawable",
                            getPackageName()));
                    rb2.setBackgroundResource(getResources().getIdentifier(opt[flag * 4 + 1],
                            "drawable",
                            getPackageName()));
                    rb3.setBackgroundResource(getResources().getIdentifier(opt[flag * 4 + 2],
                            "drawable",
                            getPackageName()));
                    rb4.setBackgroundResource(getResources().getIdentifier(opt[flag * 4 + 3 ],
                            "drawable",
                            getPackageName()));
                } else {
                    marks = correct;
                    Intent in = new Intent(getApplicationContext(), results.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), results.class);
                startActivity(intent);
            }
        });

    }
}
