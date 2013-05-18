package com.trnkarthik.pickimagefromgallery;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends Activity {

	public Bitmap bitmap;
	public Integer level;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		bitmap = (Bitmap) getIntent().getExtras().get("Image");
		level = (Integer) getIntent().getExtras().get("level");
		
//		Toast.makeText(getApplicationContext(), level+"", Toast.LENGTH_LONG).show();

		ImageView testImage = (ImageView)findViewById(R.id.gameImageTest);
		testImage.setImageBitmap(bitmap);
		
		TextView testTextView = (TextView)findViewById(R.id.LevelTest);
		testTextView.setText("Level : "+ level);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_game, menu);
		return true;
	}

}
