# Chapter 6 重新组织函数 #
* Extract Method (110)
	* 用的最多的方法
	* 最大困难:处理局部变量
	* 如果变量只用一次： Replace Temp with Query (120)
* 如果变量需要用多次， Split Temporary Variable (128)
	* 不要在函数体内对传入的参数赋值

## 6.1 Extract Method 提炼函数 ##
	* 最常用的重构手法之一
	> 你有一段代码可以被组织在一起并独立出来
	*  **示例**
	* 原始代码
	```java
	void printOwing(double amount) {
		printBanner();

		//print details
		System.out.println("name:" + name);
		System.out.println("amount:" + amount);

	}
```

* 经过 Extract Method (110) 处理过

```java
void printOwing(double amount) {

	printBanner();
	printDetails(amount);

}
void printDetails(double amount){

	System.out.println("name:" + name);
	System.out.println("amount:" + amount);

}
```
	* 分析示例
		* 这个函数很短，很简洁，所以重构以后的代码并没有显得很高明
		* 但是只看主函数的话，经过重构的整个函数封装的很好，在不关心细节的情况下，主函数不需要任何注释就能明白
		* 相比之下，原始代码中需要添加注释来说明下面的两行所做事情的目的
* 使用 Extract Method (110) 好处
	* 如果每个函数的颗粒度都很小，那么函数被复用的机会就会更大
	* 通过Extract使得高层函数使用起来就像是一系列注释
	* 如果函数都是细颗粒度，那么覆写也会容易一些
* **怎么做**
	* 创造一个新函数，根据这个函数的意图来对它命名，也就是以它"做什么"命名，而不是"怎么做"命名
		* 如果你想不出一个更加有意义的名字，暂时先不要动
	* 将提炼的函数从源代码复制到新建的目标函数中
	* 处理临时变量: 声明临时变量
	* 仔细检查提炼的函数代码，检查其中的局部变量和源函数变量
	* 局部变量如果被提炼的函数改变，看看是否可以将被提炼代码处理为一个查询
	* 如果多个局部变量都被改变了，那么这段代码就不能原封不动的提炼出来
		* Split Temporary Variable (128)
		* Replace Temp with Query (120)
	* 将被提炼的代码中需要读取的局部变量，作为参数传入
	* 在源函数中将被提炼代码替换成对目标函数的调用
	* 编译,测试
* **每个函数都返回一个值**
* 如果临时变量为数众多，会让提炼工作举步维艰
	* Replace Method with Method Object (135)

## 6.2 Inline Method 内联函数 ##
> 间接性可能带来帮助，但是非必要的间接性总是让人不舒服
* 这个方法是用来处理过度重构的
* 主要是指一个函数的本体和他的名字一样清楚易懂，那么就没有必要重构

```java
int getX(){
	return (moreThanFive())? 2:1;
}
void moreThanFive(){
	return (x>5);
}

int getX{
	return (x>5)?2:1;
}
```
* 间接层有其价值，但不是所有的间接层都有价值
* **怎么做**
	* 检查函数，确定它没有多态性
	* 找到这个函数所有的调用点
	* 将这个函数调用点都替换成函数本体

## 6.3 Inline Temp 内联临时变量 ##
* 临时变量会妨碍其他的重构手法, 所以处理临时变量的一个方法就是 **内联临时变量**
* 
* **Tips**
	* 如果想要去除临时变量，或者确定某一个变量只是被赋值一次，可以将其声明为final,通过编译器确定
