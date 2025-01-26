package paymentGateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class InstrumentService {
    static Map<Integer, List<Instrument>> userVsInstrument = new HashMap<Integer, List<Instrument>>();
    public abstract instrumentDo addInstrument(instrumentDo instrument);
    public abstract List<instrumentDo> getInstrument(int userId);

}
