package com.yond.multiThreadedDesign.p12_activeObject.sample;

import com.yond.multiThreadedDesign.p12_activeObject.sample.activeobject.ActiveObject;
import com.yond.multiThreadedDesign.p12_activeObject.sample.activeobject.ActiveObjectFactory;

public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread("Alice", activeObject).start();
        new MakerClientThread("Bobby", activeObject).start();
        new DisplayClientThread("Chris", activeObject).start();
    }
}
