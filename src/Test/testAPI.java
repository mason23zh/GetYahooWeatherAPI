package Test;

import Main_Package.GetWeatherXML;

/**
 * Created by Zhengyag's PC on 2016/3/4.
 */
public class testAPI {
    public static void main(String[] args) {
        GetWeatherXML getWeatherXML = new GetWeatherXML("2972", "c");
        System.out.println("City:" + getWeatherXML.getCity());
        System.out.println("Region:" + getWeatherXML.getRegion());
        System.out.println("Country:" + getWeatherXML.getCountry());
        System.out.println("Temperature Unit:" + getWeatherXML.getTemperatureUnit());
        System.out.println("distance Unit:" + getWeatherXML.getDistanceUnit());
        System.out.println("Pressure Unit:" + getWeatherXML.getPressureUnit());
        System.out.println("Wind Chill:" + getWeatherXML.getWindChill());
        System.out.println("Wind Direction:" + getWeatherXML.getWindDirection());
        System.out.println("Wind speed:" + getWeatherXML.getWindSpeed());
        System.out.println("Humidity:" + getWeatherXML.getHumidity());
        System.out.println("Visibility:" + getWeatherXML.getVisibility());
        System.out.println("Pressure:" + getWeatherXML.getPresure());
        System.out.println("Rising:" + getWeatherXML.getRising());
        System.out.println("Sunrise:" + getWeatherXML.getSunrise());
        System.out.println("Sunset:" + getWeatherXML.getSunset());
        System.out.println("Latitude:" + getWeatherXML.getLatitudes());
        System.out.println("Longitude:" + getWeatherXML.getLongitudes());
        System.out.println("Condition:" + getWeatherXML.getTextCondition());
        System.out.println("Condition Code:" + getWeatherXML.getConditionCode());
        System.out.println("Temperature:" + getWeatherXML.getTemperature());
        System.out.println("Date:" + getWeatherXML.getDate());

    }
}
