package soaptest.entity;

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

    @XmlElement
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    @XmlElement
    public void setCityOrAirportName(String cityOrAirportName) {
        this.cityOrAirportName = cityOrAirportName;
    }

    @XmlElement
    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement
    public void setCountryAbbrviation(String countryAbbrviation) {
        this.countryAbbrviation = countryAbbrviation;
    }

    @XmlElement
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @XmlElement
    public void setGMTOffset(String GMTOffset) {
        this.GMTOffset = GMTOffset;
    }

    @XmlElement
    public void setRunwayLengthFeet(String runwayLengthFeet) {
        this.runwayLengthFeet = runwayLengthFeet;
    }

    @XmlElement
    public void setLatitudeDegree(String latitudeDegree) {
        this.latitudeDegree = latitudeDegree;
    }

    @XmlElement
    public void setLatitudeMinute(String latitudeMinute) {
        this.latitudeMinute = latitudeMinute;
    }

    @XmlElement
    public void setLatitudeSecond(String latitudeSecond) {
        this.latitudeSecond = latitudeSecond;
    }

    @XmlElement
    public void setLatitudeNpeerS(String latitudeNpeerS) {
        this.latitudeNpeerS = latitudeNpeerS;
    }

    @XmlElement
    public void setLongitudeDegree(String longitudeDegree) {
        this.longitudeDegree = longitudeDegree;
    }

    @XmlElement
    public void setLongitudeMinute(String longitudeMinute) {
        this.longitudeMinute = longitudeMinute;
    }

    @XmlElement
    public void setLongitudeSeconds(String longitudeSeconds) {
        this.longitudeSeconds = longitudeSeconds;
    }

    @XmlElement
    public void setLongitudeEperW(String longitudeEperW) {
        this.longitudeEperW = longitudeEperW;
    }
}
