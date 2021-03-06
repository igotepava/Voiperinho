package xyz.thedevspot.voiperinho.mvp.interactors.impl;

import java.util.List;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import xyz.thedevspot.voiperinho.helpers.SharedPreferencesHelper;
import xyz.thedevspot.voiperinho.listeners.Listener;
import xyz.thedevspot.voiperinho.models.BaseResponse;
import xyz.thedevspot.voiperinho.models.User;
import xyz.thedevspot.voiperinho.mvp.interactors.ContactsInteractor;
import xyz.thedevspot.voiperinho.network.ApiService;

/**
 * Created by foi on 09/01/16.
 */
public class ContactsInteractorImpl implements ContactsInteractor {

    private Listener<List<User>> listener;

    private ApiService apiService;

    @Inject
    public ContactsInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getContacts(Listener<List<User>> listener) {
        this.listener = listener;
        int id = SharedPreferencesHelper.getInt(SharedPreferencesHelper.USER_ID);

//        ReceiverSocket.getInstance().setContactsListener(cListener);

        Call<BaseResponse<List<User>>> call = apiService.getContacts(id);
        call.enqueue(callback);
    }

    private Callback<BaseResponse<List<User>>> callback = new Callback<BaseResponse<List<User>>>() {
        @Override
        public void onResponse(Response<BaseResponse<List<User>>> response, Retrofit retrofit) {
            listener.onSuccess(response.body().getMessage());
        }

        @Override
        public void onFailure(Throwable t) {
            listener.onFailure();
        }
    };
}
