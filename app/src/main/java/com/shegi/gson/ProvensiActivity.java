package com.shegi.gson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class ProvensiActivity extends AppCompatActivity {

    TextView txt_provensi,txt_positif,txt_sembuh,txt_meninggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provensi);


        txt_provensi = findViewById(R.id.txt_kota);
        txt_positif = findViewById(R.id.txt_positif);
        txt_sembuh = findViewById(R.id.txt_sembuh);
        txt_meninggal = findViewById(R.id.txt_meninggal);


        String kota = getIntent().getExtras().getString("Kota");
        txt_provensi.setText(kota);
        String positif = getIntent().getExtras().getString("Positif");
        txt_positif.setText(positif);
        String sembuh = getIntent().getExtras().getString("Sembuh");
        txt_sembuh.setText(sembuh);
        String meninggal = getIntent().getExtras().getString("Meninggal");
        txt_meninggal.setText(meninggal);

    }
}
