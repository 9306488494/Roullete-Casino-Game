package com.example.yeshveer.roullette;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private ImageView rot;
    private ImageView pointer;
    Animation Blink;
    private ImageView imageView3;
    private EditText bet;
    private String betData="";




    Random r;
    int degree=0,old_deg=0;
    // because there are 36 sector on the wheel(10degree for each)
    private  static final float factor=4.80f;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        rot = (ImageView) findViewById(R.id.rot);
        pointer = (ImageView) findViewById(R.id.pointer);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        bet = (EditText) findViewById(R.id.bet);

        r=new Random();

        // Click on spin button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Collect bet data into a variable
                betData = bet.getText().toString();
                // check bet box is empty
                if (bet.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter Your Bet", Toast.LENGTH_SHORT).show();
                } else {
                    imageView3.setImageResource(R.drawable.nob);
                    old_deg = degree % 360;
                    degree = r.nextInt(3600) + 720;
                    RotateAnimation rotate = new RotateAnimation(old_deg, degree, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setDuration(3600);
                    rotate.setFillAfter(true);
                    rotate.setInterpolator(new DecelerateInterpolator());
                    rotate.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            Blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.my_anim);
                            textView.setText("Spining Wheel");
                            textView.startAnimation(Blink);
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            textView.setText(currentno(360 - (degree % 360)));

                            if (textView.getText().toString().equals(String.valueOf(betData))) {
                                imageView3.setImageResource(R.drawable.win);
                            } else {
                                imageView3.setImageResource(R.drawable.lost);
                            }
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    rot.startAnimation(rotate);
                }
            }
        });
    }



    private String currentno(int degrees){
        String text="";
        // do this for each of the number
        if(degrees>=(factor*1) && degrees<(factor*3)){
            text="28";
        }
        if(degrees>=(factor*3) && degrees<(factor*5)){
            text="9";
        }
        if(degrees>=(factor*5) && degrees<(factor*7)){
            text="26";
        }
        if(degrees>=(factor*7) && degrees<(factor*9)){
            text="30";
        }
        if(degrees>=(factor*9) && degrees<(factor*11)){
            text="11";
        }
        if(degrees>=(factor*11) && degrees<(factor*13)){
            text="7";
        }
        if(degrees>=(factor*13) && degrees<(factor*15)){
            text="20";
        }
        if(degrees>=(factor*15) && degrees<(factor*17)){
            text="32";
        }
        if(degrees>=(factor*17) && degrees<(factor*19)){
            text="17";
        }
        if(degrees>=(factor*19) && degrees<(factor*21)){
            text="5";
        }
        if(degrees>=(factor*21) && degrees<(factor*23)){
            text="22";
        }
        if(degrees>=(factor*23) && degrees<(factor*25)){
            text="34";
        }
        if(degrees>=(factor*25) && degrees<(factor*27)){
            text="16";
        }
        if(degrees>=(factor*27) && degrees<(factor*29)){
            text="3";
        }
        if(degrees>=(factor*29) && degrees<(factor*31)){
            text="24";
        }
        if(degrees>=(factor*31) && degrees<(factor*33)){
            text="36";
        }
        if(degrees>=(factor*33) && degrees<(factor*35)){
            text="13";
        }
        if(degrees>=(factor*35) && degrees<(factor*37)){
            text="1";
        }
        if(degrees>=(factor*37) && degrees<(factor*39)){
            text="00";
        }
        if(degrees>=(factor*39) && degrees<(factor*41)){
            text="27";
        }
        if(degrees>=(factor*41) && degrees<(factor*43)){
            text="10";
        }
        if(degrees>=(factor*43) && degrees<(factor*45)){
            text="25";
        }
        if(degrees>=(factor*45) && degrees<(factor*47)){
            text="29";
        }
        if(degrees>=(factor*47) && degrees<(factor*49)){
            text="12";
        }
        if(degrees>=(factor*49) && degrees<(factor*51)){
            text="8";
        }
        if(degrees>=(factor*51) && degrees<(factor*53)){
            text="19";
        }
        if(degrees>=(factor*53) && degrees<(factor*55)){
            text="31";
        }
        if(degrees>=(factor*55) && degrees<(factor*57)){
            text="18";
        }
        if(degrees>=(factor*57) && degrees<(factor*59)){
            text="6";
        }
        if(degrees>=(factor*59) && degrees<(factor*61)){
            text="21";
        }
        if(degrees>=(factor*61) && degrees<(factor*63)){
            text="33";
        }
        if(degrees>=(factor*63) && degrees<(factor*65)){
            text="16";
        }
        if(degrees>=(factor*65) && degrees<(factor*67)){
            text="4";
        }
        if(degrees>=(factor*67) && degrees<(factor*69)){
            text="23";
        }
        if(degrees>=(factor*69) && degrees<(factor*71)){
            text="35";
        }
        if(degrees>=(factor*71) && degrees<(factor*73)){
            text="14";
        }
        if(degrees>=(factor*73) && degrees<(factor*75)){
            text="2";
        }
        if((degrees>=(factor*75) && degrees<360) || (degrees>=0 && degrees<(factor*1))){
            text="0";
        }


        return text;
    }
}
