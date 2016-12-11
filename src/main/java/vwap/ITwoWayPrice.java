package vwap;

/**
 * ProjectEuler
 * <p>
 * Created by chenxili on 08/12/2016.
 */
public interface ITwoWayPrice {
    Instrument getInstrument();

    State getState();

    double getBidPrice();

    double getOfferAmount();

    double getOfferPrice();

    double getBidAmount();
}
