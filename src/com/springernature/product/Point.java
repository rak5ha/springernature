package com.springernature.product;

/**
 * Created by rkotecha on 01/05/2016.
 * Point Class - coordinates.
 */
public class Point {

    private int xCoordinate;
    private int yCoordinate;

    public Point (int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }
}
