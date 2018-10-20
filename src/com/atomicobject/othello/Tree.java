package com.atomicobject.othello;

public class Tree {
	Node root;
}

class Node {
	int value;
	
	// Expected to have ten branches
	Node first;
	Node second;
	Node third;
	Node fourth;
	Node fifth;
	Node sixth;
	Node seventh;
	Node eighth;
	Node ninth;
	Node tenth;
	
	Node() {
		value = 0;
		
		// Expected to have ten branches
		first   = null;
		second  = null;
		third   = null;
		fourth  = null;
		fifth   = null;
		sixth   = null;
		seventh = null;
		eighth  = null;
		ninth   = null;
		tenth   = null;
	}
}
