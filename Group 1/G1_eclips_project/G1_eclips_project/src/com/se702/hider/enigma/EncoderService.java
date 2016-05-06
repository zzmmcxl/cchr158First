package com.se702.hider.enigma;

import android.content.Intent;
import android.net.Uri;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.graphics.Point;
import java.io.File;
import java.io.FileOutputStream;

import android.graphics.Bitmap;
import android.app.IntentService;

public class EncoderService extends IntentService {
	public Bitmap $0;
	public String fileName;
	public char $16;
	public String $50;
	public RandomPointGenerator randomPointGen;
	public StringBuilder $97;
	public File inFile;
	public char $140;
	public String date;
	public int $279;
	public File outFile;
	public int $292;
	public Point $301;
	public Bitmap $304;
	public File $312;
	public OutputStream $341;
	public Uri $388;
	public int $450;
	public Intent $474;
	public int $481;
	public int $496;
	public Uri $502;
	public String $510;

	public EncoderService() {
		super(EncoderService.class.getName());
		$16 = "\u0002\u0002".charAt(0);
		$140 = "\u0003\t".charAt(0);
	}

	private char getCharForBits(final String s) {
		return (char) Integer.parseInt(s, 2);
	}

	public String getBitsForPos(final String s, final int n) {
		this.$97 = new StringBuilder(Integer.toBinaryString(s.charAt(n)));
		while (this.$97.length() < 16) {
			this.$97.insert(0, "0");
		}
		return $97.toString();
	}

	public File getFileDestination() {
		this.inFile = new File(Environment.getExternalStorageDirectory() + "/DCIM/Encoder");
		if (!inFile.exists() && !inFile.mkdirs()) {
			return null;
		}
		this.date = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
		this.fileName = "ENCODED_" + this.date + ".png";
		this.outFile = new File(this.inFile.getPath() + File.separator + this.fileName);
		return outFile;
	}

	public void hideText(final Bitmap bitmap, final String s) {
		this.randomPointGen = new RandomPointGenerator(bitmap.getHeight(), bitmap.getWidth());
		this.$279 = 0;
		this.$496 = 0;
		this.$510 = "";
		while (this.$496 != this.$510.length() || this.$279 != s.length()) {
			this.$301 = this.randomPointGen.getNextRandomPoint();
			if (this.$496 == this.$510.length()) {
				this.$510 = this.getBitsForPos(s, this.$279);
				this.$496 = 0;
				$910.$1(this, bitmap, s);
			}
			this.$481 = Integer.parseInt(this.$510.substring(this.$496, 1 + this.$496));
			++this.$496;
			this.$292 = bitmap.getPixel(this.$301.x, this.$301.y);
			this.$450 = Color.red(this.$292);
			if (this.$450 % 2 == 1) {
				--this.$450;
			}
			this.$450 += this.$481;
			bitmap.setPixel(this.$301.x, this.$301.y, Color.argb(Color.alpha(this.$292),
					this.$450, Color.green(this.$292), Color.blue(this.$292)));
		}
		try {
			this.$312 = this.getFileDestination();
			 this.$341 = new FileOutputStream(this.$312);
			 bitmap.compress(Bitmap$CompressFormat.PNG, 100, this.$341);
			 this.$341.close();
			 this.$502 = Uri.fromFile(this.$312);
			 this.$474 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
			 this.$474.setData(this.$502);
			 this.sendBroadcast(this.$474);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
	}

	protected void onHandleIntent(final Intent intent) {
		if (intent.getStringExtra("imageURI") != null) {
			this.$388 = Uri.parse(intent.getStringExtra("imageURI"));
			try {
	            this.$304 = MediaStore$Images$Media.getBitmap(this.getContentResolver(), this.$388);
	        }
	        catch (Exception ex) {}
        }
		if (this.$304 != null) {
			this.$0 = this.$304.copy(Bitmap$Config.ARGB_8888, true);
			this.$50 = intent.getStringExtra("message");
			if (this.$50.equals("") || this.$50.equals(null)) {
				this.$50 = "Enter a message in !!!!";
	        }
			this.hideText(this.$0, this.$50);
        }
	}
}
