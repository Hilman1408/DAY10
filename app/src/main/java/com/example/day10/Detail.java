package com.example.day10;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        int totalHarga = getIntent().getIntExtra("TotalHarga", 0);

        TextView kiretria = findViewById(R.id.Kiretria);
        TextView totalHargaTextView = findViewById(R.id.TotalHarga);

        kiretria.setText(getString(R.string.krietria));
        totalHargaTextView.setText(getString(R.string.total_harga) + " " + totalHarga);
    }
}

