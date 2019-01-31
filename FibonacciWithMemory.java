package fibmemory;

import java.util.HashMap;
import java.util.Map;
import java.math.BigInteger;

public class FibonacciWithMemory {
	public static Map<Long, BigInteger> m1 = new HashMap();

	public static void main(String[] args) {

		System.out.println(f(1000L));
	}

	private static BigInteger f(Long i) {
		if(i==1) {
			
			return BigInteger.ONE;
		}else if(i==0) {
			return BigInteger.ZERO;
		}
		if(m1.containsKey(i)) {
			return m1.get(i);
		}else {
			
			m1.put(i,f(i-1).add(f(i-2)));
		}
		return m1.get(i);
		
		
	}

}
