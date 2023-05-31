package com.example.driodquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DeceitActivity extends AppCompatActivity {
private boolean mAnswerIsTrue;
private TextView mAnswerTextView;
private Button mShowAnswer;

    public  static final String Extra_Answer_IS_TRUE = "ru.rsue.android.driodquest.answer_is_true";
    public  static final String Extra_Answer_IS_Show = "ru.rsue.android.driodquest.answer_shown";

    public static Intent newIntent (Context packageContext, boolean answerIsTrue){
        Intent i = new Intent(packageContext, DeceitActivity.class);
        i.putExtra(Extra_Answer_IS_TRUE,answerIsTrue);
        return i;
    }
    public static boolean wasAnswerShown(Intent result){
        return  result.getBooleanExtra(Extra_Answer_IS_Show, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deceit);
        mAnswerIsTrue= getIntent().getBooleanExtra(Extra_Answer_IS_TRUE,false);

        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);
        mShowAnswer = (Button) findViewById(R.id.show_answer_button);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_button);

                }else{
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShowResult(true);
            }
        });
    }
    private void setAnswerShowResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(Extra_Answer_IS_Show, isAnswerShown);
        setResult(RESULT_OK,data);
    }
}