# TeaShop
### 1、tea表

| 序号 | 名称   | 描述                                               | 类型    | 键   | 为空 | 额外           | 默认值  |
| ---- | ------ | -------------------------------------------------- | ------- | ---- | ---- | -------------- | ------- |
| 1    | id     | 奶茶id                                             | int     | PRI  | NO   | auto_increment |         |
| 2    | name   | 奶茶名称                                           | varchar |      | NO   |                |         |
| 3    | price  | 奶茶价格                                           | decimal |      | NO   |                |         |
| 4    | type   | 奶茶类型                                           | varchar |      | YES  |                | '其它'  |
| 5    | isSale | 是否可销售。<br />0表示可销售，<br />1表示不可销售 | int     |      | YES  |                | 0       |
| 6    | remark | 备注                                               | varchar |      | YES  |                | '暂无~' |



### 2、store表

| 序号 | 名称  | 描述                    | 类型 | 键   | 为空 | 额外           | 默认值 |
| ---- | ----- | ----------------------- | ---- | ---- | ---- | -------------- | ------ |
| 1    | id    | 库存id                  | int  | PRI  | NO   | auto_increment |        |
| 2    | teaId | 奶茶id。外键，连接tea表 | int  | FOR  | NO   |                |        |
| 3    | count | 库存数量                | int  |      | YES  |                | 0      |





### 3、statistic表

| 序号 | 名称       | 描述                    | 类型 | 键   | 为空 | 额外           | 默认值 |
| ---- | ---------- | ----------------------- | ---- | ---- | ---- | -------------- | ------ |
| 1    | id         | 库存id                  | int  | PRI  | NO   | auto_increment |        |
| 2    | teaId      | 奶茶id。外键，连接tea表 | int  | FOR  | NO   |                |        |
| 3    | sales      | 总销量                  | int  |      | YES  |                | 0      |
| 4    | daySales   | 日销量                  | int  |      | YES  |                | 0      |
| 5    | monthSales | 月销量                  | int  |      | YES  |                | 0      |
| 6    | yearSales  | 年销量                  | int  |      | YES  |                | 0      |



### 4、order表

| 序号 | 名称      | 描述                                                  | 类型    | 键   | 为空 | 额外           | 默认值   |
| ---- | --------- | ----------------------------------------------------- | ------- | ---- | ---- | -------------- | -------- |
| 1    | id        | 订单id                                                | int     | PRI  | NO   | auto_increment |          |
| 2    | username  | 用户名                                                | varchar |      | YES  |                | '无名氏' |
| 3    | list      | 订购商品列表                                          | varchar |      | YES  |                | NULL     |
| 4    | amount    | 总金额                                                | decimal |      | YES  |                | NULL     |
| 5    | startTime | 订单发起时间                                          | date    |      | YES  |                | NULL     |
| 6    | status    | 订单状态(0-订单进行中，1-订单成功并结束，-1-订单失败) | int     |      | YES  |                | 0        |
| 7    | remark    | 订单备注信息                                          | varchar |      | YES  |                | '暂无~'  |

list字段说明：

​	例：用户买了珍珠奶茶2份，双皮奶1份。

数据库存储格式 ：varchar v = '珍珠奶茶 2 双皮奶 1'

1、保证商家添加奶茶时，奶茶名称**前后缀无连续空格**

2、java使用split(" ")函数分割该list字段值，结果一定是一个偶数长度数组String[]，从左到右两两对应即为订单列表。