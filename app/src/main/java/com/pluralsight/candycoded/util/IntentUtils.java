package com.pluralsight.candycoded.util;

import android.content.Context;
import android.content.Intent;

public class IntentUtils {

    public static boolean hasResolvedActivity(Context context, Intent intent) {
        return intent.resolveActivity(context.getPackageManager()) != null;
    }

}
