
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
