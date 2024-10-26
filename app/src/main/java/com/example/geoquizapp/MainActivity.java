package com.example.geoquizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[] {
        new Question(R.string.question_oceans, true),
        new Question(R.string.question_mideast, true),
        new Question(R.string.question_africa, true),
        new Question(R.string.question_americas, true),
        new Question(R.string.question_asia, true)
    };

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionTextView = findViewById(R.id.questionTextView);
        mQuestionTextView.setText(mQuestionBank[mCurrentIndex].toString());

        mTrueButton = findViewById(R.id.trueButton);
        mTrueButton.setOnClickListener(v ->
            Toast.makeText(MainActivity.this,
                "Correct!!",
                Toast.LENGTH_SHORT).show());

        mFalseButton = findViewById(R.id.falseButton);
        mFalseButton.setOnClickListener(v ->
            Toast.makeText(MainActivity.this,
                "Incorrect!!",
                Toast.LENGTH_SHORT).show());

        mNextButton = findViewById(R.id.nextButton);
        mNextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                mCurrentIndex = mCurrentIndex % mQuestionBank.length;
                updateQuestion();
            }
        });
    }

    private void updateQuestion() {
        var question = mQuestionBank[mCurrentIndex].getmTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {

    }
}