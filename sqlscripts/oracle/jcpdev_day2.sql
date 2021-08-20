-- ���θ� : ���� ��ǰ�� �����Ѵ�.
-- ��(custom) ���̺� ���� : �ʵ�(�÷�) ������ �̸��� ���������� �߿�.
CREATE TABLE custom (    
	-- �� ���̵�(���ڿ�,var:�������� char:���� , ����2,�������ڵ� utf-8)
	-- �� �̸�(���ڿ�)
	-- �̸���(���ڿ�)
	-- ����(����,number) 3�ڸ� *number : int,long,float,doble
	-- ��������(��¥ Ÿ��)
	custome_id varchar2(20), --����Ʈ ����
	name varchar2(20),
	email varchar2(20),
	age number(3),
	reg_date date
);

-- ��ǰ(product) ���̺� : ��ǰ�ڵ�,ī�װ�(�ڵ�:2�ڸ�),��ǰ��,���� 
--								�� 00:������ǰ,10:��ǰ,20:��Ȱ��ǰ..
CREATE TABLE product(
	pcode varchar2(10),  -- ������ ������ ����ؼ� �����ϰ� ū �����
	category char(2),   --�������̷� 2����Ʈ
	pname varchar2(50),  -- utf-8 �ѱ��϶� ���� 16��
	price number(9)
);

-- ����(buy)���̺� : �� who , ��ǰ what �����ߴ°�?
CREATE TABLE buy(
	custome_id varchar2(20),  --who
	pcode varchar2(10), --what
	quantity NUMBER(5), --how many?
	buy_date DATE --when
);

-- inset(DML) ���� : ���̺� ���ο� ������ �߰��մϴ�.
-- insert into ��Ű���̸�.���̺��̸� (�÷�1,�÷�2,,,,)
-- values (�÷�1��,�÷�2��,,,,,);
INSERT INTO JCPDEV.CUSTOM (CUSTOME_ID,NAME,EMAIL,AGE,REG_DATE)
VALUES ('mina2012','��̳�','kim@gmail.com',20,'2020-05-23');

-- ��Ű���̸� ������ �������� , ��� �÷��� null ����ϹǷ� �Ʒ� insert �����մϴ�.
INSERT INTO custom(custome_id) VALUES ('dayeon11');
INSERT INTO custom(reg_date) VALUES ('2021-08-10');
INSERT INTO custom(reg_date) VALUES (sysdate);   -- ���� ��¥ : sysdate
INSERT INTO custom(CUSTOME_ID,NAME,EMAIL)
			VALUES ('soon1234','������','test@daum.net');
-- ���ڿ� '' , ��ġ���� ��ȣ���� �ۼ�.
INSERT INTO CUSTOM (age) VALUES (33);

-- ��� �÷����� �߰��Ҷ�, ���̺��̸� �ڿ� �÷��̸��� �����մϴ�.
INSERT INTO CUSTOM
	VALUES ('mina2014','�̹̳�','lee@gmail.com',21,'2020-05-23');

/*   ���̺� ����� ������ ���� : update(����) ,delete(����)
 *   update ���̺��̸� set �÷��̸�1=�����Ұ�1,�÷��̸�2=�����Ұ�2,,,,,
 *          where ����;
 */
-- where ���Ǿ��� UPDATE : ��� row �鿡 ���� --> �ſ� ������ �۾�.(�ٶ���X)
UPDATE CUSTOM SET REG_DATE = SYSDATE ;
UPDATE CUSTOM SET age=25 WHERE CUSTOME_ID ='dayeon11';
-- name ���� null �� ��� name='�մ�' ���� update 
UPDATE custom SET name='�մ�' WHERE name is NULL;
-- custome_id ���� null �� ��� custome_id='guest' �� update
UPDATE CUSTOM SET CUSTOME_ID ='guest' WHERE CUSTOME_ID IS NULL;

-- age ���� 20���� ������ age=99 �� update
UPDATE custom SET age=99 WHERE age < 20;  --null���� �ȵ˴ϴ�.

-- and , or --> ���� ������ �˻�  
-- �񿬼����� ���� ���������� �˻� --> in 
UPDATE custom SET age=98 WHERE age IN (20,25);
UPDATE custom SET age=97 WHERE age=98 OR age=33; -- age IN (98,33)
-- set �ڿ� �������� �÷� ������ �� �ֽ��ϴ�.
UPDATE custom SET age=37,EMAIL='koreait@korea.com' 
		WHERE age IS NULL AND EMAIL IS NULL;
	
-- delete ����
DELETE FROM CUSTOM WHERE EMAIL IS null;	
DELETE FROM custom WHERE age=99;	

-- ��¥�� ���̺��� �����͸� ��� �����ϰ� �ʹٸ�....
TRUNCATE TABLE CUSTOM ;

-- custom ���̺� ��� ������ ������~~
SELECT * FROM CUSTOM;

INSERT INTO PRODUCT VALUES ('ipad10','00','�����е�10',880000);
INSERT INTO PRODUCT VALUES ('snk099','10','�һ����',2200);
INSERT INTO PRODUCT VALUES ('dk_14','20','��ǻ��å��',199900);

INSERT INTO BUY VALUES ('mina2012','ipad10',2,sysdate);
INSERT INTO BUY VALUES ('mina2012','snk099',11,sysdate);
INSERT INTO BUY VALUES ('mina2021','dk_144',1,sysdate);
INSERT INTO BUY VALUES ('mina2014','snk099',1,'2020-11-22');
SELECT * FROM PRODUCT;
SELECT * FROM BUY;


-- ���ݱ����� select �� ���̺��� ��� ���� �����ֱ�
--1. Ư�� �÷��� ����ʹ�.
SELECT custome_id,age FROM CUSTOM;
SELECT LOWER(custome_id),age FROM CUSTOM;

--2. Ư�� row (�˻����ǿ� �´�) ����ʹ�. --> where
-- ���� �������� ��ȸ : 40�� �̸�
SELECT * FROM CUSTOM WHERE age <40;
SELECT * FROM CUSTOM WHERE age IN (37,97);
SELECT * FROM CUSTOM WHERE age NOT IN (37,97); -- NULL ����
SELECT * FROM custom ;
-- �̸� �������� �˻�
SELECT * FROM CUSTOM WHERE name ='�մ�';
SELECT * FROM custom WHERE name NOT IN ('�մ�');

-- ���� �� : ��, custome_id �� mina�� �����ϴ� ������ ��ȸ
SELECT * FROM custom WHERE custome_id LIKE 'mina%' ; 
--							  mina�� ������ ������ ��ȸ
SELECT * FROM custom WHERE custome_id LIKE '%mina' ;  
--                            mina�� ���Ե� ������ ��ȸ
SELECT * FROM custom WHERE custome_id LIKE '%mina%' ;

SELECT * FROM custom WHERE custome_id LIKE '%Mina%' ;    


-- ����Ŭ���� ���̺��,�÷��� ��� ��ü�ĺ��� �̸��� ��ҹ��� ���о��մϴ�.
-- ����� ���ڿ� �����ʹ� ��ҹ��� �����մϴ�.

-- dual ���̺� : � ���ѿ����� ����� ������ �ӽ����̺�
SELECT 22*33 AS result FROM DUAL ; -- AS �ڿ� ��Ī
SELECT LOWER('MiNa') FROM dual;   --�ҹ��� ��ȯ
SELECT UPPER('MiNa') FROM dual;   --�빮�� ��ȯ
SELECT sysdate AS today FROM DUAL ;

--3. �����ִ� ���� : order by �÷��̸� [asc(�⺻������)|desc]
SELECT * FROM CUSTOM ORDER BY NAME ;
-- ���� ������� -> ������� ���� : �������� desc(descending)
SELECT * FROM custom ORDER BY age DESC ;
SELECT * FROM custom ORDER BY age DESC , name; 
					-- ���� ������ age ����, 2�� ����(age������) name





/*  ���̺� ������ ���� ������ ���̺� �� �÷��� �������� �䱸���� ���� �ʿ��մϴ�.
 *  ������ ���� ���� �����Դϴ�.!!
 *  ��������(contraints) �� �����մϴ�. --> �������� ���Ἲ ����.
 * 		�� not null
 * 		�� �⺻�� ���� : ���� ��� reg_date, buy_date�� ���糯¥�� �Ѵ�.
 * 		�� ���� ���� : quntity(����) �� 1���� ū������ �Ѵ�.
 * 		�� ������ ��(unique) �÷� : custom_id , pcode (� ���̺��� ����ũ�÷��� 1���̻�)
 * 		�� �⺻Ű(primary key) : �˻�,rows �ĺ� �÷��� ǥ��-> unique �÷� �߿��� ���ϴ�.
 * 							: �⺻Ű�� 2�� �̻� �÷��� �׷�ȭ�� �� �ֽ��ϴ�.
 *  	�� �ܷ�Ű(foreign key) : ����Ű. �ٸ� ���̺��� ��÷� ���� �����ϰ� �ִ���?
 * 					:buy���̺��� custom_id ������ custom ���̺��� �����Ѵ�.
 * 					:�������� �ߺ�����/�ϰ��� ������ ���� ����Դϴ�.
 * 					:--> buy ���̺��� �Ŷ�� ������ ���� �̸��� �˰� �ʹ�.
 */




