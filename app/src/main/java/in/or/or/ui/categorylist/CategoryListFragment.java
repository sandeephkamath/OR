package in.or.or.ui.categorylist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.or.or.R;
import in.or.or.model.Category;
import in.or.or.network.NetworkAdapter;
import in.or.or.network.ResponseCallback;


public class CategoryListFragment extends Fragment implements CategoryListAdapter.CategoryClickListener {

    private static final String TAG = CategoryListFragment.class.getSimpleName();
    private RecyclerView categoryRecyclerView;

    public static CategoryListFragment newInstance() {
        CategoryListFragment fragment = new CategoryListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
        categoryRecyclerView = (RecyclerView) view.findViewById(R.id.category_list);
        getCategories();
        return view;
    }

    private void getCategories() {
        NetworkAdapter.getInstance(getActivity()).getCategories(new ResponseCallback<ArrayList<Category>>() {
            @Override
            public void onResponse(ArrayList<Category> response) {
                CategoryListAdapter categoryListAdapter = new CategoryListAdapter(getActivity(), response, CategoryListFragment.this);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                categoryRecyclerView.setLayoutManager(linearLayoutManager);
                categoryRecyclerView.setAdapter(categoryListAdapter);
                Log.d(TAG, "Success" + response.size());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG, "Failure");
            }
        });
    }


    @Override
    public void onCategoryClick(Category category) {

    }
}
