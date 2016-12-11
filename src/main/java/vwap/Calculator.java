package vwap;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * ProjectEuler
 * <p>
 * Created by chenxili on 08/12/2016.
 */
public class Calculator implements ICalculator {

    private Map<Instrument, ITwoWayPrice> mostRecentPrice = new EnumMap<>(Instrument.class);
    private Map<Instrument, Map<Market, ITwoWayPrice>> historicalMarketMap = new EnumMap<>(Instrument.class);

    public Calculator() {
        init();
    }

    private void init() {
        //initialise the market map to improve the performance
        for (Instrument instrument : Instrument.values()) {
            historicalMarketMap.put(instrument, new HashMap<>());
            mostRecentPrice.put(instrument, null);
        }
    }

    @Override
    public ITwoWayPrice applyMarketUpdate(final IMarketUpdate twoWayMarketPrice) {

        Market market = twoWayMarketPrice.getMarket();

        ITwoWayPrice twoWayPrice = twoWayMarketPrice.getTwoWayPrice();

        Instrument instrument = twoWayPrice.getInstrument();

        State state = twoWayPrice.getState();

        // assume only when state of a market update is FIRM, we update the two way price
        if (state.equals(State.FIRM)) {
            Map<Market, ITwoWayPrice> localMarketPrice = historicalMarketMap.get(instrument);

            localMarketPrice.put(market, twoWayPrice);

            historicalMarketMap.put(instrument, localMarketPrice);

            ITwoWayPrice updatedTwoWayPrice = updateInstrument(instrument, historicalMarketMap.get(instrument));

            mostRecentPrice.put(instrument, updatedTwoWayPrice);

            return updatedTwoWayPrice;
            
        } else {
            return mostRecentPrice.get(instrument);
        }
    }

    private ITwoWayPrice updateInstrument(Instrument instrument, Map<Market, ITwoWayPrice> marketTwoWayPriceMap) {

        double localBid = 0.0;
        double localOffer = 0.0;

        double localBidAmount = 0.0;
        double localOfferAmount = 0.0;

        for (ITwoWayPrice twoWayPrice : marketTwoWayPriceMap.values()) {
            localBidAmount = localBidAmount + twoWayPrice.getBidAmount();
            localOfferAmount = localOfferAmount + twoWayPrice.getOfferAmount();

            localBid = localBid + twoWayPrice.getBidAmount() * twoWayPrice.getBidPrice();
            localOffer = localOffer + twoWayPrice.getOfferAmount() * twoWayPrice.getOfferPrice();

        }

        double localBidPrice = localBid / localBidAmount;

        double localOfferPrice = localOffer / localOfferAmount;

        return new TwoWayPrice(instrument, State.FIRM, localBidPrice, localOfferPrice, localOfferAmount, localBidAmount);

    }
}
