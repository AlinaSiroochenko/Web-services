package lt.viko.eif.siroochenko.restaurantconsumer;

import lt.viko.eif.siroochenko.restaurantconsumer.model.Restaurant;
import lt.viko.eif.siroochenko.restaurantconsumer.util.ConverterUtil;
import lt.viko.eif.siroochenko.restaurantconsumer.util.JaxbUtilGeneric;
import lt.viko.eif.siroochenko.restaurantconsumer.util.TransformUtil;
import lt.viko.eif.siroochenko.restaurantconsumer.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Controller class for handling restaurant-related requests.
 */
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantClient restaurantClient;

    @Autowired
    private ConverterUtil converterUtil;

    @Autowired
    private JaxbUtilGeneric jaxbUtil;

    @Autowired
    private TransformUtil transformUtil;

    private final String RESTAURANT_XSLT_PDF = "src/main/resources/restaurant-to-pdf.xsl";
    private final String RESTAURANT_XSLT_HTML = "src/main/resources/restaurant-to-html.xsl";

    /**
     * Retrieves restaurant by name and returns it as HTML.
     * @param name The name of the restaurant to retrieve.
     * @return ResponseEntity containing the restaurant data as HTML.
     */
    @GetMapping("/restaurants/restaurant/name/html")
    public ResponseEntity<String> getRestaurantByNameAsHtml(@RequestParam String name) {
        String restaurantXML = getRestaurantXMLByName(name);
        return displayRestaurantXMLInHTML(restaurantXML, RESTAURANT_XSLT_HTML);
    }

    /**
     * Retrieves restaurant by name and returns it as PDF.
     * @param name The name of the restaurant to retrieve.
     * @return ResponseEntity containing the restaurant data as PDF.
     */
    @GetMapping("/restaurants/restaurant/name/pdf")
    public ResponseEntity<?> getRestaurantByNameAsPdf(@RequestParam String name) {
        String restaurantXML = getRestaurantXMLByName(name);
        return displayRestaurantXMLInPDF(restaurantXML, RESTAURANT_XSLT_PDF);
    }

    /**
     * Retrieves restaurant by id and returns it as HTML.
     * @param id The id of the restaurant to retrieve.
     * @return ResponseEntity containing the restaurant data as HTML.
     */
    @GetMapping("/restaurants/restaurant/id/html")
    public ResponseEntity<String> getRestaurantByIdAsHtml(@RequestParam int id) {
        String restaurantXML = getRestaurantXMLById(id);
        return displayRestaurantXMLInHTML(restaurantXML, RESTAURANT_XSLT_HTML);
    }

    /**
     * Retrieves restaurant by id and returns it as PDF.
     * @param id The id of the restaurant to retrieve.
     * @return ResponseEntity containing the restaurant data as PDF.
     */
    @GetMapping("/restaurants/restaurant/id/pdf")
    public ResponseEntity<?> getRestaurantByIdAsPdf(@RequestParam int id) {
        String restaurantXML = getRestaurantXMLById(id);
        return displayRestaurantXMLInPDF(restaurantXML, RESTAURANT_XSLT_PDF);
    }

    /**
     * Adds a new restaurant based on the provided XML data.
     * @param xmlData The XML data representing the restaurant to be added.
     * @return ResponseEntity containing the added restaurant data as HTML.
     */
    @PostMapping("/restaurants/add")
    public ResponseEntity<String> addRestaurant(@RequestBody String xmlData) {
        Restaurant restaurant = jaxbUtil.convertXMLToPOJO(xmlData, Restaurant.class);
        lt.viko.eif.siroochenko.restaurantconsumer.wsdl.Restaurant restaurantGen = converterUtil.convertToDto(restaurant);

        AddRestaurantResponse response = restaurantClient.addRestaurant(restaurantGen);
        if (response != null) {
            return displayRestaurantXMLInHTML(xmlData, RESTAURANT_XSLT_HTML);
        } else {
            return get404Response();
        }
    }

    /**
     * Converts restaurant DTO to XML and returns it.
     * @param restaurantGen The restaurant DTO object.
     * @return XML representation of the restaurant.
     */
    private String convertRestaurantDtoToXML(lt.viko.eif.siroochenko.restaurantconsumer.wsdl.Restaurant restaurantGen) {
        Restaurant restaurant = converterUtil.convertToEntity(restaurantGen);
        return jaxbUtil.convertPOJOToXML(restaurant);
    }

    /**
     * Returns a ResponseEntity with a 404 status code and custom error message.
     * @return ResponseEntity with 404 status and error message.
     */
    private ResponseEntity<String> get404Response() {
        try {
            File file = ResourceUtils.getFile("src/main/resources/static/404.html");
            String content = new String(Files.readAllBytes(file.toPath()));
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.TEXT_HTML)
                    .body(content);
        } catch (IOException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error reading 404 file");
        }
    }

    /**
     * Retrieves XML data for a restaurant by its name from the RestaurantClient and converts it to XML format.
     * @param name The name of the restaurant to retrieve.
     * @return XML representation of the restaurant with the specified name.
     */
    private String getRestaurantXMLByName(String name) {
        GetRestaurantByNameResponse response = restaurantClient.getRestaurantByName(name);
        if (response != null) {
            lt.viko.eif.siroochenko.restaurantconsumer.wsdl.Restaurant restaurantGen = response.getRestaurant();
            return convertRestaurantDtoToXML(restaurantGen);
        } else {
            return null;
        }
    }

    /**
     * Retrieves XML data for a restaurant by its ID from the RestaurantClient and converts it to XML format.
     * @param id The ID of the restaurant to retrieve.
     * @return XML representation of the restaurant with the specified ID.
     */
    private String getRestaurantXMLById(int id) {
        GetRestaurantByIdResponse response = restaurantClient.getRestaurantById(id);
        if (response != null) {
            lt.viko.eif.siroochenko.restaurantconsumer.wsdl.Restaurant restaurantGen = response.getRestaurant();
            return convertRestaurantDtoToXML(restaurantGen);
        } else {
            return null;
        }
    }

    /**
     * Displays restaurant XML as PDF.
     * @param restaurantXML The XML data representing the restaurant.
     * @param xslFilePath The file path to the XSL stylesheet for PDF transformation.
     * @return ResponseEntity with PDF content.
     */
    private ResponseEntity<?> displayRestaurantXMLInPDF(String restaurantXML, String xslFilePath) {
        if (restaurantXML != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            transformUtil.convertToPDF(restaurantXML, xslFilePath, baos);
            byte[] pdfBytes = baos.toByteArray();
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfBytes);
        } else {
            return get404Response();
        }
    }

    /**
     * Displays restaurant XML as HTML.
     * @param restaurantXML The XML data representing the restaurant.
     * @param xslFilePath The file path to the XSL stylesheet for HTML transformation.
     * @return ResponseEntity with HTML content.
     */
    private ResponseEntity<String> displayRestaurantXMLInHTML(String restaurantXML, String xslFilePath) {
        if (restaurantXML != null) {
            String restaurantHTML = transformUtil.convertToHTML(restaurantXML, xslFilePath);
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_HTML)
                    .body(restaurantHTML);
        } else {
            return get404Response();
        }
    }
}
