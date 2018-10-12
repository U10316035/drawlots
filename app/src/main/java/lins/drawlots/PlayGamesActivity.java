package lins.drawlots;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;

import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import lins.drawlots.Util.LogHelper;

/**
 * Created by no_name on 2018/10/5.
 */

public class PlayGamesActivity extends AppCompatActivity {
    private ImageView imgDrawLotPic;
    private ImageView imgCastBlockPic;
    private ImageView imgMoonBlockLeft;
    private ImageView imgMoonBlockRight;
    private Button btnDrawLots;
    private Button btnCastBlocks;
    private boolean isStarted = false;

    private int times = 10;
    int tempValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        setView();
    }

    private void setView(){
        imgDrawLotPic = (ImageView)findViewById(R.id.imageViewDrawLot);
        imgCastBlockPic = (ImageView)findViewById(R.id.imageViewCastBlocks);
        imgMoonBlockLeft = (ImageView)findViewById(R.id.imageViewMoonBlockLeft);
        imgMoonBlockRight = (ImageView)findViewById(R.id.imageViewMoonBlockRight);
        btnDrawLots = (Button)findViewById((R.id.buttonDrawLots));
        btnCastBlocks = (Button)findViewById((R.id.buttonCastBlocks));

        btnDrawLots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgCastBlockPic.setVisibility(View.GONE);
                imgMoonBlockLeft.setVisibility(View.GONE);
                imgMoonBlockRight.setVisibility(View.GONE);
                if(imgDrawLotPic.getVisibility() == View.GONE) {
                    imgDrawLotPic.setVisibility(View.VISIBLE);
                }else{
                    imgDrawLotPic.setVisibility(View.GONE);
                }
            }
        });

        btnCastBlocks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempValue = 0;
                imgDrawLotPic.setVisibility(View.GONE);
                imgMoonBlockLeft.setVisibility(View.VISIBLE);
                imgMoonBlockRight.setVisibility(View.VISIBLE);
                imgMoonBlockLeft.setBackground(ContextCompat.getDrawable(PlayGamesActivity.this, R.drawable.cast_blocks_left_animation));
                imgMoonBlockRight.setBackground(ContextCompat.getDrawable(PlayGamesActivity.this, R.drawable.cast_blocks_right_animation));
                rotate(imgMoonBlockLeft);
                rotate(imgMoonBlockRight);

//                final Timer t = new Timer();
//                final Handler handler = new Handler();
//                times = 10;
//
//                t.schedule(new TimerTask(){
//                    @Override
//                    public void run(){
//                        handler.post(new Runnable(){
//                            @Override
//                            public void run() {
//                                if(times<=0) {
//
//                                    ((AnimationDrawable) imgMoonBlockLeft.getBackground()).stop();
//                                    ((AnimationDrawable) imgMoonBlockRight.getBackground()).stop();
//
//                                    t.cancel();
//
//                                    //afterCastBlocks();
//                                }
//                                int randomDegree1 = (int) (Math.random() * 180) - 90;
//                                int randomDegree2 = (int) (Math.random() * 180) - 90;
//                                rotate(randomDegree1, imgMoonBlockLeft);
//                                rotate(randomDegree2, imgMoonBlockRight);
//                                times--;
//                            }
//                        });
//                    }
//                }, 0, 100);
            }
        });

        imgDrawLotPic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                if(!isStarted) {
                    ((AnimationDrawable) imgDrawLotPic.getBackground()).start();
                    isStarted = true;
                }else{
                    ((AnimationDrawable) imgDrawLotPic.getBackground()).stop();
                    isStarted = false;
                }
            }

        });
    }

//    private void rotateFunction(){
//        int randomDegree1 = (int) (Math.random() * 180) - 90;
//        int randomDegree2 = (int) (Math.random() * 180) - 90;
//        rotate(randomDegree1, imgMoonBlockLeft);
//        rotate(randomDegree2, imgMoonBlockRight);
//    }

//    private void afterCastBlocks(){
//        imgMoonBlockLeft.clearAnimation();
//        Animation translateAnimationL = new TranslateAnimation(0, 100f, 0, 100f);
//        translateAnimationL.setDuration(1000);
//        translateAnimationL.setFillAfter(true);
//        imgMoonBlockLeft.setAnimation(translateAnimationL);
//        imgMoonBlockLeft.startAnimation(translateAnimationL);
//
//        imgMoonBlockRight.clearAnimation();
//        Animation translateAnimationR = new TranslateAnimation(0, -100f, 0, -100f);
//        translateAnimationR.setDuration(1000);
//        translateAnimationR.setFillAfter(true);
//        imgMoonBlockRight.setAnimation(translateAnimationR);
//        imgMoonBlockRight.startAnimation(translateAnimationR);
//    }

    private void rotate(final ImageView ig) {
       // if(times != 0) {
        int randomDegree1 = (int) (Math.random() * 180) - 90;
        int randomDegree2 = (int) (Math.random() * 180) - 90;
//        int randomDegree3 = (int) (Math.random() * 180) - 90;
//        int randomDegree4 = (int) (Math.random() * 180) - 90;
//        int randomDegree5 = (int) (Math.random() * 180) - 90;
        int randomLength = (int) (Math.random() * 160)  - 80;
        while(randomLength == 0) randomLength = (int) (Math.random() * 160)  - 80;
        while(Math.abs(tempValue - randomLength)<=45) randomLength = (int) (Math.random() * 160)  - 80;
        tempValue = randomLength;

        final AnimationSet aniSet = new AnimationSet(true);

        RotateAnimation rotateAnim1 = new RotateAnimation(0.0f, randomDegree1,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnim1.setDuration(200);
        //rotateAnim1.setFillAfter(true);
        aniSet.addAnimation(rotateAnim1);

        RotateAnimation rotateAnim2 = new RotateAnimation(0.0f, randomDegree2,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotateAnim1.setDuration(200);
        //rotateAnim1.setFillAfter(true);
        aniSet.addAnimation(rotateAnim2);

//        RotateAnimation rotateAnim3 = new RotateAnimation(0.0f, randomDegree3,
//                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
//                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
//        rotateAnim1.setDuration(200);
//        //rotateAnim1.setFillAfter(true);
//        aniSet.addAnimation(rotateAnim3);
//
//        RotateAnimation rotateAnim4 = new RotateAnimation(0.0f, randomDegree4,
//                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
//                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
//        rotateAnim1.setDuration(200);
//        //rotateAnim1.setFillAfter(true);
//        aniSet.addAnimation(rotateAnim4);
//
//        RotateAnimation rotateAnim5 = new RotateAnimation(0.0f, randomDegree5,
//                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
//                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
//        rotateAnim1.setDuration(200);
//        //rotateAnim1.setFillAfter(true);
//        aniSet.addAnimation(rotateAnim5);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, randomLength, 0, randomLength);
        translateAnimation.setDuration(1000);
        aniSet.setFillAfter(true);
        aniSet.addAnimation(translateAnimation);
        aniSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                ((AnimationDrawable) ig.getBackground()).start();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(imgMoonBlockRight==ig) {
                    //((AnimationDrawable) imgMoonBlockLeft.getBackground()).stop();
                    //((AnimationDrawable) imgMoonBlockRight.getBackground()).stop();

//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                    int randomPic1 = (int) (Math.random() * 4);
                    int randomPic2 = (int) (Math.random() * 4);

                    switch (randomPic1) {
                        case 0: {
                            imgMoonBlockLeft.setBackground(ContextCompat.getDrawable(PlayGamesActivity.this, R.drawable.moon_block_left_back));
                            break;
                        }
                        case 1: {
                            imgMoonBlockLeft.setBackground(ContextCompat.getDrawable(PlayGamesActivity.this, R.drawable.moon_block_left_front));
                            break;
                        }
                        case 2: {
                            imgMoonBlockLeft.setBackground(ContextCompat.getDrawable(PlayGamesActivity.this, R.drawable.moon_block_right_back));
                            break;
                        }
                        case 3: {
                            imgMoonBlockLeft.setBackground(ContextCompat.getDrawable(PlayGamesActivity.this, R.drawable.moon_block_right_front));
                            break;
                        }
                    }

                    switch (randomPic2) {
                        case 0: {
                            imgMoonBlockRight.setBackground(ContextCompat.getDrawable(PlayGamesActivity.this, R.drawable.moon_block_left_back));
                            break;
                        }
                        case 1: {
                            imgMoonBlockRight.setBackground(ContextCompat.getDrawable(PlayGamesActivity.this, R.drawable.moon_block_left_front));
                            break;
                        }
                        case 2: {
                            imgMoonBlockRight.setBackground(ContextCompat.getDrawable(PlayGamesActivity.this, R.drawable.moon_block_right_back));
                            break;
                        }
                        case 3: {
                            imgMoonBlockRight.setBackground(ContextCompat.getDrawable(PlayGamesActivity.this, R.drawable.moon_block_right_front));
                            break;
                        }
                    }

                    if ((randomPic1 + randomPic2) % 2 == 0) {
                        new LogHelper().i("擲筊", "笑筊");
                    } else {
                        new LogHelper().i("擲筊", "聖筊");
                    }
                    imgMoonBlockLeft.clearAnimation();
                    imgMoonBlockRight.clearAnimation();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ig.startAnimation(aniSet);




//        final Timer t = new Timer();
//                final Handler handler = new Handler();
//                times = 10;
//
//                t.schedule(new TimerTask(){
//                    @Override
//                    public void run(){
//                        handler.post(new Runnable(){
//                            @Override
//                            public void run() {
//
//                                if(times!=10) {
//
//                                    ((AnimationDrawable) imgMoonBlockLeft.getBackground()).stop();
//                                    ((AnimationDrawable) imgMoonBlockRight.getBackground()).stop();
//
//                                    t.cancel();
//
//                                    //afterCastBlocks();
//                                }else{
//                                    ig.startAnimation(aniSet);
//                                }
//                                times--;
//                            }
//                        });
//                    }
//                }, 0, 2000);
    }
    //}
}
