package Thready;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Read extends Thread {
	public List<String> lista;
	private BlockingQueue<Data> msg;

	public Read(BlockingQueue<Data> msg) {
		this.msg = msg;
	}

	public void run() {
		Data list;
//		synchronized (lock) {
//			lock.notifyAll();
//		}
			try {
				
				list = msg.take();
				this.lista = list.lista;
				if (!lista.isEmpty()) {
					System.out.println("Lista recebida");
				} else {
					System.out.println("Lista vazia!");
				}
				for (String f : list.lista) {
					System.out.println(f);
				}
			} catch (InterruptedException e) {
				System.err.println(e);
		}
	}

}
