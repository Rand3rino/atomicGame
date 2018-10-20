package com.atomicobject.othello;

import java.util.Stack;

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
	
	
	boolean noChildren(Node node) {
		if (first == null && 
		second == null &&
		third == null &&
		fourth == null &&
		fifth == null &&
		sixth == null &&
		seventh == null &&
		eighth == null &&
		ninth == null &&
		tenth == null)
			return true;
		return false;
	}
	Stack<Node> getChildren(Node node) {
		Stack<Node> nodeList = new Stack<Node>();
		nodeList.add(node.first);
		nodeList.add(node.second);
		nodeList.add(node.third);
		nodeList.add(node.fourth);
		nodeList.add(node.fifth);
		nodeList.add(node.sixth);
		nodeList.add(node.seventh);
		nodeList.add(node.eighth);
		nodeList.add(node.ninth);
		nodeList.add(node.tenth);
		return nodeList;
	}
	
	
}
