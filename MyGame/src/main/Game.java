package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;

public class Game {
	
	public static void main(String[] args) throws IOException {
		
		JFrame window = new JFrame();
		
		makeFile("README", "txt","CONTROLS:\n \n	Player1:\n		ARROW KEYS - movement\n		COMMA - get smaller PERIOD - get bigger\n \n	Player2:\n		WASD - movement\n		Q - get smaller E - get bigger");
		
		window.setTitle("MyGame");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		
	}
	
	private static void makeFile(String name, String text, String extension) throws IOException {
		
		String DIR = System.getProperty("user.dir");
		String DIR1 = DIR + "/" + name + "." + extension;
		
		System.out.print(DIR + "\n" + DIR1);
		
		File folder = new File(DIR);
		folder.mkdir();
		
		File file = new File(DIR1);
		file.createNewFile();
		
		PrintWriter writer = new PrintWriter(DIR1, "UTF-8");
		writer.print(text);
		writer.close();
		
	}
	
}
