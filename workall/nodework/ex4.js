//함수 파라미터 기본값
// function func(x,y=100,z=200)
// {
//     console.log(x,y,z);
// }

//위의 함수를 화살표함수로 변경해보자
let func = (x, y = 100, z = 200) => console.log(x, y, z);

//두수의 합을 리턴하는 함수
let add = (a, b) => a + b;//return 생략

//두수의 곱을 리턴하는 함수
let mul = (a, b) => a * b;//return 생략

//함수를 호출해보자
func(4);
func(5, 6);
func(1, 2, 3);

console.log(add(3, 5));
console.log(mul(3, 5));