```
                                         ____.                    
                                        |    |____ ___  _______   
                                        |    \__  \\  \/ /\__  \  
                                    /\__|    |/ __ \\   /  / __ \_
                                    \________(____  /\_/  (____  /
                                                  \/           \/ 
  ```
# Java
```
javac HelloWorld.java
javap -v HelloWorld.class 
java HelloWorld
java -classpath classes_dir HelloWorld
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

# Запуск
## Запуск программы, если прописан главный класс
```
java -jar hw.jar
```
## Else:
```
java -classpath hw.jar HelloWorld
```

# Компиляция
## Компиляция со сторонними классами (библиотеками)
```
java -classpath lib.jar HelloWorld.java
java -classpath lib.jar:hw.jar HelloWorld
```
# Codestyle
Более подробно о рекомендуемом стиле кода можно почитать здесь:
* Старый документ [Code Conventions for the Java Programming Language](http://www.oracle.com/technetwork/java/javase/documentation/codeconvtoc-136057.html)
* Черновик нового документа [Java Style Guidelines](http://cr.openjdk.java.net/~alundblad/styleguide/index-v6.html)

# Assembly:
#### Ant - build.xml
#### Gradle - build.gradle
#### Maven - pom.xml


# Классы-обёртки (wrapper classes)
```
int primitive = 0
// boxing
Integer reference = Integer.valueOf(primitive);
// unboxing
int backToPrimitive = reference.intValue();
```

# Конвертация в строку и обратно
```
long fromString = Long parseLong("12345");
String fromLong = Long.toString(12345);
String concatenation = "area" + 51;
```

![](https://ucarecdn.com/89855d97-d6ad-4a79-bffa-7786d8eae311/)
