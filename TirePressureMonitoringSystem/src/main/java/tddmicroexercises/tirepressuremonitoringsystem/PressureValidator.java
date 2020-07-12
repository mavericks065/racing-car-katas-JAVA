package tddmicroexercises.tirepressuremonitoringsystem;

public class PressureValidator {
    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;

    public static boolean isPressureOutOfThreshold(double psiPressure) {
        return psiPressure < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressure;
    }
}
