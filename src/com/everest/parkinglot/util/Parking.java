package com.everest.parkinglot.util;

public class Parking {
    public enum SlotStartsFor{
        CAR(3),BIKE(2),TRUCK(1);
        private int value;
        SlotStartsFor(int value){
            this.value=value;
        }

        public static String valueOf() {
            return null;
        }
    }
    public enum SlotEndsFor{
        CAR(6),BIKE(3),TRUCK(1);
        private int value;
        SlotEndsFor(int i) {
            this.value=i;
        }
    }
}
