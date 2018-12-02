package com.hepexta.refactoring.htmlparser.util;

import com.hepexta.refactoring.htmlparser.Node;

import java.io.Serializable;

public class NodeList implements Serializable {
	private static final int INITIAL_CAPACITY=10;
	private Node nodeData[];
	private int size;
	private int capacity;
	private int capacityIncrement;
	private int numberOfAdjustments;

	public NodeList() {
		size = 0;
		capacity = INITIAL_CAPACITY;
		nodeData = new Node[capacity];
		capacityIncrement = capacity*2;
		numberOfAdjustments = 0;
	}
	
	public void add(Node node) {
		if (size==capacity) 
			adjustVectorCapacity();
		nodeData[size++]=node;
	}

	public void prepend(Node node)
    {
		if (size==capacity) 
			adjustVectorCapacity();
        System.arraycopy (nodeData, 0, nodeData, 1, size);
        size++;
		nodeData[0]=node;
	}

	private void adjustVectorCapacity() {
		capacity += capacityIncrement;
		capacityIncrement *= 2;
		Node oldData [] = nodeData;
		nodeData = new Node[capacity];
		System.arraycopy(oldData, 0, nodeData, 0, size);
		numberOfAdjustments++;
	}
	
	public int size() {
		return size;
	}
	
	public Node elementAt(int i) {
		return nodeData[i];
	}

	public String toString() {
		StringBuffer text = new StringBuffer();
		for (int i=0;i<size;i++)
			text.append(nodeData[i].toPlainTextString());
		return text.toString();
	}
}
