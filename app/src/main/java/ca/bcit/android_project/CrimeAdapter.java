//package ca.bcit.android_project;
//
//import android.content.Context;
//import android.graphics.Movie;
//import android.support.annotation.LayoutRes;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CrimeAdapter extends ArrayAdapter<Crime> {
//    private Context mContext;
//    private List<Crime> crimeList = new ArrayList<>();
//
//    public CrimeAdapter(@NonNull Context context,  ArrayList<Crime> list) {
//        super(context, 0 , list);
//        mContext = context;
//        crimeList = list;
//    }
//    @NonNull
//    @Override
//    public View getView(, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View listItem = convertView;
//
//        Crime currentCrime = crimeList.get(position);
//
//
//
//        TextView name = (TextView) listItem.findViewById(R.id.list);
//        name.setText(currentCrime.getCity());
//
//
//
//        return listItem;
//    }
//}
