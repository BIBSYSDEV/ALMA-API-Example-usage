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
 *         &lt;element ref="{http://www.niso.org/2008/ncip}InitiationHeader" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}MandatedAction" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}AgencyId" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}OrganizationNameInformation" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}AgencyAddressInformation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}AuthenticationPrompt" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}ApplicationProfileSupportedType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}ConsortiumAgreement" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}AgencyUserPrivilegeType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "mandatedAction",
    "agencyId",
    "organizationNameInformations",
    "agencyAddressInformations",
    "authenticationPrompts",
    "applicationProfileSupportedTypes",
    "consortiumAgreements",
    "agencyUserPrivilegeTypes",
    "ext"
})
@XmlRootElement(name = "CreateAgency")
public class CreateAgency implements Equals2, HashCode2, ToString2
{

    @XmlElement(name = "InitiationHeader")
    protected InitiationHeader initiationHeader;
    @XmlElement(name = "MandatedAction")
    protected MandatedAction mandatedAction;
    @XmlElement(name = "AgencyId")
    protected SchemeValuePair agencyId;
    @XmlElement(name = "OrganizationNameInformation", required = true)
    protected List<OrganizationNameInformation> organizationNameInformations;
    @XmlElement(name = "AgencyAddressInformation")
    protected List<AgencyAddressInformation> agencyAddressInformations;
    @XmlElement(name = "AuthenticationPrompt")
    protected List<AuthenticationPrompt> authenticationPrompts;
    @XmlElement(name = "ApplicationProfileSupportedType")
    protected List<SchemeValuePair> applicationProfileSupportedTypes;
    @XmlElement(name = "ConsortiumAgreement")
    protected List<SchemeValuePair> consortiumAgreements;
    @XmlElement(name = "AgencyUserPrivilegeType")
    protected List<SchemeValuePair> agencyUserPrivilegeTypes;
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
     * Gets the value of the mandatedAction property.
     * 
     * @return
     *     possible object is
     *     {@link MandatedAction }
     *     
     */
    public MandatedAction getMandatedAction() {
        return mandatedAction;
    }

    /**
     * Sets the value of the mandatedAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandatedAction }
     *     
     */
    public void setMandatedAction(MandatedAction value) {
        this.mandatedAction = value;
    }

    /**
     * Gets the value of the agencyId property.
     * 
     * @return
     *     possible object is
     *     {@link SchemeValuePair }
     *     
     */
    public SchemeValuePair getAgencyId() {
        return agencyId;
    }

    /**
     * Sets the value of the agencyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link SchemeValuePair }
     *     
     */
    public void setAgencyId(SchemeValuePair value) {
        this.agencyId = value;
    }

    /**
     * Gets the value of the organizationNameInformations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organizationNameInformations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganizationNameInformations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrganizationNameInformation }
     * 
     * 
     */
    public List<OrganizationNameInformation> getOrganizationNameInformations() {
        if (organizationNameInformations == null) {
            organizationNameInformations = new ArrayList<OrganizationNameInformation>();
        }
        return this.organizationNameInformations;
    }

    /**
     * Gets the value of the agencyAddressInformations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the agencyAddressInformations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAgencyAddressInformations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AgencyAddressInformation }
     * 
     * 
     */
    public List<AgencyAddressInformation> getAgencyAddressInformations() {
        if (agencyAddressInformations == null) {
            agencyAddressInformations = new ArrayList<AgencyAddressInformation>();
        }
        return this.agencyAddressInformations;
    }

    /**
     * Gets the value of the authenticationPrompts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authenticationPrompts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthenticationPrompts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuthenticationPrompt }
     * 
     * 
     */
    public List<AuthenticationPrompt> getAuthenticationPrompts() {
        if (authenticationPrompts == null) {
            authenticationPrompts = new ArrayList<AuthenticationPrompt>();
        }
        return this.authenticationPrompts;
    }

    /**
     * Gets the value of the applicationProfileSupportedTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicationProfileSupportedTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicationProfileSupportedTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SchemeValuePair }
     * 
     * 
     */
    public List<SchemeValuePair> getApplicationProfileSupportedTypes() {
        if (applicationProfileSupportedTypes == null) {
            applicationProfileSupportedTypes = new ArrayList<SchemeValuePair>();
        }
        return this.applicationProfileSupportedTypes;
    }

    /**
     * Gets the value of the consortiumAgreements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consortiumAgreements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsortiumAgreements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SchemeValuePair }
     * 
     * 
     */
    public List<SchemeValuePair> getConsortiumAgreements() {
        if (consortiumAgreements == null) {
            consortiumAgreements = new ArrayList<SchemeValuePair>();
        }
        return this.consortiumAgreements;
    }

    /**
     * Gets the value of the agencyUserPrivilegeTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the agencyUserPrivilegeTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAgencyUserPrivilegeTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SchemeValuePair }
     * 
     * 
     */
    public List<SchemeValuePair> getAgencyUserPrivilegeTypes() {
        if (agencyUserPrivilegeTypes == null) {
            agencyUserPrivilegeTypes = new ArrayList<SchemeValuePair>();
        }
        return this.agencyUserPrivilegeTypes;
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
            MandatedAction theMandatedAction;
            theMandatedAction = this.getMandatedAction();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mandatedAction", theMandatedAction), currentHashCode, theMandatedAction, (this.mandatedAction!= null));
        }
        {
            SchemeValuePair theAgencyId;
            theAgencyId = this.getAgencyId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "agencyId", theAgencyId), currentHashCode, theAgencyId, (this.agencyId!= null));
        }
        {
            List<OrganizationNameInformation> theOrganizationNameInformations;
            theOrganizationNameInformations = (((this.organizationNameInformations!= null)&&(!this.organizationNameInformations.isEmpty()))?this.getOrganizationNameInformations():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "organizationNameInformations", theOrganizationNameInformations), currentHashCode, theOrganizationNameInformations, ((this.organizationNameInformations!= null)&&(!this.organizationNameInformations.isEmpty())));
        }
        {
            List<AgencyAddressInformation> theAgencyAddressInformations;
            theAgencyAddressInformations = (((this.agencyAddressInformations!= null)&&(!this.agencyAddressInformations.isEmpty()))?this.getAgencyAddressInformations():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "agencyAddressInformations", theAgencyAddressInformations), currentHashCode, theAgencyAddressInformations, ((this.agencyAddressInformations!= null)&&(!this.agencyAddressInformations.isEmpty())));
        }
        {
            List<AuthenticationPrompt> theAuthenticationPrompts;
            theAuthenticationPrompts = (((this.authenticationPrompts!= null)&&(!this.authenticationPrompts.isEmpty()))?this.getAuthenticationPrompts():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "authenticationPrompts", theAuthenticationPrompts), currentHashCode, theAuthenticationPrompts, ((this.authenticationPrompts!= null)&&(!this.authenticationPrompts.isEmpty())));
        }
        {
            List<SchemeValuePair> theApplicationProfileSupportedTypes;
            theApplicationProfileSupportedTypes = (((this.applicationProfileSupportedTypes!= null)&&(!this.applicationProfileSupportedTypes.isEmpty()))?this.getApplicationProfileSupportedTypes():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "applicationProfileSupportedTypes", theApplicationProfileSupportedTypes), currentHashCode, theApplicationProfileSupportedTypes, ((this.applicationProfileSupportedTypes!= null)&&(!this.applicationProfileSupportedTypes.isEmpty())));
        }
        {
            List<SchemeValuePair> theConsortiumAgreements;
            theConsortiumAgreements = (((this.consortiumAgreements!= null)&&(!this.consortiumAgreements.isEmpty()))?this.getConsortiumAgreements():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "consortiumAgreements", theConsortiumAgreements), currentHashCode, theConsortiumAgreements, ((this.consortiumAgreements!= null)&&(!this.consortiumAgreements.isEmpty())));
        }
        {
            List<SchemeValuePair> theAgencyUserPrivilegeTypes;
            theAgencyUserPrivilegeTypes = (((this.agencyUserPrivilegeTypes!= null)&&(!this.agencyUserPrivilegeTypes.isEmpty()))?this.getAgencyUserPrivilegeTypes():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "agencyUserPrivilegeTypes", theAgencyUserPrivilegeTypes), currentHashCode, theAgencyUserPrivilegeTypes, ((this.agencyUserPrivilegeTypes!= null)&&(!this.agencyUserPrivilegeTypes.isEmpty())));
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
        final CreateAgency that = ((CreateAgency) object);
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
            MandatedAction lhsMandatedAction;
            lhsMandatedAction = this.getMandatedAction();
            MandatedAction rhsMandatedAction;
            rhsMandatedAction = that.getMandatedAction();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "mandatedAction", lhsMandatedAction), LocatorUtils.property(thatLocator, "mandatedAction", rhsMandatedAction), lhsMandatedAction, rhsMandatedAction, (this.mandatedAction!= null), (that.mandatedAction!= null))) {
                return false;
            }
        }
        {
            SchemeValuePair lhsAgencyId;
            lhsAgencyId = this.getAgencyId();
            SchemeValuePair rhsAgencyId;
            rhsAgencyId = that.getAgencyId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "agencyId", lhsAgencyId), LocatorUtils.property(thatLocator, "agencyId", rhsAgencyId), lhsAgencyId, rhsAgencyId, (this.agencyId!= null), (that.agencyId!= null))) {
                return false;
            }
        }
        {
            List<OrganizationNameInformation> lhsOrganizationNameInformations;
            lhsOrganizationNameInformations = (((this.organizationNameInformations!= null)&&(!this.organizationNameInformations.isEmpty()))?this.getOrganizationNameInformations():null);
            List<OrganizationNameInformation> rhsOrganizationNameInformations;
            rhsOrganizationNameInformations = (((that.organizationNameInformations!= null)&&(!that.organizationNameInformations.isEmpty()))?that.getOrganizationNameInformations():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "organizationNameInformations", lhsOrganizationNameInformations), LocatorUtils.property(thatLocator, "organizationNameInformations", rhsOrganizationNameInformations), lhsOrganizationNameInformations, rhsOrganizationNameInformations, ((this.organizationNameInformations!= null)&&(!this.organizationNameInformations.isEmpty())), ((that.organizationNameInformations!= null)&&(!that.organizationNameInformations.isEmpty())))) {
                return false;
            }
        }
        {
            List<AgencyAddressInformation> lhsAgencyAddressInformations;
            lhsAgencyAddressInformations = (((this.agencyAddressInformations!= null)&&(!this.agencyAddressInformations.isEmpty()))?this.getAgencyAddressInformations():null);
            List<AgencyAddressInformation> rhsAgencyAddressInformations;
            rhsAgencyAddressInformations = (((that.agencyAddressInformations!= null)&&(!that.agencyAddressInformations.isEmpty()))?that.getAgencyAddressInformations():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "agencyAddressInformations", lhsAgencyAddressInformations), LocatorUtils.property(thatLocator, "agencyAddressInformations", rhsAgencyAddressInformations), lhsAgencyAddressInformations, rhsAgencyAddressInformations, ((this.agencyAddressInformations!= null)&&(!this.agencyAddressInformations.isEmpty())), ((that.agencyAddressInformations!= null)&&(!that.agencyAddressInformations.isEmpty())))) {
                return false;
            }
        }
        {
            List<AuthenticationPrompt> lhsAuthenticationPrompts;
            lhsAuthenticationPrompts = (((this.authenticationPrompts!= null)&&(!this.authenticationPrompts.isEmpty()))?this.getAuthenticationPrompts():null);
            List<AuthenticationPrompt> rhsAuthenticationPrompts;
            rhsAuthenticationPrompts = (((that.authenticationPrompts!= null)&&(!that.authenticationPrompts.isEmpty()))?that.getAuthenticationPrompts():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "authenticationPrompts", lhsAuthenticationPrompts), LocatorUtils.property(thatLocator, "authenticationPrompts", rhsAuthenticationPrompts), lhsAuthenticationPrompts, rhsAuthenticationPrompts, ((this.authenticationPrompts!= null)&&(!this.authenticationPrompts.isEmpty())), ((that.authenticationPrompts!= null)&&(!that.authenticationPrompts.isEmpty())))) {
                return false;
            }
        }
        {
            List<SchemeValuePair> lhsApplicationProfileSupportedTypes;
            lhsApplicationProfileSupportedTypes = (((this.applicationProfileSupportedTypes!= null)&&(!this.applicationProfileSupportedTypes.isEmpty()))?this.getApplicationProfileSupportedTypes():null);
            List<SchemeValuePair> rhsApplicationProfileSupportedTypes;
            rhsApplicationProfileSupportedTypes = (((that.applicationProfileSupportedTypes!= null)&&(!that.applicationProfileSupportedTypes.isEmpty()))?that.getApplicationProfileSupportedTypes():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "applicationProfileSupportedTypes", lhsApplicationProfileSupportedTypes), LocatorUtils.property(thatLocator, "applicationProfileSupportedTypes", rhsApplicationProfileSupportedTypes), lhsApplicationProfileSupportedTypes, rhsApplicationProfileSupportedTypes, ((this.applicationProfileSupportedTypes!= null)&&(!this.applicationProfileSupportedTypes.isEmpty())), ((that.applicationProfileSupportedTypes!= null)&&(!that.applicationProfileSupportedTypes.isEmpty())))) {
                return false;
            }
        }
        {
            List<SchemeValuePair> lhsConsortiumAgreements;
            lhsConsortiumAgreements = (((this.consortiumAgreements!= null)&&(!this.consortiumAgreements.isEmpty()))?this.getConsortiumAgreements():null);
            List<SchemeValuePair> rhsConsortiumAgreements;
            rhsConsortiumAgreements = (((that.consortiumAgreements!= null)&&(!that.consortiumAgreements.isEmpty()))?that.getConsortiumAgreements():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "consortiumAgreements", lhsConsortiumAgreements), LocatorUtils.property(thatLocator, "consortiumAgreements", rhsConsortiumAgreements), lhsConsortiumAgreements, rhsConsortiumAgreements, ((this.consortiumAgreements!= null)&&(!this.consortiumAgreements.isEmpty())), ((that.consortiumAgreements!= null)&&(!that.consortiumAgreements.isEmpty())))) {
                return false;
            }
        }
        {
            List<SchemeValuePair> lhsAgencyUserPrivilegeTypes;
            lhsAgencyUserPrivilegeTypes = (((this.agencyUserPrivilegeTypes!= null)&&(!this.agencyUserPrivilegeTypes.isEmpty()))?this.getAgencyUserPrivilegeTypes():null);
            List<SchemeValuePair> rhsAgencyUserPrivilegeTypes;
            rhsAgencyUserPrivilegeTypes = (((that.agencyUserPrivilegeTypes!= null)&&(!that.agencyUserPrivilegeTypes.isEmpty()))?that.getAgencyUserPrivilegeTypes():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "agencyUserPrivilegeTypes", lhsAgencyUserPrivilegeTypes), LocatorUtils.property(thatLocator, "agencyUserPrivilegeTypes", rhsAgencyUserPrivilegeTypes), lhsAgencyUserPrivilegeTypes, rhsAgencyUserPrivilegeTypes, ((this.agencyUserPrivilegeTypes!= null)&&(!this.agencyUserPrivilegeTypes.isEmpty())), ((that.agencyUserPrivilegeTypes!= null)&&(!that.agencyUserPrivilegeTypes.isEmpty())))) {
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
            MandatedAction theMandatedAction;
            theMandatedAction = this.getMandatedAction();
            strategy.appendField(locator, this, "mandatedAction", buffer, theMandatedAction, (this.mandatedAction!= null));
        }
        {
            SchemeValuePair theAgencyId;
            theAgencyId = this.getAgencyId();
            strategy.appendField(locator, this, "agencyId", buffer, theAgencyId, (this.agencyId!= null));
        }
        {
            List<OrganizationNameInformation> theOrganizationNameInformations;
            theOrganizationNameInformations = (((this.organizationNameInformations!= null)&&(!this.organizationNameInformations.isEmpty()))?this.getOrganizationNameInformations():null);
            strategy.appendField(locator, this, "organizationNameInformations", buffer, theOrganizationNameInformations, ((this.organizationNameInformations!= null)&&(!this.organizationNameInformations.isEmpty())));
        }
        {
            List<AgencyAddressInformation> theAgencyAddressInformations;
            theAgencyAddressInformations = (((this.agencyAddressInformations!= null)&&(!this.agencyAddressInformations.isEmpty()))?this.getAgencyAddressInformations():null);
            strategy.appendField(locator, this, "agencyAddressInformations", buffer, theAgencyAddressInformations, ((this.agencyAddressInformations!= null)&&(!this.agencyAddressInformations.isEmpty())));
        }
        {
            List<AuthenticationPrompt> theAuthenticationPrompts;
            theAuthenticationPrompts = (((this.authenticationPrompts!= null)&&(!this.authenticationPrompts.isEmpty()))?this.getAuthenticationPrompts():null);
            strategy.appendField(locator, this, "authenticationPrompts", buffer, theAuthenticationPrompts, ((this.authenticationPrompts!= null)&&(!this.authenticationPrompts.isEmpty())));
        }
        {
            List<SchemeValuePair> theApplicationProfileSupportedTypes;
            theApplicationProfileSupportedTypes = (((this.applicationProfileSupportedTypes!= null)&&(!this.applicationProfileSupportedTypes.isEmpty()))?this.getApplicationProfileSupportedTypes():null);
            strategy.appendField(locator, this, "applicationProfileSupportedTypes", buffer, theApplicationProfileSupportedTypes, ((this.applicationProfileSupportedTypes!= null)&&(!this.applicationProfileSupportedTypes.isEmpty())));
        }
        {
            List<SchemeValuePair> theConsortiumAgreements;
            theConsortiumAgreements = (((this.consortiumAgreements!= null)&&(!this.consortiumAgreements.isEmpty()))?this.getConsortiumAgreements():null);
            strategy.appendField(locator, this, "consortiumAgreements", buffer, theConsortiumAgreements, ((this.consortiumAgreements!= null)&&(!this.consortiumAgreements.isEmpty())));
        }
        {
            List<SchemeValuePair> theAgencyUserPrivilegeTypes;
            theAgencyUserPrivilegeTypes = (((this.agencyUserPrivilegeTypes!= null)&&(!this.agencyUserPrivilegeTypes.isEmpty()))?this.getAgencyUserPrivilegeTypes():null);
            strategy.appendField(locator, this, "agencyUserPrivilegeTypes", buffer, theAgencyUserPrivilegeTypes, ((this.agencyUserPrivilegeTypes!= null)&&(!this.agencyUserPrivilegeTypes.isEmpty())));
        }
        {
            Ext theExt;
            theExt = this.getExt();
            strategy.appendField(locator, this, "ext", buffer, theExt, (this.ext!= null));
        }
        return buffer;
    }

}
