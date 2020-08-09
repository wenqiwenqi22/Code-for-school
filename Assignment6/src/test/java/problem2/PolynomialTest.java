package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolynomialTest {
    private Polynomial polynomial;
    private Polynomial emptyPolynomial;

    @Before
    public void setUp() throws Exception {
        emptyPolynomial = new Polynomial();
        polynomial = new Polynomial(2,2, emptyPolynomial);
    }

    @Test
    public void addTerm() throws InvalidPolynomialException {
        Polynomial newPolynomial = emptyPolynomial.addTerm(2,2);
        assertEquals(newPolynomial, polynomial);
    }

    @Test
    public void removeTerm() throws InvalidPolynomialException {
        Polynomial newPolynomial = polynomial.removeTerm(1);
        assertEquals(newPolynomial, polynomial);
        newPolynomial = polynomial.removeTerm(2);
        assertEquals(newPolynomial, emptyPolynomial);
    }

    @Test
    public void getDegree() {
        assertEquals((int)emptyPolynomial.getDegree(), 0);
        assertEquals((int)polynomial.getDegree(), 2);
    }

    @Test
    public void getCoefficient() throws InvalidPolynomialException {
        assertEquals((int)polynomial.getCoefficient(2), 2);
    }

    @Test(expected =  InvalidPolynomialException.class)
    public void getCoefficientFail() throws InvalidPolynomialException {
        polynomial.getCoefficient(1);
    }

    @Test
    public void isSame() throws InvalidPolynomialException {
        assertTrue(polynomial.removeTerm(2).isSame(emptyPolynomial));
        assertTrue(emptyPolynomial.addTerm(2,2).isSame(polynomial));
    }

    @Test
    public void add() throws InvalidPolynomialException {
        //polynomial2 = 3x^3 - 1x^2 + 4
        Polynomial polynomial2 = polynomial.addTerm(3,3).addTerm(-1,2).addTerm(4,0);
        //sum =polynomial2 + polynomial =  3x^3 + 1x^2 + 4
        Polynomial sum = polynomial2.add(polynomial);
        //newPoly = 3x^3 + 1x^2 + 4
        Polynomial newPoly = emptyPolynomial.addTerm(3,3).addTerm(1,2).addTerm(4,0);
        assertEquals(sum, newPoly);

    }

    @Test
    public void testEquals() throws InvalidPolynomialException {
        assertEquals(emptyPolynomial, new Polynomial());
        assertEquals(emptyPolynomial.addTerm(2,2), polynomial);
    }

    @Test
    public void testHashCode() throws InvalidPolynomialException {
        assertEquals(emptyPolynomial.hashCode(), new Polynomial().hashCode());
        assertEquals(emptyPolynomial.addTerm(2,2).hashCode(), polynomial.hashCode());
    }

    @Test
    public void testToString() throws InvalidPolynomialException {
        String s1 = "2x^2";
        String s2 = "3x^3+2x^2+4";
        assertEquals(polynomial.toString(), s1);
        polynomial = polynomial.addTerm(4,0).addTerm(3,3);
        assertEquals(polynomial.toString(), s2);
    }
}