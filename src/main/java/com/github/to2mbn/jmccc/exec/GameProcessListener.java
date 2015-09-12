package com.github.to2mbn.jmccc.exec;

public interface GameProcessListener {
    void onLog(String log);
    void onErrorLog(String log);
    void onExit(int code);
}