import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class A extends JFrame{
  public static void main(String[] args){
    A test = new A();

    test.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){System.exit(0);}
    });

    test.setBounds( 0, 0, 200, 200);
    test.setVisible(true);
  }

  public void paint(Graphics g){
    Graphics2D g2 = (Graphics2D)g;

    BufferedImage readImage = null;
    try {
      readImage = ImageIO.read(new File("sample.png"));
    } catch (Exception e) {
      e.printStackTrace();
      readImage = null;
    }

    if (readImage == null){
      readImage = new BufferedImage(getWidth(), getHeight(), 
        BufferedImage.TYPE_INT_BGR);
    }

    Graphics2D off = readImage.createGraphics();

    off.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
    RenderingHints.VALUE_ANTIALIAS_ON);

    BasicStroke wideStroke = new BasicStroke(4.0f);
    off.setStroke(wideStroke);

    off.setPaint(Color.white);
    off.draw(new Ellipse2D.Double(30, 40, 50, 50));

    off.setPaint(Color.blue);
    off.draw(new Ellipse2D.Double(70, 40, 50, 50));

    off.setPaint(Color.red);
    off.draw(new Ellipse2D.Double(110, 40, 50, 50));

    off.setPaint(Color.yellow);
    off.fill(new Arc2D.Double(50, 100, 110, 110, 330, 100, Arc2D.PIE));
    off.setPaint(Color.gray);
    off.draw(new Arc2D.Double(50, 100, 110, 110, 330, 100, Arc2D.PIE));

    if (readImage != null){
      g2.drawImage(readImage, 0, 0, this);
    }
  }
}