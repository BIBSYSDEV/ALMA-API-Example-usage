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
 *         &lt;element ref="{http://www.niso.org/2008/ncip}PromptOutput"/&gt;
 *         &lt;element ref="{http://www.niso.org/2008/ncip}PromptInput"/&gt;
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
    "promptOutput",
    "promptInput",
    "ext"
})
@XmlRootElement(name = "AuthenticationPrompt")
public class AuthenticationPrompt implements Equals2, HashCode2, ToString2
{

    @XmlElement(name = "PromptOutput", required = true)
    protected PromptOutput promptOutput;
    @XmlElement(name = "PromptInput", required = true)
    protected PromptInput promptInput;
    @XmlElement(name = "Ext")
    protected Ext ext;

    /**
     * Gets the value of the promptOutput property.
     * 
     * @return
     *     possible object is
     *     {@link PromptOutput }
     *     
     */
    public PromptOutput getPromptOutput() {
        return promptOutput;
    }

    /**
     * Sets the value of the promptOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link PromptOutput }
     *     
     */
    public void setPromptOutput(PromptOutput value) {
        this.promptOutput = value;
    }

    /**
     * Gets the value of the promptInput property.
     * 
     * @return
     *     possible object is
     *     {@link PromptInput }
     *     
     */
    public PromptInput getPromptInput() {
        return promptInput;
    }

    /**
     * Sets the value of the promptInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link PromptInput }
     *     
     */
    public void setPromptInput(PromptInput value) {
        this.promptInput = value;
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
            PromptOutput thePromptOutput;
            thePromptOutput = this.getPromptOutput();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "promptOutput", thePromptOutput), currentHashCode, thePromptOutput, (this.promptOutput!= null));
        }
        {
            PromptInput thePromptInput;
            thePromptInput = this.getPromptInput();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "promptInput", thePromptInput), currentHashCode, thePromptInput, (this.promptInput!= null));
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
        final AuthenticationPrompt that = ((AuthenticationPrompt) object);
        {
            PromptOutput lhsPromptOutput;
            lhsPromptOutput = this.getPromptOutput();
            PromptOutput rhsPromptOutput;
            rhsPromptOutput = that.getPromptOutput();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "promptOutput", lhsPromptOutput), LocatorUtils.property(thatLocator, "promptOutput", rhsPromptOutput), lhsPromptOutput, rhsPromptOutput, (this.promptOutput!= null), (that.promptOutput!= null))) {
                return false;
            }
        }
        {
            PromptInput lhsPromptInput;
            lhsPromptInput = this.getPromptInput();
            PromptInput rhsPromptInput;
            rhsPromptInput = that.getPromptInput();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "promptInput", lhsPromptInput), LocatorUtils.property(thatLocator, "promptInput", rhsPromptInput), lhsPromptInput, rhsPromptInput, (this.promptInput!= null), (that.promptInput!= null))) {
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
            PromptOutput thePromptOutput;
            thePromptOutput = this.getPromptOutput();
            strategy.appendField(locator, this, "promptOutput", buffer, thePromptOutput, (this.promptOutput!= null));
        }
        {
            PromptInput thePromptInput;
            thePromptInput = this.getPromptInput();
            strategy.appendField(locator, this, "promptInput", buffer, thePromptInput, (this.promptInput!= null));
        }
        {
            Ext theExt;
            theExt = this.getExt();
            strategy.appendField(locator, this, "ext", buffer, theExt, (this.ext!= null));
        }
        return buffer;
    }

}