package tddmicroexercises.braking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BrakingCalculationTest {

  private static final double DELTA = 0.1;

  @Test
  public void Kinetic_Energy() {
    assertEquals(4235000, BrakingCalculation.calculateKineticEnergy(110.0, 700.0), DELTA);
  }

  @Test
  public void speed() {
    assertEquals(110.0, BrakingCalculation.calculateVelocity(4235000.0, 700.0), DELTA);
  }

  @Test
  public void stopping_distance_with_zero_speed() {
    assertEquals(0.0, BrakingCalculation.calculateStoppingDistance(0.0, 700.0, new Brake()), DELTA);
  }

  @Test
  public void stopping_distance_with_speed() {
    assertEquals(1.2, BrakingCalculation.calculateStoppingDistance(12.0, 700.0, new Brake()), DELTA);
  }

  @Test
  public void update_velocity() {
    assertEquals(45.5, BrakingCalculation.updatedVelocity(50, 700.0, new Brake()), DELTA);
  }

  @Test
  public void Given_Negative_Velocity_Then_Updated_Velocity_Should_Be_Positive_Velocity() {
    assertEquals(3.09, BrakingCalculation.updatedVelocity(-1.0, 700.0, new Brake()), DELTA);
  }
}
