package com.principa.subnetting.easy.ActivitiesGames;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.principa.subnetting.easy.R;

import java.util.Random;

public class ToPlayActivity extends AppCompatActivity {

    private TextView points,account,lives,txtCorrect,txtIncorrect;
    private ImageView image;
    private EditText txtEdit;
    private  Button btnConfirm;
    String[] answers_name={"8","24","16","0 a 127","255.0.0.0","255.255.0.0","255.255.255.0","CIDR","VLSM","24","8","16"};
    String[] answers_name_two={"8","24","16","0-127","255.0.0.0","255.255.0.0","255.255.255.0","cidr","vlsm","24","8","16"};
    String[] questions_image={"img1","img2","img3","img4","img5","img6","img7","img8","img9","img10","img11","img12"};


    int intPoints = 0;
    int intLives=3;
    int generatedNumber=0;
    int accou=0;


    int [] images_seen = new int[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        txtCorrect = findViewById(R.id.txtcorrecto);
        txtIncorrect =  findViewById(R.id.txtincorrecto);

        points = findViewById(R.id.txtPoints);
        lives = findViewById(R.id.txtLives);
        account = findViewById(R.id.txtCount);
        image = findViewById(R.id.imgImage);
        txtEdit = findViewById(R.id.txtedit);
        btnConfirm = findViewById(R.id.btnConfirm);

        Random aleatorio = new Random(System.currentTimeMillis());
        generatedNumber = aleatorio.nextInt(12);
        aleatorio.setSeed(System.currentTimeMillis());
        init();

        images_seen[accou]= generatedNumber;
        //Log.d("GENERADO", ""+ numerogenerado);
        //Log.d("CONTADOR", ""+ cont);

        establecer_imagen(generatedNumber);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (accou < 12) {
                    String textoconfirmar = txtEdit.getText().toString().toLowerCase();
                    if (textoconfirmar.equals(answers_name[generatedNumber]) | textoconfirmar.equals(answers_name_two[generatedNumber])) {
                        txtCorrect.setVisibility(View.VISIBLE);
                        intPoints = intPoints + 1;
                        points.setText(getString(R.string.points_text) + intPoints);
                        accou++;
                       // Log.d("correcto contador", "" + accou);
                        if (accou == 12) {
                            Toast.makeText(ToPlayActivity.this, R.string.finish_toplay, Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        esperar1();
                    } else {
                        //Log.d("incorrecto contador", "" + accou);
                        txtIncorrect.setVisibility(View.VISIBLE);
                        intLives = intLives - 1;
                        images_seen[accou] = 0;
                        lives.setText(getString(R.string.lives_txt) + intLives);
                        esperar2();
                    }
                    if (intLives == 0) {
                        finish();
                    }


                }else{
                    Toast.makeText(ToPlayActivity.this, R.string.finish_toplay, Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

    void esperar2(){
        new CountDownTimer(2000,1) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnConfirm.setVisibility(View.GONE);
            }
            @Override
            public void onFinish() {
                btnConfirm.setVisibility(View.VISIBLE);
                txtIncorrect.setVisibility(View.INVISIBLE);
                txtEdit.setText("");
                txtEdit.setHint(R.string.enter_correct);
            }
        }.start();
    }

    void esperar1(){


        new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                account.setText(""+(millisUntilFinished/1000 +1));
                btnConfirm.setVisibility(View.GONE);
            }

            @Override
            public void onFinish() {
                btnConfirm.setVisibility(View.VISIBLE);
                //numerogenerado=numerogenerado+1;
                account.setText("");
                boolean isEncontrado = false;


                do {
                    isEncontrado = false;
                    Random aleatorio = new Random(System.currentTimeMillis());
                    generatedNumber = aleatorio.nextInt(12);
                    aleatorio.setSeed(System.currentTimeMillis());
                 //   Log.d("GENERADO WHILE ", "" + generatedNumber);
                   // Log.d("CONTADOR ", "" + accou);

                    if (accou > 0) {
                        for (int idx = 0; idx < accou; idx++) {
                            print();
                            if (images_seen[idx] == generatedNumber) {
                                isEncontrado = true;
                     //           Log.d("ENCONTRADO ", "" + generatedNumber);
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                } while (isEncontrado == true);

                //Log.d("GENERADO", "" + generatedNumber);

                establecer_imagen(generatedNumber);
                images_seen[accou] = generatedNumber;
                txtCorrect.setVisibility(View.INVISIBLE);
                txtEdit.setText("");
                txtEdit.setHint(R.string.enter_correct);

            }
        }.start();

    }


    void init() {

        for (int i=0; i < images_seen.length; i++){
            images_seen[i] = -1;
        }

    }
    void print() {
        String val="";
        for (int i=0; i < images_seen.length; i++){
            val += images_seen[i] + "-";
        }
   //     Log.d("array ", val);
    }

    void establecer_imagen(int numero){
        int id = getResources().getIdentifier(questions_image[numero], "mipmap", getPackageName());
        image.setImageResource(id);
    }
}
