package com.example.salario;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editSalario;
    RadioGroup radioGroup;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSalario = findViewById(R.id.edit_salario);
        radioGroup = findViewById(R.id.radioGroup);
        btnCalcular = findViewById(R.id.btn_calcular);
        txtResultado = findViewById(R.id.txt_resultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String salarioStr = editSalario.getText().toString();

                if (salarioStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Digite o salário!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double salario = Double.parseDouble(salarioStr);
                double percentual = 0.0;

                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == R.id.radio_40) {
                    percentual = 0.40;
                } else if (selectedId == R.id.radio_45) {
                    percentual = 0.45;
                } else if (selectedId == R.id.radio_50) {
                    percentual = 0.50;
                } else {
                    Toast.makeText(MainActivity.this, "Selecione um percentual!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double novoSalario = salario + (salario * percentual);
                txtResultado.setText(String.format("Novo salário: R$ %.2f", novoSalario));
            }
        });
    }
}
