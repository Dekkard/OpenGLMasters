package CG;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandling {
//	private String forma;
//	public List<String> lista;

	public static List<String> Load(String forma) {
		String file = "GeoForms/" + forma;
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
			f1.close();
		} catch (IOException e) {
			System.err.println(e);
			return null;
		}
		return fileLines;
	}

	public Integer getDirSize() {
		File file = new File("GeoForms/");
		return file.listFiles().length;
	}
}
