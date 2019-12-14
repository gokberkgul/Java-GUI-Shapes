package shapes;

import java.util.Scanner;

public class ShapeTester {
 
 public static void menu(){
  System.out.println("1 - Create Shape List");
  System.out.println("2 - Add Shape");
  System.out.println("3 - Show Total Area");
  System.out.println("4 - Show List");
  System.out.println("5 - Check points and find shape");
  System.out.println("6 - Remove all selected items");
  System.out.println("7 - Exit");
  System.out.println("Selection: ");
 }
 
 public static void shapeMenu(){
  System.out.println("Which shape do you want to add?");
  System.out.println("1 - Rectangle");
  System.out.println("2 - Square");
  System.out.println("3 - Circle");
  System.out.println("4 - Exit");
  System.out.println("Selection: ");
 }
 
 public static void pointMenu(){
  System.out.println("Please enter x and y cordinates");
  System.out.println("-0.1 - Exit");
 }
 
 public static void main(String[] args){
  ShapeContainer container = null;
  int selection;
  boolean containerInitialized = false;
  
  do{
   
   menu();
   
   Scanner scan = new Scanner(System.in);
   selection = scan.nextInt();
    
   if (selection == 1){
    container = new ShapeContainer();
    containerInitialized = true;
    System.out.println("List created");
   }
   
   if (selection == 2 && containerInitialized == true){
    
    shapeMenu();
    
    int selection2 = scan.nextInt();
    
    if (selection2 == 1){
     System.out.println("Please enter width");
     int width = scan.nextInt();
     System.out.println("Please enter height");
     int height = scan.nextInt();
     container.add(new Rectangle(width, height));
    }
    
    if (selection2 == 2){
     System.out.println("Please enter side");
     int side = scan.nextInt();
     container.add(new Square(side));
    }
    
    if (selection2 == 3){
     System.out.println("Please enter radius");
     int radius = scan.nextInt();
     container.add(new Circle(radius));
    }
    
    if (selection2 == 4){}
   }
   
   if (selection == 3 && containerInitialized)
    System.out.println(container.getArea());
   
   if (selection == 4 && containerInitialized)
    System.out.println(container.toString());
   
   if (selection == 5 && containerInitialized){
    
    double x = scan.nextDouble();
    
    if (x != - 0.1){
     
     int y = scan.nextInt();

     
     for (int i = 0; i < container.length(); i++){
      
      Rectangle rectangle = null;
      Circle circle = null;
      Square square = null;
      
      if (container.get(i) instanceof Square)
       square = (Square) container.get(i);
      
      else if (container.get(i) instanceof Rectangle)
        rectangle = (Rectangle) container.get(i);
      
      else if (container.get(i) instanceof Circle)
        circle = (Circle) container.get(i);
      
      
       
      if (rectangle != null && rectangle.contains( (int) x, y) != null){
       
       System.out.println("This is a rectangle with sizes " + rectangle.toString() + "- on index " + i);
       System.out.println("Do you want to select this? (Y\\N)");
       String input = scan.next();
       
       if (input.toLowerCase().equals("y"))
        rectangle.setSelected(true);
       
       else if (input.toLowerCase().equals("n"))
        rectangle.setSelected(false);
       
       else
        System.out.println("Invalid selection");
       
       break;
      }
      
      if (square != null && square.contains( (int) x, y) != null){
       
       System.out.println("This is a square with side " + square.toString() + "- on index " + i);
       System.out.println("Do you want to select this? (Y\\N)");
       String input = scan.next();
       
       if (input.toLowerCase().equals("y"))
        square.setSelected(true);
       
       else if (input.toLowerCase().equals("n"))
        square.setSelected(false);
       
       else
        System.out.println("Invalid selection");
       
       break;
      }
      
      if (circle != null && circle.contains( (int) x, y) != null){
       
       System.out.println("This is a circle with radius " + circle.toString() + "- on index " + i);
       System.out.println("Do you want to select this? (Y\\N)");
       String input = scan.nextLine();
       
       if (input.toLowerCase().equals("y"))
        circle.setSelected(true);
       
       if (input.toLowerCase().equals("n"))
        circle.setSelected(false);
        
       else
        System.out.println("Invalid selection");
      
       break;
      }
     }
    }
   } 
   
   if (selection == 6 && containerInitialized){
    for (int i = 0; i < container.length(); i++){
     
     Rectangle rectangle = null;
     Circle circle = null;
     Square square = null;
     
     if (container.get(i).getClass().getSimpleName().equals("Rectangle"))
      rectangle = (Rectangle) container.get(i);
     else if (container.get(i).getClass().getSimpleName().equals("Circle"))
       circle = (Circle) container.get(i);
     else if (container.get(i).getClass().getSimpleName().equals("Square"))
       square = (Square) container.get(i);
     
     if (circle != null && circle.getSelected()){
      container.remove(i);
      i--;
     }
     
     if (rectangle != null && rectangle.getSelected()){
      container.remove(i);
      i--;
     }
     
     if (square != null && square.getSelected()){
      container.remove(i);
      i--;
     }
    }
   }
   
   if (!containerInitialized)
    System.out.println("List hasn't created yet");
   
  }while (selection != 7);
  
  System.out.println("Terminated");
 }
 
}
