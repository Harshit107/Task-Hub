package com.harshit.taskhub.Config;

public class Config {

    public static final String API_KEY = "https://harshit-taskhub.herokuapp.com/";
    //public static final String API_KEY = "http://192.168.0.7:3000/";

    public static final String CREATE_USER = API_KEY+"users";               //POST REQUEST
    public static final String CREATE_TASK =API_KEY+"task" ;                //POST REQUEST
    public static final String PROFILE = API_KEY+"users/me";                //GET
    public static final String UPDATE_PROFILE = API_KEY+"users";            //PATCH REQUEST
    public static final String UPDATE_TASK = API_KEY+"task";                //PATCH REQUEST
    public static final String DELETE_TASK =API_KEY +"task";                //DELETE
    public static final String DELETE_USER = API_KEY+"users/me";            //DELETE
    public static final String LOGIN = API_KEY+"users/login";               //POSt
    public static final String UPLOAD_IMAGE = API_KEY+"users/me/avtar";      //UPLOAD
    public static final String DELETE_IMAGE = API_KEY+"users/me/avtar";      //DELETE
    public static final String READ_TASK = API_KEY;                         //GET
    public static final String READ_ALL_TASK = API_KEY+"task";              //GET REQUEST

}
