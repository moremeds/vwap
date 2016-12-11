package vwap;

import org.junit.Assert;
import org.junit.Test;

/**
 * ProjectEuler
 * <p>
 * Created by chenxili on 09/12/2016.
 */
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testSameInstrumentDifferentMarketUpdate() throws Exception {

        ITwoWayPrice twoWayPrice1 = new TwoWayPrice(Instrument.INSTRUMENT0, State.FIRM,
                0.6, 0.7, 1000, 1300);

        IMarketUpdate marketUpdate = new MarketUpdate(Market.MARKET1, twoWayPrice1);

        ITwoWayPrice price = calculator.applyMarketUpdate(marketUpdate);

        Assert.assertEquals("Bid Price is wrong for first update", 0.6, price.getBidPrice(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for first update", 0.7, price.getOfferPrice(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for first update", 1000, price.getOfferAmount(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for first update", 1300, price.getBidAmount(), 0.000001);
        Assert.assertEquals("Instrument is wrong", Instrument.INSTRUMENT0, price.getInstrument());


        ITwoWayPrice twoWayPrice2 = new TwoWayPrice(Instrument.INSTRUMENT0, State.FIRM,
                0.5, 0.9, 3000, 4300);

        IMarketUpdate marketUpdate2 = new MarketUpdate(Market.MARKET2, twoWayPrice2);

        ITwoWayPrice price2 = calculator.applyMarketUpdate(marketUpdate2);

        Assert.assertEquals("Bid Price is wrong for second update", 0.5232142, price2.getBidPrice(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for second update", 0.85, price2.getOfferPrice(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for second update", 4000, price2.getOfferAmount(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for second update", 5600, price2.getBidAmount(), 0.000001);
        Assert.assertEquals("Instrument is wrong", Instrument.INSTRUMENT0, price2.getInstrument());


        ITwoWayPrice twoWayPrice3 = new TwoWayPrice(Instrument.INSTRUMENT0, State.INDICATIVE,
                0.5, 0.9, 3000, 4300);

        IMarketUpdate marketUpdate3 = new MarketUpdate(Market.MARKET3, twoWayPrice3);

        ITwoWayPrice price3 = calculator.applyMarketUpdate(marketUpdate3);

        Assert.assertEquals("Bid Price is wrong for third update", 0.5232142, price3.getBidPrice(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for third update", 0.85, price3.getOfferPrice(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for third update", 4000, price3.getOfferAmount(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for third update", 5600, price3.getBidAmount(), 0.000001);
        Assert.assertEquals("Instrument is wrong", Instrument.INSTRUMENT0, price3.getInstrument());
    }

    @Test
    public void testDifferentInstrumentDifferentMarketUpdate() throws Exception {

        ITwoWayPrice twoWayPrice1 = new TwoWayPrice(Instrument.INSTRUMENT0, State.FIRM,
                0.6, 0.7, 1000, 1300);

        IMarketUpdate marketUpdate = new MarketUpdate(Market.MARKET1, twoWayPrice1);

        ITwoWayPrice price = calculator.applyMarketUpdate(marketUpdate);

        Assert.assertEquals("Bid Price is wrong for first update", 0.6, price.getBidPrice(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for first update", 0.7, price.getOfferPrice(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for first update", 1000, price.getOfferAmount(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for first update", 1300, price.getBidAmount(), 0.000001);
        Assert.assertEquals("Instrument is wrong", Instrument.INSTRUMENT0, price.getInstrument());


        ITwoWayPrice twoWayPrice2 = new TwoWayPrice(Instrument.INSTRUMENT1, State.FIRM,
                0.5, 0.9, 3000, 4300);

        IMarketUpdate marketUpdate2 = new MarketUpdate(Market.MARKET1, twoWayPrice2);

        ITwoWayPrice price2 = calculator.applyMarketUpdate(marketUpdate2);

        Assert.assertEquals("Bid Price is wrong for second update", 0.5, price2.getBidPrice(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for second update", 0.9, price2.getOfferPrice(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for second update", 3000, price2.getOfferAmount(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for second update", 4300, price2.getBidAmount(), 0.000001);
        Assert.assertEquals("Instrument is wrong", Instrument.INSTRUMENT1, price2.getInstrument());

    }

    @Test
    public void testSameInstrumentSameMarketUpdate() throws Exception {

        ITwoWayPrice twoWayPrice1 = new TwoWayPrice(Instrument.INSTRUMENT0, State.FIRM,
                0.6, 0.7, 1000, 1300);

        IMarketUpdate marketUpdate = new MarketUpdate(Market.MARKET1, twoWayPrice1);

        ITwoWayPrice price = calculator.applyMarketUpdate(marketUpdate);

        Assert.assertEquals("Bid Price is wrong for first update", 0.6, price.getBidPrice(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for first update", 0.7, price.getOfferPrice(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for first update", 1000, price.getOfferAmount(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for first update", 1300, price.getBidAmount(), 0.000001);
        Assert.assertEquals("Instrument is wrong", Instrument.INSTRUMENT0, price.getInstrument());


        ITwoWayPrice twoWayPrice2 = new TwoWayPrice(Instrument.INSTRUMENT0, State.FIRM,
                0.5, 0.9, 3000, 4300);

        IMarketUpdate marketUpdate2 = new MarketUpdate(Market.MARKET1, twoWayPrice2);

        ITwoWayPrice price2 = calculator.applyMarketUpdate(marketUpdate2);

        Assert.assertEquals("Bid Price is wrong for second update", 0.5, price2.getBidPrice(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for second update", 0.9, price2.getOfferPrice(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for second update", 3000, price2.getOfferAmount(), 0.000001);
        Assert.assertEquals("Offer Price is wrong for second update", 4300, price2.getBidAmount(), 0.000001);
        Assert.assertEquals("Instrument is wrong", Instrument.INSTRUMENT0, price2.getInstrument());

    }
}
