import org.junit.*;
import static org.junit.Assert.*;

public class RectangleTest {

//the app gets the input and returns the String
  @Test
  public void Rectangle_shouldBeRectangleOuput_true() {
    Rectangle testRectangle = new Rectangle(2,4);
    assertEquals(true, testRectangle instanceof Rectangle);
  }
  @Test
  public void getLength_getsRectangleLength_2() {
    Rectangle testRectangle = new Rectangle(2, 4);
    assertEquals(2, testRectangle.getLength());
  }

  @Test
  public void getWidth_getsRectangleWidth_2() {
    Rectangle testRectangle = new Rectangle(2, 4);
    assertEquals(4, testRectangle.getWidth());
  }
  @Test
  public void isSquare_whenNotASquare_false() {
    Rectangle testRectangle = new Rectangle(2, 4);
    assertEquals(false, testRectangle.isSquare());
  }
  @Test
  public void isSquare_whenASquare_true() {
    Rectangle testRectangle = new Rectangle(2, 2);
    assertEquals(true, testRectangle.isSquare());
  }
}
