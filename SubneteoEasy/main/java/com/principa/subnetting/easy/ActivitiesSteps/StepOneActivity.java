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

import java.util.ArrayList;
import java.util.Random;

public class StepOneActivity extends AppCompatActivity {

  private   EditText txtDatoUno;
  private Button btnRevisar;
  private TextView lblRes;
  private  EditText txtDatoEntrada;
  private TextView txtInformation5;
  private Typeface all;
  private ImageView img_btn;

    String add1;
    String add2;
    String add3; // 255.255.255.192
    String add5; // 255.255.240.0
    //String dirCinco; // 255.224.0.0

    int contador;
    int index;
    Random rand = new Random();
    //creamos arreglo de tipo cadena
    ArrayList<String> address = new ArrayList<String>();
    ArrayList<String> answer = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one);
        add1 = getString(R.string.masc_bin_p1);
        add2 = getString(R.string.mask_bin_p1);
        add3= getString(R.string.mask_bin_p2);
        add5 = getString(R.string.mask_bin_p4);
        //dirCinco = getString(R.string.mask_bin5);

        address.add(add1);
        address.add(add2);
        address.add(add3);
        address.add(add5);
        //binarias.add(dirCinco);

        answer.add(getString(R.string.first_1));
        answer.add(getString(R.string.second_1));
        answer.add(getString(R.string.third_1));
        answer.add(getString(R.string.fourth_1));
        //decimales.add("255.224.0.0");

        contador = 4;
        index=0;

        //Vincular las vistas
        txtDatoUno = findViewById(R.id.txtDatoUno);

        btnRevisar = findViewById(R.id.btnRevisar);
        txtInformation5 = findViewById(R.id.txtInformation5);
        final EditText clase = findViewById(R.id.txtDatoUno);
        txtDatoEntrada = findViewById(R.id.show);
        img_btn = findViewById(R.id.btn_back);
        index = rand.nextInt(4);


        clase.setText(address.get(index));
        clase.setEnabled(false);


        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnRevisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String datoCadena = txtDatoEntrada.getText().toString().trim();

                if (TextUtils.isEmpty(datoCadena)) {

                    Toast.makeText(StepOneActivity.this, R.string.fill_field, Toast.LENGTH_LONG).show();

                    return;
                }

                //Collections.shuffle(Arrays.asList(arreglo)); se puede utilizar en un futuro
                // para mover los lugares sin utizar random

                // while (contador < 5) {
           /*     Log.d("Tamaño de binario",""+ binarias.size());
                Log.d("Contenido Binarias ", Arrays.toString(binarias.toArray()));
                Log.d("Contenido Decimales ", Arrays.toString(decimales.toArray()));
                Log.d("indice", "" + index); */
                if(address.size() >= 1) {


                    switch (index) {
                        case 0: //adOne
                            if (datoCadena.equals(answer.get(index))) {

                                Toast.makeText(StepOneActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                txtDatoEntrada.setText("");
//                                Log.d("QUIZ ", "Correcto!!");

                            } else {

                                Toast.makeText(StepOneActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                return;
                            }
                            break;

                        case 1:
                            if (datoCadena.equals(answer.get(index))) {
                                Toast.makeText(StepOneActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                txtDatoEntrada.setText("");
                             //   Log.d("QUIZ ", "Correcto!!");

                            } else {
                                Toast.makeText(StepOneActivity.this,  R.string.its_file, Toast.LENGTH_LONG).show();
                                txtDatoEntrada.setText("");
                                return;

                            }

                            break;
                        case 2:
                            if (datoCadena.equals(answer.get(index))) {

                                Toast.makeText(StepOneActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                txtDatoEntrada.setText("");
                             //   Log.d("QUIZ ", "Correcto!!");

                            } else {
                                Toast.makeText(StepOneActivity.this,  R.string.its_file, Toast.LENGTH_LONG).show();
                                txtDatoEntrada.setText("");
                                return;


                            }
                            break;
                        case 3:
                            if (datoCadena.equals(answer.get(index))) {

                                Toast.makeText(StepOneActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                txtDatoEntrada.setText("");
                            //    Log.d("QUIZ ", "Correcto!!");
                            } else {
                                Toast.makeText(StepOneActivity.this,  R.string.its_file, Toast.LENGTH_LONG).show();
                                txtDatoEntrada.setText("");
                                return;

                            }

                            break;

                        default:

                            Toast.makeText(StepOneActivity.this, R.string.end_return, Toast.LENGTH_LONG).show();
                            //finish();

                    }

                    if (address.size() >= 1) {
                    //    Log.d("QUIZ ", "Removiendo " + index);
                        address.remove(index);
                        answer.remove(index);


                        if (address.size() == 0){
                            Toast.makeText(StepOneActivity.this, R.string.end_return, Toast.LENGTH_LONG).show();

                            return;

                        }
                        index = rand.nextInt(address.size());
                       // Log.d("QUIZ ", "GENERADO " + index);
                        clase.setText(address.get(index));

                    }

                }
            }

        });

        String fuente = "fuente/all.otf";
        this.all = Typeface.createFromAsset(getAssets(), fuente);
        txtInformation5.setTypeface(all);
        }
}
