package tddmicroexercises.telemetrysystem;

public interface Client {
    boolean getOnlineStatus();
    void connect(String telemetryServerConnectionString);
    void disconnect();
}
