public class Main {
    static char[][] laberint = {
            {' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' '},
            {' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' '},
            {' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', ' ', ' '},
            {'#', ' ', ' ', ' ', '#', '#', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', ' ', '#', ' ', '#', '#', ' ', ' ', ' ', '#', ' ', ' '},
            {'#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' '},
            {'#', '#', '#', ' ', '#', 'X', ' ', ' ', ' ', '#', ' ', ' '}
    };

    private static void imprimirLaberint() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (char[] fila : laberint) {
            for (char c : fila) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void esperar(int milisegons) {
        try {
            Thread.sleep(milisegons);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static boolean esValid(int x, int y) {
        return  x >= 0 && y >= 0 &&
                x < laberint.length &&
                y < laberint[0].length &&
                (laberint[x][y] == ' ' || laberint[x][y] == 'X');
    }

    public static boolean resolLaberint(int x, int y) {
        if (!esValid(x, y)) return false;
        if (laberint[x][y] == 'X') return true;

        laberint[x][y] = 'O';
        imprimirLaberint();
        esperar(100);

        if (    resolLaberint(x, y + 1) ||
                resolLaberint(x + 1, y) ||
                resolLaberint(x, y - 1) ||
                resolLaberint(x - 1, y))
        {
            return true;
        }
        else {
        laberint[x][y] = '.';
        imprimirLaberint();
        esperar(100);
        return false;
        }
    }

    public static void main(String[] args) {
        if (resolLaberint(0, 0)) {
            System.out.println("Camí trobat!");
        } else {
            System.out.println("No hi ha solució");
        }
    }
}
