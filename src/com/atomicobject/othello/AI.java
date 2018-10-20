package com.atomicobject.othello;

import java.util.Arrays;
import java.util.Random;
import java.util.ListIterator;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class AI {

	int player, opponent;
	ListIterator<int[]> moveList;
	

	public AI(int[][] moves) {
		moveList = Arrays.asList(moves).listIterator();
	}

	public int[] computeMove(GameState state) {
		
		player = state.getPlayer();
		opponent = getOpponent();
		
		Gson gson = new Gson();

		int[] move = new int[2];
		Random rand = new Random();

		LegalMoves check = new LegalMoves(state);

		int r, c;
		while (true) {
			r = rand.nextInt(8);
			c = rand.nextInt(8);
//		for (int r = 1; r < 8; r++) {
//			for (int c = 1; c < 8; c++) {

			if (check.isLegal(state.getBoard(), r, c)) {
				move[0] = r;
				move[1] = c;
				return move;
			}
			System.out.println(r + " " + c);

		}
	}

	private int getOpponent() {
		if (player == 1)
			return 2;
		else
			return 1;
	}

	int minimax(int node, int depth, int isMaximizingPlayer, int alpha, int beta) {
	    
		// TODO If node is leaf, return value of node.
		
		
	    if (isMaximizingPlayer == player) {
	        int bestVal = -1000000; 
	    
	        for (node : node) {
	        	int value = minimax(node, depth+1, 2, alpha, beta);
	            bestVal = max( bestVal, value); 
	            alpha = max( alpha, bestVal);
	            if (beta <= alpha) 
	                break;
	        return bestVal;}
	    }
	    else {

	    	int bestVal = +1000000;
	
	    	for (node : node) {
	            int value = minimax(node, depth+1, 1, alpha, beta);
	            bestVal = min(bestVal, value);
	            beta = min( beta, bestVal);
	            if (beta <= alpha)
	                break;
	            return bestVal;
	    	}
	    }
	}

	
	private int min(int bestVal, int value) {
		if (bestVal < value) 
			return bestVal;
		return value;
	}

	private int max(int bestVal, int value) {
		if (bestVal > value) 
			return bestVal;
		return value;
	}
}