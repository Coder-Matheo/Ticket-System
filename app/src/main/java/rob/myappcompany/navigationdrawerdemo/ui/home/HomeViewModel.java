package rob.myappcompany.navigationdrawerdemo.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private ArrayList<UserModel> userPropertObject = new ArrayList<>();


    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    MutableLiveData<List<UserModel>> result = new MutableLiveData<>();

    //Is the Test for request ArrayList with LiveData
    public ArrayList<UserModel> user(){
        ArrayList<UserModel> userModelInside = new ArrayList<>();
        userModelInside.add(new UserModel(30,"Matheo", getDataTime("Time")));
        userModelInside.add(new UserModel(44,"Martin", getDataTime("Date")));
        userModelInside.add(new UserModel(31,"Shahram", getDataTime("Date")));
        return userModelInside;
    }

    public LiveData<List<UserModel>> getUserInfo(){
        result.postValue(user());
        return  result;
    }

    public LiveData<String> getText() {
        return mText;
    }


    public String getDataTime(String choose){
        LocalDateTime localDateTime;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            localDateTime = LocalDateTime.now();

            if (choose.equals("Date")){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                return localDateTime.format(formatter);
            }else if(choose == "Time"){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                return localDateTime.format(formatter);
            }else if (choose == "DataTime"){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                return localDateTime.format(formatter);
            }
        }
        return choose;
    }

}