
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evgen on 17.05.2017.
 */

@XmlRootElement(name = "NewDataSet")
public class RequestResult {

    private List<Airport> airports;

    public RequestResult() {
    }
    public RequestResult(List<Airport> airports) {
        this.airports = airports;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    @XmlElement(name = "Table")
    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    @Override
    public String toString() {
        return "RequestResult{" +
                "airports=" + airports +
                '}';
    }

    public boolean isAirportsFromSameCountry(String country) {
        for (Airport airport : airports) {
            if (!airport.getCountry().equals(country)) return false;
        }
        return true;
    }

    public boolean isAirportWithCorrectCode(String code) {
        boolean status = true;
        int count = 0;
        for (Airport airport : airports) {
            if (airport.getAirportCode().equals(code)) {
                count ++;
            }
            if (!airport.getAirportCode().equals(code)) return false;
            if (count > 1) return false;
        }
        return true;
    }

    public boolean isAirportWithCorrectNameAndCity(String nameAndCity) {
        boolean status = true;
        int count = 0;
        for (Airport airport : airports) {
            if (airport.getCityOrAirportName().equals(nameAndCity)) {
                count ++;
            }
            if (!airport.getCityOrAirportName().equals(nameAndCity)) return false;
            if (count > 1) return false;
        }
        return true;
    }

    public boolean isAirportsWithTheSameCountryCode(String countryCode) {
        for (Airport airport : airports) {
            if (!airport.getCountryAbbrviation().equalsIgnoreCase(countryCode)) return false;
        }
        return true;
    }

    public static String requestResultText() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("src/test/resources/requestResult.xml")));
        String line;
        StringBuilder sb = new StringBuilder();
        while((line=br.readLine())!= null){
            sb.append(line.trim());
        }
        String xml = sb.toString();

        return xml;
    }

}
