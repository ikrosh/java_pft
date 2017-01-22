package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void testPrime() {
    System.out.println(Integer.MAX_VALUE);
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test (enabled = false)
  public void testNonPrime() {
    System.out.println(Integer.MAX_VALUE - 2);
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE - 2));
  }

  @Test (enabled = false)
  public void testPrimeLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }


}
