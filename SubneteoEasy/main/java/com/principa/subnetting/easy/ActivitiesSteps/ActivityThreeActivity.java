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

public class ActivityThreeActivity extends AppCompatActivity {

    private EditText txtDataOne;
    private   Button btnCheck;
    private   TextView lblRes, txtText;
    private EditText txtEntryData;
    private  Typeface all;
    private ImageView btn_back;
    String adOne;
    String adTwo;
     String adThree;// 255.255.255.192
     String adFour; // 255.255.240.0
    String adFive; // 255.224.0.0

    int account;
    int index;
    Random rand = new Random();
    //creamos arreglo de tipo cadena
    ArrayList<String> binary = new ArrayList<String>();
    ArrayList<String> decimals = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        adOne = getString(R.string.masc_bin_1); // 255.255.0.0
        adTwo = getString(R.string.mask_bin_2); //	255.128.0.0
        adThree= getString(R.string.mask_bin_3);
        adFour = getString(R.string.mask_bin_4);
       adFive = getString(R.string.mask_bin5);

        binary.add(adOne);
        binary.add(adTwo);
        binary.add(adThree);
        binary.add(adFour);
        binary.add(adFive);

        decimals.add(getString(R.string.first));
        decimals.add(getString(R.string.second));
        decimals.add(getString(R.string.third));
        decimals.add(getString(R.string.fourth));
        decimals.add(getString(R.string.fifth));

        account = 5;
        index=0;

        //Vincular las vistas
        txtDataOne = (EditText) findViewById(R.id.txtDatoUno);
        txtText = findViewById(R.id.txtText);
        final EditText clase=(EditText) findViewById(R.id.txtDatoUno);

        btnCheck = (Button)findViewById(R.id.btnRevisar);
        txtEntryData =(EditText)findViewById(R.id.show);

        btn_back = findViewById(R.id.btn_back);

        index = rand.nextInt(5);

        clase.setText(binary.get(index));
        clase.setEnabled(false);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String datoCadena = txtEntryData.getText().toString().trim();

                if (TextUtils.isEmpty(datoCadena)) {

                    Toast.makeText(ActivityThreeActivity.this, R.string.fill_field, Toast.LENGTH_LONG).show();

                    return;
                }

               // while (contador < 5) {
              /*  Log.d("Tamaño de binario",""+ binary.size());
                Log.d("Contenido Binarias ", Arrays.toString(binary.toArray()));
                Log.d("Contenido Decimales ", Arrays.toString(decimals.toArray()));
                Log.d("indice", "" + index); */
                if(binary.size() >= 1) {


                    switch (index) {
                        case 0: //adOne
                            if (datoCadena.equals(decimals.get(index))) {

                                Toast.makeText(ActivityThreeActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                txtEntryData.setText("");
                            //    Log.d("QUIZ ", "Correcto!!");

                            } else {

                                Toast.makeText(ActivityThreeActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                return;
                            }
                            break;

                        case 1:
                            if (datoCadena.equals(decimals.get(index))) {
                                Toast.makeText(ActivityThreeActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                txtEntryData.setText("");
                           //     Log.d("QUIZ ", "Correcto!!");

                            } else {
                                Toast.makeText(ActivityThreeActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                txtEntryData.setText("");
                                return;

                            }

                            break;
                        case 2:
                            if (datoCadena.equals(decimals.get(index))) {

                                Toast.makeText(ActivityThreeActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                txtEntryData.setText("");
                                //Log.d("QUIZ ", "Correcto!!");

                            } else {
                                Toast.makeText(ActivityThreeActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                txtEntryData.setText("");
                                return;


                            }
                            break;
                        case 3:
                            if (datoCadena.equals(decimals.get(index))) {

                                Toast.makeText(ActivityThreeActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                txtEntryData.setText("");
                            //   Log.d("QUIZ ", "Correcto!!");
                            } else {
                                Toast.makeText(ActivityThreeActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                txtEntryData.setText("");
                                return;

                            }

                            break;
                        case 4:
                            if (datoCadena.equals(decimals.get(index))) {
                                txtEntryData.setText("");
                                Toast.makeText(ActivityThreeActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                            //    Log.d("QUIZ ", "Correcto!!");

                            } else {
                                Toast.makeText(ActivityThreeActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                txtEntryData.setText("");
                                return;
                            }

                            break;

                        default:

                            Toast.makeText(ActivityThreeActivity.this, R.string.end_return, Toast.LENGTH_LONG).show();

                    }

                    if (binary.size() >= 1) {
                    //    Log.d("QUIZ ", "Removiendo " + index);
                        binary.remove(index);
                        decimals.remove(index);

                        if (binary.size() == 0){
                            Toast.makeText(ActivityThreeActivity.this,R.string.end_return, Toast.LENGTH_LONG).show();
                            return;

                        }
                        index = rand.nextInt(binary.size());
                      //  Log.d("QUIZ ", "GENERADO " + index);
                        clase.setText(binary.get(index));

                    }
                }
                }

        });

        String fuente = "fuente/all.otf";
        this.all = Typeface.createFromAsset(getAssets(), fuente);
        txtText.setTypeface(all);
    }
}

