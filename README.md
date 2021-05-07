# CandleStick
Compare candle stick and trade data

# Introduction
This tool is to verify the consistency between Candle Stick and Trade from Crypto.com open API.
User can input various paramters to do comparison on different Time Period and Instrument.

# Methodology
1) Get candle stick data and trade data by REST API 
2) The data are stored in ascending order. 
For CandleSticks, it is just sorted by time
For Trades, it is sorted ascending by timestamp and tradeId
3) For each candle stick (from latest to oldest), get all the related trades with respective to the input time frame.
In the meantime, it will determine if completeness of the trades with the time frame. It is determined by checking the maximum/minimum timestamp of all the trades with the input time period.
4) If all the trades within the period can be collected, calculate the open/close/high/low prices and volume of the candle stick and compare to the one captured from crypto.com

# Application Design
App.class is the main class
the parameters instrument name and time frame are in AppBean.

There are mainly three types of classes
1) data storage: DataContainer
- it is a singleton class
- it stores the candle sticks data and trades data captured
- both candle sticks and trades data are stored in TreeSet in ascedning order by timestamp / trade id. the sorting is implementing inside compareTo() for both CandleStick and Trade respectively. 
- it also outputs the required data within the specific period for verification thread

2) data capture: GetCandleStickDataService and GetTradeStickDataService
- both of it implements the abstract class AbstractGetDataService
- Both use GET request to get candle sticks data and trades data 
- AbstractGetDataService is generalized to do the connection logic for both child classes
- GetCandleStickDataService/GetTradeStickDataService implements the data parsing on its received data and store it to data storage via DataContainer

3) consistency checking: VerifyCandleStickService
- it will loop through all the candle sticks data which exists in the data storage
- for each candle stick, it will get the corresponding trades using its candlestick time and the time frame parameters
- this thread will deduce the candle stick from the trades and compare if the deduced one is the same as the one captured from the endpoint

# Development Tools
- jdk-11.0.11_windows-x64_bin
- apache-maven-3.8.1-bin
- eclipse-java-2021-03-R-win32-x86_64

# Limitation
Each time only able to verify one instrument
Only able to get last 200 trades on each instrument

# How to run it
Amend the parameters in the main class inside App.java and execute it

# One suspected issue
"t" should be the starting time for the candle stick but not the end time stated in the API reference document.

Below is the data get from https://api.crypto.com/v2/
If the timestamp of candle stick is the end time, the closing price should be 49827.20. 
So the timestamp should mean the start time of the candle stick. That can explain the open price is 49847.90

public/get-candlestick
{"t":1619278800000,"o":49847.9,"h":49903.7,"l":49782.42,"c":49903.7,"v":4.895515}
public/get-trades
{"dataTime":1619278802171,"d":1390562843781966944,"s":"SELL","p":49811.88,"q":0.000001,"t":1619278802170,"i":"BTC_USDT"},
{"dataTime":1619278800200,"d":1390562777672201888,"s":"SELL","p":49847.90,"q":0.046200,"t":1619278800200,"i":"BTC_USDT"},
{"dataTime":1619278800107,"d":1390562774538147968,"s":"SELL","p":49847.90,"q":0.000271,"t":1619278800107,"i":"BTC_USDT"},
{"dataTime":1619278793815,"d":1390562563381729856,"s":"SELL","p":49827.20,"q":0.017184,"t":1619278793814,"i":"BTC_USDT"},

