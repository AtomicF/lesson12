package ru.innopolis.metaspace;

import javassist.ClassPool;

/**
 * Программа демонстрирующая утечку памяти
 * Для тестирования целесообразно ограничить размер metaspace в конфигурации VM
 * при помощи команды -XX:MaxMetaspaceSize=512m.
 */
public class Main {
    public static void main(String args[]) throws Exception{

        ClassPool classPool = ClassPool.getDefault();
        int i = 0;
        while (true) {
            Class c = classPool.makeClass("MyObject" + i).toClass();
            i++;
        }
    }
}