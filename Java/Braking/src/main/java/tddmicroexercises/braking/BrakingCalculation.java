package tddmicroexercises.braking;

public final class BrakingCalculation {

  private static final double ONE_TENTH_OF_A_SECOND = .1;

  private BrakingCalculation() {
  }

  public static double calculateKineticEnergy(double velocity, double mass) {
    return mass * velocity * velocity / 2;
  }

  public static double calculateVelocity(double energy, double mass) {
    return Math.sqrt(2 * energy / mass);
  }

  public static double calculateStoppingDistance(double velocity, double mass, Brake brake) {
    double distance = 0;
    while (velocity > 0) {
      double updatedVelocity = updatedVelocity(velocity, mass, brake);
      if (updatedVelocity < 0) {
        updatedVelocity = 0;
      }
      distance += (velocity + updatedVelocity) / 2 * ONE_TENTH_OF_A_SECOND;
      velocity = updatedVelocity;
    }
    return distance;
  }

  public static double updatedVelocity(double velocity, double mass, Brake brake) {
    double currentKineticEnergy = calculateKineticEnergy(velocity, mass) - brake.powerDissipation(velocity);
    if (currentKineticEnergy < 0) {
      return 0;
    } else {
      return calculateVelocity(currentKineticEnergy, mass);
    }
  }
}

