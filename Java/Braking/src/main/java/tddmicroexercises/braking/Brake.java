package tddmicroexercises.braking;

public class Brake {

  private double peakForce = 30;

  public double getPeakForce() {
    return peakForce;
  }

  public void setPeakForce(double peakForce) {
    this.peakForce = peakForce;
  }

  public double powerDissipation(double velocity) {
    return BrakeStrategyFactory.newBreakingStrategy(velocity).powerDissipation(velocity, this);
  }

  public double forceAtBrakeLevel(double percentOfPeakForce) {
    return this.peakForce * percentOfPeakForce;
  }
}
