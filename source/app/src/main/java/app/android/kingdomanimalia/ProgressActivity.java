package app.android.kingdomanimalia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class ProgressActivity extends AppCompatActivity {
    SessionHandler sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        sm = new SessionHandler(this);

        ImageButton btnBack = (ImageButton)findViewById(R.id.imgBack);
        ImageButton btnReset = (ImageButton)findViewById(R.id.imgReset);
        ImageView imgBintang1 = (ImageView)findViewById(R.id.imgBintang1);
        ImageView imgBintang2 = (ImageView)findViewById(R.id.imgBintang2);

        if(sm.getRateOne() == 1){
             imgBintang1.setBackgroundResource(R.drawable.img_progress_b1);
        } else if(sm.getRateOne() == 2){
            imgBintang1.setBackgroundResource(R.drawable.img_progress_b2);
        } else {
            imgBintang1.setBackgroundResource(R.drawable.img_progress_b3);
        }

        if(sm.getRateTwo() == 1){
            imgBintang2.setBackgroundResource(R.drawable.img_progress_b1);
        } else if(sm.getRateTwo() == 2){
            imgBintang2.setBackgroundResource(R.drawable.img_progress_b2);
        } else {
            imgBintang2.setBackgroundResource(R.drawable.img_progress_b3);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProgressActivity.this, MenuActivity.class);
                startActivity(i);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm.createRateOne(1);
                sm.createRateTwo(2);
                sm.createOneFalse();
                Toast.makeText(ProgressActivity.this, "Aplikasi berhasil di reset.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ProgressActivity.this, MenuActivity.class));
            }
        });
    }
}
