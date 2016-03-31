package model.gamelog;

import com.google.gson.annotations.Expose;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yongpinggao on 3/25/16.
 */
public class Log {

    @Expose
    private String currentTime;
    @Expose
    private String content;
    @Expose
    private LogType logType;
    @Expose
    private int id;
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public Log(LogType logType, String content) {
        this.currentTime = dateFormat.format(new Date());
        this.content = content;
        this.logType = logType;
    }

    public Log(LogType logType, int id, String content) {
        this.currentTime = dateFormat.format(new Date());
        this.content = content;
        this.logType = logType;
        this.id = id;
    }

    public LogType getLogType() {
        return logType;
    }

    public int getId() {
        return id;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "[" + currentTime + "]" + " : " + content + "\n";
    }

}
