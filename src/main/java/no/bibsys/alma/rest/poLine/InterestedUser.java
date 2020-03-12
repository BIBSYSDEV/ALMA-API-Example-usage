//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:28:10 AM CET 
//


package no.bibsys.alma.rest.poLine;

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
 * Specific user to be annotated.
 * 
 * <p>Java class for interested_user complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="interested_user"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="primary_id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="notify_receiving_activation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="hold_item" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="notify_renewal" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="notify_cancel" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="first_name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="last_name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "interested_user", propOrder = {

})
public class InterestedUser implements Serializable, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "primary_id", required = true)
    protected String primaryId;
    @XmlElement(name = "notify_receiving_activation")
    protected Boolean notifyReceivingActivation;
    @XmlElement(name = "hold_item")
    protected Boolean holdItem;
    @XmlElement(name = "notify_renewal")
    protected Boolean notifyRenewal;
    @XmlElement(name = "notify_cancel")
    protected Boolean notifyCancel;
    @XmlElement(name = "first_name", required = true)
    protected String firstName;
    @XmlElement(name = "last_name", required = true)
    protected String lastName;
    @XmlElement(required = true)
    protected String email;

    /**
     * Gets the value of the primaryId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryId() {
        return primaryId;
    }

    /**
     * Sets the value of the primaryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryId(String value) {
        this.primaryId = value;
    }

    /**
     * Gets the value of the notifyReceivingActivation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotifyReceivingActivation() {
        return notifyReceivingActivation;
    }

    /**
     * Sets the value of the notifyReceivingActivation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotifyReceivingActivation(Boolean value) {
        this.notifyReceivingActivation = value;
    }

    /**
     * Gets the value of the holdItem property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHoldItem() {
        return holdItem;
    }

    /**
     * Sets the value of the holdItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHoldItem(Boolean value) {
        this.holdItem = value;
    }

    /**
     * Gets the value of the notifyRenewal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotifyRenewal() {
        return notifyRenewal;
    }

    /**
     * Sets the value of the notifyRenewal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotifyRenewal(Boolean value) {
        this.notifyRenewal = value;
    }

    /**
     * Gets the value of the notifyCancel property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotifyCancel() {
        return notifyCancel;
    }

    /**
     * Sets the value of the notifyCancel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotifyCancel(Boolean value) {
        this.notifyCancel = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String thePrimaryId;
            thePrimaryId = this.getPrimaryId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "primaryId", thePrimaryId), currentHashCode, thePrimaryId, (this.primaryId!= null));
        }
        {
            Boolean theNotifyReceivingActivation;
            theNotifyReceivingActivation = this.isNotifyReceivingActivation();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "notifyReceivingActivation", theNotifyReceivingActivation), currentHashCode, theNotifyReceivingActivation, (this.notifyReceivingActivation!= null));
        }
        {
            Boolean theHoldItem;
            theHoldItem = this.isHoldItem();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "holdItem", theHoldItem), currentHashCode, theHoldItem, (this.holdItem!= null));
        }
        {
            Boolean theNotifyRenewal;
            theNotifyRenewal = this.isNotifyRenewal();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "notifyRenewal", theNotifyRenewal), currentHashCode, theNotifyRenewal, (this.notifyRenewal!= null));
        }
        {
            Boolean theNotifyCancel;
            theNotifyCancel = this.isNotifyCancel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "notifyCancel", theNotifyCancel), currentHashCode, theNotifyCancel, (this.notifyCancel!= null));
        }
        {
            String theFirstName;
            theFirstName = this.getFirstName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "firstName", theFirstName), currentHashCode, theFirstName, (this.firstName!= null));
        }
        {
            String theLastName;
            theLastName = this.getLastName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lastName", theLastName), currentHashCode, theLastName, (this.lastName!= null));
        }
        {
            String theEmail;
            theEmail = this.getEmail();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "email", theEmail), currentHashCode, theEmail, (this.email!= null));
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
        final InterestedUser that = ((InterestedUser) object);
        {
            String lhsPrimaryId;
            lhsPrimaryId = this.getPrimaryId();
            String rhsPrimaryId;
            rhsPrimaryId = that.getPrimaryId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "primaryId", lhsPrimaryId), LocatorUtils.property(thatLocator, "primaryId", rhsPrimaryId), lhsPrimaryId, rhsPrimaryId, (this.primaryId!= null), (that.primaryId!= null))) {
                return false;
            }
        }
        {
            Boolean lhsNotifyReceivingActivation;
            lhsNotifyReceivingActivation = this.isNotifyReceivingActivation();
            Boolean rhsNotifyReceivingActivation;
            rhsNotifyReceivingActivation = that.isNotifyReceivingActivation();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "notifyReceivingActivation", lhsNotifyReceivingActivation), LocatorUtils.property(thatLocator, "notifyReceivingActivation", rhsNotifyReceivingActivation), lhsNotifyReceivingActivation, rhsNotifyReceivingActivation, (this.notifyReceivingActivation!= null), (that.notifyReceivingActivation!= null))) {
                return false;
            }
        }
        {
            Boolean lhsHoldItem;
            lhsHoldItem = this.isHoldItem();
            Boolean rhsHoldItem;
            rhsHoldItem = that.isHoldItem();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "holdItem", lhsHoldItem), LocatorUtils.property(thatLocator, "holdItem", rhsHoldItem), lhsHoldItem, rhsHoldItem, (this.holdItem!= null), (that.holdItem!= null))) {
                return false;
            }
        }
        {
            Boolean lhsNotifyRenewal;
            lhsNotifyRenewal = this.isNotifyRenewal();
            Boolean rhsNotifyRenewal;
            rhsNotifyRenewal = that.isNotifyRenewal();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "notifyRenewal", lhsNotifyRenewal), LocatorUtils.property(thatLocator, "notifyRenewal", rhsNotifyRenewal), lhsNotifyRenewal, rhsNotifyRenewal, (this.notifyRenewal!= null), (that.notifyRenewal!= null))) {
                return false;
            }
        }
        {
            Boolean lhsNotifyCancel;
            lhsNotifyCancel = this.isNotifyCancel();
            Boolean rhsNotifyCancel;
            rhsNotifyCancel = that.isNotifyCancel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "notifyCancel", lhsNotifyCancel), LocatorUtils.property(thatLocator, "notifyCancel", rhsNotifyCancel), lhsNotifyCancel, rhsNotifyCancel, (this.notifyCancel!= null), (that.notifyCancel!= null))) {
                return false;
            }
        }
        {
            String lhsFirstName;
            lhsFirstName = this.getFirstName();
            String rhsFirstName;
            rhsFirstName = that.getFirstName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "firstName", lhsFirstName), LocatorUtils.property(thatLocator, "firstName", rhsFirstName), lhsFirstName, rhsFirstName, (this.firstName!= null), (that.firstName!= null))) {
                return false;
            }
        }
        {
            String lhsLastName;
            lhsLastName = this.getLastName();
            String rhsLastName;
            rhsLastName = that.getLastName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lastName", lhsLastName), LocatorUtils.property(thatLocator, "lastName", rhsLastName), lhsLastName, rhsLastName, (this.lastName!= null), (that.lastName!= null))) {
                return false;
            }
        }
        {
            String lhsEmail;
            lhsEmail = this.getEmail();
            String rhsEmail;
            rhsEmail = that.getEmail();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "email", lhsEmail), LocatorUtils.property(thatLocator, "email", rhsEmail), lhsEmail, rhsEmail, (this.email!= null), (that.email!= null))) {
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
            String thePrimaryId;
            thePrimaryId = this.getPrimaryId();
            strategy.appendField(locator, this, "primaryId", buffer, thePrimaryId, (this.primaryId!= null));
        }
        {
            Boolean theNotifyReceivingActivation;
            theNotifyReceivingActivation = this.isNotifyReceivingActivation();
            strategy.appendField(locator, this, "notifyReceivingActivation", buffer, theNotifyReceivingActivation, (this.notifyReceivingActivation!= null));
        }
        {
            Boolean theHoldItem;
            theHoldItem = this.isHoldItem();
            strategy.appendField(locator, this, "holdItem", buffer, theHoldItem, (this.holdItem!= null));
        }
        {
            Boolean theNotifyRenewal;
            theNotifyRenewal = this.isNotifyRenewal();
            strategy.appendField(locator, this, "notifyRenewal", buffer, theNotifyRenewal, (this.notifyRenewal!= null));
        }
        {
            Boolean theNotifyCancel;
            theNotifyCancel = this.isNotifyCancel();
            strategy.appendField(locator, this, "notifyCancel", buffer, theNotifyCancel, (this.notifyCancel!= null));
        }
        {
            String theFirstName;
            theFirstName = this.getFirstName();
            strategy.appendField(locator, this, "firstName", buffer, theFirstName, (this.firstName!= null));
        }
        {
            String theLastName;
            theLastName = this.getLastName();
            strategy.appendField(locator, this, "lastName", buffer, theLastName, (this.lastName!= null));
        }
        {
            String theEmail;
            theEmail = this.getEmail();
            strategy.appendField(locator, this, "email", buffer, theEmail, (this.email!= null));
        }
        return buffer;
    }

}
