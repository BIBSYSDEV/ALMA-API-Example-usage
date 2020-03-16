//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:28:09 AM CET 
//


package no.bibsys.alma.rest.partner;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals2;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy2;
import org.jvnet.jaxb2_commons.lang.HashCode2;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy2;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * ARTEmail related details. Relevant and mandatory only if profile_type = ART_EMAIL.
 * 
 * <p>Java class for art_email_details complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="art_email_details"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="email_address" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="alternative_document_delivery" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="customer_ids" type="{}customer_ids"/&gt;
 *         &lt;element name="keywords_service" type="{}keywords_service" minOccurs="0"/&gt;
 *         &lt;element name="keywords_delivery" type="{}keywords_delivery" minOccurs="0"/&gt;
 *         &lt;element name="keywords_queries" type="{}keywords_queries" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "art_email_details", propOrder = {

})
public class ArtEmailDetails implements Serializable, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "email_address", required = true)
    protected String emailAddress;
    @XmlElement(name = "alternative_document_delivery")
    protected boolean alternativeDocumentDelivery;
    @XmlElement(name = "customer_ids", required = true)
    protected CustomerIds customerIds;
    @XmlElement(name = "keywords_service")
    protected KeywordsService keywordsService;
    @XmlElement(name = "keywords_delivery")
    protected KeywordsDelivery keywordsDelivery;
    @XmlElement(name = "keywords_queries")
    protected KeywordsQueries keywordsQueries;

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the alternativeDocumentDelivery property.
     * 
     */
    public boolean isAlternativeDocumentDelivery() {
        return alternativeDocumentDelivery;
    }

    /**
     * Sets the value of the alternativeDocumentDelivery property.
     * 
     */
    public void setAlternativeDocumentDelivery(boolean value) {
        this.alternativeDocumentDelivery = value;
    }

    /**
     * Gets the value of the customerIds property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerIds }
     *     
     */
    public CustomerIds getCustomerIds() {
        return customerIds;
    }

    /**
     * Sets the value of the customerIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerIds }
     *     
     */
    public void setCustomerIds(CustomerIds value) {
        this.customerIds = value;
    }

    /**
     * Gets the value of the keywordsService property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordsService }
     *     
     */
    public KeywordsService getKeywordsService() {
        return keywordsService;
    }

    /**
     * Sets the value of the keywordsService property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordsService }
     *     
     */
    public void setKeywordsService(KeywordsService value) {
        this.keywordsService = value;
    }

    /**
     * Gets the value of the keywordsDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordsDelivery }
     *     
     */
    public KeywordsDelivery getKeywordsDelivery() {
        return keywordsDelivery;
    }

    /**
     * Sets the value of the keywordsDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordsDelivery }
     *     
     */
    public void setKeywordsDelivery(KeywordsDelivery value) {
        this.keywordsDelivery = value;
    }

    /**
     * Gets the value of the keywordsQueries property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordsQueries }
     *     
     */
    public KeywordsQueries getKeywordsQueries() {
        return keywordsQueries;
    }

    /**
     * Sets the value of the keywordsQueries property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordsQueries }
     *     
     */
    public void setKeywordsQueries(KeywordsQueries value) {
        this.keywordsQueries = value;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theEmailAddress;
            theEmailAddress = this.getEmailAddress();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "emailAddress", theEmailAddress), currentHashCode, theEmailAddress, (this.emailAddress!= null));
        }
        {
            boolean theAlternativeDocumentDelivery;
            theAlternativeDocumentDelivery = this.isAlternativeDocumentDelivery();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "alternativeDocumentDelivery", theAlternativeDocumentDelivery), currentHashCode, theAlternativeDocumentDelivery, true);
        }
        {
            CustomerIds theCustomerIds;
            theCustomerIds = this.getCustomerIds();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "customerIds", theCustomerIds), currentHashCode, theCustomerIds, (this.customerIds!= null));
        }
        {
            KeywordsService theKeywordsService;
            theKeywordsService = this.getKeywordsService();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "keywordsService", theKeywordsService), currentHashCode, theKeywordsService, (this.keywordsService!= null));
        }
        {
            KeywordsDelivery theKeywordsDelivery;
            theKeywordsDelivery = this.getKeywordsDelivery();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "keywordsDelivery", theKeywordsDelivery), currentHashCode, theKeywordsDelivery, (this.keywordsDelivery!= null));
        }
        {
            KeywordsQueries theKeywordsQueries;
            theKeywordsQueries = this.getKeywordsQueries();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "keywordsQueries", theKeywordsQueries), currentHashCode, theKeywordsQueries, (this.keywordsQueries!= null));
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ArtEmailDetails that = ((ArtEmailDetails) object);
        {
            String lhsEmailAddress;
            lhsEmailAddress = this.getEmailAddress();
            String rhsEmailAddress;
            rhsEmailAddress = that.getEmailAddress();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "emailAddress", lhsEmailAddress), LocatorUtils.property(thatLocator, "emailAddress", rhsEmailAddress), lhsEmailAddress, rhsEmailAddress, (this.emailAddress!= null), (that.emailAddress!= null))) {
                return false;
            }
        }
        {
            boolean lhsAlternativeDocumentDelivery;
            lhsAlternativeDocumentDelivery = this.isAlternativeDocumentDelivery();
            boolean rhsAlternativeDocumentDelivery;
            rhsAlternativeDocumentDelivery = that.isAlternativeDocumentDelivery();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "alternativeDocumentDelivery", lhsAlternativeDocumentDelivery), LocatorUtils.property(thatLocator, "alternativeDocumentDelivery", rhsAlternativeDocumentDelivery), lhsAlternativeDocumentDelivery, rhsAlternativeDocumentDelivery, true, true)) {
                return false;
            }
        }
        {
            CustomerIds lhsCustomerIds;
            lhsCustomerIds = this.getCustomerIds();
            CustomerIds rhsCustomerIds;
            rhsCustomerIds = that.getCustomerIds();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "customerIds", lhsCustomerIds), LocatorUtils.property(thatLocator, "customerIds", rhsCustomerIds), lhsCustomerIds, rhsCustomerIds, (this.customerIds!= null), (that.customerIds!= null))) {
                return false;
            }
        }
        {
            KeywordsService lhsKeywordsService;
            lhsKeywordsService = this.getKeywordsService();
            KeywordsService rhsKeywordsService;
            rhsKeywordsService = that.getKeywordsService();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "keywordsService", lhsKeywordsService), LocatorUtils.property(thatLocator, "keywordsService", rhsKeywordsService), lhsKeywordsService, rhsKeywordsService, (this.keywordsService!= null), (that.keywordsService!= null))) {
                return false;
            }
        }
        {
            KeywordsDelivery lhsKeywordsDelivery;
            lhsKeywordsDelivery = this.getKeywordsDelivery();
            KeywordsDelivery rhsKeywordsDelivery;
            rhsKeywordsDelivery = that.getKeywordsDelivery();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "keywordsDelivery", lhsKeywordsDelivery), LocatorUtils.property(thatLocator, "keywordsDelivery", rhsKeywordsDelivery), lhsKeywordsDelivery, rhsKeywordsDelivery, (this.keywordsDelivery!= null), (that.keywordsDelivery!= null))) {
                return false;
            }
        }
        {
            KeywordsQueries lhsKeywordsQueries;
            lhsKeywordsQueries = this.getKeywordsQueries();
            KeywordsQueries rhsKeywordsQueries;
            rhsKeywordsQueries = that.getKeywordsQueries();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "keywordsQueries", lhsKeywordsQueries), LocatorUtils.property(thatLocator, "keywordsQueries", rhsKeywordsQueries), lhsKeywordsQueries, rhsKeywordsQueries, (this.keywordsQueries!= null), (that.keywordsQueries!= null))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        {
            String theEmailAddress;
            theEmailAddress = this.getEmailAddress();
            strategy.appendField(locator, this, "emailAddress", buffer, theEmailAddress, (this.emailAddress!= null));
        }
        {
            boolean theAlternativeDocumentDelivery;
            theAlternativeDocumentDelivery = this.isAlternativeDocumentDelivery();
            strategy.appendField(locator, this, "alternativeDocumentDelivery", buffer, theAlternativeDocumentDelivery, true);
        }
        {
            CustomerIds theCustomerIds;
            theCustomerIds = this.getCustomerIds();
            strategy.appendField(locator, this, "customerIds", buffer, theCustomerIds, (this.customerIds!= null));
        }
        {
            KeywordsService theKeywordsService;
            theKeywordsService = this.getKeywordsService();
            strategy.appendField(locator, this, "keywordsService", buffer, theKeywordsService, (this.keywordsService!= null));
        }
        {
            KeywordsDelivery theKeywordsDelivery;
            theKeywordsDelivery = this.getKeywordsDelivery();
            strategy.appendField(locator, this, "keywordsDelivery", buffer, theKeywordsDelivery, (this.keywordsDelivery!= null));
        }
        {
            KeywordsQueries theKeywordsQueries;
            theKeywordsQueries = this.getKeywordsQueries();
            strategy.appendField(locator, this, "keywordsQueries", buffer, theKeywordsQueries, (this.keywordsQueries!= null));
        }
        return buffer;
    }

}
