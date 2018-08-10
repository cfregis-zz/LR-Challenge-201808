package br.com.liferay.challenge.foundation.util;

import java.math.BigDecimal;

public class AuxiliaryFunctions {

	public static BigDecimal customRound(BigDecimal d){
		BigDecimal scale = new BigDecimal("0.05");
		BigDecimal y = d.divide(scale);
		BigDecimal q;
		if(d.remainder(scale).doubleValue() == 0){
			q = y.setScale(0,BigDecimal.ROUND_DOWN);
		} else {
			q = y.setScale(0,BigDecimal.ROUND_UP);
		}
		
		BigDecimal z = q.multiply(scale);
		return z;
	}
}
