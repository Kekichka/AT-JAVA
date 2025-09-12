package task5;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String name;
    private Boolean isEmployed;
    private List<String> address;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", isEmployed=" + isEmployed +
                ", address=" + address +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEmployed() {
        return isEmployed;
    }

    public void setEmployed(Boolean employed) {
        isEmployed = employed;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
}
