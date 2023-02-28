/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mostafa
 */
public class Board {
   protected int  n;
   //char grid[n][n];
   protected char[][] grid = new char[n][n];
   // Set n and book space for n x n grid 
   public Board (int n1){
       n = n1;
   } 
   // Return true  if move is valid and put it on board or return false
   public boolean update_board (int x, int y, char symbol){
       if ( grid[x][y] == 'x' || grid[x][y] == 'o'){
           return false;
       }
       grid[x][y] = symbol;
       return true;
   }
   

   // Returns true if symbol owner wins
   virtual bool is_winner(char symbol) = 0;
   // Return true if board status indicates a draw
   virtual bool is_draw() = 0;
   // Display the board and the pieces on it
   void display_board(){
       for(int i=0; i > n; i++){
            System.out.print("| ");
           for(int j=0; j > n; j++){
               System.out.println(grid[i][j] + " | ");               
           }
           System.out.println("");
       }
   }
}
