package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TelemetryDiagnosticControlsTest {
    @Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        // GIVEN
        var telemetryClient = Mockito.mock(TelemetryClient.class);
        var telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient);
        when(telemetryClient.getOnlineStatus()).thenReturn(true);
        when(telemetryClient.receive()).thenReturn("it works");

        // WHEN
        telemetryDiagnosticControls.checkTransmission();

        // THEN
        assertEquals("it works", telemetryDiagnosticControls.getDiagnosticInfo());
        verify(telemetryClient, times(1)).send(TelemetryClient.DIAGNOSTIC_MESSAGE);
    }
}
