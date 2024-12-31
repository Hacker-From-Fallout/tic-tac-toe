import java.util.Scanner;

public class GameCycle {

    private final Scanner in = new Scanner(System.in);

    public boolean play() {
        PlayingField field = new PlayingField();
        String checkWinner;
        Player player1;
        Player player2;

        if (!start()) {
            System.out.println("Игра завершена!");
            return false;
        }

        System.out.println("Новая игра!");

        if (initializationPlayer().equals("X")) {
            player1 = new Player("X");
            player2 = new Player("0");
        } else {
            player1 = new Player("0");
            player2 = new Player("X");
        }

        while (true) {
            field.paint();

            while (true) {
                int index = player1.input();

                if (field.set(index, player1.getName())) {
                    break;
                }
            }

            field.paint();

            checkWinner = field.checkWinner();

            if (checkWinner != null) {
                System.out.println(checkWinner);
                break;
            }

            while (true) {
                int index = player2.input();

                if (field.set(index, player2.getName())) {
                    break;
                }
            }

            checkWinner = field.checkWinner();

            if (checkWinner != null) {
                System.out.println(checkWinner);
                break;
            }
        }

        return true;
    }

    public boolean start() {
        while (true) {
            System.out.print("Введите 1 чтобы играть, 0 чтобы выйти: ");
            try {
                int controller = in.nextInt();
                in.nextLine();

                if (controller == 1) {
                    return true;
                } else if (controller == 0) {
                    return false;
                } else {
                    System.out.println("Некорректный ввод! Введите 1 или 0.");
                }
            } catch (Exception e) {
                System.out.println("Некорректный ввод! Введите число.");
                in.nextLine();
            }
        }
    }

    public String initializationPlayer() {
        String name;

        while (true) {
            System.out.println("Введите X или 0");
            System.out.print("За кого играет первый игрок: ");
            name = in.nextLine();

            if (name.equals("X") || name.equals("0")) {
                return name;
            }

            System.out.println("Некорректный ввод!");
        }
    }
}
