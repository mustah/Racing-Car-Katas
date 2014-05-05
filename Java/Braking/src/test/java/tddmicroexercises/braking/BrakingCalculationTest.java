package tddmicroexercises.braking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BrakingCalculationTest {

  @Test
  public void Kinetic_Energy() {
    assertEquals(4235000, BrakingCalculation.calculateKineticEnergy(110.0, 700.0), 0.1);
  }

  @Test
  public void speed() {
    assertEquals(110.0, BrakingCalculation.calculateVelocity(4235000.0, 700.0), 0.1);
  }

  @Test
  public void stopping_distance_with_zero_speed() {
    assertEquals(0.0, BrakingCalculation.calculateStoppingDistance(0.0, 700.0, new Brake(new FailingBrakingStrategy())), 0.1);
  }

  @Test
  public void update_velocity() {
    assertEquals(45.5, BrakingCalculation.updatedVelocity(50, 700.0, new Brake(new SteadyBrakingStrategy())), 0.1);
  }
}
