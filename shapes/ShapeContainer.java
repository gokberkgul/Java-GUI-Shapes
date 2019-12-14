package shapes;

import java.util.ArrayList;
import java.util.*;

public class ShapeContainer implements Iterable {
 
 ArrayList<Shape> shapeList; 
 
 public ShapeContainer(){
  shapeList = new ArrayList<Shape>(); 
 }
 
 public void add(Shape s){
  shapeList.add(s);
 }
 
 public double getArea(){
  double sum = 0;
  for (int i = 0; i < shapeList.size(); i++){
   sum += shapeList.get(i).getArea();
  }
  return sum;
 }
 
 public String toString(){
  String s = "";
  StringBuffer name;
  for (int i = 0; i < shapeList.size(); i++){
   name = new StringBuffer(shapeList.get(i).getClass().getSimpleName());
   while (name.length() != 10)
    name.append(" ");
   s += "" + (i + 1) + ". " + name.toString() + "\t" + shapeList.get(i).getArea() + "\t " + "  " + shapeList.get(i).toString() + "\n"; 
  }
  return s;
 }
 
 public int length(){
  return shapeList.size();
 }
 
 public Shape get(int a){
  return shapeList.get(a);
 }
 
 public void remove(int a){
  shapeList.remove(a);
 }
 
 public Iterator iterator() {
   return shapeList.iterator();
 }
 
 public void removeSelected(){
 
   for(int i=0; i< shapeList.size(); i++){
   
     if(((Shape)shapeList.get(i)).getSelected()){
     
     remove(i);
     }
   
   }
 
 }
  public Shape firstShape(int x, int y ){
    for(int i = 0 ; i < shapeList.size() ; i++){
      Selectable shape = ((Selectable)shapeList.get(i));
      if(shape.contains( x, y )!= null) {
        return shapeList.get(i);
      }
    }
    return null;
  }
 
 public int selectAllAt(int x, int y){
  int count =0;
  for(int i=0; i< shapeList.size();i++){
    Shape tmp;
    tmp = ((Circle)shapeList.get(i)).contains(x,y);
    
    if(tmp != null){
    ((Circle)tmp).setSelected(true);
    shapeList.set(i, tmp);
    count++;
    
    }
    
  }
   
 return count;
 }
 
}
