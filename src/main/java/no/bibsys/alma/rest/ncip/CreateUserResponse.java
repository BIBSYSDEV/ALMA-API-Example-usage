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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}ResponseHeader" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.niso.org/2008/ncip}Problem" maxOccurs="unbounded"/&gt;
 *           &lt;element ref="{http://www.niso.org/2008/ncip}UserId"/&gt;
 *         &lt;/choice&gt;
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
    "responseHeader",
    "userId",
    "problems",
    "ext"
})
@XmlRootElement(name = "CreateUserResponse")
public class CreateUserResponse implements Equals2, HashCode2, ToString2
{

    @XmlElement(name = "ResponseHeader")
    protected ResponseHeader responseHeader;
    @XmlElement(name = "UserId")
    protected UserId userId;
    @XmlElement(name = "Problem")
    protected List<Problem> problems;
    @XmlElement(name = "Ext")
    protected Ext ext;

    /**
     * Gets the value of the responseHeader property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseHeader }
     *     
     */
    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    /**
     * Sets the value of the responseHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseHeader }
     *     
     */
    public void setResponseHeader(ResponseHeader value) {
        this.responseHeader = value;
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
     * Gets the value of the problems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the problems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProblems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Problem }
     * 
     * 
     */
    public List<Problem> getProblems() {
        if (problems == null) {
            problems = new ArrayList<Problem>();
        }
        return this.problems;
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
            ResponseHeader theResponseHeader;
            theResponseHeader = this.getResponseHeader();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "responseHeader", theResponseHeader), currentHashCode, theResponseHeader, (this.responseHeader!= null));
        }
        {
            UserId theUserId;
            theUserId = this.getUserId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "userId", theUserId), currentHashCode, theUserId, (this.userId!= null));
        }
        {
            List<Problem> theProblems;
            theProblems = (((this.problems!= null)&&(!this.problems.isEmpty()))?this.getProblems():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "problems", theProblems), currentHashCode, theProblems, ((this.problems!= null)&&(!this.problems.isEmpty())));
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
        final CreateUserResponse that = ((CreateUserResponse) object);
        {
            ResponseHeader lhsResponseHeader;
            lhsResponseHeader = this.getResponseHeader();
            ResponseHeader rhsResponseHeader;
            rhsResponseHeader = that.getResponseHeader();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "responseHeader", lhsResponseHeader), LocatorUtils.property(thatLocator, "responseHeader", rhsResponseHeader), lhsResponseHeader, rhsResponseHeader, (this.responseHeader!= null), (that.responseHeader!= null))) {
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
            List<Problem> lhsProblems;
            lhsProblems = (((this.problems!= null)&&(!this.problems.isEmpty()))?this.getProblems():null);
            List<Problem> rhsProblems;
            rhsProblems = (((that.problems!= null)&&(!that.problems.isEmpty()))?that.getProblems():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "problems", lhsProblems), LocatorUtils.property(thatLocator, "problems", rhsProblems), lhsProblems, rhsProblems, ((this.problems!= null)&&(!this.problems.isEmpty())), ((that.problems!= null)&&(!that.problems.isEmpty())))) {
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
            ResponseHeader theResponseHeader;
            theResponseHeader = this.getResponseHeader();
            strategy.appendField(locator, this, "responseHeader", buffer, theResponseHeader, (this.responseHeader!= null));
        }
        {
            UserId theUserId;
            theUserId = this.getUserId();
            strategy.appendField(locator, this, "userId", buffer, theUserId, (this.userId!= null));
        }
        {
            List<Problem> theProblems;
            theProblems = (((this.problems!= null)&&(!this.problems.isEmpty()))?this.getProblems():null);
            strategy.appendField(locator, this, "problems", buffer, theProblems, ((this.problems!= null)&&(!this.problems.isEmpty())));
        }
        {
            Ext theExt;
            theExt = this.getExt();
            strategy.appendField(locator, this, "ext", buffer, theExt, (this.ext!= null));
        }
        return buffer;
    }

}
