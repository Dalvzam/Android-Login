package com.example.androidhelloworld;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ByeActivity extends AppCompatActivity {

    public static final int RESULT_CODE_FALTA_NOMBRE = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bye);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        new GetWeatherTask().execute("https://wttr.in/Madrid?format=%t");

        String nombre = getIntent().getStringExtra("NOMBRE");
        TextView byeText = findViewById(R.id.byeText);
        if (nombre == null || nombre.isEmpty()){
            setResult(RESULT_CODE_FALTA_NOMBRE);
            finish();
            return;
        }else{
            byeText.setText("Bye "+nombre);
        }

    }






    private class GetWeatherTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String result = "";
            try {
                // URL del servicio web
                URL url = new URL(params[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setConnectTimeout(15000);
                urlConnection.setReadTimeout(15000);

                // Leer la respuesta
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    result += line;
                }
                reader.close();
                urlConnection.disconnect();
            } catch (Exception e) {
                result = "Error: " + e.getMessage();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            // Mostrar el resultado (temperatura) en el TextView
            ((TextView)findViewById(R.id.temperaturaView)).setText("Temperatura en Madrid: " + result);
        }
    }
}
