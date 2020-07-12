package tddmicroexercises.tirepressuremonitoringsystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestAlarm {

    @Test
    public void alarm_should_be_instanciated_with_false_alarm() {
        // GIVEN WHEN
        Alarm alarm = new Alarm();

        // THEN
        assertEquals(false, alarm.isAlarmOn());
    }

    @Test
    public void check_should_popNextPressurePsiValue_and_set_alarm_to_true_when_pressure_lower_than_17() {
        // GIVEN
        var sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(Double.valueOf(11));
        var alarm = new Alarm(sensor);

        // WHEN
        alarm.check();

        // THEN
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void check_should_popNextPressurePsiValue_and_set_alarm_to_true_when_pressure_hiwer_than_21() {
        // GIVEN
        var sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(Double.valueOf(30));
        var alarm = new Alarm(sensor);

        // WHEN
        alarm.check();

        // THEN
        assertTrue(alarm.isAlarmOn());
    }
}
