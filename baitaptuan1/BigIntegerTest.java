package oop.asg02;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Unit test for BigInteger class.
 */
public class BigIntegerTest
{
    @Test
    public void testCreateBigIntegerFromInt()
    {
        BigInteger bigInt = new BigInteger(10);
        assertEquals("10", bigInt.toString());
    }

    @Test
    public void testCreatBigIntFromLong()
    {
        BigInteger bigInt = new BigInteger(10L);
        assertEquals("10", bigInt.toString());
    }
    @Test
    public void testCreateBigIntegerFromStringWithLeadingZero()
    {
        BigInteger bigInt = new BigInteger("010");
        assertEquals("10", bigInt.toString());
    }

    @Test
    public void testCreateBigIntegerFromStringWithAllZeros()
    {
        BigInteger bigInt = new BigInteger("000");
        assertEquals("0", bigInt.toString());
    }

    @Test
    public void testCreateBigIntegerFromStringWithAllButUnitZeros()
    {
        BigInteger bigInt = new BigInteger("001");
        assertEquals("1", bigInt.toString());
    }

    @Test
    public void testConvertToLongWhenNotOverRange()
    {
        BigInteger bigInt = new BigInteger("10");
        assertEquals(10L, bigInt.toLong());
    }
    
    @Test
    public void testEquality()
    {
        BigInteger bigInt1 = new BigInteger(10);
        BigInteger bigInt2 = new BigInteger(10);
        BigInteger bigInt3 = new BigInteger("10");
                
        assertEquals(bigInt1, bigInt2);
        assertEquals(bigInt1, bigInt3);
    }
    
    @Test
    public void testInequality()
    {
        BigInteger bigInt1 = new BigInteger(10);
        BigInteger bigInt2 = new BigInteger(12);
                
        assertFalse(bigInt1.equals(bigInt2));
    }
    
    @Test
    public void testAdditionWithoutCarryOn()
    {
        BigInteger bigInt1 = new BigInteger("111111111111111111111");
        BigInteger bigInt2 = new BigInteger("1");
        BigInteger sum = bigInt1.add(bigInt2);
        
        assertEquals(new BigInteger("111111111111111111112"), sum);
    }
   
    @Test
    public void testAdditionWithCarryOn()
    {
        BigInteger bigInt1 = new BigInteger("111111111111111111111");
        BigInteger bigInt2 = new BigInteger("9");
        BigInteger sum = bigInt1.add(bigInt2);
        
        assertEquals(new BigInteger("111111111111111111120"), sum);
    }
    
    @Test
    public void testSubtractionWithoutCarryOn()
    {
        BigInteger bigInt1 = new BigInteger("111111111111111111111");
        BigInteger bigInt2 = new BigInteger("1");
        BigInteger difference = bigInt1.subtract(bigInt2);
        
        assertEquals(new BigInteger("111111111111111111110"), difference);
    }
    
    @Test
    public void testSubtractionWithCarryOn()
    {
        BigInteger bigInt1 = new BigInteger("111111111111111111111");
        BigInteger bigInt2 = new BigInteger("9");
        BigInteger difference = bigInt1.subtract(bigInt2);
        
        assertEquals(new BigInteger("111111111111111111102"), difference);
    }

    @Test
    public void testCompareTo()
    {
        BigInteger bigInt1= new BigInteger("111111111111111111111");
        BigInteger bigInt2= new BigInteger("1111111111111111111111");
        int difference= bigInt1.compareTo(bigInt2);

        assertEquals(-1,difference);
    }

    @Test
    public void testClone() {
        BigInteger n1 = new BigInteger("11111111111111111111111111111");
        BigInteger n2 = n1.clone();
        BigInteger n3 = new BigInteger(111222365);
        BigInteger n4 = n3.clone();
        assertEquals(n1, n2);
        assertEquals(n3, n4);
        assertFalse(n1==n2);
    }

    @Test
    public void testCompare() {
        BigInteger n1 = new BigInteger("1111111111111111111111");
        BigInteger n2 = new BigInteger("1111111111111111111112");
        BigInteger n3 = new BigInteger("1111111111111111111111");
        BigInteger n4 = new BigInteger("1111111111111111111110");
        int a = n1.compareTo(n2);
        int b = n1.compareTo(n3);
        int c = n1.compareTo(n4);

        assertEquals(-1, a);
        assertEquals(0, b);
        assertEquals(1, c);
    }
}