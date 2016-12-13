package net.blusoft.examenuf1.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import net.blusoft.examenuf1.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    EditText eTnom;
    Spinner NumPreguntes;
    Spinner Tema;

    private int nombrePreguntes;
    private String tema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         Tema= (Spinner) findViewById(R.id.spinnerTema);
        NumPreguntes = (Spinner) findViewById(R.id.spinnerNombrePreguntes);

        eTnom = (EditText) findViewById(R.id.editText2);

        Button boto = (Button) findViewById(R.id.button);


        Tema.setOnItemSelectedListener(this);
        NumPreguntes.setOnItemSelectedListener(this);


        //Creem un adaptador per als Spinners.
        ArrayAdapter<CharSequence> adapterPreguntes = ArrayAdapter.createFromResource(this, R.array.numPreguntes, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterTema = ArrayAdapter.createFromResource(this, R.array.tema, android.R.layout.simple_spinner_item);
        adapterTema.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterPreguntes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        Tema.setAdapter(adapterTema);
        NumPreguntes.setAdapter(adapterPreguntes);

        boto.setOnClickListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinnerTema:
                //TODO
                this.tema=Tema.getSelectedItem().toString();
                break;
            case R.id.spinnerNombrePreguntes:
                this.nombrePreguntes = Integer.parseInt(NumPreguntes.getSelectedItem().toString());
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            Intent intent = new Intent(MainActivity.this, TestActivity.class);
            intent.putExtra("tema", tema);
            intent.putExtra("numeroPreguntes",nombrePreguntes);
            intent.putExtra("nom", eTnom.getText().toString());
            startActivity(intent);
        }
    }
}
