package rob.myappcompany.navigationdrawerdemo.ui.home;

import android.content.ContentValues;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import rob.myappcompany.navigationdrawerdemo.DatabaseHelper;
import rob.myappcompany.navigationdrawerdemo.R;
import rob.myappcompany.navigationdrawerdemo.TicketAdapter;
import rob.myappcompany.navigationdrawerdemo.TicketModel;
import rob.myappcompany.navigationdrawerdemo.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private ArrayList<String> creatorList = new ArrayList<>();
    private ArrayList<String> quastionList = new ArrayList<>();
    private ArrayList<String> situationList = new ArrayList<>();
    private ListView ticketListView;
    private Snackbar snackbar;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Declare HomeViewModel
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ticketListView = root.findViewById(R.id.ticketListView);



        //Insert Values to Ticket Database Table
        DatabaseHelper databaseHelper = new DatabaseHelper(getContext());

        /*databaseHelper.addTicket(new TicketModel("1","Mattheo","what is that?",
                "IT", "Problem", "Activ","HIGH",
                "11.02.2020","11.02.2020"));*/


        //Read Ticket Database and add values into homeViewModel
        for (int j = 0; j < databaseHelper.getAllTicket().size(); j++){

            //first Parameter is ID, but we give it default Value Creater_name
            homeViewModel.user(new TicketModel(databaseHelper.getAllTicket().get(j).getCOLUM_CREATOR_NAME(),
                            databaseHelper.getAllTicket().get(j).getCOLUM_CREATOR_NAME(),
                            databaseHelper.getAllTicket().get(j).getCOLUM_QUESTION_TICKET(),
                            databaseHelper.getAllTicket().get(j).getCOLUM_TICKET_NAME(),
                            databaseHelper.getAllTicket().get(j).getCOLUM_TITLE_CREATED(),
                            databaseHelper.getAllTicket().get(j).getCOLUM_SITUATION_TICKET(),
                            databaseHelper.getAllTicket().get(j).getCOLUM_PRIORITY_TICKET(),
                            databaseHelper.getAllTicket().get(j).getCOLUM_CREATED_DATE(),
                            databaseHelper.getAllTicket().get(j).getCOLUM_UPDATED_DATE()));


        }


        //Get values from HomeViewModel (with Object List TicketModel) and add it in new ArrayList
        homeViewModel.getUserInfo().observe(getViewLifecycleOwner(), new Observer<List<TicketModel>>() {
            @Override
            public void onChanged(List<TicketModel> getValuesFromModels) {
                for (int i = 0; i < getValuesFromModels.size(); i++){
                    //New ArrayList add Values for TicketAdapter
                    creatorList.add(getValuesFromModels.get(i).getCOLUM_CREATOR_NAME());
                    quastionList.add(String.valueOf(getValuesFromModels.get(i).getCOLUM_QUESTION_TICKET()));
                    situationList.add(getValuesFromModels.get(i).getCOLUM_SITUATION_TICKET());
                }
            }
        });

        //Ticket adapter (Customer ListView) to show ListView with Image and Text
        TicketAdapter ticketAdapter = new TicketAdapter(getContext(), creatorList, quastionList, situationList);
        ticketListView.setAdapter(ticketAdapter);

        ListViewClickListen();

        return root;
    }
    public void ListViewClickListen(){
        ticketListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("TAG PRESS",creatorList.get(position));
            }
        });
        ticketListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("TAG PRESS",quastionList.get(position));
                snackbar.make(view,"IS PRESSED", Snackbar.LENGTH_SHORT).setAction("HERE", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(v, "SnackBar Pressed", Snackbar.LENGTH_SHORT).show();
                    }
                }).show();
                return true;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}