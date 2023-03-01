import java.util.*;

public class game {
    public static void main(String[] args) {
        // creating the game
        Scanner input1 = new Scanner(System.in);
        System.out.print("first player, enter your name: ");
        String n1 = input1.nextLine();
        System.out.print("second player, enter your name : ");
        String n2 = input1.nextLine();
        player p1 = new player('x', n1);
        player p2 = new player('o', n2);
        XO board = new XO(3);
        int m[];
        while (true) {
            board.display_board();
            m = p1.get_move();
            while (!board.update_board(m[0], m[1], p1.get_symbol())) {
                System.out.print("invalid move ");
                m = p1.get_move();
            }
            if (board.is_winner(p1.get_symbol())) {
                board.display_board();
                System.out.println(p1.get_name() + " is the winner");
                break;
            }
            if (board.is_draw(p1.get_symbol())) {
                board.display_board();
                System.out.println("draw");
                break;
            }
            board.display_board();

            m = p2.get_move();
            while (!board.update_board(m[0], m[1], p2.get_symbol())) {
                System.out.print("invalid move ");
                m = p2.get_move();
            }
            if (board.is_winner(p2.get_symbol())) {
                System.out.println(p2.get_name() + " is the winner");
                break;
            }
            if (board.is_draw(p2.get_symbol())) {
                System.out.println("draw");
                break;
            }
        }
    }
};

class player {
    protected char symbol;
    protected String name;
    protected int move[];

    public player(char s, String n) {
        symbol = s;
        name = n;
        move = new int[2];
    }

    public int[] get_move() {
        Scanner input = new Scanner(System.in);
        System.out.print("enter your move (x,y): ");
        move[0] = input.nextInt();
        move[1] = input.nextInt();
        input.nextLine();

        return move;
    }

    public String get_name() {
        return name;
    }

    public char get_symbol() {
        return symbol;
    }

};

abstract class Board {
    protected int n;
    // char grid[n][n];
    protected char[][] grid;

    // Set n and book space for n x n grid
    public Board(int n1) {
        n = n1;
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    // Return true if move is valid and put it on board or return false
    public boolean update_board(int x, int y, char symbol) {
        if (grid[x][y] == 'x' || grid[x][y] == 'o') {
            return false;
        }
        grid[x][y] = symbol;
        return true;
    }

    // Returns true if symbol owner wins
    public boolean is_winner(char symbol) {
        return true;
    };

    // Return true if board status indicates a draw
    public boolean is_draw() {
        return true;
    };

    // Display the board and the pieces on it
    void display_board() {
        for (int i = 0; i < n; i++) {
            System.out.print("| ");
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println("");
        }
    }
}

class XO extends Board {
    public XO(int n) {
        super(n);
    }

    public boolean is_winner(char symbol) {
        for (int i = 0; i < n; i++) {

            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) {
                return true;
            }
        }
        for (int i = 0; i < n; i++) {

            if (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) {
                return true;
            }
        }
        if (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) {
            return true;
        }
        if (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol) {
            return true;
        }
        return false;
    }

    public boolean is_draw(char symbol) {
        char s;
        if (symbol == 'x') {
            s = 'o';
        } else {
            s = 'x';
        }
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == s && grid[i][1] == s && grid[i][2] == s) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == s && grid[1][i] == s && grid[2][i] == s) {
                return false;
            }
        }
        if (grid[0][0] == s && grid[1][1] == s && grid[2][2] == s) {
            return false;
        }
        if (grid[0][2] == s && grid[1][1] == s && grid[2][0] == s) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
