package tddmicroexercises.turnticketdispenser;

/**
 * The TicketDispenser class is designed to be used to manage a queuing system in a shop. There may be more than one
 * ticket dispenser but the same ticket should not be issued to two different customers.
 */
public class TicketDispenser {

  public TurnTicket getTurnTicket() {
    return new TurnTicket(TurnNumberSequence.getNextTurnNumber());
  }
}
