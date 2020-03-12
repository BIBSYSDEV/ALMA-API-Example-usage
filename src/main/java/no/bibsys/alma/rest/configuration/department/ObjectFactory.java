//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 09:28:02 AM CET 
//


package no.bibsys.alma.rest.configuration.department;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the no.bibsys.alma.rest.configuration.department package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Department_QNAME = new QName("", "department");
    private final static QName _Departments_QNAME = new QName("", "departments");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: no.bibsys.alma.rest.configuration.department
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link Address.AddressTypes }
     * 
     */
    public Address.AddressTypes createAddressAddressTypes() {
        return new Address.AddressTypes();
    }

    /**
     * Create an instance of {@link Phone }
     * 
     */
    public Phone createPhone() {
        return new Phone();
    }

    /**
     * Create an instance of {@link Phone.PhoneTypes }
     * 
     */
    public Phone.PhoneTypes createPhonePhoneTypes() {
        return new Phone.PhoneTypes();
    }

    /**
     * Create an instance of {@link Email }
     * 
     */
    public Email createEmail() {
        return new Email();
    }

    /**
     * Create an instance of {@link Email.EmailTypes }
     * 
     */
    public Email.EmailTypes createEmailEmailTypes() {
        return new Email.EmailTypes();
    }

    /**
     * Create an instance of {@link ServedLibraries }
     * 
     */
    public ServedLibraries createServedLibraries() {
        return new ServedLibraries();
    }

    /**
     * Create an instance of {@link Department }
     * 
     */
    public Department createDepartment() {
        return new Department();
    }

    /**
     * Create an instance of {@link Departments }
     * 
     */
    public Departments createDepartments() {
        return new Departments();
    }

    /**
     * Create an instance of {@link ContactInfo }
     * 
     */
    public ContactInfo createContactInfo() {
        return new ContactInfo();
    }

    /**
     * Create an instance of {@link Emails }
     * 
     */
    public Emails createEmails() {
        return new Emails();
    }

    /**
     * Create an instance of {@link Phones }
     * 
     */
    public Phones createPhones() {
        return new Phones();
    }

    /**
     * Create an instance of {@link Addresses }
     * 
     */
    public Addresses createAddresses() {
        return new Addresses();
    }

    /**
     * Create an instance of {@link Operators }
     * 
     */
    public Operators createOperators() {
        return new Operators();
    }

    /**
     * Create an instance of {@link Operator }
     * 
     */
    public Operator createOperator() {
        return new Operator();
    }

    /**
     * Create an instance of {@link Address.Country }
     * 
     */
    public Address.Country createAddressCountry() {
        return new Address.Country();
    }

    /**
     * Create an instance of {@link Address.AddressTypes.AddressType }
     * 
     */
    public Address.AddressTypes.AddressType createAddressAddressTypesAddressType() {
        return new Address.AddressTypes.AddressType();
    }

    /**
     * Create an instance of {@link Phone.PhoneTypes.PhoneType }
     * 
     */
    public Phone.PhoneTypes.PhoneType createPhonePhoneTypesPhoneType() {
        return new Phone.PhoneTypes.PhoneType();
    }

    /**
     * Create an instance of {@link Email.EmailTypes.EmailType }
     * 
     */
    public Email.EmailTypes.EmailType createEmailEmailTypesEmailType() {
        return new Email.EmailTypes.EmailType();
    }

    /**
     * Create an instance of {@link ServedLibraries.Library }
     * 
     */
    public ServedLibraries.Library createServedLibrariesLibrary() {
        return new ServedLibraries.Library();
    }

    /**
     * Create an instance of {@link Department.Type }
     * 
     */
    public Department.Type createDepartmentType() {
        return new Department.Type();
    }

    /**
     * Create an instance of {@link Department.Printer }
     * 
     */
    public Department.Printer createDepartmentPrinter() {
        return new Department.Printer();
    }

    /**
     * Create an instance of {@link Department.Owner }
     * 
     */
    public Department.Owner createDepartmentOwner() {
        return new Department.Owner();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Department }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "department")
    public JAXBElement<Department> createDepartment(Department value) {
        return new JAXBElement<Department>(_Department_QNAME, Department.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Departments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "departments")
    public JAXBElement<Departments> createDepartments(Departments value) {
        return new JAXBElement<Departments>(_Departments_QNAME, Departments.class, null, value);
    }

}