package com.robert.mentor.domain.technology;

import com.robert.mentor.domain.DDD;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@DDD.AggregateRoot
@Entity
@Table(name = "TECHNOLOGY")
@NoArgsConstructor
@Getter
@Setter
public class Technology {

    @Id
    @Column(name = "TECH_NAME")
    private String value;

    public Technology(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
