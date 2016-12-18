package ru.stqa.pft.sandbox;

public class Point {

  public double x;
  public double y;
  

  //Сделать запускаемый класс, то есть содержащий функцию

  public static void main(String[] args) {

    Point p1 = new Point();
    p1.x = 2;
    p1.y = 4;

    Point p2 = new Point();
    p2.x = 5;
    p2.y = 8;

    System.out.println("Расстояние между точками " + distance(p1, p2));
  }

  public static double distance (Point p1, Point p2) {
    return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
  }


}


