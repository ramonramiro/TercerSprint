package com.principa.subnetting.easy.ActivitiesSteps;

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

import java.util.ArrayList;
import java.util.Random;

import com.principa.subnetting.easy.R;


public class ClassExampleActivity extends AppCompatActivity {

    private EditText showAddress, enterData;
    private Button btnSubmit, btnReturn;
    private TextView freedback;
    private ImageView btn_back;

    String address1;
    String address2;
    String address3; // 255.255.255.192
    String address4; // 255.255.240.0
    String address5;

    int acco;
    int index = 5;
    Random rand = new Random();
    ArrayList<String> adrres = new ArrayList<String>();
    // ArrayList<String> adrres34 = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_clase);


        address1= "192.168.5.0/24"; //254 privada
        address2 = "10.0.0.0/8"; //	16,777,214  privada
        address3= "172.10.0.0/16"; //65,534 privada
        address4= "10.0.2.0/8"; //16,777,214 privada
        address5= "224.0.0.0/10";// 	4,194,302  publica, experimental D

        adrres.add(address1);
        adrres.add(address2);
        adrres.add(address3);
        adrres.add(address4);
        adrres.add(address5);


        acco = 5;
        index = 0;

        //Vincular vistas

//        showAddress  = findViewById(R.id.showAddress);
        enterData = findViewById(R.id.enterData);
        freedback = findViewById(R.id.freedback);
        btnSubmit = findViewById(R.id.btnSubmit);

        final EditText showStart = findViewById(R.id.showAddress);
        final TextView muestraRetro = findViewById(R.id.freedback);
        final ImageView btn_back = findViewById(R.id.btn_back);

        index = rand.nextInt(5);

        showStart.setText(adrres.get(index));
        showStart.setEnabled(false);

        muestraRetro.setText("Retroalimentación");


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String edtSubmint1 = enterData.getText().toString().trim();

                if (TextUtils.isEmpty(edtSubmint1)) {

                    Toast.makeText(ClassExampleActivity.this, R.string.fill_field, Toast.LENGTH_LONG).show();

                    return;
                }

                int temp1 = Integer.valueOf(edtSubmint1);

             //   Log.d("QUIZ ", "Muestra indice  " + index);

                if (adrres.size() >=1 ) {

                    switch (index) {
                        case 0:
                            if (temp1 <=245  ) {

                                freedback.setText(R.string.answer1);
                                Toast.makeText(ClassExampleActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                enterData.setText("");

                            } else {

                                freedback.setText(R.string.answer2);
                                Toast.makeText(ClassExampleActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                enterData.setText("");
                                // return;

                            }
                            break;

                        case 1:
                            if (temp1<=245) {

                                freedback.setText(R.string.answer3);
                                Toast.makeText(ClassExampleActivity.this, R.string.error1, Toast.LENGTH_LONG).show();
                                enterData.setText("");
                                //return;
                            } else if (temp1 >= 255 && temp1<=2500) {
                                // freedback.setText(adrres.get(index));
                                freedback.setText(R.string.answer4);
                                Toast.makeText(ClassExampleActivity.this, R.string.error2, Toast.LENGTH_LONG).show();
                                enterData.setText("");
                            } else {


                                freedback.setText(R.string.answer5);
                                Toast.makeText(ClassExampleActivity.this, R.string.answer6, Toast.LENGTH_LONG).show();
                                enterData.setText("");


                            }
                            break;
                        case 2:
                            if (temp1<=245) {

                                freedback.setText(R.string.answer7);
                                Toast.makeText(ClassExampleActivity.this, R.string.error4, Toast.LENGTH_LONG).show();
                                enterData.setText("");
                                //return;
                            } else  if (temp1 >=255 && temp1 <=2500 ){

                                freedback.setText(R.string.answer8);
                                Toast.makeText(ClassExampleActivity.this, R.string.error6, Toast.LENGTH_LONG).show();
                                enterData.setText("");
                            } else  {

                                freedback.setText(R.string.answer9);
                                Toast.makeText(ClassExampleActivity.this, R.string.error5, Toast.LENGTH_LONG).show();
                                enterData.setText("");

                            }
                            break;
                        case 3:
                            if (temp1<=245) {

                                freedback.setText(R.string.answer10);
                                Toast.makeText(ClassExampleActivity.this, R.string.answer12, Toast.LENGTH_LONG).show();
                                enterData.setText("");
                                //return;

                            } else if (temp1 >= 255 && temp1<=2500){
                                Toast.makeText(ClassExampleActivity.this, R.string.error7, Toast.LENGTH_LONG).show();

                                freedback.setText(R.string.answer13);
                                enterData.setText("");

                            } else {

                                freedback.setText(R.string.answer14);
                                Toast.makeText(ClassExampleActivity.this, R.string.error9, Toast.LENGTH_LONG).show();
                                enterData.setText("");
                            }

                            break;
                        case 4:
                            if (temp1>=1) {

                                freedback.setText(R.string.answer16);
                                Toast.makeText(ClassExampleActivity.this, R.string.error8, Toast.LENGTH_LONG).show();
                                enterData.setText("");
                                // return;
                            }
                            break;
                        default:

                            //Lg.d("mostrar retroalimentacion", "hh" + index);
                            freedback.setText(R.string.finaliz);
                            Toast.makeText(ClassExampleActivity.this, R.string.finaliz, Toast.LENGTH_LONG).show();

                            //   fileList();

                    }

                    if (adrres.size() >=1) {
                  //      Log.d("QUIZ ", "Removiendo indice  " + index);
                        adrres.remove(index);


                        if (adrres.size() == 0) {
                            Toast.makeText(ClassExampleActivity.this, R.string.finaliz, Toast.LENGTH_LONG).show();
                            return;
                        }
                        if (freedback.getTextSize() ==0) {
                            Toast.makeText(ClassExampleActivity.this, R.string.finaliz, Toast.LENGTH_LONG).show();
                            return;
                        }



                        index = rand.nextInt(adrres.size());
                        showStart.setText(adrres.get(index));
                     //   Log.d("retroalimentacion", "muestra retroalimentacion   " + index);
                        //   freedback.setText(adrres.get(index) + "");


                    }




                }


            }
        });


    }

}
