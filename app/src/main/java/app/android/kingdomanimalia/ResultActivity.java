package app.android.kingdomanimalia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ImageView imgBintang = (ImageView)findViewById(R.id.imgBintang);
        TextView txtLevel = (TextView)findViewById(R.id.txtLevel);
        TextView txtNilai = (TextView)findViewById(R.id.txtNilai);
        ImageButton imgMenu = (ImageButton)findViewById(R.id.btnBackMenu);
        ImageButton imgPlay = (ImageButton)findViewById(R.id.btnNextLevel);
        ImageButton imgReplay = (ImageButton)findViewById(R.id.btnReplay);

        Bundle b = getIntent().getExtras();

        if(b != null){
            if(b.getInt("score") < 60){
                if(b.getInt("level") == 1){
                    new SessionHandler(this).createRateOne(1);
                } else {
                    new SessionHandler(this).createRateTwo(1);
                }
                imgBintang.setBackgroundResource(R.drawable.bg_bintang_1);
            } else if(b.getInt("score") > 60 && b.getInt("score") < 80){
                if(b.getInt("level") == 1){
                    new SessionHandler(this).createRateOne(2);
                } else {
                    new SessionHandler(this).createRateTwo(2);
                }
                imgBintang.setBackgroundResource(R.drawable.bg_bintang_2);
            } else {
                if(b.getInt("level") == 1){
                    new SessionHandler(this).createRateOne(3);
                } else {
                    new SessionHandler(this).createRateTwo(3);
                }
                imgBintang.setBackgroundResource(R.drawable.bg_bintang_3);
            }
            if(b.getInt("level") == 1){
                new SessionHandler(this).createOneDone();
            }
            txtLevel.setText("Level " + b.getInt("level"));
            txtNilai.setText("Nilai " + b.getInt("score"));
        }

        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, MenuActivity.class);
                startActivity(i);
                finish();
            }
        });

        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, MenuActivity.class);
                startActivity(i);
                finish();
            }
        });

        imgReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, QuizActivity.class);
                i.putExtra("levelBefore","");
                startActivity(i);
                finish();
            }
        });
    }
}
