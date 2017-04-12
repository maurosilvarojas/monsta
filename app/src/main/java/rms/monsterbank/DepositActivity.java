package rms.monsterbank;

import android.app.Activity;
import android.icu.util.RangeValueIterator;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import rms.monsterbank.Adpaters.DepositAdapter;
import rms.monsterbank.Model.Deposit;

public class DepositActivity extends Activity  {


    JSONObject item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        // Construct the data source
        ArrayList<Deposit> deposits = new ArrayList<Deposit>();
        // Create the adapter to convert the array to views
        DepositAdapter adapter = new DepositAdapter(this,R.layout.item_deposit,deposits );
        // Attach the adapter to a ListView
        ListView listView = (ListView)findViewById(R.id.lvDeposits);
        listView.setAdapter(adapter);

//            ListAdapter listAdapter = new ArrayAdapter<String>(getActivity()
//                    .getApplicationContext(), R.layout.fragment_in,deposits);
//            ListView listView = (ListView)getView().findViewById(R.id.lvDeposits);
//            listView.setAdapter(listAdapter);

    }


}








