# Chapter 3 代码的坏味道
> 如果尿布臭了，就应该换掉它
* 代码就是我们的孩子,要想我们的孩子出人头地，就要好好教育，细心规范
* 识别代码的坏味道需要见识广博者的直觉，而非精确的衡量标准
	* 必须培养自己的判断力
	* 一个类有多少实例变量算太大,一个函数有多少行代码才算太长

## 3.1 重复代码 Duplicated Code ##
* 首当其冲的坏味道
* Extract Method(110), 提炼重复代码
	* 同一个类中: 重复调用提炼的代码函数
	* 兄弟子类中: 提炼到父类中,在子类中处理差异,Template Method设计模式
	* 两个不相关类: 形成独立类
## 3.2 过长的函数 Long Method
* 拥有短函数的对象更加健壮
	* 小函数必须有个好名字
* 每当需要以注释来说明点什么，那么需要说明的代码就需要写到独立的函数中去,以其用途命名
	* 就算只有一行代码，只要它需要注释来说明，那也值得提炼到独立函数中
	* 这有点类似于在设计函数之初写的自然语言梳理编程逻辑，用函数名来表达
* 循环和条件表达式都是提炼的信号
## 3.3 过大的类 Large Class ##
* 不要让单个类做太多事情，如果实例变量太多，则需要提炼新类
* Extract Subclass (330) 
* 技巧: 首先确定客户端如何使用他们，然后运用Extract Interface (341) 为每一种使用方式提炼一个接口
## 3.4 过长的参数列表 ##
* 全局数据是个邪恶的东西
* 太长的参数列表
	* 难以理解
	* 容易造成前后不一致
	* 一旦需要更多数据，不得不修改
* 参数太长，变化频繁就需要考虑重新设计依赖结构
* Replace Parameter with Method (292)
* Preserve Whole Object (288)
* Introduce Parameter Object

## 3.5 发散式变化 Divergent Change ## 
* 一旦需要修改，我们希望跳到系统的某一点，只在此处修改.如果不能做到，这就是坏味道
* 如果某个类经常因为不同的原因在不同的方向上发生变化，Divergent Change 就会出现
	* 运用多态，形成子类
* Extract Class (149)

## 散弹式修改　Shotgun Surgery ##
* Shotgun Surgery 类似 Divergent Change．不同之处在于:
	* 每每遇到某种变化，需要在许多不同的类中做小的改动，这种坏味道就是Shotgun Surgery
	* Divergent Change是指一个类有多种变化，类似switch
	* Shotgun Surgery 则是指一种变化，多个类受到影响
* Move Method (142)
* Move Field (146)
* Inline Class (154)

## 3.7 依恋情结 Feature Envy ##
* 对象技术的全部要点: **将数据和对数据的操作行为包装在一起**
* 经典坏味道：函数对某个类的兴趣高于自己所处的类
	* 某个函数为了计算某个值需要从另外一个对象那里调用几乎一般的取值函数
* Extract Method (110)
* Move Method (142)
* 部分设计模式破坏了这一个原则
	* GoF (Gang of Four) Strategy 和　Visitor 模式
## 3.8 数据泥团 ##
* 适用条件
	* 两个类中有大量相同,或者相互关联的字段
		* 判断方法:删除众多数据中的一项，其他数据受影响明显
	* 许多函数有相同的参数
* 这些总是一起出现的数据应该拥有他们自己的对象
* Extract Class (149)
* Introduce Parameter Object (295)
* Preserve Whole Object (288)
* **好处**
	* 参数列表变短，简化参数的调用
	

## 3.9 基本类型偏执 ## 
> 大多数编程环境都有两种数据结构:
> > 结构类型允许你将数据组织成有意义的形式 
> > 基本类型则是构成结构类型的积木快
> 结构总是会带来一定的额外开销
> 如果只是为一两件事而创建结构类型也显得太麻烦
* java 中以类来表示字符串和日期,而其他编程环境中都以基本类型出现
* 针对对象技术的新手: 即便是小任务中也可以尝试使用小的对象
	* Replace Data Value with Object (175)
* 只要是总是成组出现的基本数据或者函数，都可以编辑成类

## 3.10 Switch 惊悚现身 Switch Statements ##
> 面向对象程序的一个最明显的特征就是：少用switch 语句
> 从本质上讲，switch 语句的问题在于重复
* 修改程序的过程中，switch 语句会分布在项目的各个角落,你需要逐个找到并修改
* 面向对象中**多态**就是优雅的解决方案
* Extract Method (110)
* Move Method (142)
* Replace Type Code with Subclass (223)
* Replace Type Code with State or Strategy (227)
* Replace Conditional with Polymorphism (255)
* 当然，如果只是在单一函数中出现，这个时候用多态就是杀鸡用牛刀了



