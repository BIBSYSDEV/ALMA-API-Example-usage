//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:27:55 AM CET 
//


package no.bibsys.alma.rest.holdings;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
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
 * Information for a specific Holding record
 * 
 * <p>Java class for holding complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="holding"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="holding_id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="library" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="location" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="call_number" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="accession_number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="suppress_from_publishing" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *       &lt;attribute name="link" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "holding", propOrder = {

})
public class Holding implements Serializable, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "holding_id", required = true)
    protected String holdingId;
    protected Library library;
    protected Location location;
    @XmlElement(name = "call_number", required = true)
    protected String callNumber;
    @XmlElement(name = "accession_number")
    protected String accessionNumber;
    @XmlElement(name = "suppress_from_publishing")
    protected String suppressFromPublishing;
    @XmlAttribute(name = "link")
    protected String link;

    /**
     * Gets the value of the holdingId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoldingId() {
        return holdingId;
    }

    /**
     * Sets the value of the holdingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoldingId(String value) {
        this.holdingId = value;
    }

    /**
     * Gets the value of the library property.
     * 
     * @return
     *     possible object is
     *     {@link Library }
     *     
     */
    public Library getLibrary() {
        return library;
    }

    /**
     * Sets the value of the library property.
     * 
     * @param value
     *     allowed object is
     *     {@link Library }
     *     
     */
    public void setLibrary(Library value) {
        this.library = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link Location }
     *     
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link Location }
     *     
     */
    public void setLocation(Location value) {
        this.location = value;
    }

    /**
     * Gets the value of the callNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallNumber() {
        return callNumber;
    }

    /**
     * Sets the value of the callNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallNumber(String value) {
        this.callNumber = value;
    }

    /**
     * Gets the value of the accessionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessionNumber() {
        return accessionNumber;
    }

    /**
     * Sets the value of the accessionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessionNumber(String value) {
        this.accessionNumber = value;
    }

    /**
     * Gets the value of the suppressFromPublishing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuppressFromPublishing() {
        return suppressFromPublishing;
    }

    /**
     * Sets the value of the suppressFromPublishing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuppressFromPublishing(String value) {
        this.suppressFromPublishing = value;
    }

    /**
     * Gets the value of the link property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the value of the link property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLink(String value) {
        this.link = value;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theHoldingId;
            theHoldingId = this.getHoldingId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "holdingId", theHoldingId), currentHashCode, theHoldingId, (this.holdingId!= null));
        }
        {
            Library theLibrary;
            theLibrary = this.getLibrary();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "library", theLibrary), currentHashCode, theLibrary, (this.library!= null));
        }
        {
            Location theLocation;
            theLocation = this.getLocation();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "location", theLocation), currentHashCode, theLocation, (this.location!= null));
        }
        {
            String theCallNumber;
            theCallNumber = this.getCallNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "callNumber", theCallNumber), currentHashCode, theCallNumber, (this.callNumber!= null));
        }
        {
            String theAccessionNumber;
            theAccessionNumber = this.getAccessionNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accessionNumber", theAccessionNumber), currentHashCode, theAccessionNumber, (this.accessionNumber!= null));
        }
        {
            String theSuppressFromPublishing;
            theSuppressFromPublishing = this.getSuppressFromPublishing();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "suppressFromPublishing", theSuppressFromPublishing), currentHashCode, theSuppressFromPublishing, (this.suppressFromPublishing!= null));
        }
        {
            String theLink;
            theLink = this.getLink();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "link", theLink), currentHashCode, theLink, (this.link!= null));
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
        final Holding that = ((Holding) object);
        {
            String lhsHoldingId;
            lhsHoldingId = this.getHoldingId();
            String rhsHoldingId;
            rhsHoldingId = that.getHoldingId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "holdingId", lhsHoldingId), LocatorUtils.property(thatLocator, "holdingId", rhsHoldingId), lhsHoldingId, rhsHoldingId, (this.holdingId!= null), (that.holdingId!= null))) {
                return false;
            }
        }
        {
            Library lhsLibrary;
            lhsLibrary = this.getLibrary();
            Library rhsLibrary;
            rhsLibrary = that.getLibrary();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "library", lhsLibrary), LocatorUtils.property(thatLocator, "library", rhsLibrary), lhsLibrary, rhsLibrary, (this.library!= null), (that.library!= null))) {
                return false;
            }
        }
        {
            Location lhsLocation;
            lhsLocation = this.getLocation();
            Location rhsLocation;
            rhsLocation = that.getLocation();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "location", lhsLocation), LocatorUtils.property(thatLocator, "location", rhsLocation), lhsLocation, rhsLocation, (this.location!= null), (that.location!= null))) {
                return false;
            }
        }
        {
            String lhsCallNumber;
            lhsCallNumber = this.getCallNumber();
            String rhsCallNumber;
            rhsCallNumber = that.getCallNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "callNumber", lhsCallNumber), LocatorUtils.property(thatLocator, "callNumber", rhsCallNumber), lhsCallNumber, rhsCallNumber, (this.callNumber!= null), (that.callNumber!= null))) {
                return false;
            }
        }
        {
            String lhsAccessionNumber;
            lhsAccessionNumber = this.getAccessionNumber();
            String rhsAccessionNumber;
            rhsAccessionNumber = that.getAccessionNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accessionNumber", lhsAccessionNumber), LocatorUtils.property(thatLocator, "accessionNumber", rhsAccessionNumber), lhsAccessionNumber, rhsAccessionNumber, (this.accessionNumber!= null), (that.accessionNumber!= null))) {
                return false;
            }
        }
        {
            String lhsSuppressFromPublishing;
            lhsSuppressFromPublishing = this.getSuppressFromPublishing();
            String rhsSuppressFromPublishing;
            rhsSuppressFromPublishing = that.getSuppressFromPublishing();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "suppressFromPublishing", lhsSuppressFromPublishing), LocatorUtils.property(thatLocator, "suppressFromPublishing", rhsSuppressFromPublishing), lhsSuppressFromPublishing, rhsSuppressFromPublishing, (this.suppressFromPublishing!= null), (that.suppressFromPublishing!= null))) {
                return false;
            }
        }
        {
            String lhsLink;
            lhsLink = this.getLink();
            String rhsLink;
            rhsLink = that.getLink();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "link", lhsLink), LocatorUtils.property(thatLocator, "link", rhsLink), lhsLink, rhsLink, (this.link!= null), (that.link!= null))) {
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
            String theHoldingId;
            theHoldingId = this.getHoldingId();
            strategy.appendField(locator, this, "holdingId", buffer, theHoldingId, (this.holdingId!= null));
        }
        {
            Library theLibrary;
            theLibrary = this.getLibrary();
            strategy.appendField(locator, this, "library", buffer, theLibrary, (this.library!= null));
        }
        {
            Location theLocation;
            theLocation = this.getLocation();
            strategy.appendField(locator, this, "location", buffer, theLocation, (this.location!= null));
        }
        {
            String theCallNumber;
            theCallNumber = this.getCallNumber();
            strategy.appendField(locator, this, "callNumber", buffer, theCallNumber, (this.callNumber!= null));
        }
        {
            String theAccessionNumber;
            theAccessionNumber = this.getAccessionNumber();
            strategy.appendField(locator, this, "accessionNumber", buffer, theAccessionNumber, (this.accessionNumber!= null));
        }
        {
            String theSuppressFromPublishing;
            theSuppressFromPublishing = this.getSuppressFromPublishing();
            strategy.appendField(locator, this, "suppressFromPublishing", buffer, theSuppressFromPublishing, (this.suppressFromPublishing!= null));
        }
        {
            String theLink;
            theLink = this.getLink();
            strategy.appendField(locator, this, "link", buffer, theLink, (this.link!= null));
        }
        return buffer;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Library implements Serializable, Equals2, HashCode2, ToString2
    {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "desc")
        protected String desc;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the desc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDesc() {
            return desc;
        }

        /**
         * Sets the value of the desc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDesc(String value) {
            this.desc = value;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
            int currentHashCode = 1;
            {
                String theValue;
                theValue = this.getValue();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "value", theValue), currentHashCode, theValue, (this.value!= null));
            }
            {
                String theDesc;
                theDesc = this.getDesc();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "desc", theDesc), currentHashCode, theDesc, (this.desc!= null));
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
            final Library that = ((Library) object);
            {
                String lhsValue;
                lhsValue = this.getValue();
                String rhsValue;
                rhsValue = that.getValue();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "value", lhsValue), LocatorUtils.property(thatLocator, "value", rhsValue), lhsValue, rhsValue, (this.value!= null), (that.value!= null))) {
                    return false;
                }
            }
            {
                String lhsDesc;
                lhsDesc = this.getDesc();
                String rhsDesc;
                rhsDesc = that.getDesc();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "desc", lhsDesc), LocatorUtils.property(thatLocator, "desc", rhsDesc), lhsDesc, rhsDesc, (this.desc!= null), (that.desc!= null))) {
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
                String theValue;
                theValue = this.getValue();
                strategy.appendField(locator, this, "value", buffer, theValue, (this.value!= null));
            }
            {
                String theDesc;
                theDesc = this.getDesc();
                strategy.appendField(locator, this, "desc", buffer, theDesc, (this.desc!= null));
            }
            return buffer;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Location implements Serializable, Equals2, HashCode2, ToString2
    {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "desc")
        protected String desc;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the desc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDesc() {
            return desc;
        }

        /**
         * Sets the value of the desc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDesc(String value) {
            this.desc = value;
        }

        public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
            int currentHashCode = 1;
            {
                String theValue;
                theValue = this.getValue();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "value", theValue), currentHashCode, theValue, (this.value!= null));
            }
            {
                String theDesc;
                theDesc = this.getDesc();
                currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "desc", theDesc), currentHashCode, theDesc, (this.desc!= null));
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
            final Location that = ((Location) object);
            {
                String lhsValue;
                lhsValue = this.getValue();
                String rhsValue;
                rhsValue = that.getValue();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "value", lhsValue), LocatorUtils.property(thatLocator, "value", rhsValue), lhsValue, rhsValue, (this.value!= null), (that.value!= null))) {
                    return false;
                }
            }
            {
                String lhsDesc;
                lhsDesc = this.getDesc();
                String rhsDesc;
                rhsDesc = that.getDesc();
                if (!strategy.equals(LocatorUtils.property(thisLocator, "desc", lhsDesc), LocatorUtils.property(thatLocator, "desc", rhsDesc), lhsDesc, rhsDesc, (this.desc!= null), (that.desc!= null))) {
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
                String theValue;
                theValue = this.getValue();
                strategy.appendField(locator, this, "value", buffer, theValue, (this.value!= null));
            }
            {
                String theDesc;
                theDesc = this.getDesc();
                strategy.appendField(locator, this, "desc", buffer, theDesc, (this.desc!= null));
            }
            return buffer;
        }

    }

}