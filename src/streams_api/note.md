# Java stream
Stream là một tính năng mới được đặt trong package `java.util.stream`.
Xem trong package này ta có thể thấy vài loại stream như `Stream<T>` đại diện cho một stream của các đối tượng tham chiếu, hoặc dành riêng cho các kiểu nguyên thuỷ (primitives) như `IntStream, LongStream, DoubleStream`.
Một stream đại diện cho 1 chuỗi giá trị và  cho phép dùng các phép toán để thao tác với các giá trị đó một cách dễ dàng và rõ ràng.

## Lý thuyết về Stream
### Stream vs Collections
Điểm khác biệt giữa Stream và Collection (Array, List, ...) có thể kể đến:

- **Không lưu trữ:** Mục đích của các collection là lưu trữ, quản lý và truy cập vào các element. Trong khi đó thì stream không phải một kiểu cấu trúc dữ liệu để lưu trữ các element.
Chúng chỉ đem các giá trị từ một source nào đó, qua các bước tính toán
- **Không chỉnh sửa:** Các phép tính trong một stream sẽ tạo ra một kết quả riêng mà không làm thay đổi giá trị của data source đầu vào.
- **Laziness-seeking:** Có nhiều phép toán trong stream, như là filtering, mapping, sorting, duplicate removal có thể thực hiện một cách lazy
- **Giới hạn không bắt buộc:** Vì vậy stream cho phép chúng ta tính toán không giới hạn trong một thời gian hữu hạn.
- **Tiêu hao:** Các thành phần của một stream chỉ được duyệt 1 lần trong vòng đời của 1 stream. Để duyệt lại các đối tượng thì stream cần được sinh lại
### Các loại toán tử
- Intermediate operation: toán tử trung gian: toán tử trung gian trả về một stream mới. Chúng luôn là lazy.
Ví dụ như `filter(), map(), limit(), sorted(), distinct(),` ... Stream được tạo từ intermediate sẽ không được thực hiện cho đến khi có một toán tử terminal hay Final Operation được thực hiện
- Terminal/Final operation: toán tử đầu cuối, sẽ duyệt (thực thi) 1 stream để trả về 1 kết quả. Sau khi toán tử terminal được thực hiện, stream sẽ được xét như là đã được tiêu thụ, dùng (consumed), không còn được sử dụng nữa. Trong trường hợp bạn vẫn muốn duyệt cùng kiểu tập hợp dữ liệu đó, bạn cần phải quay lại data source và tạo ra stream mới.
  `forEach(), count() và collect()` <br />
Toán tử Intermediate operation có hai dạng: statefull và stateless:

- Stateless (filter, map): không giữ lại trạng thái của phần tử trước đó khi đang xử lý hay tương tác với một đối tượng mới
- Statefull (distinct và sorted): có thể sử dụng trạng thái của đối tượng trước để xử lý hay tương tác đối tượng mới. Stateful thường đòi hỏi duyệt toàn bộ data source trước khi tạo ra kết quả. Đặc điểm này cũng là yếu tố cần cân nhắc khi quyết định sử dụng đơn stream hay song song stream
## Cách sử dụng Stream
### 1. Tạo một Stream
Có nhiều cách tạo 1 stream từ nhiều data source khác nhau. Mỗi khi được tạo thì instance sẽ
không làm thay đổi source cũ
- _**Stream rỗng:**_ <br />
Khi muốn tạo một stream rỗng, ta dùng method empty():
    ```java
        Stream<String> streamEmpty = Stream.empty();
    ```
  Chúng ta thường sử dụng empty nếu muốn trả về một stream không có element khi check null collection.
- **_Stream từ Collection:_** <br />
  Stream có thể được tạo từ bất kì loại Collection nào (Collection, List, Set):
    ``` java
    Collection<String> collection = Arrays.asList("a", "b", "c");
    Stream<String> streamOfCollection = collection.stream();
    ```
- **_Stream từ Array_** <br />
    Stream cũng có thể được tạo từ mảng
    ```java
    Stream<String> streamOfArray = Stream.of("a", "b", "c");
    ```
- **_Stream.builder()_** <br />
  Phương thức builder() tạo ra một builder của Stream
  ```java
    //Sử dụng Stream builder()
    Stream.Builder<String> builder = Stream.builder();

    // Thêm một element vào trong stream
    Stream<String> stream = builder.add("Bean").build();

    // Xuất thông tin ra màn hình
    stream.forEach(System.out::println);
    ```
- **_Stream.generate()_**:
  Phương thức generate() cho phép truyền một Supplier vào để tự động generate ra element. Nếu như kết quả của stream là vô hạn, chúng ta cần chỉ định rõ giới hạn size:
  ```java
    // Dòng code sau tạo ra 1 stream trong đó có 10 phần tử "element"
    Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
    ```
- **_Stream.iterate()_** <br />
  Một cách khác để tạo ra một stream vô hạn là sử dụng iterate():
    ```java
    Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
    ```
  Phần tử đầu tiên của stream được tạo sẽ là param đầu tiên được truyền vào iterate(). Như vậy trong đoạn code trên, stream sau khi tạo sẽ có các phần tử 40,42,44,…
- **_Stream của kiểu dữ liệu nguyên thuỷ_**
    <br /> Java 8 cho phép chúng ta tạo stream từ 3 KDL nguyên thuỷ: int, double, long tương
    ứng với 3 interface: `IntStream, DoubleStream, LongStream`
  ```java
    IntStream intStream = IntStream.range(1,3);
    LongStream longStream = LongStream.rangeClosed(1,3);
    ```
  Ngoài ra Java 8 còn có class Random cung cấp các method để tạo ra một stream kiểu nguyên thuỷ và các phần tử ngẫu nhiên:
  ```java
    Random random = new Random();
    DoubleStream doubleStream = random.doubles(3);
    ```
- **_Stream từ một String_**:
  String cũng có thể là một nguồn tạo ra stream. Vì không có interface CharStream trong JDK nên IntStream được dùng để đại diện cho một stream gồm các phần tử kiểu char.
Mà thực chất các char cũng là những kí tự mang giá trị kiểu int, do đó cũng không cần thiết để sinh ra thêm 1 lớp stream nữa.
    ```java
    IntStream streamOfChars = "abc".chars();
    // hoặc dùng RegEx
    Stream<String> streamOfString = Pattern.compile(",").splitAsStream("a","b","c");
    ```
- **_Stream từ một File_**
<br /> Stream từ một File Lớp Files trong Java NIO cho phép tạo ra một Stream<String> của một file văn bản bằng phương thức line(). Mỗi dòng của file text này sẽ trở thành một phần tử của stream.
    ```java
    Path path = Paths.get("C:\\file.txt");
    Stream<String> streamOfStrings = Files.lines(path);
    Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));
    ```
### 2. Thứ tự thực thi
Để đảm bảo hiệu suất tốt nhất thì thứ tự thực thi các phép toán trong một stream pineline là điều quan trọng.
```java
  long size = list.stream().map(element -> {
      wasCalled();
      return element.substring(0, 3);
  }).skip(2).count();
  
  ```
trong đoạn code trên, stream có 3 phần tử -> method map() sẽ được gọi đến 3 lần. (chạy Đổi vị trí skip() và method, phương thức map() sẽ chỉ phải gọi 1 lần, do đó hiệu suất hơn hẳn vì không cần phải subtring() 2 phần tử bị loại bỏ.
```java
  long size = list.stream().skip(2).map(element -> {
      wasCalled();
      return element.substring(0, 3);
  }).count();
  ```
Bài học rút ra là đối với các intermediate operation làm giảm kích cỡ của stream thì nó nên được đặt trước các phép toán được sử dụng trên mỗi phần tử của stream. Vì vậy, luôn đặt các `skip(), filter(), distinct()` lên đầu của stream pineline.

### 3. Các phương thức reduction
Có nhiều phép toán terminal cho phép stream trả về một kết quả cụ thể. 
Chúng ta gọi đó là reduction. Có hai loại reduction: Aggregation và Collection.

#### a. Aggregation (reduce method)
Bao gồm các phép toán như sum, max, min,…
```java
  List<Integer> ages = new ArrayList<>();
  Stream<Integer> stream = ages.stream();
  Integer sum = stream.reduce(0, (age1, age2) -> age1 + age2));
  ```
Tham số thứ nhất là identity element để xác định giá trị gốc của kết quả trả về, tham số thứ hai là reduce operation.

#### b. Collection (collect method)
Collection hay còn gọi là mutable reduction, là việc gom hết tất cả các phần tử trả về từ stream sau khi mapping, filtering vào một container.
```java
  List<Person> people = new ArrayList<>();
  String result = people.stream()
      .filter(p -> p.getAge() > 20)
      .map(Person::getLastname)
      .collect(Collectors.joining(","));
  
  List<String> list = people.stream()
      .filter(p -> p.getAge() > 20)
      .map(Person::getLastname)
      .collect(Collectors.toList());
  
  Map<Integer, List<Person>> map = people.stream()
      .filter(p -> p.getAge() > 20)
      .collect(Collectors.groupingBy(Person::getAge));
  ```
# Tài liệu tham khảo
[https://viblo.asia/p/tuot-tuon-tuot-ve-stream-trong-java8-Qbq5QvwwKD8](https://viblo.asia/p/tuot-tuon-tuot-ve-stream-trong-java8-Qbq5QvwwKD8)