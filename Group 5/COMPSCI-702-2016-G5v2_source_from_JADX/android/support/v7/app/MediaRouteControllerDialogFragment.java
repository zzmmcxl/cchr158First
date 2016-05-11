package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class MediaRouteControllerDialogFragment extends DialogFragment {
    public MediaRouteControllerDialogFragment() {
        setCancelable(true);
    }

    public MediaRouteControllerDialog onCreateControllerDialog(Context context, Bundle savedInstanceState) {
        return new MediaRouteControllerDialog(context);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return onCreateControllerDialog(getActivity(), savedInstanceState);
    }
}
