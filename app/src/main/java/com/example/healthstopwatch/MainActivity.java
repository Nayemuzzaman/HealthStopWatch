package com.example.healthstopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnstart, btnstop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timehere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        btnstart = findViewById ( R.id.btnstart );
        btnstop = findViewById ( R.id.btnstop );
        icanchor = findViewById ( R.id.icanchor );
        timehere = findViewById ( R.id.timehere );

        btnstop.setAlpha ( 0 );
        roundingalone = AnimationUtils.loadAnimation ( this, R.anim.atg );

        Typeface MMedium = Typeface.createFromAsset ( getAssets (), "font/mmedium.ttf" );

        btnstart.setTypeface ( MMedium );

        btnstart.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                icanchor.startAnimation ( roundingalone );
                btnstop.animate ().alpha ( 1 ).translationY ( -80 ).setDuration ( 300 ).start ();


                //start time
                timehere.setBase ( SystemClock.elapsedRealtime () );
                timehere.start ();

            }
        } );

        btnstop.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
              timehere.stop ();
                icanchor.clearAnimation ();
            }
        } );
    }
}