# RecyclerView

### [1、EasyRecyclerView]
将开发中常用的RecyclerView的各种需求封装进库。提升开发效率。重点在Adapter与viewholder的封装。他们之间彻底解耦。adapter工作更少，仅负责业务逻辑。所以如果你使用mvp架构可以放进presenter层。viewholder负责View展示与Adapter没有任何耦合，将可以到处复用。并不会影响运行效率。并且adapter支持数据管理，Header与Footer添加，加载更多。没有更多。加载错误使用了部分Malinskiy/SuperRecyclerView的代码，将更多功能交给了adapter实现。
* GitHub：https://github.com/Jude95/EasyRecyclerView


[1、EasyRecyclerView]:https://github.com/Jude95/EasyRecyclerView