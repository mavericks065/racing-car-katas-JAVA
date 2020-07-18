package tddmicroexercises.telemetrysystem;

public interface Channel {
    String DIAGNOSTIC_MESSAGE = "AT#UD";
    String receive();
    void send(String message);
}
