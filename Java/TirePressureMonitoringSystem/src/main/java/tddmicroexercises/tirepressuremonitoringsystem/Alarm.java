package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {

  private final Sensor sensor;
  private final PressurePsiThresholds pressurePsiThresholds;

  private boolean alarmOn;

  public Alarm(Sensor sensor, PressurePsiThresholds pressurePsiThresholds) {
    this.sensor = sensor;
    this.pressurePsiThresholds = pressurePsiThresholds;
  }

  public Alarm(Sensor sensor) {
    this(sensor, new PressurePsiThresholds());
  }

  public void check() {
    if (pressurePsiThresholds.isOutOfRange(sensor.getPressurePsiValue())) {
      enableAlarm();
    } else {
      disableAlarm();
    }
  }

  public boolean isAlarmOn() {
    return alarmOn;
  }

  private void enableAlarm() {
    alarmOn = true;
  }

  private void disableAlarm() {
    alarmOn = false;
  }
}
