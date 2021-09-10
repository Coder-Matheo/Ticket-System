package rob.myappcompany.navigationdrawerdemo;

import android.view.View;
import android.widget.TextView;


public class Pro_ViewHolder {
    //hold TextView from UI to Adapter
    TextView createrTextView;
    TextView quastionTextView;
    TextView createdTextView;

    Pro_ViewHolder(View view){
        createrTextView = view.findViewById(R.id.createrTextView);
        quastionTextView = view.findViewById(R.id.questionTextView);
        createdTextView = view.findViewById(R.id.createdDateTextView);
    }


}
