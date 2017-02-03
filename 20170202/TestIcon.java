
import java.awt.*;
import javax.swing.*;

public class TestIcon {
	public static void main(String[] args) {
		Iconman man = new Iconman();
	}
}



class Iconman {
	ImageIcon img;
	JFrame frame;
	JPanel panel;
	JLabel label;

	public Iconman(){
		frame = new JFrame("Iconman");
		frame.setLocation(400, 400);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		img = new ImageIcon("neko.jpg");

		label = new JLabel(img);
		panel = new JPanel();

		panel.add(label);
		Container con = frame.getContentPane();
		con.add(panel);

		frame.setVisible(true);
	}
}