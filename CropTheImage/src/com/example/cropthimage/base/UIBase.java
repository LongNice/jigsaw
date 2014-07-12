package com.example.cropthimage.base;

import android.os.Bundle;
import android.view.Window;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * UI基本class
 * @author scobin
 */ 
public class UIBase extends BaseActivity implements OnClickListener{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onResume() {
		super.onResume();
		
	}

	@Override
	protected void onPause() {
		super.onPause();
		
	}
	
	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	public void onClick(View v) {
		
	}
	
	/**
	 * 取得textView
	 * @param rID
	 * @return
	 */
	public TextView getTextView(int rID){
		return (TextView)findViewById(rID);
	}
	
	/**
	 * 從母view裡取得textView
	 * @param view
	 * @param rID
	 * @return
	 */
	public TextView getTextView(View view, int rID){
		return (TextView)view.findViewById(rID);
	}
	
	/**
	 * 取得button
	 * @param rID
	 * @return
	 */
	public Button getButton(int rID){
		return (Button)findViewById(rID);
	}
	
	/**
	 * 從母view裡取得button
	 * @param view
	 * @param rID
	 * @return
	 */
	public Button getButton(View view, int rID){
		return (Button)view.findViewById(rID);
	}
	
	/**
	 * ImageButton
	 * @param rID
	 * @return
	 */
	public ImageButton getImageButton(int rID){
		return (ImageButton)findViewById(rID);
	}
	
	/**
	 * 
	 * @param rID
	 * @return
	 */
	public ImageView getImageView(int rID){
		return (ImageView)findViewById(rID);
	}

	public CheckBox getCheckBox(int rID){
		return (CheckBox)findViewById(rID);
	}
}
