package com.example.glide.core;

import org.junit.jupiter.api.Test;

public class FunctionComposerTests {

    @Test
    void simple() {

        Step<String, PersonOutput> createPerson = name -> new PersonOutput(name, 30);

        Transform<PersonOutput, AnimalInput> personOutputAnimalInputTransform =
                personOutput -> new AnimalInput(personOutput.getName(), "bird");

        Step<AnimalInput, AnimalOutput> animalStep =
                animalInput  -> new AnimalOutput("Processed Animal: " + animalInput.getName() + ", " + animalInput.getSpecies());


        Transform<AnimalOutput, CustomerInput> animalOutputToCustomerInput =
                animalOutput -> new CustomerInput(animalOutput.getName(), "lastname", 1);

        Step<CustomerInput, CustomerOutput> customerStep =
                customerInput -> new CustomerOutput("Processed: " + customerInput.getFirstName() + " " + customerInput.getLastName() + ", Age: " + customerInput.getAge());


        //FunctionComposer<String, String> composed =
        var composer = FunctionComposer.of(createPerson)
                .transform(personOutputAnimalInputTransform)
                .andThen(animalStep)
                .transform(animalOutputToCustomerInput)
                .andThen(customerStep);


        var result = composer.apply("John Doe");
        System.out.println(result); // Output will depend on the implementation of the functions

    }


    public class PersonOutput {
        private String name;
        private int age;

        public PersonOutput(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getters
        public String getName() { return name; }
        public int getAge() { return age; }
    }

    public class CustomerOutput {
        private String name;

        public CustomerOutput(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "CustomerOutput{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public class AnimalOutput {
        private String name;

        public AnimalOutput(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    public class AnimalInput {
        private String name;

        private String species;

        public AnimalInput(String name, String species) {
            this.name = name;
            this.species = species;
        }

        public String getName() {
            return name;
        }

        public String getSpecies() {
            return species;
        }
    }
    public class CustomerInput {
        private String firstName;
        private String lastName;
        private int age;

        public CustomerInput(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        // Getters
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public int getAge() { return age; }
    }

}
