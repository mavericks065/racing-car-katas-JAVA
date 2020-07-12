package tddmicroexercises.tirepressuremonitoringsystem;

import static tddmicroexercises.tirepressuremonitoringsystem.PressureValidator.isPressureOutOfThreshold;

public class Alarm {

    private Sensor sensor;
    private boolean alarmOn = false;

    public Alarm() {
        this.sensor = new TyreSensor();
    }

    public Alarm(final Sensor sensor) {
        this.sensor = sensor;
    }

    public void check() {
        var psiPressureValue = sensor.popNextPressurePsiValue();

        if (isPressureOutOfThreshold(psiPressureValue)) {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }
}
