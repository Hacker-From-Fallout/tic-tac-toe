public class GameCycle {

    public void play() {
        PlayingField field = new PlayingField();
        Player playerX = new Player("X");
        Player playerO = new Player("O");
        String checkWinner;

        System.out.println("Новая игра!");

        while (true) {
            field.paint();

            while (true) {
                int index = playerX.input();

                if (field.set(index, "X")) {
                    break;
                } else {
                    continue;
                }
            }

            field.paint();

            checkWinner = field.checkWinner();

            if (checkWinner != null) {
                System.out.println(checkWinner);
                field = new PlayingField();
                System.out.println("Новая игра!");
                continue;
            }

            while (true) {
                int index = playerO.input();

                if (field.set(index, "O")) {
                    break;
                } else {
                    continue;
                }
            }

            checkWinner = field.checkWinner();

            if (checkWinner != null) {
                System.out.println(checkWinner);
                field = new PlayingField();
                System.out.println("Новая игра!");
                continue;
            }
        }
    }
}
