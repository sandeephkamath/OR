package in.or.or.ui.subcategorylist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.or.or.R;
import in.or.or.model.Category;


class SubCategoryListAdapter extends RecyclerView.Adapter<SubCategoryListAdapter.SubCategoryHolder> {

    private ArrayList<Category> categoryList;
    private Context context;
    private SubCategoryClickListener subCategoryClickListener;

    SubCategoryListAdapter(Context context, ArrayList<Category> categoryList, SubCategoryClickListener subCategoryClickListener) {
        this.context = context;
        this.categoryList = categoryList;
        this.subCategoryClickListener = subCategoryClickListener;
    }

    @Override
    public SubCategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SubCategoryHolder(LayoutInflater.from(context).inflate(R.layout.sub_category_item, parent, false));
    }

    @Override
    public void onBindViewHolder(SubCategoryHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (null != categoryList)
            categoryList.size();
        return 0;
    }

    public class SubCategoryHolder extends RecyclerView.ViewHolder {
        public SubCategoryHolder(View itemView) {
            super(itemView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    subCategoryClickListener.onSubCategoryClick(categoryList.get(getAdapterPosition()));
                }
            });
        }
    }

    interface SubCategoryClickListener {
        void onSubCategoryClick(Category category);
    }
}