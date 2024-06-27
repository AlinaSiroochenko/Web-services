package lt.viko.eif.siroochenko.restaurant;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * Configuration class for setting up the web service endpoints and WSDL definitions.
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    /**
     * Configures the message dispatcher servlet.
     *
     * @param applicationContext The application context.
     * @return A ServletRegistrationBean for the message dispatcher servlet.
     */
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    /**
     * Defines the WSDL for the "orders" endpoint.
     *
     * @param ordersSchema The XSD schema for the orders.
     * @return A DefaultWsdl11Definition for the "orders" endpoint.
     */
    @Bean(name = "orders")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema ordersSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("OrdersPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://eif.viko.lt/siroochenko/restaurant");
        wsdl11Definition.setSchema(ordersSchema);
        return wsdl11Definition;
    }

    /**
     * Creates an XSD schema for the "orders" endpoint.
     *
     * @return An XsdSchema instance for the "orders" endpoint.
     */
    @Bean
    public XsdSchema ordersSchema() {
        return new SimpleXsdSchema(new ClassPathResource("order.xsd"));
    }
}
