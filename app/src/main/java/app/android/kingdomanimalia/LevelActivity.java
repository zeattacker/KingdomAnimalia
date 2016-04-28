package app.android.kingdomanimalia;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class LevelActivity extends AppCompatActivity {
    ViewPager viewPager;
    MyPagerAdapter myPagerAdapter;
    SessionHandler sessMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_activiy);

        viewPager = (ViewPager)findViewById(R.id.pager);
        myPagerAdapter = new MyPagerAdapter();
        viewPager.setAdapter(myPagerAdapter);
        sessMan = new SessionHandler(this);
    }

    private class MyPagerAdapter extends PagerAdapter {

        int NumberOfPages = 2;

        int[] res = {
                R.drawable.img_level1,
                R.drawable.img_level2};

        @Override
        public int getCount() {
            return NumberOfPages;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView imageView = new ImageView(LevelActivity.this);
            if(position == 1){
                if(sessMan.isOneDone()){
                    imageView.setImageResource(res[position]);
                } else {
                    imageView.setImageResource(R.drawable.img_level2_gembok);
                }
            } else {
                imageView.setImageResource(res[position]);
            }

            LayoutParams imageParams = new LayoutParams(
                    LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(imageParams);

            LinearLayout layout = new LinearLayout(LevelActivity.this);
            layout.setOrientation(LinearLayout.VERTICAL);
            LayoutParams layoutParams = new LayoutParams(
                    LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
            layout.setLayoutParams(layoutParams);
            layout.addView(imageView);

            final int page = position;
            layout.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent i = new Intent(LevelActivity.this, QuizActivity.class);
                    i.putExtra("level", page + 1);
                    startActivity(i);
                }});

            container.addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout)object);
        }

    }
}
