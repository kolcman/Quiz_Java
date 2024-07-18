package com.kolcman.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.kolcman.myapplication.model.Question;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private Button buttonYes;
    private Button buttonNo;
    private Button buttonNext;
    private Button buttonPrevious;
    private TextView textViewCountRightAnswer;
    private ArrayList<Question> questions = new ArrayList<>();
    private int count = 0;
    private int rightAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        questions.add(new Question("Москва столица России?", true, false));
        questions.add(new Question("Питер столица России?", false, false));
        questions.add(new Question("Амазонка самая длинная река?", true, false));
        questions.add(new Question("Байкал самое глубокое озеро?", true, false));
        questions.add(new Question("Париж столица Франции?", true, false));
        questions.add(new Question("Нью-Йорк столица США?", false, false));

        if(savedInstanceState != null){
            count = savedInstanceState.getInt("count");
            rightAnswer = savedInstanceState.getInt("rightAnswer");
        }

        textViewTitle.setText(questions.get(count).getText());

        Intent intent = getIntent();
        questions.add(new Question(
                intent.getStringExtra("textQuestion"),
                intent.getBooleanExtra("rightAnswer", false),
                intent.getBooleanExtra("answered", false)
        ));

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
        outState.putInt("rightAnswer", rightAnswer);
    }
    public void onClick(View view) {
        int id = view.getId();
        String res = "";
        if (id == R.id.buttonYes) {
            if (questions.get(count).isAnswer()) {
                res = "правильно";
                if (!questions.get(count).isAnswered()) {
                    textViewCountRightAnswer.setText(String.valueOf(++rightAnswer));
                    questions.get(count).setAnswered(true);
                }
            } else {
                res = "неправильно";
                if (!questions.get(count).isAnswered()) {
                    questions.get(count).setAnswered(true);
                }
            }
            Toast.makeText(this,
                    "Вы ответили: " + res,
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.buttonNo) {
            if (!questions.get(count).isAnswer()) {
                res = "правильно";
                if (!questions.get(count).isAnswered()) {
                    textViewCountRightAnswer.setText(String.valueOf(++rightAnswer));
                    questions.get(count).setAnswered(true);
                }
            } else {
                res = "неправильно";
                if (!questions.get(count).isAnswered()) {
                    questions.get(count).setAnswered(true);
                }
            }
            Toast.makeText(this,
                    "Вы ответили: " + res,
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.buttonNext) {
            count++;
            if (count == questions.size()) {
                count = 0;
            }
            textViewTitle.setText(questions.get(count).getText());
        } else if (id == R.id.buttonPrevious) {
            count--;
            if (count < 0) {
                count = questions.size() - 1;
            }
            textViewTitle.setText(questions.get(count).getText());
        } else if (id == R.id.buttonAddQuestion) {
            launchNextScreen();
        }
    }
    private void initViews() {
        textViewTitle = findViewById(R.id.textViewTitle);
        buttonYes = findViewById(R.id.buttonYes);
        buttonNo = findViewById(R.id.buttonNo);
        buttonNext = findViewById(R.id.buttonNext);
        buttonPrevious = findViewById(R.id.buttonPrevious);
        textViewCountRightAnswer = findViewById(R.id.textViewCountRightAnswer);
    }
    public static Intent newIntent(Context context, String textQuestion, boolean rightAnswer, boolean answered) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("textQuestion", textQuestion);
        intent.putExtra("rightAnswer", rightAnswer);
        intent.putExtra("answered", answered);
        return intent;
    }
    private void launchNextScreen() {
        Intent intent = CreateQuestionsActivity.newIntent(this);
        startActivity(intent);
    }


}