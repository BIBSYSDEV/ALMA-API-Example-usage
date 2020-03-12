//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:54:26 AM CET 
//


package no.bibsys.alma.rest.ncip;

import java.math.BigInteger;
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
 *         &lt;element ref="{http://www.niso.org/2008/ncip}BibliographicId" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}ReminderLevel" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.niso.org/2008/ncip}DateDue"/&gt;
 *           &lt;element ref="{http://www.niso.org/2008/ncip}IndeterminateLoanPeriodFlag"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}Amount" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}Title" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}MediumType" minOccurs="0"/&gt;
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
    "bibliographicIds",
    "reminderLevel",
    "indeterminateLoanPeriodFlag",
    "dateDue",
    "amount",
    "title",
    "mediumType",
    "ext"
})
@XmlRootElement(name = "LoanedItem")
public class LoanedItem implements Equals2, HashCode2, ToString2
{

    @XmlElement(name = "ItemId", required = true)
    protected ItemId itemId;
    @XmlElement(name = "BibliographicId")
    protected List<BibliographicId> bibliographicIds;
    @XmlElement(name = "ReminderLevel")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger reminderLevel;
    @XmlElement(name = "IndeterminateLoanPeriodFlag")
    protected IndeterminateLoanPeriodFlag indeterminateLoanPeriodFlag;
    @XmlElement(name = "DateDue")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDue;
    @XmlElement(name = "Amount")
    protected Amount amount;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "MediumType")
    protected SchemeValuePair mediumType;
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
     * Gets the value of the bibliographicIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bibliographicIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBibliographicIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BibliographicId }
     * 
     * 
     */
    public List<BibliographicId> getBibliographicIds() {
        if (bibliographicIds == null) {
            bibliographicIds = new ArrayList<BibliographicId>();
        }
        return this.bibliographicIds;
    }

    /**
     * Gets the value of the reminderLevel property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getReminderLevel() {
        return reminderLevel;
    }

    /**
     * Sets the value of the reminderLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setReminderLevel(BigInteger value) {
        this.reminderLevel = value;
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
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link Amount }
     *     
     */
    public Amount getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Amount }
     *     
     */
    public void setAmount(Amount value) {
        this.amount = value;
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
     * Gets the value of the mediumType property.
     * 
     * @return
     *     possible object is
     *     {@link SchemeValuePair }
     *     
     */
    public SchemeValuePair getMediumType() {
        return mediumType;
    }

    /**
     * Sets the value of the mediumType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemeValuePair }
     *     
     */
    public void setMediumType(SchemeValuePair value) {
        this.mediumType = value;
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
            List<BibliographicId> theBibliographicIds;
            theBibliographicIds = (((this.bibliographicIds!= null)&&(!this.bibliographicIds.isEmpty()))?this.getBibliographicIds():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bibliographicIds", theBibliographicIds), currentHashCode, theBibliographicIds, ((this.bibliographicIds!= null)&&(!this.bibliographicIds.isEmpty())));
        }
        {
            BigInteger theReminderLevel;
            theReminderLevel = this.getReminderLevel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "reminderLevel", theReminderLevel), currentHashCode, theReminderLevel, (this.reminderLevel!= null));
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
            Amount theAmount;
            theAmount = this.getAmount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "amount", theAmount), currentHashCode, theAmount, (this.amount!= null));
        }
        {
            String theTitle;
            theTitle = this.getTitle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "title", theTitle), currentHashCode, theTitle, (this.title!= null));
        }
        {
            SchemeValuePair theMediumType;
            theMediumType = this.getMediumType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mediumType", theMediumType), currentHashCode, theMediumType, (this.mediumType!= null));
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
        final LoanedItem that = ((LoanedItem) object);
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
            List<BibliographicId> lhsBibliographicIds;
            lhsBibliographicIds = (((this.bibliographicIds!= null)&&(!this.bibliographicIds.isEmpty()))?this.getBibliographicIds():null);
            List<BibliographicId> rhsBibliographicIds;
            rhsBibliographicIds = (((that.bibliographicIds!= null)&&(!that.bibliographicIds.isEmpty()))?that.getBibliographicIds():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bibliographicIds", lhsBibliographicIds), LocatorUtils.property(thatLocator, "bibliographicIds", rhsBibliographicIds), lhsBibliographicIds, rhsBibliographicIds, ((this.bibliographicIds!= null)&&(!this.bibliographicIds.isEmpty())), ((that.bibliographicIds!= null)&&(!that.bibliographicIds.isEmpty())))) {
                return false;
            }
        }
        {
            BigInteger lhsReminderLevel;
            lhsReminderLevel = this.getReminderLevel();
            BigInteger rhsReminderLevel;
            rhsReminderLevel = that.getReminderLevel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "reminderLevel", lhsReminderLevel), LocatorUtils.property(thatLocator, "reminderLevel", rhsReminderLevel), lhsReminderLevel, rhsReminderLevel, (this.reminderLevel!= null), (that.reminderLevel!= null))) {
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
            Amount lhsAmount;
            lhsAmount = this.getAmount();
            Amount rhsAmount;
            rhsAmount = that.getAmount();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "amount", lhsAmount), LocatorUtils.property(thatLocator, "amount", rhsAmount), lhsAmount, rhsAmount, (this.amount!= null), (that.amount!= null))) {
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
            SchemeValuePair lhsMediumType;
            lhsMediumType = this.getMediumType();
            SchemeValuePair rhsMediumType;
            rhsMediumType = that.getMediumType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "mediumType", lhsMediumType), LocatorUtils.property(thatLocator, "mediumType", rhsMediumType), lhsMediumType, rhsMediumType, (this.mediumType!= null), (that.mediumType!= null))) {
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
            List<BibliographicId> theBibliographicIds;
            theBibliographicIds = (((this.bibliographicIds!= null)&&(!this.bibliographicIds.isEmpty()))?this.getBibliographicIds():null);
            strategy.appendField(locator, this, "bibliographicIds", buffer, theBibliographicIds, ((this.bibliographicIds!= null)&&(!this.bibliographicIds.isEmpty())));
        }
        {
            BigInteger theReminderLevel;
            theReminderLevel = this.getReminderLevel();
            strategy.appendField(locator, this, "reminderLevel", buffer, theReminderLevel, (this.reminderLevel!= null));
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
            Amount theAmount;
            theAmount = this.getAmount();
            strategy.appendField(locator, this, "amount", buffer, theAmount, (this.amount!= null));
        }
        {
            String theTitle;
            theTitle = this.getTitle();
            strategy.appendField(locator, this, "title", buffer, theTitle, (this.title!= null));
        }
        {
            SchemeValuePair theMediumType;
            theMediumType = this.getMediumType();
            strategy.appendField(locator, this, "mediumType", buffer, theMediumType, (this.mediumType!= null));
        }
        {
            Ext theExt;
            theExt = this.getExt();
            strategy.appendField(locator, this, "ext", buffer, theExt, (this.ext!= null));
        }
        return buffer;
    }

}