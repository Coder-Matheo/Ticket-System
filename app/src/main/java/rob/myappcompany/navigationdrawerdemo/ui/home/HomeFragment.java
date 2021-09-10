package rob.myappcompany.navigationdrawerdemo.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

import rob.myappcompany.navigationdrawerdemo.R;
import rob.myappcompany.navigationdrawerdemo.TicketAdapter;
import rob.myappcompany.navigationdrawerdemo.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private ArrayList<String> creatorList = new ArrayList<>();
    private ArrayList<String> quastionList = new ArrayList<>();
    private ArrayList<String> situationList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Declare HomeViewModel
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView ticketListView = root.findViewById(R.id.ticketListView);

        final TextView textView = binding.textHome;

        //Get values from HomeViewModel and add it in new ArrayList
        homeViewModel.getUserInfo().observe(getViewLifecycleOwner(), new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> userModels) {
                for (int i = 0; i < userModels.size(); i++){
                    creatorList.add(userModels.get(i).getYourName());
                    quastionList.add(String.valueOf(userModels.get(i).getYourAge()));
                    situationList.add(userModels.get(i).getDataOrTime());
                }
            }
        });

        //Ticket adapter (Customer ListView) to show ListView with Image and Text
        TicketAdapter ticketAdapter = new TicketAdapter(getContext(), creatorList, quastionList, situationList);
        ticketListView.setAdapter(ticketAdapter);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}