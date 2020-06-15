package com.example.sozieassessment.utils;

import androidx.annotation.NonNull;

public class UtilsGeneral {

    public static final String EXTRA_BODY_TYPE = "com.example.sozieassessment.BODY_TYPE";

    public enum BodyType{
        UNKNOWN {
            @NonNull
            @Override
            public String toString() {
                return "";
            }
        },
        MALE {
            @NonNull
            @Override
            public String toString() {
                return "Male";
            }
        },
        FEMALE {
            @NonNull
            @Override
            public String toString() {
                return "Female";
            }
        };

        public static BodyType fromString(String type){
            if (type.isEmpty())
                return UNKNOWN;

            for(BodyType bodyType : BodyType.values()){
                if(bodyType.toString().equals(type))
                    return bodyType;
            }

            return UNKNOWN;
        }
    }
}
