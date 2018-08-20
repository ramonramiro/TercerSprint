package com.principa.subnetting.easy.ActivitiesLogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.principa.subnetting.easy.MainActivity.MenuActivity;
import com.principa.subnetting.easy.R;

public class LoginActivity extends AppCompatActivity {

    private EditText txtEmail,txtPassword;
    private Button btnLogin,btnRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = findViewById(R.id.edtEmailLogin);
        txtPassword = findViewById(R.id.edtPasswordLogin);
        btnLogin = findViewById(R.id.idLoginLogin);
        btnRegister = findViewById(R.id.btnRegisterLogin);

        mAuth = FirebaseAuth.getInstance();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = txtEmail.getText().toString();
                if(isValidEmail(correo) && validarContraseña()){
                    String contraseña = txtPassword.getText().toString();
                    mAuth.signInWithEmailAndPassword(correo, contraseña)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText(LoginActivity.this, "Se logeo correctamente.", Toast.LENGTH_SHORT).show();
                                        //Intent intent = new Intent(getApplication(), MainActivity.class );
                                        //startActivity(intent);
                                        nextActivity();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(LoginActivity.this, "Error, Datos Incorrectos.", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }else{
                    Toast.makeText(LoginActivity.this, "Faltan Campos por Llenar.", Toast.LENGTH_SHORT).show();
                }
            }

        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }

    private boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public boolean validarContraseña(){
        String contraseña;
        contraseña = txtPassword.getText().toString();
        if(contraseña.length()>=6 && contraseña.length()<=16){
            return true;
        }else return false;
    }

    /*
    @Override
    protected void onResume() {
        super.onResume();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){
            Toast.makeText(this, "Usuario logeado.", Toast.LENGTH_SHORT).show();
            nextActivity();
        }
    }

    */
    private void nextActivity(){
        startActivity(new Intent(LoginActivity.this,MenuActivity.class));
        finish();
    }
}
