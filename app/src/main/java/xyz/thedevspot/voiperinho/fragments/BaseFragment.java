package xyz.thedevspot.voiperinho.fragments;

import android.app.ProgressDialog;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;

import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.mvp.views.BaseView;

/**
 * Created by foi on 10/01/16.
 */
public class BaseFragment extends android.support.v4.app.Fragment implements BaseView {

    private ProgressDialog progressDialog;

    @Override
    public void showProgress() {
        if (progressDialog == null || !progressDialog.isShowing()) {
            progressDialog = ProgressDialog.show(getActivity(), getString(R.string.app_name), getString(R.string.please_wait), true, false);
        }
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    public void showMessage(@StringRes int error) {
        Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), getString(error), Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.login_button_pressed));
        snackbar.show();
    }
}
