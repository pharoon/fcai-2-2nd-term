import java.util.*;

public class game {
    public static void main(String[] args) {

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
        return move;
    }

    public String get_name() {
        return name;
    }

    public char get_symbol() {
        return symbol;
    }

    public void move() {
        Scanner input = new Scanner(System.in);
        System.out.print("enter your move (x,y): ");
        move[0] = input.nextInt();
        move[1] = input.nextInt();

    }

};