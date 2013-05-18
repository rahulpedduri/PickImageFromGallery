package com.trnkarthik.pickimagefromgallery;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TableLayout;

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

		/*
			ImageView testImage = (ImageView)findViewById(R.id.gameImageTest);
			testImage.setImageBitmap(bitmap);
			TextView testTextView = (TextView)findViewById(R.id.LevelTest);
			testTextView.setText("Level : "+ level);
		 */

		//Resizing the image to required dimension.In this case,image is resized to 240*240
		Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 240, 240, true);

		if(level>0)
		{
			int blocksize = (240/level);
			Bitmap[] imgs = new Bitmap[(level*level)];

			for(int i=0;i<level;i++)
			{
				for(int j=0;j<level;j++)
				{
					imgs[(level*i)+j] = Bitmap.createBitmap(scaledBitmap, (blocksize*j), (blocksize*i), blocksize , blocksize);
					Log.d("heart", "imgs["+((level*i)+j)+"] = "+(blocksize*j)+","+(blocksize*i)+","+","+blocksize+","+blocksize);
				}
			}
			
		}
		
		//Assigning images to table layout
		TableLayout gameTable = (TableLayout)findViewById(R.id.TableLayoutForGame);
		
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_game, menu);
		return true;
	}

}
