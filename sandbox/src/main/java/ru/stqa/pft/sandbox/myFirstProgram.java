package ru.stqa.pft.sandbox;

import org.testng.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MyFirstProgram {

  public static void main(String[] args) {
    //System.out.println("Hello, world! New Year is coming!");

    Point p1 = new Point (1,4);
    Point p2 = new Point(5,8);
    double dis = p1.distance(p2);
    float dis1 = new BigDecimal(dis).setScale(2, RoundingMode.HALF_UP).floatValue();
    System.out.println("Расстояние между точками " + dis1);
    Assert.assertEquals(dis1, 5.66);

  }
}

