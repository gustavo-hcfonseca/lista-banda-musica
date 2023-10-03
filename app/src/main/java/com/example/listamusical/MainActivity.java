package com.example.listamusical;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //  declarando variáveis globais
    EditText edit1Email, edit2Password;
    Button btnLogin;
    TextView tv1Criar, tv2Esqueci;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//  vinculando variaveis criadas a elementos do xml

        edit1Email = findViewById(R.id.editEmail);
        edit2Password = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.buttonLogin);
        tv1Criar = findViewById(R.id.textCriar);
        tv2Esqueci = findViewById(R.id.textEsqueci);

        btnLogin.setOnClickListener(this);
        tv1Criar.setOnClickListener(this);
        tv2Esqueci.setOnClickListener(this);


    }

    public void onClick(View view) {
        String emailDigitado = edit1Email.getText().toString().trim();
        String senhaDigitada = edit2Password.getText().toString().trim();


        if (edit1Email.getText().toString().equals("") && edit2Password.getText().toString().equals("")) {
            edit1Email.setError("Campo vazio");
            edit2Password.setError("Campo vazio");
        } else if (edit2Password.getText().toString().equals("")) {
            edit2Password.setError("Campo vazio");
        } else if (edit1Email.getText().toString().equals("")) {
            edit1Email.setError("Campo vazio");
        } else {
            if (Patterns.EMAIL_ADDRESS.matcher(emailDigitado).matches()) {
                // O e-mail digitado é válido
                String valoresDigitados = "E-mail: " + emailDigitado + ", Senha: " + senhaDigitada;
                Log.e("valores: ", valoresDigitados);

                //  conexao com a segunda pagina

                Intent i = new Intent(MainActivity.this, MainActivityEstiloMusical.class);
                String email = String.valueOf(edit1Email);
                i.putExtra("email_digitado", emailDigitado);
                i.putExtra("senha_digitada", senhaDigitada);
                Toast.makeText(getApplicationContext(), "Usuário Logado", Toast.LENGTH_SHORT).show();
                startActivity(i);


            } else {
                // O e-mail digitado não é válido
                edit1Email.setError("E-mail inválido");
            }
        }
    }

    public void capturarValores() {
        String valorCampo1 = edit1Email.getText().toString();
        String valorCampo2 = edit2Password.getText().toString();


        if (!valorCampo1.isEmpty() && !valorCampo2.isEmpty()) {
            String valoresDigitados = "Campo 1: " + valorCampo1 + ", Campo 2: " + valorCampo2;
            Log.e("valores: ", valoresDigitados);
        } else {
            Log.e("valores: ", "Preencha todos os campos");
        }
    }

}