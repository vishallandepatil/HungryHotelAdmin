package com.hungry.hotel.hungryhoteladmin.utils;

import com.hungry.hotel.hungryhoteladmin.broadcastreceiver.ConnectivityReceiver;

public abstract class InternetConnectivityUtils {
    public static void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }
}
