package com.example.croptheimage;


import java.text.Bidi;

import javax.security.auth.PrivateCredentialPermission;

import android.R.integer;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
	private Bitmap origialBitmap;
	private Bitmap chooseimage1;
	private Bitmap chooseimage2;
	private Button button;
	int rolling=0;
	int id1;
	int id2;
	int choose = 0;
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
		/*button = (Button)this.findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				rolling++;
				 Bitmap bitmap1 = cutTopLeft();
				 Bitmap bitmap2 = cutTopRight();
				 Bitmap bitmap3 = cutBottomLeft();
				 Bitmap bitmap4 = cutBottomRight();
				if(rolling%4==1){					
					imageView1.setImageBitmap(bitmap2);
					imageView2.setImageBitmap(bitmap3);
					imageView3.setImageBitmap(bitmap4);
					imageView4.setImageBitmap(bitmap1);
				}
				if(rolling%4==2){
					imageView1.setImageBitmap(bitmap3);
					imageView2.setImageBitmap(bitmap4);
					imageView3.setImageBitmap(bitmap1);
					imageView4.setImageBitmap(bitmap2);
				}
				if(rolling%4==3){
					imageView1.setImageBitmap(bitmap4);
					imageView2.setImageBitmap(bitmap1);
					imageView3.setImageBitmap(bitmap2);
					imageView4.setImageBitmap(bitmap3);
				}
				if(rolling%4==0){
					imageView1.setImageBitmap(bitmap1);
					imageView2.setImageBitmap(bitmap2);
					imageView3.setImageBitmap(bitmap3);
					imageView4.setImageBitmap(bitmap4);
				}
			}
		});*/
		for (int cut_no=0;cut_no<=3;cut_no++) {			
			origialBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fourteen);
			int w = origialBitmap.getWidth()/2;
			int h = origialBitmap.getHeight()/2;	
			if(cut_no==0){
				Bitmap cutBitmap = Bitmap.createBitmap(origialBitmap, 20, 20 ,w,h);//前兩是原圖起始座標,後兩個是需求截圖的大小	
				imageView1.setImageBitmap(cutBitmap);
				//image1 = cutBitmap;
			}
			if(cut_no==1){
				Bitmap cutBitmap = Bitmap.createBitmap(origialBitmap, w, 20 ,w,h);//前兩是原圖起始座標,後兩個是需求截圖的大小	
				imageView2.setImageBitmap(cutBitmap);
				//image2 = cutBitmap;
			}
			if(cut_no==2){
				Bitmap cutBitmap = Bitmap.createBitmap(origialBitmap, 20, h ,w,h);//前兩是原圖起始座標,後兩個是需求截圖的大小	
				imageView3.setImageBitmap(cutBitmap);
				//image3 = cutBitmap;
			}
			if(cut_no==3){
				Bitmap cutBitmap = Bitmap.createBitmap(origialBitmap, w, h ,w,h);//前兩是原圖起始座標,後兩個是需求截圖的大小	
				imageView4.setImageBitmap(cutBitmap);
				//image4 = cutBitmap;
			}
		}
	}
	 private class ImageViewListener implements OnClickListener{
	public void onClick(View v) {
		choose++;
		if(choose%2==1){
		id1=v.getId();
		    no1 = (ImageView)findViewById(id1);
		    chooseimage1=((BitmapDrawable)no1.getDrawable()).getBitmap();//從ImageView裡取得Image
		}
		if(choose%2==0){
			id2 = v.getId();
			Log.i(TAG, "--"+id2);
			no2 = (ImageView)findViewById(id2);
			chooseimage2=((BitmapDrawable)no2.getDrawable()).getBitmap();
			no1.setImageBitmap(chooseimage2);
			no2.setImageBitmap(chooseimage1);
		}
		}
	 }
}
