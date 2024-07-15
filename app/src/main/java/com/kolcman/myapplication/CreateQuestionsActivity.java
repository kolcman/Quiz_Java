package com.kolcman.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateQuestionsActivity extends AppCompatActivity {

    private EditText editTextInputQuestion;
    private RadioButton radioButtonTrue;
    private RadioButton radioButtonFalse;
    private Button buttonSaveQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_questions);
        initViews();

        buttonSaveQuestion.setOnClickListener(v -> {
            String questionText = "";
            boolean rightAnswer;
            boolean answered;
            if (editTextInputQuestion.getText().toString().isEmpty()) {
                Toast.makeText(this,
                        R.string.empty_question_toast,
                        Toast.LENGTH_SHORT).show();
            } else if (!radioButtonTrue.isChecked() && !radioButtonFalse.isChecked()) {
                Toast.makeText(this,
                        R.string.empty_radio_toast,
                        Toast.LENGTH_SHORT).show();
            } else if (radioButtonTrue.isChecked()) {
                questionText = editTextInputQuestion.getText().toString();
                launchNextScreen(questionText, true, false);
            } else if (radioButtonFalse.isChecked()) {
                questionText = editTextInputQuestion.getText().toString();
                launchNextScreen(questionText, false, false);
            }
        });

    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, CreateQuestionsActivity.class);
        return intent;
    }

    private void launchNextScreen(String questionText, boolean rightAnswer, boolean answered) {
        Intent intent = MainActivity.newIntent(this, questionText, rightAnswer, answered);
        startActivity(intent);
    }

    private void initViews() {
        editTextInputQuestion = findViewById(R.id.editTextInputQuestion);
        radioButtonTrue = findViewById(R.id.radioButtonTrue);
        radioButtonFalse = findViewById(R.id.radioButtonFalse);
        buttonSaveQuestion = findViewById(R.id.buttonSaveQuestion);
    }
}