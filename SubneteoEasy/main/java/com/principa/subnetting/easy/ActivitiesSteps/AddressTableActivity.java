package com.principa.subnetting.easy.ActivitiesSteps;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.principa.subnetting.easy.R;

public class AddressTableActivity extends AppCompatActivity {

    char classAdd = 'A';
    private EditText txtclass, txtRange, txtMas, txtPrefix, txtBits;
    private Button btnAdd;
    private TextView txtInfortation, texInfortation2;
    private Typeface all;
    private ImageView imgReturn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress_table);
        txtInfortation = findViewById(R.id.txtInfortation);
        texInfortation2 = findViewById(R.id.texInfortation2);
        final EditText clas = findViewById(R.id.txtClass);
        final EditText range = findViewById(R.id.txtRange);
        final EditText mask = findViewById(R.id.txtMas);
        final EditText bits = findViewById(R.id.txtBits);
        final EditText prefix = findViewById(R.id.txtPrefix);
        imgReturn = findViewById(R.id.imgReturn);


        clas.setText("" + classAdd);
        clas.setEnabled(false);

imgReturn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        finish();
    }
});
        Button add = findViewById(R.id.btnAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String rangeChain = range.getText().toString().trim();
                String maskChain = mask.getText().toString().trim();
                String bitsChain = bits.getText().toString().trim();
                String prefixChain = prefix.getText().toString().trim();

                if (TextUtils.isEmpty(rangeChain) || TextUtils.isEmpty(maskChain) || TextUtils.isEmpty(bitsChain)
                        || TextUtils.isEmpty(prefixChain)) {

                    Toast.makeText(AddressTableActivity.this, R.string.validation_classAdrees, Toast.LENGTH_LONG).show();

                    return;
                }

                String[] chain = {clas.getText().toString(), range.getText().toString(), mask.getText().toString(), bits.getText().toString(), prefix.getText().toString()};

                switch (classAdd) {
                    case 'A':
                        if (rangeChain.equals("0-126") && maskChain.equals("255.0.0.0") && bitsChain.equals("24") && prefixChain.equals("8") ) {

                            paintRow(chain);
                            classAdd++;
                            clas.setText("" + classAdd);
                            range.setText("");
                            mask.setText("");
                            bits.setText("");
                            prefix.setText("");
                            clas.setEnabled(false);

                        }
                        break;
                    case 'B':
                        if (rangeChain.equals("128-191") && maskChain.equals("255.255.0.0") && bitsChain.equals("16") && prefixChain.equals("16")) {

                            paintRow(chain);
                            classAdd++;
                            clas.setText("" + classAdd);
                            range.setText("");
                            mask.setText("");
                            bits.setText("");
                            prefix.setText("");
                            clas.setEnabled(false);

                        }
                        break;
                    case 'C':
                        if (rangeChain.equals("192-223") && maskChain.equals("255.255.255.0") && bitsChain.equals("8") && prefixChain.equals("24")) {

                            paintRow(chain);
                            classAdd++;
                            clas.setText("" + classAdd);
                            range.setText("");
                            mask.setText("");
                            bits.setText("");
                            prefix.setText("");
                            clas.setEnabled(false);

                        }
                        break;
                    case 'D':
                        if (rangeChain.equals("224-255") && maskChain.equals("255.255.255.255") && bitsChain.equals("0") && prefixChain.equals("32")) {

                            paintRow(chain);
                            classAdd++;
                            clas.setText("" + classAdd);
                            range.setText("");
                            mask.setText("");
                            bits.setText("");
                            prefix.setText("");
                            clas.setEnabled(false);

                        }
                        break;

                    default:
                        Toast.makeText(AddressTableActivity.this, "¡¡Completaste la tabla!! No agreges más datos ", Toast.LENGTH_LONG).show();

                }

            }
        });
    }
    public void paintRow(String chain[]){


        //  if (cadena[0].equals("A") && cadena[1].equals("128") && cadena[2].equals("255.0.0") && cadena[3].equals("24") && cadena[4].equals("8")) {
        Toast.makeText(AddressTableActivity.this, ".Correcto", Toast.LENGTH_LONG).show();
        TableLayout tabla = (TableLayout) findViewById(R.id.list);
        TextView textView;
        //abrimos el table row agregar las filas
        TableRow row = new TableRow(getBaseContext());
        for (int i = 0; i < 5; i++) {

            //abrimos un constructor del textview haciendo referencia a este proyecto
            textView = new TextView(getBaseContext());
            //para centrar el texto
            textView.setGravity(Gravity.CENTER_VERTICAL);
            //le damos dimenciones al textview
            textView.setPadding(25, 25, 25, 25);
            //un color de fondo
            textView.setBackgroundResource(R.color.colorPrimary);
            //agregamos los datos del vector cadena uno por uno al textview
            textView.setText(chain[i]);
            //color de texto en el textview
            textView.setTextColor(Color.WHITE);
            //  textView.setTextSize(12);
            //agregamos el textview al TableRow
            row.addView(textView);
        }
        //Finalmente agregamos el TableRow al TableLayout
        tabla.addView(row);

        String fuente = "fuente/all.otf";
        this.all = Typeface.createFromAsset(getAssets(), fuente);
        txtInfortation.setTypeface(all);
        texInfortation2.setTypeface(all);


    }

}
