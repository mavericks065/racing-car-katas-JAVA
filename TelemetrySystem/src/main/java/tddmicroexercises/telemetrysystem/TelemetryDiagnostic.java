package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnostic {
    private String diagnosticInfo = "";

    public TelemetryDiagnostic(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }
}
