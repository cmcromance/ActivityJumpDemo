package com.juno.activityjump.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityB extends Activity implements OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        
        Button btnGoToMain = (Button)findViewById(R.id.btnActB);
        btnGoToMain.setOnClickListener(this);
        Button btnNextPage = (Button)findViewById(R.id.btnActB_Next_Page);
        btnNextPage.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		int id = v.getId();
		
		switch (id) {
		case R.id.btnActB:
			Intent intentHome = new Intent(this, ActivityJumpDemoActivity.class);
			intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intentHome.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intentHome);
			finish();
			break;
		case R.id.btnActB_Next_Page:
			Intent intent = new Intent(this, ActivityC.class);
			startActivity(intent);
		default:
			break;
		}
	}
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(getBaseContext(), ActivityA.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			startActivity(intent);
			finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}

