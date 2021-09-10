package rob.myappcompany.navigationdrawerdemo.ui.home;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UserModel extends ArrayList<UserModel> {

    private int yourAge;
    private String yourName;
    private String dataOrTime;



    public UserModel(int yourAge, String yourName, String dataOrTime) {
        this.yourAge = yourAge;
        this.yourName = yourName;
        this.dataOrTime=dataOrTime;
    }

    public int getYourAge() {
        return yourAge;
    }

    public void setYourAge(int yourAge) {
        this.yourAge = yourAge;
    }

    public String getYourName() {
        return yourName;
    }

    public void setYourName(String yourName) {
        this.yourName = yourName;
    }

    public String getDataOrTime() {
        return dataOrTime;
    }

    public void setDataOrTime(String dataOrTime) {
        this.dataOrTime = dataOrTime;
    }

}
