//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:54:26 AM CET 
//


package no.bibsys.alma.rest.ncip;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.niso.org/2008/ncip}RequestType"/&gt;
 *           &lt;element ref="{http://www.niso.org/2008/ncip}CirculationStatus"/&gt;
 *           &lt;element ref="{http://www.niso.org/2008/ncip}ItemUseRestrictionType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}RequestedItemCountValue"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}Ext" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "itemUseRestrictionType",
    "circulationStatus",
    "requestType",
    "requestedItemCountValue",
    "ext"
})
@XmlRootElement(name = "RequestedItemsCount")
public class RequestedItemsCount implements Equals2, HashCode2, ToString2
{

    @XmlElement(name = "ItemUseRestrictionType")
    protected SchemeValuePair itemUseRestrictionType;
    @XmlElement(name = "CirculationStatus")
    protected SchemeValuePair circulationStatus;
    @XmlElement(name = "RequestType")
    protected SchemeValuePair requestType;
    @XmlElement(name = "RequestedItemCountValue", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger requestedItemCountValue;
    @XmlElement(name = "Ext")
    protected Ext ext;

    /**
     * Gets the value of the itemUseRestrictionType property.
     * 
     * @return
     *     possible object is
     *     {@link SchemeValuePair }
     *     
     */
    public SchemeValuePair getItemUseRestrictionType() {
        return itemUseRestrictionType;
    }

    /**
     * Sets the value of the itemUseRestrictionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemeValuePair }
     *     
     */
    public void setItemUseRestrictionType(SchemeValuePair value) {
        this.itemUseRestrictionType = value;
    }

    /**
     * Gets the value of the circulationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link SchemeValuePair }
     *     
     */
    public SchemeValuePair getCirculationStatus() {
        return circulationStatus;
    }

    /**
     * Sets the value of the circulationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemeValuePair }
     *     
     */
    public void setCirculationStatus(SchemeValuePair value) {
        this.circulationStatus = value;
    }

    /**
     * Gets the value of the requestType property.
     * 
     * @return
     *     possible object is
     *     {@link SchemeValuePair }
     *     
     */
    public SchemeValuePair getRequestType() {
        return requestType;
    }

    /**
     * Sets the value of the requestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemeValuePair }
     *     
     */
    public void setRequestType(SchemeValuePair value) {
        this.requestType = value;
    }

    /**
     * Gets the value of the requestedItemCountValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRequestedItemCountValue() {
        return requestedItemCountValue;
    }

    /**
     * Sets the value of the requestedItemCountValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRequestedItemCountValue(BigInteger value) {
        this.requestedItemCountValue = value;
    }

    /**
     * Gets the value of the ext property.
     * 
     * @return
     *     possible object is
     *     {@link Ext }
     *     
     */
    public Ext getExt() {
        return ext;
    }

    /**
     * Sets the value of the ext property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ext }
     *     
     */
    public void setExt(Ext value) {
        this.ext = value;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            SchemeValuePair theItemUseRestrictionType;
            theItemUseRestrictionType = this.getItemUseRestrictionType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itemUseRestrictionType", theItemUseRestrictionType), currentHashCode, theItemUseRestrictionType, (this.itemUseRestrictionType!= null));
        }
        {
            SchemeValuePair theCirculationStatus;
            theCirculationStatus = this.getCirculationStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "circulationStatus", theCirculationStatus), currentHashCode, theCirculationStatus, (this.circulationStatus!= null));
        }
        {
            SchemeValuePair theRequestType;
            theRequestType = this.getRequestType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "requestType", theRequestType), currentHashCode, theRequestType, (this.requestType!= null));
        }
        {
            BigInteger theRequestedItemCountValue;
            theRequestedItemCountValue = this.getRequestedItemCountValue();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "requestedItemCountValue", theRequestedItemCountValue), currentHashCode, theRequestedItemCountValue, (this.requestedItemCountValue!= null));
        }
        {
            Ext theExt;
            theExt = this.getExt();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ext", theExt), currentHashCode, theExt, (this.ext!= null));
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
        final RequestedItemsCount that = ((RequestedItemsCount) object);
        {
            SchemeValuePair lhsItemUseRestrictionType;
            lhsItemUseRestrictionType = this.getItemUseRestrictionType();
            SchemeValuePair rhsItemUseRestrictionType;
            rhsItemUseRestrictionType = that.getItemUseRestrictionType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "itemUseRestrictionType", lhsItemUseRestrictionType), LocatorUtils.property(thatLocator, "itemUseRestrictionType", rhsItemUseRestrictionType), lhsItemUseRestrictionType, rhsItemUseRestrictionType, (this.itemUseRestrictionType!= null), (that.itemUseRestrictionType!= null))) {
                return false;
            }
        }
        {
            SchemeValuePair lhsCirculationStatus;
            lhsCirculationStatus = this.getCirculationStatus();
            SchemeValuePair rhsCirculationStatus;
            rhsCirculationStatus = that.getCirculationStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "circulationStatus", lhsCirculationStatus), LocatorUtils.property(thatLocator, "circulationStatus", rhsCirculationStatus), lhsCirculationStatus, rhsCirculationStatus, (this.circulationStatus!= null), (that.circulationStatus!= null))) {
                return false;
            }
        }
        {
            SchemeValuePair lhsRequestType;
            lhsRequestType = this.getRequestType();
            SchemeValuePair rhsRequestType;
            rhsRequestType = that.getRequestType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "requestType", lhsRequestType), LocatorUtils.property(thatLocator, "requestType", rhsRequestType), lhsRequestType, rhsRequestType, (this.requestType!= null), (that.requestType!= null))) {
                return false;
            }
        }
        {
            BigInteger lhsRequestedItemCountValue;
            lhsRequestedItemCountValue = this.getRequestedItemCountValue();
            BigInteger rhsRequestedItemCountValue;
            rhsRequestedItemCountValue = that.getRequestedItemCountValue();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "requestedItemCountValue", lhsRequestedItemCountValue), LocatorUtils.property(thatLocator, "requestedItemCountValue", rhsRequestedItemCountValue), lhsRequestedItemCountValue, rhsRequestedItemCountValue, (this.requestedItemCountValue!= null), (that.requestedItemCountValue!= null))) {
                return false;
            }
        }
        {
            Ext lhsExt;
            lhsExt = this.getExt();
            Ext rhsExt;
            rhsExt = that.getExt();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ext", lhsExt), LocatorUtils.property(thatLocator, "ext", rhsExt), lhsExt, rhsExt, (this.ext!= null), (that.ext!= null))) {
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
            SchemeValuePair theItemUseRestrictionType;
            theItemUseRestrictionType = this.getItemUseRestrictionType();
            strategy.appendField(locator, this, "itemUseRestrictionType", buffer, theItemUseRestrictionType, (this.itemUseRestrictionType!= null));
        }
        {
            SchemeValuePair theCirculationStatus;
            theCirculationStatus = this.getCirculationStatus();
            strategy.appendField(locator, this, "circulationStatus", buffer, theCirculationStatus, (this.circulationStatus!= null));
        }
        {
            SchemeValuePair theRequestType;
            theRequestType = this.getRequestType();
            strategy.appendField(locator, this, "requestType", buffer, theRequestType, (this.requestType!= null));
        }
        {
            BigInteger theRequestedItemCountValue;
            theRequestedItemCountValue = this.getRequestedItemCountValue();
            strategy.appendField(locator, this, "requestedItemCountValue", buffer, theRequestedItemCountValue, (this.requestedItemCountValue!= null));
        }
        {
            Ext theExt;
            theExt = this.getExt();
            strategy.appendField(locator, this, "ext", buffer, theExt, (this.ext!= null));
        }
        return buffer;
    }

}