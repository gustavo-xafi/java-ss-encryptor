package org.excelencryptor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person(
            "John Doe", "123456", "Active", "john.doe@example.com",
                "Member", "Transfer",
            "Male", "123 Main St", "12345", "555-1234", "01-01-1980",
                "City", "Country",
            "987654", "Single", "01-01-2000", "Jane Doe",
                "Father Doe",
                "Mother Doe",
            "Engineer", "Bachelor", "555-5678", "Yes"
        );
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("John Doe", person.getFullName());
        assertEquals("123456", person.getNumberId());
        assertEquals("Active", person.getSituation());
        assertEquals("john.doe@example.com", person.getEmail());
        assertEquals("Member", person.getMemberType());
        assertEquals("Transfer", person.getTransferType());
        assertEquals("Male", person.getGender());
        assertEquals("123 Main St", person.getAddress());
        assertEquals("12345", person.getNeighbourOrCep());
        assertEquals("555-1234", person.getCelNumber());
        assertEquals("01-01-1980", person.getBirthDate());
        assertEquals("City", person.getPlaceOfBirth());
        assertEquals("Country", person.getNationality());
        assertEquals("987654", person.getRg());
        assertEquals("Single", person.getCivilState());
        assertEquals("01-01-2000", person.getMarriageDate());
        assertEquals("Jane Doe", person.getSpouseName());
        assertEquals("Father Doe", person.getFatherName());
        assertEquals("Mother Doe", person.getMotherName());
        assertEquals("Engineer", person.getProfession());
        assertEquals("Bachelor", person.getEducationDegree());
        assertEquals("555-5678", person.getWorkPhoneNumber());
        assertEquals("Yes", person.getNeedAVisit());
    }

    @Test
    void testSetters() {
        person.setFullName("Jane Smith");
        assertEquals("Jane Smith", person.getFullName());

        person.setNumberId("654321");
        assertEquals("654321", person.getNumberId());

        person.setSituation("Inactive");
        assertEquals("Inactive", person.getSituation());

        person.setEmail("jane.smith@example.com");
        assertEquals("jane.smith@example.com", person.getEmail());

        person.setMemberType("Visitor");
        assertEquals("Visitor", person.getMemberType());

        person.setTransferType("New");
        assertEquals("New", person.getTransferType());

        person.setGender("Female");
        assertEquals("Female", person.getGender());

        person.setAddress("456 Elm St");
        assertEquals("456 Elm St", person.getAddress());

        person.setNeighbourOrCep("67890");
        assertEquals("67890", person.getNeighbourOrCep());

        person.setCelNumber("555-6789");
        assertEquals("555-6789", person.getCelNumber());

        person.setBirthDate("02-02-1990");
        assertEquals("02-02-1990", person.getBirthDate());

        person.setPlaceOfBirth("Town");
        assertEquals("Town", person.getPlaceOfBirth());

        person.setNationality("State");
        assertEquals("State", person.getNationality());

        person.setRg("123987");
        assertEquals("123987", person.getRg());

        person.setCivilState("Married");
        assertEquals("Married", person.getCivilState());

        person.setMarriageDate("02-02-2010");
        assertEquals("02-02-2010", person.getMarriageDate());

        person.setSpouseName("John Smith");
        assertEquals("John Smith", person.getSpouseName());

        person.setFatherName("Father Smith");
        assertEquals("Father Smith", person.getFatherName());

        person.setMotherName("Mother Smith");
        assertEquals("Mother Smith", person.getMotherName());

        person.setProfession("Doctor");
        assertEquals("Doctor", person.getProfession());

        person.setEducationDegree("Master");
        assertEquals("Master", person.getEducationDegree());

        person.setWorkPhoneNumber("555-9876");
        assertEquals("555-9876", person.getWorkPhoneNumber());

        person.setNeedAVisit("No");
        assertEquals("No", person.getNeedAVisit());
    }
}