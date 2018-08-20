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

public class StepTwoActivity extends AppCompatActivity {

    private EditText edtSubmint, edtAddress;
    //  private TextView edtShowBits;
    private Button btnSubmit;
    private Typeface all;
    private ImageView imvReturn;
    private TextView texInformation, texInformation1;
    int valor = 1;
    final String  addOne = ("190.30.0.0");
    private ImageView btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_two);

        // edtShowBits = findViewById(R.id.edtShowBits);
        texInformation1= findViewById(R.id.texInformation1);
        texInformation= findViewById(R.id.texInformation);
        edtSubmint = findViewById(R.id.edtSubmint);
        edtAddress = findViewById(R.id.edtAddress);
        btnSubmit = findViewById(R.id.btnSubmit);

        btn_back = findViewById(R.id.btn_back);

        final EditText viewBegan = findViewById(R.id.edtAddress);
        // final TextView utilizar = findViewById(R.id.edtShowBits);

        viewBegan.setText(addOne);
        // utilizar.setText();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String edtSubmint1 = edtSubmint.getText().toString().trim();

                if (TextUtils.isEmpty(edtSubmint1)) {

                    Toast.makeText(StepTwoActivity.this, R.string.fill_field, Toast.LENGTH_LONG).show();

                    return;
                }

                int temp1 = Integer.valueOf(edtSubmint1);


                if (temp1 <= 1) {

                    Toast.makeText(StepTwoActivity.this, R.string.error_1, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");
                    return;




                } else if (temp1 == 2) {


                    Toast.makeText(StepTwoActivity.this, R.string.bit_1, Toast.LENGTH_LONG).show();

                    edtSubmint.setText("");
                    return;


                    //  valor = 1;


                    //String valor = null;


                }else if (temp1 <= 4) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_2, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                }
                else if (temp1 <= 8) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_3, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");
                }

                else if (temp1 <= 16) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_4, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");
                }

                else if (temp1 <= 32) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_5, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");
                }

                else if (temp1 <= 69) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_6, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");
                }

                else if (temp1 <= 128) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_7, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");
                }

                else if (temp1 <= 256) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_8, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");
                }

                else if (temp1 <= 512) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_9, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                }else if (temp1 <= 1024) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_10, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                }else if (temp1 <= 2048) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_11, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                } else if (temp1 <= 4096) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_12, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                } else if (temp1 <= 8192) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_13, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                } else if (temp1 <= 16384) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_14, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                } else if (temp1 > 16384) {
                    Toast.makeText(StepTwoActivity.this, R.string.error_a, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                }
            }
        });


        String fuente = "fuente/all.otf";
        this.all = Typeface.createFromAsset(getAssets(), fuente);
        texInformation.setTypeface(all);
        edtAddress.setTypeface(all);
        texInformation1.setTypeface(all);
    }
}
