import java.util.*;

public class Player {
    private String name;
    private String[][] grid = new String[10][10];
    private Queue<Ship> ships = new LinkedList<>();

    public Player(String name) {
        this.name = name;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
            }
        }

        ships.add(new Ship("Carrier", 5));
        ships.add(new Ship("Battleship", 4));
        ships.add(new Ship("Cruiser", 3));
        ships.add(new Ship("Submarine", 3));
        ships.add(new Ship("Destroyer", 2));
    }

    public void printGrid() {
        System.out.print("      1   2   3   4   5   6   7   8   9   10 \n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  1 | " + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] + " | " + grid[0][3] + " | " + grid[0][4] + " | " + grid[0][5] + " | " + grid[0][6] + " | " + grid[0][7] + " | " + grid[0][8] + " | " + grid[0][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  2 | " + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] + " | " + grid[1][3] + " | " + grid[1][4] + " | " + grid[1][5] + " | " + grid[1][6] + " | " + grid[1][7] + " | " + grid[1][8] + " | " + grid[1][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  3 | " + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2] + " | " + grid[2][3] + " | " + grid[2][4] + " | " + grid[2][5] + " | " + grid[2][6] + " | " + grid[2][7] + " | " + grid[2][8] + " | " + grid[2][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  4 | " + grid[3][0] + " | " + grid[3][1] + " | " + grid[3][2] + " | " + grid[3][3] + " | " + grid[3][4] + " | " + grid[3][5] + " | " + grid[3][6] + " | " + grid[3][7] + " | " + grid[3][8] + " | " + grid[3][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  5 | " + grid[4][0] + " | " + grid[4][1] + " | " + grid[4][2] + " | " + grid[4][3] + " | " + grid[4][4] + " | " + grid[4][5] + " | " + grid[4][6] + " | " + grid[4][7] + " | " + grid[4][8] + " | " + grid[4][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  6 | " + grid[5][0] + " | " + grid[5][1] + " | " + grid[5][2] + " | " + grid[5][3] + " | " + grid[5][4] + " | " + grid[5][5] + " | " + grid[5][6] + " | " + grid[5][7] + " | " + grid[5][8] + " | " + grid[5][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  7 | " + grid[6][0] + " | " + grid[6][1] + " | " + grid[6][2] + " | " + grid[6][3] + " | " + grid[6][4] + " | " + grid[6][5] + " | " + grid[6][6] + " | " + grid[6][7] + " | " + grid[6][8] + " | " + grid[6][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  8 | " + grid[7][0] + " | " + grid[7][1] + " | " + grid[7][2] + " | " + grid[7][3] + " | " + grid[7][4] + " | " + grid[7][5] + " | " + grid[7][6] + " | " + grid[7][7] + " | " + grid[7][8] + " | " + grid[7][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  9 | " + grid[8][0] + " | " + grid[8][1] + " | " + grid[8][2] + " | " + grid[8][3] + " | " + grid[8][4] + " | " + grid[8][5] + " | " + grid[8][6] + " | " + grid[8][7] + " | " + grid[8][8] + " | " + grid[8][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print(" 10 | " + grid[9][0] + " | " + grid[9][1] + " | " + grid[9][2] + " | " + grid[9][3] + " | " + grid[9][4] + " | " + grid[9][5] + " | " + grid[9][6] + " | " + grid[9][7] + " | " + grid[9][8] + " | " + grid[9][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
    }

    public void putShips() {
        for (Ship s : ships) {
            printGrid();
            System.out.println("Where do you wanna put your:" + s.getName() + "Size:" + s.getName() + "? (Ex: B1");
            Position position = Position.inputPosition();
            System.out.println("Which direction you wanna put the boat? H - horizontal V - vertical");
            String direction = inputDirection();
            if (direction.equals("V") && (position.getColumn() + s.getSize()) > 9) {
                position.setColumn(position.getColumn() - (s.getSize() - 9));
                for (int i = (9); i < s.getSize(); i++) {
                    grid[position.getRow()][i] = "=";
                }
                return;
            }
            if (direction.equals("H") && (position.getRow() + s.getSize()) > 9) {
                position.setRow(position.getRow() - (s.getSize() - 9));
                for (int i = 0; i < s.getSize(); i++) {
                    grid[position.getRow() + i][position.getColumn()] = "=";
                }
                return;
            }
            if (direction.equals("V")){
                for (int i = 0; i < s.getSize(); i++) {
                    grid[position.getRow()][position.getColumn() + i] = "=";
                }

            }
            if (direction.equals("H")){
                for (int i = 0; i < s.getSize(); i++) {
                    grid[position.getRow() + i][position.getColumn()] = "=";
                }
            }

        }
    }

    private String inputDirection() {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.next().toUpperCase();
        if (in.equals("H")){
            return in;
        }
        if (in.equals("V")){
            return in;
        }
        System.out.println(in + " is not a direction");
        return inputDirection();
    }
}
