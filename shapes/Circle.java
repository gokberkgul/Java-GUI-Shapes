package shapes;

public class Circle extends Shape implements Selectable{

 int radius;

 boolean selected = false;
 boolean contains = false;
 
 public Circle(int radius){
  this.radius = radius;
  
 }
 
 public double getArea(){
  return PI * Math.pow(radius, 2);
 }



 public boolean getSelected() {
  return selected;
 }
 
 public int getRadius(){
 return radius;
 }
 
 public void changeRadius(double r){
 
   radius=(int)r;
 
 }

 
 public void setSelected(boolean b) {
   selected = b;
 }


 public Shape contains (int a, int b) 
 {
  if( Math.pow( Math.pow( getX() - a, 2) + Math.pow( getY() - b, 2), 0.5) <= radius)
   return this; 
  else
   return  null; 
 }
 
 public String toString(){
  if (selected)
   return radius + " - Selected";
  else
   return radius + " - Not selected yet";
 }
}
