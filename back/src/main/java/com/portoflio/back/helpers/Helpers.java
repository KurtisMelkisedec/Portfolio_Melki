package com.portoflio.back.helpers;

import java.util.Base64;

public class Helpers {

    public static byte[] getImageAsByte(String image){
        return Base64.getDecoder().decode(image);
    }
    public static String setImageFromBytes(byte[] image){
        return Base64.getEncoder().encodeToString(image);
    }
}
