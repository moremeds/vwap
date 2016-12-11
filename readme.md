#Volume Weighted Average Price

The volume weighted average price (VWAP) is a trading benchmark used especially in pension plans. 
VWAP is calculated by adding up the dollars traded for every transaction (price multiplied by number of shares traded) 
and then dividing by the total shares traded for the day.

The VWAP two-way price for an instrument is defined as:

_Bid = Sum(Market Bid Price * Market Bid Amount)/ Sum(Market Bid Amount)_

_Offer = Sum(Market Offer Price * Market Offer Amount)/ Sum(Market Offer Amount)_

Whenever there is a update on market, the calculator will first determine what state of this update. 
If it is an INDICATIVE state, the calculator will ignore this update, and return the most recently updated price for this instrument. 

If the same market was updated, the newer version of the market price will override the older version, and return a newly-calculated price for this instrument. 

Different instruments' update will not influence each others pricing, and new market update will also update the price for this instrument. 

A simple unit test is created to cover the above use cases. 