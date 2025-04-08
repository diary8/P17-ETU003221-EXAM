package com.itu.Servlet;

import java.util.List;
import java.util.Vector;

public abstract class BaseObject {
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public abstract void save() throws Exception;
    public abstract void update(int id, String str) throws Exception;
    public abstract BaseObject getById(int id) throws Exception;
    public abstract Vector<BaseObject> findAll() throws Exception;
    public abstract void remove(int id) throws Exception;

    
}
