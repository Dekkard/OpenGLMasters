package OP;

import java.util.Iterator;

import CG.Frame;

@SuppressWarnings("all")
public class Operation {
	private String name;
	
	public void translate(Frame frame, float x, float y) {
		Iterator<String> it = frame.lista.iterator();
		name = it.next();
		while(it.hasNext()) {
		
		}
	}
	
	public void rotate(Frame frame) {
		
	}
	
	public void scale(Frame frame) {
		
	}
}
