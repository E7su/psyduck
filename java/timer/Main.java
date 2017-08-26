package timer;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Timer timer = new Timer();
        long time = timer.measureTime(new BigDecimalPower());
        System.out.println(time);
    }
    
    private static class BigDecimalPower implements Runnable {
    
        @Override
        public void run() { 
            new BigDecimal("1234567").pow(100000); 
        }
    }
}

// ===========================================================
package timer;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Timer timer = new Timer();
        // Объявление класса внутри метода measureTime
        // Объявляется анонимный класс, реализующий интерфейс Runnable
        //                                   и создаётся его экземпляр
        long time = timer.measureTime(new Runnable() {
    
            @Override
            public void run() { 
                new BigDecimal("1234567").pow(100000); 
            }
        });
        System.out.println(time);
    }
}

// ===========================================================
package timer;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Timer timer = new Timer();
        // Java8 - magic!
        // Лямбда-выражение
        // Начинается с круглых скобок, в которых указываются параметры
        // В данном случае метод run() не предполагает никаких параметров
        // Параметры указываются без типов, т.к. они известны компилятору
        //                                        из объявения интерфейса
        // После стрелочки идёт тело лямбда-выражения
        // В нашем случае одна строка, если нужно больше, 
        //                                       то нужны фигурные скобки 
        long time = timer.measureTime(() -> new BigDecimal("1234567").pow(100000)); 
        // Такое выражение порождает объект, реализующий интерфейс Runnable
        //                                   с указанным телом метода run()
        // Лямбдой можно заменить только реализацию функционального интерфейса
        System.out.println(time);
    }
}

// ===========================================================
package timer;

import java.math.BigDecimal;

public class Main {
// Получение экземпляра интерфейса при помощи ссылки на метод с подходящей сигнатурой
    public static void main(String[] args) {
        Timer timer = new Timer();
        // Ссылка на метод состоит из имени класса или переменной (Main),
        // двух двоеточий и имени метода (bigDecimalPower)
        long time = timer.measureTime(Main::bigDecimalPower);
        System.out.println(time);
    }
    
    // Значением выражения является объект, реализующий функциональный интерфейс 
    //                        и вызывающий код при вызове своего главного метода 
    private static void bigDecimalPower() {
        new BigDecimal("1234567").pow(100000);
    }
}
