package tddmicroexercises.braking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BrakeTest {

  @Test
  public void Power_Dissipation_For_Steady_Breaking() throws Exception {
    Brake brake = new Brake(new SteadyBrakingStrategy());
    assertEquals(330000.0, brake.powerDissipation(110), 0.1);
  }
}
