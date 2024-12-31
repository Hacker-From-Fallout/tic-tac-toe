public class PlayingField {

    private final String[] field = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public void paint() {
        System.out.println("-------------");
        System.out.println("| " + field[0] + " | " + field[1] + " | " + field[2] + " |");
        System.out.println("-------------");
        System.out.println("| " + field[3] + " | " + field[4] + " | " + field[5] + " |");
        System.out.println("-------------");
        System.out.println("| " + field[6] + " | " + field[7] + " | " + field[8] + " |");
        System.out.println("-------------");
    }

    public boolean set(int index, String value) {
        if (!field[index - 1].equals("X") && !field[index - 1].equals("0")) {
            field[index - 1] = value;
            return true;
        } else {
            System.out.println("Данная позиция уже занята.");
            return false;
        }
    }

    public String checkWinner() {
        int[][] winningCombinations = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        for (int[] combination : winningCombinations) {
            String pos1 = field[combination[0]];
            String pos2 = field[combination[1]];
            String pos3 = field[combination[2]];

            if (pos1.equals(pos2) && pos2.equals(pos3)) {
                if (pos1.equals("X")) {
                    return "Победил X!";
                } else if (pos1.equals("0")) {
                    return "Победил 0!";
                }
            }
        }

        boolean isDraw = true;
        for (String cell : field) {
            if (!cell.equals("X") && !cell.equals("0")) {
                isDraw = false;
                break;
            }
        }

        if (isDraw) {
            return "Ничья!";
        }

        return null;
    }
}
