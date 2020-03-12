//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:54:26 AM CET 
//


package no.bibsys.alma.rest.ncip;

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
 *         &lt;element ref="{http://www.niso.org/2008/ncip}AuthenticationInputType"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}AuthenticationDataFormatType"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}SensitiveDataFlag" minOccurs="0"/&gt;
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
    "authenticationInputType",
    "authenticationDataFormatType",
    "sensitiveDataFlag",
    "ext"
})
@XmlRootElement(name = "PromptInput")
public class PromptInput implements Equals2, HashCode2, ToString2
{

    @XmlElement(name = "AuthenticationInputType", required = true)
    protected SchemeValuePair authenticationInputType;
    @XmlElement(name = "AuthenticationDataFormatType", required = true)
    protected SchemeValuePair authenticationDataFormatType;
    @XmlElement(name = "SensitiveDataFlag")
    protected SensitiveDataFlag sensitiveDataFlag;
    @XmlElement(name = "Ext")
    protected Ext ext;

    /**
     * Gets the value of the authenticationInputType property.
     * 
     * @return
     *     possible object is
     *     {@link SchemeValuePair }
     *     
     */
    public SchemeValuePair getAuthenticationInputType() {
        return authenticationInputType;
    }

    /**
     * Sets the value of the authenticationInputType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemeValuePair }
     *     
     */
    public void setAuthenticationInputType(SchemeValuePair value) {
        this.authenticationInputType = value;
    }

    /**
     * Gets the value of the authenticationDataFormatType property.
     * 
     * @return
     *     possible object is
     *     {@link SchemeValuePair }
     *     
     */
    public SchemeValuePair getAuthenticationDataFormatType() {
        return authenticationDataFormatType;
    }

    /**
     * Sets the value of the authenticationDataFormatType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemeValuePair }
     *     
     */
    public void setAuthenticationDataFormatType(SchemeValuePair value) {
        this.authenticationDataFormatType = value;
    }

    /**
     * Gets the value of the sensitiveDataFlag property.
     * 
     * @return
     *     possible object is
     *     {@link SensitiveDataFlag }
     *     
     */
    public SensitiveDataFlag getSensitiveDataFlag() {
        return sensitiveDataFlag;
    }

    /**
     * Sets the value of the sensitiveDataFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link SensitiveDataFlag }
     *     
     */
    public void setSensitiveDataFlag(SensitiveDataFlag value) {
        this.sensitiveDataFlag = value;
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
            SchemeValuePair theAuthenticationInputType;
            theAuthenticationInputType = this.getAuthenticationInputType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "authenticationInputType", theAuthenticationInputType), currentHashCode, theAuthenticationInputType, (this.authenticationInputType!= null));
        }
        {
            SchemeValuePair theAuthenticationDataFormatType;
            theAuthenticationDataFormatType = this.getAuthenticationDataFormatType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "authenticationDataFormatType", theAuthenticationDataFormatType), currentHashCode, theAuthenticationDataFormatType, (this.authenticationDataFormatType!= null));
        }
        {
            SensitiveDataFlag theSensitiveDataFlag;
            theSensitiveDataFlag = this.getSensitiveDataFlag();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "sensitiveDataFlag", theSensitiveDataFlag), currentHashCode, theSensitiveDataFlag, (this.sensitiveDataFlag!= null));
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
        final PromptInput that = ((PromptInput) object);
        {
            SchemeValuePair lhsAuthenticationInputType;
            lhsAuthenticationInputType = this.getAuthenticationInputType();
            SchemeValuePair rhsAuthenticationInputType;
            rhsAuthenticationInputType = that.getAuthenticationInputType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "authenticationInputType", lhsAuthenticationInputType), LocatorUtils.property(thatLocator, "authenticationInputType", rhsAuthenticationInputType), lhsAuthenticationInputType, rhsAuthenticationInputType, (this.authenticationInputType!= null), (that.authenticationInputType!= null))) {
                return false;
            }
        }
        {
            SchemeValuePair lhsAuthenticationDataFormatType;
            lhsAuthenticationDataFormatType = this.getAuthenticationDataFormatType();
            SchemeValuePair rhsAuthenticationDataFormatType;
            rhsAuthenticationDataFormatType = that.getAuthenticationDataFormatType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "authenticationDataFormatType", lhsAuthenticationDataFormatType), LocatorUtils.property(thatLocator, "authenticationDataFormatType", rhsAuthenticationDataFormatType), lhsAuthenticationDataFormatType, rhsAuthenticationDataFormatType, (this.authenticationDataFormatType!= null), (that.authenticationDataFormatType!= null))) {
                return false;
            }
        }
        {
            SensitiveDataFlag lhsSensitiveDataFlag;
            lhsSensitiveDataFlag = this.getSensitiveDataFlag();
            SensitiveDataFlag rhsSensitiveDataFlag;
            rhsSensitiveDataFlag = that.getSensitiveDataFlag();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "sensitiveDataFlag", lhsSensitiveDataFlag), LocatorUtils.property(thatLocator, "sensitiveDataFlag", rhsSensitiveDataFlag), lhsSensitiveDataFlag, rhsSensitiveDataFlag, (this.sensitiveDataFlag!= null), (that.sensitiveDataFlag!= null))) {
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
            SchemeValuePair theAuthenticationInputType;
            theAuthenticationInputType = this.getAuthenticationInputType();
            strategy.appendField(locator, this, "authenticationInputType", buffer, theAuthenticationInputType, (this.authenticationInputType!= null));
        }
        {
            SchemeValuePair theAuthenticationDataFormatType;
            theAuthenticationDataFormatType = this.getAuthenticationDataFormatType();
            strategy.appendField(locator, this, "authenticationDataFormatType", buffer, theAuthenticationDataFormatType, (this.authenticationDataFormatType!= null));
        }
        {
            SensitiveDataFlag theSensitiveDataFlag;
            theSensitiveDataFlag = this.getSensitiveDataFlag();
            strategy.appendField(locator, this, "sensitiveDataFlag", buffer, theSensitiveDataFlag, (this.sensitiveDataFlag!= null));
        }
        {
            Ext theExt;
            theExt = this.getExt();
            strategy.appendField(locator, this, "ext", buffer, theExt, (this.ext!= null));
        }
        return buffer;
    }

}
