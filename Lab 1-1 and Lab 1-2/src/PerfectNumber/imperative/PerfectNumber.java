package PerfectNumber.imperative;


import java.util.HashSet;
import java.util.Set;

public class PerfectNumber 
{
	public static Set<Integer> divisors(int number)
	{
		Set<Integer> divisors = new HashSet<>();
		for (int i = 1; i <= Math.ceil(Math.sqrt(number)); i++)
		{
			if (number % i == 0)
			{
				divisors.add(i);
				divisors.add(number/i);
			}
		}
		return divisors;
	}
	
	public static STATE process(int number)
	{
		Set<Integer> divisors = PerfectNumber.divisors(number);
		int sum =0;
		for (Integer divisor : divisors)
		{
			if (divisor != number)
			{
				sum+=divisor;
			
			}
		}
		
		if(sum < number)
		{
			return STATE.DEFICIENT;
		}
		else if(sum > number)
		{
			return STATE.ABUNDANT;
		}
		else
		{
			return STATE.PERFECT;
		}
		
	}
	
}

