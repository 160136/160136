import java.awt.*;
import javax.swing.*;

public class img1 {
	public static void main(String[] args) {
		Iconman man = new Iconman();
	}
}



class Iconman {
	ImageIcon img1;
	ImageIcon img2;
	JFrame frame;
	JPanel panel;
	JLabel label1;
	JLabel label2;
	Container con;

	public Iconman(){
		frame = new JFrame("Iconman");
		frame.setLocation(1000, 500);
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		img1= new ImageIcon("neko.jpg");
		img2 = new ImageIcon("dztj.jpg");

		label1 = new JLabel(img1);
		label2 = new JLabel(img2);
		panel=new JPanel();
	
		panel.add(label1);
		panel.add(label2);
		con = frame.getContentPane();
		con.add(panel);

		frame.setVisible(true);
	}
}