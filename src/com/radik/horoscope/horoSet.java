package com.radik.horoscope;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class horoSet extends Activity implements SeekBar.OnSeekBarChangeListener {

	TextView mTextValue;
	WebView webView;

	public static final String APP_PREFERENCES = "myset";
	public static final String APP_PREFERENCES_FSIZE = "FSIZE";
	public static final String APP_PREFERENCES_LANG = "LANG";
	public SharedPreferences mSettings;
	public String lang = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set);
		mTextValue = (TextView) findViewById(R.id.textView2);

		final SeekBar seekbar = (SeekBar) findViewById(R.id.seekBar1);
		seekbar.setOnSeekBarChangeListener(this);
		String size = "3";
		webView = (WebView) findViewById(R.id.webview);
		mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
		if(mSettings.contains(APP_PREFERENCES_FSIZE)) {
			size = mSettings.getString(APP_PREFERENCES_FSIZE, "");
			mTextValue.setText(size);
			seekbar.setProgress(Integer.parseInt(size) - 1);
		}
		lang = "";
		if(mSettings.contains(APP_PREFERENCES_LANG)) {
			lang = mSettings.getString(APP_PREFERENCES_LANG, "");
			if(Integer.parseInt(lang) == 1) {
				RadioButton rb2 = (RadioButton) findViewById(R.id.radio1);
				rb2.toggle();
				TextView fText = (TextView) findViewById(R.id.textView1);
				fText.setText("Размер шрифта в тексте");
				TextView lText = (TextView) findViewById(R.id.textView3);
				lText.setText("Выбор языка");

				Button b1 = (Button) findViewById(R.id.button1);
				b1.setText("Сохранить");
				Button b2 = (Button) findViewById(R.id.button2);
				b2.setText("Отмена");
			}

			if(Integer.parseInt(lang) == 2) {
				RadioButton rb3 = (RadioButton) findViewById(R.id.radio2);
				rb3.toggle();
				TextView fText = (TextView) findViewById(R.id.textView1);
				fText.setText("Die Schriftgröße im Text");
				TextView lText = (TextView) findViewById(R.id.textView3);
				lText.setText("Die Wahl der Sprache");

				Button b1 = (Button) findViewById(R.id.button1);
				b1.setText("Speichern");
				Button b2 = (Button) findViewById(R.id.button2);
				b2.setText("Abbrechen");
			}

			if(Integer.parseInt(lang) == 3) {
				RadioButton rb4 = (RadioButton) findViewById(R.id.radio3);
				rb4.toggle();
				TextView fText = (TextView) findViewById(R.id.textView1);
				fText.setText("La taille de la police dans le texte");
				TextView lText = (TextView) findViewById(R.id.textView3);
				lText.setText("Le choix de la langue");

				Button b1 = (Button) findViewById(R.id.button1);
				b1.setText("Enregistrer");
				Button b2 = (Button) findViewById(R.id.button2);
				b2.setText("Annulation");
			}
		}

		webView.getSettings().setJavaScriptEnabled(false);
		webView.getSettings().setSupportZoom(false);
		webView.getSettings().setAppCacheEnabled(false);
		webView.setScrollContainer(false);
		webView.setVerticalScrollBarEnabled(false);
		String summary = "";
		summary = "<html><body><font size=" + size + ">Test test.</font></body></html>";
		if(Integer.parseInt(lang) == 1) {
			summary = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body><font size=" + size + ">Тест тест.</font></body></html>";
		}
		if(Integer.parseInt(lang) == 2) {
			summary = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body><font size=" + size + ">Test test.</font></body></html>";
		}
		if(Integer.parseInt(lang) == 3) {
			summary = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body><font size=" + size + ">Test test.</font></body></html>";
		}
		webView.loadData(summary, "text/html; charset=UTF-8", null);
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		mTextValue.setText(String.valueOf(seekBar.getProgress() + 1));
		String size = String.valueOf(seekBar.getProgress() + 1);
		String summary = "<html><body><font size=" + size + ">Test test.</font></body></html>";
		if(Integer.parseInt(lang) == 1) {
			summary = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body><font size=" + size + ">Тест тест.</font></body></html>";
		}
		if(Integer.parseInt(lang) == 2) {
			summary = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body><font size=" + size + ">Test test.</font></body></html>";
		}
		if(Integer.parseInt(lang) == 3) {
			summary = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body><font size=" + size + ">Test test.</font></body></html>";
		}
		webView.loadData(summary, "text/html; charset=UTF-8", null);

	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	public void onCancel(View view) {
		finish();
	}

	public void onSave(View view) {
		Intent intent = getIntent();
		RadioButton rb2 = (RadioButton) findViewById(R.id.radio1);
		RadioButton rb3 = (RadioButton) findViewById(R.id.radio2);
		RadioButton rb4 = (RadioButton) findViewById(R.id.radio3);
		String lang = "0";
		if(rb2.isChecked() == true) {
			lang = "1";
		}
		if(rb3.isChecked() == true) {
			lang = "2";
		}
		if(rb4.isChecked() == true) {
			lang = "3";
		}
		SeekBar seekbar = (SeekBar) findViewById(R.id.seekBar1);
		String fsize = String.valueOf(seekbar.getProgress() + 1);

		intent.putExtra("fsize", fsize);
		intent.putExtra("lang", lang);
		this.setResult(RESULT_OK, intent);
		finish();
	}
}
