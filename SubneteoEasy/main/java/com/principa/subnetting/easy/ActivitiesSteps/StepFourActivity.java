package com.principa.subnetting.easy.ActivitiesSteps;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.principa.subnetting.easy.R;

public class StepFourActivity extends AppCompatActivity {

    private Button btnShow, btnShow2, btnShow3, btnShow4, btnSubmit, btnSubmit2, btnSubmit3, btnSubmit4;
    private TextView txtAnswer, txtAnswer2, txtAnswer3, txtAnswer4, txt1, txt2, txt3, txt4, txt5;
    private EditText edtBox1, edtBox2, edtBox3, edtBox4, edtBox5, edtBox6, edtBox7, edtBox8 ;
    private Typeface all;
    private ImageView btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_four);

        btnShow = findViewById(R.id.btnShow);
        btnSubmit = findViewById(R.id.btnSubmit);
        edtBox1 = findViewById(R.id.edtBox1);
        edtBox2 = findViewById(R.id.edtBox2);
        txtAnswer = findViewById(R.id.txtAnswer);

        btnSubmit2 = findViewById(R.id.btnSubmit2);
        btnShow2 = findViewById(R.id.btnShow2);
        edtBox3 = findViewById(R.id.edtBox3);
        edtBox4 = findViewById(R.id.edtBox4);
        txtAnswer2 = findViewById(R.id.txtAnswer2);

        btnSubmit3 = findViewById(R.id.btnSubmit3);
        btnShow3 = findViewById(R.id.btnShow3);
        edtBox5 = findViewById(R.id.edtBox5);
        edtBox6 = findViewById(R.id.edtBox6);
        txtAnswer3 = findViewById(R.id.txtAnswer3);

        btnSubmit4 = findViewById(R.id.btnSubmit4);
        btnShow4 =findViewById(R.id.btnShow4);
        edtBox7 = findViewById(R.id.edtBox7);
        edtBox8 = findViewById(R.id.edtBox8);
        txtAnswer4 = findViewById(R.id.txtAnswer4);
        btn_back = findViewById(R.id.btn_back);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String box1 = edtBox1.getText().toString().trim();
                String box2 = edtBox2.getText().toString().trim();

                if (TextUtils.isEmpty(box1) || TextUtils.isEmpty(box2)) {
                    Toast.makeText(StepFourActivity.this, R.string.validation_two, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (box1.equals("00000000") && box2.equals("00000000")) {
                    Toast.makeText(StepFourActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                    edtBox1.setText("");
                    edtBox2.setText("");
                } else {
                    Toast.makeText(StepFourActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                    edtBox1.setText("");
                    edtBox2.setText("");
                }

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAnswer.setText("190.30.00000000.00000000");
                Toast.makeText(StepFourActivity.this, R.string.answer, Toast.LENGTH_LONG).show();


            }
        });

        btnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String box3 = edtBox3.getText().toString().trim();
                String box4 = edtBox4.getText().toString().trim();

                if (TextUtils.isEmpty(box3) || TextUtils.isEmpty(box4)) {
                    Toast.makeText(StepFourActivity.this, R.string.answer, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (box3.equals("00000000") && box4.equals("00000001")) {
                    Toast.makeText(StepFourActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                    edtBox3.setText("");
                    edtBox4.setText("");
                } else {
                    Toast.makeText(StepFourActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                    edtBox3.setText("");
                    edtBox4.setText("");
                }
            }
        });

        btnShow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAnswer2.setText("190.30.00000000.00000001");
                Toast.makeText(StepFourActivity.this, R.string.answer, Toast.LENGTH_LONG).show();
            }
        });

        btnSubmit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String box5 = edtBox5.getText().toString().trim();
                String box6 = edtBox6.getText().toString().trim();

                if (TextUtils.isEmpty(box5) || TextUtils.isEmpty(box6)) {
                    Toast.makeText(StepFourActivity.this, R.string.validation_two, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (box5.equals("00000001") && box6.equals("11111110")) {
                    Toast.makeText(StepFourActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                    edtBox5.setText("");
                    edtBox6.setText("");
                } else {
                    Toast.makeText(StepFourActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                    edtBox5.setText("");
                    edtBox6.setText("");
                }
            }
        });

        btnShow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAnswer3.setText("190.30.00000001.11111110");
                Toast.makeText(StepFourActivity.this, R.string.answer, Toast.LENGTH_LONG).show();
            }
        });

        btnSubmit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String box7 = edtBox7.getText().toString().trim();
                String box8 = edtBox8.getText().toString().trim();

                if (TextUtils.isEmpty(box7) || TextUtils.isEmpty(box8)) {
                    Toast.makeText(StepFourActivity.this, R.string.validation_two, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (box7.equals("00000001") && box8.equals("11111111")) {
                    Toast.makeText(StepFourActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                    edtBox7.setText("");
                    edtBox8.setText("");
                } else {
                    Toast.makeText(StepFourActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                    edtBox7.setText("");
                    edtBox8.setText("");
                }
            }
        });

        btnShow4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAnswer4.setText("190.30.00000001.11111111");
                Toast.makeText(StepFourActivity.this,  R.string.answer, Toast.LENGTH_LONG).show();
            }
        });

        String fuente = "fuente/all.otf";
        this.all = Typeface.createFromAsset(getAssets(), fuente);
        txt1.setTypeface(all);
        txt2.setTypeface(all);
        txt3.setTypeface(all);
        txt4.setTypeface(all);
        txt5.setTypeface(all);

    }

}
