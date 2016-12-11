package vwap;

/**
 * ProjectEuler
 * <p>
 * Created by chenxili on 08/12/2016.
 */
public class MarketUpdate implements IMarketUpdate {

    private Market market;
    private ITwoWayPrice twoWayPrice;

    public MarketUpdate(Market market, ITwoWayPrice twoWayPrice) {
        this.market = market;
        this.twoWayPrice = twoWayPrice;
    }

    @Override
    public Market getMarket() {
        return market;
    }

    @Override
    public ITwoWayPrice getTwoWayPrice() {
        return twoWayPrice;
    }
}
