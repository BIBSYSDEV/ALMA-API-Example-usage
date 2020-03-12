//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:28:10 AM CET 
//


package no.bibsys.alma.rest.poLine;

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
 * List of users to be annotated.
 * With PUT if not sent will preserve the existing users.
 * 			
 * 
 * <p>Java class for interested_users complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="interested_users"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="interested_user" type="{}interested_user" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "interested_users", propOrder = {
    "interestedUser"
})
public class InterestedUsers implements Serializable, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "interested_user")
    protected List<InterestedUser> interestedUser;

    /**
     * Gets the value of the interestedUser property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interestedUser property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInterestedUser().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InterestedUser }
     * 
     * 
     */
    public List<InterestedUser> getInterestedUser() {
        if (interestedUser == null) {
            interestedUser = new ArrayList<InterestedUser>();
        }
        return this.interestedUser;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<InterestedUser> theInterestedUser;
            theInterestedUser = (((this.interestedUser!= null)&&(!this.interestedUser.isEmpty()))?this.getInterestedUser():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "interestedUser", theInterestedUser), currentHashCode, theInterestedUser, ((this.interestedUser!= null)&&(!this.interestedUser.isEmpty())));
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
        final InterestedUsers that = ((InterestedUsers) object);
        {
            List<InterestedUser> lhsInterestedUser;
            lhsInterestedUser = (((this.interestedUser!= null)&&(!this.interestedUser.isEmpty()))?this.getInterestedUser():null);
            List<InterestedUser> rhsInterestedUser;
            rhsInterestedUser = (((that.interestedUser!= null)&&(!that.interestedUser.isEmpty()))?that.getInterestedUser():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "interestedUser", lhsInterestedUser), LocatorUtils.property(thatLocator, "interestedUser", rhsInterestedUser), lhsInterestedUser, rhsInterestedUser, ((this.interestedUser!= null)&&(!this.interestedUser.isEmpty())), ((that.interestedUser!= null)&&(!that.interestedUser.isEmpty())))) {
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
            List<InterestedUser> theInterestedUser;
            theInterestedUser = (((this.interestedUser!= null)&&(!this.interestedUser.isEmpty()))?this.getInterestedUser():null);
            strategy.appendField(locator, this, "interestedUser", buffer, theInterestedUser, ((this.interestedUser!= null)&&(!this.interestedUser.isEmpty())));
        }
        return buffer;
    }

}
