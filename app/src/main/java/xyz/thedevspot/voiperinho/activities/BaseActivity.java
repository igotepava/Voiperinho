package xyz.thedevspot.voiperinho.activities;

import android.app.ProgressDialog;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import xyz.thedevspot.voiperinho.R;
import xyz.thedevspot.voiperinho.mvp.views.BaseView;

/**
 * Created by foi on 06/01/16.
 */
public class BaseActivity extends AppCompatActivity implements BaseView {

    private ProgressDialog progressDialog;

    @Override
    public void showProgress() {
        if (progressDialog == null || !progressDialog.isShowing()) {
            progressDialog = ProgressDialog.show(this, getString(R.string.app_name), getString(R.string.please_wait), true, false);
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
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), getString(error), Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(this, R.color.login_button_pressed));
        snackbar.show();
    }

    protected void initToolbar(Toolbar toolbar, @Nullable String title, boolean homeEnabled) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(homeEnabled);

            if (title != null) {
                getSupportActionBar().setTitle(title);
            }
        }
    }
}
