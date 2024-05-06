package com.example.day10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup menuMakanan, menuMinuman;
    RadioButton selectedMakanan, selectedMinuman;
    Button pesanButton;
    int totalHarga = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuMakanan = findViewById(R.id.Menu);
        menuMinuman = findViewById(R.id.Menu2);
        pesanButton = findViewById(R.id.button);

        pesanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotalPrice();
                Intent intent = new Intent(MainActivity.this, Detail.class);
                intent.putExtra("TotalHarga", totalHarga);
                startActivity(intent);
            }
        });
    }

    private void calculateTotalPrice() {
        int selectedMakananId = menuMakanan.getCheckedRadioButtonId();
        int selectedMinumanId = menuMinuman.getCheckedRadioButtonId();

        totalHarga = 0;
        if (selectedMakananId != -1) {
            selectedMakanan = findViewById(selectedMakananId);
            if (selectedMakanan != null) {
                if (selectedMakanan.getId() == R.id.nasigoreng) {
                    totalHarga += 10000;
                } else if (selectedMakanan.getId() == R.id.miegoreng || selectedMakanan.getId() == R.id.mierebus) {
                    totalHarga += 8000;
                } else if (selectedMakanan.getId() == R.id.nasiuduk) {
                    totalHarga += 15000;
                }
            }
        }

        if (selectedMinumanId != -1) {
            selectedMinuman = findViewById(selectedMinumanId);
            if (selectedMinuman != null) {
                if (selectedMinuman.getId() == R.id.tehes) {
                    totalHarga += 5000;
                } else if (selectedMinuman.getId() == R.id.esjeruk) {
                    totalHarga += 7000;
                }
            }
        }
    }

}
