package com.example.theprince.epicgames;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Show_Buying extends AppCompatActivity {

    ImageView im1 ,im2 ,im3 ,im4 ,im5 ,im6 ,im7 ,im8 ,im9;
    TextView txt1 ,txt2 ,txt3 ,txt4 ,txt5 ,txt6 ,txt7 ,txt8 ,txt9;
    TextView date1 ,date2 ,date3 ,date4 ,date5 ,date6 ,date7 ,date8 ,date9;
    TextView time1 ,time2 ,time3 ,time4 ,time5 ,time6 ,time7 ,time8 ,time9;
    TextView price1 ,price2 ,price3 ,price4 ,price5 ,price6 ,price7 ,price8 ,price9;
    Button btn ;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__buying);

        im1 = findViewById(R.id.ph1);
        im2 = findViewById(R.id.ph2);
        im3 = findViewById(R.id.ph3);
        im4 = findViewById(R.id.ph4);
        im5 = findViewById(R.id.ph5);
        im6 = findViewById(R.id.ph6);
        im7 = findViewById(R.id.ph7);
        im8 = findViewById(R.id.ph8);
        im9 = findViewById(R.id.ph9);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
        txt7 = findViewById(R.id.txt7);
        txt8 = findViewById(R.id.txt8);
        txt9 = findViewById(R.id.txt9);

        date1 = findViewById(R.id.date1);
        date2 = findViewById(R.id.date2);
        date3 = findViewById(R.id.date3);
        date4 = findViewById(R.id.date4);
        date5 = findViewById(R.id.date5);
        date6 = findViewById(R.id.date6);
        date7 = findViewById(R.id.date7);
        date8 = findViewById(R.id.date8);
        date9 = findViewById(R.id.date9);

        time1 = findViewById(R.id.time1);
        time2 = findViewById(R.id.time2);
        time3 = findViewById(R.id.time3);
        time4 = findViewById(R.id.time4);
        time5 = findViewById(R.id.time5);
        time6 = findViewById(R.id.time6);
        time7 = findViewById(R.id.time7);
        time8 = findViewById(R.id.time8);
        time9 = findViewById(R.id.time9);

        price1 = findViewById(R.id.price1);
        price2 = findViewById(R.id.price2);
        price3 = findViewById(R.id.price3);
        price4 = findViewById(R.id.price4);
        price5 = findViewById(R.id.price5);
        price6 = findViewById(R.id.price6);
        price7 = findViewById(R.id.price7);
        price8 = findViewById(R.id.price8);
        price9 = findViewById(R.id.price9);

        DataBase db = new DataBase(this);
        Cursor c = db.getSpecifiedRow_users("1");
        c.moveToNext();

        Cursor cc = db.getSpecifiedRow_usersInfo(c.getInt(8));

        int x =0;
        count = cc.getCount();

        while (x < count) {
            if (x==9)
                break;
            cc.moveToNext();
            if (x == 0) {
                im1.setImageResource(cc.getInt(3));
                txt1.setText(cc.getString(4));
                date1.setText(cc.getString(1));
                time1.setText(cc.getString(2));
                price1.setText(cc.getString(5));
            }
            else if(x == 1) {
                im2.setImageResource(cc.getInt(3));
                txt2.setText(cc.getString(4));
                date2.setText(cc.getString(1));
                time2.setText(cc.getString(2));
                price2.setText(cc.getString(5));
            }
            else if(x == 2) {
                im3.setImageResource(cc.getInt(3));
                txt3.setText(cc.getString(4));
                date3.setText(cc.getString(1));
                time3.setText(cc.getString(2));
                price3.setText(cc.getString(5));
            }
            else if(x == 3){
                im4.setImageResource(cc.getInt(3));
                txt4.setText(cc.getString(4));
                date4.setText(cc.getString(1));
                time4.setText(cc.getString(2));
                price4.setText(cc.getString(5));
            }
            else if(x == 4){
                im5.setImageResource(cc.getInt(3));
                txt5.setText(cc.getString(4));
                date5.setText(cc.getString(1));
                time5.setText(cc.getString(2));
                price5.setText(cc.getString(5));
            }
            else if(x == 5) {
                im6.setImageResource(cc.getInt(3));
                txt6.setText(cc.getString(4));
                date6.setText(cc.getString(1));
                time6.setText(cc.getString(2));
                price6.setText(cc.getString(5));
            }
            else if(x == 6) {
                im7.setImageResource(cc.getInt(3));
                txt7.setText(cc.getString(4));
                date7.setText(cc.getString(1));
                time7.setText(cc.getString(2));
                price7.setText(cc.getString(5));
            }
            else if(x == 7){
                im8.setImageResource(cc.getInt(3));
                txt8.setText(cc.getString(4));
                date8.setText(cc.getString(1));
                time8.setText(cc.getString(2));
                price8.setText(cc.getString(5));
            }
            else if(x == 8){
                im9.setImageResource(cc.getInt(3));
                txt9.setText(cc.getString(4));
                date9.setText(cc.getString(1));
                time9.setText(cc.getString(2));
                price9.setText(cc.getString(5));
            }
            ++x;
        }

        final Intent intent = new Intent(this,Recycled_View.class);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });


    }
}
