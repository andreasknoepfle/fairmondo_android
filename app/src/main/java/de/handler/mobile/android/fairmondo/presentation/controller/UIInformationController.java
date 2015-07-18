package de.handler.mobile.android.fairmondo.presentation.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import de.handler.mobile.android.fairmondo.FairmondoApp;
import de.handler.mobile.android.fairmondo.R;
import de.handler.mobile.android.fairmondo.data.interfaces.OnNetworkAvailableListener;

/**
 * An controller displaying error messages to the user.
 */
public class UIInformationController {
    /**
     * Displays a message as Toast.
     */
    public static void displayToastInformation(@NonNull final Context context, @NonNull final String errorMessage) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
    }

    /**
     * Displays a message as Snackbar.
     */
    public static void displaySnackbarInformation(@NonNull final View parentView, @NonNull final String errorMessage) {
        Snackbar.make(parentView, errorMessage, Snackbar.LENGTH_SHORT)
                .setActionTextColor(parentView.getResources().getColor(R.color.fairmondo_blue_dark))
                .show();
    }

    /**
     * Displays a message as Snackbar.
     */
    public static AlertDialog displayDialogInformation(@NonNull final Context context, @NonNull final String errorMessage, @NonNull final OnNetworkAvailableListener listener, @NonNull final FairmondoApp mApp) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(errorMessage).setTitle(R.string.app_not_connected);
        builder.setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (mApp.isConnected()) {
                    listener.onNetworkAvailable();
                }
            }
        });
        return builder.create();
    }
}