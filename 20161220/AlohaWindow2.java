import java.awt.*;
import javax.swing.*;

public class AlohaWindow2 {
	static JFrame frame;
	static JLabel label;
	static JButton button;
	static Container ctnr;

	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setSize(400,400);
		frame.setTitle("青木");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		label=new JLabel("hello");

		button=new JButton("click me");
		button.add

		ctnr=frame.getContentPane();
		ctnr.add(label);
		ctnr.add(button);

		frame.setVisible(true);
	}	

}