package br.com.unipar.salarycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edSalario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular(View view) {

        edSalario = findViewById(R.id.edSalario);

        double salarioBruto = Double.parseDouble(edSalario.getText().toString());
        double desconto = 0;
        double salarioLiquido = 0;
        String msg = "";

        if (salarioBruto <= 1800.00) {
            desconto = (salarioBruto * 9) / 100;
            msg = "9%";
        } else if (salarioBruto >= 1800.01 && salarioBruto <= 2750.00) {
            desconto = (salarioBruto * 10) / 100;
            msg = "10%";
        } else if (salarioBruto >= 2750.01 && salarioBruto <= 4780.00) {
            desconto = (salarioBruto * 10.5) / 100;
            msg = "10,5%";
        } else if (salarioBruto >= 4780.01) {
            desconto = (salarioBruto * 12) / 100;
            msg = "12%";
        }

        salarioLiquido = salarioBruto - desconto;

        String result = "Valor do salario: R$ " + Double.toString(salarioBruto) + "\nValor descontado: R$ " + Double.toString(desconto) + " ("+ msg+
                        ")\nValor liquido: R$ " + Double.toString(salarioLiquido);

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }

}
