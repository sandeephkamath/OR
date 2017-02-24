package in.or.or.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Category implements Parcelable {
    private String id;
    private String title;
    private String banner;
    private String link;
    private ArrayList<Category> subcategories;

    protected Category(Parcel in) {
        id = in.readString();
        title = in.readString();
        banner = in.readString();
        link = in.readString();
        subcategories = in.createTypedArrayList(Category.CREATOR);
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getBanner() {
        return banner;
    }

    public ArrayList<Category> getSubcategories() {
        return subcategories;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(banner);
        parcel.writeString(link);
        parcel.writeTypedList(subcategories);
    }
}