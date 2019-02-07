package com.example.sqlitetutor;

import android.provider.BaseColumns;

public final class ContactContract {

    private ContactContract(){}

    public static class ContactEntry implements BaseColumns {
        public static final String TABLE_NAME = "contact_info";
        public static final String CONTACT_NO = "contact_no";
        public static final String NAME = "name";
        public static final String EMAIL = "email";
    }

}
