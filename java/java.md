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
## Constructors
```java
package java.lang;

public final class Integer {
    
    private final int value;
    
    public Integer(int value){
        this.value = value;
    }
    
    // ...
}
```
```java
package java.math;

public class BigInteger {
    
    public BigInteger(String val){
        this.(val, 10);  // defaul value
    }
    
    public BigInteger(String val, int radix){
        // ...
    }

}
```

## Enums
```java
package java.time;

public enum DayOfWeek {
    MONDAY,  // <- public static final
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    
    // fields, methods
}

for (DayOfWeek day : DayOfWeek.values()) {
    System.out.println(day.ordinal() + " " + day.name());
}
```

## Inheritance & Override
```java
package java.lang;

public final class StringBuilder
    extends AbstractStringBuilder {
    
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

public final class StringBuilder
    extends AbstractStringBuilder {
    
    public StringBuilder() {
        super(16);
    }
    
    @Override
    public StringBuilder append(String str) {
        super.append(str);
        return this;
    }
    
    // ...
}
```

## Extends Object
- equals()
- toString()
- hashCode()

## Override equals()
```java
package java.lang;

public final class String /*extends Object*/ {

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String other = (String)anObject;
            // ...
        }
        return false;
    }
    // ...
}
```

## Interface
```java
package org.stepic.java.orders;

import java.time.LocalDate;

public interface OrderService {
    Order[] getOrdersByClient(long clientId);
    
    // Order[] getOrdersByClient(long clientId, LocalDate date);
    
    default Order[] getOrdersByClient(
            long clientId, LocalDate date) {
        Order[] allOrders = getOrdersByClient(clientId);
        return Orders.filterByDate(allOrders, date);
    }
}
```
