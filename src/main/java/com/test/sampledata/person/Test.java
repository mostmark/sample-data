package com.test.sampledata.person;

import java.util.Map;


public class Test {
    
    public static void main(String[] args) {
        int numberOfPersonsToGenerate = 100;
        Map<String, Person> persons = PersonGenerator.generatePersons(numberOfPersonsToGenerate);
        for (Map.Entry<String, Person> person : persons.entrySet()) {
            System.out.println(person.getValue());
        }
        
    }

}
