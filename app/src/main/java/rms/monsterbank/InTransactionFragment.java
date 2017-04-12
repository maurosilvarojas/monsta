package rms.monsterbank;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;

import rms.monsterbank.Adpaters.DepositAdapter;
import rms.monsterbank.Model.Deposit;


public class InTransactionFragment extends ListFragment {



        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return  inflater.inflate(R.layout.fragment_in,container,false);

            // Construct the data source
           // ArrayList<Deposit> deposits = new ArrayList<Deposit>();
            // Create the adapter to convert the array to views
           // DepositAdapter adapter = new DepositAdapter(getContext(),R.layout.item_deposit,deposits );
            // Attach the adapter to a ListView
            //ListView listView = (ListView)getActivity().findViewById(R.id.lvDeposits);
            //listView.setAdapter(adapter);

//            ListAdapter listAdapter = new ArrayAdapter<String>(getActivity()
//                    .getApplicationContext(), R.layout.fragment_in,deposits);
//            ListView listView = (ListView)getView().findViewById(R.id.lvDeposits);
//            listView.setAdapter(listAdapter);

//            // Add item to adapter
//            Deposit newUser = new Deposit("1","Nathan", "San Diego","3232.2");
//            adapter.add(newUser);
//            Deposit newUser1 = new Deposit("2","Some", "San Diego","52.3");
//            adapter.add(newUser1);
        }


}