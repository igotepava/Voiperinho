package xyz.thedevspot.voiperinho.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.VoiperinhoApplication;
import xyz.thedevspot.voiperinho.adapters.ChatAdapter;
import xyz.thedevspot.voiperinho.helpers.SharedPreferencesHelper;
import xyz.thedevspot.voiperinho.models.Message;
import xyz.thedevspot.voiperinho.mvp.views.ChatView;

public class ChatActivity extends BaseActivity implements ChatView {

    @Bind(R.id.chat_send)
    Button sendButton;

    @Bind(R.id.chat_message)
    EditText chatMessage;

    @Bind(R.id.chat_list)
    ListView chatListView;

    private ChatAdapter adapter;

    private List<Message> messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle(SharedPreferencesHelper.getContact(VoiperinhoApplication.getInstance()));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        messageList = new ArrayList<>();
    }

    @OnClick(R.id.chat_send)
    protected void onClickSend() {
        Message message = new Message();
        // TODO: send message via socket
    }

    @Override
    public void onMessageReceived(Message message) {
        messageList.add(message);
        adapter = new ChatAdapter(this, messageList);
        chatListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}