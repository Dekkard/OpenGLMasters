package Thready;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Load extends Thread {
	private String forma;
	public List<String> lista;
	private BlockingQueue<Data> msg;

	public Load(BlockingQueue<Data> msg, String forma) {
		this.msg = msg;
		this.forma = forma;
	}

	public void run() {
		String file = "formas/" + forma;
		BufferedReader f1 = null;
		List<String> fileLines = new ArrayList<>();
		try {
			f1 = new BufferedReader(new FileReader(file));
			while (true) {
				String aux = f1.readLine();
				if (aux == null) {
					break;
				}
				fileLines.add(aux);
			}
//			for (String f : fileLines) {
//				System.out.println(f);
//			}
//			synchronized (lock) {
//				lock.wait();
//			}
			this.lista = fileLines;
			Data data = new Data(fileLines);
			msg.put(data);
			f1.close();
		} catch (InterruptedException | IOException e) {
			System.err.println(e);
		}
	}
}