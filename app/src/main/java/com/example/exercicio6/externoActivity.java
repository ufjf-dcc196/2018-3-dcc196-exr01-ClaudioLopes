package com.example.exercicio6;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class externoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_externo);

        final TextView textNome = findViewById(R.id.editNomeExterno);
        final TextView textEmail = findViewById(R.id.editEmail);
        Button botatoConfirmar = findViewById(R.id.botaoConfirmarExterno);

        botatoConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = textNome.getText().toString();
                String email = textEmail.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("nome", nome);
                intent.putExtra("codigo", email);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
