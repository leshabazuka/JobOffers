package org.example.pageobject.page;

import org.example.core.Driver;

public class App {
    public ProtocolItPage protocolItPage = new ProtocolItPage(Driver.getDriver());

    private static App app;

    private App(){
    }

    public static App getApp(){
        if (app==null){
            app = new App();
        }
        return app;
    }
}
