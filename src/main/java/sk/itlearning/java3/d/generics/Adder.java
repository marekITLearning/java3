package sk.itlearning.java3.d.generics;

import java.util.List;


class Adder {
	public void add(List list) {
		list.add(new Integer(50));
		list.add(new Boolean(true));
	}
}