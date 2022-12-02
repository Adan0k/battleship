import java.util.Scanner;

public class Game {
    Player player1;
    Player player2;

    public Game() {
    }
    public void menu(){
        System.out.println("\n" +
                " ______     ______     ______   ______   __         ______     ______     __  __     __     ______  \n" +
                "/\\  == \\   /\\  __ \\   /\\__  _\\ /\\__  _\\ /\\ \\       /\\  ___\\   /\\  ___\\   /\\ \\_\\ \\   /\\ \\   /\\  == \\ \n" +
                "\\ \\  __<   \\ \\  __ \\  \\/_/\\ \\/ \\/_/\\ \\/ \\ \\ \\____  \\ \\  __\\   \\ \\___  \\  \\ \\  __ \\  \\ \\ \\  \\ \\  _-/ \n" +
                " \\ \\_____\\  \\ \\_\\ \\_\\    \\ \\_\\    \\ \\_\\  \\ \\_____\\  \\ \\_____\\  \\/\\_____\\  \\ \\_\\ \\_\\  \\ \\_\\  \\ \\_\\   \n" +
                "  \\/_____/   \\/_/\\/_/     \\/_/     \\/_/   \\/_____/   \\/_____/   \\/_____/   \\/_/\\/_/   \\/_/   \\/_/   \n" +
                "                                                                                                    \n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - start");
        System.out.println("2 - instructions");
        System.out.println("0 - exit");
        System.out.println("what you wanna do?");
        int action = scanner.nextInt();
        while (action != 1 && action != 2 && action != 0){
            System.out.println("the options are only 1,2 or 0");
            action = scanner.nextInt();
        }
        switch (action){
            case 1:
                startGame();
                break;
            case 2:
                instructions();
                break;
            case 0:
                System.out.println("bye bye");
                return;
        }
    }
    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the player 1 name:");
        player1 = new Player(scanner.next());
        System.out.println("Insert the player 2 name");
        player2  = new Player(scanner.next());

        System.out.println(player1.getName() + " Are you ready for put yours ships? (type anything to continue)");
        scanner.next();
        player1.putShips();

        System.out.println(player2.getName() + " Are you ready for put yours ships? (type anything to continue)");
        scanner.next();
        player2.putShips();

        do {
            System.out.println(player1.getName() + " are you ready to attack? (type anything to continue)");
            scanner.next();
            player1.attack(player2);
            player2.verifyShips();
            player2.verifyPlayerLost();
            if (player2.isLost()){
                System.out.println("Winner: " + player1.getName());
                break;
            }

            System.out.println(player1.getName() + " are you ready to attack? (type anything to continue)");
            scanner.next();
            player2.attack(player1);
            player1.verifyShips();
            player1.verifyPlayerLost();
            if (player1.isLost()){
                System.out.println("Winner: " +  player2.getName());
                break;
            }

        }while (true);;
    }
    public void instructions(){
        System.out.println("This is a game with 2 players, where the players put theirs ships on a grid and try to attack the opponent ships");
    }
}
