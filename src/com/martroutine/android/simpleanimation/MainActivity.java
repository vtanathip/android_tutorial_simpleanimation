package com.martroutine.android.simpleanimation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button animatorObject;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		animatorObject = (Button) findViewById(R.id.animator_object);
	}

	public void startAnimation(View view) {

		AnimatorSet animatorSet;
		
		ObjectAnimator fadeOutAnimator;
		ObjectAnimator fadeInAnimator;
		AnimatorSet animationFadeSet;
		
		Animation animate;
		
		RotateAnimation rotate;
		AnimationSet set;
		
		switch (view.getId()) {
		case R.id.move_to_right:
			animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.move_to_right);
			animatorSet.setTarget(animatorObject);
			animatorSet.start();
			break;
		case R.id.fade_in_and_out:

			fadeOutAnimator = new ObjectAnimator().ofFloat(animatorObject, "alpha", 1.0f, 0.0f);
			fadeOutAnimator.setDuration(1000L);
			fadeInAnimator = new ObjectAnimator().ofFloat(animatorObject, "alpha", 0.0f, 1.0f);
			fadeInAnimator.setDuration(700L);

			animationFadeSet = new AnimatorSet();
			animationFadeSet.play(fadeOutAnimator);
			animationFadeSet.play(fadeInAnimator).after(fadeOutAnimator);
			animationFadeSet.start();
			break;
		case R.id.scale:
			animate = AnimationUtils.loadAnimation(this, R.anim.scale);
			animatorObject.startAnimation(animate);
			break;
		case R.id.rotate:

			rotate = new RotateAnimation(0f, 360f, 50, 50);
			rotate.setDuration(600L);

			set = new AnimationSet(false);
			set.addAnimation(rotate);

			animatorObject.startAnimation(set);

			break;
		default:
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
