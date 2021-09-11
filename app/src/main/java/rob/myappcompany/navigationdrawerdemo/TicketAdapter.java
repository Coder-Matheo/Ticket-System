package rob.myappcompany.navigationdrawerdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import rob.myappcompany.navigationdrawerdemo.ui.home.HomeFragment;

public class TicketAdapter extends ArrayAdapter<String> {

    ArrayList<String> createrList;
    ArrayList<String> questionList;
    ArrayList<String> ticketNameList;
    ArrayList<String> titleCreatedList;
    ArrayList<String> situationList;
    ArrayList<String> priorityList;
    ArrayList<String> createdDateList;
    ArrayList<String> updatedDateList;


    public TicketAdapter(Context context, ArrayList<String> createrListIn, ArrayList<String> quastionListIn, ArrayList<String>situationList) {
        super(context, R.layout.single_item_custom_view, R.id.createrTextView, createrListIn);
        this.createrList= createrListIn;
        this.questionList=quastionListIn;
        this.situationList=situationList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View singleItemView = convertView;
        Pro_ViewHolder holder = null;
        if (singleItemView == null){
            LayoutInflater layoutInflater =(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItemView = layoutInflater.inflate(R.layout.single_item_custom_view, parent, false);
            holder = new Pro_ViewHolder(singleItemView);
            singleItemView.setTag(holder);
        }
        else
        {
            holder = (Pro_ViewHolder) singleItemView.getTag();
        }

        holder.createrTextView.setText(createrList.get(position));
        holder.quastionTextView.setText(questionList.get(position));
        holder.createdTextView.setText(situationList.get(position));


        return singleItemView;
    }
}
