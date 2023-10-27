package com.telkom.absensisiswa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {

    ImageView imageView;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // menambahkan kode untuk menangani FAB
                // membuka Activity lain atau menambahkan data ke Firebase
                Intent intent = new Intent(MainActivity2.this, UploadActivity.class);
                startActivity(intent);
            }
        });

        ImageView ImageView = findViewById(R.id.Kembalisebelumnya);
        ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Mengunci activity saat tombol back perangkat ditekan
        finish();
    }

}
