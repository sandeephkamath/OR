package in.or.or.ui.categorylist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import in.or.or.R;
import in.or.or.model.Category;

class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryHolder> {

    private ArrayList<Category> categoryList;
    private Context context;
    private CategoryClickListener categoryClickListener;

    CategoryListAdapter(Context context, ArrayList<Category> categoryList, CategoryClickListener categoryClickListener) {
        this.context = context;
        this.categoryList = categoryList;
        this.categoryClickListener = categoryClickListener;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryHolder(LayoutInflater.from(context).inflate(R.layout.category_item, parent, false));
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, int position) {
        Category category = categoryList.get(position);
        Glide.with(context)
                .load(category.getBanner())
                .centerCrop()
                .crossFade()
                .into(holder.banner);
        holder.title.setText(category.getTitle());
    }

    @Override
    public int getItemCount() {
        if (null != categoryList)
            return categoryList.size();
        return 0;
    }

    class CategoryHolder extends RecyclerView.ViewHolder {
        private ImageView banner;
        private TextView title;

        public CategoryHolder(View itemView) {
            super(itemView);
            banner = (ImageView) itemView.findViewById(R.id.banner);
            title = (TextView) itemView.findViewById(R.id.title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    categoryClickListener.onCategoryClick(categoryList.get(getAdapterPosition()));
                }
            });
        }
    }

    interface CategoryClickListener {
        void onCategoryClick(Category category);
    }
}