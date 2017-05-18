import org.testng.annotations.Test;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.*;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.RequestCreator;
import util.RequestSender;

/**
 * Created by Evgen on 17.05.2017.
 */


public class AirportServiceTest {
    private SOAPConnection soapConnection;
    private static final String URL = "http://www.webservicex.net/airport.asmx";

    @Test
    public void test() throws Exception {
        RequestSender.sendRequest(RequestCreator.getAirportInformationByCountry("Ukraine"));

    }

}
