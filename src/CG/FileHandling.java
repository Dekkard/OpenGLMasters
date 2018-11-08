package CG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileHandling {
//	private String forma;
//	public List<String> lista;

	public static List<String> Load(String forma) {
		String file = "GeoForms/" + forma;
		BufferedReader read = null;
		List<String> fileLines = new ArrayList<>();
		try {
			read = new BufferedReader(new FileReader(file));
			while (true) {
				String aux = read.readLine();
				if (aux == null) {
					break;
				}
				fileLines.add(aux);
			}
			read.close();
		} catch (IOException e) {
			System.err.println(e);
			return null;
		}
		return fileLines;
	}

	public static void Save(List<String> lista) {
		try {
			BufferedWriter write = new BufferedWriter(new FileWriter("GeoForms/form"+(new File("GeoForms/").listFiles().length+1)+".txt"));
			Iterator<String> it = lista.iterator();
			write.write(it.next());
			write.newLine();
			while(it.hasNext()) {
				write.write(it.next()+"f");
				write.newLine();
			}
			write.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public Integer getDirSize() {
		File file = new File("GeoForms/");
		return file.listFiles().length;
	}
}
