# Một số functional interface hữu dụng
***

## 1. Predicate
Được sử dụng khi chúng ta muốn kiểm tra một điều kiện cho một giá trị
input nhất định, và trả về kiểu boolean

## 2. Function

Sử dụng khi người dùng muốn đưa vào một giá trị nào đó với kiểu dữ liệu
T bất kì, sau đó thực hiện các business logic, cuối cùng trả về
kết quả kiểu R

## 3. Unary Operator
Sử dụng khi cả input và output đều chung kiểu dữ liệu, khi đó thay
vì dùng Function, ta có thể dùg UnaryOperator

## 4. Consumer
Consumer interface luôn nhận vào (consumes) 1 giá trị input để 
thực hiện các logic nhưng không return bất cứ giá trị gì

## 5. Supplier
Supplier luôn trả về 1 giá trị mà không nhận vào param nào. Chẳng hạn,
khi muốn tạo 1 bản report hoặc generate ra 1 mã hashcode, ta không cần cung cấp
input

## 6. Binary Operator

## 7. Primitive Functional Interface
- Tất cả những functional interface đã tìm hiểu ở trên chỉ làm việc với
các KDL Object như Integer, Double, Boolean.
- Tuy nhiên có một vấn đề về performance với cách làm này.
  nếu chúng ta pass các giá trị là kiểu nguyên thuỷ như int, double,
Java sẽ tự động auto box chúng thành các wrapper object. Đối với 1 tập
dữ liệu lớn như 1 mảng có 10^6 phần tử chẳng hạn, quá trình này sẽ ảnh
hưởng tới performance