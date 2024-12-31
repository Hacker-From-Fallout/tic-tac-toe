import java.util.Scanner;

public class Player {

    private String name;
    Scanner in = new Scanner(System.in);
    int num;

    public Player(String name) {
        this.name = name;
    }

    public int input() {
        while (true) {
            System.out.print("Куда поставить " + name + ": ");
            num = in.nextInt();

            if (num >= 1 && num <= 9) {
                return num;
            } else {
                System.out.println("Значение должно быть от 1 до 9.");
            }
        }
    }
}

