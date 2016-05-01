package com.springernature.product;

/**
 * Created by rkotecha on 1/05/2016.
 * Canvas - this class can be used to initialise canvas and various drawing commands.
 *
 */
public class Canvas {

    private char [][] cnvsArray;
    private int width; //cols
    private int height; //rows

    private final char verticalChar = '-';
    private final char horizontalChar = '|';
    private final char lineChar = 'x';
    private final char spaceChar = '\u0000';


    public Canvas (int rows, int cols) {
        this.height = rows+2; //top and bottom lines.
        this.width = cols+2;
        initCanvasArray();
    }

    /*
    *  This method will initialise the Canvas to the height and width supplied in the constructor.
     */
    private void initCanvasArray() {
        cnvsArray = new char[this.height][this.width];

        drawLine(0, 0, width-1, 0, verticalChar); //Top border
        drawLine(0, 1, 0, height-2, horizontalChar); //left border
        drawLine(width-1, 1, width-1, height-2, horizontalChar); //right
        drawLine(0, height-1, width-1, height-1, verticalChar); //bottom border

    }

    /**
     * This method will draw a line from coordinate X1,Y1 to X2,Y2
     * @param x1 - makes up the first point X coordinate
     * @param y1 - makes up the first point Y coordinate
     * @param x2 - makes up the second point X coordinate
     * @param y2 - makes up up the first point y coordinate
     */
    public void drawLine(int x1, int y1, int x2, int y2 ) {
        drawLine(x1, y1, x2, y2, lineChar);

    }

    private void drawLine(int x1, int y1, int x2, int y2 , char character) {

        for (int row=y1; row <= y2 ;row++) {
            for (int col=x1; col<=x2; col++) {
                cnvsArray[row][col] = character;
            }

        }

    }

    /**
     * Draw the status of the current canvas.
     */
    public void draw() {

        for (int row=0; row < height; row ++) {
            for (int col=0; col < width; col++) {
                System.out.print(cnvsArray[row][col]);
            }
            System.out.println();

        }
    }

    /**
     * This method will draw a rectangle on the canvas.
     * @param x1 - makes up the top left X coordinate
     * @param y1 - makes up the top left y coordinate
     * @param x2- makes up the bottom right  X coordinate
     * @param y2 - makes up the bottom right Y coordinate
     * @Throws RuntimeException - if the coordinates do not make up the top left and bottom right of the rectangle.
     */
    public void drawRectangle(int x1, int y1, int x2, int y2) {
        drawRectangle(x1, y1, x2, y2, lineChar);
    }

    private void drawRectangle(int x1, int y1, int x2, int y2, char character) {

        // check if the coordinates are correct
        if (x2 <= x1 || y2 <= y1 ) {
            //throw runtime exception - coordinates need to make up top left and botom right.
            throw  new RuntimeException("Coordinates should make up the top left and bottom right coordinates. i.e. x1 < x2 and y1 < y2");
        }
        Point topLeft = new Point(x1, y1);
        Point topRight = new Point(x2, y1);
        Point bottomLeft = new Point(x1, y2);
        Point bottomRight = new Point(x2, y2);

        //draw the lines of the rectangle
        drawLine(topLeft.getXCoordinate(), topLeft.getYCoordinate(), topRight.getXCoordinate(), topRight.getYCoordinate(),character );
        drawLine(topLeft.getXCoordinate(), topLeft.getYCoordinate(), bottomLeft.getXCoordinate(), bottomLeft.getYCoordinate(), character);
        drawLine(topRight.getXCoordinate(), topRight.getYCoordinate(), bottomRight.getXCoordinate(), bottomRight.getYCoordinate(), character);
        drawLine(bottomLeft.getXCoordinate(), bottomLeft.getYCoordinate(), bottomRight.getXCoordinate(), bottomRight.getYCoordinate(), character);

    }


    /**
     * This method will 'bucket fill' the canvas using the char passed in.
     * @param x - start X coordinate
     * @param y - start Y coordinate
     * @param character - the character to bucket fill the canvas with
     */
    public void fill(int x, int y, char character) {

        //reached the borders
        if ( x < 0 || x >= width || y < 0 || y >= height) {
            return;
        }
        //hit an edge of previously drawn line or rectangle
        if (cnvsArray[y][x] != spaceChar) {
            return;
        }

        cnvsArray[y][x] = character;
        fill(x-1, y, character);
        fill(x, y-1, character);
        fill(x, y+1, character);
        fill(x+1, y, character);

    }

}
