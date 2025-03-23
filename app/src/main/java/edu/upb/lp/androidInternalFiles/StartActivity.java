package edu.upb.lp.androidInternalFiles;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import edu.upb.lp.genericgame.R;

public class StartActivity extends Activity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        prefs = getSharedPreferences("CatBurgerShop", MODE_PRIVATE);

        // Casting explícito a Button
        Button startButton = (Button) findViewById(R.id.startButton);
        Button scoreButton = (Button) findViewById(R.id.scoreButton);

        startButton.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, AndroidGameActivity.class);
            startActivity(intent);
        });

        scoreButton.setOnClickListener(v -> {
            int score1 = prefs.getInt("score1", 0);
            int score2 = prefs.getInt("score2", 0);
            int score3 = prefs.getInt("score3", 0);

            String scores = "Score 1: " + score1 + "\nScore 2: " + score2 + "\nScore 3: " + score3;
            TextView title = (TextView) findViewById(R.id.title); // Casting a TextView            title.setText(scores);
        });
    }
}