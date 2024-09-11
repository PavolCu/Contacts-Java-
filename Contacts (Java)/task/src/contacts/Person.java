package contacts;

import java.util.Arrays;
import java.util.List;

public class Person extends Record {
    private String name;
    private String surname;
    private String birthDate;
    private String gender;

    public Person(String name, String surname, String birthDate, String gender, String number) {
        super(number);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updateTimeLastEdit();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        updateTimeLastEdit();
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        updateTimeLastEdit();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        updateTimeLastEdit();
    }

    @Override
    public List<String> getEditableFields() {
        return Arrays.asList("name", "surname", "birthDate", "gender", "number");
    }

    @Override
    public void setField(String field, String value) {
        switch (field) {
            case "name":
                setName(value);
                break;
            case "surname":
                setSurname(value);
                break;
            case "birthDate":
                setBirthDate(value);
                break;
            case "gender":
                setGender(value);
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
                return getName();
            case "surname":
                return getSurname();
            case "birthDate":
                return getBirthDate();
            case "gender":
                return getGender();
            case "number":
                return getNumber();
            default:
                return "";
        }
    }

    @Override
    public String getInfo() {
        return "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Birth date: " + (birthDate.isEmpty() ? "[no data]" : birthDate) + "\n" +
                "Gender: " + (gender.isEmpty() ? "[no data]" : gender) + "\n" +
                "Number: " + getNumber() + "\n" +
                "Time created: " + getTimeCreated() + "\n" +
                "Time last edit: " + getTimeLastEdit() + "\n";
    }
}