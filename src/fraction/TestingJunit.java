package fraction;

import org.junit.Assert;
import org.junit.Test;


public final class TestingJunit {
    //Tests the correct output for the valid input
    @Test
    public void testAdd() {
        Fraction a =  new FractionImpl(1, 2);
        FractionImpl b = new FractionImpl(1, 2);
        String actual = b.add(a).toString();
        String expected = "1";
        Assert.assertEquals(expected, actual);
    }
    //Tests the exception for zero denominator
    @Test(expected = ArithmeticException.class)
    public void testException() throws ArithmeticException{
        FractionImpl a = new FractionImpl(1,0);
    }
    //Tests the exception from String constructor
    @Test(expected = ArithmeticException.class)
    public void testException1() throws ArithmeticException{
        FractionImpl b = new FractionImpl("1/0");
    }
    //Tests if the reduced fraction is given as output
    @Test
    public void testReduced (){
        FractionImpl c = new FractionImpl("8/-12");
        FractionImpl e = new FractionImpl("80");
        FractionImpl d = new FractionImpl(8,-12);
        String expected1 = "80";
        String actual2 = e.toString();
        String expected = "-2/3";
        String actual = c.toString();
        String actual1 = d.toString();
        Assert.assertEquals(expected,actual);
        Assert.assertEquals(expected,actual1);
        Assert.assertEquals(expected1, actual2);
    }
    //Test 0 as Numerator
    @Test
    public void testZeroNumerator(){
        FractionImpl a = new FractionImpl(0,1);
        String expected = "0/1";

        String actual = a.toString();
       // System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }
    //Tests the subtract function
    @Test
    public void testSubtraction(){
        Fraction a = new FractionImpl(1, 2);
        FractionImpl b = new FractionImpl(1, 2);
        String actual = b.subtract(a).toString();
        String expected = "0/1";
        Assert.assertEquals(expected, actual);

    }
    //Tests the Multiply function
    @Test
    public void testMultiplication(){
        Fraction a = new FractionImpl(1, 2);
        FractionImpl b = new FractionImpl(1, 2);
        String actual = b.multiply(a).toString();
        String expected = "1/4";
        Assert.assertEquals(expected, actual);
    }
    //Tests the Division Function
    @Test
    public void testDivision(){
        Fraction a = new FractionImpl(1, 2);
        FractionImpl b = new FractionImpl(1, 2);
        String actual = b.divide(a).toString();
        String expected = "1";
        Assert.assertEquals(expected, actual);
    }
    //Tests the absolute function
    @Test
    public void testAbsolute(){
        FractionImpl a = new FractionImpl("8/-12");
        //System.out.println(a);
        String expected = "2/3";
        String actual = a.abs().toString();
        Assert.assertEquals(expected,actual);
    }
    //Tests negate function
    @Test
    public void testNegate(){
        FractionImpl a = new FractionImpl("8/-12");
        String expected = "-2/3";
        String actual = a.negate().toString();
        Assert.assertEquals(expected,actual);
    }
    //Tests the equals method
    @Test
    public void testEquals(){
        Fraction a = new FractionImpl(1,2);
        FractionImpl b = new FractionImpl(1,2);
        //Fraction c = new Fraction()
        Assert.assertFalse(a.equals(new StringBuilder("Shiva")));
        Assert.assertTrue(a.equals(a));
        Assert.assertFalse(a.equals(b));
    }
    //Tests the inverse function
    @Test
    public void testInverse(){
        FractionImpl a = new FractionImpl(1,2);
        String expected = "2";
        String expected1 = "2/1";
        String actual =  a.inverse().toString();
        Assert.assertEquals(expected,actual);
        Assert.assertNotEquals(expected1,actual);

    }
    //Tests compareTo method
    @Test
    public void testCompareTo(){
        //Tests the comparison when object o in the function is greater than this
        FractionImpl a = new FractionImpl(1,2);
        Fraction b = new FractionImpl(2,1);
        int expected = -1;
        int actual = a.compareTo(b);
        Assert.assertEquals(expected,actual);
        //Tests the comparison when this in the function is greater than o
        FractionImpl a1 = new FractionImpl(2,1);
        Fraction b1 = new FractionImpl(1,1);
        int expected1 = 1;
        int actual1 = a1.compareTo(b1);
        Assert.assertEquals(expected1,actual1);
        //Tests if the this is 0
        FractionImpl a2 = new FractionImpl(0,1);
        Fraction b2 = new FractionImpl(1,1);
        int expected2 = 0;
        int actual2 = a2.compareTo(b2);
        Assert.assertEquals(expected2,actual2);


    }
}
