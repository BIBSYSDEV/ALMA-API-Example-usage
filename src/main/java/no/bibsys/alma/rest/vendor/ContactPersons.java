//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:28:14 AM CET 
//


package no.bibsys.alma.rest.vendor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for contact_persons complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contact_persons"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="contact_person" type="{}contact_person" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contact_persons", propOrder = {
    "contactPerson"
})
public class ContactPersons implements Serializable, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "contact_person", required = true)
    protected List<ContactPerson> contactPerson;

    /**
     * Gets the value of the contactPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContactPerson }
     * 
     * 
     */
    public List<ContactPerson> getContactPerson() {
        if (contactPerson == null) {
            contactPerson = new ArrayList<ContactPerson>();
        }
        return this.contactPerson;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<ContactPerson> theContactPerson;
            theContactPerson = (((this.contactPerson!= null)&&(!this.contactPerson.isEmpty()))?this.getContactPerson():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contactPerson", theContactPerson), currentHashCode, theContactPerson, ((this.contactPerson!= null)&&(!this.contactPerson.isEmpty())));
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
        final ContactPersons that = ((ContactPersons) object);
        {
            List<ContactPerson> lhsContactPerson;
            lhsContactPerson = (((this.contactPerson!= null)&&(!this.contactPerson.isEmpty()))?this.getContactPerson():null);
            List<ContactPerson> rhsContactPerson;
            rhsContactPerson = (((that.contactPerson!= null)&&(!that.contactPerson.isEmpty()))?that.getContactPerson():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contactPerson", lhsContactPerson), LocatorUtils.property(thatLocator, "contactPerson", rhsContactPerson), lhsContactPerson, rhsContactPerson, ((this.contactPerson!= null)&&(!this.contactPerson.isEmpty())), ((that.contactPerson!= null)&&(!that.contactPerson.isEmpty())))) {
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
            List<ContactPerson> theContactPerson;
            theContactPerson = (((this.contactPerson!= null)&&(!this.contactPerson.isEmpty()))?this.getContactPerson():null);
            strategy.appendField(locator, this, "contactPerson", buffer, theContactPerson, ((this.contactPerson!= null)&&(!this.contactPerson.isEmpty())));
        }
        return buffer;
    }

}