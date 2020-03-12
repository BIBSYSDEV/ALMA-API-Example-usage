//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:28:11 AM CET 
//


package no.bibsys.alma.rest.user;

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
 * Specific user statistic.
 * 
 * <p>Java class for user_statistic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="user_statistic"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="statistic_category"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;&gt;string255Length"&gt;
 *                 &lt;attribute name="desc" type="{}string4000Length" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="category_type" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;&gt;string255Length"&gt;
 *                 &lt;attribute name="desc" type="{}string4000Length" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="statistic_note" type="{}string2000Length" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *       &lt;attribute name="segment_type" type="{}string10Length" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user_statistic", propOrder = {

})
public class UserStatistic implements Serializable, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "statistic_category", required = true)
    protected StatisticCategory statisticCategory;
    @XmlElement(name = "category_type")
    protected CategoryType categoryType;
    @XmlElement(name = "statistic_note")
    protected String statisticNote;
    @XmlAttribute(name = "segment_type")
    protected String segmentType;

    /**
     * Gets the value of the statisticCategory property.
     * 
     * @return
     *     possible object is
     *     {@link StatisticCategory }
     *     
     */
    public StatisticCategory getStatisticCategory() {
        return statisticCategory;
    }

    /**
     * Sets the value of the statisticCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatisticCategory }
     *     
     */
    public void setStatisticCategory(StatisticCategory value) {
        this.statisticCategory = value;
    }

    /**
     * Gets the value of the categoryType property.
     * 
     * @return
     *     possible object is
     *     {@link CategoryType }
     *     
     */
    public CategoryType getCategoryType() {
        return categoryType;
    }

    /**
     * Sets the value of the categoryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryType }
     *     
     */
    public void setCategoryType(CategoryType value) {
        this.categoryType = value;
    }

    /**
     * Gets the value of the statisticNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatisticNote() {
        return statisticNote;
    }

    /**
     * Sets the value of the statisticNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatisticNote(String value) {
        this.statisticNote = value;
    }

    /**
     * Gets the value of the segmentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegmentType() {
        return segmentType;
    }

    /**
     * Sets the value of the segmentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegmentType(String value) {
        this.segmentType = value;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            StatisticCategory theStatisticCategory;
            theStatisticCategory = this.getStatisticCategory();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "statisticCategory", theStatisticCategory), currentHashCode, theStatisticCategory, (this.statisticCategory!= null));
        }
        {
            CategoryType theCategoryType;
            theCategoryType = this.getCategoryType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "categoryType", theCategoryType), currentHashCode, theCategoryType, (this.categoryType!= null));
        }
        {
            String theStatisticNote;
            theStatisticNote = this.getStatisticNote();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "statisticNote", theStatisticNote), currentHashCode, theStatisticNote, (this.statisticNote!= null));
        }
        {
            String theSegmentType;
            theSegmentType = this.getSegmentType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "segmentType", theSegmentType), currentHashCode, theSegmentType, (this.segmentType!= null));
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
        final UserStatistic that = ((UserStatistic) object);
        {
            StatisticCategory lhsStatisticCategory;
            lhsStatisticCategory = this.getStatisticCategory();
            StatisticCategory rhsStatisticCategory;
            rhsStatisticCategory = that.getStatisticCategory();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "statisticCategory", lhsStatisticCategory), LocatorUtils.property(thatLocator, "statisticCategory", rhsStatisticCategory), lhsStatisticCategory, rhsStatisticCategory, (this.statisticCategory!= null), (that.statisticCategory!= null))) {
                return false;
            }
        }
        {
            CategoryType lhsCategoryType;
            lhsCategoryType = this.getCategoryType();
            CategoryType rhsCategoryType;
            rhsCategoryType = that.getCategoryType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "categoryType", lhsCategoryType), LocatorUtils.property(thatLocator, "categoryType", rhsCategoryType), lhsCategoryType, rhsCategoryType, (this.categoryType!= null), (that.categoryType!= null))) {
                return false;
            }
        }
        {
            String lhsStatisticNote;
            lhsStatisticNote = this.getStatisticNote();
            String rhsStatisticNote;
            rhsStatisticNote = that.getStatisticNote();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "statisticNote", lhsStatisticNote), LocatorUtils.property(thatLocator, "statisticNote", rhsStatisticNote), lhsStatisticNote, rhsStatisticNote, (this.statisticNote!= null), (that.statisticNote!= null))) {
                return false;
            }
        }
        {
            String lhsSegmentType;
            lhsSegmentType = this.getSegmentType();
            String rhsSegmentType;
            rhsSegmentType = that.getSegmentType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "segmentType", lhsSegmentType), LocatorUtils.property(thatLocator, "segmentType", rhsSegmentType), lhsSegmentType, rhsSegmentType, (this.segmentType!= null), (that.segmentType!= null))) {
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
            StatisticCategory theStatisticCategory;
            theStatisticCategory = this.getStatisticCategory();
            strategy.appendField(locator, this, "statisticCategory", buffer, theStatisticCategory, (this.statisticCategory!= null));
        }
        {
            CategoryType theCategoryType;
            theCategoryType = this.getCategoryType();
            strategy.appendField(locator, this, "categoryType", buffer, theCategoryType, (this.categoryType!= null));
        }
        {
            String theStatisticNote;
            theStatisticNote = this.getStatisticNote();
            strategy.appendField(locator, this, "statisticNote", buffer, theStatisticNote, (this.statisticNote!= null));
        }
        {
            String theSegmentType;
            theSegmentType = this.getSegmentType();
            strategy.appendField(locator, this, "segmentType", buffer, theSegmentType, (this.segmentType!= null));
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
     *     &lt;extension base="&lt;&gt;string255Length"&gt;
     *       &lt;attribute name="desc" type="{}string4000Length" /&gt;
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
    public static class CategoryType implements Serializable, Equals2, HashCode2, ToString2
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
            final CategoryType that = ((CategoryType) object);
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
     *     &lt;extension base="&lt;&gt;string255Length"&gt;
     *       &lt;attribute name="desc" type="{}string4000Length" /&gt;
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
    public static class StatisticCategory implements Serializable, Equals2, HashCode2, ToString2
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
            final StatisticCategory that = ((StatisticCategory) object);
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