package com.songyang.small.homework_two.data.entity;

import java.util.List;

public class Result {
    private List<Rxxp> rxxp;

    private List<Rxxp> pzsh;

    private List<Rxxp> mlss;

    public void setRxxp(List<Rxxp> rxxp) {
        this.rxxp = rxxp;
    }

    public List<Rxxp> getRxxp() {
        return this.rxxp;
    }

    public void setPzsh(List<Rxxp> pzsh) {
        this.pzsh = pzsh;
    }

    public List<Rxxp> getPzsh() {
        return this.pzsh;
    }

    public void setMlss(List<Rxxp> mlss) {
        this.mlss = mlss;
    }

    public List<Rxxp> getMlss() {
        return this.mlss;
    }

}