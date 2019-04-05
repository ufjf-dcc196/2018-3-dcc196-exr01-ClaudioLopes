package com.example.exercicio6;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class alunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        final TextView textNome = findViewById(R.id.editNome);
        final TextView textMat = findViewById(R.id.editMatricula);
        Button botatoConfirmar = findViewById(R.id.botaoConfirmarAluno);

        botatoConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = textNome.getText().toString();
                String mat = textMat.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("nome", nome);
                intent.putExtra("codigo", mat);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }
}
