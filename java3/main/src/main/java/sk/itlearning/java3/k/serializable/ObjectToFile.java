package sk.itlearning.java3.k.serializable;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ObjectToFile extends JFrame {

	private static final long serialVersionUID = 1L;

	public JTextArea jt = new JTextArea();

	transient public String nazov;

	public static void main(String[] args) {

		File f = new File("C:/test/gui");

		ObjectToFile sjf = null;
		
		if (f.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
				sjf = (ObjectToFile) ois.readObject();
			} catch (IOException | ClassNotFoundException | ClassCastException e1) {
				e1.printStackTrace();
			}
		}

		final ObjectToFile jf = sjf == null ? new ObjectToFile() : sjf;

		jf.setBounds(300, 300, 300, 300);

		jf.jt.setColumns(20);
		JPanel jp = new JPanel();
		jp.add(jf.jt);
		jf.setContentPane(jp);

		jf.setVisible(true);

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jf.jt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				serialize(jf);			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				serialize(jf);
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				serialize(jf);
			}
		});
	}

	private static void serialize(Object o) {
		File f = new File("C:/test/gui");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
			oos.writeObject(o);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
