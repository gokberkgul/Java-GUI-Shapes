import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import shapes.*;
import java.util.Iterator;



public class Frame extends JFrame{
  
  
  public static void main(String[] args){
    
    JFrame frame = new JFrame("Click and Drag");
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout() );
    ButtonPanel panel = new ButtonPanel();
    DrawPanel panel2 = new DrawPanel();
    
    mainPanel.add(panel2, BorderLayout.NORTH);
    mainPanel.add(panel, BorderLayout.SOUTH);
    
    
    frame.getContentPane().add( mainPanel);
    frame.pack();
    frame.setVisible( true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    
  }
}