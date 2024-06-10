public class Rectangle {
  private int left;     // the x-coordinate of the left edge
  private int bottom;   // the y-coordinate of the bottom edge
  private int width;    // the width of the rectangle
  private int height;   // the height of the rectangle

  // Constructor 1:
  // defaults every private member to 0
  public Rectangle() {
    this.left   = 0;
    this.bottom = 0;
    this.width  = 0;
    this.height = 0;
  }

  // Constructor 2:
  // takes in 4 parameters and sets the
  // private members to those values
  public Rectangle(int left, int bottom, int width, int height) {
    this.left   = left;
    this.bottom = bottom;
    this.width  = width;
    this.height = height;
    // if negative values are given for
    // width and/or height, set them to 0
    if (this.width < 0) {
      this.width = 0;
    }
    if (this.height < 0) {
      this.height = 0;
    }
  }
  // overriding the toString() method
  // to return a string representation of the rectangle
  @Override
  public String toString() {
    return "base: (" + this.left + "," + this.bottom + ") width:" + this.width + " height:" + this.height + "\n";
  }
  
  // Instance method that gets the area of the rectangle
  public int area() {
    return (this.width * this.height);
  }
  
  // Instance method that gets the perimeter of the rectangle
  public int perimeter() {
    return (2 * (this.width + this.height));
  }

  // Instance method that returns true if every point of 
  // the specified rectangle (i.e., passed by the explicit
  // parameter) is on or within the implicit parameter
  public boolean contains(Rectangle specifiedRectangle) {
    return ((this.left   <= specifiedRectangle.left) 
         && (this.bottom <= specifiedRectangle.bottom) 
         && (this.left + this.width    >= specifiedRectangle.left + specifiedRectangle.width)
         && (this.bottom + this.height >= specifiedRectangle.bottom + specifiedRectangle.height));
  }

  // Static class method that returns the rectangle formed 
  // by the area common to the two rectangles
  public static Rectangle intersection(Rectangle rectangleA, Rectangle rectangleB) {
   
    int x1 = Math.max(rectangleA.left, rectangleB.left);
    int y1 = Math.max(rectangleA.bottom, rectangleB.bottom);
    int x2 = Math.min(rectangleA.left + rectangleA.width, rectangleB.left + rectangleB.width);
    int y2 = Math.min(rectangleA.bottom + rectangleA.height, rectangleB.bottom + rectangleB.height);
    // calculating the overlapping width of the two rectangles
    int width   = x2 - x1;
    // calculating the overlapping height of the two rectangles
    int height  = y2 - y1;
    // If they do not intersect, we return 
    // a rectangle where all fields are zero. 
    if (width < 0 || height < 0) {
      return new Rectangle();
    }
    // otherwise, we return a rectangle with the
    // calculated values
    return new Rectangle(x1, y1, width, height);
  }
  
  // Static class method that returns the total perimeter
  // of two rectangles
  public static int totalPerimeter(Rectangle rectangleA, Rectangle rectangleB) {
    // if the rectangleA contains rectangleB,
    // then return rectangleA's perimeter
    if (rectangleA.contains(rectangleB)) {
      return rectangleA.perimeter();
    } 
    // if the rectangleB contains rectangleA,
    // then return rectangleB's perimeter
    else if (rectangleB.contains(rectangleA)) {
      return rectangleB.perimeter();
    } 
    else {
      // if they do not intersect
      // then return the sum of perimeters of both
      // the rectangles 
      int totalPerimeter = rectangleA.perimeter() + rectangleB.perimeter();
      Rectangle inter = intersection(rectangleA, rectangleB);
      // if the rectangles are disjointed return 
      // their total perimeter
      if (inter.width == 0 || inter.height == 0) {
        return totalPerimeter;
      } 
      else {
        // else subtract the overlapping 
        // perimeter of the rectangles
        // from the total perimeter
        return totalPerimeter - 2 * (inter.width + inter.height);
      }
    }
  }
}
