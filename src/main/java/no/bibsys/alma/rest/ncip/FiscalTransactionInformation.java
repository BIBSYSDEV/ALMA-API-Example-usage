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
 *         &lt;element ref="{http://www.niso.org/2008/ncip}FiscalActionType"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}FiscalTransactionReferenceId" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}RelatedFiscalTransactionReferenceId" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}FiscalTransactionType"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}ValidFromDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}ValidToDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}Amount"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}PaymentMethodType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}FiscalTransactionDescription" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}RequestId" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}ItemDetails" minOccurs="0"/&gt;
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
    "fiscalActionType",
    "fiscalTransactionReferenceId",
    "relatedFiscalTransactionReferenceIds",
    "fiscalTransactionType",
    "validFromDate",
    "validToDate",
    "amount",
    "paymentMethodType",
    "fiscalTransactionDescription",
    "requestId",
    "itemDetails",
    "ext"
})
@XmlRootElement(name = "FiscalTransactionInformation")
public class FiscalTransactionInformation implements Equals2, HashCode2, ToString2
{

    @XmlElement(name = "FiscalActionType", required = true)
    protected SchemeValuePair fiscalActionType;
    @XmlElement(name = "FiscalTransactionReferenceId")
    protected FiscalTransactionReferenceId fiscalTransactionReferenceId;
    @XmlElement(name = "RelatedFiscalTransactionReferenceId")
    protected List<RelatedFiscalTransactionReferenceId> relatedFiscalTransactionReferenceIds;
    @XmlElement(name = "FiscalTransactionType", required = true)
    protected SchemeValuePair fiscalTransactionType;
    @XmlElement(name = "ValidFromDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validFromDate;
    @XmlElement(name = "ValidToDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validToDate;
    @XmlElement(name = "Amount", required = true)
    protected Amount amount;
    @XmlElement(name = "PaymentMethodType")
    protected SchemeValuePair paymentMethodType;
    @XmlElement(name = "FiscalTransactionDescription")
    protected String fiscalTransactionDescription;
    @XmlElement(name = "RequestId")
    protected RequestId requestId;
    @XmlElement(name = "ItemDetails")
    protected ItemDetails itemDetails;
    @XmlElement(name = "Ext")
    protected Ext ext;

    /**
     * Gets the value of the fiscalActionType property.
     * 
     * @return
     *     possible object is
     *     {@link SchemeValuePair }
     *     
     */
    public SchemeValuePair getFiscalActionType() {
        return fiscalActionType;
    }

    /**
     * Sets the value of the fiscalActionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemeValuePair }
     *     
     */
    public void setFiscalActionType(SchemeValuePair value) {
        this.fiscalActionType = value;
    }

    /**
     * Gets the value of the fiscalTransactionReferenceId property.
     * 
     * @return
     *     possible object is
     *     {@link FiscalTransactionReferenceId }
     *     
     */
    public FiscalTransactionReferenceId getFiscalTransactionReferenceId() {
        return fiscalTransactionReferenceId;
    }

    /**
     * Sets the value of the fiscalTransactionReferenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link FiscalTransactionReferenceId }
     *     
     */
    public void setFiscalTransactionReferenceId(FiscalTransactionReferenceId value) {
        this.fiscalTransactionReferenceId = value;
    }

    /**
     * Gets the value of the relatedFiscalTransactionReferenceIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedFiscalTransactionReferenceIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedFiscalTransactionReferenceIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelatedFiscalTransactionReferenceId }
     * 
     * 
     */
    public List<RelatedFiscalTransactionReferenceId> getRelatedFiscalTransactionReferenceIds() {
        if (relatedFiscalTransactionReferenceIds == null) {
            relatedFiscalTransactionReferenceIds = new ArrayList<RelatedFiscalTransactionReferenceId>();
        }
        return this.relatedFiscalTransactionReferenceIds;
    }

    /**
     * Gets the value of the fiscalTransactionType property.
     * 
     * @return
     *     possible object is
     *     {@link SchemeValuePair }
     *     
     */
    public SchemeValuePair getFiscalTransactionType() {
        return fiscalTransactionType;
    }

    /**
     * Sets the value of the fiscalTransactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemeValuePair }
     *     
     */
    public void setFiscalTransactionType(SchemeValuePair value) {
        this.fiscalTransactionType = value;
    }

    /**
     * Gets the value of the validFromDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidFromDate() {
        return validFromDate;
    }

    /**
     * Sets the value of the validFromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidFromDate(XMLGregorianCalendar value) {
        this.validFromDate = value;
    }

    /**
     * Gets the value of the validToDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidToDate() {
        return validToDate;
    }

    /**
     * Sets the value of the validToDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidToDate(XMLGregorianCalendar value) {
        this.validToDate = value;
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
     * Gets the value of the paymentMethodType property.
     * 
     * @return
     *     possible object is
     *     {@link SchemeValuePair }
     *     
     */
    public SchemeValuePair getPaymentMethodType() {
        return paymentMethodType;
    }

    /**
     * Sets the value of the paymentMethodType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemeValuePair }
     *     
     */
    public void setPaymentMethodType(SchemeValuePair value) {
        this.paymentMethodType = value;
    }

    /**
     * Gets the value of the fiscalTransactionDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiscalTransactionDescription() {
        return fiscalTransactionDescription;
    }

    /**
     * Sets the value of the fiscalTransactionDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiscalTransactionDescription(String value) {
        this.fiscalTransactionDescription = value;
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
     * Gets the value of the itemDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ItemDetails }
     *     
     */
    public ItemDetails getItemDetails() {
        return itemDetails;
    }

    /**
     * Sets the value of the itemDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemDetails }
     *     
     */
    public void setItemDetails(ItemDetails value) {
        this.itemDetails = value;
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
            SchemeValuePair theFiscalActionType;
            theFiscalActionType = this.getFiscalActionType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fiscalActionType", theFiscalActionType), currentHashCode, theFiscalActionType, (this.fiscalActionType!= null));
        }
        {
            FiscalTransactionReferenceId theFiscalTransactionReferenceId;
            theFiscalTransactionReferenceId = this.getFiscalTransactionReferenceId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fiscalTransactionReferenceId", theFiscalTransactionReferenceId), currentHashCode, theFiscalTransactionReferenceId, (this.fiscalTransactionReferenceId!= null));
        }
        {
            List<RelatedFiscalTransactionReferenceId> theRelatedFiscalTransactionReferenceIds;
            theRelatedFiscalTransactionReferenceIds = (((this.relatedFiscalTransactionReferenceIds!= null)&&(!this.relatedFiscalTransactionReferenceIds.isEmpty()))?this.getRelatedFiscalTransactionReferenceIds():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "relatedFiscalTransactionReferenceIds", theRelatedFiscalTransactionReferenceIds), currentHashCode, theRelatedFiscalTransactionReferenceIds, ((this.relatedFiscalTransactionReferenceIds!= null)&&(!this.relatedFiscalTransactionReferenceIds.isEmpty())));
        }
        {
            SchemeValuePair theFiscalTransactionType;
            theFiscalTransactionType = this.getFiscalTransactionType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fiscalTransactionType", theFiscalTransactionType), currentHashCode, theFiscalTransactionType, (this.fiscalTransactionType!= null));
        }
        {
            XMLGregorianCalendar theValidFromDate;
            theValidFromDate = this.getValidFromDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validFromDate", theValidFromDate), currentHashCode, theValidFromDate, (this.validFromDate!= null));
        }
        {
            XMLGregorianCalendar theValidToDate;
            theValidToDate = this.getValidToDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "validToDate", theValidToDate), currentHashCode, theValidToDate, (this.validToDate!= null));
        }
        {
            Amount theAmount;
            theAmount = this.getAmount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "amount", theAmount), currentHashCode, theAmount, (this.amount!= null));
        }
        {
            SchemeValuePair thePaymentMethodType;
            thePaymentMethodType = this.getPaymentMethodType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "paymentMethodType", thePaymentMethodType), currentHashCode, thePaymentMethodType, (this.paymentMethodType!= null));
        }
        {
            String theFiscalTransactionDescription;
            theFiscalTransactionDescription = this.getFiscalTransactionDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fiscalTransactionDescription", theFiscalTransactionDescription), currentHashCode, theFiscalTransactionDescription, (this.fiscalTransactionDescription!= null));
        }
        {
            RequestId theRequestId;
            theRequestId = this.getRequestId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "requestId", theRequestId), currentHashCode, theRequestId, (this.requestId!= null));
        }
        {
            ItemDetails theItemDetails;
            theItemDetails = this.getItemDetails();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itemDetails", theItemDetails), currentHashCode, theItemDetails, (this.itemDetails!= null));
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
        final FiscalTransactionInformation that = ((FiscalTransactionInformation) object);
        {
            SchemeValuePair lhsFiscalActionType;
            lhsFiscalActionType = this.getFiscalActionType();
            SchemeValuePair rhsFiscalActionType;
            rhsFiscalActionType = that.getFiscalActionType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fiscalActionType", lhsFiscalActionType), LocatorUtils.property(thatLocator, "fiscalActionType", rhsFiscalActionType), lhsFiscalActionType, rhsFiscalActionType, (this.fiscalActionType!= null), (that.fiscalActionType!= null))) {
                return false;
            }
        }
        {
            FiscalTransactionReferenceId lhsFiscalTransactionReferenceId;
            lhsFiscalTransactionReferenceId = this.getFiscalTransactionReferenceId();
            FiscalTransactionReferenceId rhsFiscalTransactionReferenceId;
            rhsFiscalTransactionReferenceId = that.getFiscalTransactionReferenceId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fiscalTransactionReferenceId", lhsFiscalTransactionReferenceId), LocatorUtils.property(thatLocator, "fiscalTransactionReferenceId", rhsFiscalTransactionReferenceId), lhsFiscalTransactionReferenceId, rhsFiscalTransactionReferenceId, (this.fiscalTransactionReferenceId!= null), (that.fiscalTransactionReferenceId!= null))) {
                return false;
            }
        }
        {
            List<RelatedFiscalTransactionReferenceId> lhsRelatedFiscalTransactionReferenceIds;
            lhsRelatedFiscalTransactionReferenceIds = (((this.relatedFiscalTransactionReferenceIds!= null)&&(!this.relatedFiscalTransactionReferenceIds.isEmpty()))?this.getRelatedFiscalTransactionReferenceIds():null);
            List<RelatedFiscalTransactionReferenceId> rhsRelatedFiscalTransactionReferenceIds;
            rhsRelatedFiscalTransactionReferenceIds = (((that.relatedFiscalTransactionReferenceIds!= null)&&(!that.relatedFiscalTransactionReferenceIds.isEmpty()))?that.getRelatedFiscalTransactionReferenceIds():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "relatedFiscalTransactionReferenceIds", lhsRelatedFiscalTransactionReferenceIds), LocatorUtils.property(thatLocator, "relatedFiscalTransactionReferenceIds", rhsRelatedFiscalTransactionReferenceIds), lhsRelatedFiscalTransactionReferenceIds, rhsRelatedFiscalTransactionReferenceIds, ((this.relatedFiscalTransactionReferenceIds!= null)&&(!this.relatedFiscalTransactionReferenceIds.isEmpty())), ((that.relatedFiscalTransactionReferenceIds!= null)&&(!that.relatedFiscalTransactionReferenceIds.isEmpty())))) {
                return false;
            }
        }
        {
            SchemeValuePair lhsFiscalTransactionType;
            lhsFiscalTransactionType = this.getFiscalTransactionType();
            SchemeValuePair rhsFiscalTransactionType;
            rhsFiscalTransactionType = that.getFiscalTransactionType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fiscalTransactionType", lhsFiscalTransactionType), LocatorUtils.property(thatLocator, "fiscalTransactionType", rhsFiscalTransactionType), lhsFiscalTransactionType, rhsFiscalTransactionType, (this.fiscalTransactionType!= null), (that.fiscalTransactionType!= null))) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsValidFromDate;
            lhsValidFromDate = this.getValidFromDate();
            XMLGregorianCalendar rhsValidFromDate;
            rhsValidFromDate = that.getValidFromDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validFromDate", lhsValidFromDate), LocatorUtils.property(thatLocator, "validFromDate", rhsValidFromDate), lhsValidFromDate, rhsValidFromDate, (this.validFromDate!= null), (that.validFromDate!= null))) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsValidToDate;
            lhsValidToDate = this.getValidToDate();
            XMLGregorianCalendar rhsValidToDate;
            rhsValidToDate = that.getValidToDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "validToDate", lhsValidToDate), LocatorUtils.property(thatLocator, "validToDate", rhsValidToDate), lhsValidToDate, rhsValidToDate, (this.validToDate!= null), (that.validToDate!= null))) {
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
            SchemeValuePair lhsPaymentMethodType;
            lhsPaymentMethodType = this.getPaymentMethodType();
            SchemeValuePair rhsPaymentMethodType;
            rhsPaymentMethodType = that.getPaymentMethodType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "paymentMethodType", lhsPaymentMethodType), LocatorUtils.property(thatLocator, "paymentMethodType", rhsPaymentMethodType), lhsPaymentMethodType, rhsPaymentMethodType, (this.paymentMethodType!= null), (that.paymentMethodType!= null))) {
                return false;
            }
        }
        {
            String lhsFiscalTransactionDescription;
            lhsFiscalTransactionDescription = this.getFiscalTransactionDescription();
            String rhsFiscalTransactionDescription;
            rhsFiscalTransactionDescription = that.getFiscalTransactionDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fiscalTransactionDescription", lhsFiscalTransactionDescription), LocatorUtils.property(thatLocator, "fiscalTransactionDescription", rhsFiscalTransactionDescription), lhsFiscalTransactionDescription, rhsFiscalTransactionDescription, (this.fiscalTransactionDescription!= null), (that.fiscalTransactionDescription!= null))) {
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
            ItemDetails lhsItemDetails;
            lhsItemDetails = this.getItemDetails();
            ItemDetails rhsItemDetails;
            rhsItemDetails = that.getItemDetails();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "itemDetails", lhsItemDetails), LocatorUtils.property(thatLocator, "itemDetails", rhsItemDetails), lhsItemDetails, rhsItemDetails, (this.itemDetails!= null), (that.itemDetails!= null))) {
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
            SchemeValuePair theFiscalActionType;
            theFiscalActionType = this.getFiscalActionType();
            strategy.appendField(locator, this, "fiscalActionType", buffer, theFiscalActionType, (this.fiscalActionType!= null));
        }
        {
            FiscalTransactionReferenceId theFiscalTransactionReferenceId;
            theFiscalTransactionReferenceId = this.getFiscalTransactionReferenceId();
            strategy.appendField(locator, this, "fiscalTransactionReferenceId", buffer, theFiscalTransactionReferenceId, (this.fiscalTransactionReferenceId!= null));
        }
        {
            List<RelatedFiscalTransactionReferenceId> theRelatedFiscalTransactionReferenceIds;
            theRelatedFiscalTransactionReferenceIds = (((this.relatedFiscalTransactionReferenceIds!= null)&&(!this.relatedFiscalTransactionReferenceIds.isEmpty()))?this.getRelatedFiscalTransactionReferenceIds():null);
            strategy.appendField(locator, this, "relatedFiscalTransactionReferenceIds", buffer, theRelatedFiscalTransactionReferenceIds, ((this.relatedFiscalTransactionReferenceIds!= null)&&(!this.relatedFiscalTransactionReferenceIds.isEmpty())));
        }
        {
            SchemeValuePair theFiscalTransactionType;
            theFiscalTransactionType = this.getFiscalTransactionType();
            strategy.appendField(locator, this, "fiscalTransactionType", buffer, theFiscalTransactionType, (this.fiscalTransactionType!= null));
        }
        {
            XMLGregorianCalendar theValidFromDate;
            theValidFromDate = this.getValidFromDate();
            strategy.appendField(locator, this, "validFromDate", buffer, theValidFromDate, (this.validFromDate!= null));
        }
        {
            XMLGregorianCalendar theValidToDate;
            theValidToDate = this.getValidToDate();
            strategy.appendField(locator, this, "validToDate", buffer, theValidToDate, (this.validToDate!= null));
        }
        {
            Amount theAmount;
            theAmount = this.getAmount();
            strategy.appendField(locator, this, "amount", buffer, theAmount, (this.amount!= null));
        }
        {
            SchemeValuePair thePaymentMethodType;
            thePaymentMethodType = this.getPaymentMethodType();
            strategy.appendField(locator, this, "paymentMethodType", buffer, thePaymentMethodType, (this.paymentMethodType!= null));
        }
        {
            String theFiscalTransactionDescription;
            theFiscalTransactionDescription = this.getFiscalTransactionDescription();
            strategy.appendField(locator, this, "fiscalTransactionDescription", buffer, theFiscalTransactionDescription, (this.fiscalTransactionDescription!= null));
        }
        {
            RequestId theRequestId;
            theRequestId = this.getRequestId();
            strategy.appendField(locator, this, "requestId", buffer, theRequestId, (this.requestId!= null));
        }
        {
            ItemDetails theItemDetails;
            theItemDetails = this.getItemDetails();
            strategy.appendField(locator, this, "itemDetails", buffer, theItemDetails, (this.itemDetails!= null));
        }
        {
            Ext theExt;
            theExt = this.getExt();
            strategy.appendField(locator, this, "ext", buffer, theExt, (this.ext!= null));
        }
        return buffer;
    }

}