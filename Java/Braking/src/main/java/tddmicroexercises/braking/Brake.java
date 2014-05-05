package tddmicroexercises.braking;

public class Brake {

  private BrakingStrategy breakStrategy;

  private double peakForce = 30;

  public Brake(BrakingStrategy breakStrategy) {
    this.breakStrategy = breakStrategy;
  }

  public double getPeakForce() {
    return peakForce;
  }

  public void setPeakForce(double peakForce) {
    this.peakForce = peakForce;
  }

  public double powerDissipation(double velocity) {
    breakStrategy = newBreakStrategy(velocity);
    return breakStrategy.powerDissipation(velocity, this);
  }

  public double forceAtBrakeLevel(double percentOfPeakForce) {
    return this.peakForce * percentOfPeakForce;
  }

  private BrakingStrategy newBreakStrategy(double velocity) {
    if (breakStrategy == null) {
      if (velocity < 60) {
        return new SteadyBrakingStrategy();
      } else if (velocity < 120) {
        return new IntervalBrakingStrategy();
      } else {
        return new FailingBrakingStrategy();
      }
    }
    return breakStrategy;
  }
}
