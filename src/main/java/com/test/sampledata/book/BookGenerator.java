package com.test.sampledata.book;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BookGenerator {

    public static Book generateBook() {
        return generateBooks(1).get(0);
    }

    public static Map<String, Book> generateBooks(int numberOfBooksToGenerate) {

        if (numberOfBooksToGenerate < 1) {
            numberOfBooksToGenerate = 1;
        }
        
        Map<String, Book> books = new HashMap<>();

        for (int i = 0; i < numberOfBooksToGenerate; i++) {

            String title = generateSentence(true);
            String description = generateSentence(true);

            Book book = new Book();
            book.setIsbn(generateISBN());
            book.setAuthor(generateName());
            book.setPublicationYear(ThreadLocalRandom.current().nextInt(2000, 2022));

            // Make sure the description is longer than the title
            if (description.length() > title.length()) {
                book.setTitle(title);
                book.setDescription(description);
            } else {
                book.setTitle(description);
                book.setDescription(title);
            }
            
            books.put(book.getIsbn(), book);
        }

        return books;
    }

    private static String generateISBN() {

        int leftLimit = 48; // letter '0'
        int rightLimit = 57; // letter '9'
        int targetStringLength = 13;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String isbn = buffer.insert(3, "-").insert(6, "-").insert(12, "-").insert(15, "-").toString();

        return isbn;
    }

    private static String generateName() {
        return randomItem(firstNames) + " " + randomItem(lastNames);
    }

    private static String generateSentence(boolean capitalize) {
        StringBuffer sb = new StringBuffer();
        sb.append(nounPhrase());
        sb.append(verbPhrase());
        if (Math.random() > 0.75) {
            sb.append(" " + randomItem(conjunction));
            sb.append(" " + generateSentence(false));
        }
        if (capitalize) {
            return sb.toString().trim().substring(0, 1).toUpperCase() + sb.toString().substring(2);
        } else {
            return sb.toString().trim();
        }
    }

    private static String nounPhrase() {

        StringBuffer sb = new StringBuffer();

        if (Math.random() > 0.75) {
            sb.append(" " + randomItem(proper_noun));
        } else {
            sb.append(" " + randomItem(determiner));
            if (Math.random() > 0.5) {
                sb.append(" " + randomItem(adjective));
            }
            sb.append(" " + randomItem(common_noun));
            if (Math.random() > 0.5) {
                sb.append(" who");
                sb.append(verbPhrase());
            }
        }

        return sb.toString();
    }

    private static String verbPhrase() {

        StringBuffer sb = new StringBuffer();

        if (Math.random() > 0.75) {
            sb.append(" " + randomItem(intransitive_verb));
        } else if (Math.random() > 0.50) {
            sb.append(" " + randomItem(transitive_verb));
            sb.append(nounPhrase());
        } else if (Math.random() > 0.25) {
            sb.append(" is " + randomItem(adjective));
        } else {
            sb.append(" believes that");
            sb.append(nounPhrase());
            sb.append(verbPhrase());
        }
        return sb.toString();
    }

    private static String randomItem(String[] listOfStrings) {
        return listOfStrings[(int) (Math.random() * listOfStrings.length)];
    }

    private static final String[] firstNames = {"Charlotte", "Olivia", "Mia", "Amelia", "Ava", "Chloe", "Emily", "Zoe", "Grace", "Sophia", "Sophie", "Isabella", "Isla", "Ruby", "Ivy", "Ella", "Evie", "Sienna", "Matilda", "Scarlett", "Harper", "Evelyn", "Lily", "Emma", "Georgia", "Eva", "Lucy", "Hannah", "Zara", "Isabelle", "Willow", "Abigail", "Audrey", "Aria", "Sofia", "Annabelle", "Layla", "Violet", "Mila", "Imogen", "Sarah", "Stella", "Piper", "Savannah", "Elizabeth", "Alice", "Ellie", "Jessica", "Maddison", "Ariana", "Victoria", "Mackenzie", "Jasmine", "Maya", "Claire", "Eleanor", "Madison", "Alexis", "Phoebe", "Indiana", "Chelsea", "Alyssa", "Summer", "Eden", "Anna", "Lara", "Hazel", "Addison", "Madeleine", "Penelope", "Elsie", "Isabel", "Poppy", "Frankie", "Molly", "Aisha", "Bella", "Emilia", "Aurora", "Lilly", "Rose", "Ayla", "Eloise", "Harriet", "Leah", "Lola", "Alexandra", "Daisy", "Olive", "Eliza", "Aaliyah", "Holly", "Lillian", "Maryam", "Eve", "Charlie", "Gabriella", "Paige", "Billie", "Madeline", "Oliver", "George", "Harry", "Jack", "Jacob", "Noah", "Charlie", "Muhammad", "Thomas", "Oscar", "William", "James", "Henry", "Leo", "Alfie", "Joshua", "Freddie", "Archie", "Ethan", "Isaac", "Alexander", "Joseph", "Edward", "Samuel", "Max", "Daniel", "Arthur", "Lucas", "Mohammed", "Logan", "Theo", "Harrison", "Benjamin", "Mason", "Sebastian", "Finley", "Adam", "Dylan", "Zachary", "Riley", "Teddy", "Theodore", "David", "Toby", "Jake", "Louie", "Elijah", "Reuben", "Arlo", "Hugo", "Luca", "Jaxon", "Matthew", "Harvey", "Reggie", "Michael", "Harley", "Jude", "Albert", "Tommy", "Luke", "Stanley", "Jenson", "Frankie", "Jayden", "Gabriel", "Elliot", "Mohammad", "Ronnie", "Charles", "Louis", "Elliott", "Frederick", "Nathan", "Lewis", "Blake", "Rory", "Ollie", "Ryan", "Tyler", "Jackson", "Dexter", "Alex", "Austin", "Kai", "Albie", "Caleb", "Carter", "Bobby", "Ezra", "Ellis", "Leon", "Roman", "Ibrahim", "Aaron", "Liam", "Jesse", "Jasper", "Felix", "Jamie"};
    private static final String[] lastNames = {"Smith", "Jones", "Williams", "Taylor", "Brown", "Davies", "Evans", "Wilson", "Thomas", "Johnson", "Roberts", "Robinson", "Thompson", "Wright", "Walker", "White", "Edwards", "Hughes", "Green", "Hall", "Lewis", "Harris", "Clarke", "Patel", "Jackson", "Wood", "Turner", "Martin", "Cooper", "Hill", "Ward", "Morris", "Moore", "Clark", "Lee", "King", "Baker", "Harrison", "Morgan", "Allen", "James", "Scott", "Phillips", "Watson", "Davis", "Parker", "Price", "Bennett", "Young", "Griffiths", "Mitchell", "Kelly", "Cook", "Carter", "Richardson", "Bailey", "Collins", "Bell", "Shaw", "Murphy", "Miller", "Cox", "Richards", "Khan", "Marshall", "Anderson", "Simpson", "Ellis", "Adams", "Singh", "Begum", "Wilkinson", "Foster", "Chapman", "Powell", "Webb", "Rogers", "Gray", "Mason", "Ali", "Hunt", "Hussain", "Campbell", "Matthews", "Owen", "Palmer", "Holmes", "Mills", "Barnes", "Knight", "Lloyd", "Butler", "Russell", "Barker", "Fisher", "Stevens", "Jenkins", "Murray", "Dixon", "Harvey"};

    private static final String[] conjunction = {"and", "or", "but", "because"};
    private static final String[] proper_noun = {"Fred", "Jane", "Martin", "Sarah"};
    private static final String[] common_noun = {"man", "woman", "fish", "elephant", "dog"};
    private static final String[] determiner = {"a", "the", "every", "some"};
    private static final String[] adjective = {"big", "awesome", "pretty", "lovely"};
    private static final String[] intransitive_verb = {"runs", "jumps", "talks", "sleeps"};
    private static final String[] transitive_verb = {"loves", "hates", "sees", "knows", "looks for", "finds"};

}
