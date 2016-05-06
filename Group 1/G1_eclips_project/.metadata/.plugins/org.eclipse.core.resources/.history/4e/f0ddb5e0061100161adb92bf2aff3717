package com.se702.hider.enigma;

import java.util.Random;
import android.graphics.Point;
import java.util.ArrayList;

class RandomPointGenerator
{
    private int IIIlIlllI;
    private ArrayList<Point> IlIllllIl;
    private Random lIIIIllll;
    private int llIlIIIll;
    
    public RandomPointGenerator(final int iiIlIlllI, final int llIlIIIll) {
        super();
        IIIlIlllI = iiIlIlllI;
        llIlIIIll = llIlIIIll;
        lIIIIllll = new Random(this.getRandomSeedFromDimensions());
        IlIllllIl = new ArrayList<Point>();
    }
    
    private Point getRandomPoint() {
        return new Point(lIIIIllll.nextInt(llIlIIIll), lIIIIllll.nextInt(IIIlIlllI));
    }
    
    private int getRandomSeedFromDimensions() {
        return IIIlIlllI * llIlIIIll;
    }
    
    public Point getNextRandomPoint() {
        Point point;
        for (point = this.getRandomPoint(); IlIllllIl.contains(point); point = this.getRandomPoint()) {}
        IlIllllIl.add(point);
        return point;
    }
}
