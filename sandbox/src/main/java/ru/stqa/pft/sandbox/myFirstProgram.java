package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    //System.out.println("Hello, world! New Year is coming!");

    Point p1 = new Point (2,4);
    Point p2 = new Point(5,8);
    System.out.println("Расстояние между точками " + p1.distance(p2));

  }



}

