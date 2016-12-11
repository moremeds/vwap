package vwap;

/**
 * ProjectEuler
 * <p>
 * Created by chenxili on 08/12/2016.
 */
public class TwoWayPrice implements ITwoWayPrice {

    private Instrument instrument;
    private State state;
    private double bidPrice;
    private double offerPrice;
    private double offerAmount;
    private double bidAmount;

    public TwoWayPrice(Instrument instrument, State state, double bidPrice, double offerPrice, double offerAmount, double bidAmount) {
        this.instrument = instrument;
        this.state = state;
        this.bidPrice = bidPrice;
        this.offerPrice = offerPrice;
        this.offerAmount = offerAmount;
        this.bidAmount = bidAmount;
    }

    @Override
    public Instrument getInstrument() {
        return instrument;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public double getBidPrice() {
        return bidPrice;
    }

    @Override
    public double getOfferPrice() {
        return offerPrice;
    }

    @Override
    public double getOfferAmount() {
        return offerAmount;
    }

    @Override
    public double getBidAmount() {
        return bidAmount;
    }
}
