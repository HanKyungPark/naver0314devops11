//class method
class Person{
    constructor(name,age)
    {
        this.name=name;
        this.age=age;
    }

    //클래스 안의 메소드는 모두 클래스의 prototype
    //프로퍼티에 추가된다
    printProfile()
    {
        console.log(`이름:${this.name}, 나이:${this.age}`);
    }

    //정적함수
    static showTitle()
    {
        console.log("ES6의 정적함수입니다")
    }
}

//선언
let p=new Person("손흥민",25);//생성
p.printProfile();//메서드 호출
//멤버 메서드로 등록되어있는지 확인
console.log("printProfile" in p.__proto__);//true
console.log("printProfile" in Person.prototype);//true

//정적함수 호출 방법
Person.showTitle();//클래스명으로 호출