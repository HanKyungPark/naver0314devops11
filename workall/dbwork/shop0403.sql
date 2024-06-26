

insert into hello (idx,blood,address) values (seq_test.nextval,'ab','서울 역삼');
--컬럼명 생략시 테이블의 컬럼 순서대로 모든값을 줘야한다
insert into hello values (seq_test.nextval,'이진','제주도 애월읍','o',23);

--수정
--이름이 '이진' 인 사람의 혈액형을 b형으로 변경해보자
update hello set blood='b' where irum='이진';
--idx가 2인 사람의 irum,age 를 수정해보자
update hello set irum='강호동',age=35 where idx=2;
--idx 가 1인 사람의 address,blood,age 의 값을 수정하세요
update hello set address='부산 해운대구',blood='a',age=23 where idx=1;

--삭제
--idx 가 1 인 사람 삭제
delete from hello where idx=1;
--age 가 30이상인 데이타는 모두 삭제
delete from hello where age>=30;

-- 테이블을 제거
drop table hello;
------------------------------------------------------------------
--새로운 테이블 생성,이번에는  각종 제약조건을 추가해서 생성해보자
create table student (
                         num number(3) CONSTRAINT pk_num primary key,
                         stuname varchar2(20) CONSTRAINT nn_name not null,
                         score number(3)CONSTRAINT ck_score check(score>=1 and score<=100),
                         birthday date
);

-- insert 로 데이타 추가를 하는데 각종 에러를 발생시켜보자
insert into student (num,stuname) values (1,'김미리');--ok

--ORA-01400: NULL을 ("ANGEL"."STUDENT"."NUM") 안에 삽입할 수 없습니다
insert into student (stuname,score) values ('이미자',45);--오류

--ORA-00001: 무결성 제약 조건(ANGEL.PK_NUM)에 위배됩니다
--num 은 pk(pk는 not null+unique)
insert into student (num,stuname) values (1,'홍진주');--오류

--ORA-02290: 체크 제약조건(ANGEL.CK_SCORE)이 위배되었습니다
--score 의 범위는 1~100 이라야 한다
insert into student (num,stuname,score) values (2,'강동호',110);--오류

--오류 없는 정상데이타로 추가해보자
insert into  student values (3,'이미자',89,sysdate);--날짜는 현재날짜로
insert into  student values (4,'김민종',100,'2010-12-20');
commit; --commit 을 일단 하면 rollback 이 안된다,
insert into  student values (5,'손미나',56,'2019-05-10');
insert into  student values (6,'강수지',98,sysdate);
insert into  student values (7,'김진우',67,'2015-09-12');
insert into  student values (8,'강호동',66,'2019-05-03');
commit;
rollback;--마지막 commit 한 이후의 DML 작업에 대한 롤백

--num 이 5번인 데이타의 이름을 '손미라',score를 80 으로 수정
update student set stuname='손미라',score=80 where num=5;
--birhday 의 월이 5인사람의 점수를 일괄적으로 85로 수정
update student set score=85 where to_char(birthday,'mm')='05';
commit;

--num 이 7인 데이타 삭제
delete from student where num=7;
--롤백 후 데이타 확인하기
rollback;
--다시 삭제문 실행
delete from student where num=7;
--커밋하기
commit;
--다시 롤백후 데이타 확인하기
rollback;--이미 커밋된 데이타는 취소되지 않는다

--불필요한 제약조건 제거
alter table student drop constraint ck_score;
alter table student drop constraint nn_name;

--새로운 제약조건 추가
alter table  student add constraint uq_name unique (stuname);

--같은 이름의 데이타를 추가해보자
insert into  student (num,stuname) values (10,'강호동');

--연습이 끝난후 시퀀스랑 테이블은 삭제해주세요
drop SEQUENCE  SEQ_TEST;
drop table student;

--------------------------------------------------------------------------------------
/*
 join 연습용 테이블 2개 생성하기
 테이블 #1 :
    food - foodnum 숫자(3)
           foodname 문자열(20)
           foodprice 숫자(7)
           foodsize 문자열(20)

    booking - bnum pk 숫자(3)
              bname 문자열(20) nn
              bhp   문자열(20) uq
              foodnum 숫자(3) - fk(food 의 foodnum)
              bookingday date

    외부키로 연결된경우 booking 에 데이타가 추가된이후 추가된 foodnum 은 삭제할수 없다
    (예를 들어 게시판의 댓글같은경우 외부키로 연결되어있는데
    이때도 댓글이 달린경우 해달글을 삭제할수 없는 게시판들이 있다)
    -그런데 만약 food의 데이타를 삭제하면 그 메뉴를 추가한 고객의 다이타도
 자동으로 삭제시키고자 할경우 booking 에 외부키를 설정할떄 on delete cascade 를 주면 된다.
 */
drop table food

create table food(
                     foodnum number(3) constraint pk_foodnum primary key,
                     foodname varchar2(20),
                     foodprice number(7),
                     foodsize varchar2(20)
);

--메뉴를 등록해보자
insert into food values (100,'짜장면',9000,'보통');
insert into food values (101,'짜장면',11000,'곱빼기');
insert into food values (200,'탕수육',15000,'보통');
insert into food values (201,'탕수육',20000,'곱빼기');
insert into food values (300,'칠리새우',15000,'보통');
insert into food values (301,'칠리새우',30000,'곱빼기');
insert into food values (400,'해물짬뽕',11000,'보통');
commit;

select *from food;

--시퀀스 추가
create sequence seq_food nocache ;

drop table  booking;
--booking 테이블 생성
create table booking
(
    bnum number(3)
        constraint pk_pnum primary key,
    bname varchar2(20) constraint nn_pname not null ,
    bhp varchar2(20)constraint uq_bhp unique,
    foodnum number(3),
    bookingday date,
    constraint fk_foodnum foreign key (foodnum) references food(foodnum));

select * from booking;

insert into booking values (seq_food.nextval,'홍범자','010-2222-3333',101,sysdate);--ok

--무결성 제약조건에 위배됩니다, 핸드폰이 같으면 안됨
insert into booking values (seq_food.nextval,'강호동','010-2222-3333',101,sysdate);--오류발생

--오늘로부터 7일후 예약
insert into booking values (seq_food.nextval,'이영자','010-3434-8899',301,sysdate+7)--ok;

--무결성 제약조건이 위배되었습니다. 부모 키가 없습니다.
insert into booking values (seq_food.nextval,'박지민','010-3434-4545',500,sysdate);

--join으로 두테이블을 조인해서 출력하시오
--bnum,bname,bhp,foodnum,foodname,foodprice,foodsize,bookingday(YYYY--mm-dd)
select
    bnum,bname,bhp,b.foodnum,foodname,foodprice,foodsize,
    to_char(bookingday,'yyyy-mm-dd') bookingday
    from food f,booking b
    where f.foodnum=b.foodnum;

--아무도 예약하지 않은 food 음식은 무엇이 있을까?
select
    bnum,f.foodnum,foodname,foodprice,foodsize
from food f,booking b
where f.foodnum=b.foodnum(+) and bnum is null;
--food 의 200번 메뉴는 삭제가 될까요?
delete from food where foodnum=200;

delete from food where foodnum=100;

--부모 테이블인 food 를 삭제해보자
drop table food;--오류발생, 자식테이블을 먼저 삭제후 부모테이블을 삭제해야만 한다

--연습이 끝난후 두테이블을 제거하세요
drop table booking;--자식 테이블 제거후 부모테이블 제거
drop table food;--자식 테이블 제거후 부모테이블 제거
--시퀀스도 제거

create sequence seq_shop nocache;
create table shop
(
    sang_no    number(3)
        constraint shop_pk_no primary key,
    sang_name  varchar2(30),
    sang_price number(10)
);
--외부키 설정시 on delete cascade 를 붙이면 부모테이블 삭제시 자식테이블에 추가된
--데이타도 같이 삭제됨
create table cart
(
    cart_no number(3)
        constraint cart_pk_no primary key,
    sang_no number(3),
    cnt     number(3),
    cartday date,
    constraint cart_fk_no foreign key (sang_no) references shop (sang_no) on delete cascade
);

--5개의 상품을 등록해보자
insert into shop values (seq_shop.nextval,'블라우스',12000);
insert into shop values (seq_shop.nextval,'조끼',19000);
insert into shop values (seq_shop.nextval,'청바지',25000);
insert into shop values (seq_shop.nextval,'체크코트',99000);
insert into shop values (seq_shop.nextval,'티셔츠',11000);
commit;
select * from shop;

--cart 에 원하는 상품을 담아보자
insert into cart values (seq_shop.nextval,2,3,sysdate);
insert into cart values (seq_shop.nextval,1,3,sysdate);
insert into cart values (seq_shop.nextval,5,1,sysdate);
commit;

--join 으로 조회하기
--cart_no,sang_no,sang_name,sang_pprice,cnt,cartday(yyyy-mm-dd) 출력
select
    cart_no,s.sang_no,sang_name,sang_price,cnt,to_char(cartday,'yyyy-mm-dd') cartday
   from shop s,cart c
where s.sang_no=c.sang_no;
--아무도 카트에 담지 않은 상품은?
select
    cart_no,s.sang_no,sang_name,sang_price
from  shop s,cart c
where s.sang_no=c.sang_no(+) and cart_no is null;

--on delete cascade 를 한경우 cart에 추가도니 상품도 삭제가 가능하다
--2번 조끼상품을 삭제해보자
delete from shop where sang_no=2;

--cart 를 확인해보면 cart 에 있던 2번 상품도 사라진걸 확인할수 있다
select
    cart_no,s.sang_no,sang_name,sang_price,cnt,to_char(cartday,'yyyy-mm-dd') cartday
from shop s,cart c
where s.sang_no=c.sang_no;

--테이블 제거는 역시 서브 테이블부터 삭제
drop table cart;
DROP table shop;
DROP sequence seq_shop;


