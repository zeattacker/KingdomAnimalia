package app.android.kingdomanimalia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class BelajarActivity extends AppCompatActivity {
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar);
        ImageButton btn1 = (ImageButton)findViewById(R.id.btnBelajar1);
        ImageButton btn2 = (ImageButton)findViewById(R.id.btnBelajar2);
        ImageButton btn3 = (ImageButton)findViewById(R.id.btnBelajar3);
        ImageButton btn4 = (ImageButton)findViewById(R.id.btnBelajar4);
        ImageButton btn5 = (ImageButton)findViewById(R.id.btnBelajar5);
        ImageButton btn6 = (ImageButton)findViewById(R.id.btnBelajar6);
        ImageButton btn7 = (ImageButton)findViewById(R.id.btnBelajar7);
        ImageButton btn8 = (ImageButton)findViewById(R.id.btnBelajar8);

        i = new Intent(BelajarActivity.this, ContentBelajarActivity.class);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("content_name","belajar1.htm");
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("content_name","belajar2.htm");
                startActivity(i);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("content_name","belajar3.htm");
                startActivity(i);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("content_name","belajar4.htm");
                startActivity(i);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("content_name","belajar5.htm");
                startActivity(i);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("content_name","belajar6.htm");
                startActivity(i);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("content_name","belajar7.htm");
                startActivity(i);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("content_name","belajar8.htm");
                startActivity(i);
            }
        });

        ImageButton btnBack = (ImageButton)findViewById(R.id.btnBackPengantar);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BelajarActivity.this, MenuActivity.class);
                startActivity(i);
            }
        });



    }
}
