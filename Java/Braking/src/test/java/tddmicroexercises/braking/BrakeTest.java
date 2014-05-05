package tddmicroexercises.braking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BrakeTest {

  private static final double DELTA = 0.1;

  @Test
  public void Power_Dissipation_When_Negative_Velocity() {
    assertEquals(-3000.0, new Brake().powerDissipation(-1), DELTA);
  }

  @Test
  public void Power_Dissipation_When_No_Velocity() {
    assertEquals(0.0, new Brake().powerDissipation(0), DELTA);
  }

  @Test
  public void Power_Dissipation_For_Steady_Braking() throws Exception {
    assertEquals(3000.0, new Brake().powerDissipation(1), DELTA);
    assertEquals(177000.0, new Brake().powerDissipation(59), DELTA);
  }

  @Test
  public void Power_Dissipation_For_Internal_Braking() throws Exception {
    assertEquals(238000.0, new Brake().powerDissipation(119), DELTA);
  }

  @Test
  public void Power_Dissipation_For_Failing_Braking() {
    assertEquals(280800.0, new Brake().powerDissipation(120), DELTA);
  }
}
