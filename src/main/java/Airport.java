
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Evgen on 17.05.2017.
 */
public class Airport {
    private String airportCode;
    private String cityOrAirportName;
    private String country;
    private String countryAbbrviation;
    private String countryCode;
    private String GMTOffset;
    private String runwayLengthFeet;
    private String latitudeDegree;
    private String latitudeMinute;
    private String latitudeSecond;
    private String latitudeNpeerS;
    private String longitudeDegree;
    private String longitudeMinute;
    private String longitudeSeconds;
    private String longitudeEperW;

    @XmlElement(name = "AirportCode")
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }
    @XmlElement(name = "CityOrAirportName")
    public void setCityOrAirportName(String cityOrAirportName) {
        this.cityOrAirportName = cityOrAirportName;
    }
    @XmlElement(name = "Country")
    public void setCountry(String country) {
        this.country = country;
    }
    @XmlElement(name = "CountryAbbrviation")
    public void setCountryAbbrviation(String countryAbbrviation) {
        this.countryAbbrviation = countryAbbrviation;
    }
    @XmlElement(name = "CountryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    @XmlElement(name = "GMTOffset")
    public void setGMTOffset(String GMTOffset) {
        this.GMTOffset = GMTOffset;
    }
    @XmlElement(name = "RunwayLengthFeet")
    public void setRunwayLengthFeet(String runwayLengthFeet) {
        this.runwayLengthFeet = runwayLengthFeet;
    }
    @XmlElement(name = "LatitudeDegree")
    public void setLatitudeDegree(String latitudeDegree) {
        this.latitudeDegree = latitudeDegree;
    }
    @XmlElement(name = "LatitudeMinute")
    public void setLatitudeMinute(String latitudeMinute) {
        this.latitudeMinute = latitudeMinute;
    }
    @XmlElement(name = "LatitudeSecond")
    public void setLatitudeSecond(String latitudeSecond) {
        this.latitudeSecond = latitudeSecond;
    }
    @XmlElement(name = "LatitudeNpeerS")
    public void setLatitudeNpeerS(String latitudeNpeerS) {
        this.latitudeNpeerS = latitudeNpeerS;
    }
    @XmlElement(name = "LongitudeDegree")
    public void setLongitudeDegree(String longitudeDegree) {
        this.longitudeDegree = longitudeDegree;
    }
    @XmlElement(name = "LongitudeMinute")
    public void setLongitudeMinute(String longitudeMinute) {
        this.longitudeMinute = longitudeMinute;
    }
    @XmlElement(name = "LongitudeSeconds")
    public void setLongitudeSeconds(String longitudeSeconds) {
        this.longitudeSeconds = longitudeSeconds;
    }
    @XmlElement(name = "LongitudeEperW")
    public void setLongitudeEperW(String longitudeEperW) {
        this.longitudeEperW = longitudeEperW;
    }

    public Airport(String airportCode, String cityOrAirportName, String country, String countryAbbrviation, String countryCode, String GMTOffset, String runwayLengthFeet, String latitudeDegree, String latitudeMinute, String latitudeSecond, String latitudeNpeerS, String longitudeDegree, String longitudeMinute, String longitudeSeconds, String longitudeEperW) {
        this.airportCode = airportCode;
        this.cityOrAirportName = cityOrAirportName;
        this.country = country;
        this.countryAbbrviation = countryAbbrviation;
        this.countryCode = countryCode;
        this.GMTOffset = GMTOffset;
        this.runwayLengthFeet = runwayLengthFeet;
        this.latitudeDegree = latitudeDegree;
        this.latitudeMinute = latitudeMinute;
        this.latitudeSecond = latitudeSecond;
        this.latitudeNpeerS = latitudeNpeerS;
        this.longitudeDegree = longitudeDegree;
        this.longitudeMinute = longitudeMinute;
        this.longitudeSeconds = longitudeSeconds;
        this.longitudeEperW = longitudeEperW;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airportCode='" + airportCode + '\'' +
                ", cityOrAirportName='" + cityOrAirportName + '\'' +
                ", country='" + country + '\'' +
                ", countryAbbrviation='" + countryAbbrviation + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", GMTOffset='" + GMTOffset + '\'' +
                ", runwayLengthFeet='" + runwayLengthFeet + '\'' +
                ", latitudeDegree='" + latitudeDegree + '\'' +
                ", latitudeMinute='" + latitudeMinute + '\'' +
                ", latitudeSecond='" + latitudeSecond + '\'' +
                ", latitudeNpeerS='" + latitudeNpeerS + '\'' +
                ", longitudeDegree='" + longitudeDegree + '\'' +
                ", longitudeMinute='" + longitudeMinute + '\'' +
                ", longitudeSeconds='" + longitudeSeconds + '\'' +
                ", longitudeEperW='" + longitudeEperW + '\'' +
                '}';
    }

    public String getAirportCode() {
        return airportCode;
    }

    public String getCityOrAirportName() {
        return cityOrAirportName;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryAbbrviation() {
        return countryAbbrviation;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getGMTOffset() {
        return GMTOffset;
    }

    public String getRunwayLengthFeet() {
        return runwayLengthFeet;
    }

    public String getLatitudeDegree() {
        return latitudeDegree;
    }

    public String getLatitudeMinute() {
        return latitudeMinute;
    }

    public String getLatitudeSecond() {
        return latitudeSecond;
    }

    public String getLatitudeNpeerS() {
        return latitudeNpeerS;
    }

    public String getLongitudeDegree() {
        return longitudeDegree;
    }

    public String getLongitudeMinute() {
        return longitudeMinute;
    }

    public String getLongitudeSeconds() {
        return longitudeSeconds;
    }

    public String getLongitudeEperW() {
        return longitudeEperW;
    }

    public Airport() {
    }
}

