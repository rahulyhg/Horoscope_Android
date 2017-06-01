package com.radik.horoscope;

import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HoroscopeActivity extends Activity {
	/** Called when the activity is first created. */
	public static final int Record_Request_Code = 1;
	public static final String APP_PREFERENCES = "myset";
	public static final String APP_PREFERENCES_FSIZE = "FSIZE";
	public static final String APP_PREFERENCES_LANG = "LANG";
	public SharedPreferences mSettings;
	public String lang;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		Date myDate = new Date();
		if(((myDate.getDate() >= 20) && (myDate.getMonth() == 11)) || ((myDate.getDate() <= 13) && (myDate.getMonth() == 0))) {
			LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mainLay);
			linearLayout.setBackgroundResource(R.drawable.back2);
		}

		mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
		if(mSettings.contains(APP_PREFERENCES_LANG) == false) {
			Editor editor = mSettings.edit();
			editor.putString(APP_PREFERENCES_FSIZE, "3");
			editor.commit();
			editor.putString(APP_PREFERENCES_LANG, "0");
			editor.commit();
		}

	}

	public void onZClick(View v) {
		Intent intent = new Intent(this, horoInfo1.class);
		intent.putExtra(horoInfo1.HTAG, v.getTag().toString());
		startActivity(intent);
	}

	public void onRatClick(View v) {
		mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
		String lang = "";
		if(mSettings.contains(APP_PREFERENCES_LANG)) {
			lang = mSettings.getString(APP_PREFERENCES_LANG, "");
		}
		AppRater.showRateDialog(HoroscopeActivity.this, null, lang);
	}

	public void onSetClick(View v) {
		Intent intent = new Intent(this, horoSet.class);
		startActivityForResult(intent, Record_Request_Code);
	}

	protected void onActivityResult(int RequestCode, int ResultCode, Intent data) {
		if(RequestCode == Record_Request_Code) {
			if(ResultCode == RESULT_OK) {
				String fsize = data.getStringExtra("fsize");
				String lang = data.getStringExtra("lang");

				Editor editor = mSettings.edit();
				editor.putString(APP_PREFERENCES_FSIZE, fsize);
				editor.commit();
				editor.putString(APP_PREFERENCES_LANG, lang);
				editor.commit();
				if(Integer.parseInt(lang) == 0) {
					Toast.makeText(HoroscopeActivity.this, "Save", Toast.LENGTH_SHORT).show();
				}

				if(Integer.parseInt(lang) == 1) {
					Toast.makeText(HoroscopeActivity.this, "Сохранение", Toast.LENGTH_SHORT).show();
				}

				if(Integer.parseInt(lang) == 2) {
					Toast.makeText(HoroscopeActivity.this, "Speichern", Toast.LENGTH_SHORT).show();
				}

				if(Integer.parseInt(lang) == 3) {
					Toast.makeText(HoroscopeActivity.this, "Enregistrer", Toast.LENGTH_SHORT).show();
				}
			}

		}
	}

	public void onAboutClick(View v) {
		Intent intent = new Intent(this, horoAbout.class);
		startActivity(intent);
	}

	public void onCDayClick(View v) {
		Intent intent = new Intent(this, horoInfo1.class);
		intent.putExtra(horoInfo1.HTAG, "0");
		startActivity(intent);
	}

	public void onDayClick(View v) {
		Intent intent = new Intent(this, horoInfo1.class);
		intent.putExtra(horoInfo1.HTAG, "15");
		startActivity(intent);
		/*
		 * Intent share = new Intent(android.content.Intent.ACTION_SEND);
		 * share.setType("text/plain");
		 * String lang="";
		 * if(mSettings.contains(APP_PREFERENCES_LANG)) {
		 * lang=mSettings.getString(APP_PREFERENCES_LANG, "");
		 * }
		 * if(Integer.parseInt(lang)==0){
		 * share.putExtra(android.content.Intent.EXTRA_SUBJECT, "Horoscope");
		 * share.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.radik.horoscope");
		 * startActivity(Intent.createChooser(share, "Share link!"));
		 * }else{
		 * share.putExtra(android.content.Intent.EXTRA_SUBJECT, "Гороскоп");
		 * share.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.radik.horoscope");
		 * startActivity(Intent.createChooser(share, "Поделиться ссылкой!"));
		 * }
		 */
	}

	public void onMoonClick(View v) {
		Intent intent = new Intent(this, horoInfo1.class);
		intent.putExtra(horoInfo1.HTAG, "13");
		startActivity(intent);
	}

	public void onFengClick(View v) {
		Intent intent = new Intent(this, horoInfo1.class);
		intent.putExtra(horoInfo1.HTAG, "14");
		startActivity(intent);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK) {
			int pid = android.os.Process.myPid();
			android.os.Process.killProcess(pid);
		}
		return super.onKeyDown(keyCode, event);
	}
}