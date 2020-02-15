package waka.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class User {
    private String name = "";
    private String passWord = "";

    @Autowired
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

}
