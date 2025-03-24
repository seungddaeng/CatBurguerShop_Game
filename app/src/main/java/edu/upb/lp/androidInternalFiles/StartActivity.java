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

        Button startButton = (Button) findViewById(R.id.startButton);
        Button scoreButton = (Button) findViewById(R.id.scoreButton);

        startButton.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, AndroidGameActivity.class);
            startActivity(intent);
        });

        scoreButton.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this, ScoresActivity.class);
            startActivity(intent);
        });
    }
}