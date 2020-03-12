//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:28:06 AM CET 
//


package no.bibsys.alma.rest.fund;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the no.bibsys.alma.rest.fund package. 
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

    private final static QName _Fund_QNAME = new QName("", "fund");
    private final static QName _Funds_QNAME = new QName("", "funds");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: no.bibsys.alma.rest.fund
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Fund }
     * 
     */
    public Fund createFund() {
        return new Fund();
    }

    /**
     * Create an instance of {@link Funds }
     * 
     */
    public Funds createFunds() {
        return new Funds();
    }

    /**
     * Create an instance of {@link Fund.Type }
     * 
     */
    public Fund.Type createFundType() {
        return new Fund.Type();
    }

    /**
     * Create an instance of {@link Fund.Status }
     * 
     */
    public Fund.Status createFundStatus() {
        return new Fund.Status();
    }

    /**
     * Create an instance of {@link Fund.FiscalPeriod }
     * 
     */
    public Fund.FiscalPeriod createFundFiscalPeriod() {
        return new Fund.FiscalPeriod();
    }

    /**
     * Create an instance of {@link Fund.Currency }
     * 
     */
    public Fund.Currency createFundCurrency() {
        return new Fund.Currency();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Fund }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "fund")
    public JAXBElement<Fund> createFund(Fund value) {
        return new JAXBElement<Fund>(_Fund_QNAME, Fund.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Funds }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "funds")
    public JAXBElement<Funds> createFunds(Funds value) {
        return new JAXBElement<Funds>(_Funds_QNAME, Funds.class, null, value);
    }

}
