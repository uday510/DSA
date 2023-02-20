/**
 * Construct a class called ComplexNumber which stores two properties
 *
 * real - The real part
 * imaginary - The imaginary part
 *
 * The name of the properties should be strictly real and imaginary
 *
 *
 * Implement the following functionalities inside this class :-
 *
 * add(ComplexNumber) -> Returns an object of ComplexNumber having sum of the two complex numbers.
 *
 * subtract(ComplexNumber) -> Returns an object of ComplexNumber having difference of the two complex numbers.
 *
 * multiply(ComplexNumber) -> Returns an object of ComplexNumber having multiplication of the two complex numbers.
 *
 * divide(ComplexNumber) -> Returns an object of ComplexNumber having division of the two complex numbers.
 */
package ClassAndObject;

public class ComplexNumber {
    float real, imaginary;

    // Define constructor here
    ComplexNumber(float x, float y) {
        this.real = x ;
        this.imaginary = y;
    }

    ComplexNumber add(ComplexNumber x){
        // Complete the function
        return new ComplexNumber(this.real + x.real, this.imaginary + x.imaginary);
    }

    ComplexNumber subtract(ComplexNumber x){
        // Complete the function
        return new ComplexNumber(this.real - x.real, this.imaginary - x.imaginary);
    }

    ComplexNumber multiply(ComplexNumber x){
        // Complete the function
        float r = x.real * this.real - x.imaginary * this.imaginary;
        float i = this.imaginary * x.real + this.real * x.imaginary;
        return new ComplexNumber(r, i);
    }

    ComplexNumber divide(ComplexNumber x){
        // Complete the function
    float r = (this.real * x.real + this.imaginary * x.imaginary) /
            (x.real * x.real + x.imaginary * x.imaginary);

    float i = (this.imaginary * x.real - this.real * x.imaginary) /
            (x.real * x.real + x.imaginary * x.imaginary);

    return new ComplexNumber(r, i);
    }

    /*
        ComplexNumber a = new ComplexNumber(10, 5)
        ComplexNumber b = new ComplexNumber(2, 3)
        ComplexNumber c1 = a.add(b)
        ComplexNumber c2 = a.subtract(b)
        ComplexNumber c3 = a.multiply(b)
        ComplexNumber c4 = a.divide(b)

    */
    public static void main(String[] args) {

    }
}
