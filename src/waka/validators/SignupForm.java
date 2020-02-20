package waka.validators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupForm implements Serializable {

    private static final long serialVersionUID = 1L;

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    @NotNull
    @NotEmpty
    @Size(min = 6, message = "username should be consist of 6 to 20 characters")
    private String username;

    @NotNull
    @NotEmpty
    @Size(min = 6, message = "password should be consist of 6 to 20 characters")
    private String password;

}
