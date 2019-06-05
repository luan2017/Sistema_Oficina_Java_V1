package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistênciaArquivo {

    public static void salvar(Object raizObject, String arquivo) {
        if (raizObject == null) {
            return;
        }
        try {
            ObjectOutputStream saídaObjectOutputStream
                    = new ObjectOutputStream(new FileOutputStream(arquivo));
            saídaObjectOutputStream.writeObject(raizObject);
            saídaObjectOutputStream.close();
        } catch (Exception exceção) {
            System.out.println("Falha ao salvar no arquivo: " + arquivo + "\n");
        }
    }

    public static Object recuperar(String arquivo) {
        try {
            ObjectInputStream entradaObjectInputStream
                    = new ObjectInputStream(new FileInputStream(arquivo));
            Object raizObject = entradaObjectInputStream.readObject();
            return raizObject;
        } catch (Exception exceção) {
            System.out.println("Falha na recuperação do arquivo: " + arquivo + "\n");
            return null;
        }
    }

}
