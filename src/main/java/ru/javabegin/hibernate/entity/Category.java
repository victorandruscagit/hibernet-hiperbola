package ru.javabegin.hibernate.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category", schema = "todolist", catalog = "postgres")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Category {

    // указываем, что поле заполняется в БД
    // нужно, когда добавляем новый объект и он возвращается уже с новым id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String title;

    @Column(name = "completed_count", updatable = false) // т.к. это поле высчитывается автоматически в триггерах - вручную его не обновляем (updatable = false)
    private Long completedCount;

    @Column(name = "uncompleted_count", updatable = false) // т.к. это поле высчитывается автоматически в триггерах - вручную его не обновляем (updatable = false)
    private Long uncompletedCount;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id") // по каким полям связаны эти 2 объекта (foreign key)
    private User user;


}
