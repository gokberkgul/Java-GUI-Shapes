package shapes;
public abstract class Shape implements Locatable{
 
 final double PI = 3.14;
 
 int x;
 int y;
 
 public void setLocation(int x, int y){
  this.x = x;
  this.y = y;
 }
 
 public int getX(){
  return x;
 }
 
 public int getY(){
  return y;
 }
 
 public abstract double getArea();
 public abstract boolean getSelected();
 public abstract void setSelected(boolean a);

}
