public class Shape_Shifter {
    public static void main(String[] args) {
        //The 6 Primary Shapes:
        printComment("Horizontal Line:"); //Just the usual System.out.println(). For reducing mess in main().
        drawHorizontalLine(30);
        println(2);

        printComment("Vertical Line:");
        drawVerticalLine(30, 30);
        println(1);

        printComment("Rectangle:");
        drawRectangle(40, 20, 10);
        println(1);

        printComment("Square:");
        drawSquare(20, 10);
        println(1);

        printComment("Up Triangle:");
        drawUpTriangle(20, 10);
        println(1);

        printComment("Down Triangle:");
        drawDownTriangle(20, 10);
        println(1);

        //the House
        printComment("House");
        drawUpTriangle(15,0);
        drawRectangle(5, 5, 0);
        println(1);

        //My own custom complex shape
        printSpace(35);
        System.out.println("This is a Christmas Tree!");
        drawUpTriangle(10, 40);
        drawUpTriangle(30, 30);
        drawUpTriangle(50, 20);
        drawRectangle(5, 3, 37);
        println(1);

        ////Created by Baijian Xie
        printComment("Dumbbell");
        drawRectangle(10,5,0);
        drawVerticalLine(8,13);
        drawRectangle(10, 5, 0 );
        println(1);

        //Created by Maeve Fitzpatrick
        printComment("Pencil & Paper");
        drawRectangle(4, 5, 0);
        drawRectangle(4, 5, 0);
        drawRectangle(4, 5, 0);
        drawDownTriangle(10,0);
        drawRectangle(30, 2, 0);
        println(1);
    }

    //Helper methods:
    public static void printAst(int n){
        for (int i = 1; i <= n; i++){
            System.out.print('*');
        }
    }

    public static void printSpace (int n){
        for (int i = 1; i <= n; i++){
            System.out.print(' ');
        }
    }

    public static void println (int n){
        for (int i = 1; i <= n; i++){
            System.out.println("");
        }
    }

    public static void printComment (String args){ //idk why. I was getting annoyed, I guess
        System.out.println(args);
    }

    //Main methods:
    //    drawHorizontalLine: This method will display a horizontal line using asterisks
    public static void drawHorizontalLine(int n){
        for(int i = 1; i <= n; i++){
            printAst(1);
            printSpace(2);
        }
    }//Draw horizontal line does not need a distFromLeft. Could be done separately. Also I need it to fit into other methods
    //generic printAsk method and drawHorizontalLine method can't be merged
    //          because width of 10 asterisks in drawHorizontalLine is several times shorter than 10 asterisks in drawVerticalLine. Ratio is approx 1:3.

    //    drawVerticalLine: This method will display a vertical line using asterisks
    public static void drawVerticalLine(int n, int distFromLeft) {
        for (int i = 1; i <= n; i++){
            printSpace(distFromLeft);

            printAst(1);
            println(1);
        }

    }

    //merge the in input first
    //    drawRectangle: This method will display a rectangle using asterisks
    public static void drawRectangle(int width, int height, int distFromLeft){//Major problem: println naturally produces height that is 3x the horizontal width of an Asterisk
        printSpace(distFromLeft);

        drawHorizontalLine(width);
        println(1);
        for(int i = 1; i <= height - 1 ; i++){//added height -1 once I realized this makes for less deformity at a lower magnitude of dimensions while at higher magnitude it's not as noticible.
            printSpace(distFromLeft);

            printAst(1);
            printSpace(3*(width-2) +2);
            //3 is space between asterisks horizontally to imitate the spacing between lines
            //-2 is to account for the 2 edges
            //+2 is to account for a spacing error after adding distFromLeft. distFromLeft is a variable to make shapes not stick to the leftmost end.
            printAst(1);
            println(1);
        }
        printSpace(distFromLeft);
        drawHorizontalLine(width);
        println(1);
    }

    //    drawSquare: This method will display a square using asterisks
    public static void drawSquare(int width, int distFromLeft){//20 and above works best for this setup
        int height = width;

        printSpace(distFromLeft);

        drawHorizontalLine(width);
        println(1);
        for(int i = 1; i <= height; i++){
            printSpace(distFromLeft);

            printAst(1);
            printSpace(3*(width-2) +2);
            printAst(1);
            println(1);
        }

        printSpace(distFromLeft);

        drawHorizontalLine(width);
        println(1);
    }    //Due to horizontal and vertical spacing varying, it was hard to find optimal ratio for the square function.
    //This setup approaches square ratio at larger dimensions. Integer greater than 10 or 15 as input would look fine.

    //    drawUpTriangle: This method will display a triangle pointed up using asterisks
    public static void drawUpTriangle(int baseWidth, int distFromLeft){
//        int medLinePos = 40;
//        int baseWidth = 2*medLinePos;

        //dimensions
        int medLinePos = (int)(baseWidth/2.0);//casting

        int height = (int)(baseWidth/3.0);
        //Checking this works:
//        System.out.println(baseWidth);
//        System.out.println(height);
        int nthRow;

        //first point
        printSpace(distFromLeft);

        printSpace(medLinePos-1);
        printAst(1);
        println(1);

        //slopes in middle
        for (nthRow = 0; nthRow < height ; nthRow++){
            printSpace(distFromLeft);

            printSpace(medLinePos-2-nthRow);
            printAst(1);
            printSpace(1 + 2*nthRow);
            printAst(1);
            println(1);
        }

        //last line
        nthRow = height;
        printSpace(distFromLeft);
        printSpace(medLinePos-2-nthRow);
//        drawHorizontalLine(nthRow);//wourldn't work, need to customize the spacing
        for(int i = 1; i <= nthRow+2; i++){
            printAst(1);
            printSpace(1);
        }
        println(1);


    }

    //    drawDownTriangle: This method will display a triangle pointed down using asterisks
    public static void drawDownTriangle(int baseWidth, int distFromLeft){

        //dimensions
        int medLinePos = (int)(baseWidth/2.0);
        int height = (int)(baseWidth/3.0);
        int nthRow;

        //top line
        printSpace(distFromLeft);

        nthRow = height;
        printSpace(medLinePos-2-nthRow);
        //        drawHorizontalLine(nthRow);//wouldn't work, need to customize the spacing
        for(int i = 1; i <= nthRow+2; i++){
            printAst(1);
            printSpace(1);
        }
        println(1);

        //slopes in middle
        for (nthRow = height; nthRow > 0 ; nthRow--){
            printSpace(distFromLeft);
            printSpace(medLinePos-2-nthRow);
            printAst(1);
            printSpace(1 + 2*nthRow);
            printAst(1);
            println(1);
        }

        //last point
        printSpace(distFromLeft);
        printSpace(medLinePos-1);
        printAst(1);
        println(1);
    }

}