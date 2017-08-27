```
                                     ____.                    
                                    |    |____ ___  _______   
                                    |    \__  \\  \/ /\__  \  
                                /\__|    |/ __ \\   /  / __ \_
                                \________(____  /\_/  (____  /
                                              \/           \/ 
  ``` 
  
# Java

## Install Java
```bash
sudo add-apt-repository ppa:webupd8team/java
aptitude update
aptitude search oracle
aptitude install oracle-java8-installer oracle-java7-installer
```

## Compilation
```bash
javac HelloWorld.java
javap -v HelloWorld.class 
java HelloWorld
java -classpath classes_dir HelloWorld
```

## Компиляция со сторонними классами (библиотеками)
```bash
java -classpath lib.jar HelloWorld.java
java -classpath lib.jar:hw.jar HelloWorld
```

## JAR
### Упаковка
```bash
jar cfe hw.jar HelloWorld HelloWorld.class
```

### Просмотреть содержимое архива без распаковки
```bash
jar tf hw.jar
```

### Распаковка архива
```bash
jar xf hw.jar
```

## Запуск
### Запуск программы, если прописан главный класс
```bash
java -jar hw.jar
```
### Else:
```bash
java -classpath hw.jar HelloWorld
```

## Codestyle
Более подробно о рекомендуемом стиле кода можно почитать здесь:
* Старый документ [Code Conventions for the Java Programming Language](http://www.oracle.com/technetwork/java/javase/documentation/codeconvtoc-136057.html)
* Черновик нового документа [Java Style Guidelines](http://cr.openjdk.java.net/~alundblad/styleguide/index-v6.html)
* Статья на русском [Рекомендации к стилю кода](https://habrahabr.ru/post/112042/)

## Assembly:
#### Ant - build.xml
#### Gradle - build.gradle
#### Maven - pom.xml

## Print type
```java
System.out.println(variable.getClass().getName());
```

## Классы-обёртки (wrapper classes)
```java
int primitive = 0
// boxing
Integer reference = Integer.valueOf(primitive);
// unboxing
int backToPrimitive = reference.intValue();
```

## Конвертация в строку и обратно
```java
long fromString = Long parseLong("12345");
String fromLong = Long.toString(12345);
String concatenation = "area" + 51;
```

![](https://ucarecdn.com/89855d97-d6ad-4a79-bffa-7786d8eae311/)

## Simple way to print a Java array
```java
String[] array = new String[] {"John", "Mary", "Bob"};
System.out.println(Arrays.toString(array));
```

# Arrays
## Varargs
```java
static int maxArray(int[] numbers) { ... };
maxArray(new int[] {1, 2, 3});

static int maxVarargs(int... numbers) { ... };
maxVarargs(1, 2, 3);
```

## Array equals
```java
import java.util.Arrays;

int[] a = {1, 2, 3};
int[] b = {4, 5, 6};
boolean equals = Arrays.equals(a, b);
boolean equals = Arrays.deepEquals(a, b);
```

## Print Array
```java
int[] a = {1, 2, 3};
System.out.println(Arrays.toString(a));
System.out.println(Arrays.deepToString(a));
```

# Strings
```java
char[] charArray = {'a', 'b', 'c'};
String string = new String(charArray);
char[] charFromString = string.toCharArray();

String s = "stringIsImmutable";
int length = s.length();
char firstChar = s.charAt(0);

boolean endsWithTable = s.endsWith("table");
booalen containsIs = s.contains("Is");
String substr = s.substring(0, 6);

String afterReplace = s.replace("Imm", "M");
String allCapitals = s.toUpperCase();
boolean equal2 = s1.equalsIgnoreCase(s2);
```
## If-Else
```java
class IfElseDemo {
    public static void main(String[] args) {

        int testscore = 76;
        char grade;

        if (testscore >= 90) {
            grade = 'A';
        } else if (testscore >= 80) {
            grade = 'B';
        } else if (testscore >= 70) {
            grade = 'C';
        } else if (testscore >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Grade = " + grade);
    }
}
```

# Ternary operator
```java
if (weatherIsGood) {
    System.out.println("Wheater is good");
} else {
    System.out.println("Wheater is bad");
}

// same effect, but much shorter
System.out.println("Wheater is "
        + (wheaterIsGood ? "good" : "bad"));
```

# Switch
```java
switch (digit) {
    case 0: 
        text = "zero";
        break;
        
    case 1:
        text = "one";
        break;
        
    // ...
    
    default:
        text = "???";
        
}
```

# Circles
## Do while
```java
do {
    goShopping();
} while (haveTime() && haveMoney());
```

## Foreach
```java
for (String arg : args) {
    System.out.printls(arg);
}
```

# OOP
## Classes
```java
// Друг за другом может быть объявлено несколько классов, 
//                                      но только один из них может быть public
// Его имя должно соответствовать имени файла

public final class Integer {
// Ключевое слово final означает что от класса нельзя наследоваться
}
```

## Fields (variables of classes)
```java
public final class Integer {
    // final - означает что значение полю можно присвоить только один раз
    // Мб также применён к методам и локальным переменным
    private final int value;

    // Явное присвоение значения полю можно сделать 
    //                                   прямо в объявлении поля или в конструкторе
    private final int zero_value = 0;  // 0, null, false в зависимости от типа поля
    
    public Integer(int value) {
        this.zero_value = zero_value;
    // Компилятор проверит, что к моменту выхода из конструктора  
    //                                    значение полю будет обязательно присвоено
    // Иначе - ошибка компиляции
    }

    
}
```

## Constructors
```java
// Констуктор - метод, вызываемый при создании класса
// Например, когда кто-то в программе применяет оператор new (new Integer(33))

// Задача конструктора - инициализировать состояние объекта 
//                                           и подготовить его к использованию
package java.lang;

// Когда в классе не объявлен ни один конструктор, 
//               то неявно создаётся конструктор по умолчанию (без параметров)
// Т.е. даже когда у класса нет конструкторов, 
//                        его экземпляр можно создать при помощи оператора new

public final class Integer {
    
    private final int value;
    
    // Объявление конструктора состоит из модификатора доступа и имени класса
    // Конструктор может принимать параметры
    public Integer(int value){
        // Если параметр конструктора принимает такой же параметр как имя класса, 
        //                то для доступа к полю класса используется префикс this
        // this - это ссылка на текущий экземпляр, 
        //        в контексте которого выполняется текущий конструктор или метод
        // Обычно писать this не нужно, но в случае конфликта имён 
        //                                поля и локальных параметров необходимо
        this.value = value;
    }
    
    // ...
}
```
```java
package java.math;

public final class Math {

    // Если нужно запретить создание экземпляров класса, 
    //                                   то нужно сделать конструктор приватным
    /**
     * Don't let anyone instantiate this class.
     */
    private Math() {}

    // ...
}
```
```java
package java.math;

public class BigInteger {
    
    // В классе может быть несколько 
    //         перегруженных версий конструкторов с разными наборами параметров
    public BigInteger(String val){
        // Из одного конструктора можно вызывать другой
        this.(val, 10);  // defaul value
    }
    
    public BigInteger(String val, int radix){
        // ...
    }

}
```
## Methods
```java
package java.lang;

public final class Integer {

    private final int value;

    // Объявление метода состоит из модификатора доступа, 
    //                          типа возвращаемого значения, имени и параметров

    // Метод может иметь модификатор final,
    //   тогда данный метод не может быть переопределён в классах наследниках
    // Если класс уже объявлен как final, то расставлять на методах избыточно
    public int intValue() {
        // Метод исполняется в контексте текущего экземпляра класса, 
        //              поэтому он может обращаться к полям объекта
        return value;
    }

    // ...
}
```
```java
// Поля и методы могут быть статическими (с модификатором static)
// В каждой программе присутствует хотя бы он статический метод - метод main()

// Статические поля и методы существуют независимо от экземпляров класса
// и могут вызываться просто по имени класса (например, Integer.rotateRight(5, 7))

// Статический метод исполняется в контексте класса, а не конкретного экземпляра,
// поэтому он не имеет доступа к this и нестатическим полям и методам

package java.lang;

public final class Integer {

    // В комбинации с final, static используется для объявления констант
    // Имена констант принято записывать в верхнем регистре, 
    //                                    разделяя слова подчёркиваниями
    public static final int MIN_VALUE = 0x80000000;

    public static int rotateRight(int i, int distance) {
        return (i >>> distance) | (i << -distance);
    }

    // ...
}

```

## Nested Classes
```java
package java.util;

// ArrayList - коллекция, контейнер для однотипных элементов
//              в отличие от массива может динамически изменять свой размер
public class ArrayList<E> {

    Object[] elementData;

    // Когда необходимо обойти и обработать все элементы коллекции, 
    //                                        используется итератор 
    //     (объект, по очереди возвращающий все элементы коллекции)
    // Итератор должен помнить текущую коллекцию, 
    //                     которую он обходит (чтобы получать её элементы),
    //                                       а также текущую позицию обхода
    public Iterator<E> iterator() {
        return new Itr();
    }

    // Каждый экземпляр итератора будет иметь собственное состояние, 
    //                                       хранящееся в его полях, 
    //          а также неявную ссылку на экземпляр внешнего класса
    // То есть из кода итератора можно будет напрямую обращаться 
    //     к полям экземпляра ArrayList, в том числе к приватным
    private class Itr implements Iterator<E> {
        int cursor;
        // ...
    }

    // ...
}
```
```java
package java.util;

public class Collections {

    public static final List EMPTY_LIST = new EmptyList<>();

    public static final <T> List<T> emptyList() {
        return (List<T>) EMPTY_LIST;
    }

    // Если вложенный класс снабжён модификатором static,
    //                           то неявная связь с внешним классом теряется
    // Экземпляры вложенного класса будут независимы

    // При этом размещение одного класса внутри другого мотивируется:
    // - либо желанием скрыть вложенный класс, сделав его приватным
    // - либо тесной логической связью внешнего и вложенных классов, 
    //               требующий доступа к приватным полям друг друга
    private static class EmptyList<E> {
        //...
    }
}
```

## Enums
```java
package java.time;

// Перечисления - это полноценный ссылочный тип
// Его можно воспринимать как класс с фиксированным количеством экземпляров
// Перечисленные в enum значения эквиваленты public static final полям класса
public enum DayOfWeek {
    MONDAY,  // <- public static final
    TUESDAY,
    WEDNESDAY,
    THURSDAY(args),
    FRIDAY,
    SATURDAY,
    SUNDAY;
    
    // fields, methods
    // В перечислениях можно объявлять fields, methods как в обычном классе

    // Можно также объявить констуктор, в том числе принимающий параметры
    // Тогда в объявлении нужно описать эти параметры
}

// В любом перечислении доступны методы name(), ordinal(),
//                                      а также статический метод values()

// name - возвращает строку (имя элемента перечисления как в исходном коде)
// ordinal - порядковый номер элемента, начиная с 0 как в исходном коде
// values - массив возможных перечислений в том же порядке
for (DayOfWeek day : DayOfWeek.values()) {
    System.out.println(day.ordinal() + " " + day.name());
}
```

## Inheritance
```java
package java.lang;

// Наследоваться можно только от одного класса
// Унаследованный класс автоматически получает все поля и методы класса
// Пользоваться ими может как он сам, 
//        так и другие классы программы (с учётом модификаторов доступа)
// Иерархия наследования может быть произвольной глубины

// В класс наследника можно добавлять поля и методы, 
//                                    тем самым расширяя родительский класс
// Методы также можно переопределять 
//  (завести в классе наследника метод с такими же названием и параметрами, 
//                                                    как в базовом классе)
// Тип возвращаемого значения должен быть аналогичным 
//      или подтипом возвращаемого значения метода базового класса, а также 
//                модификатор доступа должен быть тем же или более открытым

public final class BigDecimal extends Number {

    public int intValue() {
        //...
    }

    // no shortValue() method,
    // it's inherited from Number

    // bd.intValue() bd.shortValue()
}
```

## Inheritance & Override
```java
package java.lang;

public final class StringBuilder
    extends AbstractStringBuilder {
    
    // Переопределение метода append, принимающего строку
    // Возвращаемый StringBuilder - подкласс AbstractStringBuilder
    // Иначе, если бы тип возвращаемого значения не совпал, 
    //                                   была бы ошибка компиляции
    // Сигнатуры методов не должны расходиться
    @Override
    public StringBuilder append(String str){
        // ...
    }
    
    // base method in AbstractStringBuilder:
    // AbstractStringBuilder append(String str)
}
```

## Super
```java
package java.lang;

// Создание экземпляра класса наследника всегда включает в себя 
//              инициализацию базового класса т.е. вызов его конструктора
// Когда у базового класса есть конструктор без параметров, то компилятор
//                              автоматически поставит его вызов в начало 
//                                    тела конструктора класса наследника
public final class StringBuilder
    extends AbstractStringBuilder {
    
    // Вызов конструктора с параметрами необходимо указывать явно
    public StringBuilder() {
        // Вызов конструктора суперкласса должен идти перед другим кодом,
        //                                     размещённым в конструкторе
        super(16);
    }
    
    @Override
    public StringBuilder append(String str) {
        // Вызов реализации из метода базового класса, 
        //                           несмотря на наличие переопределённой 
        //                                 версии метода в текущем классе
        super.append(str);
        // Использование ключевого слова super разрешено 
        //                                только в теле класса наследника
        // Поэтому из класса наследника всегда будет вызываться
        //                          только переопределённая версия метода
        return this;
    }
    
    // ...
}
```
## java.lang.Object
```java
package java.lang;

public final class String /*extends Object*/ {
    // ...
}
```

## Extends Object
- equals() - сравнение по содержимому (массивы все ещё сравниваются по ссылке)
- toString() - обычно java.lang.Object@35fe45
- hashCode() - для хранения объектов в хэш-таблицах вычисляет хэш-код объекта

```
Если два объекта равны с точки зрения equals, 
                                     то у них должны быть одинаковые хэш-коды
Поэтому либо переопределять и equals() и hashCode(), либо не переопределять вовсе
```
```
Модификатор native означает что реализация данного метода в нативном Сишном коде
```

## Override equals()
```java
package java.lang;

public final class String /*extends Object*/ {

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
     
        // instanceof - проверяет, является ли объект, находящийся по ссылке
        //                                 экземпляром класса или подклассом
        // null instanceof -> false
        if (anObject instanceof String) {
            String other = (String)anObject;
            // ...
        }
        return false;
    }
    // ...
}
```

## Read from console
```java
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int a = s.nextInt();
    int b = s.nextInt();
    System.out.println(a + b);
  }
}
```

## Modifiers
```java

// модификаторы protected и private не применимы к классам верхнего уровня
public class ModifiersDemo {
    // доступ отовсюду
    public static void visibleEverywhere() {}

    // доступ только для классов наследников и классов текущего пакета
    protected static void inSubclasses() {}

    // (отсутствие модификатора) доступ только в пределах пакета
    static void inPackage() {}

    // доступ только в пределах класса
    private void inClass() {}
}
```

## Abstract Class
```java
// Если класс объявлен как абстрактный, то нельзя создавать его экземпляры
// Создать можно только экземпляр класса наследника, не являющийся абстрактным

// В абстрактном классе могут быть методы без реализации (абстрактные)
// Все неабстрактные классы-наследники должны предоставить реализацию 
//                                                абстрактного метода
// Наличие неабстрактных методов в абстрактном классе 
//                                       приводит к ошибке компиляции

// Задачи, которые решают абстрактные классы:
// - определяют набор публичных методов
// - могут содержать непубличные поля и методы (детали реализации)

```
## Interface
```java
// Все методы интерфейса публичны и абстрактны
// Поля в интерфейсе могут быть только public static final (константы)
// Ничего непубличного объявить в интерфейсе нельзя
// Могут быть статические публичные методы (с Java8)
package org.stepic.java.orders;

import java.time.LocalDate;

public interface OrderService {
    Order[] getOrdersByClient(long clientId);
    
    // Чтобы при добавлении нового интерфейса не отъезжал код,
    // завязанный на старый, добавлена реализация default-методов
    // Order[] getOrdersByClient(long clientId, LocalDate date);
    
    default Order[] getOrdersByClient(
            long clientId, LocalDate date) {
        Order[] allOrders = getOrdersByClient(clientId);
        return Orders.filterByDate(allOrders, date);
    }
}
```

```java
// В Java можно объявлять классы, реализующие множество интерфейсов
// Реализуемые классом интерфейсы перечисляются после
//                  ключевого слова implements через запятую
// Класс может реализовывать интерфейсы 
//               вдобавление к наследованию от произвольного класса
public class OrderServiceImpl
       extends ServiceBase
       implements OrderService {

    public Order[] getOrdersByClient(long clientId) {
        // ...
    }
}

```
```java
package java.lang;

// Последовательность символов
public interface CharSequence {

    int length();  // длина последовательности
    char charAt(int index);  // запрос символа по индексу
    CharSequence subSequence(int start, int end);  // взятие подпоследовательности

// Реализации CharSequence -  String и StringBuilder
}
```
```java
package java.lang;

public interface Appendable {

    Appendable append(CharSequence csq);
    Appendable append(CharSequence csq, int start, int end);
    Appendable append(char c);
}
```
```java
package java.lang;
// Абстрактное нечто, которое можно запустить :)

// У функциональных интерфейсов единственный абстрактный метод
// Если добавить аннотацию, то компилятор это проверит
@FunctionalInterface
public interface Runnable {
    void run();
}
```
```java
package java.lang;
// Умеет сравнивать пары объектов и говорить, какое из них больше
// Если первый объект < второго, то возвращается отрицательное число
//                    ==                         0
//                    >                          положительное

@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);
}
```
```java
// Функциональные интерфейсы можно кратко описать в виде:
//   - лямбда-выражений
//   - ссылок на метод
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
```
## Exceptions
```java
// Исключения - события, которые случаются во время работы программы и 
//                             прерывают стандартный ход её выполнения
// Программа переход в режим поиска обработчика внештатной ситуации
// Такой обработчик может вернуть программу в штатное выполнение
// Если обработчика не нашлось, то JVM завершит программу, но
//                           обеспечит подробные логи падения
// Stack Trace - вся цепочка вызовов от входа в программу до падения

Object nullRef = null;
// java.lang.NullPointerException (NPE)
// Обращение по нулевой ссылке (JVM)
nullRef.toString();

int[] array = {1, 2, 3};
// java.lang.ArrayIndexOutOfBoundsException
// Обращение к несуществующим элементам массива
array[10];

// StringIOOBE при обращении к несуществующему символу в строке

// java.io.FileNotFoundException
new FileInputStream("not_existing_file");
// Является подклассом более общего IOException
// Его экземпляры бросаются при ошибках ввода-вывода

// Когда JVM не хватает памяти на создание нового объекта,
//                           она бросает исключение типа OutOfMemoryError
// Его можно обработать, но лучше этого не делать, 
//    т.к. предпринять что-то разумное в данной ситуации проблематично :)
```
```java
// Исключение в Java - это объект, экземпляр какого-то класса, который
// наследуется от java.lang.Throwable, который наследуется от Object
// Ключевое св-во экземпляров java.lang.Throwable - возможность быть брошенными

// Бросание - ключевое слово throw и объект типа Throwable
// Stack Trace определяется тем где был создан экземпляр исключения,
//                                  а не тем, где оно было выброшено
throw new IllegalStateException(
"Invalid user. " +
"Please replace user and continue.");
```
```java
// Exception Classification:
//   Исключительные ситуации в JVM
     java.lang.Error

//   Исключительные ситуации в пользовательском коде
//       Проверяемые (checked)
         java.lang.Exception

//       Непроверяемые (unchecked)
         java.lang.RuntimeException


// Er -> Th
// Re -> Ex -> Th
```
```java
java.lang.Error

java.lang.OutOfMemoryError
java.lang.NoClassDefFoundError
java.lang.VerifyError  // что-то не так с байт-кодом
// JVM плохо, но не настолько чтобы умереть
// Такие исключения не надо обрабатывать, помочь JVM уже ничем не получится
```
```java
// Exception и RuntimeException - ошибки уровня программы
// Некорректные параметры, некорректные состояния, недопустимые действия
// Можно пытаться обрабатывать :)

// За Exception следит компилятор, 
//                       например, следующий код не скомпилится:
import java.io.IOException;
public class ExceptionDemo {
    public void someMethod() {
        // ...
        throw new IOException("Failed to read file");
        // ...
    }
}

// Для компиляции в этом же методе должен быть обработчик
//      данного исключения, либо на методе должно быть явно написано
//                            что из него может вылетать IOException 
//         (нужно вешать throws на все методы, вызывающие наш метод)
// Таким образом, компилятор обеспечивает, что в сигнатуре метода 
// видны все проверяемые исключения, которые могут из него вылетать
// Их может быть несколько (через запятую)
import java.io.IOException;
public class ExceptionDemo {
    public void someMethod() throws IOException {
        // ...
        throw new IOException("Failed to read file");
        // ...
    }
}
```
```java
java.lang.RuntimeException
// Такие исключения могут вылететь в любой части программы

java.lang.NullPointerException
java.lang.ArrayIndexOutOfBoundsException
java.lang.ArithmeticException  // деление на ноль
```
### Собственное исключение
```java
public class CalculatorException extends RuntimeException {

    public CalculatorException(String message) {
        super(message);
    }

    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }
}
```
```java
public class CalculatorImpl implements Calculator {

    @Override
    public double calculate(String expr) {
        // ...
        throw new CalculatorException("Unsupported operator found");
        // ...
    }
}
```
## Try-Catch
```java
for (;;) {
    System.out.print("Enter expression: ");
    String expr = readUserInput();
    if (expr == null || "exit".equalsIgnoreCase(expr)) {
        break;
    }
    try {
        double result = calculator.calculate(expr);
        System.out.println("Result: " + result);
    } catch (CalculatorException e) {
        System.out.print("Bad expression: " + e.getMessage());
        System.out.print("Please try again: ");
    }
}
```
