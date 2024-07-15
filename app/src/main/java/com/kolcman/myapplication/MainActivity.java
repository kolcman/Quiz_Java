package com.kolcman.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.kolcman.myapplication.model.Question;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private Button buttonYes;
    private Button buttonNo;
    private Button buttonNext;
    private Button buttonPrevious;
    private ArrayList<Question> questions;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        count = 0;

        questions = new ArrayList<>();
        questions.add(new Question("Москва столица России?", true));
        questions.add(new Question("Питер столица России?", false));
        questions.add(new Question("Амазонка самая длинная река?", true));
        questions.add(new Question("Байкал самое глубокое озеро?", true));

        textViewTitle.setText(questions.get(count).getText());
    }

    public void onClick(View view) {
        int id = view.getId();
        String res = "";
        if(id == R.id.buttonYes){
            if(questions.get(count).isAnswer()){
                res = "правильно";
            }
            else {
                res = "неправильно";
            }
            Toast.makeText(this,
                    "Вы ответили: " + res,
                    Toast.LENGTH_LONG).show();
        } else if (id == R.id.buttonNo) {
            Toast.makeText(this,
                    "Вы ответили: " + res,
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.buttonNext) {

        } else if (id == R.id.buttonPrevious) {

        }
    }

    private void initViews() {
        textViewTitle = findViewById(R.id.textViewTitle);
        buttonYes = findViewById(R.id.buttonYes);
        buttonNo = findViewById(R.id.buttonNo);
        buttonNext = findViewById(R.id.buttonNext);
        buttonPrevious = findViewById(R.id.buttonPrevious);
    }
}