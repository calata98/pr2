package Printers;

import game.Game;
import interfaces.GamePrinter;
import util.MyStringUtils;

public class BoardPrinter implements GamePrinter{
			
		int numRows; 
		int numCols;
		String[][] board;
		final String space = " ";
		
		
		public BoardPrinter (int rows, int cols) {
			this.numRows = rows;
			this.numCols = cols;	
		}
		
		public BoardPrinter() {
			// TODO Auto-generated constructor stub
		}

		private void encodeGame(Game game) {
			board = new String[numRows][numCols];
			for(int i = 0; i < numRows; i++) {
				for(int j = 0; j < numCols; j++) {
					board[i][j] =  game.positionToString(i, j);
				}
			}
		}
		@Override
		public String toString(Game game) {
			encodeGame(game);
			int cellSize = 7;
			int marginSize = 2;
			String vDelimiter = "|";
			String hDelimiter = "-";
			
			String rowDelimiter = MyStringUtils.repeat(hDelimiter, (numCols * (cellSize + 1)) - 1);
			String margin = MyStringUtils.repeat(space, marginSize);
			String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
			
			StringBuilder str = new StringBuilder();
			
			str.append(lineDelimiter);
			
			for(int i=0; i<numRows; i++) {
					str.append(margin).append(vDelimiter);
					for (int j=0; j<numCols; j++) {
						str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
					}
					str.append(lineDelimiter);
			}
			return str.toString();
		}

		@Override
		public GamePrinter parse(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String helpText() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	

