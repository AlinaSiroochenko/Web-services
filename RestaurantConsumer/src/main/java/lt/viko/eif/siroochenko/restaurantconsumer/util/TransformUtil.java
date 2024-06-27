package lt.viko.eif.siroochenko.restaurantconsumer.util;

import org.apache.fop.apps.*;
import org.springframework.stereotype.Service;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * Utility class for transforming XML content to PDF or HTML using XSLT (Extensible Stylesheet Language Transformations)
 * and Apache FOP (Formatting Objects Processor).
 */
@Service
public class TransformUtil {

    /**
     * Converts XML content to PDF using XSLT transformation.
     * @param xmlContent The XML content to be converted to PDF.
     * @param XSLFilePath The file path to the XSLT stylesheet for PDF conversion.
     * @param out The output stream to write the PDF content to.
     * @throws RuntimeException If an error occurs during the conversion process.
     */
    public void convertToPDF(String xmlContent, String XSLFilePath, ByteArrayOutputStream out) {
        File xsltFile = new File(XSLFilePath);
        StreamSource xmlSource = new StreamSource(new StringReader(xmlContent));
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

        try {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
            Result res = new SAXResult(fop.getDefaultHandler());
            transformer.transform(xmlSource, res);
        } catch (FOPException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts XML content to HTML using XSLT transformation.
     * @param xmlContent The XML content to be converted to HTML.
     * @param xslFilePath The file path to the XSLT stylesheet for HTML conversion.
     * @return The HTML content generated from the XML content.
     * @throws RuntimeException If an error occurs during the conversion process.
     */
    public String convertToHTML(String xmlContent, String xslFilePath) {
        Source xmlSource = new StreamSource(new StringReader(xmlContent));
        File xsltFile = new File(xslFilePath);
        Source xsltSource = new StreamSource(xsltFile);

        StringWriter writer = new StringWriter();

        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xsltSource);

            Result result = new StreamResult(writer);
            transformer.transform(xmlSource, result);

            return writer.toString();
        } catch (TransformerException e) {
            throw new RuntimeException("Error during XML to HTML transformation", e);
        }
    }
}
