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
```
sudo add-apt-repository ppa:webupd8team/java
aptitude update
aptitude search oracle
aptitude install oracle-java8-installer oracle-java7-installer
```

## Compilation
```
javac HelloWorld.java
javap -v HelloWorld.class 
java HelloWorld
java -classpath classes_dir HelloWorld
```

## Компиляция со сторонними классами (библиотеками)
```
java -classpath lib.jar HelloWorld.java
java -classpath lib.jar:hw.jar HelloWorld
```

## JAR
### Упаковка
```
jar cfe hw.jar HelloWorld HelloWorld.class
```

### Просмотреть содержимое архива без распаковки
```
jar tf hw.jar
```

### Распаковка архива
```
jar xf hw.jar
```

## Запуск
### Запуск программы, если прописан главный класс
```
java -jar hw.jar
```
### Else:
```
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
```
System.out.println(variable.getClass().getName());
```

## Классы-обёртки (wrapper classes)
```
int primitive = 0
// boxing
Integer reference = Integer.valueOf(primitive);
// unboxing
int backToPrimitive = reference.intValue();
```

## Конвертация в строку и обратно
```
long fromString = Long parseLong("12345");
String fromLong = Long.toString(12345);
String concatenation = "area" + 51;
```

![](https://ucarecdn.com/89855d97-d6ad-4a79-bffa-7786d8eae311/)

## Simple way to print a Java array
```
String[] array = new String[] {"John", "Mary", "Bob"};
System.out.println(Arrays.toString(array));
```

# Arrays
## Varargs
```
static int maxArray(int[] numbers) { ... };
maxArray(new int[] {1, 2, 3});

static int maxVarargs(int... numbers) { ... };
maxVarargs(1, 2, 3);
```

## Array equals
```
import java.util.Arrays;

int[] a = {1, 2, 3};
int[] b = {4, 5, 6};
boolean equals = Arrays.equals(a, b);
boolean equals = Arrays.deepEquals(a, b);
```

## Print Array
```
int[] a = {1, 2, 3};
System.out.println(Arrays.toString(a));
System.out.println(Arrays.deepToString(a));
```

# Strings
```
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
```
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
```
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
