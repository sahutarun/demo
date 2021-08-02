package automation;

import org.junit.Assert;
import org.junit.Test;

import com.maths.Addition;
import com.maths.Division;
import com.maths.Multiplication;
import com.maths.Substraction;

public class UnitTests {


	@Test
	public void twoAndThreeIsFive() throws Exception {
		final int result = new Addition().add(2, 3);
		Assert.assertEquals(5, result);
	}

	@Test
	public void twoAndZeroIsTwo() throws Exception {
		final int result = new Addition().add(2, 0);
		Assert.assertEquals(2, result);
	}

	@Test
	public void twoAndMinusTwoIsZero() throws Exception {
		final int result = new Addition().add(2, -2);
		Assert.assertEquals(0, result);
	}

	@Test
	public void threeMinusTwoIsOne() throws Exception {
		final int result = new Substraction().subtract(3, 2);
		Assert.assertEquals(1, result);
	}

	@Test
	public void threeMinusThreeIsZero() throws Exception {
		final int result = new Substraction().subtract(3, 3);
		Assert.assertEquals(0, result);
	}

	@Test
	public void threeMinusMinusThreeIsSix() throws Exception {
		final int result = new Substraction().subtract(3, -3);
		Assert.assertEquals(6, result);
	}

	@Test
	public void threeXThreeIsNine() throws Exception {
		final double result = new Multiplication().multiply(3, 3);
		Assert.assertEquals(9, result,Double.NaN);
	}

	@Test
	public void threeXZeroIsZero() throws Exception {
		final double result = new Multiplication().multiply(3, 0);
		Assert.assertEquals(0, result,Double.NaN);
	}

	@Test
	public void threeXMinusThreeIsMinusNine() throws Exception {
		final double result = new Multiplication().multiply(3, -3);
		Assert.assertEquals(-9, result,Double.NaN);
	}


	@Test
	public void threeDivideDByThreeIs1() throws Exception {
		final int result = new Division().divide(3, 3);
		Assert.assertEquals(1, result);
	}

	@Test
	public void twelveDividebByMinusThreeIsMinusFour() throws Exception {
		final int result = new Division().divide(12, -3);
		Assert.assertEquals(-4, result);
	}
	
	@Test
	public void twelveDividebByZeroIsZero() throws Exception {
		final int result = new Division().divide(12, 0);
		Assert.assertEquals(0, result);
	}
	
	@Test
	public void muliplicationTwoNumbersInfinityCondition() throws Exception {
		final double result = new Multiplication().multiply(1.1, Double.MAX_VALUE);
		Assert.assertEquals(Double.POSITIVE_INFINITY, result,Double.NaN);
	
	}
	
	

}
