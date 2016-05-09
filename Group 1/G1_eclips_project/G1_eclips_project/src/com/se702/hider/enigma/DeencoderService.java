package com.se702.hider.enigma;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import android.content.Intent;
import android.net.Uri;
import android.graphics.Point;
import android.graphics.Bitmap;
import android.app.IntentService;

public class DeencoderService extends IntentService {

    public boolean $7;
    public String $11;
    public Bitmap $18;
    public StringBuilder $22;
    public int $23;
    public Bitmap $84;
    public char $141;
    public RandomPointGenerator randomPointGen;
    public char $296;
    public int $380;
    public StringBuilder $419;
    public Point $431;
    public Uri $465;
    public Intent $471;
    public char $504;

    public DeencoderService() {
        super(EncoderService.class.getName());
        $141 = "\u0002\u0002".charAt(0);
        $296 = "\u0003\t".charAt(0);
    }

    public char getCharForBits(final String s) {
        return (char) Integer.parseInt(s, 2);
    }

    public String getHiddenText(final Bitmap bitmap) {
        randomPointGen = new RandomPointGenerator(bitmap.getHeight(), bitmap.getWidth());
        this.$7 = false;
        this.$380 = 0;
        this.$504 = 'a';
        this.$419 = new StringBuilder();
        this.$22 = new StringBuilder();
        while ($380 != 16 || $504 != $296) {
            this.$431 = this.randomPointGen.getNextRandomPoint();
            if ($380 == 16) {
                this.$504 = this.getCharForBits(this.$22.toString());
                if ($419.length() == 0 && !$7) {
                    if ($504 != $141) {
                        return "Invalid Image: Image has no text hidden in it";
                    }
                    this.$7 = true;
                } else {
                    this.$419.append(this.$504);
                }
                this.$22.setLength(0);
                this.$380 = 0;
            }
            this.$23 = bitmap.getPixel(this.$431.x, this.$431.y);
            if (Color.red(this.$23) % 2 == 0) {
                this.$22.append("0");
            } else {
                this.$22.append("1");
            }
            ++this.$380;
        }
        return $419.toString();
    }

    protected void onHandleIntent(final Intent intent) {
        this.$18 = null;
        this.$465 = null;
        if (intent.getStringExtra("imageURI") != null) {
            this.$465 = Uri.parse(intent.getStringExtra("imageURI"));
            try {
                this.$18 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), this.$465);
            } catch (Exception ex) {
            }
        }
        if (this.$18 != null) {
            this.$84 = this.$18.copy(Bitmap.Config.ARGB_8888, true);
            this.$11 = this.getHiddenText(this.$84);
            this.sendBroadcast(this.$11, this.$465.toString());
        }
    }

    public void sendBroadcast(final String s, final String s2) {

        this.$471 = new Intent("BReceivermessage");
        this.$471.putExtra("output", s);
        this.$471.putExtra("imageURI", s2);
        LocalBroadcastManager.getInstance((Context) this).sendBroadcast(this.$471);
    }
}