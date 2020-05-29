package com.example.p06ps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    int requestCode = 123;
    int notificationID = 888;


    Button btnAdd;
    EditText etName, etDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnAdd = findViewById(R.id.btnAdd);
        etName = findViewById(R.id.etName);
        etDesc = findViewById(R.id.etDesc);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new
                            NotificationChannel("default", "Default Channel",
                            NotificationManager.IMPORTANCE_DEFAULT);

                    channel.setDescription("This is for default notification");
                    notificationManager.createNotificationChannel(channel);
                }

                Intent intent = new Intent(AddActivity.this,MainActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity
                        ( AddActivity.this, requestCode, intent,
                                PendingIntent.FLAG_CANCEL_CURRENT);

                // Build notification
                NotificationCompat.Builder builder = new
                        NotificationCompat.Builder(AddActivity.this, "default");
                builder.setContentTitle("Amazing Offer!");
                builder.setContentText("Subject");
                builder.setSmallIcon(android.R.drawable.btn_star_big_off);
                builder.setContentIntent(pIntent);
                builder.setAutoCancel(true);

                Notification n = builder.build();

                // An integer good to have, for you to programmatically cancel it
                notificationManager.notify(notificationID, n);
                finish();

                DBHelper db = new DBHelper(AddActivity.this);

                // Insert a task
                db.insertNote(etName.getText().toString(), etDesc.getText().toString());
                db.close();

                Intent i = new Intent(AddActivity.this, MainActivity.class);
                startActivity(i);

            }


        });

    }
}
//done
