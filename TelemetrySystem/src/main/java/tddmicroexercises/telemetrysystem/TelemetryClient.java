package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TelemetryClient implements Client {

    private boolean onlineStatus;

    private Random connectionEventsSimulator;

    public TelemetryClient(Random connectionEventsSimulator) {
        this.connectionEventsSimulator = connectionEventsSimulator;
    }

    public boolean getOnlineStatus() {
        return onlineStatus;
    }

    public void connect(String telemetryServerConnectionString) {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString)) {
            throw new IllegalArgumentException();
        }

        // simulate the operation on a real modem
        boolean success = connectionEventsSimulator.nextInt(10) <= 8;

        onlineStatus = success;
    }

    public void disconnect() {
        onlineStatus = false;
    }
}

