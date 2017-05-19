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

    private static SOAPMessage createRequest(String requestName) throws SOAPException, FileNotFoundException {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        soapPart.setContent(new StreamSource(new FileInputStream(filePath)));

        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", baseURL + requestName);
        soapMessage.saveChanges();
        return soapMessage;
    }

    public static SOAPMessage getAirportInformationByCountry(String country) throws IOException, SOAPException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "    <soap:Body>\n" +
                "        <GetAirportInformationByCountry xmlns=\"http://www.webserviceX.NET\">\n" +
                "            <country>");
        builder.append(country);
        builder.append("</country>\n" +
                "        </GetAirportInformationByCountry>\n" +
                "    </soap:Body>\n" +
                "</soap:Envelope>");
        bufferedWriter.write(builder.toString());
        bufferedWriter.close();
        return createRequest("GetAirportInformationByCountry");
    }

    public static SOAPMessage getAirportInformationByAirportCode(String code) throws IOException, SOAPException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <getAirportInformationByAirportCode xmlns=\"http://www.webserviceX.NET\">\n" +
                "      <airportCode>");
        builder.append(code);
        builder.append("</airportCode>\n" +
                "    </getAirportInformationByAirportCode>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>");
        bufferedWriter.write(builder.toString());
        bufferedWriter.close();
        return createRequest("getAirportInformationByAirportCode");
    }

    public static SOAPMessage getAirportInformationByCityOrAirportName(String cityOrName) throws IOException, SOAPException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <getAirportInformationByCityOrAirportName xmlns=\"http://www.webserviceX.NET\">\n" +
                "      <cityOrAirportName>");
        builder.append(cityOrName);
        builder.append("</cityOrAirportName>\n" +
                "    </getAirportInformationByCityOrAirportName>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>");
        bufferedWriter.write(builder.toString());
        bufferedWriter.close();
        return createRequest("getAirportInformationByCityOrAirportName");
    }

    public static SOAPMessage getAirportInformationByISOCountryCode(String ISO) throws IOException, SOAPException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <getAirportInformationByISOCountryCode xmlns=\"http://www.webserviceX.NET\">\n" +
                "      <CountryAbbrviation>");
        builder.append(ISO);
        builder.append("</CountryAbbrviation>\n" +
                "    </getAirportInformationByISOCountryCode>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>");
        bufferedWriter.write(builder.toString());
        bufferedWriter.close();
        return createRequest("getAirportInformationByISOCountryCode");
    }

    public static SOAPMessage createWrongMessage() throws IOException, SOAPException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <getAirportInformationByISOCountryCode xmlns=\"http://www.webserviceX.NET\">\n");
        builder.append("    </getAirportInformationByISOCountryCode>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>");
        bufferedWriter.write(builder.toString());
        bufferedWriter.close();
        return createRequest("getAirportInformationByISOCountryCode");
    }
}
