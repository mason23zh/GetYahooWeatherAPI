package Main_Package;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by Zhengyag's PC on 2016/3/2.
 */
public class GetWeatherXML {

    //base url
    private String url = "http://weather.yahooapis.com/forecastrss";
    //WOEID parameter
    private String wParameter;
    //Unit parameter
    private String uParameter;
    //Full request url
    private String fullUrl;

    //Weather XML Elements
    //<yweahter:location>
    private String city;
    private String region;
    private String country;
    //<yweahter:units>
    private String temperatureUnit;
    private String distanceUnit;
    private String pressureUnit;
    private String speedUnit;
    //<yweather:wind>
    private String chill;
    private String direction;
    private String speedWind;
    //<yweather:atosphere>
    private String humidity;
    private String visibility;
    private String pressureAtmosphere;
    private String rising;
    //<yweather:astronomy>
    private String sunrise;
    private String sunset;
    //<geoLocation>
    private String latitudes;
    private String longitudes;
    //<yWeather:codition>
    private String textCondition;
    private String code;
    private String temp;
    private String date;





    public GetWeatherXML(String wParameter, String uParameter) {
        this.uParameter = uParameter;
        this.wParameter = wParameter;
        fullUrl = "http://weather.yahooapis.com/forecastrss" + "?" + "w="+wParameter
                + "&" + "u="+uParameter;

        ParseWeatherXML(getDocConnect());

    }


    /**
     * The getDocConnect method will take a url
     * use DocumentBuilder to return a doc object
     * @return doc object
     */
    public Document getDocConnect() {
        Document doc = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(fullUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    /**
     * The ParseWeatherXML method will take a Doc object
     * and use doc.getElementsByTagName to get correspond NodeList
     * in order to get correct Element
     * @param doc object
     */
    public void ParseWeatherXML(Document doc) {

        NodeList channelList = doc.getElementsByTagName("channel");
        Node channelNode = channelList.item(0);

        if(channelNode.getNodeType()==Node.ELEMENT_NODE) {
            Element channelElement = (Element) channelNode;
            //Get location
            NodeList locationList = channelElement.getElementsByTagName("yweather:location");
            Node locationNode = locationList.item(0);
            if (locationNode.getNodeType() == Node.ELEMENT_NODE) {
                Element locationElement = (Element)locationNode;
                city = locationElement.getAttribute("city");
                region = locationElement.getAttribute("region");
                country = locationElement.getAttribute("country");
            }
            //Get <yweather:units>
            NodeList unitsList = channelElement.getElementsByTagName("yweather:units");
            Node unitsNode = unitsList.item(0);
            if (unitsNode.getNodeType() == Node.ELEMENT_NODE) {
                Element unitsElement = (Element)unitsNode;
                temperatureUnit = unitsElement.getAttribute("temperature");
                distanceUnit = unitsElement.getAttribute("distance");
                pressureUnit = unitsElement.getAttribute("pressure");
                speedUnit = unitsElement.getAttribute("speed");
            }
            //Get <yweather:wind>
            NodeList windList = channelElement.getElementsByTagName("yweather:wind");
            Node windNode = windList.item(0);
            if (windNode.getNodeType() == Node.ELEMENT_NODE) {
                Element windElement = (Element)windNode;
                chill = windElement.getAttribute("chill");
                direction = windElement.getAttribute("direction");
                speedWind = windElement.getAttribute("speed");
            }
            //Get <yweather:atmosphere>
            NodeList atmosphereList = channelElement.getElementsByTagName("yweather:atmosphere");
            Node atmosphereNode = atmosphereList.item(0);
            if (atmosphereNode.getNodeType() == Node.ELEMENT_NODE) {
                Element atmosphereElement = (Element)atmosphereNode;
                humidity = atmosphereElement.getAttribute("humidity");
                visibility = atmosphereElement.getAttribute("visibility");
                pressureAtmosphere = atmosphereElement.getAttribute("pressure");
                rising = atmosphereElement.getAttribute("rising");
            }
            //Get <yweather:astronomy> sunrise || sunset
            NodeList astronomyList = channelElement.getElementsByTagName("yweather:astronomy");
            Node astronomyNode = astronomyList.item(0);
            if (astronomyNode.getNodeType() == Node.ELEMENT_NODE) {
                Element astronomyElement = (Element)astronomyNode;
                sunrise = astronomyElement.getAttribute("sunrise");
                sunset = astronomyElement.getAttribute("sunset");
            }
            //Get <geo:lat>
            NodeList latList = channelElement.getElementsByTagName("geo:lat");
            Node latNode = latList.item(0);
            if (latNode.getNodeType() == Node.ELEMENT_NODE) {
                Element latElement = (Element) latNode;
                latitudes = latElement.getTextContent();
            }
            //Get <get:long>
            NodeList longList = channelElement.getElementsByTagName("geo:long");
            Node longNode = longList.item(0);
            if (longNode.getNodeType() == Node.ELEMENT_NODE) {
                Element longElement = (Element) longNode;
                longitudes = longElement.getTextContent();
            }
            //Get <yweather:condition>
            NodeList conditionList = channelElement.getElementsByTagName("yweather:condition");
            Node conditionNode = conditionList.item(0);
            if (conditionNode.getNodeType() == Node.ELEMENT_NODE) {
                Element conditionElement = (Element)conditionNode;
                textCondition = conditionElement.getAttribute("text");
                code = conditionElement.getAttribute("code");
                temp = conditionElement.getAttribute("temp");
                date = conditionElement.getAttribute("date");
            }
        }
    }

    public String getUrl() {
        return fullUrl;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public String getPressureUnit() {
        return pressureUnit;
    }

    public String getSpeedUnit() {
        return speedUnit;
    }

    public String getWindChill() {
        return chill;
    }

    public String getWindDirection() {
        return direction;
    }

    public String getWindSpeed() {
        return speedWind;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getPresure() {
        return pressureAtmosphere;
    }

    public String getRising() {
        return rising;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public String getTextCondition() {
        return textCondition;
    }

    public String getConditionCode() {
        return code;
    }

    public String getTemperature() {
        return temp;
    }

    public String getLatitudes() {
        return latitudes;
    }

    public String getLongitudes() {
        return longitudes;
    }

    public String getDate() {
        return date;
    }







}
