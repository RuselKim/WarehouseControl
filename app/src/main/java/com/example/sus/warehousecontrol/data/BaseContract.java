package com.example.sus.warehousecontrol.data;

import android.provider.BaseColumns;

/**
 * Created by Sus on 06.09.2017.
 */

public final class BaseContract {
    private BaseContract(){
    };

    public static final class WarehouseBase implements BaseColumns{
        public final static String TABLE_NAME = "warehouse";

        public final static String _ID = BaseColumns._ID;
        public final static String ITEM = "item";
        public final static String COUNT = "count";

    }

}
