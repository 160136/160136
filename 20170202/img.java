import java.awt.*;
import javax.swing.*;

public class img {
	public static void main(String[] args) {
		Iconman man = new Iconman();
	}
}



class Iconman {
	ImageIcon img;
	JFrame frame;
	JPanel panel;
	JLabel label;
	Container con;

	public Iconman(){
		frame = new JFrame("Iconman");
		frame.setLocation(500, 500);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		img = new ImageIcon("neko.jpg");

		label = new JLabel(img);
		panel=new JPanel();
	
		panel.add(label);
		con = frame.getContentPane();
		con.add(panel);

		frame.setVisible(true);
	}
}