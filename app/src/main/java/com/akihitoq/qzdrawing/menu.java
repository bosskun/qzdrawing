package com.akihitoq.qzdrawing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class menu extends AppCompatActivity {
    TextView showTopic;
    Button btnPlayer;
    Button btnAsker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        showTopic = findViewById(R.id.tvShowTopic);
        showTopic.setText("Choose one " + globalData.name);

        btnPlayer = findViewById(R.id.btnPlayer);
        btnPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu.this, player.class));
            }
        });

        btnAsker = findViewById(R.id.btnAsker);
        btnAsker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu.this, asker.class));
            }
        });
    }
}
