package br.com.Thready;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main2 {
	public static void main(String[] argson) {
		BlockingQueue<Data> msg = new ArrayBlockingQueue<Data>(1);
		Read ready = new Read(msg);
		ready.start();
	}
}
