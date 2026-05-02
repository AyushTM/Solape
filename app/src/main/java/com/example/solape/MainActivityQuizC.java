package com.example.solape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivityQuizC extends AppCompatActivity {

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
        setContentView(R.layout.activity_main_quiz_c);

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
                        Toast.makeText(MainActivityQuizC.this, "Please Select an option ", Toast.LENGTH_SHORT).show();
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
        questionsList.add(new QuestionModel("How old is Sun?", "4.603 billion years","7.008 billion years","4.16 billion years","5.302 billion years", 1));
        questionsList.add(new QuestionModel("How long does Sunlight take to reach Earth?", "5 minutes","6 minutes","7 minutes","8 minutes", 4));
        questionsList.add(new QuestionModel("The much time does Sun take to complete a rotation on its axis", "About 25 days","About 27 days","About 30 days","None", 2));
        questionsList.add(new QuestionModel("What is the temperature at the very centre of the Sun in Fahrenheit? (F)", "27 million Fahrenheit","30 million Fahrenheit","27 billion Fahrenheit","30 billion Fahrenheit", 1));
        questionsList.add(new QuestionModel("The asteroid belt is between of which two planets?", "Mercury and Venus","Earth and Mars","Mars and Jupiter","Uranus and Neptune", 3));
        questionsList.add(new QuestionModel("Pluto is?", "One third water.","Two third water.","Whole water.","None", 2));
        questionsList.add(new QuestionModel("On which day is Pluto discovered?", "February 18th in 1930","March 18th in 1930","February 28th in 1930","March 28th in 1930", 3));
    }
}