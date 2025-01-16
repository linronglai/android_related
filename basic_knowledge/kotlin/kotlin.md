# 0.创建二维数组

1.有初始值的

val array = arrayOf(arrayOf(0,1), array(0,-1))

2.有固定大小的

val array = Array(4){ IntArray(4) }

# 1.返回(return@XXX)与跳转

条件(if，when)与循环(for)

# 2.作用域run,also,let,apply

对象引用       返回值           使用场景
let     it        最后一行代码        判空场景 XX?.let{}
run     this      最后一行代码
also    it        返回对象本身        额外的操作，例如获取ab后打印日志
apply   this      返回对象本身        对bean进行复制操作

注意下面函数定义的返回值差别（Unit代表返回的是上下文对象本身，R代表表达式最后一行）
以及T.()和(T)的差别：T.()代表接受的是上下文对象本身，使用this来获取属性及方法；(T)代表使用lambda表达式，上下文对象是lamda表达式的参数
全都是泛型T的扩展函数
(T) -> Unit函数类型； T.()->Unit扩展函数类型
public inline fun <T> T.also(block: (T) -> Unit): T
public inline fun <T> T.apply(block: T.() -> Unit): T

public inline fun <T, R> T.let(block: (T) -> R): R
public inline fun <T, R> T.run(block: T.() -> R): R

# 3.类与对象

3.1 setter和getter ，以及field字段
3.2 密封类(seal class)和密封接口(seal interface)
(1)密封类不能被实例化
3.3 数据类
3.4 类默认不能被继承，使用open可以使类可以被继承
3.5 主构造函数，次构造函数，init()

# 4.函数

扩展类型函数
T.()->unit的含义：扩展函数类型

# 5.泛型的概念：out, in, where

解决泛型的协变问题，及String是Object子类，但是List<String>也成为List<Object>子类
(1) out:类似于java中的 <? extend Number>，允许将T及子类型传出
in: 类似于java中的 <? super Number>， 允许将T及子类型传入
(2) out规定了集合中的上界（例如集合都是Number的子类）。
知道了元素的上界，就可以用上界引用集合中的元素，因此可以从中获取元素。
但是不能往集合中增加元素，因为对于编译器来说，只知道元素的上界，不知道具体是哪种子类。
生产者
(3)in 规定了集合的下界（换句话说集合中的元素都是Number的父类），
因为编译器不知道集合中具体是哪个父类，所以无法用某个子类来引用父类。
但是可以往集合中增加元素，因为元素是父类的子类，往里面增加元素不会出错。

# 6.@JvmOverloads

主要是为了java调用带有默认参数的方法
这个注解会帮带有n个默认参数的方法，生成n+1个重载方法
例如: @Jvmoverloads fun set(name: String = "jack", age: Int = 18)
-> public void set(String name, int age)
public void set(String name)
public void set()

# 7.委托（by）

类委托
属性委托
https://juejin.cn/post/7043843490366619685?searchId=202412301752534E5817F7F8FBDA3C3968

# 8.by lazy 和 lateinit的区别和使用

# 9.infix（中缀函数）

# 10.解构

val (name, age) = Person("Jame", 12)

原理就是jvm会帮忙生成两个方法component1()，component2()
Person person = new Person("Jame", 12)
String name = person.component1()
int age = person.component2()

# 11.Sequence的使用

sequence.filter.map.take 是“每个”元素依次执行filter -> map -> take函数
list.filter.map.take     是“所有”元素依次执行filter -> map -> take

# 12.kotlin中的高阶函数和lambda表达式

### 1.函数类型定义:函数可以作为参数或者返回值，称为函数类型

```
fun(str: String, fun:(A,B)->C)

```

### 2.函数类型的实例化：

```
val f = { a: Int, b: Int -> a + b }

val f2 = fun(a: Int, b: Int): Int{ a + b }

val f3 = String::toInt
```

### 3.函数类型调用

f.invoke(), f()

### 4.lambda表达式

4.1 标准写法： val sum: (Int, Int)->Int = { a: Int, b: Int -> a + b}

4.2 it含义：当只有一个参数时，隐式声明为it

4.3 非局部返回：lambda表达式内部禁止使用裸return(即不带标签的return),如下代码块。因为lambda表达式不能使包含lambda表达式的函数返回，即不能使foo()函数有返回了

```
fun ordinaryFunction(block: () -> Unit) {
    println("hi!")
}
//sampleStart
fun foo() {
    ordinaryFunction {
        return // 错误：不能使 `foo` 在此处返回
    }
}
```

### 5 匿名函数

匿名函数可以看作是没有名字的普通函数

```
fun(x: Int, y: Int): Int {
    return x + y
}
```

与lambda表达式不同的是:1.可以有不带标签的return;2.一般显示指定函数返回值

## 13.扩展函数

13.1可见性：扩展函数的可见性受其定义位置的限制。通常：

* 扩展函数可以定义在文件顶层，也可以定义在类或伴生对象中。
* 如果在文件顶层定义，所有引用该文件的地方都可以使用。

13.2 特性

* 静态分发特性。在编译期间就决定了，而不是在运行时决定，因此与运行时对象无关，不会被子类覆盖
* 当有同名成员函数时，扩展函数被忽略

13.3 使用场景

包装常用工具类

## 13 反射

14 Kotlin DSL
