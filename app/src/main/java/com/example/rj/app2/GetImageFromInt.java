//package com.example.rj.app2;
//
//import android.os.AsyncTask;
//import android.util.Log;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//
//public class GetImageFromInt extends AsyncTask <String, Void, ByteArrayOutputStream> {
//
//    private static final String TAG = GetImageFromInt.class.getSimpleName();
//
//
//    MyDatabaseHelper myDatabaseHelper;
//
//    public GetImageFromInt (MyDatabaseHelper myDatabaseHelper) {
//        this.myDatabaseHelper = myDatabaseHelper;
//    }
//    @Override
//    protected ByteArrayOutputStream doInBackground(String... strings) {
//        Log.i(TAG, "doInBackground start");
//
//        try {
//            URL url = new URL(strings[0]);
//            ByteArrayOutputStream output = new ByteArrayOutputStream();
//            InputStream inputStream = url.openStream();
//            int n = 0;
//            byte [] buffer = new byte[ 1024 ];
//            while (-1 != (n = inputStream.read(buffer))) {
//                output.write(buffer, 0, n);
//            }
//            Log.i(TAG, "doInBackground finish");
//
//            return output;
//        }
//        catch (IOException i ){
//            Log.e(TAG, "doInBackground error",i);
//        }
//
//        return null;
//    }
//
//    @Override
//    protected void onPostExecute(ByteArrayOutputStream byteArrayOutputStream) {
//    byte [] imageFromInt = byteArrayOutputStream.toByteArray();
//        Log.i(TAG, "onPostExecute start");
//
//        try {
//            this.myDatabaseHelper.createRecipe(imageFromInt);
//            Log.i(TAG, "onPostExecute finish");
//
//        } catch (Exception e) {
//            Log.e(TAG, "onPostExecute error",e);
//
//            e.printStackTrace();
//        }
////    createRecipe(db);
//
//    }
//}
