package springmvc.dao;

import org.springframework.stereotype.Component;
import springmvc.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT; //id
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Ivan"));
        people.add(new Person(++PEOPLE_COUNT, "Egor"));
        people.add(new Person(++PEOPLE_COUNT, "Maxim"));
        people.add(new Person(++PEOPLE_COUNT, "Petr"));
    }  //блок инициализации

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null); //ищем по id
    }
}
