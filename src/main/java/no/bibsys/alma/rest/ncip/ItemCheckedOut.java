//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:54:26 AM CET 
//


package no.bibsys.alma.rest.ncip;

import java.math.BigInteger;
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
 *         &lt;element ref="{http://www.niso.org/2008/ncip}InitiationHeader" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}UserId"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}ItemId"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}RequestId" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.niso.org/2008/ncip}DateDue"/&gt;
 *           &lt;element ref="{http://www.niso.org/2008/ncip}IndeterminateLoanPeriodFlag"/&gt;
 *           &lt;element ref="{http://www.niso.org/2008/ncip}NonReturnableFlag"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}ElectronicResourceProvidedFlag" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}RenewalCount" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}FiscalTransactionInformation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}ShippingInformation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}ItemOptionalFields" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}UserOptionalFields" minOccurs="0"/&gt;
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
    "initiationHeader",
    "userId",
    "itemId",
    "requestId",
    "nonReturnableFlag",
    "indeterminateLoanPeriodFlag",
    "dateDue",
    "electronicResourceProvidedFlag",
    "renewalCount",
    "fiscalTransactionInformation",
    "shippingInformation",
    "itemOptionalFields",
    "userOptionalFields",
    "ext"
})
@XmlRootElement(name = "ItemCheckedOut")
public class ItemCheckedOut implements Equals2, HashCode2, ToString2
{

    @XmlElement(name = "InitiationHeader")
    protected InitiationHeader initiationHeader;
    @XmlElement(name = "UserId", required = true)
    protected UserId userId;
    @XmlElement(name = "ItemId", required = true)
    protected ItemId itemId;
    @XmlElement(name = "RequestId")
    protected RequestId requestId;
    @XmlElement(name = "NonReturnableFlag")
    protected NonReturnableFlag nonReturnableFlag;
    @XmlElement(name = "IndeterminateLoanPeriodFlag")
    protected IndeterminateLoanPeriodFlag indeterminateLoanPeriodFlag;
    @XmlElement(name = "DateDue")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDue;
    @XmlElement(name = "ElectronicResourceProvidedFlag")
    protected ElectronicResourceProvidedFlag electronicResourceProvidedFlag;
    @XmlElement(name = "RenewalCount")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger renewalCount;
    @XmlElement(name = "FiscalTransactionInformation")
    protected FiscalTransactionInformation fiscalTransactionInformation;
    @XmlElement(name = "ShippingInformation")
    protected ShippingInformation shippingInformation;
    @XmlElement(name = "ItemOptionalFields")
    protected ItemOptionalFields itemOptionalFields;
    @XmlElement(name = "UserOptionalFields")
    protected UserOptionalFields userOptionalFields;
    @XmlElement(name = "Ext")
    protected Ext ext;

    /**
     * Gets the value of the initiationHeader property.
     * 
     * @return
     *     possible object is
     *     {@link InitiationHeader }
     *     
     */
    public InitiationHeader getInitiationHeader() {
        return initiationHeader;
    }

    /**
     * Sets the value of the initiationHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitiationHeader }
     *     
     */
    public void setInitiationHeader(InitiationHeader value) {
        this.initiationHeader = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link UserId }
     *     
     */
    public UserId getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserId }
     *     
     */
    public void setUserId(UserId value) {
        this.userId = value;
    }

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
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link RequestId }
     *     
     */
    public RequestId getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestId }
     *     
     */
    public void setRequestId(RequestId value) {
        this.requestId = value;
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
     * Gets the value of the electronicResourceProvidedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link ElectronicResourceProvidedFlag }
     *     
     */
    public ElectronicResourceProvidedFlag getElectronicResourceProvidedFlag() {
        return electronicResourceProvidedFlag;
    }

    /**
     * Sets the value of the electronicResourceProvidedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElectronicResourceProvidedFlag }
     *     
     */
    public void setElectronicResourceProvidedFlag(ElectronicResourceProvidedFlag value) {
        this.electronicResourceProvidedFlag = value;
    }

    /**
     * Gets the value of the renewalCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRenewalCount() {
        return renewalCount;
    }

    /**
     * Sets the value of the renewalCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRenewalCount(BigInteger value) {
        this.renewalCount = value;
    }

    /**
     * Gets the value of the fiscalTransactionInformation property.
     * 
     * @return
     *     possible object is
     *     {@link FiscalTransactionInformation }
     *     
     */
    public FiscalTransactionInformation getFiscalTransactionInformation() {
        return fiscalTransactionInformation;
    }

    /**
     * Sets the value of the fiscalTransactionInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link FiscalTransactionInformation }
     *     
     */
    public void setFiscalTransactionInformation(FiscalTransactionInformation value) {
        this.fiscalTransactionInformation = value;
    }

    /**
     * Gets the value of the shippingInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ShippingInformation }
     *     
     */
    public ShippingInformation getShippingInformation() {
        return shippingInformation;
    }

    /**
     * Sets the value of the shippingInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingInformation }
     *     
     */
    public void setShippingInformation(ShippingInformation value) {
        this.shippingInformation = value;
    }

    /**
     * Gets the value of the itemOptionalFields property.
     * 
     * @return
     *     possible object is
     *     {@link ItemOptionalFields }
     *     
     */
    public ItemOptionalFields getItemOptionalFields() {
        return itemOptionalFields;
    }

    /**
     * Sets the value of the itemOptionalFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemOptionalFields }
     *     
     */
    public void setItemOptionalFields(ItemOptionalFields value) {
        this.itemOptionalFields = value;
    }

    /**
     * Gets the value of the userOptionalFields property.
     * 
     * @return
     *     possible object is
     *     {@link UserOptionalFields }
     *     
     */
    public UserOptionalFields getUserOptionalFields() {
        return userOptionalFields;
    }

    /**
     * Sets the value of the userOptionalFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserOptionalFields }
     *     
     */
    public void setUserOptionalFields(UserOptionalFields value) {
        this.userOptionalFields = value;
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
            InitiationHeader theInitiationHeader;
            theInitiationHeader = this.getInitiationHeader();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "initiationHeader", theInitiationHeader), currentHashCode, theInitiationHeader, (this.initiationHeader!= null));
        }
        {
            UserId theUserId;
            theUserId = this.getUserId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userId", theUserId), currentHashCode, theUserId, (this.userId!= null));
        }
        {
            ItemId theItemId;
            theItemId = this.getItemId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itemId", theItemId), currentHashCode, theItemId, (this.itemId!= null));
        }
        {
            RequestId theRequestId;
            theRequestId = this.getRequestId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "requestId", theRequestId), currentHashCode, theRequestId, (this.requestId!= null));
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
            ElectronicResourceProvidedFlag theElectronicResourceProvidedFlag;
            theElectronicResourceProvidedFlag = this.getElectronicResourceProvidedFlag();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "electronicResourceProvidedFlag", theElectronicResourceProvidedFlag), currentHashCode, theElectronicResourceProvidedFlag, (this.electronicResourceProvidedFlag!= null));
        }
        {
            BigInteger theRenewalCount;
            theRenewalCount = this.getRenewalCount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "renewalCount", theRenewalCount), currentHashCode, theRenewalCount, (this.renewalCount!= null));
        }
        {
            FiscalTransactionInformation theFiscalTransactionInformation;
            theFiscalTransactionInformation = this.getFiscalTransactionInformation();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fiscalTransactionInformation", theFiscalTransactionInformation), currentHashCode, theFiscalTransactionInformation, (this.fiscalTransactionInformation!= null));
        }
        {
            ShippingInformation theShippingInformation;
            theShippingInformation = this.getShippingInformation();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "shippingInformation", theShippingInformation), currentHashCode, theShippingInformation, (this.shippingInformation!= null));
        }
        {
            ItemOptionalFields theItemOptionalFields;
            theItemOptionalFields = this.getItemOptionalFields();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itemOptionalFields", theItemOptionalFields), currentHashCode, theItemOptionalFields, (this.itemOptionalFields!= null));
        }
        {
            UserOptionalFields theUserOptionalFields;
            theUserOptionalFields = this.getUserOptionalFields();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userOptionalFields", theUserOptionalFields), currentHashCode, theUserOptionalFields, (this.userOptionalFields!= null));
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
        final ItemCheckedOut that = ((ItemCheckedOut) object);
        {
            InitiationHeader lhsInitiationHeader;
            lhsInitiationHeader = this.getInitiationHeader();
            InitiationHeader rhsInitiationHeader;
            rhsInitiationHeader = that.getInitiationHeader();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "initiationHeader", lhsInitiationHeader), LocatorUtils.property(thatLocator, "initiationHeader", rhsInitiationHeader), lhsInitiationHeader, rhsInitiationHeader, (this.initiationHeader!= null), (that.initiationHeader!= null))) {
                return false;
            }
        }
        {
            UserId lhsUserId;
            lhsUserId = this.getUserId();
            UserId rhsUserId;
            rhsUserId = that.getUserId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userId", lhsUserId), LocatorUtils.property(thatLocator, "userId", rhsUserId), lhsUserId, rhsUserId, (this.userId!= null), (that.userId!= null))) {
                return false;
            }
        }
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
            RequestId lhsRequestId;
            lhsRequestId = this.getRequestId();
            RequestId rhsRequestId;
            rhsRequestId = that.getRequestId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "requestId", lhsRequestId), LocatorUtils.property(thatLocator, "requestId", rhsRequestId), lhsRequestId, rhsRequestId, (this.requestId!= null), (that.requestId!= null))) {
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
            ElectronicResourceProvidedFlag lhsElectronicResourceProvidedFlag;
            lhsElectronicResourceProvidedFlag = this.getElectronicResourceProvidedFlag();
            ElectronicResourceProvidedFlag rhsElectronicResourceProvidedFlag;
            rhsElectronicResourceProvidedFlag = that.getElectronicResourceProvidedFlag();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "electronicResourceProvidedFlag", lhsElectronicResourceProvidedFlag), LocatorUtils.property(thatLocator, "electronicResourceProvidedFlag", rhsElectronicResourceProvidedFlag), lhsElectronicResourceProvidedFlag, rhsElectronicResourceProvidedFlag, (this.electronicResourceProvidedFlag!= null), (that.electronicResourceProvidedFlag!= null))) {
                return false;
            }
        }
        {
            BigInteger lhsRenewalCount;
            lhsRenewalCount = this.getRenewalCount();
            BigInteger rhsRenewalCount;
            rhsRenewalCount = that.getRenewalCount();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "renewalCount", lhsRenewalCount), LocatorUtils.property(thatLocator, "renewalCount", rhsRenewalCount), lhsRenewalCount, rhsRenewalCount, (this.renewalCount!= null), (that.renewalCount!= null))) {
                return false;
            }
        }
        {
            FiscalTransactionInformation lhsFiscalTransactionInformation;
            lhsFiscalTransactionInformation = this.getFiscalTransactionInformation();
            FiscalTransactionInformation rhsFiscalTransactionInformation;
            rhsFiscalTransactionInformation = that.getFiscalTransactionInformation();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fiscalTransactionInformation", lhsFiscalTransactionInformation), LocatorUtils.property(thatLocator, "fiscalTransactionInformation", rhsFiscalTransactionInformation), lhsFiscalTransactionInformation, rhsFiscalTransactionInformation, (this.fiscalTransactionInformation!= null), (that.fiscalTransactionInformation!= null))) {
                return false;
            }
        }
        {
            ShippingInformation lhsShippingInformation;
            lhsShippingInformation = this.getShippingInformation();
            ShippingInformation rhsShippingInformation;
            rhsShippingInformation = that.getShippingInformation();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "shippingInformation", lhsShippingInformation), LocatorUtils.property(thatLocator, "shippingInformation", rhsShippingInformation), lhsShippingInformation, rhsShippingInformation, (this.shippingInformation!= null), (that.shippingInformation!= null))) {
                return false;
            }
        }
        {
            ItemOptionalFields lhsItemOptionalFields;
            lhsItemOptionalFields = this.getItemOptionalFields();
            ItemOptionalFields rhsItemOptionalFields;
            rhsItemOptionalFields = that.getItemOptionalFields();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "itemOptionalFields", lhsItemOptionalFields), LocatorUtils.property(thatLocator, "itemOptionalFields", rhsItemOptionalFields), lhsItemOptionalFields, rhsItemOptionalFields, (this.itemOptionalFields!= null), (that.itemOptionalFields!= null))) {
                return false;
            }
        }
        {
            UserOptionalFields lhsUserOptionalFields;
            lhsUserOptionalFields = this.getUserOptionalFields();
            UserOptionalFields rhsUserOptionalFields;
            rhsUserOptionalFields = that.getUserOptionalFields();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "userOptionalFields", lhsUserOptionalFields), LocatorUtils.property(thatLocator, "userOptionalFields", rhsUserOptionalFields), lhsUserOptionalFields, rhsUserOptionalFields, (this.userOptionalFields!= null), (that.userOptionalFields!= null))) {
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
            InitiationHeader theInitiationHeader;
            theInitiationHeader = this.getInitiationHeader();
            strategy.appendField(locator, this, "initiationHeader", buffer, theInitiationHeader, (this.initiationHeader!= null));
        }
        {
            UserId theUserId;
            theUserId = this.getUserId();
            strategy.appendField(locator, this, "userId", buffer, theUserId, (this.userId!= null));
        }
        {
            ItemId theItemId;
            theItemId = this.getItemId();
            strategy.appendField(locator, this, "itemId", buffer, theItemId, (this.itemId!= null));
        }
        {
            RequestId theRequestId;
            theRequestId = this.getRequestId();
            strategy.appendField(locator, this, "requestId", buffer, theRequestId, (this.requestId!= null));
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
            ElectronicResourceProvidedFlag theElectronicResourceProvidedFlag;
            theElectronicResourceProvidedFlag = this.getElectronicResourceProvidedFlag();
            strategy.appendField(locator, this, "electronicResourceProvidedFlag", buffer, theElectronicResourceProvidedFlag, (this.electronicResourceProvidedFlag!= null));
        }
        {
            BigInteger theRenewalCount;
            theRenewalCount = this.getRenewalCount();
            strategy.appendField(locator, this, "renewalCount", buffer, theRenewalCount, (this.renewalCount!= null));
        }
        {
            FiscalTransactionInformation theFiscalTransactionInformation;
            theFiscalTransactionInformation = this.getFiscalTransactionInformation();
            strategy.appendField(locator, this, "fiscalTransactionInformation", buffer, theFiscalTransactionInformation, (this.fiscalTransactionInformation!= null));
        }
        {
            ShippingInformation theShippingInformation;
            theShippingInformation = this.getShippingInformation();
            strategy.appendField(locator, this, "shippingInformation", buffer, theShippingInformation, (this.shippingInformation!= null));
        }
        {
            ItemOptionalFields theItemOptionalFields;
            theItemOptionalFields = this.getItemOptionalFields();
            strategy.appendField(locator, this, "itemOptionalFields", buffer, theItemOptionalFields, (this.itemOptionalFields!= null));
        }
        {
            UserOptionalFields theUserOptionalFields;
            theUserOptionalFields = this.getUserOptionalFields();
            strategy.appendField(locator, this, "userOptionalFields", buffer, theUserOptionalFields, (this.userOptionalFields!= null));
        }
        {
            Ext theExt;
            theExt = this.getExt();
            strategy.appendField(locator, this, "ext", buffer, theExt, (this.ext!= null));
        }
        return buffer;
    }

}
