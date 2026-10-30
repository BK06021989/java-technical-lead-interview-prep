package com.java.oops;

import java.util.Date;

public final class EmployeeImmutable {
    private final String name;
    private final Date joiningDate;

    public EmployeeImmutable(String name, Date joiningDate) {
        this.name = name;
        this.joiningDate = new Date(joiningDate.getTime()); // copy on input
    }

    public String getName() {
        return name; // String is immutable
    }

    public Date getJoiningDate() {
        return new Date(joiningDate.getTime()); // copy on output
    }
}