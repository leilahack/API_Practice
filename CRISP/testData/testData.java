package CRISP.testData;

import java.util.LinkedHashMap;
import java.util.Map;

public class testData {

    public static Map<String,Object> getPatient0(){

        Map<String, Object> patient0 = new LinkedHashMap<>();
        patient0.put("Id", "111");
        patient0.put("Name", "Jenn D.");
        patient0.put("DateOfBirth", "1934-06-01");
        patient0.put("Address", "CA");

        Map<String, Object> patient1 = new LinkedHashMap<>();
        patient1.put("Id", "222");
        patient1.put("Name", "Jack");
        patient1.put("DateOfBirth", "1956-05-01");
        patient1.put("Address", "MD");

        Map<String, Object> patient2 = new LinkedHashMap<>();
        patient2.put("Id", "333");
        patient2.put("Name", "Bernard");
        patient2.put("DateOfBirth", "1966-04-01");
        patient2.put("Address", "CA State");

        Map<String, Object> patient3 = new LinkedHashMap<>();
        patient3.put("Id", "444");
        patient3.put("Name", "Ross C.");
        patient3.put("DateOfBirth", "2000-03-01");
        patient3.put("Address", "Valley State");

        return patient0;

    }



}
