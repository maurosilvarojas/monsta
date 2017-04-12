package rms.monsterbank;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by regga on 01/04/2017.
 */

public class RowAdapter  extends ArrayAdapter<String>{

    public RowAdapter(@NonNull Context context, @LayoutRes String[] inTansaction) {
        super(context, R.layout.custom_chat_row,inTansaction);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutinflater = LayoutInflater.from(getContext());
        View customeView = layoutinflater.inflate(R.layout.custom_chat_row,parent,false);

        return customeView;
    }
}
