//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:54:26 AM CET 
//


package no.bibsys.alma.rest.ncip;

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
 *         &lt;element ref="{http://www.niso.org/2008/ncip}ItemId"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}DeleteItemFields" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}AddItemFields" minOccurs="0"/&gt;
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
    "itemId",
    "deleteItemFields",
    "addItemFields",
    "ext"
})
@XmlRootElement(name = "UpdateItem")
public class UpdateItem implements Equals2, HashCode2, ToString2
{

    @XmlElement(name = "InitiationHeader")
    protected InitiationHeader initiationHeader;
    @XmlElement(name = "MandatedAction")
    protected MandatedAction mandatedAction;
    @XmlElement(name = "ItemId", required = true)
    protected ItemId itemId;
    @XmlElement(name = "DeleteItemFields")
    protected DeleteItemFields deleteItemFields;
    @XmlElement(name = "AddItemFields")
    protected AddItemFields addItemFields;
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
     * Gets the value of the deleteItemFields property.
     * 
     * @return
     *     possible object is
     *     {@link DeleteItemFields }
     *     
     */
    public DeleteItemFields getDeleteItemFields() {
        return deleteItemFields;
    }

    /**
     * Sets the value of the deleteItemFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteItemFields }
     *     
     */
    public void setDeleteItemFields(DeleteItemFields value) {
        this.deleteItemFields = value;
    }

    /**
     * Gets the value of the addItemFields property.
     * 
     * @return
     *     possible object is
     *     {@link AddItemFields }
     *     
     */
    public AddItemFields getAddItemFields() {
        return addItemFields;
    }

    /**
     * Sets the value of the addItemFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddItemFields }
     *     
     */
    public void setAddItemFields(AddItemFields value) {
        this.addItemFields = value;
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
            ItemId theItemId;
            theItemId = this.getItemId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "itemId", theItemId), currentHashCode, theItemId, (this.itemId!= null));
        }
        {
            DeleteItemFields theDeleteItemFields;
            theDeleteItemFields = this.getDeleteItemFields();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "deleteItemFields", theDeleteItemFields), currentHashCode, theDeleteItemFields, (this.deleteItemFields!= null));
        }
        {
            AddItemFields theAddItemFields;
            theAddItemFields = this.getAddItemFields();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "addItemFields", theAddItemFields), currentHashCode, theAddItemFields, (this.addItemFields!= null));
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
        final UpdateItem that = ((UpdateItem) object);
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
            ItemId lhsItemId;
            lhsItemId = this.getItemId();
            ItemId rhsItemId;
            rhsItemId = that.getItemId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "itemId", lhsItemId), LocatorUtils.property(thatLocator, "itemId", rhsItemId), lhsItemId, rhsItemId, (this.itemId!= null), (that.itemId!= null))) {
                return false;
            }
        }
        {
            DeleteItemFields lhsDeleteItemFields;
            lhsDeleteItemFields = this.getDeleteItemFields();
            DeleteItemFields rhsDeleteItemFields;
            rhsDeleteItemFields = that.getDeleteItemFields();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "deleteItemFields", lhsDeleteItemFields), LocatorUtils.property(thatLocator, "deleteItemFields", rhsDeleteItemFields), lhsDeleteItemFields, rhsDeleteItemFields, (this.deleteItemFields!= null), (that.deleteItemFields!= null))) {
                return false;
            }
        }
        {
            AddItemFields lhsAddItemFields;
            lhsAddItemFields = this.getAddItemFields();
            AddItemFields rhsAddItemFields;
            rhsAddItemFields = that.getAddItemFields();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "addItemFields", lhsAddItemFields), LocatorUtils.property(thatLocator, "addItemFields", rhsAddItemFields), lhsAddItemFields, rhsAddItemFields, (this.addItemFields!= null), (that.addItemFields!= null))) {
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
            ItemId theItemId;
            theItemId = this.getItemId();
            strategy.appendField(locator, this, "itemId", buffer, theItemId, (this.itemId!= null));
        }
        {
            DeleteItemFields theDeleteItemFields;
            theDeleteItemFields = this.getDeleteItemFields();
            strategy.appendField(locator, this, "deleteItemFields", buffer, theDeleteItemFields, (this.deleteItemFields!= null));
        }
        {
            AddItemFields theAddItemFields;
            theAddItemFields = this.getAddItemFields();
            strategy.appendField(locator, this, "addItemFields", buffer, theAddItemFields, (this.addItemFields!= null));
        }
        {
            Ext theExt;
            theExt = this.getExt();
            strategy.appendField(locator, this, "ext", buffer, theExt, (this.ext!= null));
        }
        return buffer;
    }

}
