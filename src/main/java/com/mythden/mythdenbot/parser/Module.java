package com.mythden.mythdenbot.miniGames.Parser;

import java.util.ArrayList;
import java.util.List;

abstract class Module implements Cloneable {
    private boolean init;

    public List<String> args = new ArrayList<>();

    public void addArgs(String objectArgs) throws Exception {
        if(!init) throw new Exception("Module object not created via create()");
        this.args.add(objectArgs);
    }

    public void addArgs2(String objectArgs) throws Exception {
        if(!init) throw new Exception("Module object not created via create()");
        this.args.add(objectArgs);
    }

    private void flush() {
        this.args.clear();
    }

    public Object invoke() {
        Object product = produce();
        this.flush();
        return product;
    }

    protected abstract Object produce();
    abstract int params();

    public Module create() {
        try {
            Module module = (Module) super.clone();
            module.init = true;
            return module;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}