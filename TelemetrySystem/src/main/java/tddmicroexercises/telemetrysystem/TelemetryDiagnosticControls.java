package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls {
    private static final String DIAGNOSTIC_CHANNEL_CONNECTION_STRING = "*111#";

    private final Client telemetryClient;
    private final Channel telemetryChannel;

    public TelemetryDiagnosticControls(Client client, Channel channel) {
        telemetryClient = client;
        telemetryChannel = channel;
    }

    public TelemetryDiagnostic checkTransmission() throws ConnectionException {
        telemetryClient.disconnect();

        int retryLeft = 3;
        while (!telemetryClient.getOnlineStatus() && retryLeft > 0) {
            telemetryClient.connect(DIAGNOSTIC_CHANNEL_CONNECTION_STRING);
            retryLeft -= 1;
        }

        if (!telemetryClient.getOnlineStatus()) {
            throw new ConnectionException("Unable to connect.");
        }

        telemetryChannel.send(TelemetryChannel.DIAGNOSTIC_MESSAGE);
        return new TelemetryDiagnostic(telemetryChannel.receive());
    }
}
