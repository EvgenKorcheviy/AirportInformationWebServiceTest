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

/**
 * Created by Evgen on 17.05.2017.
 */

public class AirportServiceTest {
    private SOAPConnection soapConnection;
    private static final String URL = "http://www.webservicex.net/airport.asmx";


    @BeforeMethod
    public void before() throws SOAPException {
        //create SOAP connection
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        soapConnection = soapConnectionFactory.createConnection();
    }

    @AfterMethod
    public void after() throws SOAPException {
        //close SOAP connection
        soapConnection.close();
    }


    @Test
    public void test() throws Exception {
        SOAPMessage soapResponse = soapConnection.call(getAirportInformationByCountry(), URL);
        printSOAPResponse(soapResponse);
        File file = new File("src/test/resources/requestResult.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(CountryAirPorts.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        CountryAirPorts airPorts = (CountryAirPorts) jaxbUnmarshaller.unmarshal(file);
        System.out.println(airPorts);

    }

    //request for get airportinfo by country
    private static SOAPMessage getAirportInformationByCountry() throws SOAPException, IOException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        soapPart.setContent(new StreamSource(new FileInputStream("src/test/resources/request.xml")));

        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", "http://www.webserviceX.NET/GetAirportInformationByCountry");
        soapMessage.saveChanges();
        return soapMessage;
    }

    //print response
    private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        StreamResult sr = new StreamResult(new File("src/test/resources/requestResult.xml"));
        transformer.transform(sourceContent, sr);
    }
}
