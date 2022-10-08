# Lambda expression
***
## Lambda expression là gì
Lambda expression là một khối code mà bạn có thể dùng để thực thi sau này
, một lần hoặc nhiều lần. Truớc đây muốn viết 1 hàm, chúng ta phải khai báo 1
class, trong đó định nghĩa phương thức và viết code logic cho phương thức đó.
Lambda expression cũng là một hàm, nhưng hàm này k phụ thuộc vào bất
kì class nào. Nó là một hàm không tên (unamed function) với các tham số (parameters) và phần body chứa khối lệnh được tách biệt với các tham số bằng dấu ->.
Ví dụ:
```java
    (int x, int y) -> {
        int max = x > y? x: y;
        return max;
    }
```
## Functional interface
Trước khi đi sâu hơn về lamda expression, ta cần phải nẵm rõ được khái
niệm Functional Interface. Một interface chỉ chứa duy nhất một method trừu tượng được gọi là function interface.
Functional interface sử dụng annotation @FunctionalInterface để khai báo. Tuy nhiên việc này là không bắt buộc, nó chỉ đảm bảo cho quá trình complile, giúp chương trình báo lỗi khi có từ 2 method trừu tượng trở lên
.
<br>
>Một vài quy tắc khai báo Functional interface:
> * Một Functional Interface hợp lệ chỉ có duy nhất một method trừu tượng
> * Một Functional Interface có thể có các phương thức của lớp java.lang.Object (chẳng hạn như toString ...)
> * Phương thức default and static không phá vỡ quy tắc của Functional interface
> * Một Functional Interface có thể kế thừa từ một Functional Interface khác chỉ khi nó không có bất kỳ phương thức trừu tượng nào

Vậy tại sao chúng ta phải nắm rõ khái niệm này. Câu trả lời rất đơn giản, 
một trong những ứng dụng quan trọng của Lambda Expression để tạo ra thể hiện (instance) cho interface đó
. Hay nói cách khác, để sử dụng được lambda expression, ta cần phải có
một <i>functional interface</i> chứa 1 abstract method cần được
override lại trong biểu thức lambda
<br>
Ta xét 1 case study sau: **Implement method của 1 interface**
```java
    @FunctionalInterface
    public interface Runnable {
        public abstract void run();
    }
```
- Cách 1: Tạo 1 class implement lại Runnable
  ```java
    public class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("I have implemented Runnable!");
        }

        public static void main(String args[]) {
            MyRunnable runnable = new MyRunnable();
            runnable.run();
        }
    }
    ```
- Cách 2: Tạo một class Annonymous:
  ```java
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("I have implemented Runnable!");
        }
    };
    runnable.run();
    ```
- Cách 3: Dùng Lambda
  ```java
    Runnable runnable = () -> System.out.println("I have implemented Runnable!");
    runnable.run();
    ```
## Variable scpoe
- Lambda expression có thể sử dụng biến được định nghĩa ở phạm vi ngoài.
Lambda có thể capture được các biến statics, instance, local. Có 1 lưu
ý là các biến local phải _final_ hoặc _effectively final_.
<br>
- Trong lambda block code, ta **không thể thay đổi giá trị của biến local** vì việc
thay đổi giá trị này là **not thread-safe**

## Anonymous class vs Lambda Expression
| Anonymous class                                      | Lambda Expression                                                                                   |
|------------------------------------------------------|:----------------------------------------------------------------------------------------------------|
| Là class mà không có tên                             | là phương thức mà không có tên (Anonymous function)                                                 |
| Có thể impl interface có nhiều hơn 1 abstract method | chỉ có thể impl functional interface                                                                |
| có thể khởi tạo và kế thừa                           | Không thể khởi tạo và kế thừa                                                                       |
| có thể khai báo instance var                         | không thể khai báo instance var, cho dù các  <br/> biến được khai báo chỉ hoạt động như biến cục bộ |
| Performance thấp hơn                                 | Performance cao hơn                                                                                 |