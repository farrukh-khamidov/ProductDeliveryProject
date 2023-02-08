package uz.farrukh.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "regions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;


    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = new Date();
    }

}
