import java.util.Scanner;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public static Position inputPosition() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (input.length() == 2 || (input.length() == 3 && input.contains("10"))) {
            String letter = String.valueOf(input.toCharArray()[0]).toUpperCase();
            int number = Integer.parseInt(String.valueOf(input.toCharArray()[1]));
            if (input.length() == 3){
                number = 9;
            }

            if (number < 10 && number >= 0 && Letters.containsLetter(letter)) {
                return new Position(Letters.toNumber(letter), number);
            }
        }
        System.out.println("insert a valid position");
        return inputPosition();
    }
}
