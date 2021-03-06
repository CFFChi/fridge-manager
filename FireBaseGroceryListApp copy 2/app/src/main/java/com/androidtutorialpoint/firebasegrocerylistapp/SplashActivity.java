package com.androidtutorialpoint.firebasegrocerylistapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.view.WindowManager;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashActivity extends AwesomeSplash {

    @Override
    public void initSplash(ConfigSplash configSplash) {

        // We hide the top action bar in the splash screen
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // Set it to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Background Animation
        configSplash.setBackgroundColor(R.color.bg_splash);
        configSplash.setAnimCircularRevealDuration(3000);
        configSplash.setRevealFlagX(Flags.REVEAL_LEFT);
        configSplash.setRevealFlagX(Flags.REVEAL_BOTTOM);

        // Logo
        configSplash.setLogoSplash(R.mipmap.magicfridge);
        configSplash.setAnimLogoSplashDuration(1000);
        configSplash.setAnimLogoSplashTechnique(Techniques.FadeIn);

        // Title
        configSplash.setTitleSplash(getString(R.string.app_name));
        configSplash.setTitleTextColor(R.color.colorAccent);
        configSplash.setTitleFont("fonts/chelaone_regular.ttf");
        configSplash.setTitleTextSize(30f);
        configSplash.setAnimTitleDuration(2000);
        configSplash.setAnimTitleTechnique(Techniques.FadeIn);

    }

    @Override
    public void animationsFinished() {
        Intent intent = new Intent(this, ExpirationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

        // change the transition animation
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
