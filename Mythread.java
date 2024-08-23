package com.java8.eg;

public class Mythread implements Runnable {

	@Override
	public void run() {
		//java 7  way to call fuction
		Task t=new Task();
		t.print();
		
	}

}
