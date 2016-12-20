import java.awt.*;
import javax.swing.*;

public class AlohaWindow {
	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setSize(400,400);
		frame.setTitle("青木");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		JLabel label=new JLabel("hello");

		Container ctnr=frame.getContentPane();
		ctnr.add(label);

		JButton button=new JButton("click me");
		Container ctnr2=frame.getContentPane;
		ctnr2.add(button);
		frame.setVisible(true);
	}	
}

