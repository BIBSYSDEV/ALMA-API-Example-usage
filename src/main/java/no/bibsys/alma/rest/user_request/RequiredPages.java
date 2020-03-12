//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:28:02 AM CET 
//


package no.bibsys.alma.rest.user_request;

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
 * The pages required for the digitization.
 * 
 * <p>Java class for required_pages complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="required_pages"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="required_pages_range" type="{}page_range" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "required_pages", propOrder = {
    "requiredPagesRange"
})
public class RequiredPages implements Serializable, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "required_pages_range")
    protected List<PageRange> requiredPagesRange;

    /**
     * Gets the value of the requiredPagesRange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requiredPagesRange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequiredPagesRange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PageRange }
     * 
     * 
     */
    public List<PageRange> getRequiredPagesRange() {
        if (requiredPagesRange == null) {
            requiredPagesRange = new ArrayList<PageRange>();
        }
        return this.requiredPagesRange;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<PageRange> theRequiredPagesRange;
            theRequiredPagesRange = (((this.requiredPagesRange!= null)&&(!this.requiredPagesRange.isEmpty()))?this.getRequiredPagesRange():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "requiredPagesRange", theRequiredPagesRange), currentHashCode, theRequiredPagesRange, ((this.requiredPagesRange!= null)&&(!this.requiredPagesRange.isEmpty())));
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
        final RequiredPages that = ((RequiredPages) object);
        {
            List<PageRange> lhsRequiredPagesRange;
            lhsRequiredPagesRange = (((this.requiredPagesRange!= null)&&(!this.requiredPagesRange.isEmpty()))?this.getRequiredPagesRange():null);
            List<PageRange> rhsRequiredPagesRange;
            rhsRequiredPagesRange = (((that.requiredPagesRange!= null)&&(!that.requiredPagesRange.isEmpty()))?that.getRequiredPagesRange():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "requiredPagesRange", lhsRequiredPagesRange), LocatorUtils.property(thatLocator, "requiredPagesRange", rhsRequiredPagesRange), lhsRequiredPagesRange, rhsRequiredPagesRange, ((this.requiredPagesRange!= null)&&(!this.requiredPagesRange.isEmpty())), ((that.requiredPagesRange!= null)&&(!that.requiredPagesRange.isEmpty())))) {
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
            List<PageRange> theRequiredPagesRange;
            theRequiredPagesRange = (((this.requiredPagesRange!= null)&&(!this.requiredPagesRange.isEmpty()))?this.getRequiredPagesRange():null);
            strategy.appendField(locator, this, "requiredPagesRange", buffer, theRequiredPagesRange, ((this.requiredPagesRange!= null)&&(!this.requiredPagesRange.isEmpty())));
        }
        return buffer;
    }

}