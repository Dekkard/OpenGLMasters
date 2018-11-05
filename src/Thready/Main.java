package Thready;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
	public static void main(String[] args) {
		BlockingQueue<Data> msg = new ArrayBlockingQueue<Data>(1);
		Load loady = new Load(msg,"teste.txt");
		Read ready = new Read(msg);
		loady.start();
		ready.start();
	}
}
