import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Evgen on 18.05.2017.
 */
public class AirportFactory {
    public static RequestResult createResult() throws IOException, JAXBException {
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
        JAXBContext jaxbContext = JAXBContext.newInstance(RequestResult.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        RequestResult airports = (RequestResult) jaxbUnmarshaller.unmarshal( new StreamSource( new StringReader(xml)));
        return airports;
    }
}
