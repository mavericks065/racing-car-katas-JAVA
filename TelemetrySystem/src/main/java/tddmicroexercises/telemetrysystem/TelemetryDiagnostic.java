package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnostic {
    private final String diagnosticInfo;

    public TelemetryDiagnostic(){
        diagnosticInfo = "";
    }

    public TelemetryDiagnostic(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }
}
