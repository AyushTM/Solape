package com.example.solape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivityQuizT extends AppCompatActivity {

    private TextView tvQuestion, tvScore, tvQuestionNo;
    private RadioGroup radiogroup;
    private RadioButton rb1, rb2, rb3, rb4;
    private Button btnNext;

    int totalQuestions;
    int qCounter = 0;
    int score;

    ColorStateList dfRbColor;
    boolean answered;

    private QuestionModel currentQuestion;

    private List<QuestionModel> questionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz_t);

        questionsList = new ArrayList<>();

        tvQuestion = findViewById(R.id.tvQuestion);
        tvScore = findViewById(R.id.tvScore);
        tvQuestionNo = findViewById(R.id.tvQuestionNo);

        radiogroup = findViewById(R.id.radiogroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        btnNext = findViewById(R.id.btnNext);

        dfRbColor = rb1.getTextColors();


        addQuestions();
        totalQuestions = questionsList.size();
        showNextQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answered == false){
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                        checkAnswer();
                    }else{
                        Toast.makeText(MainActivityQuizT.this, "Please Select an option ", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    showNextQuestion();
                }
            }
        });

    }

    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(radiogroup.getCheckedRadioButtonId());
        int answerNo = radiogroup.indexOfChild(rbSelected) + 1;
        if (answerNo == currentQuestion.getCorrectAnsNo()){
            score++;
            tvScore.setText("Score: "+score);
        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        switch (currentQuestion.getCorrectAnsNo()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                break;
        }
        if (qCounter < totalQuestions){
            btnNext.setText("Next");
        }else {
            btnNext.setText("Finish");
        }
    }

    private void showNextQuestion() {

        radiogroup.clearCheck();
        rb1.setTextColor(dfRbColor);
        rb2.setTextColor(dfRbColor);
        rb3.setTextColor(dfRbColor);
        rb4.setTextColor(dfRbColor);


        if (qCounter<totalQuestions){



            currentQuestion = questionsList.get(qCounter);
            tvQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            qCounter++;
            btnNext.setText("Submit");
            tvQuestionNo.setText("Question: "+qCounter+"/"+totalQuestions);
            answered = false;

        }else {
            finish();
        }
    }



    private void addQuestions() {
        questionsList.add(new QuestionModel("There are how many Terrestrial planets?", "2","3","4","5", 3));
        questionsList.add(new QuestionModel("How many days Earth takes to travel around the sun?", "365","687","255","88", 1));
        questionsList.add(new QuestionModel("Which is the biggest Terrestrial planet?", "Mars","Venus","Earth","Mercury", 3));
        questionsList.add(new QuestionModel("Which is the hottest Terrestrial planet?", "Mercury","Venus","Earth","Mars", 2));
        questionsList.add(new QuestionModel("how much distance from mercury to the sun?", "108 million km","58 million km","246.31 million km","149.9 million km", 2));
        questionsList.add(new QuestionModel("Which Terrestrial planet has shortest orbit?", "Mercury","Venus","Earth","Mars", 1));
        questionsList.add(new QuestionModel("Which planet was formed approximately 4.54 billion years ago?", "Mercury","Venus","Earth","Mars", 3));
        questionsList.add(new QuestionModel("Which planet is only planet that has life?", "Mercury","Venus","Earth","Mars", 3));
        questionsList.add(new QuestionModel("which planet is most similar in size to earth?", "Mercury","Venus","Earth","Mars", 2));
        questionsList.add(new QuestionModel("Terrestrial planets are made of which material?", "Rockey and Solid material","Gases","Ice","None", 1));
    }

}