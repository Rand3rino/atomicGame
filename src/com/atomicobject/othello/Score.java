package com.atomicobject.othello;

public class Score {
	int row,col,points;
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Score (int r, int c, int p) {
		row = r;
		col = c;
		points = p;
	}
}
