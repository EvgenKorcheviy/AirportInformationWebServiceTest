
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.sun.xml.internal.txw2.annotation.XmlCDATA;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
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
        BufferedReader br = new BufferedReader(new FileReader(new File("src/test/resources/requestResult.xml")));
        String line;
        StringBuilder sb = new StringBuilder();
        while((line=br.readLine())!= null){
            sb.append(line.trim());
        }
        String xml = sb.toString();
        Pattern p = Pattern.compile("&lt;NewDataSet&gt;((.*?))&lt;/NewDataSet&gt;",Pattern.DOTALL);
        Matcher m = p.matcher(sb.toString());
        xml=new String();
        while (m.find()) {
            xml = m.group(0).trim().replaceAll("&lt;","<").replaceAll("&gt;",">");
        }
        File file = new File("src/test/resources/requestResult.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(CountryAirPorts.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        CountryAirPorts customer = (CountryAirPorts) jaxbUnmarshaller.unmarshal( new StreamSource( new StringReader(xml)));
    }


    public static String extractBody(String string){

        return null;
    }
    public static Object convert(String string, Class cl) throws JAXBException, JAXBException {
        StringReader reader = new StringReader(string);
        JAXBContext jaxbContext = JAXBContext.newInstance(cl);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        return jaxbUnmarshaller.unmarshal( reader );
    }
}
