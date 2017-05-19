
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.soap.*;

import util.RequestCreator;
import util.RequestSender;

/**
 * Created by Evgen on 17.05.2017.
 */


public class AirportServiceTest {
    private SOAPConnection soapConnection;
    private static final String URL = "http://www.webservicex.net/airport.asmx";

    private static final String COUNTRY = "Ukraine";
    private static final String AIRPORT_CODE = "LWO";
    private static final String CITYNAME_AND_AIRPORTNAME = "LVOV SNILOW";
    private static final String COUNTRY_CODE = "UA";


    @Test
    public void functionalityGetAirportInformationByCountryTest() throws Exception {
        RequestSender.sendRequest(RequestCreator.getAirportInformationByCountry(COUNTRY));
        RequestResult airports = AirportFactory.createResult();
        Assert.assertTrue(airports.isAirportsFromSameCountry(COUNTRY), "Airport not from this country");
    }

    @Test
    public void functionalityGetAirportInformationByAirportCodeTest() throws Exception {
        RequestSender.sendRequest(RequestCreator.getAirportInformationByAirportCode(AIRPORT_CODE));
        RequestResult airports = AirportFactory.createResult();
        Assert.assertTrue(airports.isAirportWithCorrectCode(AIRPORT_CODE),
                "There are 2 airports with the same code or airport with not correct code");
    }

    @Test
    public void functionalityGetAirportInformationByCityOrAirportNameTest() throws Exception {
        RequestSender.sendRequest(RequestCreator.getAirportInformationByCityOrAirportName(CITYNAME_AND_AIRPORTNAME));
        RequestResult airports = AirportFactory.createResult();
        Assert.assertTrue(airports.isAirportWithCorrectNameAndCity(CITYNAME_AND_AIRPORTNAME),
                "There are 2 airports with the same city and name or airport with not correct city and name");
    }

    @Test
    public void functionalityGetAirportInformationByISOCountryCodeTest() throws Exception {
        RequestSender.sendRequest(RequestCreator.getAirportInformationByISOCountryCode(COUNTRY_CODE));
        RequestResult airports = AirportFactory.createResult();
        Assert.assertTrue(airports.isAirportsWithTheSameCountryCode(COUNTRY_CODE),
                "Airport without this code");
    }

    @Test
    public void reliabilityTest() throws Exception {
        RequestSender.sendRequest(RequestCreator.createWrongMessage());
        String result = RequestResult.requestResultText();
        Assert.assertTrue(result.contains("Exception"));
    }
}
