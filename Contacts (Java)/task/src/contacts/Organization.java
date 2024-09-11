package contacts;

import java.util.Arrays;
import java.util.List;

public class Organization extends Record {
    private String organizationName;
    private String address;

    public Organization(String organizationName, String address, String number) {
        super(number);
        this.organizationName = organizationName;
        this.address = address;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        updateTimeLastEdit();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        updateTimeLastEdit();
    }

    @Override
    public List<String> getEditableFields() {
        return Arrays.asList("name", "address", "number");
    }

    @Override
    public void setField(String field, String value) {
        switch (field) {
            case "name":
                setOrganizationName(value);
                break;
            case "address":
                setAddress(value);
                break;
            case "number":
                setNumber(value);
                break;
        }
    }

    @Override
    public String getField(String field) {
        switch (field) {
            case "name":
                return getOrganizationName();
            case "address":
                return getAddress();
            case "number":
                return getNumber();
            default:
                return "";
        }
    }

    @Override
    public String getInfo() {
        return "Organization name: " + organizationName + "\n" +
                "Address: " + address + "\n" +
                "Number: " + getNumber() + "\n" +
                "Time created: " + getTimeCreated() + "\n" +
                "Time last edit: " + getTimeLastEdit() + "\n";
    }
}