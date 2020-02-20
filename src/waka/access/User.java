package waka.access;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.Id;
import waka.persistence.JPAWakaRepository;

import javax.persistence.*;
import java.util.Objects;

@EntityListeners(JPAWakaRepository.class)
@Entity
@Table(name = "T_USER")
@ComponentScan
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name = "";
    @Column(name = "PASSWORD", nullable = false, length = 50)
    private String passWord = "";
    @Column(name = "EMAIL", nullable = true, length = 150)
    private String email = "";
    @Column(name = "DATE", nullable = true, length = 150)
    private String creationDate = "";
    @Column(name = "ROLE")
    private String role;


    public String getName () {
        return name;
    }

    public void setName (String param) {
        this.name = param;
    }

    public String getPassWord () {
        return passWord;
    }

    public void setPassWord (String passWord) {
        this.passWord = passWord;
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getRole () {
        return role;
    }

    public void setRole (String role) {
        this.role = role;
    }

    public String getCreationDate () {
        return creationDate;
    }

    public void setCreationDate (String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public int hashCode () {
        return Objects.hash(name, passWord, email);
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(passWord, user.passWord);
    }

    @Override
    public String toString () {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", password='").append(passWord).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
