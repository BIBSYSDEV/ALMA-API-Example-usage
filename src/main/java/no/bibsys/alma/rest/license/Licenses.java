//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:28:08 AM CET 
//


package no.bibsys.alma.rest.license;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 * A list of licenses.
 * 
 * <p>Java class for licenses complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="licenses"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="license" type="{}license" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="total_record_count" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "licenses", propOrder = {
    "license"
})
@XmlRootElement(name = "licenses")
public class Licenses implements Serializable, Equals2, HashCode2, ToString2
{

    protected List<License> license;
    @XmlAttribute(name = "total_record_count")
    protected Integer totalRecordCount;

    /**
     * Gets the value of the license property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the license property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLicense().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link License }
     * 
     * 
     */
    public List<License> getLicense() {
        if (license == null) {
            license = new ArrayList<License>();
        }
        return this.license;
    }

    /**
     * Gets the value of the totalRecordCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalRecordCount() {
        return totalRecordCount;
    }

    /**
     * Sets the value of the totalRecordCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalRecordCount(Integer value) {
        this.totalRecordCount = value;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<License> theLicense;
            theLicense = (((this.license!= null)&&(!this.license.isEmpty()))?this.getLicense():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "license", theLicense), currentHashCode, theLicense, ((this.license!= null)&&(!this.license.isEmpty())));
        }
        {
            Integer theTotalRecordCount;
            theTotalRecordCount = this.getTotalRecordCount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "totalRecordCount", theTotalRecordCount), currentHashCode, theTotalRecordCount, (this.totalRecordCount!= null));
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
        final Licenses that = ((Licenses) object);
        {
            List<License> lhsLicense;
            lhsLicense = (((this.license!= null)&&(!this.license.isEmpty()))?this.getLicense():null);
            List<License> rhsLicense;
            rhsLicense = (((that.license!= null)&&(!that.license.isEmpty()))?that.getLicense():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "license", lhsLicense), LocatorUtils.property(thatLocator, "license", rhsLicense), lhsLicense, rhsLicense, ((this.license!= null)&&(!this.license.isEmpty())), ((that.license!= null)&&(!that.license.isEmpty())))) {
                return false;
            }
        }
        {
            Integer lhsTotalRecordCount;
            lhsTotalRecordCount = this.getTotalRecordCount();
            Integer rhsTotalRecordCount;
            rhsTotalRecordCount = that.getTotalRecordCount();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "totalRecordCount", lhsTotalRecordCount), LocatorUtils.property(thatLocator, "totalRecordCount", rhsTotalRecordCount), lhsTotalRecordCount, rhsTotalRecordCount, (this.totalRecordCount!= null), (that.totalRecordCount!= null))) {
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
            List<License> theLicense;
            theLicense = (((this.license!= null)&&(!this.license.isEmpty()))?this.getLicense():null);
            strategy.appendField(locator, this, "license", buffer, theLicense, ((this.license!= null)&&(!this.license.isEmpty())));
        }
        {
            Integer theTotalRecordCount;
            theTotalRecordCount = this.getTotalRecordCount();
            strategy.appendField(locator, this, "totalRecordCount", buffer, theTotalRecordCount, (this.totalRecordCount!= null));
        }
        return buffer;
    }

}
