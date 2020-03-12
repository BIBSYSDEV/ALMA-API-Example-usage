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
 * Specific researcher's education info.
 * 
 * <p>Java class for researcher_education complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="researcher_education"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="organization_code" type="{}string255Length" minOccurs="0"/&gt;
 *         &lt;element name="organization_name" type="{}string255Length" minOccurs="0"/&gt;
 *         &lt;element name="degree" type="{}string255Length" minOccurs="0"/&gt;
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="field_of_study" type="{}string255Length" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "researcher_education", propOrder = {
    "organizationCode",
    "organizationName",
    "degree",
    "year",
    "fieldOfStudy"
})
public class ResearcherEducation implements Serializable, Equals2, HashCode2, ToString2
{

    @XmlElement(name = "organization_code")
    protected String organizationCode;
    @XmlElement(name = "organization_name")
    protected String organizationName;
    protected String degree;
    protected Integer year;
    @XmlElement(name = "field_of_study")
    protected String fieldOfStudy;

    /**
     * Gets the value of the organizationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * Sets the value of the organizationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationCode(String value) {
        this.organizationCode = value;
    }

    /**
     * Gets the value of the organizationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * Sets the value of the organizationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationName(String value) {
        this.organizationName = value;
    }

    /**
     * Gets the value of the degree property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDegree() {
        return degree;
    }

    /**
     * Sets the value of the degree property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDegree(String value) {
        this.degree = value;
    }

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setYear(Integer value) {
        this.year = value;
    }

    /**
     * Gets the value of the fieldOfStudy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    /**
     * Sets the value of the fieldOfStudy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldOfStudy(String value) {
        this.fieldOfStudy = value;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theOrganizationCode;
            theOrganizationCode = this.getOrganizationCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "organizationCode", theOrganizationCode), currentHashCode, theOrganizationCode, (this.organizationCode!= null));
        }
        {
            String theOrganizationName;
            theOrganizationName = this.getOrganizationName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "organizationName", theOrganizationName), currentHashCode, theOrganizationName, (this.organizationName!= null));
        }
        {
            String theDegree;
            theDegree = this.getDegree();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "degree", theDegree), currentHashCode, theDegree, (this.degree!= null));
        }
        {
            Integer theYear;
            theYear = this.getYear();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "year", theYear), currentHashCode, theYear, (this.year!= null));
        }
        {
            String theFieldOfStudy;
            theFieldOfStudy = this.getFieldOfStudy();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "fieldOfStudy", theFieldOfStudy), currentHashCode, theFieldOfStudy, (this.fieldOfStudy!= null));
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
        final ResearcherEducation that = ((ResearcherEducation) object);
        {
            String lhsOrganizationCode;
            lhsOrganizationCode = this.getOrganizationCode();
            String rhsOrganizationCode;
            rhsOrganizationCode = that.getOrganizationCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "organizationCode", lhsOrganizationCode), LocatorUtils.property(thatLocator, "organizationCode", rhsOrganizationCode), lhsOrganizationCode, rhsOrganizationCode, (this.organizationCode!= null), (that.organizationCode!= null))) {
                return false;
            }
        }
        {
            String lhsOrganizationName;
            lhsOrganizationName = this.getOrganizationName();
            String rhsOrganizationName;
            rhsOrganizationName = that.getOrganizationName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "organizationName", lhsOrganizationName), LocatorUtils.property(thatLocator, "organizationName", rhsOrganizationName), lhsOrganizationName, rhsOrganizationName, (this.organizationName!= null), (that.organizationName!= null))) {
                return false;
            }
        }
        {
            String lhsDegree;
            lhsDegree = this.getDegree();
            String rhsDegree;
            rhsDegree = that.getDegree();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "degree", lhsDegree), LocatorUtils.property(thatLocator, "degree", rhsDegree), lhsDegree, rhsDegree, (this.degree!= null), (that.degree!= null))) {
                return false;
            }
        }
        {
            Integer lhsYear;
            lhsYear = this.getYear();
            Integer rhsYear;
            rhsYear = that.getYear();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "year", lhsYear), LocatorUtils.property(thatLocator, "year", rhsYear), lhsYear, rhsYear, (this.year!= null), (that.year!= null))) {
                return false;
            }
        }
        {
            String lhsFieldOfStudy;
            lhsFieldOfStudy = this.getFieldOfStudy();
            String rhsFieldOfStudy;
            rhsFieldOfStudy = that.getFieldOfStudy();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "fieldOfStudy", lhsFieldOfStudy), LocatorUtils.property(thatLocator, "fieldOfStudy", rhsFieldOfStudy), lhsFieldOfStudy, rhsFieldOfStudy, (this.fieldOfStudy!= null), (that.fieldOfStudy!= null))) {
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
            String theOrganizationCode;
            theOrganizationCode = this.getOrganizationCode();
            strategy.appendField(locator, this, "organizationCode", buffer, theOrganizationCode, (this.organizationCode!= null));
        }
        {
            String theOrganizationName;
            theOrganizationName = this.getOrganizationName();
            strategy.appendField(locator, this, "organizationName", buffer, theOrganizationName, (this.organizationName!= null));
        }
        {
            String theDegree;
            theDegree = this.getDegree();
            strategy.appendField(locator, this, "degree", buffer, theDegree, (this.degree!= null));
        }
        {
            Integer theYear;
            theYear = this.getYear();
            strategy.appendField(locator, this, "year", buffer, theYear, (this.year!= null));
        }
        {
            String theFieldOfStudy;
            theFieldOfStudy = this.getFieldOfStudy();
            strategy.appendField(locator, this, "fieldOfStudy", buffer, theFieldOfStudy, (this.fieldOfStudy!= null));
        }
        return buffer;
    }

}
