package problem2;

import java.util.Objects;

/**
 * Polynomial is an object that implements IPolynomial interface and override all the methods from the interface. The elements follows a descending order
 * its power value. For example 5x^2 + 4x^1 - 2 and -50x^3 + 1x^2 + 3
 * {@value #NEGATIVE_SIGN} used for turning a negative coefficient to positive so it can be presented appropriately in toString method.
 */
public class Polynomial implements IPolynomial{
    public static final int NEGATIVE_SIGN = -1;
    private Integer coefficient;
    private Integer power;
    private Polynomial next;


    /**
     * Construct an empty polynomial.
     */
    public Polynomial() {
        this.coefficient = null;
        this.power = null;
        this.next = null;
    }

    /**
     * Constructs a non-empty polynomial.
     * @param coefficient the coefficient of the highest power value.
     * @param power the highest power value of the polynomial.
     * @param next the next polynomial after the term of the the highest power
     * @throws InvalidPolynomialException if the value of the power is negative value or the power is smaller than the degree of the next
     */
    public Polynomial(Integer coefficient, Integer power, Polynomial next) throws InvalidPolynomialException{
        if (power < 0){
            throw new InvalidPolynomialException("This value of power is invalid.");
        }


        if (next.getDegree() == null || next.getDegree() == 0 || power > next.getDegree() ){
            this.power = power;
            this.coefficient = coefficient;
            this.next = next;
        }else {
            throw new InvalidPolynomialException("This is not a valid Polynomial.");
        }

    }

    /**
     * Returns true if the polynomial is empty.
     * @return true if the polynomial is empty.
     */
    private boolean isEmpty(){
        if ((this.coefficient == null ||this.coefficient == 0)
                && (this.power == null ||this.power == 0)
                && (this.next == null || this.next.isEmpty())){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Adds a new term to the existing polynomial, and return the new polynomial.
     * @param coefficient the coefficient of the new term.
     * @param power the power of the new term.
     * @return return the new polynomial after adding a new term.
     * @throws InvalidPolynomialException if the value of the power of the new term is negative.
     */
    @Override
    public Polynomial addTerm(Integer coefficient, Integer power) throws InvalidPolynomialException {
        if (power < 0) {
            throw new InvalidPolynomialException("This value of power is invalid.");
        }

        if (this.getDegree() == null || this.getDegree() == 0|| power > this.getDegree()) {
            return new Polynomial(coefficient, power, this);
        }else if (power.equals(this.getDegree())) {
            return new Polynomial(coefficient + this.coefficient, power, this.next);
        } else {

            Polynomial newNext = new Polynomial();
            if (!this.getNext().isEmpty()) {
                newNext = new Polynomial(this.getNext().coefficient,
                        this.getNext().power, this.getNext().getNext());
            }
            newNext = newNext.addTerm(coefficient, power);
            return  new Polynomial(this.coefficient, this.power, newNext);
        }
    }

    /**
     * Removes a term with a specific power from the polynomial, and return the new polynomial.
     * @param power - the power of the term wanted to removed
     * @return return the new polynomial after removes a term with a specific power from the polynomial.
     * @throws InvalidPolynomialException  if the value of the power of the new term is negative.
     */
    @Override
    public Polynomial removeTerm(Integer power) throws InvalidPolynomialException {
        if(power < 0) {
            throw new InvalidPolynomialException("This value of power is invalid.");
        }

        if (power.equals(this.getDegree())) {
            if (!this.getNext().isEmpty()) {
                return new Polynomial(this.getNext().coefficient, this.getNext().power, this.getNext().getNext());
            }else {
                return new Polynomial();
            }
        } else  {
            Polynomial newNext = new Polynomial();
            if (!this.getNext().isEmpty()){
                newNext = new Polynomial(this.getNext().coefficient, this.getNext().power, this.getNext().getNext());

            }
            if (newNext.isEmpty()){
                return this;
            }else {
                newNext = newNext.removeTerm(power);
            }
            return new Polynomial(this.coefficient, this.power, newNext);
        }

    }

    /**
     * Returns the degree(the highest power value) of the polynomial, if there is no power, return 0.
     * @return the degree(the highest power value) of the polynomial.
     */
    @Override
    public Integer getDegree() {
        // if there is no power,return 0
        if (power == null) {
            return 0;
        }
        return this.power;
    }

    /**
     * Returns the next polynomial of the current polynomial.
     * @return the next polynomial of the current polynomial.
     */
    private Polynomial getNext() {
        return this.next;
    }

    /**
     * Returns the corresponding coefficient of the power in the polynomial.
     * @param power the power wanted to get the coefficient.
     * @return  the corresponding coefficient of the power in the polynomial.
     * @throws InvalidPolynomialException if there is no corresponding coefficient for the power or the power is negative.
     */
    @Override
    public Integer getCoefficient(Integer power) throws InvalidPolynomialException{
        if (power.equals(this.getDegree())) {
            return this.coefficient;
        }else if (power >= 0 && power < this.getDegree()) {
            if (!this.getNext().isEmpty()) {
                return this.getNext().getCoefficient(power);
            } else{// no corresponding coefficient for the power
                throw new InvalidPolynomialException("The power  not found.");
            }
        } else {
            throw new InvalidPolynomialException("The power is invalid or not found.");
        }

    }

    /**
     * Returns true when two polynomial is the same, otherwise returns false.
     * @param otherPolynomial the other polynomial wanted to checked
     * @return true when two polynomial is the same, otherwise returns false.
     */
    @Override
    public Boolean isSame(Polynomial otherPolynomial) {
        return this.equals(otherPolynomial);
    }

    /**
     * Adds two polynomial and returns descending order of their powers.
     * @param otherPolynomial the other polynomial wanted to add.
     * @return  descending order of their powers after adding two polynomial.
     * @throws InvalidPolynomialException if the value of the power of the new polynomial is negative.
     */
    @Override
    public Polynomial add(Polynomial otherPolynomial) throws InvalidPolynomialException {
        if (otherPolynomial.getNext() == null || otherPolynomial.getNext().isEmpty()) {
            return this;
        }
        Polynomial newTerm = new Polynomial();
        newTerm =  this.addTerm(otherPolynomial.coefficient, otherPolynomial.power);
        this.add(otherPolynomial.getNext());

        return newTerm;
    }

    /**
     * Returns true if two polynomial is equals.
     * @param o the polynomial wanted to check
     * @return true if two polynomial is equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polynomial that = (Polynomial) o;
        return Objects.equals(coefficient, that.coefficient) &&
                Objects.equals(power, that.power) &&
                Objects.equals(next, that.next);
    }

    /**
     * Returns the hash code of the polynomial.
     * @return the hash code of the polynomial.
     */
    @Override
    public int hashCode() {
        return Objects.hash(coefficient, power, next);
    }


    /**
     * Returns the string format of the polynomial. For example, 5x^2 + 4x^1 - 2, -50x^3 + 1x^2 + 3 and 2x^5 - 3x^2 + 4x^1 - 10.
     * @return the string format of the polynomial. For example,5x^2 + 4x^1 - 2, -50x^3 + 1x^2 + 3 and 2x^5 - 3x^2 + 4x^1 - 10.
     */
    @Override
    public String toString(){
        return toStringHelper(this, true);
    }

    /**
     * A helper function that build the string format in a recursive way.
     * @param temp a temporary polynomial represented the whole polynomial
     * @param firstTerm it is true if the term is the first term in the whole polynomial, otherwise is false.
     * @return the string format of the polynomial object.
     */
    private String toStringHelper(Polynomial temp, boolean firstTerm){
        String tmpResult;
        if (temp.getNext() == null) {
            return "";
        }

        if (firstTerm && temp.coefficient > 0 && temp.power != null && temp.power != 0) {

            tmpResult = temp.coefficient + "x" + "^" + temp.power ;

            //handle the first term if it is a constant
        }else if (firstTerm && temp.coefficient != 0 &&
                (temp.power == null || temp.power.equals(0))) {
            if (temp.coefficient > 0) {
                tmpResult =  temp.coefficient.toString();
            }else {
                tmpResult = "-" + temp.coefficient * NEGATIVE_SIGN;
            }

            //handle constant which is not the first term
        } else if (!firstTerm &&temp.coefficient != 0
                && (temp.power == null || temp.power.equals(0))){
            if (coefficient > 0) {
                tmpResult = "+" + temp.coefficient;
            }else {
                tmpResult = "-" + temp.coefficient;
            }

            //other cases
        }else {
            if(coefficient > 0) {
                tmpResult = "+" + temp.coefficient + "x^" + temp.power;
            }else {
                tmpResult = "-" + temp.coefficient + "x^" + temp.power;
            }
        }
        return tmpResult + toStringHelper(temp.getNext(), false);
    }
}