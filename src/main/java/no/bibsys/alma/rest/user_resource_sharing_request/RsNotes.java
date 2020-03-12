//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:28:13 AM CET 
//


package no.bibsys.alma.rest.user_resource_sharing_request;

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
 * 
 * List of related notes that appear in the Notes tab in the UI..
 * 			
 * 
 * <p>Java class for rs_notes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rs_notes"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rs_note" type="{}rs_note" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rs_notes", propOrder = {
    "rsNote"
})
public class RsNotes implements Serializable, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "rs_note")
    protected List<RsNote> rsNote;

    /**
     * Gets the value of the rsNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rsNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRsNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RsNote }
     * 
     * 
     */
    public List<RsNote> getRsNote() {
        if (rsNote == null) {
            rsNote = new ArrayList<RsNote>();
        }
        return this.rsNote;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            List<RsNote> theRsNote;
            theRsNote = (((this.rsNote!= null)&&(!this.rsNote.isEmpty()))?this.getRsNote():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "rsNote", theRsNote), currentHashCode, theRsNote, ((this.rsNote!= null)&&(!this.rsNote.isEmpty())));
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
        final RsNotes that = ((RsNotes) object);
        {
            List<RsNote> lhsRsNote;
            lhsRsNote = (((this.rsNote!= null)&&(!this.rsNote.isEmpty()))?this.getRsNote():null);
            List<RsNote> rhsRsNote;
            rhsRsNote = (((that.rsNote!= null)&&(!that.rsNote.isEmpty()))?that.getRsNote():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "rsNote", lhsRsNote), LocatorUtils.property(thatLocator, "rsNote", rhsRsNote), lhsRsNote, rhsRsNote, ((this.rsNote!= null)&&(!this.rsNote.isEmpty())), ((that.rsNote!= null)&&(!that.rsNote.isEmpty())))) {
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
            List<RsNote> theRsNote;
            theRsNote = (((this.rsNote!= null)&&(!this.rsNote.isEmpty()))?this.getRsNote():null);
            strategy.appendField(locator, this, "rsNote", buffer, theRsNote, ((this.rsNote!= null)&&(!this.rsNote.isEmpty())));
        }
        return buffer;
    }

}