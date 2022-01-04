package com.example.atvavl1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class proxTela extends AppCompatActivity {

    TextView valor1;
    TextView valor2;
    TextView valor3;
    TextView valor4;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prox_tela);

        valor1 = findViewById(R.id.v1);
        valor2 = findViewById(R.id.v2);
        valor3 = findViewById(R.id.v3);
        valor4 = findViewById(R.id.v4);
        resultado = findViewById(R.id.resultado);

        Intent proxTela = getIntent();
        if(proxTela != null){
            Bundle params = proxTela.getExtras();
            if(params != null){
                String Valor1 = params.getString("valor1");
                String Valor2 = params.getString("valor2");
                String Valor3 = params.getString("valor3");
                String Valor4 = params.getString("valor4");
                String RES = params.getString("resultado");

                valor1.setText("Valor 1:  " + Valor1);
                valor2.setText("Valor 2:  " + Valor2);
                valor3.setText("Valor 3:  " + Valor3);
                valor4.setText("Valor 4:  " + Valor4);
                resultado.setText(" " + RES);
            }
        }
    }
}
