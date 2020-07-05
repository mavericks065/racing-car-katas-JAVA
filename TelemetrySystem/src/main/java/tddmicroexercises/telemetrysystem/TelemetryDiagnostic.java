package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnostic {
    private String diagnosticInfo;

    public TelemetryDiagnostic(){
        diagnosticInfo = "";
    }

    public TelemetryDiagnostic(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }
}
