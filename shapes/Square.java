
package shapes;

public class Square extends Rectangle {
   int side;
  boolean selected;
  
  public Square(int side){
    super(side,side);
    this.side = side;
    selected = false;
  }
 
 public String toString(){
  if (getSelected())
   return side + "," + side + "- Selected";
  else
   return side + "," + side + " - Not selected yet";
 }
}
