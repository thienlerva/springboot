package com.revature.practice;

import java.util.Random;

public class ChessBoard {
	
	
	public static void main(String[] args) {
		
		constructBoard();
	}
	
	public static void constructBoard() {
		
		String[][] strArray = new String[8][8];
		
		int row = strArray.length;
		int col = strArray[0].length;
		
		// ["(2,1)", "(4,2)", "(6,3)", "(8,4)", "(3,5)", "(1,6)", "(7,7)", "(5,8)"] 
		String[][] queenPosition = placeQueen();
		
		
		for(int i = 0; i < row; i++) {
			String grid = "";
			for(int j = 0; j < col; j++) {
				if(queenPosition[i][j].equals("*")) {
					grid += "|*_";
				} else {
					grid += "|_";
				}
			}
			grid += "| \n";
			System.out.println(grid);
		}
	}
	
	public static boolean availablePosition(String position, String[][] queenPosition) {
		
		
		int row = Integer.parseInt(position.charAt(0) + "");
		int col = Integer.parseInt(position.charAt(position.length()-1) + "");
		
		
		
		return false;
	}
	
	public static String[][] placeQueen() {
		String[][] queenPosition = new String[8][8];
		
		Random gen = new Random();
		
		int row = queenPosition.length;
		int col = queenPosition[0].length;
		
		
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				queenPosition[i][j] = "";
			}
		}
		
		int number = 1;
		while(number <= 8) {
			row = gen.nextInt(7);
			col = gen.nextInt(7);
			if(!queenPosition[row][col].equals("*")) {
				queenPosition[gen.nextInt(8)][gen.nextInt(8)] = "*";
				number++;
			}
		}
		
		return queenPosition;
	}

}

class ArrayUtil {
	
	private static Random gen = new Random();
	
	
	public static int[][] randomIntArray(int length, int n) {
		
		int[][] array = new int[8][8];
		int row = array.length;
		int col = array[0].length;
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				array[i][j] = gen.nextInt(8);
			}
		}
		
		return array;
	}

}
