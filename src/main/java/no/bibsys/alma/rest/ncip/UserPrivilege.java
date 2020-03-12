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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
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
 *         &lt;element ref="{http://www.niso.org/2008/ncip}AgencyId"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}AgencyUserPrivilegeType"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}ValidFromDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}ValidToDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}UserPrivilegeFee" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}UserPrivilegeStatus" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}UserPrivilegeDescription" minOccurs="0"/&gt;
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
    "agencyUserPrivilegeType",
    "validFromDate",
    "validToDate",
    "userPrivilegeFee",
    "userPrivilegeStatus",
    "userPrivilegeDescription",
    "ext"
})
@XmlRootElement(name = "UserPrivilege")
public class UserPrivilege implements Equals2, HashCode2, ToString2
{

    @XmlElement(name = "AgencyId", required = true)
    protected SchemeValuePair agencyId;
    @XmlElement(name = "AgencyUserPrivilegeType", required = true)
    protected SchemeValuePair agencyUserPrivilegeType;
    @XmlElement(name = "ValidFromDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validFromDate;
    @XmlElement(name = "ValidToDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validToDate;
    @XmlElement(name = "UserPrivilegeFee")
    protected UserPrivilegeFee userPrivilegeFee;
    @XmlElement(name = "UserPrivilegeStatus")
    protected UserPrivilegeStatus userPrivilegeStatus;
    @XmlElement(name = "UserPrivilegeDescription")
    protected String userPrivilegeDescription;
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
     * Gets the value of the agencyUserPrivilegeType property.
     * 
     * @return
     *     possible object is
     *     {@link SchemeValuePair }
     *     
     */
    public SchemeValuePair getAgencyUserPrivilegeType() {
        return agencyUserPrivilegeType;
    }

    /**
     * Sets the value of the agencyUserPrivilegeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemeValuePair }
     *     
     */
    public void setAgencyUserPrivilegeType(SchemeValuePair value) {
        this.agencyUserPrivilegeType = value;
    }

    /**
     * Gets the value of the validFromDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidFromDate() {
        return validFromDate;
    }

    /**
     * Sets the value of the validFromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidFromDate(XMLGregorianCalendar value) {
        this.validFromDate = value;
    }

    /**
     * Gets the value of the validToDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidToDate() {
        return validToDate;
    }

    /**
     * Sets the value of the validToDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidToDate(XMLGregorianCalendar value) {
        this.validToDate = value;
    }

    /**
     * Gets the value of the userPrivilegeFee property.
     * 
     * @return
     *     possible object is
     *     {@link UserPrivilegeFee }
     *     
     */
    public UserPrivilegeFee getUserPrivilegeFee() {
        return userPrivilegeFee;
    }

    /**
     * Sets the value of the userPrivilegeFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserPrivilegeFee }
     *     
     */
    public void setUserPrivilegeFee(UserPrivilegeFee value) {
        this.userPrivilegeFee = value;
    }

    /**
     * Gets the value of the userPrivilegeStatus property.
     * 
     * @return
     *     possible object is
     *     {@link UserPrivilegeStatus }
     *     
     */
    public UserPrivilegeStatus getUserPrivilegeStatus() {
        return userPrivilegeStatus;
    }

    /**
     * Sets the value of the userPrivilegeStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserPrivilegeStatus }
     *     
     */
    public void setUserPrivilegeStatus(UserPrivilegeStatus value) {
        this.userPrivilegeStatus = value;
    }

    /**
     * Gets the value of the userPrivilegeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPrivilegeDescription() {
        return userPrivilegeDescription;
    }

    /**
     * Sets the value of the userPrivilegeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPrivilegeDescription(String value) {
        this.userPrivilegeDescription = value;
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
            SchemeValuePair theAgencyUserPrivilegeType;
            theAgencyUserPrivilegeType = this.getAgencyUserPrivilegeType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "agencyUserPrivilegeType", theAgencyUserPrivilegeType), currentHashCode, theAgencyUserPrivilegeType, (this.agencyUserPrivilegeType!= null));
        }
        {
            XMLGregorianCalendar theValidFromDate;
            theValidFromDate = this.getValidFromDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validFromDate", theValidFromDate), currentHashCode, theValidFromDate, (this.validFromDate!= null));
        }
        {
            XMLGregorianCalendar theValidToDate;
            theValidToDate = this.getValidToDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validToDate", theValidToDate), currentHashCode, theValidToDate, (this.validToDate!= null));
        }
        {
            UserPrivilegeFee theUserPrivilegeFee;
            theUserPrivilegeFee = this.getUserPrivilegeFee();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userPrivilegeFee", theUserPrivilegeFee), currentHashCode, theUserPrivilegeFee, (this.userPrivilegeFee!= null));
        }
        {
            UserPrivilegeStatus theUserPrivilegeStatus;
            theUserPrivilegeStatus = this.getUserPrivilegeStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userPrivilegeStatus", theUserPrivilegeStatus), currentHashCode, theUserPrivilegeStatus, (this.userPrivilegeStatus!= null));
        }
        {
            String theUserPrivilegeDescription;
            theUserPrivilegeDescription = this.getUserPrivilegeDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userPrivilegeDescription", theUserPrivilegeDescription), currentHashCode, theUserPrivilegeDescription, (this.userPrivilegeDescription!= null));
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
        final UserPrivilege that = ((UserPrivilege) object);
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
            SchemeValuePair lhsAgencyUserPrivilegeType;
            lhsAgencyUserPrivilegeType = this.getAgencyUserPrivilegeType();
            SchemeValuePair rhsAgencyUserPrivilegeType;
            rhsAgencyUserPrivilegeType = that.getAgencyUserPrivilegeType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "agencyUserPrivilegeType", lhsAgencyUserPrivilegeType), LocatorUtils.property(thatLocator, "agencyUserPrivilegeType", rhsAgencyUserPrivilegeType), lhsAgencyUserPrivilegeType, rhsAgencyUserPrivilegeType, (this.agencyUserPrivilegeType!= null), (that.agencyUserPrivilegeType!= null))) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsValidFromDate;
            lhsValidFromDate = this.getValidFromDate();
            XMLGregorianCalendar rhsValidFromDate;
            rhsValidFromDate = that.getValidFromDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validFromDate", lhsValidFromDate), LocatorUtils.property(thatLocator, "validFromDate", rhsValidFromDate), lhsValidFromDate, rhsValidFromDate, (this.validFromDate!= null), (that.validFromDate!= null))) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsValidToDate;
            lhsValidToDate = this.getValidToDate();
            XMLGregorianCalendar rhsValidToDate;
            rhsValidToDate = that.getValidToDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validToDate", lhsValidToDate), LocatorUtils.property(thatLocator, "validToDate", rhsValidToDate), lhsValidToDate, rhsValidToDate, (this.validToDate!= null), (that.validToDate!= null))) {
                return false;
            }
        }
        {
            UserPrivilegeFee lhsUserPrivilegeFee;
            lhsUserPrivilegeFee = this.getUserPrivilegeFee();
            UserPrivilegeFee rhsUserPrivilegeFee;
            rhsUserPrivilegeFee = that.getUserPrivilegeFee();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userPrivilegeFee", lhsUserPrivilegeFee), LocatorUtils.property(thatLocator, "userPrivilegeFee", rhsUserPrivilegeFee), lhsUserPrivilegeFee, rhsUserPrivilegeFee, (this.userPrivilegeFee!= null), (that.userPrivilegeFee!= null))) {
                return false;
            }
        }
        {
            UserPrivilegeStatus lhsUserPrivilegeStatus;
            lhsUserPrivilegeStatus = this.getUserPrivilegeStatus();
            UserPrivilegeStatus rhsUserPrivilegeStatus;
            rhsUserPrivilegeStatus = that.getUserPrivilegeStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userPrivilegeStatus", lhsUserPrivilegeStatus), LocatorUtils.property(thatLocator, "userPrivilegeStatus", rhsUserPrivilegeStatus), lhsUserPrivilegeStatus, rhsUserPrivilegeStatus, (this.userPrivilegeStatus!= null), (that.userPrivilegeStatus!= null))) {
                return false;
            }
        }
        {
            String lhsUserPrivilegeDescription;
            lhsUserPrivilegeDescription = this.getUserPrivilegeDescription();
            String rhsUserPrivilegeDescription;
            rhsUserPrivilegeDescription = that.getUserPrivilegeDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userPrivilegeDescription", lhsUserPrivilegeDescription), LocatorUtils.property(thatLocator, "userPrivilegeDescription", rhsUserPrivilegeDescription), lhsUserPrivilegeDescription, rhsUserPrivilegeDescription, (this.userPrivilegeDescription!= null), (that.userPrivilegeDescription!= null))) {
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
            SchemeValuePair theAgencyUserPrivilegeType;
            theAgencyUserPrivilegeType = this.getAgencyUserPrivilegeType();
            strategy.appendField(locator, this, "agencyUserPrivilegeType", buffer, theAgencyUserPrivilegeType, (this.agencyUserPrivilegeType!= null));
        }
        {
            XMLGregorianCalendar theValidFromDate;
            theValidFromDate = this.getValidFromDate();
            strategy.appendField(locator, this, "validFromDate", buffer, theValidFromDate, (this.validFromDate!= null));
        }
        {
            XMLGregorianCalendar theValidToDate;
            theValidToDate = this.getValidToDate();
            strategy.appendField(locator, this, "validToDate", buffer, theValidToDate, (this.validToDate!= null));
        }
        {
            UserPrivilegeFee theUserPrivilegeFee;
            theUserPrivilegeFee = this.getUserPrivilegeFee();
            strategy.appendField(locator, this, "userPrivilegeFee", buffer, theUserPrivilegeFee, (this.userPrivilegeFee!= null));
        }
        {
            UserPrivilegeStatus theUserPrivilegeStatus;
            theUserPrivilegeStatus = this.getUserPrivilegeStatus();
            strategy.appendField(locator, this, "userPrivilegeStatus", buffer, theUserPrivilegeStatus, (this.userPrivilegeStatus!= null));
        }
        {
            String theUserPrivilegeDescription;
            theUserPrivilegeDescription = this.getUserPrivilegeDescription();
            strategy.appendField(locator, this, "userPrivilegeDescription", buffer, theUserPrivilegeDescription, (this.userPrivilegeDescription!= null));
        }
        {
            Ext theExt;
            theExt = this.getExt();
            strategy.appendField(locator, this, "ext", buffer, theExt, (this.ext!= null));
        }
        return buffer;
    }

}