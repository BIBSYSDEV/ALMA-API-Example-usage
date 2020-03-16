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
 *         &lt;element ref="{http://www.niso.org/2008/ncip}CurrencyCode"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}MonetaryValue"/&gt;
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
    "currencyCode",
    "monetaryValue",
    "ext"
})
@XmlRootElement(name = "AcknowledgedFeeAmount")
public class AcknowledgedFeeAmount implements Equals2, HashCode2, ToString2
{

    @XmlElement(name = "CurrencyCode", required = true)
    protected SchemeValuePair currencyCode;
    @XmlElement(name = "MonetaryValue", required = true)
    protected BigInteger monetaryValue;
    @XmlElement(name = "Ext")
    protected Ext ext;

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link SchemeValuePair }
     *     
     */
    public SchemeValuePair getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemeValuePair }
     *     
     */
    public void setCurrencyCode(SchemeValuePair value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the monetaryValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMonetaryValue() {
        return monetaryValue;
    }

    /**
     * Sets the value of the monetaryValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMonetaryValue(BigInteger value) {
        this.monetaryValue = value;
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
            SchemeValuePair theCurrencyCode;
            theCurrencyCode = this.getCurrencyCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "currencyCode", theCurrencyCode), currentHashCode, theCurrencyCode, (this.currencyCode!= null));
        }
        {
            BigInteger theMonetaryValue;
            theMonetaryValue = this.getMonetaryValue();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "monetaryValue", theMonetaryValue), currentHashCode, theMonetaryValue, (this.monetaryValue!= null));
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
        final AcknowledgedFeeAmount that = ((AcknowledgedFeeAmount) object);
        {
            SchemeValuePair lhsCurrencyCode;
            lhsCurrencyCode = this.getCurrencyCode();
            SchemeValuePair rhsCurrencyCode;
            rhsCurrencyCode = that.getCurrencyCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "currencyCode", lhsCurrencyCode), LocatorUtils.property(thatLocator, "currencyCode", rhsCurrencyCode), lhsCurrencyCode, rhsCurrencyCode, (this.currencyCode!= null), (that.currencyCode!= null))) {
                return false;
            }
        }
        {
            BigInteger lhsMonetaryValue;
            lhsMonetaryValue = this.getMonetaryValue();
            BigInteger rhsMonetaryValue;
            rhsMonetaryValue = that.getMonetaryValue();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "monetaryValue", lhsMonetaryValue), LocatorUtils.property(thatLocator, "monetaryValue", rhsMonetaryValue), lhsMonetaryValue, rhsMonetaryValue, (this.monetaryValue!= null), (that.monetaryValue!= null))) {
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
            SchemeValuePair theCurrencyCode;
            theCurrencyCode = this.getCurrencyCode();
            strategy.appendField(locator, this, "currencyCode", buffer, theCurrencyCode, (this.currencyCode!= null));
        }
        {
            BigInteger theMonetaryValue;
            theMonetaryValue = this.getMonetaryValue();
            strategy.appendField(locator, this, "monetaryValue", buffer, theMonetaryValue, (this.monetaryValue!= null));
        }
        {
            Ext theExt;
            theExt = this.getExt();
            strategy.appendField(locator, this, "ext", buffer, theExt, (this.ext!= null));
        }
        return buffer;
    }

}
