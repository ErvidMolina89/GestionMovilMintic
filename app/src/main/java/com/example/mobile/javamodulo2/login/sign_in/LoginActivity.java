package com.example.mobile.javamodulo2.login.sign_in;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobile.javamodulo2.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.ktx.Firebase;

import static com.example.mobile.javamodulo2.util.ExtentionsStringsKt.validateFormaterEmail;

public class LoginActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;
    private Button btn_login;
    private Activity mySelf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mySelf = this;
        setView();
        listener();
    }

    private void setView(){
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
    }

    private void listener(){
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                if(!validateFormaterEmail(username)){
                    Log.e("EMAIL", "ERROR FORMATO DE CORREO INCORRECTO");
                    AlertDialog.Builder builder = new AlertDialog.Builder(mySelf);
                    builder.setTitle(R.string.txt_title_login);
                    builder.setMessage(R.string.txt_error_sesion);
                    builder.setPositiveButton(R.string.txt_accept, null);
                    builder.setCancelable(false);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return;
                }

                if (username.equals("admin@mail.com") && password.equals("123")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(mySelf);
                    builder.setTitle(R.string.txt_title_login);
                    builder.setMessage(R.string.txt_sesion_ok);
                    builder.setPositiveButton(R.string.txt_accept, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                            Intent activity2 = new Intent(mySelf, MainActivity2.class);
//                            activity2.putExtra("username", username);
//                            activity2.putExtra("password", password);
//                            startActivity(activity2);
                        }
                    });
                    builder.setNegativeButton(R.string.txt_cancel, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();

                } else {
                    Log.e("LOGIN", "ERROR INICIANDO SESION");
                    AlertDialog.Builder builder = new AlertDialog.Builder(mySelf);
                    builder.setTitle(R.string.txt_title_login);
                    builder.setMessage(R.string.txt_error_sesion);
                    builder.setPositiveButton(R.string.txt_accept, null);
                    builder.setCancelable(false);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

            }
        });
    }
}