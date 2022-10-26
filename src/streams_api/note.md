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
Ví dụ như filter(), mapping(), ... Stream được tạo từ intermediate sẽ không được thực hiện cho đến khi có một toán tử terminal hay Final Operation được thực hiện
- Terminal/Final operation: toán tử đầu cuối, sẽ duyệt (thực thi) 1 stream để trả về 1 kết quả. Sau khi toán tử terminal được thực hiện, stream sẽ được xét như là đã được tiêu thụ, dùng (consumed), không còn được sử dụng nữa. Trong trường hợp bạn vẫn muốn duyệt cùng kiểu tập hợp dữ liệu đó, bạn cần phải quay lại data source và tạo ra stream mới.

Toán tử Intermediate operation có hai dạng: statefull và stateless:

- Stateless (filter, map): không giữ lại trạng thái của phần tử trước đó khi đang xử lý hay tương tác với một đối tượng mới
- Statefull (distinct và sorted): có thể sử dụng trạng thái của đối tượng trước để xử lý hay tương tác đối tượng mới. Stateful thường đòi hỏi duyệt toàn bộ data source trước khi tạo ra kết quả. Đặc điểm này cũng là yếu tố cần cân nhắc khi quyết định sử dụng đơn stream hay song song stream
## Cách sử dụng Stream
### 1. Tạo một Stream
Có nhiều cách tạo 1 stream từ nhiều data source khác nhau. Mỗi khi được tạo thì instance sẽ
không làm thay đổi source cũ
- Stream rỗng
- Stream từ Collection
- Stream từ Array
- Stream.builder()
- Stream.generate()
- Stream.iterate()
- Stream của kiểu dữ liệu nguyên thuỷ
- Stream từ một String
- Stream từ một File