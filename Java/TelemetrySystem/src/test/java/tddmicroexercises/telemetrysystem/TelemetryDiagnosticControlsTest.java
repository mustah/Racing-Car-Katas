package tddmicroexercises.telemetrysystem;

import org.junit.Test;

import tddmicroexercises.turnticketdispenser.TicketDispenser;
import tddmicroexercises.turnticketdispenser.TurnTicket;

import static org.junit.Assert.assertEquals;

public class TelemetryDiagnosticControlsTest {

  @Test
  public void NextSequence() {
    TurnTicket turnTicket = new TicketDispenser().getTurnTicket();
    assertEquals(0, turnTicket.getTurnNumber());
  }

  @Test
  public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() {
  }
}
