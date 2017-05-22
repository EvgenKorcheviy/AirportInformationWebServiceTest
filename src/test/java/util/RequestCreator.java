package util;

import javax.xml.soap.*;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * Created by Evgen on 18.05.2017.
 */
public class RequestCreator {

    private static final String baseURL = "http://www.webserviceX.NET/";
    private static final String filePath = "src/test/resources/request.xml";


    public static SOAPMessage getAirportInformationByCountry(String country) throws IOException, SOAPException {
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage soapMessage = factory.createMessage();
        SOAPPart part = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = part.getEnvelope();
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", baseURL + "GetAirportInformationByCountry");
        SOAPBody body = envelope.getBody();

        SOAPBodyElement element = body.addBodyElement(envelope.createName("GetAirportInformationByCountry", "", "http://www.webserviceX.NET"));
        element.addChildElement("country").addTextNode(country);

        soapMessage.writeTo(System.out);
        FileOutputStream fOut = new FileOutputStream(filePath);
        return soapMessage;
    }

    public static SOAPMessage getAirportInformationByAirportCode(String code) throws IOException, SOAPException {
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage soapMessage = factory.createMessage();
        SOAPPart part = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = part.getEnvelope();
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", baseURL + "getAirportInformationByAirportCode");
        SOAPBody body = envelope.getBody();

        SOAPBodyElement element = body.addBodyElement(envelope.createName("getAirportInformationByAirportCode", "", "http://www.webserviceX.NET"));
        element.addChildElement("airportCode").addTextNode(code);

        soapMessage.writeTo(System.out);
        FileOutputStream fOut = new FileOutputStream(filePath);
        return soapMessage;

    }

    public static SOAPMessage getAirportInformationByCityOrAirportName(String cityOrName) throws IOException, SOAPException {
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage soapMessage = factory.createMessage();
        SOAPPart part = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = part.getEnvelope();
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", baseURL + "getAirportInformationByCityOrAirportName");
        SOAPBody body = envelope.getBody();

        SOAPBodyElement element = body.addBodyElement(envelope.createName("getAirportInformationByCityOrAirportName", "", "http://www.webserviceX.NET"));
        element.addChildElement("cityOrAirportName").addTextNode(cityOrName);

        soapMessage.writeTo(System.out);
        FileOutputStream fOut = new FileOutputStream(filePath);
        return soapMessage;
    }

    public static SOAPMessage getAirportInformationByISOCountryCode(String ISO) throws IOException, SOAPException {
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage soapMessage = factory.createMessage();
        SOAPPart part = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = part.getEnvelope();
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", baseURL + "getAirportInformationByISOCountryCode");
        SOAPBody body = envelope.getBody();

        SOAPBodyElement element = body.addBodyElement(envelope.createName("getAirportInformationByISOCountryCode", "", "http://www.webserviceX.NET"));
        element.addChildElement("CountryAbbrviation").addTextNode(ISO);

        soapMessage.writeTo(System.out);
        FileOutputStream fOut = new FileOutputStream(filePath);
        return soapMessage;
    }

    public static SOAPMessage createWrongMessage() throws IOException, SOAPException {
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage soapMessage = factory.createMessage();
        SOAPPart part = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = part.getEnvelope();
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", baseURL + "GetAirportInformationByCountry");
        SOAPBody body = envelope.getBody();

        SOAPBodyElement element = body.addBodyElement(envelope.createName("GetAirportInformationByCountry", "", "http://www.webserviceX.NET"));

        soapMessage.writeTo(System.out);
        FileOutputStream fOut = new FileOutputStream(filePath);
        return soapMessage;
    }

}
