package tddmicroexercises.braking;

public final class BrakeStrategyFactory {

  private BrakeStrategyFactory() {
  }

  public static BrakingStrategy newBreakingStrategy(double velocity) {
    if (velocity < 60) {
      return new SteadyBrakingStrategy();
    } else if (velocity < 120) {
      return new IntervalBrakingStrategy();
    } else {
      return new FailingBrakingStrategy();
    }
  }
}
