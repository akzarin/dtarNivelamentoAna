package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ArquivosUtils {
    public static String getPropriedade(String propriedade) throws IOException {

        Properties propriedades = new Properties();
        propriedades.load(new FileInputStream("src/main/resources/application.properties"));
       return propriedades.getProperty(propriedade);

    }
}

//serve como se fosse uma 'função'

//ArquivosUtils.getPropriedade("propriedade do application.properties"));

//um método estatico não precisa de 'new'; não pode ser referenciado (ou seja, nao pode usar o this.)
