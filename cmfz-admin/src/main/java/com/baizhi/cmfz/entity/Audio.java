package com.baizhi.cmfz.entity;
import java.io.Serializable;

/**
 * @Description 音频实体类
 * Created by huanglei on 2018/7/3.
 */
public class Audio implements Serializable {
    private String audioid;
    private String audioname;
    private String audiosinger;
    private String audiocompose;
    private String audioarrangement;
    private String audioproducer;
    private String audiosize;
    private String audioadd;
    private String albumid;
    private Integer audiocount;

    public Audio() {
    }

    public Audio(String audioid, String audioname, String audiosinger, String audiocompose, String audioarrangement, String audioproducer, String audiosize, String audioadd, String albumid, Integer audiocount) {
        this.audioid = audioid;
        this.audioname = audioname;
        this.audiosinger = audiosinger;
        this.audiocompose = audiocompose;
        this.audioarrangement = audioarrangement;
        this.audioproducer = audioproducer;
        this.audiosize = audiosize;
        this.audioadd = audioadd;
        this.albumid = albumid;
        this.audiocount = audiocount;
    }

    public String getAudioid() {
        return audioid;
    }

    public void setAudioid(String audioid) {
        this.audioid = audioid;
    }

    public String getAudioname() {
        return audioname;
    }

    public void setAudioname(String audioname) {
        this.audioname = audioname;
    }

    public String getAudiosinger() {
        return audiosinger;
    }

    public void setAudiosinger(String audiosinger) {
        this.audiosinger = audiosinger;
    }

    public String getAudiocompose() {
        return audiocompose;
    }

    public void setAudiocompose(String audiocompose) {
        this.audiocompose = audiocompose;
    }

    public String getAudioarrangement() {
        return audioarrangement;
    }

    public void setAudioarrangement(String audioarrangement) {
        this.audioarrangement = audioarrangement;
    }

    public String getAudioproducer() {
        return audioproducer;
    }

    public void setAudioproducer(String audioproducer) {
        this.audioproducer = audioproducer;
    }

    public String getAudiosize() {
        return audiosize;
    }

    public void setAudiosize(String audiosize) {
        this.audiosize = audiosize;
    }

    public String getAudioadd() {
        return audioadd;
    }

    public void setAudioadd(String audioadd) {
        this.audioadd = audioadd;
    }

    public String getAlbumid() {
        return albumid;
    }

    public void setAlbumid(String albumid) {
        this.albumid = albumid;
    }

    public Integer getAudiocount() {
        return audiocount;
    }

    public void setAudiocount(Integer audiocount) {
        this.audiocount = audiocount;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "audioid='" + audioid + '\'' +
                ", audioname='" + audioname + '\'' +
                ", audiosinger='" + audiosinger + '\'' +
                ", audiocompose='" + audiocompose + '\'' +
                ", audioarrangement='" + audioarrangement + '\'' +
                ", audioproducer='" + audioproducer + '\'' +
                ", audiosize='" + audiosize + '\'' +
                ", audioadd='" + audioadd + '\'' +
                ", albumid='" + albumid + '\'' +
                ", audiocount=" + audiocount +
                '}';
    }
}
