package paymentGateway;

import java.util.ArrayList;
import java.util.List;

public class InstrumentController {
    InstrumentServiceFactory instrumentServiceFactory;

    public InstrumentController(InstrumentServiceFactory instrumentServiceFactory) {
        this.instrumentServiceFactory = instrumentServiceFactory;
    }

    public List<instrumentDo> getInstrument(int userId, InstrumentType instrumentType) {
        InstrumentService instrumentService = instrumentServiceFactory.getInstrumentService(instrumentType);
        return instrumentService.getInstrument(userId);
    }

    public instrumentDo addInstrument(instrumentDo instrument) {
        InstrumentService instrumentService = instrumentServiceFactory.getInstrumentService(instrument.instrumentType);
        return instrumentService.addInstrument(instrument);
    }

    public List<instrumentDo> getInstrument(int userId) {
        List<instrumentDo> bankInstrumentList=getInstrument(userId,InstrumentType.BANK);
        List<instrumentDo> cardInstrumentList=getInstrument(userId,InstrumentType.CREDIT_CARD);
        List<instrumentDo> all=new ArrayList<>();
        all.addAll(bankInstrumentList);
        all.addAll(cardInstrumentList);
        return all;
    }

    public instrumentDo getInstrumentById(int userId,int instrumentId) {
        List<instrumentDo> instrumentList=getInstrument(userId);
        for(instrumentDo instrumentDo:instrumentList)
        {
            if(instrumentDo.instrumentId==instrumentId)
            {
                return instrumentDo;
            }
        }
        return null;
    }






}
