//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:27:57 AM CET 
//


package no.bibsys.alma.rest.items;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 * Bibliographic data of the Physical Item. Output parameter.
 * 
 * <p>Java class for bib_data complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bib_data"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="mms_id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="issn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isbn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="complete_edition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="network_numbers" type="{}network_numbers" minOccurs="0"/&gt;
 *         &lt;element name="place_of_publication" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="date_of_publication" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="publisher_const" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "bib_data", propOrder = {

})
public class BibData implements Serializable, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "mms_id", required = true)
    protected String mmsId;
    protected String title;
    protected String author;
    protected String issn;
    protected String isbn;
    @XmlElement(name = "complete_edition")
    protected String completeEdition;
    @XmlElement(name = "network_numbers")
    protected NetworkNumbers networkNumbers;
    @XmlElement(name = "place_of_publication")
    protected String placeOfPublication;
    @XmlElement(name = "date_of_publication")
    protected String dateOfPublication;
    @XmlElement(name = "publisher_const")
    protected String publisherConst;
    @XmlAttribute(name = "link")
    protected String link;

    /**
     * Gets the value of the mmsId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMmsId() {
        return mmsId;
    }

    /**
     * Sets the value of the mmsId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMmsId(String value) {
        this.mmsId = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the issn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssn() {
        return issn;
    }

    /**
     * Sets the value of the issn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssn(String value) {
        this.issn = value;
    }

    /**
     * Gets the value of the isbn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the value of the isbn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsbn(String value) {
        this.isbn = value;
    }

    /**
     * Gets the value of the completeEdition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompleteEdition() {
        return completeEdition;
    }

    /**
     * Sets the value of the completeEdition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompleteEdition(String value) {
        this.completeEdition = value;
    }

    /**
     * Gets the value of the networkNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkNumbers }
     *     
     */
    public NetworkNumbers getNetworkNumbers() {
        return networkNumbers;
    }

    /**
     * Sets the value of the networkNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkNumbers }
     *     
     */
    public void setNetworkNumbers(NetworkNumbers value) {
        this.networkNumbers = value;
    }

    /**
     * Gets the value of the placeOfPublication property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceOfPublication() {
        return placeOfPublication;
    }

    /**
     * Sets the value of the placeOfPublication property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceOfPublication(String value) {
        this.placeOfPublication = value;
    }

    /**
     * Gets the value of the dateOfPublication property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfPublication() {
        return dateOfPublication;
    }

    /**
     * Sets the value of the dateOfPublication property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfPublication(String value) {
        this.dateOfPublication = value;
    }

    /**
     * Gets the value of the publisherConst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublisherConst() {
        return publisherConst;
    }

    /**
     * Sets the value of the publisherConst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublisherConst(String value) {
        this.publisherConst = value;
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
            String theMmsId;
            theMmsId = this.getMmsId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mmsId", theMmsId), currentHashCode, theMmsId, (this.mmsId!= null));
        }
        {
            String theTitle;
            theTitle = this.getTitle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "title", theTitle), currentHashCode, theTitle, (this.title!= null));
        }
        {
            String theAuthor;
            theAuthor = this.getAuthor();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "author", theAuthor), currentHashCode, theAuthor, (this.author!= null));
        }
        {
            String theIssn;
            theIssn = this.getIssn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "issn", theIssn), currentHashCode, theIssn, (this.issn!= null));
        }
        {
            String theIsbn;
            theIsbn = this.getIsbn();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "isbn", theIsbn), currentHashCode, theIsbn, (this.isbn!= null));
        }
        {
            String theCompleteEdition;
            theCompleteEdition = this.getCompleteEdition();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "completeEdition", theCompleteEdition), currentHashCode, theCompleteEdition, (this.completeEdition!= null));
        }
        {
            NetworkNumbers theNetworkNumbers;
            theNetworkNumbers = this.getNetworkNumbers();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "networkNumbers", theNetworkNumbers), currentHashCode, theNetworkNumbers, (this.networkNumbers!= null));
        }
        {
            String thePlaceOfPublication;
            thePlaceOfPublication = this.getPlaceOfPublication();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "placeOfPublication", thePlaceOfPublication), currentHashCode, thePlaceOfPublication, (this.placeOfPublication!= null));
        }
        {
            String theDateOfPublication;
            theDateOfPublication = this.getDateOfPublication();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dateOfPublication", theDateOfPublication), currentHashCode, theDateOfPublication, (this.dateOfPublication!= null));
        }
        {
            String thePublisherConst;
            thePublisherConst = this.getPublisherConst();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "publisherConst", thePublisherConst), currentHashCode, thePublisherConst, (this.publisherConst!= null));
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
        final BibData that = ((BibData) object);
        {
            String lhsMmsId;
            lhsMmsId = this.getMmsId();
            String rhsMmsId;
            rhsMmsId = that.getMmsId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "mmsId", lhsMmsId), LocatorUtils.property(thatLocator, "mmsId", rhsMmsId), lhsMmsId, rhsMmsId, (this.mmsId!= null), (that.mmsId!= null))) {
                return false;
            }
        }
        {
            String lhsTitle;
            lhsTitle = this.getTitle();
            String rhsTitle;
            rhsTitle = that.getTitle();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "title", lhsTitle), LocatorUtils.property(thatLocator, "title", rhsTitle), lhsTitle, rhsTitle, (this.title!= null), (that.title!= null))) {
                return false;
            }
        }
        {
            String lhsAuthor;
            lhsAuthor = this.getAuthor();
            String rhsAuthor;
            rhsAuthor = that.getAuthor();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "author", lhsAuthor), LocatorUtils.property(thatLocator, "author", rhsAuthor), lhsAuthor, rhsAuthor, (this.author!= null), (that.author!= null))) {
                return false;
            }
        }
        {
            String lhsIssn;
            lhsIssn = this.getIssn();
            String rhsIssn;
            rhsIssn = that.getIssn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "issn", lhsIssn), LocatorUtils.property(thatLocator, "issn", rhsIssn), lhsIssn, rhsIssn, (this.issn!= null), (that.issn!= null))) {
                return false;
            }
        }
        {
            String lhsIsbn;
            lhsIsbn = this.getIsbn();
            String rhsIsbn;
            rhsIsbn = that.getIsbn();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "isbn", lhsIsbn), LocatorUtils.property(thatLocator, "isbn", rhsIsbn), lhsIsbn, rhsIsbn, (this.isbn!= null), (that.isbn!= null))) {
                return false;
            }
        }
        {
            String lhsCompleteEdition;
            lhsCompleteEdition = this.getCompleteEdition();
            String rhsCompleteEdition;
            rhsCompleteEdition = that.getCompleteEdition();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "completeEdition", lhsCompleteEdition), LocatorUtils.property(thatLocator, "completeEdition", rhsCompleteEdition), lhsCompleteEdition, rhsCompleteEdition, (this.completeEdition!= null), (that.completeEdition!= null))) {
                return false;
            }
        }
        {
            NetworkNumbers lhsNetworkNumbers;
            lhsNetworkNumbers = this.getNetworkNumbers();
            NetworkNumbers rhsNetworkNumbers;
            rhsNetworkNumbers = that.getNetworkNumbers();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "networkNumbers", lhsNetworkNumbers), LocatorUtils.property(thatLocator, "networkNumbers", rhsNetworkNumbers), lhsNetworkNumbers, rhsNetworkNumbers, (this.networkNumbers!= null), (that.networkNumbers!= null))) {
                return false;
            }
        }
        {
            String lhsPlaceOfPublication;
            lhsPlaceOfPublication = this.getPlaceOfPublication();
            String rhsPlaceOfPublication;
            rhsPlaceOfPublication = that.getPlaceOfPublication();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "placeOfPublication", lhsPlaceOfPublication), LocatorUtils.property(thatLocator, "placeOfPublication", rhsPlaceOfPublication), lhsPlaceOfPublication, rhsPlaceOfPublication, (this.placeOfPublication!= null), (that.placeOfPublication!= null))) {
                return false;
            }
        }
        {
            String lhsDateOfPublication;
            lhsDateOfPublication = this.getDateOfPublication();
            String rhsDateOfPublication;
            rhsDateOfPublication = that.getDateOfPublication();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dateOfPublication", lhsDateOfPublication), LocatorUtils.property(thatLocator, "dateOfPublication", rhsDateOfPublication), lhsDateOfPublication, rhsDateOfPublication, (this.dateOfPublication!= null), (that.dateOfPublication!= null))) {
                return false;
            }
        }
        {
            String lhsPublisherConst;
            lhsPublisherConst = this.getPublisherConst();
            String rhsPublisherConst;
            rhsPublisherConst = that.getPublisherConst();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "publisherConst", lhsPublisherConst), LocatorUtils.property(thatLocator, "publisherConst", rhsPublisherConst), lhsPublisherConst, rhsPublisherConst, (this.publisherConst!= null), (that.publisherConst!= null))) {
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
            String theMmsId;
            theMmsId = this.getMmsId();
            strategy.appendField(locator, this, "mmsId", buffer, theMmsId, (this.mmsId!= null));
        }
        {
            String theTitle;
            theTitle = this.getTitle();
            strategy.appendField(locator, this, "title", buffer, theTitle, (this.title!= null));
        }
        {
            String theAuthor;
            theAuthor = this.getAuthor();
            strategy.appendField(locator, this, "author", buffer, theAuthor, (this.author!= null));
        }
        {
            String theIssn;
            theIssn = this.getIssn();
            strategy.appendField(locator, this, "issn", buffer, theIssn, (this.issn!= null));
        }
        {
            String theIsbn;
            theIsbn = this.getIsbn();
            strategy.appendField(locator, this, "isbn", buffer, theIsbn, (this.isbn!= null));
        }
        {
            String theCompleteEdition;
            theCompleteEdition = this.getCompleteEdition();
            strategy.appendField(locator, this, "completeEdition", buffer, theCompleteEdition, (this.completeEdition!= null));
        }
        {
            NetworkNumbers theNetworkNumbers;
            theNetworkNumbers = this.getNetworkNumbers();
            strategy.appendField(locator, this, "networkNumbers", buffer, theNetworkNumbers, (this.networkNumbers!= null));
        }
        {
            String thePlaceOfPublication;
            thePlaceOfPublication = this.getPlaceOfPublication();
            strategy.appendField(locator, this, "placeOfPublication", buffer, thePlaceOfPublication, (this.placeOfPublication!= null));
        }
        {
            String theDateOfPublication;
            theDateOfPublication = this.getDateOfPublication();
            strategy.appendField(locator, this, "dateOfPublication", buffer, theDateOfPublication, (this.dateOfPublication!= null));
        }
        {
            String thePublisherConst;
            thePublisherConst = this.getPublisherConst();
            strategy.appendField(locator, this, "publisherConst", buffer, thePublisherConst, (this.publisherConst!= null));
        }
        {
            String theLink;
            theLink = this.getLink();
            strategy.appendField(locator, this, "link", buffer, theLink, (this.link!= null));
        }
        return buffer;
    }

}
