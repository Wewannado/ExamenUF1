package net.blusoft.examenuf1.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.blusoft.examenuf1.R;

public class FiTestActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fi_test);


        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button2) {
            Intent intent = new Intent(FiTestActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
