//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:54:26 AM CET 
//


package no.bibsys.alma.rest.ncip;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://www.niso.org/2008/ncip}ItemId"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}BibliographicDescription"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}DateCheckedOut" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}DateRenewed" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element ref="{http://www.niso.org/2008/ncip}DateDue"/&gt;
 *           &lt;element ref="{http://www.niso.org/2008/ncip}IndeterminateLoanPeriodFlag"/&gt;
 *           &lt;element ref="{http://www.niso.org/2008/ncip}NonReturnableFlag"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}DateReturned" minOccurs="0"/&gt;
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
    "itemId",
    "bibliographicDescription",
    "dateCheckedOut",
    "dateReneweds",
    "nonReturnableFlag",
    "indeterminateLoanPeriodFlag",
    "dateDue",
    "dateReturned",
    "ext"
})
@XmlRootElement(name = "ItemDetails")
public class ItemDetails implements Equals2, HashCode2, ToString2
{

    @XmlElement(name = "ItemId", required = true)
    protected ItemId itemId;
    @XmlElement(name = "BibliographicDescription", required = true)
    protected BibliographicDescription bibliographicDescription;
    @XmlElement(name = "DateCheckedOut")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCheckedOut;
    @XmlElement(name = "DateRenewed")
    @XmlSchemaType(name = "dateTime")
    protected List<XMLGregorianCalendar> dateReneweds;
    @XmlElement(name = "NonReturnableFlag")
    protected NonReturnableFlag nonReturnableFlag;
    @XmlElement(name = "IndeterminateLoanPeriodFlag")
    protected IndeterminateLoanPeriodFlag indeterminateLoanPeriodFlag;
    @XmlElement(name = "DateDue")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDue;
    @XmlElement(name = "DateReturned")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateReturned;
    @XmlElement(name = "Ext")
    protected Ext ext;

    /**
     * Gets the value of the itemId property.
     * 
     * @return
     *     possible object is
     *     {@link ItemId }
     *     
     */
    public ItemId getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemId }
     *     
     */
    public void setItemId(ItemId value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the bibliographicDescription property.
     * 
     * @return
     *     possible object is
     *     {@link BibliographicDescription }
     *     
     */
    public BibliographicDescription getBibliographicDescription() {
        return bibliographicDescription;
    }

    /**
     * Sets the value of the bibliographicDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link BibliographicDescription }
     *     
     */
    public void setBibliographicDescription(BibliographicDescription value) {
        this.bibliographicDescription = value;
    }

    /**
     * Gets the value of the dateCheckedOut property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCheckedOut() {
        return dateCheckedOut;
    }

    /**
     * Sets the value of the dateCheckedOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCheckedOut(XMLGregorianCalendar value) {
        this.dateCheckedOut = value;
    }

    /**
     * Gets the value of the dateReneweds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dateReneweds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDateReneweds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XMLGregorianCalendar }
     * 
     * 
     */
    public List<XMLGregorianCalendar> getDateReneweds() {
        if (dateReneweds == null) {
            dateReneweds = new ArrayList<XMLGregorianCalendar>();
        }
        return this.dateReneweds;
    }

    /**
     * Gets the value of the nonReturnableFlag property.
     * 
     * @return
     *     possible object is
     *     {@link NonReturnableFlag }
     *     
     */
    public NonReturnableFlag getNonReturnableFlag() {
        return nonReturnableFlag;
    }

    /**
     * Sets the value of the nonReturnableFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonReturnableFlag }
     *     
     */
    public void setNonReturnableFlag(NonReturnableFlag value) {
        this.nonReturnableFlag = value;
    }

    /**
     * Gets the value of the indeterminateLoanPeriodFlag property.
     * 
     * @return
     *     possible object is
     *     {@link IndeterminateLoanPeriodFlag }
     *     
     */
    public IndeterminateLoanPeriodFlag getIndeterminateLoanPeriodFlag() {
        return indeterminateLoanPeriodFlag;
    }

    /**
     * Sets the value of the indeterminateLoanPeriodFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndeterminateLoanPeriodFlag }
     *     
     */
    public void setIndeterminateLoanPeriodFlag(IndeterminateLoanPeriodFlag value) {
        this.indeterminateLoanPeriodFlag = value;
    }

    /**
     * Gets the value of the dateDue property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDue() {
        return dateDue;
    }

    /**
     * Sets the value of the dateDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDue(XMLGregorianCalendar value) {
        this.dateDue = value;
    }

    /**
     * Gets the value of the dateReturned property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateReturned() {
        return dateReturned;
    }

    /**
     * Sets the value of the dateReturned property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateReturned(XMLGregorianCalendar value) {
        this.dateReturned = value;
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
            ItemId theItemId;
            theItemId = this.getItemId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itemId", theItemId), currentHashCode, theItemId, (this.itemId!= null));
        }
        {
            BibliographicDescription theBibliographicDescription;
            theBibliographicDescription = this.getBibliographicDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bibliographicDescription", theBibliographicDescription), currentHashCode, theBibliographicDescription, (this.bibliographicDescription!= null));
        }
        {
            XMLGregorianCalendar theDateCheckedOut;
            theDateCheckedOut = this.getDateCheckedOut();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dateCheckedOut", theDateCheckedOut), currentHashCode, theDateCheckedOut, (this.dateCheckedOut!= null));
        }
        {
            List<XMLGregorianCalendar> theDateReneweds;
            theDateReneweds = (((this.dateReneweds!= null)&&(!this.dateReneweds.isEmpty()))?this.getDateReneweds():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dateReneweds", theDateReneweds), currentHashCode, theDateReneweds, ((this.dateReneweds!= null)&&(!this.dateReneweds.isEmpty())));
        }
        {
            NonReturnableFlag theNonReturnableFlag;
            theNonReturnableFlag = this.getNonReturnableFlag();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "nonReturnableFlag", theNonReturnableFlag), currentHashCode, theNonReturnableFlag, (this.nonReturnableFlag!= null));
        }
        {
            IndeterminateLoanPeriodFlag theIndeterminateLoanPeriodFlag;
            theIndeterminateLoanPeriodFlag = this.getIndeterminateLoanPeriodFlag();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "indeterminateLoanPeriodFlag", theIndeterminateLoanPeriodFlag), currentHashCode, theIndeterminateLoanPeriodFlag, (this.indeterminateLoanPeriodFlag!= null));
        }
        {
            XMLGregorianCalendar theDateDue;
            theDateDue = this.getDateDue();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dateDue", theDateDue), currentHashCode, theDateDue, (this.dateDue!= null));
        }
        {
            XMLGregorianCalendar theDateReturned;
            theDateReturned = this.getDateReturned();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dateReturned", theDateReturned), currentHashCode, theDateReturned, (this.dateReturned!= null));
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
        final ItemDetails that = ((ItemDetails) object);
        {
            ItemId lhsItemId;
            lhsItemId = this.getItemId();
            ItemId rhsItemId;
            rhsItemId = that.getItemId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "itemId", lhsItemId), LocatorUtils.property(thatLocator, "itemId", rhsItemId), lhsItemId, rhsItemId, (this.itemId!= null), (that.itemId!= null))) {
                return false;
            }
        }
        {
            BibliographicDescription lhsBibliographicDescription;
            lhsBibliographicDescription = this.getBibliographicDescription();
            BibliographicDescription rhsBibliographicDescription;
            rhsBibliographicDescription = that.getBibliographicDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bibliographicDescription", lhsBibliographicDescription), LocatorUtils.property(thatLocator, "bibliographicDescription", rhsBibliographicDescription), lhsBibliographicDescription, rhsBibliographicDescription, (this.bibliographicDescription!= null), (that.bibliographicDescription!= null))) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDateCheckedOut;
            lhsDateCheckedOut = this.getDateCheckedOut();
            XMLGregorianCalendar rhsDateCheckedOut;
            rhsDateCheckedOut = that.getDateCheckedOut();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dateCheckedOut", lhsDateCheckedOut), LocatorUtils.property(thatLocator, "dateCheckedOut", rhsDateCheckedOut), lhsDateCheckedOut, rhsDateCheckedOut, (this.dateCheckedOut!= null), (that.dateCheckedOut!= null))) {
                return false;
            }
        }
        {
            List<XMLGregorianCalendar> lhsDateReneweds;
            lhsDateReneweds = (((this.dateReneweds!= null)&&(!this.dateReneweds.isEmpty()))?this.getDateReneweds():null);
            List<XMLGregorianCalendar> rhsDateReneweds;
            rhsDateReneweds = (((that.dateReneweds!= null)&&(!that.dateReneweds.isEmpty()))?that.getDateReneweds():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dateReneweds", lhsDateReneweds), LocatorUtils.property(thatLocator, "dateReneweds", rhsDateReneweds), lhsDateReneweds, rhsDateReneweds, ((this.dateReneweds!= null)&&(!this.dateReneweds.isEmpty())), ((that.dateReneweds!= null)&&(!that.dateReneweds.isEmpty())))) {
                return false;
            }
        }
        {
            NonReturnableFlag lhsNonReturnableFlag;
            lhsNonReturnableFlag = this.getNonReturnableFlag();
            NonReturnableFlag rhsNonReturnableFlag;
            rhsNonReturnableFlag = that.getNonReturnableFlag();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "nonReturnableFlag", lhsNonReturnableFlag), LocatorUtils.property(thatLocator, "nonReturnableFlag", rhsNonReturnableFlag), lhsNonReturnableFlag, rhsNonReturnableFlag, (this.nonReturnableFlag!= null), (that.nonReturnableFlag!= null))) {
                return false;
            }
        }
        {
            IndeterminateLoanPeriodFlag lhsIndeterminateLoanPeriodFlag;
            lhsIndeterminateLoanPeriodFlag = this.getIndeterminateLoanPeriodFlag();
            IndeterminateLoanPeriodFlag rhsIndeterminateLoanPeriodFlag;
            rhsIndeterminateLoanPeriodFlag = that.getIndeterminateLoanPeriodFlag();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "indeterminateLoanPeriodFlag", lhsIndeterminateLoanPeriodFlag), LocatorUtils.property(thatLocator, "indeterminateLoanPeriodFlag", rhsIndeterminateLoanPeriodFlag), lhsIndeterminateLoanPeriodFlag, rhsIndeterminateLoanPeriodFlag, (this.indeterminateLoanPeriodFlag!= null), (that.indeterminateLoanPeriodFlag!= null))) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDateDue;
            lhsDateDue = this.getDateDue();
            XMLGregorianCalendar rhsDateDue;
            rhsDateDue = that.getDateDue();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dateDue", lhsDateDue), LocatorUtils.property(thatLocator, "dateDue", rhsDateDue), lhsDateDue, rhsDateDue, (this.dateDue!= null), (that.dateDue!= null))) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsDateReturned;
            lhsDateReturned = this.getDateReturned();
            XMLGregorianCalendar rhsDateReturned;
            rhsDateReturned = that.getDateReturned();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dateReturned", lhsDateReturned), LocatorUtils.property(thatLocator, "dateReturned", rhsDateReturned), lhsDateReturned, rhsDateReturned, (this.dateReturned!= null), (that.dateReturned!= null))) {
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
            ItemId theItemId;
            theItemId = this.getItemId();
            strategy.appendField(locator, this, "itemId", buffer, theItemId, (this.itemId!= null));
        }
        {
            BibliographicDescription theBibliographicDescription;
            theBibliographicDescription = this.getBibliographicDescription();
            strategy.appendField(locator, this, "bibliographicDescription", buffer, theBibliographicDescription, (this.bibliographicDescription!= null));
        }
        {
            XMLGregorianCalendar theDateCheckedOut;
            theDateCheckedOut = this.getDateCheckedOut();
            strategy.appendField(locator, this, "dateCheckedOut", buffer, theDateCheckedOut, (this.dateCheckedOut!= null));
        }
        {
            List<XMLGregorianCalendar> theDateReneweds;
            theDateReneweds = (((this.dateReneweds!= null)&&(!this.dateReneweds.isEmpty()))?this.getDateReneweds():null);
            strategy.appendField(locator, this, "dateReneweds", buffer, theDateReneweds, ((this.dateReneweds!= null)&&(!this.dateReneweds.isEmpty())));
        }
        {
            NonReturnableFlag theNonReturnableFlag;
            theNonReturnableFlag = this.getNonReturnableFlag();
            strategy.appendField(locator, this, "nonReturnableFlag", buffer, theNonReturnableFlag, (this.nonReturnableFlag!= null));
        }
        {
            IndeterminateLoanPeriodFlag theIndeterminateLoanPeriodFlag;
            theIndeterminateLoanPeriodFlag = this.getIndeterminateLoanPeriodFlag();
            strategy.appendField(locator, this, "indeterminateLoanPeriodFlag", buffer, theIndeterminateLoanPeriodFlag, (this.indeterminateLoanPeriodFlag!= null));
        }
        {
            XMLGregorianCalendar theDateDue;
            theDateDue = this.getDateDue();
            strategy.appendField(locator, this, "dateDue", buffer, theDateDue, (this.dateDue!= null));
        }
        {
            XMLGregorianCalendar theDateReturned;
            theDateReturned = this.getDateReturned();
            strategy.appendField(locator, this, "dateReturned", buffer, theDateReturned, (this.dateReturned!= null));
        }
        {
            Ext theExt;
            theExt = this.getExt();
            strategy.appendField(locator, this, "ext", buffer, theExt, (this.ext!= null));
        }
        return buffer;
    }

}
