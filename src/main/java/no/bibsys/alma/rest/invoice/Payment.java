//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:28:07 AM CET 
//


package no.bibsys.alma.rest.invoice;

import java.io.Serializable;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
import org.w3._2001.xmlschema.Adapter2;


/**
 * Payment information.
 * 
 * <p>Java class for payment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="payment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="prepaid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="internal_copy" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="export_to_erp" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="payment_status" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="voucher_date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="voucher_number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="voucher_amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="voucher_currency" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payment", propOrder = {

})
public class Payment implements Serializable, Equals2, HashCode2, ToString2
{

    protected Boolean prepaid;
    @XmlElement(name = "internal_copy")
    protected Boolean internalCopy;
    @XmlElement(name = "export_to_erp")
    protected Boolean exportToErp;
    @XmlElement(name = "payment_status")
    protected PaymentStatus paymentStatus;
    @XmlElement(name = "voucher_date", type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected Calendar voucherDate;
    @XmlElement(name = "voucher_number")
    protected String voucherNumber;
    @XmlElement(name = "voucher_amount")
    protected String voucherAmount;
    @XmlElement(name = "voucher_currency")
    protected VoucherCurrency voucherCurrency;

    /**
     * Gets the value of the prepaid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPrepaid() {
        return prepaid;
    }

    /**
     * Sets the value of the prepaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPrepaid(Boolean value) {
        this.prepaid = value;
    }

    /**
     * Gets the value of the internalCopy property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInternalCopy() {
        return internalCopy;
    }

    /**
     * Sets the value of the internalCopy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInternalCopy(Boolean value) {
        this.internalCopy = value;
    }

    /**
     * Gets the value of the exportToErp property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExportToErp() {
        return exportToErp;
    }

    /**
     * Sets the value of the exportToErp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExportToErp(Boolean value) {
        this.exportToErp = value;
    }

    /**
     * Gets the value of the paymentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentStatus }
     *     
     */
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * Sets the value of the paymentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentStatus }
     *     
     */
    public void setPaymentStatus(PaymentStatus value) {
        this.paymentStatus = value;
    }

    /**
     * Gets the value of the voucherDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getVoucherDate() {
        return voucherDate;
    }

    /**
     * Sets the value of the voucherDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherDate(Calendar value) {
        this.voucherDate = value;
    }

    /**
     * Gets the value of the voucherNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherNumber() {
        return voucherNumber;
    }

    /**
     * Sets the value of the voucherNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherNumber(String value) {
        this.voucherNumber = value;
    }

    /**
     * Gets the value of the voucherAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherAmount() {
        return voucherAmount;
    }

    /**
     * Sets the value of the voucherAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherAmount(String value) {
        this.voucherAmount = value;
    }

    /**
     * Gets the value of the voucherCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link VoucherCurrency }
     *     
     */
    public VoucherCurrency getVoucherCurrency() {
        return voucherCurrency;
    }

    /**
     * Sets the value of the voucherCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link VoucherCurrency }
     *     
     */
    public void setVoucherCurrency(VoucherCurrency value) {
        this.voucherCurrency = value;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            Boolean thePrepaid;
            thePrepaid = this.isPrepaid();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "prepaid", thePrepaid), currentHashCode, thePrepaid, (this.prepaid!= null));
        }
        {
            Boolean theInternalCopy;
            theInternalCopy = this.isInternalCopy();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "internalCopy", theInternalCopy), currentHashCode, theInternalCopy, (this.internalCopy!= null));
        }
        {
            Boolean theExportToErp;
            theExportToErp = this.isExportToErp();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "exportToErp", theExportToErp), currentHashCode, theExportToErp, (this.exportToErp!= null));
        }
        {
            PaymentStatus thePaymentStatus;
            thePaymentStatus = this.getPaymentStatus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "paymentStatus", thePaymentStatus), currentHashCode, thePaymentStatus, (this.paymentStatus!= null));
        }
        {
            Calendar theVoucherDate;
            theVoucherDate = this.getVoucherDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "voucherDate", theVoucherDate), currentHashCode, theVoucherDate, (this.voucherDate!= null));
        }
        {
            String theVoucherNumber;
            theVoucherNumber = this.getVoucherNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "voucherNumber", theVoucherNumber), currentHashCode, theVoucherNumber, (this.voucherNumber!= null));
        }
        {
            String theVoucherAmount;
            theVoucherAmount = this.getVoucherAmount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "voucherAmount", theVoucherAmount), currentHashCode, theVoucherAmount, (this.voucherAmount!= null));
        }
        {
            VoucherCurrency theVoucherCurrency;
            theVoucherCurrency = this.getVoucherCurrency();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "voucherCurrency", theVoucherCurrency), currentHashCode, theVoucherCurrency, (this.voucherCurrency!= null));
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
        final Payment that = ((Payment) object);
        {
            Boolean lhsPrepaid;
            lhsPrepaid = this.isPrepaid();
            Boolean rhsPrepaid;
            rhsPrepaid = that.isPrepaid();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "prepaid", lhsPrepaid), LocatorUtils.property(thatLocator, "prepaid", rhsPrepaid), lhsPrepaid, rhsPrepaid, (this.prepaid!= null), (that.prepaid!= null))) {
                return false;
            }
        }
        {
            Boolean lhsInternalCopy;
            lhsInternalCopy = this.isInternalCopy();
            Boolean rhsInternalCopy;
            rhsInternalCopy = that.isInternalCopy();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "internalCopy", lhsInternalCopy), LocatorUtils.property(thatLocator, "internalCopy", rhsInternalCopy), lhsInternalCopy, rhsInternalCopy, (this.internalCopy!= null), (that.internalCopy!= null))) {
                return false;
            }
        }
        {
            Boolean lhsExportToErp;
            lhsExportToErp = this.isExportToErp();
            Boolean rhsExportToErp;
            rhsExportToErp = that.isExportToErp();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "exportToErp", lhsExportToErp), LocatorUtils.property(thatLocator, "exportToErp", rhsExportToErp), lhsExportToErp, rhsExportToErp, (this.exportToErp!= null), (that.exportToErp!= null))) {
                return false;
            }
        }
        {
            PaymentStatus lhsPaymentStatus;
            lhsPaymentStatus = this.getPaymentStatus();
            PaymentStatus rhsPaymentStatus;
            rhsPaymentStatus = that.getPaymentStatus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "paymentStatus", lhsPaymentStatus), LocatorUtils.property(thatLocator, "paymentStatus", rhsPaymentStatus), lhsPaymentStatus, rhsPaymentStatus, (this.paymentStatus!= null), (that.paymentStatus!= null))) {
                return false;
            }
        }
        {
            Calendar lhsVoucherDate;
            lhsVoucherDate = this.getVoucherDate();
            Calendar rhsVoucherDate;
            rhsVoucherDate = that.getVoucherDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "voucherDate", lhsVoucherDate), LocatorUtils.property(thatLocator, "voucherDate", rhsVoucherDate), lhsVoucherDate, rhsVoucherDate, (this.voucherDate!= null), (that.voucherDate!= null))) {
                return false;
            }
        }
        {
            String lhsVoucherNumber;
            lhsVoucherNumber = this.getVoucherNumber();
            String rhsVoucherNumber;
            rhsVoucherNumber = that.getVoucherNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "voucherNumber", lhsVoucherNumber), LocatorUtils.property(thatLocator, "voucherNumber", rhsVoucherNumber), lhsVoucherNumber, rhsVoucherNumber, (this.voucherNumber!= null), (that.voucherNumber!= null))) {
                return false;
            }
        }
        {
            String lhsVoucherAmount;
            lhsVoucherAmount = this.getVoucherAmount();
            String rhsVoucherAmount;
            rhsVoucherAmount = that.getVoucherAmount();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "voucherAmount", lhsVoucherAmount), LocatorUtils.property(thatLocator, "voucherAmount", rhsVoucherAmount), lhsVoucherAmount, rhsVoucherAmount, (this.voucherAmount!= null), (that.voucherAmount!= null))) {
                return false;
            }
        }
        {
            VoucherCurrency lhsVoucherCurrency;
            lhsVoucherCurrency = this.getVoucherCurrency();
            VoucherCurrency rhsVoucherCurrency;
            rhsVoucherCurrency = that.getVoucherCurrency();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "voucherCurrency", lhsVoucherCurrency), LocatorUtils.property(thatLocator, "voucherCurrency", rhsVoucherCurrency), lhsVoucherCurrency, rhsVoucherCurrency, (this.voucherCurrency!= null), (that.voucherCurrency!= null))) {
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
            Boolean thePrepaid;
            thePrepaid = this.isPrepaid();
            strategy.appendField(locator, this, "prepaid", buffer, thePrepaid, (this.prepaid!= null));
        }
        {
            Boolean theInternalCopy;
            theInternalCopy = this.isInternalCopy();
            strategy.appendField(locator, this, "internalCopy", buffer, theInternalCopy, (this.internalCopy!= null));
        }
        {
            Boolean theExportToErp;
            theExportToErp = this.isExportToErp();
            strategy.appendField(locator, this, "exportToErp", buffer, theExportToErp, (this.exportToErp!= null));
        }
        {
            PaymentStatus thePaymentStatus;
            thePaymentStatus = this.getPaymentStatus();
            strategy.appendField(locator, this, "paymentStatus", buffer, thePaymentStatus, (this.paymentStatus!= null));
        }
        {
            Calendar theVoucherDate;
            theVoucherDate = this.getVoucherDate();
            strategy.appendField(locator, this, "voucherDate", buffer, theVoucherDate, (this.voucherDate!= null));
        }
        {
            String theVoucherNumber;
            theVoucherNumber = this.getVoucherNumber();
            strategy.appendField(locator, this, "voucherNumber", buffer, theVoucherNumber, (this.voucherNumber!= null));
        }
        {
            String theVoucherAmount;
            theVoucherAmount = this.getVoucherAmount();
            strategy.appendField(locator, this, "voucherAmount", buffer, theVoucherAmount, (this.voucherAmount!= null));
        }
        {
            VoucherCurrency theVoucherCurrency;
            theVoucherCurrency = this.getVoucherCurrency();
            strategy.appendField(locator, this, "voucherCurrency", buffer, theVoucherCurrency, (this.voucherCurrency!= null));
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
    public static class PaymentStatus implements Serializable, Equals2, HashCode2, ToString2
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
            final PaymentStatus that = ((PaymentStatus) object);
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
    public static class VoucherCurrency implements Serializable, Equals2, HashCode2, ToString2
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
            final VoucherCurrency that = ((VoucherCurrency) object);
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