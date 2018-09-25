package sk.itlearning.java3.c.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

public class CatchDeclare {

	private static class CustomBigDecimal extends BigDecimal {

		private static final long serialVersionUID = 1L;

		public CustomBigDecimal(Double val) {
			super(val);
		}

		public BigDecimal divide(CustomBigDecimal divisor) throws DivisionByZeroException {
			BigDecimal ret = null;
			try {
				ret = super.divide(divisor);
			} catch (ArithmeticException e) {
				if (divisor.equals(new BigDecimal(0))) {
					throw new DivisionByZeroException();
				}
			}
			return ret;
		}
	}

	public static void main(String[] args) {

//		BigDecimal a = new BigDecimal(10);
//
//		BigDecimal b = a.divide(new BigDecimal(0));
		
		CustomBigDecimal c = new CustomBigDecimal(10.0);
		
		try {
			c.divide(new CustomBigDecimal(0.0));
		} catch (DivisionByZeroException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("idem dalej");
	}

}
