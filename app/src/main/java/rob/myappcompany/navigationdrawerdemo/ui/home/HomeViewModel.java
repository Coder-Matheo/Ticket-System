package rob.myappcompany.navigationdrawerdemo.ui.home;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import rob.myappcompany.navigationdrawerdemo.DatabaseHelper;
import rob.myappcompany.navigationdrawerdemo.TicketModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private ArrayList<TicketModel> userModelInside = new ArrayList<>();;

    Context context;
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    MutableLiveData<List<TicketModel>> result = new MutableLiveData<>();



    //request ArrayList with LiveData
    public void user(TicketModel ticketModel){

        //first value is ID, but we give default Value Ticket_name
        userModelInside.add(new TicketModel(
                ticketModel.getCOLUM_TICKET_NAME(),
                ticketModel.getCOLUM_CREATOR_NAME(),
                ticketModel.getCOLUM_QUESTION_TICKET(),
                ticketModel.getCOLUM_TICKET_NAME(),
                ticketModel.getCOLUM_TITLE_CREATED(),
                ticketModel.getCOLUM_SITUATION_TICKET(),
                ticketModel.getCOLUM_PRIORITY_TICKET(),
                ticketModel.getCOLUM_CREATED_DATE(),
                ticketModel.getCOLUM_UPDATED_DATE()));
    }

    public MutableLiveData<List<TicketModel>> getUserInfo(){
        result.postValue(userModelInside);
        return  result;
    }
}