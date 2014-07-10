package com.example.croptheimage;


import java.text.Bidi;

import javax.security.auth.PrivateCredentialPermission;

import android.R.integer;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.*;
import android.view.View;

public class MainActivity extends Activity {
	private ImageView imageView1;
	private ImageView imageView2;
	private ImageView imageView3;
	private ImageView imageView4;
	ImageView no1,no2;
	private Bitmap chooseimage1;
	private Bitmap chooseimage2;
	int rolling=0;
	int choose_id1;
	int choose_id2;
	int choose = 0;
	int random_record;
	private final String TAG = "MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView1 = (ImageView)this.findViewById(R.id.imageView1);
		imageView1.setOnClickListener(new ImageViewListener());
		imageView2 = (ImageView)this.findViewById(R.id.imageView2);
		imageView2.setOnClickListener(new ImageViewListener());
		imageView3 = (ImageView)this.findViewById(R.id.imageView3);
		imageView3.setOnClickListener(new ImageViewListener());
		imageView4 = (ImageView)this.findViewById(R.id.imageView4);
		imageView4.setOnClickListener(new ImageViewListener());
		int cut_random[] = {2131034172,2131034173,2131034174,2131034175};
		for (int cut_no=0;cut_no<=3;cut_no++) {
			Bitmap origialBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fourteen);
			int w = origialBitmap.getWidth()/2;
			int h = origialBitmap.getHeight()/2;	
			if(cut_no==0){
				Bitmap cutBitmap = Bitmap.createBitmap(origialBitmap, 20, 20 ,w,h);//前兩是原圖起始座標,後兩個是需求截圖的大小	
				int random = (int)(Math.random() * cut_random.length);
				ImageView random_cutimage = (ImageView)findViewById(cut_random[random]);
				random_cutimage.setImageBitmap(cutBitmap);
				cut_random[random]=1;
			}
			if(cut_no==1){
				Bitmap cutBitmap = Bitmap.createBitmap(origialBitmap, w, 20 ,w,h);//前兩是原圖起始座標,後兩個是需求截圖的大小	
				int random = (int)(Math.random() * cut_random.length);
				while (cut_random[random]==1) {
					random = (int)(Math.random() * cut_random.length);
					//break;
			}			
				ImageView random_cutimage = (ImageView)findViewById(cut_random[random]);
				random_cutimage.setImageBitmap(cutBitmap);
				cut_random[random]=1;
				
			}
			if(cut_no==2){
				Bitmap cutBitmap = Bitmap.createBitmap(origialBitmap, 20, h ,w,h);//前兩是原圖起始座標,後兩個是需求截圖的大小	
				int random = (int)(Math.random() * cut_random.length);
				while (cut_random[random]==1) {
						random = (int)(Math.random() * cut_random.length);
						//break;
				}	
				ImageView random_cutimage = (ImageView)findViewById(cut_random[random]);
				random_cutimage.setImageBitmap(cutBitmap);
				cut_random[random]=1;
			}
			if(cut_no==3){
				Bitmap cutBitmap = Bitmap.createBitmap(origialBitmap, w, h ,w,h);//前兩是原圖起始座標,後兩個是需求截圖的大小	
				int random = (int)(Math.random() * cut_random.length);
				while (cut_random[random]==1) {
					random = (int)(Math.random() * cut_random.length);
					//break;
			}
				ImageView random_cutimage = (ImageView)findViewById(cut_random[random]);
				random_cutimage.setImageBitmap(cutBitmap);
				cut_random[random]=1;
			}
		}

	}
	 private class ImageViewListener implements OnClickListener{
	public void onClick(View v) {
		choose++;
		if(choose%2==1){
			choose_id1=v.getId();
		//Log.i(TAG, "--"+id1);
		    no1 = (ImageView)findViewById(choose_id1);
		    chooseimage1=((BitmapDrawable)no1.getDrawable()).getBitmap();//從ImageView裡取得Image
		}
		if(choose%2==0){
			choose_id2 = v.getId();
			//Log.i(TAG, "--"+id2);
			no2 = (ImageView)findViewById(choose_id2);
			chooseimage2=((BitmapDrawable)no2.getDrawable()).getBitmap();
			no1.setImageBitmap(chooseimage2);
			no2.setImageBitmap(chooseimage1);
		}
		}
	 }
}
