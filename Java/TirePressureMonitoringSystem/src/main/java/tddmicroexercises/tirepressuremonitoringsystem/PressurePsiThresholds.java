package tddmicroexercises.tirepressuremonitoringsystem;

public class PressurePsiThresholds {

  private static final double LOW_PRESSURE_THRESHOLD = 17;
  private static final double HIGH_PRESSURE_THRESHOLD = 21;

  public final double lowest;
  public final double highest;

  public PressurePsiThresholds(double lowest, double highest) {
    this.lowest = lowest;
    this.highest = highest;
  }

  public PressurePsiThresholds() {
    this(LOW_PRESSURE_THRESHOLD, HIGH_PRESSURE_THRESHOLD);
  }
}
