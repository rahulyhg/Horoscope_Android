package com.radik.horoscope;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AppRater {
	private final static String APP_TITLE = "Horoscope";
	private final static String APP_PNAME = "com.radik.horoscope";

	public static Context mc;

	public static void showRateDialog(final Context mContext, final SharedPreferences.Editor editor, final String lang) {
		try {
			final Dialog dialog = new Dialog(mContext);
			dialog.setTitle(APP_TITLE);

			LinearLayout ll = new LinearLayout(mContext);
			ll.setOrientation(LinearLayout.VERTICAL);

			TextView tv = new TextView(mContext);
			if(Integer.parseInt(lang) == 1) {
				tv.setText("Если Вам нравится это приложение, пожалуйста проголосуйте за него. Спасибо за Вашу поддержку!");
			}
			if(Integer.parseInt(lang) == 0) {
				tv.setText("If you enjoy using " + APP_TITLE + ", please take a moment to rate it. Thanks for your support!");
			}

			if(Integer.parseInt(lang) == 2) {
				tv.setText("Wenn Sie diese App gefällt, bitte Vote für ihn. Vielen Dank für Ihre Unterstützung!");
			}

			if(Integer.parseInt(lang) == 3) {
				tv.setText("Si Vous aimez ce soft, s'il vous plaît voter pour lui. Merci pour Votre soutien!");
			}
			tv.setWidth(240);
			tv.setPadding(4, 0, 4, 10);
			ll.addView(tv);

			Button b1 = new Button(mContext);
			if(Integer.parseInt(lang) == 1) {
				b1.setText("Проголосовать " + APP_TITLE);
			}
			if(Integer.parseInt(lang) == 0) {
				b1.setText("Rate " + APP_TITLE);
			}
			if(Integer.parseInt(lang) == 2) {
				b1.setText("Stimmen " + APP_TITLE);
			}
			if(Integer.parseInt(lang) == 3) {
				b1.setText("Voter " + APP_TITLE);
			}
			b1.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME)));
					// mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.amazon.com/gp/mas/dl/android?p=" + APP_PNAME)));
					dialog.dismiss();
				}
			});
			ll.addView(b1);

			Button b3 = new Button(mContext);
			if(Integer.parseInt(lang) == 1) {
				b3.setText("Нет, спасибо");
			} else {
				b3.setText("No, thanks");
			}
			b3.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
			ll.addView(b3);
			dialog.setContentView(ll);
			dialog.show();
		} catch(Exception ex) {
			ex.getStackTrace();
		}
	}

}
