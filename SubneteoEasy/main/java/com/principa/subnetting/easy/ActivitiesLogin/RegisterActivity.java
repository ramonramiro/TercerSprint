package com.principa.subnetting.easy.ActivitiesLogin;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.principa.subnetting.easy.Entities.User;
import com.principa.subnetting.easy.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtName,edtEmail,edtPassword,edtRepeatedPass;
    private Button btnRegistrar;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.edtRegisterName);
        edtEmail = findViewById(R.id.edtRegisterEmail);
        edtPassword =  findViewById(R.id.edtRegisterPassword);
        edtRepeatedPass =  findViewById(R.id.edtRegisterRepeatedPass);
        btnRegistrar =  findViewById(R.id.btnRegisterRegis);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();



        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String correo = edtEmail.getText().toString();
                final String nombre = edtName.getText().toString();
                if(isValidEmail(correo) && validarContraseña() && validarNombre(nombre)){
                    String contraseña = edtPassword.getText().toString();
                    mAuth.createUserWithEmailAndPassword(correo, contraseña)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText(RegisterActivity.this, "Se Registro Correctamente.", Toast.LENGTH_SHORT).show();
                                        //finish();
                                        User usuario = new User();
                                        usuario.setCorreo(correo);
                                        usuario.setNombre(nombre);
                                        FirebaseUser currentUser = mAuth.getCurrentUser();
                                        DatabaseReference reference = database.getReference("Usuarios/"+currentUser.getUid());
                                        reference.setValue(usuario);
                                        finish();



                                        // Intent intent = new Intent(RegistroActivity.this, LoginActivity.class );

                                        // startActivity(intent);





                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(RegisterActivity.this, "Error al Registrarse.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }else{
                    Toast.makeText(RegisterActivity.this, "Faltan Campos por Llenar.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public boolean validarContraseña(){
        String contraseña,contraseñaRepetida;
        contraseña = edtPassword.getText().toString();
        contraseñaRepetida = edtRepeatedPass.getText().toString();
        if(contraseña.equals(contraseñaRepetida)){
            if(contraseña.length()>=6 && contraseña.length()<=16){
                return true;
            }else return false;
        }else return false;
    }

    public boolean validarNombre(String nombre){
        return !nombre.isEmpty();
    }

}



