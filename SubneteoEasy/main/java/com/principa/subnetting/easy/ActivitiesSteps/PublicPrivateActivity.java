package com.principa.subnetting.easy.ActivitiesSteps;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.principa.subnetting.easy.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PublicPrivateActivity extends AppCompatActivity {

    private EditText txtDatoUno;
    private Button btnChek;
    private TextView lblRes, txtInfortation3;
    private  EditText txtDataEntry;
    private ImageView imgReturn1;
    private Typeface all;

    String addres1;
    String addres2;
    String addres3; // 255.255.255.192
    String addres4; // 255.255.240.0
    String dirCinco; // 255.224.0.0

    int contador;
    int index;
    Random rand = new Random();
    //creamos arreglo de tipo cadena
    ArrayList<String> addres = new ArrayList<String>();
    ArrayList<String> answers = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_private);
        addres1 = getString(R.string.priv1); // privada
        addres2 = getString(R.string.priv2); //	privada
        addres3= getString(R.string.priv3); ///privada
        addres4 = getString(R.string.public1); //publica
        dirCinco = getString(R.string.public2);  //publica

        addres.add(addres1);
        addres.add(addres2);
        addres.add(addres3);
        addres.add(addres4);
        addres.add(dirCinco);

        answers.add(getString(R.string.ans1));
        answers.add(getString(R.string.ans2));
        answers.add(getString(R.string.ans3));
        answers.add(getString(R.string.ans4));
        answers.add(getString(R.string.ans5));

        contador = 5;
        index=0;

        //Vincular las vistas
        txtDatoUno = findViewById(R.id.txtDatoUno);
        final EditText clase=findViewById(R.id.txtDatoUno);

        btnChek = findViewById(R.id.btnRevisar);
        txtDataEntry =findViewById(R.id.show);
        imgReturn1 = findViewById(R.id.imgReturn1);
        txtInfortation3= findViewById(R.id.txtInfortation3);

        index = rand.nextInt(5);

        clase.setText(addres.get(index));
        clase.setEnabled(false);

imgReturn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        finish();
    }
});
        btnChek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String datoCadena = txtDataEntry.getText().toString().trim();

                if (TextUtils.isEmpty(datoCadena)) {

                    Toast.makeText(PublicPrivateActivity.this, R.string.fill_field, Toast.LENGTH_LONG).show();

                    return;
                }

                //Collections.shuffle(Arrays.asList(arreglo)); se puede utilizar en un futuro
                // para mover los lugares sin utizar random

                // while (contador < 5) {
              /*  Log.d("Tamaño de binario",""+ addres.size());
                Log.d("Contenido Binarias ", Arrays.toString(addres.toArray()));
                Log.d("Contenido Decimales ", Arrays.toString(answers.toArray()));
                Log.d("indice", "" + index); */
                if(addres.size() >= 1) {


                    switch (index) {
                        case 0: //adOne
                            if (datoCadena.equals(answers.get(index))) {

                                Toast.makeText(PublicPrivateActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                txtDataEntry.setText("");
                                //Log.d("QUIZ ", "Correcto!!");

                            } else {

                                Toast.makeText(PublicPrivateActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                return;
                            }
                            break;

                        case 1:
                            if (datoCadena.equals(answers.get(index))) {
                                Toast.makeText(PublicPrivateActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                txtDataEntry.setText("");
                              //  Log.d("QUIZ ", "Correcto!!");

                            } else {
                                Toast.makeText(PublicPrivateActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                txtDataEntry.setText("");
                                return;

                            }

                            break;
                        case 2:
                            if (datoCadena.equals(answers.get(index))) {

                                Toast.makeText(PublicPrivateActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                txtDataEntry.setText("");
                            //    Log.d("QUIZ ", "Correcto!!");

                            } else {
                                Toast.makeText(PublicPrivateActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                txtDataEntry.setText("");
                                return;


                            }
                            break;
                        case 3:
                            if (datoCadena.equals(answers.get(index))) {

                                Toast.makeText(PublicPrivateActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                txtDataEntry.setText("");
                          //      Log.d("QUIZ ", "Correcto!!");
                            } else {
                                Toast.makeText(PublicPrivateActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                txtDataEntry.setText("");
                                return;

                            }

                            break;
                        case 4:
                            if (datoCadena.equals(answers.get(index))) {
                                txtDataEntry.setText("");
                                Toast.makeText(PublicPrivateActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                        //        Log.d("QUIZ ", "Correcto!!");

                            } else {
                                Toast.makeText(PublicPrivateActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                txtDataEntry.setText("");
                                return;
                            }

                            break;

                        default:

                            Toast.makeText(PublicPrivateActivity.this,R.string.end_return, Toast.LENGTH_LONG).show();

                    }

                    if (addres.size() >= 1) {
                    //    Log.d("QUIZ ", "Removiendo " + index);
                        addres.remove(index);
                        answers.remove(index);

                        if (addres.size() == 0){
                            Toast.makeText(PublicPrivateActivity.this, R.string.end_return, Toast.LENGTH_LONG).show();
                            return;
                        }
                        index = rand.nextInt(addres.size());
                      //  Log.d("QUIZ ", "GENERADO " + index);
                        clase.setText(addres.get(index));


                    }
                }
            }
            //contador--;
            // }
        });

        String fuente = "fuente/all.otf";
        this.all = Typeface.createFromAsset(getAssets(), fuente);
        txtInfortation3.setTypeface(all);
        txtDatoUno.setTypeface(all);
    }
}

