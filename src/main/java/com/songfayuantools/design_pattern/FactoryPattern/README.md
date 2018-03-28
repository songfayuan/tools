
*****************************************start********************************************

#【工厂模式】
工厂模式（Factory Pattern）是java中最常用的设计模式之一。这种类型的设计模式属于创建型模式，他提供了一种创建对象的最佳方式。
在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新的创建对象。

#【介绍】
## 意图
定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
## 主要解决
主要解决接口选择的问题。
## 如何解决
让其子类实现工厂接口，返回的也是一个抽象的产品。

*****************************************end********************************************