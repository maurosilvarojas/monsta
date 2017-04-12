package rms.monsterbank;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import static android.R.id.message;

public class ChatActivity extends Activity {

    String clientId = MqttClient.generateClientId();
    MqttAndroidClient client;

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText msgInput;
    String[] messageInArray={"Customer Support,how may I help you ?"};
    int n=0;
    String arrivedMessage;

  //  arrayList = new ArrayList<>(Arrays.asList(messageInArray));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Log.d("Debugging", " Start chat activity");

        arrayList = new ArrayList<>(Arrays.asList(messageInArray));
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        //**********************************
        //    MQTT initialization.start
        //***********************************

        client = new MqttAndroidClient(this.getApplicationContext(), "tcp://broker.hivemq.com:1883",
                clientId);
        MqttConnectOptions options = new MqttConnectOptions();

        try {
            IMqttToken token = client.connect();

            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    Log.d("mqtt", "onSuccess");

                    setSubscriber();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Log.d("mqtt", "onFailure");

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }

        client.setCallback(new MqttCallback() {
                               @Override
                               public void connectionLost(Throwable cause) {

                               }

                               @Override
                               public void messageArrived(String topic, MqttMessage message) throws Exception {
                                   Log.d("mqtt", "messageReceived:" + message);
                                    arrivedMessage=message.toString();
                                   Log.d("mqtt", "messageReceived:" + message);

                                   arrayList.add((n), message.toString());
                                   itemsAdapter.notifyDataSetChanged();


//                myTextView.setText(new String(message.getPayload()));
//                Toast.makeText(MainActivity.this,"RECEIVED",Toast.LENGTH_LONG);
//                Toast.makeText(MainActivity.this,"RECEIVED",Toast.LENGTH_LONG);
                               }

                               @Override
                               public void deliveryComplete(IMqttDeliveryToken token) {

                               }
                           });

        //***

        EditText chatMessageOut = (EditText) findViewById(R.id.msginput);

//        arrayList = new ArrayList<>(Arrays.asList(messageInArray));
//        ArrayAdapter<String> itemsAdapter =
//                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        ListView listView = (ListView) findViewById(R.id.chatListView);
        listView.setAdapter(itemsAdapter);

        Button sendButton = (Button) findViewById(R.id.sendMsg);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Debugging", "Send Button Click");
                String newMessage = chatMessageOut.getText().toString();
                try {
                    client.publish("bankCustomer", newMessage.getBytes(),0,false);
                    Log.d("mqtt", "message sent : "+ newMessage);
                } catch (MqttException e) {
                    e.printStackTrace();
                }

                arrayList.add((n ), newMessage);
                itemsAdapter.notifyDataSetChanged();
                chatMessageOut.setText("");

            }



        });
    }

    private void setSubscriber() {
        try{
            client.subscribe("bankSupport",0);
        }catch(MqttException e){
            e.printStackTrace();
        }
    }

}


