package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TelemetryDiagnosticControlsTest {
    @Test
    public void checkTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        // GIVEN
        var telemetryClient = mock(Client.class);
        var telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient);
        when(telemetryClient.getOnlineStatus()).thenReturn(true);
        when(telemetryClient.receive()).thenReturn("it works");

        // WHEN
        telemetryDiagnosticControls.checkTransmission();

        // THEN
        assertEquals("it works", telemetryDiagnosticControls.getDiagnosticInfo());
        verify(telemetryClient, times(1)).send(TelemetryClient.DIAGNOSTIC_MESSAGE);
    }

    @Test
    public void checkTransmission_should_disconnect_and_if_online_status_is_false_reconnect() throws Exception {
        // GIVEN
        var telemetryClient = mock(Client.class);
        var telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient);

        doReturn(false).doReturn(true).when(telemetryClient).getOnlineStatus();
        when(telemetryClient.receive()).thenReturn("it works");

        // WHEN
        telemetryDiagnosticControls.checkTransmission();

        // THEN
        assertEquals("it works", telemetryDiagnosticControls.getDiagnosticInfo());
        verify(telemetryClient, times(1)).disconnect();
        verify(telemetryClient, times(1)).connect("*111#");
    }

    @Test
    public void checkTransmission_should_throw_an_exception_if_cannot_reconnect_but_try_3_times() throws Exception {
        // GIVEN
        var telemetryClient = mock(Client.class);
        var telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient);

        when(telemetryClient.getOnlineStatus()).thenReturn(false);

        // WHEN
        var thrown = Assertions.assertThrows(Exception.class, () -> telemetryDiagnosticControls.checkTransmission());

        // THEN
        Assertions.assertEquals("Unable to connect.", thrown.getMessage());
        verify(telemetryClient, times(3)).connect("*111#");
    }
}
