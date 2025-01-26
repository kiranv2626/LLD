package paymentGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankInstrumentService extends InstrumentService {

    @Override
    public instrumentDo addInstrument(instrumentDo instrument) {
        BankInstrument bankInstrument = new BankInstrument();
        bankInstrument.instrumentId=new Random().nextInt(100-10)+10;
        bankInstrument.userId=instrument.userId;
        bankInstrument.bankAcountNumber=instrument.bankAcountNumber;
        bankInstrument.IFSCCode=instrument.IFSCCode;
        bankInstrument.instrumentType=InstrumentType.BANK;

        List<Instrument> instrumentList=userVsInstrument.get(instrument.userId);
        if(instrumentList==null)
        {
            instrumentList=new ArrayList<>();
            userVsInstrument.put(instrument.userId,instrumentList);
        }
        instrumentList.add(bankInstrument);
        return convertInstrumentToDO(bankInstrument); //bankInstrument;
    }
    instrumentDo convertInstrumentToDO(BankInstrument bankInstrument) {
        instrumentDo instrumentDo=new instrumentDo();
        instrumentDo.instrumentId=bankInstrument.instrumentId;
        instrumentDo.userId=bankInstrument.userId;
        instrumentDo.bankAcountNumber=bankInstrument.bankAcountNumber;
        instrumentDo.IFSCCode=bankInstrument.IFSCCode;
        instrumentDo.instrumentType=bankInstrument.instrumentType;
        return instrumentDo;
    }


    @Override
    public List<instrumentDo> getInstrument(int userId) {
        List<Instrument> instrumentList=userVsInstrument.get(userId);
        List<instrumentDo> instrumentDoList=new ArrayList<>();
        for(Instrument instrument:instrumentList)
        {
            if(instrument.instrumentType==InstrumentType.BANK)
            instrumentDoList.add(convertInstrumentToDO((BankInstrument)instrument));
        }
        return instrumentDoList;
    }
}


