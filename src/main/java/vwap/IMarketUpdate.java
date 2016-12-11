package vwap;

/**
 * ProjectEuler
 * <p>
 * Created by chenxili on 08/12/2016.
 */
public interface IMarketUpdate {
    Market getMarket();
    ITwoWayPrice getTwoWayPrice();
}
