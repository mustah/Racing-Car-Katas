package tddmicroexercises.braking;

/**
 * This strategy simply puts the brakes on at full power. This
 * strategy is only appropriate at low speed.
 */
class SteadyBrakingStrategy implements BrakingStrategy {
  @Override
  public double powerDissipation(double velocity, Brake brake) {
    return brake.forceAtBrakeLevel(100.0) * velocity;
  }
}
