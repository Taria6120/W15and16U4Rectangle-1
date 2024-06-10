// Filename: W15&16U4_Rectangle
// Author: Alishba Tariq 
// Date:  Wednesday, February 14, 2024
// Purpose: The purpose of this class is to test the Rectangle class. Objects are created and tested to see if they are properly initialized, and if they are properly formatted. Negative values used in the constructor are also tested, they should be set to 0. The area and perimeter methods are also tested to see if they are properly calculated. The contains method, intersections, and totalPerimeter methods are also tested to see if they are properly calculated. In the Main Class, I have put if statements to make sure the output is accurate.

//------------------------------

public class Main {
  // Test 1:
  // if the values are correctly aligned with
  // the values in the toString() method, then
  // it should print out the following
  // We are also checking if the toString() method
  // returns the correct string 
  public static void main(String[] args) {
  Rectangle rectA = new Rectangle(0, 0, 4, 4);
  System.out.println("Rectangle A: " + rectA);
  
  if (rectA.toString().contains("base: (0,0) width:4 height:4")) {
      System.out.println("Test 1a: Passed\n");
    } 
  Rectangle rectB = new Rectangle(3, 2, 4, 5);
  System.out.println("Rectangle B: " + rectB);
  if (rectB.toString().contains("base: (3,2) width:4 height:5")){
    System.out.println("Test 1b: Passed\n");
  }
  Rectangle rectC = new Rectangle(1, 1, 3, 3);
  System.out.println("Rectangle C: " + rectC);
  if (rectC.toString().contains("base: (1,1) width:3 height:3")) {
    System.out.println("Test 1c: Passed\n");
  }

  // Test 2:
  // if the values in the area() and perimeter() 
  // methods are correct, the following will print
  System.out.println("Area of A: " + rectA.area() + " Perimeter of A: " + rectA.perimeter() + "\n");
    if ((rectA.area() == 16) 
    && (rectA.perimeter() == 16 )){ 
      System.out.println("Test 2a: Passed\n");
    }
  System.out.println("Area of B: " + rectB.area() + " Perimeter of B: " + rectB.perimeter() + "\n");
    if ((rectB.area() == 20) 
    && (rectB.perimeter() == 18 )){ 
      System.out.println("Test 2b: Passed\n");
    }
  System.out.println("Area of C: " + rectC.area() + " Perimeter of C: " + rectC.perimeter() + "\n");
    if ((rectC.area() == 9) 
    && (rectC.perimeter() == 12 )){ 
      System.out.println("Test 2c: Passed\n");
    }

  // Test 3: 
  // if the values in the contains() method are 
  // correct, then the following will print
  System.out.println("Rectangle A contains Rectangle B: " + rectA.contains(rectB) + "\n");
    if (rectA.contains(rectB) == false){
      System.out.println("Test 3a: Passed\n");
    }
  System.out.println("Rectangle B contains Rectangle 3: " + rectB.contains(rectC) + "\n");
    if (rectB.contains(rectC) == false){
      System.out.println("Test 3b: Passed\n");
    }

  
  Rectangle rectD = new Rectangle(4, 5, 3, 3);
  Rectangle inter = Rectangle.intersection(rectB, rectD);
  System.out.println(inter + "of rectangle D \n");
   
    
  // rectE had negative values
  // the output should be a rectangle with all fields set to 0
  // In this case because rectE is intersecting
  // with rectB, then only rectB values should show
  // and the perimeter of rectB should show
  Rectangle rectE = new Rectangle(-12, -12, -3, -4);
  Rectangle inter2 = Rectangle.intersection(rectB, rectE);
    
  System.out.println("Total Perimeter of rectangle B and E:" + Rectangle.totalPerimeter(rectB, rectE) + "\n");
  //
  System.out.println("Total Perimeter of rectangle B and D:" + Rectangle.totalPerimeter(rectB, rectD) + "\n");
    
  Rectangle intersection = Rectangle.intersection(rectA, rectC);
  int totalperimeter = Rectangle.totalPerimeter(rectA, rectC);
  System.out.println("Intersection of rectangle A and rectangle C is: " + intersection + "\n");
  System.out.println("Total perimeter of rectangle A and rectangle C is: " + totalperimeter + "\n");
  }
}