package org.pract.demo.two.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
@ToString(exclude = {"id"} ) @EqualsAndHashCode
public class Person {
    @Id
    private long id;

    private String firstName;
    private String lastName;

    public Person(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
