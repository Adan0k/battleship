import java.util.*;

public class Player {
    private String name;
    private String[][] grid = new String[10][10];
    private String[][] enemyGrid = new String[10][10];
    private Queue<Ship> ships = new LinkedList<>();

    public Player(String name) {
        this.name = name;

        for (int i = 0; i < enemyGrid.length; i++) {
            for (int j = 0; j < enemyGrid[i].length; j++) {
                enemyGrid[i][j] = " ";
                enemyGrid[i][j] = " ";
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
        System.out.print("  A | " + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] + " | " + grid[0][3] + " | " + grid[0][4] + " | " + grid[0][5] + " | " + grid[0][6] + " | " + grid[0][7] + " | " + grid[0][8] + " | " + grid[0][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  B | " + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] + " | " + grid[1][3] + " | " + grid[1][4] + " | " + grid[1][5] + " | " + grid[1][6] + " | " + grid[1][7] + " | " + grid[1][8] + " | " + grid[1][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  C | " + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2] + " | " + grid[2][3] + " | " + grid[2][4] + " | " + grid[2][5] + " | " + grid[2][6] + " | " + grid[2][7] + " | " + grid[2][8] + " | " + grid[2][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  D | " + grid[3][0] + " | " + grid[3][1] + " | " + grid[3][2] + " | " + grid[3][3] + " | " + grid[3][4] + " | " + grid[3][5] + " | " + grid[3][6] + " | " + grid[3][7] + " | " + grid[3][8] + " | " + grid[3][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  E | " + grid[4][0] + " | " + grid[4][1] + " | " + grid[4][2] + " | " + grid[4][3] + " | " + grid[4][4] + " | " + grid[4][5] + " | " + grid[4][6] + " | " + grid[4][7] + " | " + grid[4][8] + " | " + grid[4][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  F | " + grid[5][0] + " | " + grid[5][1] + " | " + grid[5][2] + " | " + grid[5][3] + " | " + grid[5][4] + " | " + grid[5][5] + " | " + grid[5][6] + " | " + grid[5][7] + " | " + grid[5][8] + " | " + grid[5][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  G | " + grid[6][0] + " | " + grid[6][1] + " | " + grid[6][2] + " | " + grid[6][3] + " | " + grid[6][4] + " | " + grid[6][5] + " | " + grid[6][6] + " | " + grid[6][7] + " | " + grid[6][8] + " | " + grid[6][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  H | " + grid[7][0] + " | " + grid[7][1] + " | " + grid[7][2] + " | " + grid[7][3] + " | " + grid[7][4] + " | " + grid[7][5] + " | " + grid[7][6] + " | " + grid[7][7] + " | " + grid[7][8] + " | " + grid[7][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  I | " + grid[8][0] + " | " + grid[8][1] + " | " + grid[8][2] + " | " + grid[8][3] + " | " + grid[8][4] + " | " + grid[8][5] + " | " + grid[8][6] + " | " + grid[8][7] + " | " + grid[8][8] + " | " + grid[8][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  J | " + grid[9][0] + " | " + grid[9][1] + " | " + grid[9][2] + " | " + grid[9][3] + " | " + grid[9][4] + " | " + grid[9][5] + " | " + grid[9][6] + " | " + grid[9][7] + " | " + grid[9][8] + " | " + grid[9][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
    }
    public void printEnemyGrid(){
        System.out.print("      1   2   3   4   5   6   7   8   9   10 \n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  A | " + enemyGrid[0][0] + " | " + enemyGrid[0][1] + " | " + enemyGrid[0][2] + " | " + enemyGrid[0][3] + " | " + enemyGrid[0][4] + " | " + enemyGrid[0][5] + " | " + enemyGrid[0][6] + " | " + enemyGrid[0][7] + " | " + enemyGrid[0][8] + " | " + enemyGrid[0][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  B | " + enemyGrid[1][0] + " | " + enemyGrid[1][1] + " | " + enemyGrid[1][2] + " | " + enemyGrid[1][3] + " | " + enemyGrid[1][4] + " | " + enemyGrid[1][5] + " | " + enemyGrid[1][6] + " | " + enemyGrid[1][7] + " | " + enemyGrid[1][8] + " | " + enemyGrid[1][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  C | " + enemyGrid[2][0] + " | " + enemyGrid[2][1] + " | " + enemyGrid[2][2] + " | " + enemyGrid[2][3] + " | " + enemyGrid[2][4] + " | " + enemyGrid[2][5] + " | " + enemyGrid[2][6] + " | " + enemyGrid[2][7] + " | " + enemyGrid[2][8] + " | " + enemyGrid[2][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  D | " + enemyGrid[3][0] + " | " + enemyGrid[3][1] + " | " + enemyGrid[3][2] + " | " + enemyGrid[3][3] + " | " + enemyGrid[3][4] + " | " + enemyGrid[3][5] + " | " + enemyGrid[3][6] + " | " + enemyGrid[3][7] + " | " + enemyGrid[3][8] + " | " + enemyGrid[3][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  E | " + enemyGrid[4][0] + " | " + enemyGrid[4][1] + " | " + enemyGrid[4][2] + " | " + enemyGrid[4][3] + " | " + enemyGrid[4][4] + " | " + enemyGrid[4][5] + " | " + enemyGrid[4][6] + " | " + enemyGrid[4][7] + " | " + enemyGrid[4][8] + " | " + enemyGrid[4][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  F | " + enemyGrid[5][0] + " | " + enemyGrid[5][1] + " | " + enemyGrid[5][2] + " | " + enemyGrid[5][3] + " | " + enemyGrid[5][4] + " | " + enemyGrid[5][5] + " | " + enemyGrid[5][6] + " | " + enemyGrid[5][7] + " | " + enemyGrid[5][8] + " | " + enemyGrid[5][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  G | " + enemyGrid[6][0] + " | " + enemyGrid[6][1] + " | " + enemyGrid[6][2] + " | " + enemyGrid[6][3] + " | " + enemyGrid[6][4] + " | " + enemyGrid[6][5] + " | " + enemyGrid[6][6] + " | " + enemyGrid[6][7] + " | " + enemyGrid[6][8] + " | " + enemyGrid[6][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  H | " + enemyGrid[7][0] + " | " + enemyGrid[7][1] + " | " + enemyGrid[7][2] + " | " + enemyGrid[7][3] + " | " + enemyGrid[7][4] + " | " + enemyGrid[7][5] + " | " + enemyGrid[7][6] + " | " + enemyGrid[7][7] + " | " + enemyGrid[7][8] + " | " + enemyGrid[7][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  I | " + enemyGrid[8][0] + " | " + enemyGrid[8][1] + " | " + enemyGrid[8][2] + " | " + enemyGrid[8][3] + " | " + enemyGrid[8][4] + " | " + enemyGrid[8][5] + " | " + enemyGrid[8][6] + " | " + enemyGrid[8][7] + " | " + enemyGrid[8][8] + " | " + enemyGrid[8][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  J | " + enemyGrid[9][0] + " | " + enemyGrid[9][1] + " | " + enemyGrid[9][2] + " | " + enemyGrid[9][3] + " | " + enemyGrid[9][4] + " | " + enemyGrid[9][5] + " | " + enemyGrid[9][6] + " | " + enemyGrid[9][7] + " | " + enemyGrid[9][8] + " | " + enemyGrid[9][9] + " |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|\n");
    }

    public void putShips() {
        for (Ship s : ships) {
            printGrid();
            System.out.println("Where do you wanna put your: " + s.getName() + " Size: " + s.getSize() + " ? (Ex: B1");
            Position position = Position.inputPosition();
            System.out.println("Which direction you wanna put the boat? H - horizontal V - vertical");
            String direction = inputDirection();

            while (verifyIfHasOtherShip(position, direction, s)) {
                System.out.println("The ship does not fit in this position");
                System.out.println("Where do you wanna put your: " + s.getName() + " Size: " + s.getSize() + " ? (Ex: B1");
                position = Position.inputPosition();
                System.out.println("Which direction you wanna put the boat? H - horizontal V - vertical");
                direction = inputDirection();
            }

            if (direction.equals("V")) {
                for (int i = position.getColumn(); i < position.getColumn() + s.getSize(); i++) {
                    enemyGrid[position.getRow()][i] = "=";
                    s.getPositions().add(new Position(position.getRow(), i));
                }

            }
            if (direction.equals("H")) {
                if ((position.getRow() + s.getSize()) > 9) {
                    position.setRow(position.getRow() - (s.getSize() - 10));
                }
                for (int i = position.getRow(); i < (s.getSize() + position.getRow()); i++) {
                    enemyGrid[i][position.getColumn()] = "=";
                    s.getPositions().add(new Position(i, position.getColumn()));
                }
            }

        }
    }

    private String inputDirection() {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.next().toUpperCase();
        if (in.equals("H")) {
            return in;
        }
        if (in.equals("V")) {
            return in;
        }
        System.out.println(in + " is not a direction");
        return inputDirection();
    }

    private boolean verifyIfHasOtherShip(Position position, String direction, Ship ship) {
        if (direction.equals("V") && (position.getColumn() + ship.getSize()) > enemyGrid.length || direction.equals("H") && (position.getRow() + ship.getSize()) > enemyGrid.length){
            return true;
        }
        if (direction.equals("V")) {
            for (int i = position.getColumn(); i < position.getColumn() + ship.getSize(); i++) {
                if (enemyGrid[position.getRow()][i].equals("=")) {
                    return true;
                }
            }
        }
        if (direction.equals("H")) {
            for (int i = position.getRow(); i < (ship.getSize() + position.getRow()); i++) {
                if (enemyGrid[i][position.getColumn()].equals("=")) {
                    return true;
                }
            }
        }
        return false;
    }
    public void attack(Player player){
        System.out.println("Insert a position to attack. (Ex: B1)");
        Position position = Position.inputPosition();
        if (!player.grid[position.getRow()][position.getColumn()].equals(" ")){
            System.out.println("you missed the turn");
            return;
        }
        if (player.grid[position.getRow()][position.getColumn()].equals("=")){
            this.enemyGrid[position.getRow()][position.getColumn()] = "X";
            player.grid[position.getRow()][position.getColumn()] = "X";
            attack(player);
        }
        this.enemyGrid[position.getRow()][position.getColumn()] = "o";
        player.grid[position.getRow()][position.getColumn()] = "o";
    }
}
