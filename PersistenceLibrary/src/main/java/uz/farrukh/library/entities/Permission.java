package uz.farrukh.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "permissions")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @DateTimeFormat
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
