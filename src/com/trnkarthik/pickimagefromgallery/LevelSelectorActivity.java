package com.trnkarthik.pickimagefromgallery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LevelSelectorActivity extends Activity {

	public RadioGroup LevelRadio;
	public Bitmap bitmap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level_selector);
		
		bitmap = (Bitmap) getIntent().getExtras().get("Image");

		ImageView ShowCaseImage = (ImageView)findViewById(R.id.showCaseImage);
		ShowCaseImage.setImageBitmap(bitmap);

		Button toGameButton = (Button)findViewById(R.id.toGameButton);
		toGameButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				LevelRadio =(RadioGroup) findViewById(R.id.radioGroup1);
				String selectedRadioValue = ((RadioButton)findViewById(LevelRadio.getCheckedRadioButtonId() )).getText().toString();
				
				int level = 0;
				
				Log.d("test", selectedRadioValue+"");
				
				if(selectedRadioValue.equals("Play 3*3 level"))
				{
					level = 3;
				}
				else if(selectedRadioValue.equals("Play 4*4 level"))
				{
					level = 4;
				}
				
				Toast.makeText(getApplicationContext(), level +"", Toast.LENGTH_LONG).show();
				
				Intent toMainGame = new Intent(LevelSelectorActivity.this, GameActivity.class);
				toMainGame.putExtra("level", level);
				toMainGame.putExtra("Image",bitmap);
				startActivity(toMainGame);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_level_selector, menu);
		return true;
	}

}
