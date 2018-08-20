package com.principa.subnetting.easy.MainActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.principa.subnetting.easy.ActivitiesSteps.ActivityThreeActivity;
import com.principa.subnetting.easy.ActivitiesSteps.StepOneActivity;
import com.principa.subnetting.easy.R;
import com.principa.subnetting.easy.ActivitiesSteps.StepFourActivity;
import com.principa.subnetting.easy.ActivitiesSteps.StepTwoActivity;

public class RadioButtonMenuActivity extends AppCompatActivity {
    private Button btnNext;
    private RadioButton b1, b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_menu);

        btnNext = findViewById(R.id.btnNext);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b1.isChecked()) {
                    Intent b1 = new Intent(RadioButtonMenuActivity.this, StepOneActivity.class);
                    //Paso 1
                    startActivity(b1);
                } else if (b2.isChecked()) {
                    Intent b2 = new Intent(RadioButtonMenuActivity.this, StepTwoActivity.class);
                    //Paso 2
                    startActivity(b2);
                } else if (b3.isChecked()) {
                    Intent b3 = new Intent(RadioButtonMenuActivity.this, ActivityThreeActivity.class);
                    //Paso 3
                    //Esta es la actividad 3 que estaba en el menu del circulito ActivityThreeActivity
                    startActivity(b3);
                } else if (b4.isChecked()) {
                    Intent b4 = new Intent(RadioButtonMenuActivity.this, StepFourActivity.class);
                    //Paso 4
                    //Esta es la actividad 4 que esta en el menu de circulito StepFourActivity
                    startActivity(b4);
                }

            }
        });

    }
    public void open_dialog (View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title);
        builder.setMessage(R.string.messager);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(RadioButtonMenuActivity.this, R.string.ok1, Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton(R.string.nose, null);
        Dialog dialog = builder.create();
        dialog.show();
    }
    public void open_dialog2(View v)  {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title2);
        builder.setMessage(R.string.messager2);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(RadioButtonMenuActivity.this, R.string.ok1, Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton(R.string.nose, null);
        Dialog dialog = builder.create();
        dialog.show();
    }

    public void open_dialog3(View v)  {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title3);
        builder.setMessage(R.string.messager3);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(RadioButtonMenuActivity.this, R.string.ok1, Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton(R.string.nose, null);
        Dialog dialog = builder.create();
        dialog.show();
    }
    public void open_dialog4 (View v)  {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title4);
        builder.setMessage(R.string.messager4);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(RadioButtonMenuActivity.this, R.string.ok1, Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton(R.string.nose, null);
        Dialog dialog = builder.create();
        dialog.show();
    }
}
