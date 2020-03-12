//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:27:58 AM CET 
//


package no.bibsys.alma.rest.bibs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the no.bibsys.alma.rest.bibs package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NetworkNumbers_QNAME = new QName("", "network_numbers");
    private final static QName _Bib_QNAME = new QName("", "bib");
    private final static QName _Bibs_QNAME = new QName("", "bibs");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: no.bibsys.alma.rest.bibs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Bib }
     * 
     */
    public Bib createBib() {
        return new Bib();
    }

    /**
     * Create an instance of {@link NetworkNumbers }
     * 
     */
    public NetworkNumbers createNetworkNumbers() {
        return new NetworkNumbers();
    }

    /**
     * Create an instance of {@link Bibs }
     * 
     */
    public Bibs createBibs() {
        return new Bibs();
    }

    /**
     * Create an instance of {@link Warnings }
     * 
     */
    public Warnings createWarnings() {
        return new Warnings();
    }

    /**
     * Create an instance of {@link Warning }
     * 
     */
    public Warning createWarning() {
        return new Warning();
    }

    /**
     * Create an instance of {@link Bib.LinkedRecordId }
     * 
     */
    public Bib.LinkedRecordId createBibLinkedRecordId() {
        return new Bib.LinkedRecordId();
    }

    /**
     * Create an instance of {@link Bib.Holdings }
     * 
     */
    public Bib.Holdings createBibHoldings() {
        return new Bib.Holdings();
    }

    /**
     * Create an instance of {@link Bib.CatalogingLevel }
     * 
     */
    public Bib.CatalogingLevel createBibCatalogingLevel() {
        return new Bib.CatalogingLevel();
    }

    /**
     * Create an instance of {@link Bib.Requests }
     * 
     */
    public Bib.Requests createBibRequests() {
        return new Bib.Requests();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NetworkNumbers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "network_numbers")
    public JAXBElement<NetworkNumbers> createNetworkNumbers(NetworkNumbers value) {
        return new JAXBElement<NetworkNumbers>(_NetworkNumbers_QNAME, NetworkNumbers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bib }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bib")
    public JAXBElement<Bib> createBib(Bib value) {
        return new JAXBElement<Bib>(_Bib_QNAME, Bib.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bibs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bibs")
    public JAXBElement<Bibs> createBibs(Bibs value) {
        return new JAXBElement<Bibs>(_Bibs_QNAME, Bibs.class, null, value);
    }

}