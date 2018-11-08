package OP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import CG.ObjectGeo;

@SuppressWarnings("all")
public class Operation {
	private String name;

	public void translate(ObjectGeo objgeo, float x, float y) {
		List<String> lista = new ArrayList<>();
		Iterator<String> it = objgeo.lista.iterator();
		name = it.next();
		lista.add(name);
		while (it.hasNext()) {
			float ver1 = Float.parseFloat(it.next());
			float ver2 = Float.parseFloat(it.next());
			String ver3 = it.next();
			ver1 += x;
			ver2 += y;
			lista.add(String.valueOf(ver1));
			lista.add(String.valueOf(ver2));
			lista.add(ver3);
		}
		objgeo.lista = lista;
	}

	public void rotate(ObjectGeo objgeo, double angle) {
		List<String> lista = new ArrayList<>();
		Iterator<String> it = objgeo.lista.iterator();
		float medX = 0.0f;
		float medY = 0.0f;
		int cnt = 0;
		name = it.next();
		lista.add(name);
		while (it.hasNext()) {
			String ver1 = it.next();
			String ver2 = it.next();
			String ver3 = it.next();
			medX += Float.parseFloat(ver1);
			medY += Float.parseFloat(ver2);
			cnt++;
		}
		medX /= cnt;
		medY /= cnt;
		name = it.next();
		lista.add(name);
		while (it.hasNext()) {
			float ver1 = Float.parseFloat(it.next()) - medX;
			float ver2 = Float.parseFloat(it.next()) - medY;
			String ver3 = it.next();
			float ver1f = ver1 * (float) Math.cos(angle) - ver2 * (float) Math.sin(angle);
			float ver2f = ver1 * (float) Math.sin(angle) - ver2 * (float) Math.cos(angle);
			lista.add(String.valueOf(ver1f + medX));
			lista.add(String.valueOf(ver2f + medY));
			lista.add(ver3);
		}
		objgeo.lista = lista;
	}

	public void scale(ObjectGeo objgeo, float scale) {
		List<String> lista = new ArrayList<>();
		Iterator<String> it = objgeo.lista.iterator();
		float medX = 0.0f;
		float medY = 0.0f;
		int cnt = 0;
		name = it.next();
		lista.add(name);
		while (it.hasNext()) {
			String ver1 = it.next();
			String ver2 = it.next();
			String ver3 = it.next();
			medX += Float.parseFloat(ver1);
			medY += Float.parseFloat(ver2);
			cnt++;
		}
		medX /= cnt;
		medY /= cnt;
		name = it.next();
		while (it.hasNext()) {
			float ver1 = Float.parseFloat(it.next()) - medX;
			float ver2 = Float.parseFloat(it.next()) - medY;
			String ver3 = it.next();
			lista.add(String.valueOf(ver1 * scale + medX));
			lista.add(String.valueOf(ver2 * scale + medY));
			lista.add(ver3);
		}
		objgeo.lista = lista;
	}
}
