package ee.taltech.iti0200.personstatistics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CsvPersonMapper {

    public List<Person> mapToPersons(String path) throws CsvToPersonMappingException {
        List<Person> personList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(e -> {
                String[] attributes = e.split(",");
                Person person = new PersonBuilder().setFirstName(attributes[0])
                        .setLastName(attributes[1])
                        .setAge(Integer.parseInt(attributes[2]))
                        .setGender(attributes[3])
                        .setHeight(Double.parseDouble(attributes[4]))
                        .setOccupation(attributes[5])
                        .setNationality(attributes[6])
                        .build();
                personList.add(person);
            });

        } catch (IOException e) {
            throw new CsvToPersonMappingException();
        }
        return personList;
    }
}
