package com.example.hp.mockipl.db;

import android.provider.BaseColumns;

/**
 * Created by HP on 3/20/2017.
 */

public class QuizContract {
    public QuizContract() {
    }
    public static class Quiz implements BaseColumns {
        public static final String TABLE_NAME = "quiz";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_Ques = "ques";
        public static final String COLUMN_NAME_Op1 = "op1";
        public static final String COLUMN_NAME_Op2 = "op2";
        public static final String COLUMN_NAME_Op3 = "op3";
        public static final String COLUMN_NAME_Op4 = "op4";
        public static final String COLUMN_NAME_ans = "ans";
        public static final String COLUMN_NAME_sta = "status";
    }
}
