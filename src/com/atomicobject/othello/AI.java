package com.atomicobject.othello;

import java.util.Arrays;
import java.util.Random;
import java.util.ListIterator;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class AI {

	ListIterator<int[]> moveList;

	public AI(int[][] moves) {
		moveList = Arrays.asList(moves).listIterator();
	}

	public int[] computeMove(GameState state) {
		Gson gson = new Gson();

		int[] move = new int[2];
		Random rand = new Random();
		// LegalMoves(state);

		LegalMoves check = new LegalMoves(state);

		int r, c;
		while (true) {
			r = rand.nextInt(8);
			c = rand.nextInt(8);
//		
//		
//		for (int r = 1; r < 8; r++) {
//			for (int c = 1; c < 8; c++) {

				if (check.isLegal(state.getBoard(), r, c)) {
					move[0] = r;
					move[1] = c;
					return move;
				}
				System.out.println(r + " " + c);

		
		}

//		int moveX = 4 ,moveY = 2;
//		move[0] = moveX;
//		move[1] = moveY;

//		JsonObject json = new JsonObject();
//		json.add(gson.toJson(move), json );
//		JsonArray jarray = new JsonArray();
//		jarray.add(json);

		// System.out.println("AI returning canned move for game state - " + state);

		// return jarray;
		// return move;
	}
}
