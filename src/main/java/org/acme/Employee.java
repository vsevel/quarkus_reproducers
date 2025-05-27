package org.acme;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employeeType", namespace = "org.acme", propOrder = { "name", "age" })
@XmlRootElement(name = "employee", namespace = "org.acme")
public class Employee {

    @XmlElement(required = true)
    protected String name;

    protected int age;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int value) {
        this.age = value;
    }
}