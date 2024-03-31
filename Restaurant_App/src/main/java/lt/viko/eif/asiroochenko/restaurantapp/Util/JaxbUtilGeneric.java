package lt.viko.eif.asiroochenko.restaurantapp.Util;

import javax.xml.bind.*;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * The JaxbUtilGeneric class provides utility methods for marshalling and unmarshalling XML using JAXB,
 * as well as for generating XSD schema.
 * It contains static methods for converting objects to XML, XML to objects (POJO), and for generating XSD.
 */
public final class JaxbUtilGeneric {

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private JaxbUtilGeneric() {
    }

    /**
     * Marshals the given object to XML and writes it to a file named "generated.xml".
     *
     * @param object The object to be marshalled to XML.
     * @param <T>    The type of the object being marshalled.
     */
    public static <T> void convertToXML(T object) {
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            OutputStream os = new FileOutputStream("generated.xml");
            marshaller.marshal(object, System.out);
            marshaller.marshal(object, os);
        } catch (FileNotFoundException | JAXBException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Unmarshals the XML file into an object of the specified class.
     *
     * @param xmlFile The XML file to be unmarshalled.
     * @param clazz   The class of the object to be created from XML.
     * @param <T>     The type of the object being unmarshalled.
     * @return The object created from XML.
     */
    public static <T> T convertToPOJO(File xmlFile, Class<T> clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return clazz.cast(unmarshaller.unmarshal(xmlFile));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Generates XSD schema for the specified class and writes it to a file named "generated.xsd".
     *
     * @param clazz The class for which XSD schema needs to be generated.
     * @param <T>   The type of the class for XSD generation.
     */
    public static <T> void generateXSD(Class<T> clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            jaxbContext.generateSchema(new SchemaOutputResolver() {
                @Override
                public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                    File file = new File("generated.xsd");
                    StreamResult result = new StreamResult(file);
                    result.setSystemId(file.toURI().toURL().toString());
                    return result;
                }
            });
            BufferedReader reader = new BufferedReader(new FileReader("generated.xsd"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}