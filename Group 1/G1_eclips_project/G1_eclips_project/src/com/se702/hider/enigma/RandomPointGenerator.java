package com.se702.hider.enigma;

import java.util.Random;
import android.graphics.Point;
import java.util.ArrayList;

class RandomPointGenerator
{
    private int hight;
    private ArrayList<Point> points;
    private Random rand;
    private int width;
    
    public RandomPointGenerator(final int hight, final int width) {
        super();
        this.hight = hight;
        this.width = width;
        rand = new Random(this.getRandomSeedFromDimensions());
        points = new ArrayList<Point>();
    }
    
    private Point getRandomPoint() {
        return new Point(rand.nextInt(width), rand.nextInt(hight));
    }
    
    private int getRandomSeedFromDimensions() {
        return hight * width;
    }
    
    public Point getNextRandomPoint() {
        Point point;
        for (point = this.getRandomPoint(); points.contains(point); point = this.getRandomPoint()) {}
        points.add(point);
        return point;
    }
}
