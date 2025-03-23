package edu.upb.lp.androidInternalFiles;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import edu.upb.lp.genericgame.R;

public class ScoresActivity extends Activity {

    private TextView scoresTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        scoresTextView = (TextView) findViewById(R.id.scoresTextView);
        backButton = (Button) findViewById(R.id.backButton);

        // Obtener los puntajes guardados
        SharedPreferences prefs = getSharedPreferences("CatBurgerShop", MODE_PRIVATE);
        int score1 = prefs.getInt("score1", 0);
        int score2 = prefs.getInt("score2", 0);
        int score3 = prefs.getInt("score3", 0);

        // Mostrar los puntajes en el TextView
        String scores = "Top Scores:\n1. " + score1 + "\n2. " + score2 + "\n3. " + score3;
        scoresTextView.setText(scores);

        // Configurar el botón "Back" para regresar a StartActivity
        backButton.setOnClickListener(v -> finish());
    }
}