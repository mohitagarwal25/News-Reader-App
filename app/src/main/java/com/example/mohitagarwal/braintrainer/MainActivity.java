package com.example.mohitagarwal.braintrainer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startbutton;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    TextView resultTextView;
    TextView Pointtextview;
    TextView sumtextview;
    TextView timertextview;
    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button playagainbutton;
    RelativeLayout gamerelativelayout;
    int locationOfCorrectAnswer;
    int score=0;
    int numberofquestions=0;

    public void playagain(View view){

        score=0;
        numberofquestions=0;
        answers.clear();
        timertextview.setText("30s");
        Pointtextview.setText("0/0");
        resultTextView.setText("");
        playagainbutton.setVisibility(View.INVISIBLE);
        generateQuestion();
        new CountDownTimer(30100,1000){


            @Override
            public void onTick(long l) {

                timertextview.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {

                playagainbutton.setVisibility(View.VISIBLE);
                timertextview.setText("0s");
                resultTextView.setText("Your Score : "+ Integer.toString(score)+"/"+Integer.toString(numberofquestions));

            }
        }.start();
    }
    public void generateQuestion(){
        Random random=new Random();
        int a = random.nextInt(21);
        int b = random.nextInt(21);
        sumtextview.setText(Integer.toString(a)+"+"+Integer.toString(b));
        locationOfCorrectAnswer=random.nextInt(4);
        int incorrectAnswer;
        answers.clear();
        for(int i=0;i<4;i++)
        {
            if(locationOfCorrectAnswer==i)
            {
                answers.add(a+b);
            }
            else {

                incorrectAnswer=random.nextInt(41);
                while (incorrectAnswer==a+b)
                {
                    incorrectAnswer=random.nextInt(41);
                }


                answers.add(incorrectAnswer);
            }
        }
        button.setText(Integer.toString(answers.get(0)));
        button2.setText(Integer.toString(answers.get(1)));
        button3.setText(Integer.toString(answers.get(2)));
        button4.setText(Integer.toString(answers.get(3)));

    }
    public void start(View view){

        startbutton.setVisibility(View.INVISIBLE);
        gamerelativelayout.setVisibility(View.VISIBLE);
        playagain(findViewById(R.id.playagainbutton));



    }
    public void chooseanswer(View view){

        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){

            score++;
            resultTextView.setText("CORRECT !");

        }
        else{

            resultTextView.setText("INCORRECT !");
        }
        numberofquestions++;
        Pointtextview.setText(Integer.toString(score)+"/"+Integer.toString(numberofquestions));
        generateQuestion();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startbutton =(Button)findViewById(R.id.startbutton);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        sumtextview=(TextView)findViewById(R.id.textView3);
        resultTextView=(TextView)findViewById(R.id.textview4);
        Pointtextview=(TextView)findViewById(R.id.textView2);
        timertextview=(TextView)findViewById(R.id.timertextView);
        playagainbutton=(Button)findViewById(R.id.playagainbutton);
        gamerelativelayout=(RelativeLayout)findViewById(R.id.gamerelativelayout);




    }
}
