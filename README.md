# GetYahooWeatherAPI
A small Yahoo Weather API

How to use:

GetWeatherXML getWeatherXML = new GetWeatherXML("2972","c");

String temperature = getWeatherXML.getTemperature() + " " + getWeatherXML.getTemperatureUnit();

Note:
The GetWeatherXML will take 2 parameter, the first one is the WOEID code, which is a location code, you can find this code from
"http://woeid.rosselliot.co.nz/lookup". The second parameter is the unit, "c" for Celsius and "f" for Fehrenheit.
