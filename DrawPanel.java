import shapes.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import java.util.Iterator;
import java.awt.Color;

public class DrawPanel extends JPanel{
  
  Drag drag = new Drag();
  public DrawPanel(){
    
    
    setPreferredSize(new Dimension(1000, 800));
    setBackground(Color.white);
    addMouseListener(drag);
    addMouseMotionListener(drag);
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Iterator<shapes.Shape> it = ButtonPanel.container.iterator();
    while(it.hasNext()){
      Shape shape1 = it.next();
      if(shape1 instanceof Circle){
        Circle circle2 = (Circle)shape1;
        int x = circle2.getX();
        int y = circle2.getY();
        g.setColor(Color.red);
        g.drawOval((int)(x - ButtonPanel.RADIUS_OF_CIRCLE), (int)(y - ButtonPanel.RADIUS_OF_CIRCLE), (int)ButtonPanel.RADIUS_OF_CIRCLE * 2, (int)ButtonPanel.RADIUS_OF_CIRCLE * 2);
        
      }
      
      
      
      else if(shape1 instanceof Square){
        Square sqrt2 = (Square)shape1;
        int x = sqrt2.getX();
        int y = sqrt2.getY();
        g.setColor(Color.pink);
        g.drawRect((int)(x - ButtonPanel.SIDE_OF_SQUARE/2), (int)(y - ButtonPanel.SIDE_OF_SQUARE/2), (int)ButtonPanel.SIDE_OF_SQUARE , (int)ButtonPanel.SIDE_OF_SQUARE ); 
        
      }
      else if(shape1 instanceof Rectangle){
        Rectangle rect2 = (Rectangle)shape1;
        int x = rect2.getX();
        int y = rect2.getY();
        g.setColor(Color.green);
        g.drawRect((int)(x - ButtonPanel.WIDTH_OF_RECT/2), (int)(y - ButtonPanel.HEIGHT_OF_RECT/2), (int)ButtonPanel.WIDTH_OF_RECT , (int)ButtonPanel.HEIGHT_OF_RECT ); 
      }
      
    }
    repaint();
  }
  
  private class Drag implements MouseListener, MouseMotionListener{
    
    public Drag(){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseMoved(MouseEvent e) {}
    
    public void mousePressed(MouseEvent e){
      int xAxis = e.getX();
      int yAxis = e.getY();
      
      Iterator<shapes.Shape> it = ButtonPanel.container.iterator();
      
      
      while(it.hasNext()){
        Shape shape1 = it.next();
        if(shape1 == ButtonPanel.container.firstShape(xAxis, yAxis)){
          shape1.setSelected(true);
        }
      }     
    }
    
    public void mouseReleased(MouseEvent e){
      Iterator<shapes.Shape> it = ButtonPanel.container.iterator();
      
      
      while(it.hasNext()){
        Shape shape1 = it.next();
        shape1.setSelected(false);
      }
    }
    
    
    public void mouseDragged(MouseEvent e) {
      Iterator<shapes.Shape> it1 = ButtonPanel.container.iterator();
      
      while(it1.hasNext()){
        Shape shape1 = it1.next();
        if(shape1.getSelected()){
          shape1.setLocation(e.getX() , e.getY() );
          repaint();
        }
      }
    }
    
  }
  
  
}
