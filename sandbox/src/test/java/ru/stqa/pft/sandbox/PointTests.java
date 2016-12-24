package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void TestArea () {
    Point p1 = new Point (2,4);
    Point p2 = new Point(5,8);
    Assert.assertEquals(p1.distance(p2), 5.0);

  }

}
