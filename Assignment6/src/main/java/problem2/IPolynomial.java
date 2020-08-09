package problem2;

public interface IPolynomial {

    /**
     * Adds a new term to the existing polynomial, and return the new polynomial.
     * @param coefficient the coefficient of the new term.
     * @param power the power of the new term.
     * @return return the new polynomial after adding a new term.
     * @throws InvalidPolynomialException if the value of the power of the new term is negative.
     */
    Polynomial addTerm(Integer coefficient, Integer power) throws InvalidPolynomialException;

    /**
     * Removes a term with a specific power from the polynomial, and return the new polynomial.
     * @param power - the power of the term wanted to removed
     * @return return the new polynomial after removes a term with a specific power from the polynomial.
     * @throws InvalidPolynomialException  if the value of the power of the new term is negative.
     */
    Polynomial removeTerm(Integer power) throws InvalidPolynomialException;

    /**
     * Returns the degree(the highest power value) of the polynomial, if there is no power, return 0.
     * @return the degree(the highest power value) of the polynomial.
     */
    Integer getDegree();

    /**
     * Returns the corresponding coefficient of the power in the polynomial.
     * @param power the power wanted to get the coefficient.
     * @return  the corresponding coefficient of the power in the polynomial.
     * @throws InvalidPolynomialException if there is no corresponding coefficient for the power or the power is negative.
     */
    Integer getCoefficient(Integer power) throws InvalidPolynomialException;

    /**
     * Returns true when two polynomial is the same, otherwise returns false.
     * @param otherPolynomial the other polynomial wanted to checked
     * @return true when two polynomial is the same, otherwise returns false.
     */
    Boolean isSame(Polynomial otherPolynomial);

    /**
     * Adds two polynomial and returns descending order of their powers.
     * @param otherPolynomial the other polynomial wanted to add.
     * @return  descending order of their powers after adding two polynomial.
     * @throws InvalidPolynomialException if the value of the power of the new polynomial is negative.
     */
    Polynomial add(Polynomial otherPolynomial) throws InvalidPolynomialException;


}
