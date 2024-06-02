public class ShapeShifter2 {
    public static void main(String[] args) {
        drawShapes();
    }

    private static void drawShapes() {
        drawShape("Horizontal Line", () -> drawHorizontalLine(30), 2);
        drawShape("Vertical Line", () -> drawVerticalLine(30, 30), 1);
        drawShape("Rectangle", () -> drawRectangle(40, 20, 10), 1);
        drawShape("Square", () -> drawSquare(20, 10), 1);
        drawShape("Up Triangle", () -> drawTriangle(true, 20, 10), 1);
        drawShape("Down Triangle", () -> drawTriangle(false, 20, 10), 1);
        drawShape("House", () -> {
            drawTriangle(true, 15, 0);
            drawRectangle(5, 5, 0);
        }, 1);
        drawCustomShapes();
    }

    private static void drawShape(String name, Runnable shapeDrawer, int newLinesAfter) {
        System.out.println(name + ":");
        shapeDrawer.run();
        printNewLines(newLinesAfter);
    }

    private static void drawCustomShapes() {
        // Add custom shapes similar to the drawShape method calls
    }

    private static void printAsterisks(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static void printNewLines(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println();
        }
    }

    private static void drawHorizontalLine(int length) {
        printAsterisks(length);
        System.out.println();
    }

    private static void drawVerticalLine(int height, int padding) {
        for (int i = 0; i < height; i++) {
            printSpaces(padding);
            printAsterisks(1);
            System.out.println();
        }
    }

    private static void drawRectangle(int width, int height, int padding) {
        for (int i = 0; i < height; i++) {
            printSpaces(padding);
            printAsterisks(width);
            System.out.println();
        }
    }

    private static void drawSquare(int side, int padding) {
        drawRectangle(side, side, padding);
    }

    private static void drawTriangle(boolean isUpwards, int baseWidth, int padding) {
        int height = baseWidth / 2;
        for (int i = 0; i <= height; i++) {
            int spaces = isUpwards ? height - i : i;
            int asterisks = isUpwards ? i * 2 + 1 : (height - i) * 2 + 1;
            printSpaces(padding + spaces);
            printAsterisks(asterisks);
            System.out.println();
        }
    }
}
