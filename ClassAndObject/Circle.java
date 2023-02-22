/**Construct a class Circle that represents a Circle.


 The class should support the following functionalities:-
 perimeter() -> returns the perimeter of the circle
 area() -> returns the area of the circle


 Assume Π (pi) = 3.14 for calculations.
 You may define any properties in the class as you see appropriate.
 *
 */

package ClassAndObject;

public class Circle {
    // Define properties here
    int radius;

    // Define constructor here
    Circle(int radius) {
        this.radius = radius;
    }

    float perimeter(){
        // Complete the function
        return (float) (2 * 3.14 * this.radius);

    }

    float area(){
        // Complete the function
        return (float) (3.14 * this.radius * this.radius);

    }
}
