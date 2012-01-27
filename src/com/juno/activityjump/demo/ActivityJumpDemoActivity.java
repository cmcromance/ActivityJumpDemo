package com.juno.activityjump.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityJumpDemoActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("TAG", "ActivityJumpDemoActivity : onCreate");
        Button btnNextPage = (Button)findViewById(R.id.btnActMain_Next_Page);
        btnNextPage.setOnClickListener(this);
    }
    
    
	@Override
	protected void onResume() {
		super.onResume();
		Log.d("TAG", "ActivityJumpDemoActivity : onResume");
	}


	@Override
	public void onClick(View v) {
		int id = v.getId();
		
		switch (id) {
		case R.id.btnActMain_Next_Page:
			Intent intent = new Intent(this, ActivityA.class);
			startActivity(intent);
		default:
			break;
		}
	}
}