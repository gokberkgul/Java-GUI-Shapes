package shapes;
public class Rectangle extends Shape implements Selectable{
  
  int width;
  int height;
  private boolean selected = false;
  
  
  public Rectangle (int width, int height){
    this.width = width;
    this.height = height;
  }
  
  
  public double getArea() {
    return width * height;
  }
  
  
  public boolean getSelected() {
    return selected;
  }
  
  public void setSelected (boolean a){
    
    selected = a;
  }
    
    public Shape contains(int a, int b){ 
      if(getX() - (double) width/2 < a && getX() + (double) width/2 > a && getY() - (double) height/2 < a && getX() + (double) height/2 > a)
        return this;
      else
        return null;
    }
    
    public String toString(){
      if (selected)
        return width + "," + height + "- Selected";
      else
        return width + "," + height + " - Not selected yet";
    }
  }

