package com.trnkarthik.pickimagefromgallery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

public class LevelSelectorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level_selector);
		
		Intent intent = getIntent();
		Bitmap bitmap = (Bitmap) getIntent().getExtras().get("Image");

		ImageView ShowCaseImage = (ImageView)findViewById(R.id.showCaseImage);
		ShowCaseImage.setImageBitmap(bitmap);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_level_selector, menu);
		return true;
	}

}
