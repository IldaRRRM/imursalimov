package ru.job4j.condition;

//import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
 /**
 *Class TriangleTest - class for testing class Triangle.
 */
 public class TriangleTest {
 /**
 *method whenAreaSetThreePointsThenTriangleArea calculates area of Triangle with 3 points.
 */
 public void whenAreaSetThreePointsThenTriangleArea() {
    Point a = new Point(0, 0);
    Point b = new Point(0, 2);
    Point c = new Point(2, 0);
    // Создаем объект треугольник и передаем в него объекты точек.
    Triangle triangle = new Triangle(a, b, c);
    // Вычисляем площадь.
    double result = triangle.area();
    // Задаем ожидаемый результат.
    double expected = 2;
    //Проверяем результат и ожидаемое значение.
    assertThat(result, closeTo(expected, 0.1));
 }
 /**
 *method possibleTriangle shows, that can we build the triangle throws this points.
 */
  public void possibleTriangle() {
  	Point a = new Point(0, 0);
  	Point b = new Point(2, 0);
  	Point c = new Point(0, 0);

  	Triangle triangle1 = new Triangle(a, b, c);
  	boolean result = triangle1.possible();
  	boolean expected = false;
  	assertThat(result, is(expected));
  }

}

