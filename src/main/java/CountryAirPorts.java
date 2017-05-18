import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evgen on 17.05.2017.
 */

@XmlRootElement(name = "NewDataSet")
public class CountryAirPorts {
    @JacksonXmlElementWrapper(localName = "Table")
    private List<Airport> airports;
    public CountryAirPorts() {
    }
    public CountryAirPorts(List<Airport> airports) {
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
        return "CountryAirPorts{" +
                "airports=" + airports +
                '}';
    }
}
