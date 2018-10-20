package com.atomicobject.othello;

public class LegalMoves {
	int player;
	int opponent;

	// GameState gameState = new GameState();
	public LegalMoves(GameState game) {
		player = game.getPlayer();
		opponent = getOpponent();
	}

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
		else if (!isEmpty(move, moveR, moveC))
			return false;

		// check if it captures a piece
		else if (!flipsPiece(move, moveR, moveC))
			return false;

		return true;
	}

	// check if move coordinates are on the board
	public boolean onBoard(int moveR, int moveC) {
		if (moveR > 7 || moveC > 7 || moveR < 0 || moveC < 0)
			return false;
		return true;
	}

	// check if there is already a piece on that spot of the board
	public boolean isEmpty(int[][] move, int moveR, int moveC) {
		if (onBoard(moveR, moveC)) {
			if (move[moveR][moveC] != 0)
				return false;
			return true;
		}
		return false;
	}

	// check to make sure that the move flips an opponent's piece
	public boolean flipsPiece(int[][] move, int moveR, int moveC) {
		for (int r = -1; r < 2; r++)
			for (int c = -1; c < 2; c++) {
				int tempMoveR = moveR + r;
				int tempMoveC = moveC + c;
				if (onBoard(tempMoveR, tempMoveC))
					if (move[tempMoveR][tempMoveC] == opponent) {
						while (onBoard(tempMoveR, tempMoveC) && move[tempMoveR][tempMoveC] == opponent) {
							if (r == -1 && c == -1) {
								tempMoveR--;
								tempMoveC--;
							} else if (r == 0 && c == -1) {
								tempMoveC--;
							} else if (r == 0 && c == 1) {
								tempMoveC++;
							}

							else if (r == 1 && c == -1) {
								tempMoveR++;
								tempMoveC--;
							} else if (r == -1 && c == 0) {
								tempMoveR--;
							} else if (r == 1 && c == 0) {
								tempMoveR++;
							} else if (r == -1 && c == 1) {
								tempMoveR--;
								;
								tempMoveC++;
							} else if (r == 1 && c == 1) {
								tempMoveR++;
								tempMoveC++;
							}

							if (onBoard(tempMoveR, tempMoveC))
								if (move[tempMoveR][tempMoveC] == player) {
									System.out.println("Me:" + tempMoveR + " " + tempMoveC);
									return true;
								}
						}

					}
			}

		return false;

	}

}
