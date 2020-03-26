package com.acun.submission2;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private String title;
    private String overview;
    private String release;
    private String userscore;
    private String runtime;
    private String genre;
    private int poster;

    protected TvShow(Parcel in) {
        title = in.readString();
        overview = in.readString();
        release = in.readString();
        userscore = in.readString();
        runtime = in.readString();
        genre = in.readString();
        poster = in.readInt();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    public TvShow() {

    }

    public String getUserscore() {
        return userscore;
    }

    public void setUserscore(String userscore) {
        this.userscore = userscore;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(overview);
        parcel.writeString(release);
        parcel.writeString(userscore);
        parcel.writeString(runtime);
        parcel.writeString(genre);
        parcel.writeInt(poster);
    }
}
