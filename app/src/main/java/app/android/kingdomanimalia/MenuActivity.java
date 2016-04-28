package app.android.kingdomanimalia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ImageButton btnPengantar = (ImageButton)findViewById(R.id.btnPengantar);
        ImageButton btnBelajar = (ImageButton)findViewById(R.id.btnBelajar);
        ImageButton btnQuiz = (ImageButton)findViewById(R.id.btnQuiz);
        ImageButton btnProgress = (ImageButton)findViewById(R.id.btnProgress);

        btnPengantar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PengantarActivity.class);
                startActivity(i);
            }
        });


        btnBelajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), BelajarActivity.class);
                startActivity(i);
            }
        });

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LevelActivity.class);
                startActivity(i);
            }
        });

        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProgressActivity.class);
                startActivity(i);
            }
        });

    }
}
