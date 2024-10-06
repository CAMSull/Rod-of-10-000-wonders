package com.example.rodof10000wonders; // Ensure this matches your package name

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView effectTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        effectTextView = findViewById(R.id.effect_text_view);
        Button buttonEffects = findViewById(R.id.button_effects);
        Button buttonNormalRod = findViewById(R.id.button_normal_rod);

        // Load the effects when the app starts
        DataProvider.loadEffects(this);

        buttonEffects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String randomEffect = DataProvider.getRandomEffect();
                effectTextView.setText(randomEffect); // Display the random effect
            }
        });

        buttonNormalRod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String normalRodEffect = DataProvider.getNormalRodEffect(); // Get effect based on d100 roll
                effectTextView.setText(normalRodEffect); // Display the effect
            }
        });
    }
}
