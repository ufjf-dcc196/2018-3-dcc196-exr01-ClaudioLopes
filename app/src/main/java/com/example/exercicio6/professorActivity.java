package com.example.exercicio6;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class professorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        final TextView textNome = findViewById(R.id.editNomeProfessor);
        final TextView textSeape = findViewById(R.id.editSeape);
        Button botatoConfirmar = findViewById(R.id.botaoConfirmarProfessor);

        botatoConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = textNome.getText().toString();
                String seape = textSeape.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("nome", nome);
                intent.putExtra("codigo", seape);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
