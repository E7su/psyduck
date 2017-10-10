## Install virtualenv on python2
```
python2 -m pip install virtualenv
virtualenv --python=/usr/bin/python2.6 venv
```

## Activate venv
```
source venv/bin/activate
```
## Install requirements
```
pip install -r requirements.txt
```

## Run autotests
```
python -m pytest -v tests/test_generator.py
```

## Exception hierarchy
```
BaseException
 +-- SystemExit
 +-- KeyboardInterrupt
 +-- GeneratorExit
 +-- Exception
      +-- StopIteration
      +-- StandardError
      |    +-- BufferError
      |    +-- ArithmeticError
      |    |    +-- FloatingPointError
      |    |    +-- OverflowError
      |    |    +-- ZeroDivisionError
      |    +-- AssertionError
      |    +-- AttributeError
      |    +-- EnvironmentError
      |    |    +-- IOError
      |    |    +-- OSError
      |    |         +-- WindowsError (Windows)
      |    |         +-- VMSError (VMS)
      |    +-- EOFError
      |    +-- ImportError
      |    +-- LookupError
      |    |    +-- IndexError
      |    |    +-- KeyError
      |    +-- MemoryError
      |    +-- NameError
      |    |    +-- UnboundLocalError
      |    +-- ReferenceError
      |    +-- RuntimeError
      |    |    +-- NotImplementedError
      |    +-- SyntaxError
      |    |    +-- IndentationError
      |    |         +-- TabError
      |    +-- SystemError
      |    +-- TypeError
      |    +-- ValueError
      |         +-- UnicodeError
      |              +-- UnicodeDecodeError
      |              +-- UnicodeEncodeError
      |              +-- UnicodeTranslateError
      +-- Warning
           +-- DeprecationWarning
           +-- PendingDeprecationWarning
           +-- RuntimeWarning
           +-- SyntaxWarning
           +-- UserWarning
           +-- FutureWarning
	   +-- ImportWarning
	   +-- UnicodeWarning
	   +-- BytesWarning
```

## Dict to string
```python
''.join('{}{}'.format(key, val) for key, val in adict.items())
```

## Magic to transform string representation of a Dictionary to a dictionary
```python
string = ast.literal_eval(string)
assert type(new_dict) is dict
```

## Read multiple parameters from console
```python
def main():
    a, b = map(int, input().split())
    res = a + b
    print(res)


if __name__ == "__main__":
    main()
```

## Which BLAS we use in out numpy and spark
```python
import numpy as np
np.show_config()
```

## Classes
```python
class Song:
    def __init__(self, artist, song):
        self.artist = artist
        self.song = song
        self.tags = []


    def add_tags(self, *args):
        self.tags.extend(args)


song1 = Song("artist_name1", "song_name2")
song1.add_tags("tag1", "tag2")

song2 = Song("artist_name3", "song_name4")
song2.add_tags("tag3", "tag4")

song2.tags
```
```python
class MoneyBox:
    def __init__(self, capacity):
        self.capacity = capacity
        self.value = 0

    def can_add(self, v):
        if (v <= (self.capacity - self.value)):
            return True
        else:
            return False

    def add(self, v):
        self.value = self.value + v
```

## Check instance
```python
isinstance(x,y)
```
## Check class
```python
type()
```

## Unit-test
```python
import unittest

class TestStringMethods(unittest.TestCase):

  def test_upper(self):
      self.assertEqual('foo'.upper(), 'FOO')

  def test_isupper(self):
      self.assertTrue('FOO'.isupper())
      self.assertFalse('Foo'.isupper())

  def test_split(self):
      s = 'hello world'
      self.assertEqual(s.split(), ['hello', 'world'])
      # Проверим, что s.split не работает, если разделитель - не строка
      with self.assertRaises(TypeError):
          s.split(2)

if __name__ == '__main__':
    unittest.main()
```

# Функции
## Синтаксис объявления функций
```python
# return использовать не обязательно, функция вернёт None

# Для документации функции используются строковые литералы
>>> def foo():
...     """I return 42."""
...     return 42
...

# После объявлении функции документация доступна через определённый атрибут
>>> foo.__doc__
'I return 42.'

# В интерпретаторе удобнее пользоваться встроенной функцией
>>> help(foo)  # или foo? в IPython.
```

## Улучшение функции min()
```python
>>> def min(x, y):                #    __o
...     return x if x < y else y  #  _`\<,_
...                               # (_)/ (_)

# 1. Находить минимум произвольного количества аргументов
>>> min(-5, 12, 13)
-5

# 2. Использовать функцию min для кортежей, списков, множеств и других последовательностей 
>>> xs = {-5, 12, 13}
>>> min(???)
-5

# 3. Ограничить минимум произвольным отрезком [lo, hi]
>>> bounded_min(-5, 12, 13, lo=0, hi=255)
12

# 4. По заданным lo и hi строить функцию bounded_min (фабрика функций)
>>> bounded_min = make_min(lo=0, hi=255)
>>> bounded_min(-5, 12, 13)
12
```
### Упаковка агрументов
```python
# 1.a
def min(*args):  # type(args) == tuple
    res = float("inf")  # инициализируем бесконечностью
    for arg in args:
        if arg < res:
            res = arg
        return res

# >>> min(-5, 12, 13)
# -5

# >>> min()
# inf
```
```python
1.b
def min(first, *args):
    res = first
    # ...

# min()
# TypeError: min() missing 1 required [...] argument: 'first'
```

### Распаковка аргументов
```python
# 2.a
# Синтаксис будет работать с любым объектом, поддерживающим протокол итератора
# Итератор - что-то, что можно обойти

>> xs = {-5, 12, 13}  # но вообще set лучше не юзать
>>> min(*xs)  # здесь он не критичен, но вообще, распаковывать set - странная идея
-5

>>> min(*[-5, 12, 13])
-5

>>> min(*(-5, 12, 13))
-5
...
```

### Ключевые аргументы: аргументы по умолчанию
```python
# 3.a
def bounded_min(first, *args, lo=float("-inf"),
                hi=float("inf")):
    res = hi
    # итерируемся по первому элементу + всё остальное
    for arg in (first, ) + args:  # args - это кортеж, 
                                  # соответственно fisrt тоже надо превратить к кортеж :)
        if arg < res and lo < arg < hi:
            res = arg
    return max(res, lo)

# >>> bounded_min(-5, 12, 13, lo=0, hi=255)
# 12
```

### Ключевые элементы: подводные камни
```python
# Нужно было написать функцию, которая принимает что-то, 
# по чему можно итерироваться и возвращает список уникальных элементов
def unique(iterable, seen=set()):
    acc = []
    for item in iterable:
        if item not in seen:
            seen.add(item)
            acc.append(item)
    return acc

# >>> xs = [1, 1, 2, 3]
# >>> unique(xs)
# [1, 2, 3]

# >>> unique(xs)
# []
# Так происходит, потому что значение по умолчанию инициализируется ровно один раз -
#                                                   - в момент компиляции в байт-код
# Т.е. все вызовы unique() будут различать значения атрибута seen
# Вывод: никогда не использовать изменяемые значения в качестве значений по умолчанию
# (никакие списки, никакие словари)

# Атрибут __defaults__ - кортеж с инициализированными значениями элементов по умолчанию
# >>> unique.__defaults__
# ({1, 2, 3},)
```

## Ключевые элементы: правильная инициализация
```python
def unique(iterable, seen=None):  # None не изменяемый, потому что он Singleton
    seen = set(seen or [])  # None --- falsy. 
    # Поэтому если аргумент=None, то он станет пустым списком
    # OR подразумевает операции над булевыми переменными,
    #                        поэтому, если они не булевы, 
    #                        то он попытается их привести к таковым
    # А если первая штука truesy, то мы берём её значение
    
    acc = []
    for item in iterable:
        if item not in seen:
            seen.add(item)
            acc.append(item)
    return acc


# >>> xs = [1, 1, 2, 3]
# >>> unique(xs)
# [1, 2, 3]

# >>> unique(xs)
# [1, 2, 3]
```

### Falsy:
```python
None
0
0,00
""
[] () {}
set()
```

### Ключевые аргуенты: и только ключевые
```python
# Если функция имеет фиксированную арность, 
# то ключевые агрументы можно передавать без явного указания имени:
>>> def flatten(xs, depth=None):
...     pass
...
>>> flatten([1, [2], 3], depth=1)
>>> flatten([1, [2], 3], 1)

# Можно явно потребовать, чтобы часть аргументов всегда передавалась как ключевые:
>>> def flatten(xs, *, depth=None):  # звёздочка всё кушает и не связывает это с именем
# Всё, что идёт после звёздочки - ключевые аргументы
...     pass
...
>>> flatten([1, [2], 3], 2)
TypeError: flatten() takes 1 positional argument [...]
```

## Ключевые аргументы: упаковка и распаковка
```python
def runner(cmd, **kwargs):
    if kwargs.get("verbose", True):
        print("Logging enabled")

>>> runner("mysqld", limit=42)
Logging enabled
>>> runner("mysqld", **{"verbose": False})
>>> options = {"verbose": False}
>>> runner("mysqld", **options)
```

## Упаковка и распаковка
```python
# Присваивание
acc = []
seen = set()
(acc, seen) = ([], set())

# В качестве правого объекта можно использовать любой объект,
# поддерживающий протокол итератора
x, y, z = [1, 2, 3]
x, y, z = {1, 2, 3}  # unordered
x, y, z = "xyz"
x, y = y, x  # по сути справа - tuple (y, x)

# Скобки обычно опускают, но иногда они бывают полезны
rectangle = (0, 0), (4, 4)
(x1, y1), (x2, y2) = rectangle
```

### Расширенный синтаксис распаковки
```python
# В Python 3.0 можно юзать * (что-то мы распакуем, а что-то обратно запакуем)
# rest всегда приводится к списку и копирует то, что справа
>>> first, *rest = range(1, 5)
>>> first, rest
(1, [2, 3, 4])

# * можно использовать в любом месте приложения
>>> first, *rest, last = range(1, 5)
>>> last
4

>>> first, *rest, last = [42]
ValueError: need more than 1 values to unpack

# Работает рекурсивно тоже
>>> *_, (first, *rest) = [range(1, 5)] * 5
>>> fisrt
1

https://www.python.org/dev/peps/pep-3132/
```

### Распаковка и цикл for
```
# Синтаксис распаковки работает и в цикле for, например:
for a, *b in [range(4), range(2)]:
    print(b)

# [1, 2, 3]
# [1]
```

### Распаковка и байткод
```python
>>> import dis
>>> dis.dis("first, *rest, last = ('a', 'b', 'c')")
     0 LOAD_CONST               4 (('a', 'b', 'c'))
     3 UNPACK_EX              257
     6 STORE_NAME               0 (first)
     9 STORE_NAME               1 (rest)
    12 STORE_NAME               2 (last)
    15 LOAD_CONST               3 (None)
    18 RETURN_VALUE
# Мораль: присваивание в Python работает слева-направо
>>> x, (x, y) = 1, (2, 3)  # не надо так писать :)
>>> x
2
```
```python
>>> dis.dis("first, *rest, last = ['a', 'b', 'c']")
     0 LOAD_CONST               0 (1)
     3 LOAD_CONST               1 (2)
     6 LOAD_CONST               2 (3)
     9 BUILD_LIST               3
    12 UNPACK_EX              257
    15 STORE_NAME               0 (first)
    18 STORE_NAME               1 (rest)
    21 STORE_NAME               2 (last)
    24 LOAD_CONST               3 (None)
    27 RETURN_VALUE
# Мораль: Синтаксически схожие конструкции могут 
#         иметь различную семантику времени исполнения
```

### Упаковка и распаковка: резюме
```python
# Функции в Python могут принимать произвольное количество
# позиционных и ключевых аргументов

# Для объявления таких функций используется синтаксис упаковки,
# а для вызова синтаксис распаковки
>>> def f(*args, **kwargs):
...     pass
...
>>> f(1, 2, 3, **{"foo":42})

# Синтаксис распаковки также можно использовать при присваивании
# нескольких аргументов в цикле for:
>>> first, *rest = range(4)
>>> for first, *rest in [range(4), range(2)]:
...     pass
...
```

### Дополниетльные расширения синтаксиса распаковки
```python
# В Python 3.5 возможности распаковки были в очередной раз расширены
# Теперь можем распаковать произвольное количество объектов
# https://www.python.org/dev/peps/pep-0448/

# Изменения затронули распаковку при вызове функции:
>>> def f(*args, **kwargs):
...     print(args, kwargs)
...
>>> f(1, 2, *[3, 4], *[5],
...   foo="bar", **{"baz": 42}, boo=24)
# (1, 2, 3, 4, 5) {'baz': 42, 'boo': 24, 'foo': 'bar'}

# и при инициализации контейнеров
>>> defaults = {"host": "0.0.0.0", "port": 8080}
>>> {**defaults, "port": 80}  # замещает значения по ключу
{'host': '0.0.0.0', 'port': 80}
>>> [*range(5), 6]  # аналогично для множества и кортежа
[0, 1, 2, 3, 4, 5, 6]
```

## Области видимости aka scopes
### Функции внутри функций внутри функций
* В отличие от Java (< 8), C/C++ (< 11) в Python функции - объекты первого класса.
То есть с ними можно делать то же самое, что и с другими значениями.
Можно функцию передать в другую функцию, можно функцию вернуть из функции.
* Например, можно объявлять функции внутри других функций
```python
>>> def wrapper():
...     def identity(x):
...         return x
...     return identity
...
>>> f = wrapper()
>>> f(42)
42
```

### Фабрика функций
```python
def make_min(*, lo, hi):
    def inner(first, *args):
       res = hi
       for arg in (first,) + args:
           if arg < res and lo < arg < hi:
               res = arg
       return max(res, lo)
    return inner

# >>> bounded_min = make_min(lo=0, hi=255)
# >>> bounded_min(-5, 12, 13)
# 0 
```

### Области видимости: LEGB
```python
>>> min              # builtin
<built-in function min>
>>> min = 42         # global
>>> def f(*args):
...     min = 2
...     def g():     # enclosing
...         min = 4  # local
...         print(min)
...

# Правило LEGB
# Поиск имени ведётся не более чем в четырёх областях видимости:
# локальной, затем в объемлющей функции (если такая имеется), затем
# в глобальной и, наконец, во встроенной.
```

### Области видимости: интроспекция
```python
>>> min = 42     # = globals()['min'] = 42
>>> globals()    # изменяемый словарь глобальных переменных
{..., 'min': 42}
>>> def f():
...     min = 2  # = locals()['min'] = 2
...     print(locals())
...
>>> f()
{'min': 2}
```

## Области видимости: замыкания
* Функции в Python могут использовать переменные, определённые во внешних областях видимости
* Важно помнить, что поиск переменных осуществляется во время исполнения функции, а не во время объявления
```python
>>> def f():
...     print(i)
...
>>> for i in range(4):
...     f()
...
0
1
2
3
```

## Области видимости: присваивание
* Для присваивания правило LEGB не работает. Присваивание абсолютно всегда создаёт имя в локальной области видимости
```python
>>> min = 42
>>> def f():
...     min += 1
...     return min
...
>>> f()
UnboundLocalError: local variable 'min' referenced [...]
```
* По умолчанию операция присваивания создаёт локальную переменную
* Изменить это поведение можно с помощью операторов local и nonlocal

## Оператор global 
* Позволяет модифицировать значение переменной из глобальной области видимости
```python
>>> min = 42
>>> def f():
...     global min
...     min += 1
...     return min
...
>>> f()
43
>>> f()
44
```
* Использование global порочно, почти всегда лучше заменить global на thread-local объект

## Оператор nonlocal
* Позволяет модифицировать значение переменной из объемлющей области видимости
```python
# Мы хотим сделать "изменяемую ячейку памяти" value,
# при этом мы хотим инкапсулировать её значение (никаким
# другим способом пользователь не сможет получить её значение, кроме вызвав get(),
# потому что переменная value локальная

# Переменная get просто использует value (мы пойдём наверх и 
# найдём в объемлющей области видимости value)

# С set другая история, там нужен nonlocal чтобы мы не создали локальную переменную, 
# а изменили внешнюю
def cell(value=None):
    def get():
        return value
    def set(update):
        nonlocal value
        value = update
    return get, set

# >>> get, set = cell()
# >>> set(42)
# >>> get()
# 42
```
[Почитать мысли разработчиков на эту тему (PEP-3104)](https://www.python.org/dev/peps/pep-3104/)

## Области видимости: резюме
* В Python четыре области видимости: встроенная, глобальная, объемлющая и локальная
* Правило LEGB: поиск имени осуществляется от локальной к встроенной
* При использовании операции присваивания имя считается локальным. 
Это поведение можно изменить с помощью операторов global и nonlocal.

# Функциональное программирование
## Функциональное программирование: анонимные функции
* Python не функциональный язык, но в нём есть элементу функционального программирования
* Анонимные функции имеют вид
```python
>>> lambda arguments: expression
```
и эквивалентны по поведению
```python
>>> def <lambda>(arguments):
...     return expression
```
* Всё, сказанное про аргументы именованных функций, справедливо и для анонимных
```python
>>> lambda foo, *args, bar=None, **kwargs: 42
```

## Функциональное программирование: map
// Функции высшего порядка - функции, которые принимают другие функции
* Применяет функцию к каждому элементу последовательности (iterable, т.е. объекту, поддерживающему протокол итератора)
```python
# Первый аргумент - это функция, которую мы применим к последовательности из итераторов
# Map ленивый, ничего не вернёт и считать не будет, если не указать
>>> map(indentity, range(4))
<map object>
>>> list(map(identity, range(4)))
[0, 1, 2, 3]
>>> set(map(lambda x: x % 7, [1, 9, 16, -1, 2, 5]))
{1, 2, 5, 6}
>>> map(lambda s: s.strip(), open("./HBA1.txt"))
<map object>
```
* или последовательностей, количество элементов в результате 
определяется длиной наименьшей из последовательностей
```python
>>> list(map(lambda x, n: x ** n,
...          [2, 3], range(1, 8)))
[2, 9]
```

## Функциональное программирование: filter
Принимает предикат (т.е. какую-то функцию, возвращающую truthy value) и принимает коллекцию
* Убирает из последовательности элементы, не удовлетворяющие предикату
```python
>>> filter(lambda x: x % 2 != 0, range(10))
<filter object>
>>> list(filter(lambda x: x % 2 != 0, range(10)))
[1, 3, 5, 7, 9]
```
* Вместо предиката можно передать None, в этом случае в последовательности останутся только truthy значения
```python
>>> xs = [0, None, [], {}, set(), "", 42]
>>> list(filter(None, xs))
[42]
```

## Функциональное программирование: zip
Сшивает несколько последовательностей
* Строит последовательность кортежей из элементов нескольких последовательностей
```python
>>> list(zip("abc", range(3), [42j, 42j, 42j]))
[('a', 0, 42j), ('b', 1, 42j), ('c', 2, 42j)]
```
* Поведение в случае последовательностей различной длины аналогично map
```python
>>> list(zip("abc", range(10)))
[('a', 0), ('b', 1), ('c', 2)]
```
* Выражение zip через map
```python
map(lambda *args, argf)
```

## Функциональное программирование: генераторы списков
Выглядят как плоский цикл for
* Пришли в Python из языка ABC, который позаимствовал их из языка SETL
```python
>>> [x ** 2 for x in range(10) if x % 2 == 1]
[1, 9, 25, 49, 81]
```
* Компактная альтернатива комбинациям map и filter
```python
>>> list(map(lambda x: x ** 2,
...          filter(lambda x: x % 2 ==1,
...                 range(10))))
[1, 9, 25, 49, 81]
```
* Могут быть вложенными
```python
# Расплющит вложенные списки. Здесь вложенность 2, поэтому 2 цикла for
# Если больше двух, то лучше явно написать цикл for и не заставлять людей страдать
>>> nested = [range(5), range(8, 10)]
>>> [x for xs in nested for x in xs]  # flatten
[0, 1, 2, 3, 4, 8, 9]
```

## Функциональное программирование: генераторы множеств и словарей
```python
>>> {x % 7 for x in [1, 9, 16, -1, 2, 5]}
{1, 2, 5, 6}
>>> date = {"year": 2015, "month": "September", "day": ""}
>>> {k: v for k, v in date.items() if v}
{'month': 'September', 'year': 2015}
>>> {x: x ** 2 for x in range(4)}
{0: 0, 1: 1, 2: 4, 3: 9}
```

## Функциональное программирование: резюме
* Наличие элементов функционального программирования позволяет компактно выражать вычисления
* В Python есть типичные для функциональных языков:
*  * анонимные функции lambda,
*  * функции map, filter и zip,  
*  * генераторы списков.
* Синтаксис Python также поддерживает генерацию других типов коллекций: множеств и словарей

## PEP-8 (python enhancement proposal)
https://www.python.org/dev/peps/pep-0008/
http://www.pocoo.org/internal/styleguide/

Для сравнения на равенство
* объектов используйте операторы == и !=,
* синглтонов используйте is и is not,
* булевых значений используйте сам объект или оператор not, например
```python
if foo:
    # ...

while not bar:
    # ...
```
* проверяйте отсутствие элемента в словаре с помощью оператора not in
```python
if not key in d:  # Плохо
if key not in d:  # Лучше
```
* Документируйте функции следующим образом:
```python
def something_useful(arg, **options):
    """One-line summary.

    Optional longer description of the function behaviour.
    """
```

## PEP-8 tools
```
pip install pep8
pep8 ./file.py
```
```
pip install autopep8
autopep8 -v ./file.py
```

# Декораторы и модуль functools
## Синтаксис использования декораторов
* Декоратор - функция, которая принимает другую функцию и что-то возвращает
```python
>>> @trace
... def foo(x):
...     return 42
...
```
* Аналогичная по смыслу версия без синтаксического сахара
```python
>>> def foo(x):
...     return 42
...
>>> foo = trace(foo)
```
* По имени foo будет доступно то, что вернула функция trace. Это и есть результат применения декоратора
* Возвращаемый объект может быть любого типа

## Пример синтаксиса
* Декоратор trace выводит на экран сообщение с информацией о вызове декорируемой функции
```python
# Возвращает имя функции и аргументы, с которыми она была вызвана
>>> def trace(func):
...     def inner(*args, **kwargs):
...         print(func.__name__, args, kwargs)
...         return func(*args, **kwargs)
...     return inner
```
* Применим его к тождетсвенной функции
```python
>>> @trace
... def identity(x):
...     "I do nothing useful."
...     return x
...
>>> identity(42)
identity(42, ) {}
42
```
## Что можно допилить в этой функции:
* Проблема c help и атрибутами декорируемой функции
```python
>>> help(identity)
Help on function inner in module __main__:

inner(*args, **kwargs)

```
* Возможность глобально отключать trace без лишних телодвижений
* Явное указание файла при использовании trace
```python
>>> @trace
... def identity(x):
...    return x
```
* Использование sys.stdout для вывода по умолчанию

## Декоратор и help: проблема
```python
>>> def identity(x):
...     "I do nothing useful"
...     return x
...
>>> identity.__name__, identity.__doc__
('identity', 'I do nothing useful.')
>>> identity = trace(identity)
>>> identity.__name__, identity.__doc__
('inner', None)
```
__module__
У любой функции в Python есть атрибут __module__, содержащий имя модуля, в котором функция была определена. Для функций, определённых в интерпретаторе, например:
```python
>>> identity.__module__
'__main__'
```

## Декораторы и help: модуль functools
* В модуле functools из стандартной библиотеки Python есть функция, реализующая логику копирования внутренних атрибутов
```python
import functools

    def trace(func):
        def inner(*args, **kwargs):
            print(func.__name__, args, kwargs)
            return func(args, kwargs)
        functools.update_wrapper(inner, func)
        return inner
```
* То же самое можно сделать с помощью декоратора wraps
```python
def trace(func):
    @functools.wraps(func)
    def inner(*args, **kwargs):
        print(func.__name__, args, kwargs)
        return func(args, kwargs)
    return inner
```

## Отключение применения декоратора
* Заведём глобальную переменную trace_enabled и с её помощью будем отключать и включать trace
```python
trace_enabled = False


def trace(func):
    @functools.wraps(func)
    def inner(*args, **kwargs):
        print(func.__name__, args, kwargs)
        return func(*args, **kwargs)
    return inner if trace_enabled else func
```
* Если trace выключен, то результатом применения декоратора является сама функция func - никаких дополнительных действий в момент её исполнения производиться не будет

## Декораторы с аргументами: синтаксис
```python
@trace
def identity():
    return x

# ==

def identity(x):
    return x

identity = trace(identity)
```
* Для декораторов с аргументами эквивалентность сохраняется
```python
@trace(sys.stderr)
def identity(x):
    return x

# ==

def identity(x):
    return x

deco = trace(sys.stderr)
identity = deco(identity)
```

## Декоратор с аргументами: реализация
```python
def trace(handle):
    def decorator(func):
        @functools.wraps(func)
        def inner(*args, **kwargs):
            print(func.__name__, args, kwargs, file=handle)
            return func(*args, **kwargs)
        return inner
    return decorator
```

## Декораторы с аргументами: @with_arguments
* Можно обобщить логику декоратора с аргументами в виде декоратора with_arguments
```python
def with_arguments(deco):
    @functools.wraps(deco)
    def wrapper(*dargs, **dkwargs):
        def decorator(func):
            result = deco(func, *dargs, **dkwargs)
            functools.update_wrapper(result, func)
            return result
        return decorator
    return wrapper
```
* Что происходит:
1. with_arguments принимает декоратор deco и должна вернуть декоратор
2. заворачивает его во wrapper, так как deco - декоратор с аргументами, а затем в decorator
3. decorator конструирует новый декоратор с помощью deco и копирует в него внутренние атрибуты функции func

## Декораторы с аргументами: человечный trace
```python
@with_arguments
def trace(func, handle):
    def inner(*args, **kwargs):
        print(func.__name__, args, kwargs, file=handle)
        return func(*args, **kwargs)
    return inner

@trace(sys.stderr)
def identity(x):
    return x
```

## Декораторы с опциональными аргументами: магическая версия
```python
# Тут декоратор может быть с аргументами или без них,
# есть обработка обоих случаев

# lambda выполняет функцию deco из предыдущих примеров 
def trace(func=None, *, handle=sys.stdout):
    # со скобками
    if func is None:
        return lambda func: trace(func, handle=handle)

    # без скобок
    @functools.wraps(func)
    def inner(*args, **kwargs):
        print(func.__name__, args, kwargs)
        return func(*args, **kwargs)
    return inner
```

## "Теория" декораторов: резюме
* Декоратор - способ модифицировать поведение функции, сохраняя читаемость кода
* Декораторы бывают:
* * без аргументов @trace
* * с аргументами @trace(sys.stderr)
* * с опциональными аргументами

## Использование декораторов: @timethis
```python
def timethis(func=None, *, n_iter=100):
    if func is None:
        return lambda func: timethis(func, n_iter=n_iter)

    @functools.wraps(func)
    def inner(*args, **kwargs):
        print(func.__name__, end=" ... ")
        acc = float("inf")
        for i in range(n_iter):
            tick = time.perf_counter()
            result = func(*args, **kwargs)
            acc = min(acc, time.perf_counter - tick)
        print(acc)
        return result
    return inner

result = timethis(sum)(range(10 ** 6))
# sum ... 0.021247283742833462
```

## Использование декораторов: @profiled
Профилирование для бедных :) считает количество вызовов функции
```python
def profiled(func):
    @functools.wraps(func)
    def inner(func, *args, **kwargs):
        inner.ncalls += 1
        return func(*args, **kwargs)

    inner.ncalls = 0
    return inner


@profiled
def identity(x):
    return x


# >>> identity(42)
# 42

# >>> identity.ncalls
# 1
```

## Использование декораторов: @once
Функция, которая делает что-то один раз.

Данная реализация работает, только если внутренняя функция ничего не возвращает.
Иначе нужно либо писать результат в атрибут, либо в переменную из объемлющей области видимости.
```python
def once(func):
    @functools.wraps(func)
    def inner(*args, **kwargs):
        if not inner.called:
            func(*args, **kwargs)
            inner.called = True
    inner.called = False
    return inner


@once
def initialize_settings():
    print("Settings initialized.")


# >>> initialize_settings()
# Settings initialized.
# >>> initialize_settings()
#
```

## Использование декораторов: @memoized
* Мемоизация - сохранение результатов выполнения функции для предотвращения избыточных вычислений.
* Декоратор для автоматической мемоизации "любой" функции:
```python
# Неработающий (из-за изменяемости словарей, словарь не хешируемый) декоратор

# Если уже считали - вернём,
# если ещё не - посчитаем и запомним
def memoized(func):
    cache = {}

    @functools.wraps(func)
    def inner(*args, **kwargs):
        key = args, kwargs
        if key not in cache:
            cache[key] = func(*args, **kwargs)
        return cache[key]
    return inner
```
```python
# Функция Аккермана и @memoized
def ackermann(m, n):
    if not m:
        return n + 1
    elif not n:
        return ackermann(m - 1, 1)
    else:
        return ackermann(m - 1, ackermann(m, n - 1))

# >>> ackermann(3, 4)
# TypeError: unhashable type: 'dict'
```
```python
# Работающий декоратор
# Частное решение проблемы:
def memoized(func):
    cache = {}

    @functools.wraps(func)
    def inner(*args, **kwargs):
        key = args + tuple(sorted(kwargs.items()))
        if key not in cache:
            cache[key] = func(*args, **kwargs)
        return cache[key]
    return inner

ackermann(3, 4)
# 125
```
Нет универсального и быстрого решения. Можно сериализовывать аргументы в строку, например, через str или, что более осмысленно, через pickle

## Использование декораторов: @deprecated
```python
def deprecated(func):
    code = func.__code__
    warnings.warn_explicit(
        func.__name__ + "is deprecated.",
        category=DeprecationWarning,
        filename=code.co_filename,
        lineno=co_firstlineno + 1)
    return func


@deprecated
def identity(x):
    return x

# <stdin>:2: DeprecationWarning: identity is deprecated.
# В момент импорта, в момент компиляции в байт-код
```

## Использование декораторов: контракты pre и post
* Контрактное программирование - способ проектирования программ, основывающийся на формальном описании интерфейсов в терминах предусловий, постусловий и инвариантов.
* В Python контрактное программирование можно реализовать в виде библиотеки декораторов:
https://pypi.python.org/pypi/contracts
```python
# Проверка что аргумент логарифма не отрицателен
>>> @pre(lambda x: x >= 0, "negative argument")
... def checked_log(x):
...     pass
...
# Проверка что функция NaN не вернула
# Декоратор можно записать в переменную
>>> is_not_nan = post(lambda r: not math.isnan(r), "not a number")
>>> @is_not_nan
... def something_useful():
...     pass
...
```
### Реализация @pre
```python
def pre(cond, message):
    def wrapper(func):
        @functools.wraps(func)
        def inner(*args, **kwargs):
            assert cond(*args, **kwargs), message
            return func(*args, **kwargs)
        return inner
    return wrapper


@pre(lambda r: r >= 0, "negative argument")
def checked_log(x):
    return math.log(x)

# checked_log(-42)
# AssertionError: negative argument
```
### Реализация @post
```python
# В post assert после применения функции
def post(cond, message):
    def wrapper(func):
        @functools.wraps(func)
        def inner(*args, **kwargs)
            result = func(*args, **kwargs)
            assert cond(result), message
            return result
        return inner
    return wrapper


@post(lambda x: not math.isnan(x), "not a number")
def something_useful():
    return float("nan")

# >>> something_useful()
# AssertionError: not a numbet
```

## Цепочки декораторов
* Синтаксис Python разрешает одновременное применение нескольких декораторов
* Порядок декораторов имеет значение:
```python
>>> def square(func):
...     return lambda x: func(x * x)
...
>>> def addsome(func)
...    return lambda x: func(x + 42)
...
>>> # identity = square(addsome(identity))  Поэтому выполнится сверху вниз
>>> @square
... @addsome
... def identity(x):
...     return x
...
>>> identity(2)
46
>>> # ============================================================
>>> @addsome
... @square
... def identity(x):
...     return x
...
>>> identity(2)
1936
```
https://wiki.python.org/moin/PythonDecoratorLibrary

## Модуль functools
