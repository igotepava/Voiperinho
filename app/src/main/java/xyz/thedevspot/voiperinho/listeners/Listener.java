package xyz.thedevspot.voiperinho.listeners;

/**
 * Created by foi on 11/02/16.
 */
public interface Listener<T> {

    void onSuccess(T response);

    void onFailure();
}
