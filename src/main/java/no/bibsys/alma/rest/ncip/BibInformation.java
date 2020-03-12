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
 *         &lt;element ref="{http://www.niso.org/2008/ncip}BibliographicId" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element ref="{http://www.niso.org/2008/ncip}BibliographicDescription" minOccurs="0"/&gt;
 *             &lt;element ref="{http://www.niso.org/2008/ncip}TitleHoldQueueLength" minOccurs="0"/&gt;
 *             &lt;element ref="{http://www.niso.org/2008/ncip}CurrentRequester" maxOccurs="unbounded" minOccurs="0"/&gt;
 *             &lt;element ref="{http://www.niso.org/2008/ncip}HoldingsSet" maxOccurs="unbounded"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;element ref="{http://www.niso.org/2008/ncip}Problem" maxOccurs="unbounded"/&gt;
 *         &lt;/choice&gt;
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
    "bibliographicId",
    "problems",
    "bibliographicDescription",
    "titleHoldQueueLength",
    "currentRequesters",
    "holdingsSets"
})
@XmlRootElement(name = "BibInformation")
public class BibInformation implements Equals2, HashCode2, ToString2
{

    @XmlElement(name = "BibliographicId")
    protected BibliographicId bibliographicId;
    @XmlElement(name = "Problem")
    protected List<Problem> problems;
    @XmlElement(name = "BibliographicDescription")
    protected BibliographicDescription bibliographicDescription;
    @XmlElement(name = "TitleHoldQueueLength")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger titleHoldQueueLength;
    @XmlElement(name = "CurrentRequester")
    protected List<CurrentRequester> currentRequesters;
    @XmlElement(name = "HoldingsSet")
    protected List<HoldingsSet> holdingsSets;

    /**
     * Gets the value of the bibliographicId property.
     * 
     * @return
     *     possible object is
     *     {@link BibliographicId }
     *     
     */
    public BibliographicId getBibliographicId() {
        return bibliographicId;
    }

    /**
     * Sets the value of the bibliographicId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BibliographicId }
     *     
     */
    public void setBibliographicId(BibliographicId value) {
        this.bibliographicId = value;
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
     * Gets the value of the titleHoldQueueLength property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTitleHoldQueueLength() {
        return titleHoldQueueLength;
    }

    /**
     * Sets the value of the titleHoldQueueLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTitleHoldQueueLength(BigInteger value) {
        this.titleHoldQueueLength = value;
    }

    /**
     * Gets the value of the currentRequesters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currentRequesters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrentRequesters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CurrentRequester }
     * 
     * 
     */
    public List<CurrentRequester> getCurrentRequesters() {
        if (currentRequesters == null) {
            currentRequesters = new ArrayList<CurrentRequester>();
        }
        return this.currentRequesters;
    }

    /**
     * Gets the value of the holdingsSets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the holdingsSets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHoldingsSets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HoldingsSet }
     * 
     * 
     */
    public List<HoldingsSet> getHoldingsSets() {
        if (holdingsSets == null) {
            holdingsSets = new ArrayList<HoldingsSet>();
        }
        return this.holdingsSets;
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            BibliographicId theBibliographicId;
            theBibliographicId = this.getBibliographicId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bibliographicId", theBibliographicId), currentHashCode, theBibliographicId, (this.bibliographicId!= null));
        }
        {
            List<Problem> theProblems;
            theProblems = (((this.problems!= null)&&(!this.problems.isEmpty()))?this.getProblems():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "problems", theProblems), currentHashCode, theProblems, ((this.problems!= null)&&(!this.problems.isEmpty())));
        }
        {
            BibliographicDescription theBibliographicDescription;
            theBibliographicDescription = this.getBibliographicDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bibliographicDescription", theBibliographicDescription), currentHashCode, theBibliographicDescription, (this.bibliographicDescription!= null));
        }
        {
            BigInteger theTitleHoldQueueLength;
            theTitleHoldQueueLength = this.getTitleHoldQueueLength();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "titleHoldQueueLength", theTitleHoldQueueLength), currentHashCode, theTitleHoldQueueLength, (this.titleHoldQueueLength!= null));
        }
        {
            List<CurrentRequester> theCurrentRequesters;
            theCurrentRequesters = (((this.currentRequesters!= null)&&(!this.currentRequesters.isEmpty()))?this.getCurrentRequesters():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "currentRequesters", theCurrentRequesters), currentHashCode, theCurrentRequesters, ((this.currentRequesters!= null)&&(!this.currentRequesters.isEmpty())));
        }
        {
            List<HoldingsSet> theHoldingsSets;
            theHoldingsSets = (((this.holdingsSets!= null)&&(!this.holdingsSets.isEmpty()))?this.getHoldingsSets():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "holdingsSets", theHoldingsSets), currentHashCode, theHoldingsSets, ((this.holdingsSets!= null)&&(!this.holdingsSets.isEmpty())));
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
        final BibInformation that = ((BibInformation) object);
        {
            BibliographicId lhsBibliographicId;
            lhsBibliographicId = this.getBibliographicId();
            BibliographicId rhsBibliographicId;
            rhsBibliographicId = that.getBibliographicId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bibliographicId", lhsBibliographicId), LocatorUtils.property(thatLocator, "bibliographicId", rhsBibliographicId), lhsBibliographicId, rhsBibliographicId, (this.bibliographicId!= null), (that.bibliographicId!= null))) {
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
            BibliographicDescription lhsBibliographicDescription;
            lhsBibliographicDescription = this.getBibliographicDescription();
            BibliographicDescription rhsBibliographicDescription;
            rhsBibliographicDescription = that.getBibliographicDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bibliographicDescription", lhsBibliographicDescription), LocatorUtils.property(thatLocator, "bibliographicDescription", rhsBibliographicDescription), lhsBibliographicDescription, rhsBibliographicDescription, (this.bibliographicDescription!= null), (that.bibliographicDescription!= null))) {
                return false;
            }
        }
        {
            BigInteger lhsTitleHoldQueueLength;
            lhsTitleHoldQueueLength = this.getTitleHoldQueueLength();
            BigInteger rhsTitleHoldQueueLength;
            rhsTitleHoldQueueLength = that.getTitleHoldQueueLength();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "titleHoldQueueLength", lhsTitleHoldQueueLength), LocatorUtils.property(thatLocator, "titleHoldQueueLength", rhsTitleHoldQueueLength), lhsTitleHoldQueueLength, rhsTitleHoldQueueLength, (this.titleHoldQueueLength!= null), (that.titleHoldQueueLength!= null))) {
                return false;
            }
        }
        {
            List<CurrentRequester> lhsCurrentRequesters;
            lhsCurrentRequesters = (((this.currentRequesters!= null)&&(!this.currentRequesters.isEmpty()))?this.getCurrentRequesters():null);
            List<CurrentRequester> rhsCurrentRequesters;
            rhsCurrentRequesters = (((that.currentRequesters!= null)&&(!that.currentRequesters.isEmpty()))?that.getCurrentRequesters():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "currentRequesters", lhsCurrentRequesters), LocatorUtils.property(thatLocator, "currentRequesters", rhsCurrentRequesters), lhsCurrentRequesters, rhsCurrentRequesters, ((this.currentRequesters!= null)&&(!this.currentRequesters.isEmpty())), ((that.currentRequesters!= null)&&(!that.currentRequesters.isEmpty())))) {
                return false;
            }
        }
        {
            List<HoldingsSet> lhsHoldingsSets;
            lhsHoldingsSets = (((this.holdingsSets!= null)&&(!this.holdingsSets.isEmpty()))?this.getHoldingsSets():null);
            List<HoldingsSet> rhsHoldingsSets;
            rhsHoldingsSets = (((that.holdingsSets!= null)&&(!that.holdingsSets.isEmpty()))?that.getHoldingsSets():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "holdingsSets", lhsHoldingsSets), LocatorUtils.property(thatLocator, "holdingsSets", rhsHoldingsSets), lhsHoldingsSets, rhsHoldingsSets, ((this.holdingsSets!= null)&&(!this.holdingsSets.isEmpty())), ((that.holdingsSets!= null)&&(!that.holdingsSets.isEmpty())))) {
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
            BibliographicId theBibliographicId;
            theBibliographicId = this.getBibliographicId();
            strategy.appendField(locator, this, "bibliographicId", buffer, theBibliographicId, (this.bibliographicId!= null));
        }
        {
            List<Problem> theProblems;
            theProblems = (((this.problems!= null)&&(!this.problems.isEmpty()))?this.getProblems():null);
            strategy.appendField(locator, this, "problems", buffer, theProblems, ((this.problems!= null)&&(!this.problems.isEmpty())));
        }
        {
            BibliographicDescription theBibliographicDescription;
            theBibliographicDescription = this.getBibliographicDescription();
            strategy.appendField(locator, this, "bibliographicDescription", buffer, theBibliographicDescription, (this.bibliographicDescription!= null));
        }
        {
            BigInteger theTitleHoldQueueLength;
            theTitleHoldQueueLength = this.getTitleHoldQueueLength();
            strategy.appendField(locator, this, "titleHoldQueueLength", buffer, theTitleHoldQueueLength, (this.titleHoldQueueLength!= null));
        }
        {
            List<CurrentRequester> theCurrentRequesters;
            theCurrentRequesters = (((this.currentRequesters!= null)&&(!this.currentRequesters.isEmpty()))?this.getCurrentRequesters():null);
            strategy.appendField(locator, this, "currentRequesters", buffer, theCurrentRequesters, ((this.currentRequesters!= null)&&(!this.currentRequesters.isEmpty())));
        }
        {
            List<HoldingsSet> theHoldingsSets;
            theHoldingsSets = (((this.holdingsSets!= null)&&(!this.holdingsSets.isEmpty()))?this.getHoldingsSets():null);
            strategy.appendField(locator, this, "holdingsSets", buffer, theHoldingsSets, ((this.holdingsSets!= null)&&(!this.holdingsSets.isEmpty())));
        }
        return buffer;
    }

}