package net.blusoft.examenuf1.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.blusoft.examenuf1.Model.Pregunta;
import net.blusoft.examenuf1.Model.Preguntes;
import net.blusoft.examenuf1.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestActivity extends AppCompatActivity implements View.OnClickListener{

    private String name;
    private int numPreguntes;
    private String tema;

    private int erro = 0;
    private int ence = 0;

    private int preguntaActual = 0;

    private ArrayList<Pregunta> llistaPreguntes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        if (savedInstanceState == null) {
            Intent extras = getIntent();
            this.name = extras.getStringExtra("nom");
            this.numPreguntes = extras.getIntExtra("numeroPreguntes", 0);
            this.tema = extras.getStringExtra("tema");
        }
        Preguntes objecte = new Preguntes();
        llistaPreguntes = objecte.getPreguntes(1, numPreguntes);

        omplirPantalla();


    }

    public void omplirPantalla() {
        TextView eTnom = (TextView) findViewById(R.id.tvNom);
        eTnom.setText(name);
        TextView tvErrors = (TextView) findViewById(R.id.errors);
        TextView tvEncerts = (TextView) findViewById(R.id.encerts);

        //tvErrors.setText(erro);
        //tvEncerts.setText(ence);
        TextView pregunta = (TextView) findViewById(R.id.txViewPregunta);
        Button boto = (Button) findViewById(R.id.buttonSiguiente);
        boto.setOnClickListener(this);
        pregunta.setText(llistaPreguntes.get(preguntaActual).getPregunta());
    }

    public void seguent() {
//TODO
        preguntaActual++;
        omplirPantalla();
        System.out.println(preguntaActual);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonSiguiente) {
            if(preguntaActual==llistaPreguntes.size()) {
                Intent intent = new Intent(this, FiTestActivity.class);
                startActivity(intent);
            }
        }
        else{
            seguent();
        }
    }
}
