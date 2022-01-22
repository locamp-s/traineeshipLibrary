package test.com.library.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

    @Entity
    @Table(name = "role")
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        @Column(name = "name")
        private String roleName;
}
