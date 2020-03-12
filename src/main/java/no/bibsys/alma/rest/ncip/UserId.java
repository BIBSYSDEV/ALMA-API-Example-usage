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
 *         &lt;element ref="{http://www.niso.org/2008/ncip}AgencyId" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}UserIdentifierType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}UserIdentifierValue"/&gt;
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
    "agencyId",
    "userIdentifierType",
    "userIdentifierValue",
    "ext"
})
@XmlRootElement(name = "UserId")
public class UserId implements Equals2, HashCode2, ToString2
{

    @XmlElement(name = "AgencyId")
    protected SchemeValuePair agencyId;
    @XmlElement(name = "UserIdentifierType")
    protected SchemeValuePair userIdentifierType;
    @XmlElement(name = "UserIdentifierValue", required = true)
    protected String userIdentifierValue;
    @XmlElement(name = "Ext")
    protected Ext ext;

    /**
     * Gets the value of the agencyId property.
     * 
     * @return
     *     possible object is
     *     {@link SchemeValuePair }
     *     
     */
    public SchemeValuePair getAgencyId() {
        return agencyId;
    }

    /**
     * Sets the value of the agencyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemeValuePair }
     *     
     */
    public void setAgencyId(SchemeValuePair value) {
        this.agencyId = value;
    }

    /**
     * Gets the value of the userIdentifierType property.
     * 
     * @return
     *     possible object is
     *     {@link SchemeValuePair }
     *     
     */
    public SchemeValuePair getUserIdentifierType() {
        return userIdentifierType;
    }

    /**
     * Sets the value of the userIdentifierType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemeValuePair }
     *     
     */
    public void setUserIdentifierType(SchemeValuePair value) {
        this.userIdentifierType = value;
    }

    /**
     * Gets the value of the userIdentifierValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserIdentifierValue() {
        return userIdentifierValue;
    }

    /**
     * Sets the value of the userIdentifierValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserIdentifierValue(String value) {
        this.userIdentifierValue = value;
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
            SchemeValuePair theAgencyId;
            theAgencyId = this.getAgencyId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "agencyId", theAgencyId), currentHashCode, theAgencyId, (this.agencyId!= null));
        }
        {
            SchemeValuePair theUserIdentifierType;
            theUserIdentifierType = this.getUserIdentifierType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userIdentifierType", theUserIdentifierType), currentHashCode, theUserIdentifierType, (this.userIdentifierType!= null));
        }
        {
            String theUserIdentifierValue;
            theUserIdentifierValue = this.getUserIdentifierValue();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userIdentifierValue", theUserIdentifierValue), currentHashCode, theUserIdentifierValue, (this.userIdentifierValue!= null));
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
        final UserId that = ((UserId) object);
        {
            SchemeValuePair lhsAgencyId;
            lhsAgencyId = this.getAgencyId();
            SchemeValuePair rhsAgencyId;
            rhsAgencyId = that.getAgencyId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "agencyId", lhsAgencyId), LocatorUtils.property(thatLocator, "agencyId", rhsAgencyId), lhsAgencyId, rhsAgencyId, (this.agencyId!= null), (that.agencyId!= null))) {
                return false;
            }
        }
        {
            SchemeValuePair lhsUserIdentifierType;
            lhsUserIdentifierType = this.getUserIdentifierType();
            SchemeValuePair rhsUserIdentifierType;
            rhsUserIdentifierType = that.getUserIdentifierType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userIdentifierType", lhsUserIdentifierType), LocatorUtils.property(thatLocator, "userIdentifierType", rhsUserIdentifierType), lhsUserIdentifierType, rhsUserIdentifierType, (this.userIdentifierType!= null), (that.userIdentifierType!= null))) {
                return false;
            }
        }
        {
            String lhsUserIdentifierValue;
            lhsUserIdentifierValue = this.getUserIdentifierValue();
            String rhsUserIdentifierValue;
            rhsUserIdentifierValue = that.getUserIdentifierValue();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userIdentifierValue", lhsUserIdentifierValue), LocatorUtils.property(thatLocator, "userIdentifierValue", rhsUserIdentifierValue), lhsUserIdentifierValue, rhsUserIdentifierValue, (this.userIdentifierValue!= null), (that.userIdentifierValue!= null))) {
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
            SchemeValuePair theAgencyId;
            theAgencyId = this.getAgencyId();
            strategy.appendField(locator, this, "agencyId", buffer, theAgencyId, (this.agencyId!= null));
        }
        {
            SchemeValuePair theUserIdentifierType;
            theUserIdentifierType = this.getUserIdentifierType();
            strategy.appendField(locator, this, "userIdentifierType", buffer, theUserIdentifierType, (this.userIdentifierType!= null));
        }
        {
            String theUserIdentifierValue;
            theUserIdentifierValue = this.getUserIdentifierValue();
            strategy.appendField(locator, this, "userIdentifierValue", buffer, theUserIdentifierValue, (this.userIdentifierValue!= null));
        }
        {
            Ext theExt;
            theExt = this.getExt();
            strategy.appendField(locator, this, "ext", buffer, theExt, (this.ext!= null));
        }
        return buffer;
    }

}
