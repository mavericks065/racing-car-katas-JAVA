package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls {
    private static final String DIAGNOSTIC_CHANNEL_CONNECTION_STRING = "*111#";

    private final Client telemetryClient;

    public TelemetryDiagnosticControls() {
        this(new TelemetryClient());
    }

    public TelemetryDiagnosticControls(Client client) {
        telemetryClient = client;
    }

    public TelemetryDiagnostic checkTransmission() throws Exception {
        telemetryClient.disconnect();

        int retryLeft = 3;
        while (!telemetryClient.getOnlineStatus() && retryLeft > 0) {
            telemetryClient.connect(DIAGNOSTIC_CHANNEL_CONNECTION_STRING);
            retryLeft -= 1;
        }

        if (!telemetryClient.getOnlineStatus()) {
            throw new Exception("Unable to connect.");
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        return new TelemetryDiagnostic(telemetryClient.receive());
    }
}
