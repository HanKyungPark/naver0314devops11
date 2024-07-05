//js 에서 모듈 사용하기
/*
 하나의 함수에서 모든 기능을 넣는것보다 기능별로 여러개의
 함수로 만들어두면 필요한 함수만 가져다 사용하고 다른곳에서도
 재사용할수있고 효율적이다
 */
//모듈의 장점은 재사용이 가능하다는것이다
//리액트에서는 이것을 컴포넌트라고 한다.

let m1=require('./modfunc.js');
console.log("모듈 1의 함수 호출:"+m1.add(10,20));
let age=21;
console.log("%d 세는 %s입니다",age,m1.check(age));


let m2=require("./modfunc2.js");
let score=78;
console.log("두수의 곱:"+m2.mul(2,4));