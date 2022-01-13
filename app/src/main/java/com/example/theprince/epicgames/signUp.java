package com.example.theprince.epicgames;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class signUp extends AppCompatActivity {

    EditText edtFName ,edtLName ,edtUsername ,edtPassword ,edtAddress ,edtPhone ;
    Button btnDone ;
    Intent intent;
    DataBase db = new DataBase(this);
    Cursor c ;
    String str ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Animation an = AnimationUtils.loadAnimation(this,R.anim.down_to_top);
        LinearLayout photo = findViewById(R.id.photo);
        photo.setAnimation(an);
        LinearLayout form = findViewById(R.id.form);
        an = AnimationUtils.loadAnimation(this,R.anim.top_to_down);
        form.setAnimation(an);

        intent = new Intent(this, login.class);

        edtFName = findViewById(R.id.fname);
        edtLName = findViewById(R.id.lname);
        edtUsername = findViewById(R.id.username);
        edtPassword = findViewById(R.id.password);
        edtAddress = findViewById(R.id.address);
        edtPhone = findViewById(R.id.phone);

        /////This Code To Set Data In EditTexts When You Click On Person Setting/////
        db = new DataBase(this);
        c = db.getSpecifiedRow_users2("1");
        if (c.getCount() != 0){

            c.moveToNext();
            edtFName.setText(c.getString(0));
            edtLName.setText(c.getString(1));
            edtUsername.setText(c.getString(2));
            edtPassword.setText(c.getString(3));
            edtAddress.setText(c.getString(4));
            edtPhone.setText(c.getString(5));

            /////////////// To Update EditInfo ///////////////////
            db.update_editInfo(c.getString(2),c.getString(3),"0");
        }

        btnDone =findViewById(R.id.btndone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            long test = 0 ;
            if ((edtFName.getText().toString().isEmpty()) || (edtLName.getText().toString().isEmpty()) || (edtUsername.getText().toString().isEmpty())
                    || (edtPassword.getText().toString().isEmpty()) || (edtAddress.getText().toString().isEmpty()) || (edtPhone.getText().toString().isEmpty()) ) {
                Toast.makeText(signUp.this, "Please Enter All Data", Toast.LENGTH_SHORT).show();
            }
            else if(c.getCount() != 0){
                //////////////// This Code To Update Data In DataBase ////////////////
                db.updateRow_users(edtFName.getText().toString().trim(), edtLName.getText().toString().trim(), edtUsername.getText().toString().trim(),
                        edtPassword.getText().toString().trim(), edtAddress.getText().toString().trim(), edtPhone.getText().toString().trim(),"1");
                Toast.makeText(signUp.this, "Your Data Are Updated", Toast.LENGTH_SHORT).show();

                finish();
            }
            else {
                test = db.insertData_users(edtFName.getText().toString().trim(), edtLName.getText().toString().trim(), edtUsername.getText().toString().trim(),
                        edtPassword.getText().toString().trim(), edtAddress.getText().toString().trim(), edtPhone.getText().toString().trim(),"0","0");
                if (test != -1) {
                    edtFName.setText("");
                    edtLName.setText("");
                    edtUsername.setText("");
                    edtPassword.setText("");
                    edtAddress.setText("");
                    edtPhone.setText("");
                    startActivity(intent);
                    finish();
                }
                else
                    Toast.makeText(signUp.this, "Error In Data Base!", Toast.LENGTH_SHORT).show();
            }}
    });


    }
}
