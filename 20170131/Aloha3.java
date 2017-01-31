import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Aloha3 {
	public static void main(String[] args) {
		String[] data = new String[100];
		Windowman wman = new Windowman();
		Dataman dman = new Dataman();
		Fileman fman = new Fileman();
	}
}

class Windowman {
	JFrame frame;
	JLabel labelName;
	JPanel panelName;
	JPanel panelButton;
	JButton buttonOk;

	public Windowman(){
		System.out.println("Aloha, Windowman!");

		frame = new JFrame("windowman");
		frame.setLocation(400, 400);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		labelName = new JLabel("名前");

		buttonOk = new JButton("OK");

		panelName = new JPanel();
		panelButton = new JPanel();

		panelName.add(labelName);
		panelButton.add(buttonOk);

		Container con = frame.getContentPane();
		con.setLayout(new GridLayout(4, 1));
		con.add(panelName);
		con.add(panelButton);

		frame.setVisible(true);
	}
}


class Dataman {
	public Dataman() {
		System.out.println("Aloha, Dataman!");
	}
}


class Fileman {
	public Fileman() {
		System.out.println("Aloha, Fileman!");
	}
}