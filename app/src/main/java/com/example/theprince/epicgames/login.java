package com.example.theprince.epicgames;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class login extends AppCompatActivity {
    ImageButton login ,signup;
    Intent intentLogin ,intentSignup;
    EditText edt1 ,edt2;
    DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DataBase(this);

        edt1 = findViewById(R.id.edtUesr);
        edt2 = findViewById(R.id.edtPass);

        login = findViewById(R.id.login);
        signup = findViewById(R.id.signUp);
        LinearLayout linearLayout = findViewById(R.id.layout);
        Animation an = AnimationUtils.loadAnimation(this,R.anim.fide_in);
        linearLayout.setAnimation(an);

        intentLogin = new Intent(this ,Recycled_View.class);
        intentSignup = new Intent(this ,signUp.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //////////////This Code For Check On Username And Password////////////////////////
                Cursor c = db.checkPassword(edt1.getText().toString().trim(),edt2.getText().toString().trim());
                if (c.getCount() != 0){
                    Toast.makeText(login.this, "Done", Toast.LENGTH_SHORT).show();
                    /////To Update The Active (When You Signin And Close App Then Open again ,This Open RecyclerView Format)////
                    db.update_active(edt1.getText().toString().trim() ,edt2.getText().toString().trim() ,"1");
                    edt1.setText("");
                    edt2.setText("");
                    startActivity(intentLogin);
                    finish();
                }
                else
                    Toast.makeText(login.this, "UserName OR Password InCorrect", Toast.LENGTH_SHORT).show();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentSignup);
            }
        });
    }
}
