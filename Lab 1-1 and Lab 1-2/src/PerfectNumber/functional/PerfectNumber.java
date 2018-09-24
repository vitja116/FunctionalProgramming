package PerfectNumber.functional;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import PerfectNumber.imperative.STATE;


public class PerfectNumber 
{
    public static Set<Integer> divisors(int number) 
    {
        return IntStream.range(1, (int) Math.sqrt(number) + 1)
                .filter(i -> number % i == 0)
                .boxed()
                .flatMap(divisor -> Stream.of(divisor, number / divisor))
                .collect(Collectors.toSet());
    }

    public static STATE process(int number) 
    {
        Function<Integer, STATE> matchPerfectOrAbundant = divisorSum -> Optional.of(divisorSum)
                .filter(sum -> sum == number).map(sum -> STATE.PERFECT)
                .orElse(STATE.ABUNDANT);
        return PerfectNumber.divisors(number).stream()
                .filter(divisor -> divisor != number)
                .reduce((sum, divisor) -> sum + divisor)
                .filter(sum -> sum >= number)
                .map(matchPerfectOrAbundant)
                .orElse(STATE.DEFICIENT);
    }
}