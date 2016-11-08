package eugene.spring.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Aspire on 05.11.2016.
 */

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isAdmin;

    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
    private Timestamp createDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    @PrePersist
    void onCreate() {
        this.setCreateDate(new Timestamp((new Date()).getTime()));
    }

}
