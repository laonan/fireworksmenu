package com.cyy.firworksmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity{

	private ImageView btnClose;
	private ImageView btnSound;
	private ImageView btnDrive;
	private ImageView btnOil;
	private ImageView btnSOS;
	private ImageView btnClean;
	private ImageView btnFix;
	
	private RelativeLayout rlSound;
	private RelativeLayout rlDrive;
	private RelativeLayout rlOil;
	private RelativeLayout rlSOS;
	private RelativeLayout rlClean;
	private RelativeLayout rlFix;
	private RelativeLayout rlClose;	
	
	private int closeX;
	private int closeY;
	private int closeW;
	
	private int soundX;
	private int soundY;
	private int driveX;
	private int driveY;
	private int oilX;
	private int oilY;
	private int SOSX;
	private int SOSY;
	private int cleanX;
	private int cleanY;
	private int fixX;
	private int fixY;
	
	private boolean isExpand;
	private int clickTimes = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnClose = (ImageView) findViewById(R.id.btn_close);
		btnClose.setOnClickListener(new RotateAndTransListener());
				
		btnSound = (ImageView) findViewById(R.id.btn_sound);
		btnDrive = (ImageView) findViewById(R.id.btn_drive);
		btnOil = (ImageView) findViewById(R.id.btn_oil);
		btnSOS = (ImageView) findViewById(R.id.btn_sos);
		btnClean = (ImageView) findViewById(R.id.btn_clean);
		btnFix = (ImageView) findViewById(R.id.btn_fix);
		
		rlSound = (RelativeLayout) findViewById(R.id.rlSound);
		rlDrive = (RelativeLayout) findViewById(R.id.rlDrive);
		rlOil = (RelativeLayout) findViewById(R.id.rlOil);
		rlSOS = (RelativeLayout) findViewById(R.id.rlSOS);
		rlClean = (RelativeLayout) findViewById(R.id.rlClean);
		rlFix = (RelativeLayout) findViewById(R.id.rlFix);
		rlClose = (RelativeLayout) findViewById(R.id.rlClose);
		
		isExpand = true;
	}
		
	class RotateAndTransListener implements OnClickListener{
	       public void onClick(View v) {
	    	   Rotate(0, 90, 1000, btnClose);
	    	   Rotate(0, 720, 1000, btnSound);
	    	   Rotate(0, 720, 1000, btnDrive);
	    	   Rotate(0, 720, 1000, btnOil);
	    	   Rotate(0, 720, 1000, btnSOS);
	    	   Rotate(0, 720, 1000, btnClean);
	    	   Rotate(0, 720, 1000, btnFix);
	    	   
	    	   if(clickTimes == 0) {
		    	   int position[] = new int[2];
		    	   rlClose.getLocationOnScreen(position);
		   		   closeX = position[0];
		   		   closeY = position[1];
		   		   closeW = rlClose.getWidth();
		   		   
		   		   int positionSound[] = new int[2];
		   		   rlSound.getLocationOnScreen(positionSound);
		   		   soundX = positionSound[0];
		   		   soundY = positionSound[1];
		   		   
		   		   int positionDrive[] = new int[2];
		   		   rlDrive.getLocationOnScreen(positionDrive);
		   		   driveX = positionDrive[0];
		   		   driveY = positionDrive[1];
		   		   
		   		   int positionOil[] = new int[2];
		   		   rlOil.getLocationOnScreen(positionOil);
		   		   oilX = positionOil[0];
		   		   oilY = positionOil[1];
		   		   
		   		   int positionSOS[] = new int[2];
		   		   rlSOS.getLocationOnScreen(positionSOS);
		   		   SOSX = positionSOS[0];
		   		   SOSY = positionSOS[1];
		   		   
		   		   int positionClean[] = new int[2];
		   		   rlClean.getLocationOnScreen(positionClean);
		   		   cleanX = positionClean[0];
		   		   cleanY = positionClean[1];
		   		   
		   		   int positionFix[] = new int[2];
		   		   rlFix.getLocationOnScreen(positionFix);
		   		   fixX = positionFix[0];
		   		   fixY = positionFix[1];
	    	   }
	    	   	
	    	   clickTimes ++;
	    	   
	    	   int duration = 1000;
	    	   float buttonRadious = btnClose.getWidth()/2;
	    	   
	   		   if(isExpand) {
		   		   Translate(0, 0, 0, closeY - soundY, duration, rlSound);
		   		   Translate(0, closeW/2 - buttonRadious , 0, closeY - driveY, duration, rlDrive);
		   		   Translate(0, buttonRadious - closeW/2, 0, closeY - oilY, duration, rlOil);
		   		   Translate(0, 0, 0, closeY - SOSY, 1000, rlSOS);
		   		   Translate(0, closeW/2 - buttonRadious, 0, closeY - cleanY, duration, rlClean);
		   		   Translate(0, buttonRadious - closeW/2, 0, closeY - fixY, duration, rlFix);
		   		   isExpand = false;
	   		   } else {
	   			   Translate(0, 0, closeY - soundY, 0, duration, rlSound);
	   			   Translate(closeW/2 - buttonRadious, 0 , closeY - driveY, 0, duration, rlDrive);
	   			   Translate(buttonRadious - closeW/2, 0 , closeY - oilY, 0, duration, rlOil);
		   		   Translate(0, 0, closeY - SOSY, 0, duration, rlSOS);
		   		   Translate(closeW/2 - buttonRadious, 0, closeY - cleanY, 0, duration, rlClean);
		   		   Translate(buttonRadious - closeW/2, 0, closeY - fixY, 0, duration, rlFix);
	   			   isExpand = true;
	   		   }
	       }
	       
	       private void Rotate(int fromDegrees, int toDegrees, int duration, ImageView img) {
	    	   AnimationSet animationSet = new AnimationSet(true);
	    	   //参数1：从哪个旋转角度开始
	           //参数2：转到什么角度
	           //后4个参数用于设置围绕着旋转的圆的圆心在哪里
	           //参数3：确定x轴坐标的类型，有ABSOLUT绝对坐标、RELATIVE_TO_SELF相对于自身坐标、RELATIVE_TO_PARENT相对于父控件的坐标
	           //参数4：x轴的值，0.5f表明是以自身这个控件的一半长度为x轴
	           //参数5：确定y轴坐标的类型
	           //参数6：y轴的值，0.5f表明是以自身这个控件的一半长度为x轴
	    	   RotateAnimation rotateAnimation = new RotateAnimation(fromDegrees, toDegrees, Animation.RELATIVE_TO_SELF,0.5f, 
	    			   Animation.RELATIVE_TO_SELF,0.5f);
	    	   rotateAnimation.setDuration(duration);
		       animationSet.addAnimation(rotateAnimation);
		       img.startAnimation(animationSet);
	       }
	       
	       private void Translate(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, int duration, RelativeLayout rl) {
	    	   
	    	   AnimationSet animationSet = new AnimationSet(true);
	          	    	   
	           TranslateAnimation translateAnimation =
	              new TranslateAnimation(
	                  Animation.ABSOLUTE, fromXDelta,
	                  Animation.ABSOLUTE, toXDelta,
	                  Animation.ABSOLUTE, fromYDelta,
	                  Animation.ABSOLUTE, toYDelta);
	    	  
	           translateAnimation.setDuration(duration);
	           animationSet.addAnimation(translateAnimation);
	           animationSet.setFillAfter(true);
	           rl.startAnimation(animationSet);
	           /*
	           animationSet.setAnimationListener(new AnimationListener(){
	        	   @Override
	        	   public void onAnimationStart(Animation animation) {
	        	   // TODO Auto-generated method stub
	        	   }
	        	   
	        	   @Override
	        	   public void onAnimationRepeat(Animation animation) {
	        	   // TODO Auto-generated method stub
	        	   }
	        	   
	        	   @SuppressLint("NewApi")
	        	   @Override
	        	   public void onAnimationEnd(Animation animation) {
	        	   // TODO Auto-generated method stub
	        		  
	        		  int position[] = new int[2];
	    	   		  rl.getLocationOnScreen(position);
	    	   		  float x = position[0];
	    	   		  float y = position[1];
	    	   		  
	    	   		  //x = x + toXDelta;
	    	   		  //y = y + toYDelta;
	    	   		  
	    	   		  if(!isExpand) {
	    	   			  rl.clearAnimation();
	    	   			  rl.setX(closeX);
	    	   			  rl.setY(closeY);
	    	   		  }
	        	      	        	      
	        	      //System.out.println("[view id: " + String.valueOf(rl.getId()) + "]x:" + String.valueOf(x) + "-----y:" + String.valueOf(y));
	        	   }

	           });*/
	       }
	       
	   }
}
