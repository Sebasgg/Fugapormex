package com.example.fugapormexico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registro extends AppCompatActivity {
    TextView tieneCuenta;
    Button btnRegistrar;
    EditText txtInputUsername, txtInputEmail, txtInputPassword, txtInputConfirmPassword;
    private ProgressDialog mProgressBar;
    FirebaseAuth  mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtInputUsername = findViewById(R.id.inputUsername);
        txtInputEmail = findViewById(R.id.inputEmail);
        txtInputPassword = findViewById(R.id.inputPassword);
        txtInputConfirmPassword = findViewById(R.id.inputConfirmPassword);

        btnRegistrar = findViewById(R.id.btnRegister);
        tieneCuenta =findViewById(R.id.alreadyHaveAccount);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarCredenciales();
            }
        });

        tieneCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registro.this,Inicio.class));
            }
        });
        mAuth = FirebaseAuth.getInstance();
        mProgressBar = new ProgressDialog(Registro.this);

    }

    public void verificarCredenciales(){
        String username = txtInputUsername.getText().toString();
        String email = txtInputEmail.getText().toString();
        String password = txtInputPassword.getText().toString();
        String confirmPass = txtInputConfirmPassword.getText().toString();
        if(username.isEmpty() || username.length() < 5){
            showError(txtInputUsername,"Username no valido");
        }else if (email.isEmpty() || !email.contains("@")){
            showError(txtInputEmail,"Email no valido");
        }else if (password.isEmpty() || password.length() < 7){
            showError(txtInputPassword,"Clave no valida minimo 7 caracteres");
        }else if (confirmPass.isEmpty() || !confirmPass.equals(password)){
            showError(txtInputConfirmPassword,"Clave no valida, no coincide.");
        }else{
            //Mostrar ProgressBar
            mProgressBar.setTitle("Proceso de Registro");
            mProgressBar.setCanceledOnTouchOutside(false);
            mProgressBar.show();
            //Registrar usuario
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        //ocultar progressBar
                        mProgressBar.dismiss();
                        //redireccionar - intent a login
                        Intent intent = new Intent(Registro.this, Inicio.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Registrado Correctamente",Toast.LENGTH_LONG).show();

                    }else{
                        Toast.makeText(getApplicationContext(),"No se pudo registrar",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void showError(EditText input, String s){
        input.setError(s);
        input.requestFocus();
    }
}