//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:27:57 AM CET 
//


package no.bibsys.alma.rest.items;

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
 * <p>Java class for parsed_call_number complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="parsed_call_number"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="call_no" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parsed_call_number", propOrder = {
    "callNo"
})
public class ParsedCallNumber implements Serializable, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "call_no")
    protected List<String> callNo;

    /**
     * Gets the value of the callNo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the callNo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCallNo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCallNo() {
        if (callNo == null) {
            callNo = new ArrayList<String>();
        }
        return this.callNo;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<String> theCallNo;
            theCallNo = (((this.callNo!= null)&&(!this.callNo.isEmpty()))?this.getCallNo():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "callNo", theCallNo), currentHashCode, theCallNo, ((this.callNo!= null)&&(!this.callNo.isEmpty())));
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
        final ParsedCallNumber that = ((ParsedCallNumber) object);
        {
            List<String> lhsCallNo;
            lhsCallNo = (((this.callNo!= null)&&(!this.callNo.isEmpty()))?this.getCallNo():null);
            List<String> rhsCallNo;
            rhsCallNo = (((that.callNo!= null)&&(!that.callNo.isEmpty()))?that.getCallNo():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "callNo", lhsCallNo), LocatorUtils.property(thatLocator, "callNo", rhsCallNo), lhsCallNo, rhsCallNo, ((this.callNo!= null)&&(!this.callNo.isEmpty())), ((that.callNo!= null)&&(!that.callNo.isEmpty())))) {
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
            List<String> theCallNo;
            theCallNo = (((this.callNo!= null)&&(!this.callNo.isEmpty()))?this.getCallNo():null);
            strategy.appendField(locator, this, "callNo", buffer, theCallNo, ((this.callNo!= null)&&(!this.callNo.isEmpty())));
        }
        return buffer;
    }

}