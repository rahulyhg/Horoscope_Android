package com.radik.horoscope;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.util.ByteArrayBuffer;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

// import com.google.android.gms.ads.AdRequest;
// import com.google.android.gms.ads.AdView;
// import android.content.ContentValues;
// import android.database.Cursor;

public class horoInfo1 extends Activity {

	private int group1Id = 1;
	int saveId = Menu.FIRST;
	int loadId = Menu.FIRST + 1;
	int refId = Menu.FIRST + 2;
	// private AdView mAdView;

	public static final String HTAG = "";
	public String htag = "";
	public String htitle = "";
	public String summary = "";
	public String startload = "";
	public String gurl = "";
	public String url = "";
	public String url2 = "";
	public String url3 = "";
	public String size = "3";
	public String lang = "0";
	public String result2 = "";
	public int Cl = 0;
	public int Pl = 0;
	private WebView webView;
	public static final String APP_PREFERENCES = "myset";
	public static final String APP_PREFERENCES_FSIZE = "FSIZE";
	public static final String APP_PREFERENCES_LANG = "LANG";
	public SharedPreferences mSettings;

	public void DownloadFromUrl(String DownloadUrl, String fileName) {

		try {
			File root = android.os.Environment.getExternalStorageDirectory();

			File dir = new File(root.getAbsolutePath() + "/xmls");
			if(dir.exists() == false) {
				dir.mkdirs();
			}

			URL url = new URL(DownloadUrl); // you can write here any link
			File file = new File(dir, fileName);

			long startTime = System.currentTimeMillis();
			// Log.d("DownloadManager", "download begining");
			// Log.d("DownloadManager", "download url:" + url);
			// Log.d("DownloadManager", "downloaded file name:" + fileName);
			// /
			/* Open a connection to that URL. */
			URLConnection ucon = url.openConnection();

			/*
			 * Define InputStreams to read from the URLConnection.
			 */
			InputStream is = ucon.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);

			/*
			 * Read bytes to the Buffer until there is nothing more to read(-1).
			 */
			ByteArrayBuffer baf = new ByteArrayBuffer(5000);
			int current = 0;
			while((current = bis.read()) != -1) {
				baf.append((byte) current);
			}

			/* Convert the Bytes read to a String. */
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(baf.toByteArray());
			fos.flush();
			fos.close();
			// Log.d("DownloadManager", "download ready in" + ((System.currentTimeMillis() - startTime) / 1000) + " sec");

		} catch(IOException e) {
			// Log.d("DownloadManager", "Error: " + e);
		}

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.horoinfo);
		size = "3";
		mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
		if(mSettings.contains(APP_PREFERENCES_FSIZE)) {
			size = mSettings.getString(APP_PREFERENCES_FSIZE, "");

		}
		lang = "0";
		if(mSettings.contains(APP_PREFERENCES_LANG)) {
			lang = mSettings.getString(APP_PREFERENCES_LANG, "");
		}
		Cl = 0;
		TextView dateView = (TextView) findViewById(R.id.hdate);
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		Date myDate = new Date();
		myDate.setDate(myDate.getDate());
		dateView.setText(formatter.format(myDate));
		Bundle extras = getIntent().getExtras();
		htag = extras.getString(HTAG);
		Integer t = Integer.parseInt(htag);
		String zod = "";
		switch(t)
			{
				case 1:
					zod = "aries";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Horoscope for aries";
					}

					if(Integer.parseInt(lang) == 1) {
						htitle = "Гороскоп для Овена";
					}

					if(Integer.parseInt(lang) == 2) {
						htitle = "Horoskop für Widder";
					}

					if(Integer.parseInt(lang) == 3) {
						htitle = "Horoscope Bélier";
					}
					break;
				case 2:
					zod = "taurus";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Horoscope for taurus";
					}

					if(Integer.parseInt(lang) == 1) {
						htitle = "Гороскоп для Тельца";
					}

					if(Integer.parseInt(lang) == 2) {
						htitle = "Horoskop für Taurus";
					}

					if(Integer.parseInt(lang) == 3) {
						htitle = "Horoscope Taureau";
					}
					break;
				case 3:
					zod = "gemini";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Horoscope for gemini";
					}
					if(Integer.parseInt(lang) == 1) {
						htitle = "Гороскоп для Близнецов";
					}

					if(Integer.parseInt(lang) == 2) {
						htitle = "Horoskop für Zwillinge";
					}

					if(Integer.parseInt(lang) == 3) {
						htitle = "Horoscope Gémeaux";
					}
					break;
				case 4:
					zod = "cancer";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Horoscope for cancer";
					}

					if(Integer.parseInt(lang) == 1) {
						htitle = "Гороскоп для Рака";
					}

					if(Integer.parseInt(lang) == 2) {
						htitle = "Horoskop für den Krebs";
					}

					if(Integer.parseInt(lang) == 3) {
						htitle = "Horoscope Cancer";
					}
					break;
				case 5:
					zod = "leo";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Horoscope for leo";
					}

					if(Integer.parseInt(lang) == 1) {
						htitle = "Гороскоп для Льва";
					}

					if(Integer.parseInt(lang) == 2) {
						htitle = "Horoskop Löwe";
					}

					if(Integer.parseInt(lang) == 3) {
						htitle = "Horoscope Lion";
					}
					break;
				case 6:
					zod = "virgo";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Horoscope for virgo";
					}

					if(Integer.parseInt(lang) == 1) {
						htitle = "Гороскоп для Девы";
					}
					if(Integer.parseInt(lang) == 2) {
						htitle = "Horoskop für die Jungfrau";
					}
					if(Integer.parseInt(lang) == 3) {
						htitle = "Horoscope de la Vierge";
					}
					break;
				case 7:
					zod = "libra";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Horoscope for libra";
					}
					if(Integer.parseInt(lang) == 1) {
						htitle = "Гороскоп для Весов";
					}
					if(Integer.parseInt(lang) == 2) {
						htitle = "Horoskop Waage";
					}
					if(Integer.parseInt(lang) == 3) {
						htitle = "Horoscope de la Balance";
					}
					break;
				case 8:
					zod = "scorpio";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Horoscope for scorpio";
					}
					if(Integer.parseInt(lang) == 1) {
						htitle = "Гороскоп для Скорпиона";
					}
					if(Integer.parseInt(lang) == 2) {
						htitle = "Horoskop Skorpion";
					}
					if(Integer.parseInt(lang) == 3) {
						htitle = "Horoscope Scorpion";
					}
					break;
				case 9:
					zod = "sagittarius";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Horoscope for sagittarius";
					}
					if(Integer.parseInt(lang) == 1) {
						htitle = "Гороскоп для Стрельца";
					}
					if(Integer.parseInt(lang) == 2) {
						htitle = "Horoskop Schütze";
					}
					if(Integer.parseInt(lang) == 3) {
						htitle = "Horoscope Sagittaire";
					}
					break;
				case 10:
					zod = "capricorn";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Horoscope for capricorn";
					}
					if(Integer.parseInt(lang) == 1) {
						htitle = "Гороскоп для Козерога";
					}
					if(Integer.parseInt(lang) == 2) {
						htitle = "Horoskop für den Steinbock";
					}
					if(Integer.parseInt(lang) == 3) {
						htitle = "Horoscope Capricorne";
					}
					break;
				case 11:
					zod = "aquarius";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Horoscope for aquarius";
					}
					if(Integer.parseInt(lang) == 1) {
						htitle = "Гороскоп для Водолея";
					}
					if(Integer.parseInt(lang) == 2) {
						htitle = "Horoskop Wassermann";
					}
					if(Integer.parseInt(lang) == 3) {
						htitle = "Horoscope du Verseau";
					}
					break;
				case 12:
					zod = "pisces";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Horoscope for pisces";
					}
					if(Integer.parseInt(lang) == 1) {
						htitle = "Гороскоп для Рыб";
					}
					if(Integer.parseInt(lang) == 2) {
						htitle = "Horoskop für Fische";
					}
					if(Integer.parseInt(lang) == 3) {
						htitle = "Horoscope Poissons";
					}
					break;
				case 0:
					zod = "";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Horoscope for All";
					}
					if(Integer.parseInt(lang) == 1) {
						htitle = "Гороскоп для Всех";
					}
					if(Integer.parseInt(lang) == 2) {
						htitle = "Horoskop für Alle";
					}
					if(Integer.parseInt(lang) == 3) {
						htitle = "Horoscope pour Tous";
					}
					break;
				case 13:
					zod = "";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Lunar horoscope";
					}
					if(Integer.parseInt(lang) == 1) {
						htitle = "Лунный гороскоп";
					}
					if(Integer.parseInt(lang) == 2) {
						htitle = "Lunar-Horoskop";
					}
					if(Integer.parseInt(lang) == 3) {
						htitle = "Horoscope lunaire";
					}
					break;
				case 14:
					zod = "";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Daily Feng Shui";
					}
					if(Integer.parseInt(lang) == 1) {
						htitle = "Феншуй-прогноз";
					}
					if(Integer.parseInt(lang) == 2) {
						htitle = "Feng Shui-Vorhersage";
					}
					if(Integer.parseInt(lang) == 3) {
						htitle = "Le feng shui-prévisions";
					}
					break;
				case 15:
					zod = "";
					if(Integer.parseInt(lang) == 0) {
						htitle = "Chinese horoscope";
					}
					if(Integer.parseInt(lang) == 1) {
						htitle = "Китайский гороскоп";
					}
					if(Integer.parseInt(lang) == 3) {
						htitle = "Das chinesische Horoskop";
					}
					if(Integer.parseInt(lang) == 3) {
						htitle = "L'horoscope chinois";
					}
					break;
			}

		TextView ZView = (TextView) findViewById(R.id.htitle);
		ZView.setText(htitle);

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);

		if(t == 13) {
			LinearLayout LL1 = (LinearLayout) findViewById(R.id.LL1);
			LL1.setVisibility(View.GONE);
		}
		if(t == 14) {
			LinearLayout LL1 = (LinearLayout) findViewById(R.id.LL1);
			LL1.setVisibility(View.GONE);
		}
		if(t == 15) {
			LinearLayout LL1 = (LinearLayout) findViewById(R.id.LL1);
			LL1.setVisibility(View.GONE);
		}
		if(Integer.parseInt(lang) == 0) {
			summary = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body bgcolor=\"#000000\"><font color=\"#FFFFFF\">Internet disconnect</font></body></html>";
			startload = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body bgcolor=\"#000000\"><font color=\"#FFFFFF\">Please wait ...</font></body></html>";
			b1.setText("Yesterday");
			b2.setText("Today");
			b3.setText("Tomorrow");
			b4.setText("Zodiak");
		}

		if(Integer.parseInt(lang) == 1) {
			summary = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body bgcolor=\"#000000\"><font color=\"#FFFFFF\">Нет соединения</font></body></html>";
			startload = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body bgcolor=\"#000000\"><font color=\"#FFFFFF\">Пожалуйста подождите...</font></body></html>";
			b1.setText("Вчера");
			b2.setText("Сегодня");
			b3.setText("Завтра");
			b4.setText("О Знаке");
		}

		if(Integer.parseInt(lang) == 2) {
			summary = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body bgcolor=\"#000000\"><font color=\"#FFFFFF\">Keine Verbindung</font></body></html>";
			startload = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body bgcolor=\"#000000\"><font color=\"#FFFFFF\">Bitte warten...</font></body></html>";
			b1.setText("Gestern");
			b2.setText("Heute");
			b3.setText("Morgen");
			b4.setText("Zeichen");
		}

		if(Integer.parseInt(lang) == 3) {
			summary = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body bgcolor=\"#000000\"><font color=\"#FFFFFF\">Pas de connexion</font></body></html>";
			startload = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body bgcolor=\"#000000\"><font color=\"#FFFFFF\">Merci de patienter...</font></body></html>";
			b1.setText("Hier");
			b2.setText("aujourd'Hui");
			b3.setText("Demain");
			b4.setText("Signe");
		}

		b1.setTextColor(Color.BLACK);
		b2.setTextColor(Color.BLUE);
		b3.setTextColor(Color.BLACK);
		b4.setTextColor(Color.BLACK);

		url = "http://craftask.ru/zodiak/zodiak.php?z=" + zod + "&a=1&l=" + lang + "&t=0&s=" + size;
		url2 = "http://craftask.ru/zodiak/zodiak.php?z=" + zod + "&a=1&l=" + lang + "&t=1&s=" + size;
		url3 = "http://craftask.ru/zodiak/zodiak.php?z=" + zod + "&a=1&l=" + lang + "&t=2&s=" + size;

		/*
		 * if(Integer.parseInt(lang) == 0) {
		 * url = "http://rjump.net/zodiak/en/zodiak.php?z=" + zod + "&t=0&s=" + size;
		 * } else {
		 * url = "http://rjump.net/zodiak/ru/zodiak.php?z=" + zod + "&t=0&s=" + size;
		 * }
		 * if(Integer.parseInt(lang) == 0) {
		 * url2 = "http://rjump.net/zodiak/en/zodiak.php?z=" + zod + "&t=1&s=" + size;
		 * } else {
		 * url2 = "http://rjump.net/zodiak/ru/zodiak.php?z=" + zod + "&t=1&s=" + size;
		 * }
		 * if(Integer.parseInt(lang) == 0) {
		 * url3 = "http://rjump.net/zodiak/en/zodiak.php?z=" + zod + "&t=2&s=" + size;
		 * } else {
		 * url3 = "http://rjump.net/zodiak/ru/zodiak.php?z=" + zod + "&t=2&s=" + size;
		 * }
		 */
		webView = (WebView) findViewById(R.id.webview);
		webView.getSettings().setJavaScriptEnabled(false);
		webView.getSettings().setSupportZoom(false);
		webView.getSettings().setAppCacheEnabled(false);
		webView.setScrollContainer(false);
		webView.setVerticalScrollBarEnabled(false);
		if(isOnline() == false) {
			webView.loadData(summary, "text/html; charset=UTF-8", null);
			return;
		} else {

			gurl = url2;
			// new ATLoadInfo().execute(gurl);
			// LoadInf(gurl);

			// mAdView = (AdView) findViewById(R.id.ad_view);
			// AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
			// AdRequest adRequest = new AdRequest.Builder().build();
			// mAdView.loadAd(adRequest);

			if(t == 13) {
				LoadMoon(lang);
			} else if(t == 14) {
				LoadFeng(lang);
			} else if(t == 15) {
				LoadFeng2(lang);
			} else {
				webView.loadUrl(gurl);
			}
		}
	}

	@Override
	public void onDestroy() {

		super.onDestroy();
	}

	public void LoadMoon(String lang) {
		String result = "";
		webView.loadData(startload, "text/html; charset=UTF-8", null);
		try {
			gurl = url = "http://craftask.ru/zodiak/zodiak.php?a=2&l=" + lang + "&s=" + size;
			webView.loadUrl(gurl);
			Cl = 0;

		} catch(Exception ex) {
			Cl = 0;
			if(Integer.parseInt(lang) == 0) {
				result = "It was not possible to load. Repeat again.";
			}

			if(Integer.parseInt(lang) == 1) {
				result = "Не удалось загрузить. Повторите снова.";
			}

			if(Integer.parseInt(lang) == 2) {
				result = "Konnte nicht geladen werden. Wiederholen Sie den Vorgang.";
			}

			if(Integer.parseInt(lang) == 3) {
				result = "Impossible de télécharger. Répéter à nouveau.";
			}
			webView.loadData("<font size=\"" + size + "\">" + result + "</font>", "text/html; charset=UTF-8", null);
		}

	}

	public void LoadFeng(String lang) {
		String result = "";
		webView.loadData(startload, "text/html; charset=UTF-8", null);
		try {

			gurl = url = "http://craftask.ru/zodiak/zodiak.php?a=3&l=" + lang + "&s=" + size;
			webView.loadUrl(gurl);
			Cl = 0;

		} catch(Exception ex) {
			Cl = 0;
			if(Integer.parseInt(lang) == 0) {
				result = "It was not possible to load. Repeat again.";
			}

			if(Integer.parseInt(lang) == 1) {
				result = "Не удалось загрузить. Повторите снова.";
			}

			if(Integer.parseInt(lang) == 2) {
				result = "Konnte nicht geladen werden. Wiederholen Sie den Vorgang.";
			}

			if(Integer.parseInt(lang) == 3) {
				result = "Impossible de télécharger. Répéter à nouveau.";
			}
			webView.loadData("<font size=\"" + size + "\">" + result + "</font>", "text/html; charset=UTF-8", null);
		}
	}

	public void LoadFeng2(String lang) {
		String result = "";
		webView.loadData(startload, "text/html; charset=UTF-8", null);
		try {
			gurl = url = "http://craftask.ru/zodiak/zodiak.php?a=4&l=" + lang + "&s=" + size;
			webView.loadUrl(gurl);
			Cl = 0;

		} catch(Exception ex) {
			Cl = 0;
			if(Integer.parseInt(lang) == 0) {
				result = "It was not possible to load. Repeat again.";
			}
			if(Integer.parseInt(lang) == 1) {
				result = "Не удалось загрузить. Повторите снова.";
			}

			if(Integer.parseInt(lang) == 2) {
				result = "Konnte nicht geladen werden. Wiederholen Sie den Vorgang.";
			}

			if(Integer.parseInt(lang) == 3) {
				result = "Impossible de télécharger. Répéter à nouveau.";
			}
			webView.loadData("<font size=\"" + size + "\">" + result + "</font>", "text/html; charset=UTF-8", null);
		}
	}

	public boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo nInfo = cm.getActiveNetworkInfo();
		if(nInfo != null && nInfo.isConnected()) {
			return true;
		} else {
			return false;
		}
	}

	public void onClickY(View v) {
		if(Cl != 0) {
			return;
		}
		TextView dateView = (TextView) findViewById(R.id.hdate);
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		Date myDate = new Date();
		myDate.setDate(myDate.getDate() - 1);
		dateView.setText(formatter.format(myDate));
		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);
		b2.setTextColor(Color.BLACK);
		b1.setTextColor(Color.BLUE);
		b3.setTextColor(Color.BLACK);
		b4.setTextColor(Color.BLACK);
		String result = "";
		result = "";
		if(isOnline() == true) {
			gurl = url;
			webView.loadUrl(gurl);
			// new ATLoadInfo().execute();
		} else {
			webView.loadData("<font size=\"" + size + "\">" + summary + "</font>", "text/html; charset=UTF-8", null);
		}
	}

	public void onClickT(View v) {
		if(Cl != 0) {
			return;
		}
		TextView dateView = (TextView) findViewById(R.id.hdate);
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		Date myDate = new Date();
		myDate.setDate(myDate.getDate());
		dateView.setText(formatter.format(myDate));
		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);
		b1.setTextColor(Color.BLACK);
		b2.setTextColor(Color.BLUE);
		b3.setTextColor(Color.BLACK);
		b4.setTextColor(Color.BLACK);
		String result = "";
		result = "";
		if(isOnline() == true) {
			gurl = url2;
			webView.loadUrl(gurl);// new ATLoadInfo().execute();
		} else {
			webView.loadData("<font size=\"" + size + "\">" + summary + "</font>", "text/html; charset=UTF-8", null);
		}
	}

	public void onClickW(View v) {
		if(Cl != 0) {
			return;
		}
		TextView dateView = (TextView) findViewById(R.id.hdate);
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		Date myDate = new Date();
		myDate.setDate(myDate.getDate() + 1);
		dateView.setText(formatter.format(myDate));
		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);
		b1.setTextColor(Color.BLACK);
		b3.setTextColor(Color.BLUE);
		b2.setTextColor(Color.BLACK);
		b4.setTextColor(Color.BLACK);
		String result = "";
		result = "";
		if(isOnline() == true) {
			gurl = url3;
			webView.loadUrl(gurl);// new ATLoadInfo().execute();
		} else {
			webView.loadData("<font size=\"" + size + "\">" + summary + "</font>", "text/html; charset=UTF-8", null);
		}
	}

	public void onClickZ(View v) {

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);
		b1.setTextColor(Color.BLACK);
		b4.setTextColor(Color.BLUE);
		b2.setTextColor(Color.BLACK);
		b3.setTextColor(Color.BLACK);
		if(Integer.parseInt(lang) == 0) {
			webView.loadUrl("file:///android_asset/en/" + htag + ".html");
		}
		if(Integer.parseInt(lang) == 1) {
			webView.loadUrl("file:///android_asset/" + htag + ".html");
		}
		if(Integer.parseInt(lang) == 2) {
			webView.loadUrl("file:///android_asset/de/" + htag + ".html");
		}
		if(Integer.parseInt(lang) == 3) {
			webView.loadUrl("file:///android_asset/fr/" + htag + ".html");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if(Integer.parseInt(lang) == 0) {
			menu.add(group1Id, saveId, saveId, "Save");
			menu.add(group1Id, loadId, loadId, "Load");
			menu.add(group1Id, refId, refId, "Rotate");
		}

		if(Integer.parseInt(lang) == 1) {
			menu.add(group1Id, saveId, saveId, "Сохранить");
			menu.add(group1Id, loadId, loadId, "Загрузить");
			menu.add(group1Id, refId, refId, "Повернуть");
		}

		if(Integer.parseInt(lang) == 2) {
			menu.add(group1Id, saveId, saveId, "Speichern");
			menu.add(group1Id, loadId, loadId, "Laden");
			menu.add(group1Id, refId, refId, "Drehen");
		}

		if(Integer.parseInt(lang) == 3) {
			menu.add(group1Id, saveId, saveId, "Enregistrer");
			menu.add(group1Id, loadId, loadId, "Télécharger");
			menu.add(group1Id, refId, refId, "Tourner");
		}
		return super.onCreateOptionsMenu(menu);
	}

	public void saveInfo() {
		Log.d("DownloadManager", gurl);
		new DownloadTask().execute();

	}

	private class DownloadTask extends AsyncTask<Void, Void, Void> {

		protected void onPostExecute(Void result) {
			String saves = "";
			if(Integer.parseInt(lang) == 0) {
				saves = "Saved";
			}
			if(Integer.parseInt(lang) == 1) {
				saves = "Сохранено";
			}
			if(Integer.parseInt(lang) == 2) {
				saves = "Gespeichert";
			}
			if(Integer.parseInt(lang) == 3) {
				saves = "Enregistré";
			}

			Toast.makeText(horoInfo1.this, saves, Toast.LENGTH_SHORT).show();
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			DownloadFromUrl(gurl, htag + lang + ".xml");
			return null;
		}
	}

	public void loadInfo() {

		String saves = "";
		if(Integer.parseInt(lang) == 0) {
			saves = "Loaded";
		}
		if(Integer.parseInt(lang) == 1) {
			saves = "Загружено";
		}
		if(Integer.parseInt(lang) == 2) {
			saves = "Hochgeladen";
		}
		if(Integer.parseInt(lang) == 3) {
			saves = "Transféré";
		}
		String info = "";
		FileExp fe = new FileExp();
		File root = android.os.Environment.getExternalStorageDirectory();
		String cpath = root.getAbsolutePath() + "/xmls/" + htag + lang + ".xml";
		if(fe.ExistsFile(cpath)) {
			List<String> LS = new ArrayList<String>();
			fe.ReadStringsFile(cpath, LS);

			for(String s : LS) {
				info = info + s;
			}

			info = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body><font size=\"" + size + "\">" + info + "</font></body><html>";
			// Log.w("d", info);

			webView.loadData(info.replace('%', ' '), "text/html; charset=UTF-8", null);
		}
		Toast.makeText(horoInfo1.this, saves, Toast.LENGTH_SHORT).show();

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch(item.getItemId())
			{
				case 1:
					// write your code here
					saveInfo();
					return true;

				case 2:
					// code here
					// write your code here
					loadInfo();
					return true;
				case 3:
					// code here
					// write your code here
					if(Pl == 0) {
						setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
						Pl = 1;
					} else {

						setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
						Pl = 0;
					}
					webView.loadUrl(gurl);
					return true;
				default:
					break;

			}
		return super.onOptionsItemSelected(item);
	}

}