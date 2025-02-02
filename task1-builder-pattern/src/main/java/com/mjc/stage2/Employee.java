package com.mjc.stage2;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Employee {
    private String name;
    private String lastName;
    private String position;
    private String phone;
    private String email;
    private String carNumber;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public static EmployeeBuilder getBuilder() {
        return new EmployeeBuilder();
    }

    public static class EmployeeBuilder {
        private final Employee employee;

        public EmployeeBuilder() {
            this.employee = new Employee();
        }

        public EmployeeBuilder setName(String value) {
            this.employee.setName(value);
            return this;
        }

        public EmployeeBuilder setLastName(String value) {
            this.employee.setLastName(value);
            return this;
        }

        public EmployeeBuilder setPosition(String value) {
            this.employee.setPosition(value);
            return this;
        }

        public EmployeeBuilder setPhone(String value) {
            this.employee.setPhone(value);
            return this;
        }

        public EmployeeBuilder setEmail(String value) {
            this.employee.setEmail(value);
            return this;
        }

        public EmployeeBuilder setCarNumber(String value) {
            this.employee.setCarNumber(value);
            return this;
        }

        public Employee build() {
            return this.employee;
        }
    }
}
