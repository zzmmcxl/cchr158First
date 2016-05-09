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

public class DeencoderService extends IntentService
{
    public boolean IIIIIIlll;
    public String IIIIIlIll;
    public Bitmap IIIIlIIlI;
    public StringBuilder IIIIlIllI;
    public int IIIIlIlll;
    public Bitmap IIlIlIlII;
    public char IlIIIllIl;
    public RandomPointGenerator IlIlIllll;
    public char lIIlIlIII;
    public int lIlllllII;
    public StringBuilder llIlIIIll;
    public Point llIlIllll;
    public Uri lllIlIIIl;
    public Intent lllIlIlll;
    public char llllllIII;
    
    public DeencoderService() {
        super(EncoderService.class.getName());
        IlIIIllIl = "\u0002\u0002".charAt(0);
        lIIlIlIII = "\u0003\t".charAt(0);
    }
    
    public char getCharForBits(final String s) {
        return (char)Integer.parseInt(s, 2);
    }
    
    public String getHiddenText(final Bitmap bitmap) {
        IIIIllIlll.l(this, bitmap);
        while (lIlllllII != 16 || llllllIII != lIIlIlIII) {
            IIIIIlIlIl.l(this, bitmap);
            if (lIlllllII == 16) {
                llIlIlIIIl.l(this, bitmap);
                if (llIlIIIll.length() == 0 && !IIIIIIlll) {
                    if (llllllIII != IlIIIllIl) {
                        return "Invalid Image: Image has no text hidden in it";
                    }
                    llllllIlIl.l(this, bitmap);
                }
                else {
                    lIIIIIIIIl.l(this, bitmap);
                }
                IIIIIIlIII.l(this, bitmap);
            }
            lllIlIlIll.l(this, bitmap);
        }
        return llIlIIIll.toString();
    }
    
    protected void onHandleIntent(final Intent intent) {
        IIIIlIlIll.l(this, intent);
    }
    
    public void sendBroadcast(final String s, final String s2) {
        IIIIlIlllI.l(this, s, s2);
    }
}
