package app.android.kingdomanimalia;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.android.kingdomanimalia.models.Quiz;
import io.realm.Realm;
import io.realm.RealmResults;

public class QuizActivity extends AppCompatActivity {
    private static final String	TAG			= QuizActivity.class.getName();

    private TextView soal;
    private RadioGroup rg_answer;
    private RadioButton rb_A, rb_B, rb_C,rb_D,rb_E;

    private List<Quiz> mListQuiz;
    private Quiz mQuiz;
    private ArrayList<String> jawabBenar = new ArrayList<String>();
    private ArrayList<String> pembahasan = new ArrayList<String>();
    private CountDownTimer mCountDownTimer;
    private SessionHandler sessionHandler;

    private int					mScore;
    private int					mTime		= 0;
    private int					currentSoal	= 0;
    private static final int	milisecond	= 1000;
    private static final int	second		= 120;
    public static MediaPlayer soundSalah,soundBenar;
    private static final int	detik		= second * milisecond;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        realm = Realm.getDefaultInstance();

        sessionHandler = new SessionHandler(this);
        soundSalah = MediaPlayer.create(this, R.raw.sound_salah);
        soundBenar = MediaPlayer.create(this, R.raw.sound_benar);
        currentSoal = sessionHandler.getIndexSoal();

        //get all soal
        mListQuiz = findAllQuiz();

//        Collections.shuffle(mListQuiz);

        setupView();
        mulaiQuiz();
    }

    private void mulaiQuiz(){
        setupSoal();

        setupTimer();
    }

    private void setupTimer()
    {
        mCountDownTimer = new CountDownTimer(detik, 1000)
        {

            @Override
            public void onTick(long millisUntilFinished)
            {
                // TODO Auto-generated method stub
                mTime = (int) (millisUntilFinished / 1000);
            }

            @Override
            public void onFinish()
            {
                // TODO Auto-generated method stub
                mTime = second - mTime;

                Bundle bundle = new Bundle();
                Log.d("score", mScore + "");
                bundle.putInt("score", mScore);
                bundle.putInt("time", mTime);
                bundle.putStringArrayList("jawabanBenar",jawabBenar);
                bundle.putStringArrayList("pembahasan",pembahasan);

                Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                i.putExtras(bundle);
                startActivity(i);
                finish();
                Toast.makeText(QuizActivity.this, "Waktu Habis",
                        Toast.LENGTH_SHORT).show();
            }
        };

        mCountDownTimer.start();

    }

    private void setupSoal()
    {

        // clear checked radiobutton
        rg_answer.clearCheck();

        // get soal berdasar index
        mQuiz = mListQuiz.get(currentSoal);
        // set soalnya
        soal.setText(mQuiz.getSoal());

        rb_A.setText("A. " + mQuiz.getJawab_a());
        rb_B.setText("B. " + mQuiz.getJawab_b());
        rb_C.setText("C. " + mQuiz.getJawab_c());
        rb_D.setText("D. " + mQuiz.getJawab_d());
        rb_E.setText("E. " + mQuiz.getJawab_e());


        currentSoal++;
    }

    private void setupView()
    {
        soal = (TextView) findViewById(R.id.txtSoal);

        rb_A = (RadioButton) findViewById(R.id.rb_A);
        rb_B = (RadioButton) findViewById(R.id.rb_B);
        rb_C = (RadioButton) findViewById(R.id.rb_C);
        rb_D = (RadioButton) findViewById(R.id.rb_D);
        rb_E = (RadioButton) findViewById(R.id.rb_E);
        rg_answer = (RadioGroup) findViewById(R.id.rgAnswer);
        
        rg_answer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId > 0){
                    jawabBenar.add(mQuiz.getJawab_benar().toUpperCase());
                    pembahasan.add(mQuiz.getPembahasan());
                    if(getAnswer().equals(mQuiz.getJawab_benar().toUpperCase())){
                        mScore += 10;
                        soundBenar.start();
                    } else {
                        soundSalah.start();
                    }

                    if(currentSoal < (sessionHandler.getIndexSoal() + 10)){
                        setupSoal();
                    } else {
                        mTime = second - mTime;

                        Bundle bundle = new Bundle();
                        Log.d("score", mScore + "");
                        bundle.putInt("score", mScore);
                        bundle.putInt("time", mTime);
                        bundle.putInt("level", getIntent().getIntExtra("level",1));
                        bundle.putStringArrayList("jawabanBenar",jawabBenar);
                        bundle.putStringArrayList("pembahasan",pembahasan);
                        mCountDownTimer.cancel();
                        Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                        i.putExtras(bundle);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });

    }

    private String getAnswer()
    {
        switch (rg_answer.getCheckedRadioButtonId())
        {
            case R.id.rb_A:
                return "A";
            case R.id.rb_B:
                return "B";
            case R.id.rb_C:
                return "C";
            case R.id.rb_D:
                return "D";
            case R.id.rb_E:
                return "E";
        }
        return "";
    }

    private List<Quiz> findAllQuiz()
    {
        List<Quiz> listSoal = new ArrayList<Quiz>();

        RealmResults<Quiz> quiz = realm.where(Quiz.class).findAll();
        if(getIntent().getIntExtra("level", 1) == 1){
            for(int i = 0;i < 18;i++){
                listSoal.add(quiz.get(i));
            }
        }else {
            for(int i = 18;i < quiz.size();i++){
                listSoal.add(quiz.get(i));
            }
        }


        return  listSoal;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(QuizActivity.this, "Selesaikan dulu quiznya :)", Toast.LENGTH_SHORT).show();
    }
}
