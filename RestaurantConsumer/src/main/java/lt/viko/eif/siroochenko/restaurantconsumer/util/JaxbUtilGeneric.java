package lt.viko.eif.siroochenko.restaurantconsumer.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;
import java.io.*;

/**
 * Utility class for converting between XML and POJO objects using JAXB (Java Architecture for XML Binding).
 */
@Service
public class JaxbUtilGeneric {

    /**
     * Converts XML content to a POJO (Plain Old Java Object) of the specified class.
     * @param xmlContent The XML content to be converted.
     * @param clazz The class of the POJO to convert to.
     * @param <T> The type of the POJO.
     * @return The POJO object created from the XML content.
     * @throws RuntimeException If an error occurs during unmarshalling.
     */
    public <T> T convertXMLToPOJO(String xmlContent, Class<T> clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            T unmarshalledObject = (T) jaxbUnmarshaller.unmarshal(
                    new StringReader(xmlContent)
            );
            return unmarshalledObject;

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts a POJO object to its XML representation.
     * @param object The POJO object to be converted to XML.
     * @param <T> The type of the POJO.
     * @return The XML representation of the POJO object.
     * @throws RuntimeException If an error occurs during marshalling.
     */
    public <T> String convertPOJOToXML(T object) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(object, writer);

            return writer.toString();

        } catch (JAXBException e) {
            throw new RuntimeException("Error during XML marshalling", e);
        }
    }
}
