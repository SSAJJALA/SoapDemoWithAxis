package gov.weather;

import gov.weather.JAXB.DwmlType;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

import static org.junit.Assert.*;

/**
 * Created by student on 10/6/16.
 */
public class NdfdXMLBindingStubTest {
    @Test
    public void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();
        String result = binding.latLonListZipCode("53562");

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        DwmlType dwml = (DwmlType) unmarshaller.unmarshal(new StringReader(result));
        String latlonlist = dwml.getLatLonList();

        assertEquals("Result did not match the expected value", "43.1029,-89.5063", latlonlist);
    }

}