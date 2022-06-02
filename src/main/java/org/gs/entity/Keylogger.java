package org.gs.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Entity
@Getter
@Setter
@ToString
public class Keylogger extends PanacheEntity {

    private String data;

    public void translitor(String path, int inc) {
        try (FileReader reader = new FileReader(path);
             FileWriter writer = new FileWriter("D:\\translit\\" + inc + ".log")) {
            int c;
            while (reader.ready()) {
                c = reader.read();
                switch ((char) c) {
                    case 'a':
                        c = 'ф';
                        break;
                    case 'A':
                        c = 'Ф';
                        break;
                    case 'b':
                        c = 'и';
                        break;
                    case 'B':
                        c = 'И';
                        break;
                    case 'c':
                        c = 'с';
                        break;
                    case 'C':
                        c = 'С';
                        break;
                    case 'd':
                        c = 'в';
                        break;
                    case 'D':
                        c = 'В';
                        break;
                    case 'e':
                        c = 'у';
                        break;
                    case 'E':
                        c = 'У';
                        break;
                    case 'f':
                        c = 'а';
                        break;
                    case 'F':
                        c = 'А';
                        break;
                    case 'g':
                        c = 'п';
                        break;
                    case 'G':
                        c = 'П';
                        break;
                    case 'h':
                        c = 'р';
                        break;
                    case 'H':
                        c = 'Р';
                        break;
                    case 'i':
                        c = 'ш';
                        break;
                    case 'I':
                        c = 'Ш';
                        break;
                    case 'j':
                        c = 'о';
                        break;
                    case 'J':
                        c = 'О';
                        break;
                    case 'k':
                        c = 'л';
                        break;
                    case 'K':
                        c = 'Л';
                        break;
                    case 'l':
                        c = 'д';
                        break;
                    case 'L':
                        c = 'Д';
                        break;
                    case 'm':
                        c = 'ь';
                        break;
                    case 'M':
                        c = 'ь';
                        break;
                    case 'n':
                        c = 'т';
                        break;
                    case 'N':
                        c = 'Т';
                        break;
                    case 'o':
                        c = 'щ';
                        break;
                    case 'O':
                        c = 'Щ';
                        break;
                    case 'p':
                        c = 'з';
                        break;
                    case 'P':
                        c = 'З';
                        break;
                    case 'r':
                        c = 'к';
                        break;
                    case 'R':
                        c = 'К';
                        break;
                    case 's':
                        c = 'ы';
                        break;
                    case 'S':
                        c = 'Ы';
                        break;
                    case 't':
                        c = 'е';
                        break;
                    case 'T':
                        c = 'Е';
                        break;
                    case 'u':
                        c = 'г';
                        break;
                    case 'U':
                        c = 'Г';
                        break;
                    case 'v':
                        c = 'м';
                        break;
                    case 'V':
                        c = 'М';
                        break;
                    case 'w':
                        c = 'ц';
                        break;
                    case 'W':
                        c = 'Ц';
                        break;
                    case 'x':
                        c = 'ч';
                        break;
                    case 'X':
                        c = 'Ч';
                        break;
                    case 'y':
                        c = 'н';
                        break;
                    case 'Y':
                        c = 'Н';
                        break;
                    case 'z':
                        c = 'я';
                        break;
                    case 'Z':
                        c = 'Я';
                        break;
                    case '{':
                        c = 'х';
                        break;
                    case '[':
                        c = 'х';
                        break;
                    case '}':
                        c = 'ъ';
                        break;
                    case ':':
                        c = 'Ж';
                        break;
                    case ';':
                        c = 'ж';
                        break;
                    case '\'':
                        c = 'э';
                        break;
                    case ',':
                        c = 'б';
                        break;
                    case '.':
                        c = 'ю';
                        break;
                    default:
                        break;
                }
                writer.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
