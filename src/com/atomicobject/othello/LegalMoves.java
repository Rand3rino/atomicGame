package com.atomicobject.othello;

public class LegalMoves {
	GameState gameState = new GameState();
	int player = gameState.getPlayer();
	int opponent = getOpponent();

	/**
	 * @return the opponent
	 */
	public int getOpponent() {
		if (player == 1)
			return 2;
		else
			return 1;
	}

	// returns if the move is legal
	public boolean isLegal(int[][] move, int moveR, int moveC) {

		// check if move is on board
		if (!onBoard(moveR, moveC))
			return false;

		// check if space is empty
		else if (isEmpty(move, moveR, moveC))
			return true;

		// check if it captures a piece
		else if(flipsPiece(move, moveR, moveC))
			return true;
		
		return false;
	}

	// check if move coordinates are on the board
	public boolean onBoard(int moveR, int moveC) {
		if (moveR > 7 || moveC > 7)
			return false;
		return true;
	}

	// check if there is already a piece on that spot of the board
	public boolean isEmpty(int[][] move, int moveR, int moveC) {
		if (move[moveR][moveC] != 0)
			return false;
		return true;
	}

	// check to make sure that the move flips an opponent's piece
	public boolean flipsPiece(int[][] move, int moveR, int moveC) {
		for (int r = -1; r < 2; r++)
			for (int c = -1; c < 2; c++)
				if (onBoard(moveR + r, moveC + c))
					if (move[r + moveR][c + moveC] == opponent)
						for(int mult = 2; mult < 100; mult++)
							while (onBoard(moveR + mult*r, moveC + mult*c))
								if (move[moveR + mult * r][moveC + mult * c] == player)
									return true;

		return false;

	}

}
