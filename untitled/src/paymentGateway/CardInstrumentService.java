package paymentGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardInstrumentService extends InstrumentService{
    @Override
    public instrumentDo addInstrument(instrumentDo instrument) {
        CardInstrument cardInstrument = new CardInstrument();
        cardInstrument.instrumentId=new Random().nextInt(100-10)+10;
        cardInstrument.userId=instrument.userId;
        cardInstrument.cardNumber=instrument.cardNumber;
        cardInstrument.cvv=instrument.cvv;
        cardInstrument.instrumentType=InstrumentType.CREDIT_CARD;

        List<Instrument> instrumentList=userVsInstrument.get(instrument.userId);
        if(instrumentList==null)
        {
            instrumentList=new ArrayList<>();
            userVsInstrument.put(instrument.userId,instrumentList);
        }
        instrumentList.add(cardInstrument);
        return convertInstrumentToDO(cardInstrument);
    }
   instrumentDo convertInstrumentToDO(CardInstrument cardInstrument)
   {
       instrumentDo instrumentDo=new instrumentDo();
       instrumentDo.instrumentId=cardInstrument.instrumentId;
       instrumentDo.userId=cardInstrument.userId;
       instrumentDo.cardNumber=cardInstrument.cardNumber;
       instrumentDo.cvv=cardInstrument.cvv;
       instrumentDo.instrumentType=cardInstrument.instrumentType;
       return instrumentDo;
   }
   @Override
    public List<instrumentDo> getInstrument(int userId) {
        List<Instrument> instrumentList=userVsInstrument.get(userId);
        List<instrumentDo> instrumentDoList=new ArrayList<>();
        for(Instrument instrument:instrumentList)
        {
            if(instrument.instrumentType==InstrumentType.CREDIT_CARD)
            instrumentDoList.add(convertInstrumentToDO((CardInstrument)instrument));
        }
        return instrumentDoList;
    }
}
