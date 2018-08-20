package com.principa.subnetting.easy.ActivitiesGames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.principa.subnetting.easy.R;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private int ids_answers[] = {
            R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4
    };


    int questionFirst = 0;
    int count = 0;


    private int correct_answer;
    private int current_question;
    private String[] all_questions;
    private boolean[] answer_is_correct;
    private int[] answer;
    private TextView text_question;
    private RadioGroup group;
    private Button btn_next, btn_prev;

    int [] preguntas_contestadas = new int[4];

    private int generaPregunta() {
        int valor;
        boolean isEncontrado = false;
        do {
            isEncontrado =false;
            Random aleatorio = new Random(System.currentTimeMillis());
            aleatorio.setSeed(System.currentTimeMillis());
            valor = aleatorio.nextInt(5);
            for(int i =0; i < answer.length; i++) {
                if (answer[i]==valor){
                    isEncontrado = true;
                    break;
                }
            }
        } while(isEncontrado);
        count++;
        return  valor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        text_question =  findViewById(R.id.text_question);
        group = findViewById(R.id.answer_group);
        btn_next = findViewById(R.id.btn_check);
        btn_prev = findViewById(R.id.btn_prev);

        init();
        preguntas_contestadas[questionFirst] = current_question;

        //Carga preguntas
        all_questions = getResources().getStringArray(R.array.all_questions);
        //Inicializa respuestas correctas
        answer_is_correct = new boolean[all_questions.length];
        answer = new int[all_questions.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }
        showQuestion();
        printlog();
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  Log.d("Contador", count+"");
                if (count<=5) {
                    checkAnswer();
                    current_question = generaPregunta();
                    showQuestion();
                }
                else{
                    Toast.makeText(QuizActivity.this, R.string.finish_question , Toast.LENGTH_LONG).show();
                    int correctas = 0, incorrectas = 0;
                    for (boolean b : answer_is_correct) {
                        if (b) correctas++;
                        else incorrectas++;
                    }
                    String resultado =
                            String.format(Locale.getDefault(), getString(R.string.correct_answer), correctas, incorrectas);

                    Toast.makeText(QuizActivity.this, resultado, Toast.LENGTH_LONG).show();

                    finish();
                }
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                if (current_question > 0) {
                    current_question--;
                    showQuestion();
                }
            }
        });
    }

    private void checkAnswer() {
        int id = group.getCheckedRadioButtonId();
        int ans = -1;
        for (int i = 0; i < ids_answers.length; i++) {
            if (ids_answers[i] == id) {
                ans = i;
            }
        }
        answer_is_correct[current_question] = (ans == correct_answer);
        answer[current_question] = ans;
        printlog();
    }

    private void printlog(){
       /* Log.d("LOG Count ", count+"");
        Log.d("LOG Current Question", current_question+"");
        Log.d("LOG All Questions", Arrays.toString(all_questions)+"");
        Log.d("LOG Answer", Arrays.toString(answer)+"");
        Log.d("LOG Answer is correct", Arrays.toString(answer_is_correct)+"");*/
    }

    private void showQuestion() {

        current_question = generaPregunta();

        String q = all_questions[current_question];
        String[] parts = q.split(";");

        group.clearCheck();

        text_question.setText(count+" " +parts[0]);

        for (int i = 0; i < ids_answers.length; i++) {
            RadioButton rb = findViewById(ids_answers[i]);
            String ans = parts[i + 1];
            if (ans.charAt(0) == '*') {
                correct_answer = i;
                ans = ans.substring(1);
            }
            rb.setText(ans);
        }
    }

    void init() {

        for (int i = 0; i < preguntas_contestadas.length; i++) {
            preguntas_contestadas[i] = -1;
        }

    }
}
