package util;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by Evgen on 18.05.2017.
 */
public class RequestSender {
    private static SOAPConnection soapConnection;
    private static final String URL = "http://www.webservicex.net/airport.asmx";
    private static final String resultPath = "src/test/resources/requestResult.xml";

    public static SOAPMessage sendRequest(SOAPMessage message) throws Exception {
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        soapConnection = soapConnectionFactory.createConnection();
        SOAPMessage soapResponse = soapConnection.call(message, URL);
        printSOAPResponse(soapResponse);
        soapConnection.close();
        return soapResponse;
    }

    private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        StreamResult sr = new StreamResult(new File(resultPath));
        transformer.transform(sourceContent, sr);
    }
}
