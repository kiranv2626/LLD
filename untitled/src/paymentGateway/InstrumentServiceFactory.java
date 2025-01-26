package paymentGateway;

public class InstrumentServiceFactory {

InstrumentService getInstrumentService(InstrumentType instrumentType) {
    if (instrumentType == InstrumentType.BANK) {
        return new BankInstrumentService();
    } else if (instrumentType == InstrumentType.CREDIT_CARD) {
        return new CardInstrumentService();
    }
    return null;
}
}
