package com.test.sampledata.person;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PersonGenerator {

    public static Map<String, Person> generatePersons(int numberOfPersonsToGenerate) {

        if (numberOfPersonsToGenerate < 1) {
            numberOfPersonsToGenerate = 1;
        }

        Map<String, Person> persons = new HashMap<>();
        
        for (int i = 0; i < numberOfPersonsToGenerate; i++) {
            
            Person person = new Person();
            boolean female = new Random().nextBoolean();
            if(female)
                person.setFirstName(randomItem(femaleFirstNames));
            else
                person.setFirstName(randomItem(maleFirstNames));
            
            person.setLastName(randomItem(lastNames));
            String email = String.format("%s.%s@%s.%s", 
                    person.getFirstName(), 
                    person.getLastName(), 
                    randomItem(domains), 
                    randomItem(domainSuffix)).toLowerCase();
            person.setEmail(email);
            person.setPhoneNumber(getPhoneNumber());
            person.setStreetName(randomItem(streets));
            person.setStreetNumber(getStreetNumber());
            person.setZipCode(getZipCode());
            person.setCity(randomItem(cities));
            person.setState(randomItem(states));
            
            persons.put(email, person);
            
        }

        return persons;
    }

    private static String randomItem(String[] listOfStrings) {
        return listOfStrings[(int) (Math.random() * listOfStrings.length)];
    }
    
    private static String getPhoneNumber() {
        int countryCode = (int) (99 * Math.random());
        int phoneNumber = (int) (1000000000 * Math.random());
        return "+" + countryCode + phoneNumber;
    }
    
    private static int getStreetNumber() {
        return (int) (200 * Math.random());
    }
    
    private static int getZipCode() {
        return (int) (10000 * Math.random());
    }

    private static String[] femaleFirstNames = {"Charlotte", "Olivia", "Mia", "Amelia", "Ava", "Chloe", "Emily", "Zoe", "Grace", "Sophia", "Sophie", "Isabella", "Isla", "Ruby", "Ivy", "Ella", "Evie", "Sienna", "Matilda", "Scarlett", "Harper", "Evelyn", "Lily", "Emma", "Georgia", "Eva", "Lucy", "Hannah", "Zara", "Isabelle", "Willow", "Abigail", "Audrey", "Aria", "Sofia", "Annabelle", "Layla", "Violet", "Mila", "Imogen", "Sarah", "Stella", "Piper", "Savannah", "Elizabeth", "Alice", "Ellie", "Jessica", "Maddison", "Ariana", "Victoria", "Mackenzie", "Jasmine", "Maya", "Claire", "Eleanor", "Madison", "Alexis", "Phoebe", "Indiana", "Chelsea", "Alyssa", "Summer", "Eden", "Anna", "Lara", "Hazel", "Addison", "Madeleine", "Penelope", "Elsie", "Isabel", "Poppy", "Frankie", "Molly", "Aisha", "Bella", "Emilia", "Aurora", "Lilly", "Rose", "Ayla", "Eloise", "Harriet", "Leah", "Lola", "Alexandra", "Daisy", "Olive", "Eliza", "Aaliyah", "Holly", "Lillian", "Maryam", "Eve", "Charlie", "Gabriella", "Paige", "Billie", "Madeline"};
    private static String[] maleFirstNames = {"Oliver", "George", "Harry", "Jack", "Jacob", "Noah", "Charlie", "Muhammad", "Thomas", "Oscar", "William", "James", "Henry", "Leo", "Alfie", "Joshua", "Freddie", "Archie", "Ethan", "Isaac", "Alexander", "Joseph", "Edward", "Samuel", "Max", "Daniel", "Arthur", "Lucas", "Mohammed", "Logan", "Theo", "Harrison", "Benjamin", "Mason", "Sebastian", "Finley", "Adam", "Dylan", "Zachary", "Riley", "Teddy", "Theodore", "David", "Toby", "Jake", "Louie", "Elijah", "Reuben", "Arlo", "Hugo", "Luca", "Jaxon", "Matthew", "Harvey", "Reggie", "Michael", "Harley", "Jude", "Albert", "Tommy", "Luke", "Stanley", "Jenson", "Frankie", "Jayden", "Gabriel", "Elliot", "Mohammad", "Ronnie", "Charles", "Louis", "Elliott", "Frederick", "Nathan", "Lewis", "Blake", "Rory", "Ollie", "Ryan", "Tyler", "Jackson", "Dexter", "Alex", "Austin", "Kai", "Albie", "Caleb", "Carter", "Bobby", "Ezra", "Ellis", "Leon", "Roman", "Ibrahim", "Aaron", "Liam", "Jesse", "Jasper", "Felix", "Jamie"};
    private static String[] lastNames = {"Smith", "Jones", "Williams", "Taylor", "Brown", "Davies", "Evans", "Wilson", "Thomas", "Johnson", "Roberts", "Robinson", "Thompson", "Wright", "Walker", "White", "Edwards", "Hughes", "Green", "Hall", "Lewis", "Harris", "Clarke", "Patel", "Jackson", "Wood", "Turner", "Martin", "Cooper", "Hill", "Ward", "Morris", "Moore", "Clark", "Lee", "King", "Baker", "Harrison", "Morgan", "Allen", "James", "Scott", "Phillips", "Watson", "Davis", "Parker", "Price", "Bennett", "Young", "Griffiths", "Mitchell", "Kelly", "Cook", "Carter", "Richardson", "Bailey", "Collins", "Bell", "Shaw", "Murphy", "Miller", "Cox", "Richards", "Khan", "Marshall", "Anderson", "Simpson", "Ellis", "Adams", "Singh", "Begum", "Wilkinson", "Foster", "Chapman", "Powell", "Webb", "Rogers", "Gray", "Mason", "Ali", "Hunt", "Hussain", "Campbell", "Matthews", "Owen", "Palmer", "Holmes", "Mills", "Barnes", "Knight", "Lloyd", "Butler", "Russell", "Barker", "Fisher", "Stevens", "Jenkins", "Murray", "Dixon", "Harvey"};
    private static String[] domains = {"wish", "vanish", "knock", "assemble", "sentence", "brush", "project", "play", "perform", "embody", "pretend", "know", "check", "specify", "incur", "pin", "voice", "date", "proceed", "recommend", "seek", "succeed", "associate", "conceive", "differ", "flood", "allocate", "sell", "exist", "rid", "murder", "record", "destroy", "strip", "recognize", "overcome", "inherit", "eat", "resist", "reassure", "spell", "separate", "round", "outline", "market", "address", "remind", "mount", "demonstrate", "member", "judgment", "population", "contribution", "loss", "mixture", "tongue", "success", "warning", "disk", "tea", "complaint", "fishing", "region", "hotel", "replacement", "studio", "industry", "problem", "oven", "girlfriend", "marketing", "classroom", "initiative", "promotion", "safety", "location", "payment", "topic", "bedroom", "world", "possession", "suggestion", "mom", "blood", "requirement", "apartment", "city", "hearing", "basket", "nature", "hall", "charity", "database", "response", "lab", "union", "artisan", "media", "gate", "resolution"};
    private static String[] domainSuffix = {"com", "net", "org", "info"};
    private static String[] streets = {"South Langdale Rise", "North San Michelle Hill", "Street End", "Northwest Avanti Path", "North Revere House", "Goshawk Townline", "Kilburne Heights", "Diamantini Viaduct", "South Bev Cunha County", "Carrwood Gardens", "Stoneycrest Route", "West George Michas", "Kantor Nook North", "South Severance Loop", "Northwest Cherryblossom Gate", "South Corfdon Nook", "Arrowrock Lane South", "North Dardanelle West", "Refugio Valley", "East Thornet Wood Avenue", "Southeast Marc Bay", "Peniston Turnpike", "East Wyatville Circle", "Albert Bridge South", "West Traceys Landing", "Steenwick Quay", "North Valette Canyon", "Pickfair Alley", "Portwood Mews Northeast", "North Elan Village", "East Chase Side", "Meakin Road South", "South Netherby Causeway", "Southeast McCredie Byway", "Esslog Mount", "Shipwheel Vale", "South Mundy Terrace", "Northwest Belmont Mount", "West Holdernesse Gardens", "South Wincham Avenue", "West Chapeltown Grove Grade", "Orchard End", "Northeast Carr Manor Canyon", "Lumber Hill Southwest", "West Contact Spur", "Northwest Quaker Ridge", "East Mount Dell Parkway", "Irk Vale Trail South", "East Hedy Grove", "South Colson Park", "Cyprian Park", "North Number One First", "North Solstice Crescent", "South Redmans Terrace", "South Gennene Cove", "West Mungerie Bay", "Brockway Place", "East Caldbeck Viaduct", "Janine Grade", "Southeast Stedhall Hill", "Northwest Brickel Oval", "Sackman Passage", "Roynton Dell", "West Ditch Garth", "Koorabar Park Southeast", "Cottered Knoll", "Southwest Franklin Corner Route", "South Belshaw Heights", "East Wickersham Drive", "Cherlyn Route", "East Old Common Quay", "Waddell Passage South", "Steger Monee", "McCarty Ranch", "East Castlemain Mount", "Clam Shell", "North Fitzallen Path", "Ink Turnpike", "Empson Terrace", "Lemarc Route", "Via Primavera Grove", "Daryngton Trace", "Milboro Route North", "North Auto Plaza", "Southwest Bolsa Court", "North William Shakespeare Passage", "North Flatback Parkway", "Ulatis Gardens", "East Ridge View", "Annin Causeway", "South Three Forks", "South Tea Gardens", "East Premisy Hill", "North Pudding Cake", "La Cima Mews", "Southeast Chenango Causeway", "Hamor Road", "North Lang Grove", "Keynes Arcade", "Southdene Terrace"};
    private static String[] cities = {"Fort Scott", "Alpine", "Glens Falls", "Pass Christian", "Sidney", "Pittsburg", "Superior", "Vermillion", "Summersville", "Pottsville", "Spokane", "Morganton", "Gatlinburg", "Hammondsport", "Mount Holly", "Evansville", "Watertown", "Fort Myers", "Ilion", "Everett", "Bethlehem", "Sault Sainte Marie", "Oakland", "Wenatchee", "Liberal", "East Providence", "Park Forest", "Cheboygan", "Naperville", "Faribault", "Urbana", "Janesville", "Ticonderoga", "Utica", "Lawton", "Kalamazoo", "Needles", "Lockport", "Rockland", "Kawaihae", "Emmitsburg", "Norman", "Toledo", "Portland", "Menasha", "Elmira", "Michigan City", "Dunkirk", "Lawrence", "Sapulpa", "Uniontown", "Birmingham", "Calexico", "Chesapeake", "New Madrid", "Winooski", "Iowa City", "Santa Clarita", "Westminster", "Pittsfield", "Stamford", "Layton", "Honolulu", "Weymouth", "Grants", "Johnstown", "Kingsville", "Presque Isle", "Minot", "Gloucester", "Monterey", "Escondido", "Tullahoma", "Iron Mountain", "Columbus", "Pine Bluff", "Fort Pierce", "Irving", "Enfield", "Nags Head", "Coupeville", "Orono", "Bangor", "Anaheim", "Orange", "Ketchikan", "El Dorado", "Elk City", "Uvalde", "Spearfish", "Grayling", "Osceola", "Medicine Lodge", "Goshen", "Santa Cruz", "Kapaa", "Arcadia", "Narragansett", "Payson", "Richland"};
    private static String[] states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

}
