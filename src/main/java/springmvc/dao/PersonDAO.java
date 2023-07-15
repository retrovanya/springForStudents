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

        people.add(new Person(++PEOPLE_COUNT, "Ivan", 21, "ivanvetikodny@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Egor", 20, "egoreftrv@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Maxim", 22, "maxtikokog@chech.com"));
        people.add(new Person(++PEOPLE_COUNT, "Petr", 19, "petutr@mail.rt"));
    }  //блок инициализации

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null); //ищем по id
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
