package tddmicroexercises.tirepressuremonitoringsystem;

import java.util.Random;

class MockSensor implements Sensor {

  private static final double OFFSET = 16;

  @Override
  public double getPressurePsiValue() {
    return popNextPressurePsiValue();
  }

  private double popNextPressurePsiValue() {
    return OFFSET + samplePressure();
  }

  private static double samplePressure() {
    Random random = new Random(42);
    return 6 * random.nextDouble() * random.nextDouble();
  }
}
