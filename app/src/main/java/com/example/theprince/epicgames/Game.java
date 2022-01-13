
package com.example.theprince.epicgames;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Game extends AppCompatActivity {
    //////////
    ImageView imgP , img1 , img2 , img3;
    TextView txtName ,txtPrice ,txtDesc1 ,txtDesc2 ,txtDesc3;
    String uri ;
    String gameName ;
    String price ;
    int image;
    /////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ////////////////////////////////////////
        imgP = findViewById(R.id.imgPoster);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        txtName = findViewById(R.id.txtName);
        txtPrice = findViewById(R.id.txtPrice);
        txtDesc1 = findViewById(R.id.txtDes1);
        txtDesc2 = findViewById(R.id.txtDes2);
        txtDesc3 = findViewById(R.id.txtDes3);

        gameName = getIntent().getStringExtra("gamename");
        price = getIntent().getStringExtra("gameprice");
        image = getIntent().getIntExtra("imgPoster",00);
        imgP.setImageResource(image);
        txtName.setText(gameName);
        txtPrice.setText(price);

        DataBase1 db1 = new DataBase1(this);

        Cursor c = db1.getSpecifiedRow_Games(gameName);
        c.moveToNext();
        uri = c.getString(1);
        img1.setImageResource(c.getInt(2));
        img2.setImageResource(c.getInt(3));
        img3.setImageResource(c.getInt(4));
        txtDesc1.setText(c.getString(5));
        txtDesc2.setText(c.getString(6));
        txtDesc3.setText(c.getString(7));

        final Button trailer = findViewById(R.id.btn_trailer);
        trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(uri));
                if(intent.resolveActivity(getPackageManager())!= null)
                {
                    startActivity(intent);
                }
            }
        });
    }

    public void btn_Buy(View view){

        ///////////////////Making The Notification
        final NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.buy2_icon);
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Delivery Service")
                .setContentText("Your Game Will be Arrived After 48 Hours")
                .setSmallIcon(R.drawable.buy3_icon)
                .setLargeIcon(bitmap)
                .setAutoCancel(true)
                .setNumber(1);

        builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);

        ///////////////Making The Message Box
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Are You Sure You Want To Buy This Game ???")
                .setIcon(R.drawable.buy_icon)
                .setTitle("Purchase contract")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        /////// Create Time //////////////
                        Date d = new Date(System.currentTimeMillis());
                        SimpleDateFormat sdf_time = new SimpleDateFormat("hh:mm:ss a");

                        /////// Create Date  //////////////
                        Date dd =new Date();
                        SimpleDateFormat sdf_date =new SimpleDateFormat("dd-MM-yyyy");

                        ////// Insert Data In DataBase ////////////
                        DataBase db = new DataBase(Game.this);
                        Cursor c = db.getSpecifiedRow_users("1");
                        c.moveToNext();
                        db.insertData_usersInfo(c.getInt(8) ,String.valueOf(sdf_date.format(dd)) ,String.valueOf(sdf_time.format(d)),image ,gameName ,price);

                        manager.notify(1,builder.build());
                        finish();

                    }
                });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

}
