package fpoly.chiennvph50713_duanmau.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import fpoly.chiennvph50713_duanmau.R;


public class HelloActivity extends AppCompatActivity {
    TextView txt_hello;
    LottieAnimationView lottieAnimationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(fpoly.chiennvph50713_duanmau.R.layout.activity_hello);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(HelloActivity.this, LoginActivity.class));

            }
        },3000);

    }
}