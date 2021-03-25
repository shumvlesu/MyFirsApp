package com.shumikhin.myfirsapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

//public class Lesson3Counters implements Serializable {
public class Lesson3Counters implements Parcelable {
    private int counter1;
    private int counter2;

    public Lesson3Counters() {
        counter1 = 0;
        counter2 = 0;
    }

    protected Lesson3Counters(Parcel in) {
        counter1 = in.readInt();
        counter2 = in.readInt();
    }

    public int getCounter1() {
        return counter1;
    }

    public void incrementCounter1() {
        this.counter1++;
    }

    public int getCounter2() {
        return counter2;
    }

    public void incrementCounter2() {
        this.counter2++;
    }

    //для Parcelable надо переопределить эти два метода и Creator

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(counter1);
        parcel.writeInt(counter2);
    }

    public static final Creator<Lesson3Counters> CREATOR = new Creator<Lesson3Counters>() {
        @Override
        public Lesson3Counters createFromParcel(Parcel in) {
            return new Lesson3Counters(in);
        }

        @Override
        public Lesson3Counters[] newArray(int size) {
            return new Lesson3Counters[size];
        }
    };
}
