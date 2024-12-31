import java.util.Scanner;

public class Player {

    private final String name;
    Scanner in = new Scanner(System.in);
    int num;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int input() {
        while (true) {
            System.out.print("Куда поставить " + name + ": ");

            try {
                num = in.nextInt();

                if (num >= 1 && num <= 9) {
                    return num;
                } else {
                    System.out.println("Значение должно быть от 1 до 9.");
                }
            } catch (Exception e) {
                System.out.println("Некорректный ввод! Введите число.");
                in.nextLine();
            }
        }
    }
}

