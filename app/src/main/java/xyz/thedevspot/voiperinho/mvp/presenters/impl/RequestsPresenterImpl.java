package xyz.thedevspot.voiperinho.mvp.presenters.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.models.RequestInformation;
import xyz.thedevspot.voiperinho.models.User;
import xyz.thedevspot.voiperinho.mvp.interactors.RequestsInteractor;
import xyz.thedevspot.voiperinho.listeners.Listener;
import xyz.thedevspot.voiperinho.mvp.presenters.RequestsPresenter;
import xyz.thedevspot.voiperinho.mvp.views.RequestsView;

/**
 * Created by foi on 10/01/16.
 */
public class RequestsPresenterImpl implements RequestsPresenter {

    private RequestsView view;

    private RequestsInteractor interactor;

    @Inject
    public RequestsPresenterImpl(RequestsView view, RequestsInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void getRequests() {
        view.showProgress();
        interactor.getRequests(listener);
    }

    @Override
    public void onRequestClick(int id, boolean accept) {
        //view.showProgress();
        view.showMessage(R.string.accept);
        // TODO: accept/deny the request via interactor

    }

    private Listener<List<RequestInformation>> listener = new Listener<List<RequestInformation>>() {
        @Override
        public void onSuccess(List<RequestInformation> requestList) {
            view.hideProgress();

            if (requestList != null && requestList.size() > 0) {
                    List<User> userList = new ArrayList<>();

                    for (RequestInformation request : requestList) {
                        userList.add(request.getUser());
                    }

                    view.onRequestsReceived(userList);
            } else {
                view.onRequestsEmpty();
            }
        }

        @Override
        public void onFailure() {
            view.hideProgress();
            view.showMessage(R.string.something_wrong);
        }
    };
}
