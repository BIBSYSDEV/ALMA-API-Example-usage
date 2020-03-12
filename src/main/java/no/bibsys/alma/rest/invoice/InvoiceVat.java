//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:28:07 AM CET 
//


package no.bibsys.alma.rest.invoice;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * VAT charge that is included in the invoice.
 * 
 * <p>Java class for invoice_vat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="invoice_vat"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="report_tax" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="vat_per_invoice_line" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="vat_code" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="percentage" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="vat_amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="type" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="expended_from_fund" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="vendor_tax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invoice_vat", propOrder = {

})
public class InvoiceVat implements Serializable, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "report_tax")
    protected Boolean reportTax;
    @XmlElement(name = "vat_per_invoice_line")
    protected Boolean vatPerInvoiceLine;
    @XmlElement(name = "vat_code")
    protected VatCode vatCode;
    protected BigDecimal percentage;
    @XmlElement(name = "vat_amount")
    protected BigDecimal vatAmount;
    protected Type type;
    @XmlElement(name = "expended_from_fund")
    protected Boolean expendedFromFund;
    @XmlElement(name = "vendor_tax")
    protected String vendorTax;

    /**
     * Gets the value of the reportTax property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReportTax() {
        return reportTax;
    }

    /**
     * Sets the value of the reportTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReportTax(Boolean value) {
        this.reportTax = value;
    }

    /**
     * Gets the value of the vatPerInvoiceLine property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVatPerInvoiceLine() {
        return vatPerInvoiceLine;
    }

    /**
     * Sets the value of the vatPerInvoiceLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVatPerInvoiceLine(Boolean value) {
        this.vatPerInvoiceLine = value;
    }

    /**
     * Gets the value of the vatCode property.
     * 
     * @return
     *     possible object is
     *     {@link VatCode }
     *     
     */
    public VatCode getVatCode() {
        return vatCode;
    }

    /**
     * Sets the value of the vatCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link VatCode }
     *     
     */
    public void setVatCode(VatCode value) {
        this.vatCode = value;
    }

    /**
     * Gets the value of the percentage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercentage() {
        return percentage;
    }

    /**
     * Sets the value of the percentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercentage(BigDecimal value) {
        this.percentage = value;
    }

    /**
     * Gets the value of the vatAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVatAmount() {
        return vatAmount;
    }

    /**
     * Sets the value of the vatAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVatAmount(BigDecimal value) {
        this.vatAmount = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Type }
     *     
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Type }
     *     
     */
    public void setType(Type value) {
        this.type = value;
    }

    /**
     * Gets the value of the expendedFromFund property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExpendedFromFund() {
        return expendedFromFund;
    }

    /**
     * Sets the value of the expendedFromFund property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExpendedFromFund(Boolean value) {
        this.expendedFromFund = value;
    }

    /**
     * Gets the value of the vendorTax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendorTax() {
        return vendorTax;
    }

    /**
     * Sets the value of the vendorTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendorTax(String value) {
        this.vendorTax = value;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            Boolean theReportTax;
            theReportTax = this.isReportTax();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "reportTax", theReportTax), currentHashCode, theReportTax, (this.reportTax!= null));
        }
        {
            Boolean theVatPerInvoiceLine;
            theVatPerInvoiceLine = this.isVatPerInvoiceLine();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vatPerInvoiceLine", theVatPerInvoiceLine), currentHashCode, theVatPerInvoiceLine, (this.vatPerInvoiceLine!= null));
        }
        {
            VatCode theVatCode;
            theVatCode = this.getVatCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vatCode", theVatCode), currentHashCode, theVatCode, (this.vatCode!= null));
        }
        {
            BigDecimal thePercentage;
            thePercentage = this.getPercentage();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "percentage", thePercentage), currentHashCode, thePercentage, (this.percentage!= null));
        }
        {
            BigDecimal theVatAmount;
            theVatAmount = this.getVatAmount();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vatAmount", theVatAmount), currentHashCode, theVatAmount, (this.vatAmount!= null));
        }
        {
            Type theType;
            theType = this.getType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "type", theType), currentHashCode, theType, (this.type!= null));
        }
        {
            Boolean theExpendedFromFund;
            theExpendedFromFund = this.isExpendedFromFund();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "expendedFromFund", theExpendedFromFund), currentHashCode, theExpendedFromFund, (this.expendedFromFund!= null));
        }
        {
            String theVendorTax;
            theVendorTax = this.getVendorTax();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vendorTax", theVendorTax), currentHashCode, theVendorTax, (this.vendorTax!= null));
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
        final InvoiceVat that = ((InvoiceVat) object);
        {
            Boolean lhsReportTax;
            lhsReportTax = this.isReportTax();
            Boolean rhsReportTax;
            rhsReportTax = that.isReportTax();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "reportTax", lhsReportTax), LocatorUtils.property(thatLocator, "reportTax", rhsReportTax), lhsReportTax, rhsReportTax, (this.reportTax!= null), (that.reportTax!= null))) {
                return false;
            }
        }
        {
            Boolean lhsVatPerInvoiceLine;
            lhsVatPerInvoiceLine = this.isVatPerInvoiceLine();
            Boolean rhsVatPerInvoiceLine;
            rhsVatPerInvoiceLine = that.isVatPerInvoiceLine();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "vatPerInvoiceLine", lhsVatPerInvoiceLine), LocatorUtils.property(thatLocator, "vatPerInvoiceLine", rhsVatPerInvoiceLine), lhsVatPerInvoiceLine, rhsVatPerInvoiceLine, (this.vatPerInvoiceLine!= null), (that.vatPerInvoiceLine!= null))) {
                return false;
            }
        }
        {
            VatCode lhsVatCode;
            lhsVatCode = this.getVatCode();
            VatCode rhsVatCode;
            rhsVatCode = that.getVatCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "vatCode", lhsVatCode), LocatorUtils.property(thatLocator, "vatCode", rhsVatCode), lhsVatCode, rhsVatCode, (this.vatCode!= null), (that.vatCode!= null))) {
                return false;
            }
        }
        {
            BigDecimal lhsPercentage;
            lhsPercentage = this.getPercentage();
            BigDecimal rhsPercentage;
            rhsPercentage = that.getPercentage();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "percentage", lhsPercentage), LocatorUtils.property(thatLocator, "percentage", rhsPercentage), lhsPercentage, rhsPercentage, (this.percentage!= null), (that.percentage!= null))) {
                return false;
            }
        }
        {
            BigDecimal lhsVatAmount;
            lhsVatAmount = this.getVatAmount();
            BigDecimal rhsVatAmount;
            rhsVatAmount = that.getVatAmount();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "vatAmount", lhsVatAmount), LocatorUtils.property(thatLocator, "vatAmount", rhsVatAmount), lhsVatAmount, rhsVatAmount, (this.vatAmount!= null), (that.vatAmount!= null))) {
                return false;
            }
        }
        {
            Type lhsType;
            lhsType = this.getType();
            Type rhsType;
            rhsType = that.getType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "type", lhsType), LocatorUtils.property(thatLocator, "type", rhsType), lhsType, rhsType, (this.type!= null), (that.type!= null))) {
                return false;
            }
        }
        {
            Boolean lhsExpendedFromFund;
            lhsExpendedFromFund = this.isExpendedFromFund();
            Boolean rhsExpendedFromFund;
            rhsExpendedFromFund = that.isExpendedFromFund();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "expendedFromFund", lhsExpendedFromFund), LocatorUtils.property(thatLocator, "expendedFromFund", rhsExpendedFromFund), lhsExpendedFromFund, rhsExpendedFromFund, (this.expendedFromFund!= null), (that.expendedFromFund!= null))) {
                return false;
            }
        }
        {
            String lhsVendorTax;
            lhsVendorTax = this.getVendorTax();
            String rhsVendorTax;
            rhsVendorTax = that.getVendorTax();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "vendorTax", lhsVendorTax), LocatorUtils.property(thatLocator, "vendorTax", rhsVendorTax), lhsVendorTax, rhsVendorTax, (this.vendorTax!= null), (that.vendorTax!= null))) {
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
            Boolean theReportTax;
            theReportTax = this.isReportTax();
            strategy.appendField(locator, this, "reportTax", buffer, theReportTax, (this.reportTax!= null));
        }
        {
            Boolean theVatPerInvoiceLine;
            theVatPerInvoiceLine = this.isVatPerInvoiceLine();
            strategy.appendField(locator, this, "vatPerInvoiceLine", buffer, theVatPerInvoiceLine, (this.vatPerInvoiceLine!= null));
        }
        {
            VatCode theVatCode;
            theVatCode = this.getVatCode();
            strategy.appendField(locator, this, "vatCode", buffer, theVatCode, (this.vatCode!= null));
        }
        {
            BigDecimal thePercentage;
            thePercentage = this.getPercentage();
            strategy.appendField(locator, this, "percentage", buffer, thePercentage, (this.percentage!= null));
        }
        {
            BigDecimal theVatAmount;
            theVatAmount = this.getVatAmount();
            strategy.appendField(locator, this, "vatAmount", buffer, theVatAmount, (this.vatAmount!= null));
        }
        {
            Type theType;
            theType = this.getType();
            strategy.appendField(locator, this, "type", buffer, theType, (this.type!= null));
        }
        {
            Boolean theExpendedFromFund;
            theExpendedFromFund = this.isExpendedFromFund();
            strategy.appendField(locator, this, "expendedFromFund", buffer, theExpendedFromFund, (this.expendedFromFund!= null));
        }
        {
            String theVendorTax;
            theVendorTax = this.getVendorTax();
            strategy.appendField(locator, this, "vendorTax", buffer, theVendorTax, (this.vendorTax!= null));
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
    public static class Type implements Serializable, Equals2, HashCode2, ToString2
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
            final Type that = ((Type) object);
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
    public static class VatCode implements Serializable, Equals2, HashCode2, ToString2
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
            final VatCode that = ((VatCode) object);
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