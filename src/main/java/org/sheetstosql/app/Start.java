package org.sheetstosql.app;

import org.sheetstosql.app.GUI.FileSelection;

public class Start {

    Boolean terminalRun = false;
    String filePath;

    String tableName;
    public void StartApp(String[] args){
        handleArgs(args);
        if(!terminalRun){
            new FileSelection();
        }
        else{
            // TODO add no gui file processing
        }
    }
    public void handleArgs(String[] args){
        if(args.length > 0) {
            if (args[0].equals("noGui")){
                this.terminalRun = true;
                this.filePath = args[1];
                this.tableName = args[2];
            }
        }
    }
}
