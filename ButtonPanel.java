import shapes.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;

public class ButtonPanel extends JPanel{
  private JButton rect;
  private JButton circle;
  private JButton square;
  static final int HEIGHT_OF_RECT = 80;
  static final int WIDTH_OF_RECT = 100;
  static final int SIDE_OF_SQUARE = 50;
  static final int RADIUS_OF_CIRCLE = 50;
  static final int X = 200;
  static final int Y = 200;
  static ShapeContainer container;
  
  public ButtonPanel(){
    container = new ShapeContainer();
    rect = new JButton("RECT");
    circle = new JButton("CIRCLE");
    square = new JButton("SQUARE");
    
    rect.addActionListener(new ButtonListener());
    circle.addActionListener(new ButtonListener());
    square.addActionListener(new ButtonListener());
    setPreferredSize(new Dimension(1000,200));
    
    add(rect);
    add(circle);
    add(square);
  }
  
  private class ButtonListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e ){
      
      if(e.getSource() == rect){
        Rectangle r = new Rectangle(WIDTH_OF_RECT , HEIGHT_OF_RECT );
        r.setLocation(X , Y );
        r.setSelected(false);
        container.add(r);
      }
      
      if(e.getSource() == circle){
        Circle c = new Circle(RADIUS_OF_CIRCLE);
        c.setLocation(X , Y );
        c.setSelected(false);
        container.add(c);
      }
      
      if(e.getSource() == square){
        Square s = new Square(SIDE_OF_SQUARE);
        s.setLocation(X , Y );
        s.setSelected(false);
        container.add((Square)s);
      }
    }
  }
  
  
  
  
  
}