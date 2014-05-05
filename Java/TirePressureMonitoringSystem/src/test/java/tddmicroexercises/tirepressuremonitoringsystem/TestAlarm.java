package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestAlarm {

  @Test
  public void Alarm_Is_Off_By_Default() {
    Alarm alarm = new Alarm(new MockSensor());
    checkAlarmIsOff(alarm);
  }

  @Test
  public void Alarm_Is_On_When_Psi_Pressure_Value_Is_Below_Lowest_Threshold() {
    checkAlarmIsOnForPressurePsiValues(0, 1, 3, 16);
  }

  private void checkAlarmIsOnForPressurePsiValues(int... pressurePsiValues) {
    LowPressurePsiValueSensor sensor = new LowPressurePsiValueSensor();
    Alarm alarm = new Alarm(sensor);
    for (int ppv : pressurePsiValues) {
      sensor.setPressurePsiValue(ppv);
      checkAlarmIsOn(alarm);
    }
  }

  private void checkAlarmIsOff(Alarm alarm) {
    alarm.check();
    assertFalse(alarm.isAlarmOn());
  }

  private void checkAlarmIsOn(Alarm alarm) {
    alarm.check();
    assertTrue(alarm.isAlarmOn());
  }

  private static class LowPressurePsiValueSensor implements Sensor {

    private int pressurePsiValue;

    public void setPressurePsiValue(int pressurePsiValue) {
      this.pressurePsiValue = pressurePsiValue;
    }

    @Override
    public double getPressurePsiValue() {
      return pressurePsiValue;
    }
  }
}
