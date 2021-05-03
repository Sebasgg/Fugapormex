package com.example.fugapormexico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import de.hdodenhof.circleimageview.CircleImageView;

import android.os.Bundle;
import android.widget.Toast;

public class Usuario extends AppCompatActivity {
    private TextView userNombre,userEmail,userID;
    Button btnCerrarSesion,btnEliminarCta ;
    private CircleImageView userImg;
    //Variable para gestionar FirebaseAuth
    private FirebaseAuth mAuth;
    //Variables opcionales para desloguear de google tambien
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInOptions gso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        userNombre = findViewById(R.id.userNombre);
        userEmail = findViewById(R.id.userEmail);
        userID = findViewById(R.id.userId);
        userImg = findViewById(R.id.userImagen);
        btnCerrarSesion = findViewById(R.id.btnLogout);
        btnEliminarCta = findViewById(R.id.btnEliminarCta);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        userNombre.setText(currentUser.getUid());
        userEmail.setText(currentUser.getDisplayName());
        userID.setText(currentUser.getEmail());
        //cargar imágen con glide:
        Glide.with(this).load(currentUser.getPhotoUrl()).into(userImg);
        //Configurar las gso para google signIn con el fin de luego desloguear de google
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                //Cerrar sesión con google tambien: Google sign out
                mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //Abrir MainActivity con SigIn button
                        if(task.isSuccessful()){
                            Intent activity_inicio = new Intent(getApplicationContext(), Inicio.class);
                            startActivity(activity_inicio);
                            Usuario.this.finish();
                        }else{
                            Toast.makeText(getApplicationContext(), "No se pudo cerrar sesión con google",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
        btnEliminarCta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //obtener el usuario actual
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                // Get the account
                GoogleSignInAccount signInAccount =
                        GoogleSignIn.getLastSignedInAccount(getApplicationContext());
                if (signInAccount != null) {
                    AuthCredential credential =
                            GoogleAuthProvider.getCredential(signInAccount.getIdToken(), null);
                    //Re-autenticar el usuario para eliminarlo
                    user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                //Eliminar el usuario
                                user.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d("Imagenes", "onSuccess:Usuario Eliminado");
                                        //llamar al metodo signOut para salir de aqui
                                        signOut();
                                    }
                                });
                            } else {
                                Log.e("Imagenes", "onComplete: Error al eliminar el usuario",
                                        task.getException());
                            }
                        }
                    });
                } else {
                    Log.d("dashBoard", "Error: reAuthenticateUser: user account is null");
                }
            }
        });//fin onClick
    }
    private void signOut() {
        //sign out de firebase
        FirebaseAuth.getInstance().signOut();
        //sign out de "google sign in"
        mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                //regresar al login screen o MainActivity
                //Abrir mainActivity para que inicie sesión o sign in otra vez.
                Intent Inicio = new Intent(getApplicationContext(), Inicio.class);
                Inicio.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(Inicio);
                Usuario.this.finish();
            }
        });
    }
}