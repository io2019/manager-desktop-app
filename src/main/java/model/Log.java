package model;

import java.sql.Timestamp;
import java.util.List;

public class Log {
    private long managerId;
    private String type;
    private Timestamp timestamp;
    private boolean result;
    private List<String> params;

    public Log(long managerId, String type, Timestamp timestamp, boolean result, List<String> params) {
        this.managerId = managerId;
        this.type = type;
        this.timestamp = timestamp;
        this.result = result;
        this.params = params;
    }

    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
