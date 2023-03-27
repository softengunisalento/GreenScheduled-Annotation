package com.example.Tesi.error;

public class ErrorHandler extends Exception {

    final static String ZONE_NOT_FOUND = "Zone not found!";
    final static String AUTHORIZATION = "Forbidden Key or Value!";

    final static String ACCESS_DENIED = "Access to the service denied!";



    public ErrorHandler(Throwable cause, String message) {
        super(message, cause);
    }

    public static class ZoneNotFound extends ErrorHandler{
        public ZoneNotFound(Throwable cause) {
            super(cause, ZONE_NOT_FOUND);
        }
    }

    public static class Unathorized extends ErrorHandler{
        public Unathorized(Throwable cause) {
            super(cause, AUTHORIZATION);
        }
    }

    public static class AccessDenied extends ErrorHandler{
        public AccessDenied(Throwable cause) {
            super(cause, ACCESS_DENIED);
        }
    }


}

