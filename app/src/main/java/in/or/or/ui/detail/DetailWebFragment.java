package in.or.or.ui.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.or.or.R;
import in.or.or.model.Category;


public class DetailWebFragment extends Fragment {

    private static final String ARG_CATEGORY = "category";

    private Category category;

    public DetailWebFragment() {
        // Required empty public constructo
    }


    public static DetailWebFragment newInstance(Category category) {
        DetailWebFragment fragment = new DetailWebFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            category = getArguments().getParcelable(ARG_CATEGORY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sub_category_list, container, false);
    }


}
