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

  @Test
  public void Alarm_Is_On_When_Psi_Pressure_Value_Is_Above_Highest_Threshold() {
    checkAlarmIsOnForPressurePsiValues(22, 23, 100);
  }

  @Test
  public void Alarm_Is_Off_When_Psi_Pressure_Value_Is_Between_Thresholds() {
    checkAlarmIsOffForPressurePsiValues(18, 19, 20, 21);
  }

  @Test
  public void Alarm_Is_On_Given_New_Low_And_High_Thresholds() {
    MockPressurePsiValueSensor sensor = new MockPressurePsiValueSensor();
    sensor.setPressurePsiValue(11);
    Alarm alarm = new Alarm(sensor, new PressurePsiThresholds(10, 15));
    checkAlarmIsOff(alarm);
  }

  @Test
  public void When_Alarm_Has_Been_Enabled_It_Should_Be_Possible_To_Disable_It_Again_By_Adjusting_Pressure() {
    MockPressurePsiValueSensor sensor = new MockPressurePsiValueSensor();
    Alarm alarm = new Alarm(sensor);

    sensor.setPressurePsiValue(0);
    checkAlarmIsOn(alarm);

    sensor.setPressurePsiValue(19);
    checkAlarmIsOff(alarm);
  }

  private void checkAlarmIsOnForPressurePsiValues(int... pressurePsiValues) {
    checkAlarmForPressurePsiValues(new AlarmChecker() {
      @Override
      public void check(Alarm alarm) {
        checkAlarmIsOn(alarm);
      }
    }, pressurePsiValues);
  }

  private void checkAlarmIsOffForPressurePsiValues(int... pressurePsiValues) {
    checkAlarmForPressurePsiValues(new AlarmChecker() {
      @Override
      public void check(Alarm alarm) {
        checkAlarmIsOff(alarm);
      }
    }, pressurePsiValues);
  }

  private void checkAlarmForPressurePsiValues(AlarmChecker alarmChecker, int... pressurePsiValues) {
    MockPressurePsiValueSensor sensor = new MockPressurePsiValueSensor();
    Alarm alarm = new Alarm(sensor);
    for (int ppv : pressurePsiValues) {
      sensor.setPressurePsiValue(ppv);
      alarmChecker.check(alarm);
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

  private static interface AlarmChecker {
    void check(Alarm alarm);
  }

  private static class MockPressurePsiValueSensor implements Sensor {

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
