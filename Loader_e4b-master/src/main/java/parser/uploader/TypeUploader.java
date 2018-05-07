package parser.uploader;

import dbupdate.InsertT;
import model.Type;

import java.util.List;

public class TypeUploader implements ClassAppend{
    @Override
    public void addMethod(List<String> toAdd){
        for(String line : toAdd) {
            String[] tipo = line.split(",");
            crearTipo(tipo);
        }
    }

    private Type crearTipo(String[] tipo) {
        Type type = new Type(Integer.valueOf(tipo[0]), tipo[1]);
        new InsertT().save(type);
        return type;
    }

}
