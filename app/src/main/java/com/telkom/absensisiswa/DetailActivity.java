package com.telkom.absensisiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DetailActivity extends AppCompatActivity {

    TextView detailNama, detailTanggaldanwaktu, detailLokasi, detailKeterangan;
    ImageView detailImage;
    FloatingActionButton deleteButton, editButton;
    String key = "";
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailNama = findViewById(R.id.detailNama);
        detailImage = findViewById(R.id.detailImage);
        detailTanggaldanwaktu = findViewById(R.id.detailTanggaldanwaktu);
        detailLokasi = findViewById(R.id.detailLokasi);
        detailKeterangan = findViewById(R.id.detailKeterangan);
        deleteButton = findViewById(R.id.deleteButton);
        editButton = findViewById(R.id.editButton);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailTanggaldanwaktu.setText(bundle.getString("Tanggal dan waktu"));
            detailLokasi.setText(bundle.getString("Lokasi"));
            detailKeterangan.setText(bundle.getString("Keterangan"));
            detailNama.setText(bundle.getString("Nama"));
            key = bundle.getString("Key");
            imageUrl = bundle.getString("Image");
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Data siswa");
                FirebaseStorage storage = FirebaseStorage.getInstance();

                StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
                storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        reference.child(key).removeValue();
                        Toast.makeText(DetailActivity.this, "Berhasil menghapus", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
                        finish();
                    }
                });
            }
        });
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class)
                        .putExtra("Nama", detailNama.getText().toString())
                        .putExtra("Tanggaldanwaktu", detailTanggaldanwaktu.getText().toString())
                        .putExtra("Lokasi", detailLokasi.getText().toString())
                        .putExtra("Keterangan", detailKeterangan.getText().toString())
                        .putExtra("Image", imageUrl)
                        .putExtra("Key", key);
                startActivity(intent);
            }
        });
    }
}