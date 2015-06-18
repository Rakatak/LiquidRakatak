package com.example.rakatak.liquidrakatak.datalogic.user;

import android.provider.BaseColumns;

/**
 * Created by robins on 18.06.15.
 */
public final class UserEntryContract {

    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME_USER = "User";
        public static final String COLUMN_NAME_NAME = "Name";
        public static final String COLUMN_NAME_EMAIL = "Email";
        public static final String COLUMN_NAME_PASSWORD = "Password";
        public static final String[] COLUMNS = {COLUMN_NAME_PASSWORD, COLUMN_NAME_EMAIL ,COLUMN_NAME_NAME};
    }

}
