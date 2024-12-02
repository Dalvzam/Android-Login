package com.example.androidhelloworld;

import static com.example.androidhelloworld.ByeActivity.RESULT_CODE_FALTA_NOMBRE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.adiosButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Las dos hacen lo mismo, pero el setContenView solo lo hace visualmente
                //setContentView(R.layout.activity_bye);
                // Y el intent lo que hace es iniciar una nueva actividad

                Intent intent = new Intent(MainActivity.this, ByeActivity.class);
                String nombreUsuario = ((EditText)findViewById(R.id.userNameText)).getText().toString();
                intent.putExtra("NOMBRE",nombreUsuario);

                startActivityForResult(intent, RESULT_CODE_FALTA_NOMBRE);

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (resultCode == RESULT_CODE_FALTA_NOMBRE){
            findViewById(R.id.errorText).setVisibility(View.VISIBLE);

        }


    }

}