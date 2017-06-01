package com.radik.horoscope;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class horoAbout extends Activity {
	public static final String APP_PREFERENCES = "myset";
	public static final String APP_PREFERENCES_LANG = "LANG";
	public SharedPreferences mSettings;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
		String lang = "";
		if(mSettings.contains(APP_PREFERENCES_LANG)) {
			lang = mSettings.getString(APP_PREFERENCES_LANG, "");
		}
		String tAbout = "Program allows to read a daily horoscope on the phone: \n - zodiac horoscope \n - lunar horoscope \n - daily Feng Shui \n\n Voice your opinion - vote for the application.\n\n http://craftask.ru \n , by Radik Apps.";
		if(Integer.parseInt(lang) == 1) {
			tAbout = "Приложение позволяет читать ежедневный гороскоп на вашем телефоне:\n - зодиакальный\n - лунный гороскоп\n - Феншуй-прогноз\n\nВыскажите свое мнение - проголосуйте за приложение.\n\n http://craftask.ru \n , by Radik Apps.";
		}
		if(Integer.parseInt(lang) == 2) {
			tAbout = "Die App ermöglicht das Lesen Horoskop auf Ihrem Handy:\n - Tierkreis - \n - Lunar-Horoskop\n - Feng Shui-Vorhersage\n\n Sagen Sie Ihre Meinung - Vote für die App.\n\n http://craftask.ru \n , by Radik Apps.";
		}
		if(Integer.parseInt(lang) == 3) {
			tAbout = "L'application vous permet de lire l'horoscope quotidien sur votre téléphone:\n - zodiac\n - lunaire horoscope\n - feng shui-prévisions\n\n Donnez-nous votre avis - votez pour l'application.\n\n http://craftask.ru \n , by Radik Apps.";
		}

		TextView fText = (TextView) findViewById(R.id.textAV1);
		fText.setText(tAbout);
		if(Integer.parseInt(lang) == 1) {
			Button b1 = (Button) findViewById(R.id.button1);
			b1.setText("Назад");
		}
	}

	public void onBackClick(View v) {
		finish();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}
}
