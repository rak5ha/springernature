package com.springernature;

import com.springernature.product.Canvas;

import java.util.Scanner;

/**
 * Main class into the application.
 */
public class App {

    public static final String quitCmd = "Q";
    private static Canvas canvas;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = null;
	    do  {
            System.out.print("Enter Command:");
            command = scanner.nextLine();
            issueCommand(command);

        } while (!command.equals(quitCmd));

       /* Canvas myCanvas = new Canvas(4, 20);
        myCanvas.drawLine(1,2,6,2);
        myCanvas.drawLine(6,3,6,4);
        myCanvas.drawRectangle(16, 1, 10, 3);
        myCanvas.fill(10,3, 'o');
        myCanvas.draw();*/
    }


    private static void issueCommand(String command)  {

        command = command.trim();
        String[] args = command.split(" ");
        char cmd = args[0].charAt(0);

        try {
            switch (cmd) {
                case 'C':
                    canvas = new Canvas(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                    canvas.draw();
                    break;
                case 'L':
                    if (canvas == null) {
                        System.out.println("Canvas has not been set. Please set canvas using command C x y where x = width and y = height");
                    }
                    canvas.drawLine(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
                    canvas.draw();
                    break;
                case 'R':
                    if (canvas == null) {
                        System.out.println("Canvas has not been set. Please set canvas using command C x y where x = width and y = height");
                    }
                    try {
                        canvas.drawRectangle(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]));
                        canvas.draw();
                    } catch ( RuntimeException rte) {
                        System.out.println(rte.getMessage());
                    }

                    break;
                case 'B':
                    if (canvas == null) {
                        System.out.println("Canvas has not been set. Please set canvas using command C x y where x = width and y = height");
                    }
                    canvas.fill(Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3].charAt(0));
                    canvas.draw();
                    break;
                case 'Q' :
                    return;
                default:
                    System.out.println("Invalid command entered. Valid commands are 'C, 'L', 'R', 'B' or 'Q to quit ");
                    break;
            }
        }
        catch (ArrayIndexOutOfBoundsException aob) {
            System.out.println("Incorrect no of arguments provided for command:  " + cmd);
        } catch (NumberFormatException nfe) {
            System.out.println("Incorrect argument. Please specify correct integer");
        } catch (Exception e) {
            System.out.println("Sorry your command cant not be processed at this time");
        }




    }
}
