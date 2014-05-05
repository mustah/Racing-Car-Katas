package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {

  private static final double LOW_PRESSURE_THRESHOLD = 17;
  private static final double HIGH_PRESSURE_THRESHOLD = 21;

  private final Sensor sensor;

  boolean alarmOn = false;

  public Alarm(Sensor sensor) {
    this.sensor = sensor;
  }

  public void check() {
    double psiPressureValue = sensor.getPressurePsiValue();
    if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue) {
      enableAlarm();
    }
  }

  public boolean isAlarmOn() {
    return alarmOn;
  }

  private void enableAlarm() {
    alarmOn = true;
  }
}
