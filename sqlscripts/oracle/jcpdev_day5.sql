/*
SQL ����(select) ���� ����

1. custom# ���̺��� age �� 25�� �̻� ��� ���� ��ȸ
2. custom# ���̺��� custom_id 'momo' �� email ��ȸ
3. product# ���̺��� category '12' �� pname ��ȸ
4. product# ���̺��� price �� �ְ� ��ȸ
5. product# ���̺��� category '10' �� ���� ��ȸ
6. buy# ���̺��� custom_id 'nayeon' �� ��� ���� ��ȸ
7. buy# ���̺��� pcode �� 'LG'�� �����ϴ� �� ��ȸ
8. buy# ���̺��� cusom_id 'momo' �� ������ ��ǰ�� �̸��� ���� ��ȸ(�������� ���)

*/

-- 11�� 30�б��� ���� �����ϰ� ���� ����� ������.(����: �̸��� koreait.2021@gmail.com) �̿ϼ��ص� ����.


-- Ǯ��

--1. custom# ���̺��� age �� 25�� �̻� ��� ���� ��ȸ
SELECT * FROM "CUSTOM#" WHERE age >=25;

--2. custom# ���̺��� custom_id 'momo' �� email ��ȸ
SELECT EMAIL FROM "CUSTOM#" WHERE CUSTOM_ID ='momo';

--3. product# ���̺��� category '12' �� pname ��ȸ
SELECT pname FROM "PRODUCT#"  WHERE CATEGORY ='12';

--4. product# ���̺��� price �� �ְ� ��ȸ
SELECT MAX(PRICE) FROM "PRODUCT#";

--5. product# ���̺��� category '10' �� ���� ��ȸ
SELECT count(*) FROM "PRODUCT#" WHERE CATEGORY ='10';

--6. buy# ���̺��� custom_id 'nayeon' �� ��� ���� ��ȸ
SELECT * FROM buy# WHERE CUSTOM_ID ='nayeon';

--7. buy# ���̺��� pcode �� 'LG'�� �����ϴ� �� ��ȸ
SELECT * FROM buy# WHERE PCODE LIKE 'LG%';

--8. buy# ���̺��� cusom_id 'momo' �� ������ ��ǰ�� �̸��� ���� ��ȸ(�������� ���)
--  buy# ���̺��� ��ǰ ������ ���� ��ID�� ������ ����� �� �ֽ��ϴ�. 
SELECT  PNAME,PRICE FROM "PRODUCT#" 
		WHERE PCODE IN (SELECT PCODE FROM "BUY#" WHERE CUSTOM_ID ='nayeon');

SELECT pcode FROM "BUY#" WHERE CUSTOM_ID ='nayeon';
SELECT pcode FROM "BUY#" WHERE CUSTOM_ID ='momo';

SELECT PNAME,PRICE FROM "PRODUCT#" WHERE PCODE = 'MU98';


-- JOIN : �� �̻��� ���̺��� �����ϳ� �����͸� �˻��ϴ� ���.
--		  �� ���� ���̺� ����� �÷��� ����Ѵ�.
-- ���� ���� (���� ����) : ���� ���  buy# , product# ���̺��� �����ϸ�

-- ���� from ���̺�1 a,���̺�2 b where a.�ߺ��÷�1 = b.�ߺ��÷�1 : a,b���̺��� ���� ��������(�������輳���ķ����)

SELECT * FROM buy#, product# WHERE buy#.pcode = product#.pcode;      
-- �� �⺻�������� ���� Ȯ��

--SELECT pcode,price FROM buy#, product# WHERE buy#.pcode = product#.pcode;  -- ���� �� Ư���÷� ����

SELECT buy#.pcode,price FROM buy#, product# WHERE buy#.pcode = product#.pcode;

-- ���̺��, �÷����� alias (��Ī)�� �����մϴ�. -> �̸��� �����ϰ� �մϴ�.

-- buy# ���̺��� pcode ������ price �� �˰� �ʹ�. PCODE = 'MU98'
-- buy# ���̺��� ���� ���  buy_no ���� ���űݾ� ��� : price * quantity(����)
SELECT CUSTOM_ID , b.pcode,pname,price,quantity , price*quantity AS total  -- �÷����� AS �ᵵ �˴ϴ�.
		FROM buy# b, product# p        -- ����Ŭ�� ���̺�� �ڿ� AS �Ⱦ��ϴ�.
		WHERE b.pcode = p.pcode;    -- AS�� ������ �����ϰ� ���ϴ�.

SELECT CUSTOM_ID , b.pcode,pname, price,quantity , price*quantity total 
		FROM buy# b, product# p 
		WHERE b.pcode = p.pcode AND b.pcode = 'MU98'; 
 


SELECT * FROM "BUY#";


-- ���� ������ ����� �׷�ȭ : 
--				���1) with  ���2) from �ڿ� ���� sql �� ��������.  ���3) create view
--       ��  1.���� �� ���űݾ� -> sum(total) -> group by custom_id(FK)
--       ��  2.��ǰ�� �� �Ǹűݾ� -> sum(total) -> group by pcode(FK)

WITH sale as(  -- �ӽ����̺� -> �� �ѹ� ��� �մϴ�.�̸��� sale
	SELECT CUSTOM_ID , b.pcode AS p_code,pname,price,quantity , 
		   price*quantity AS total  -- �÷����� AS �ᵵ �˴ϴ�.
	FROM buy# b, product# p        -- ����Ŭ�� ���̺�� �ڿ� AS �Ⱦ��ϴ�.
	WHERE b.pcode = p.pcode
)
--1. ���� �� ���űݾ�
-- SELECT custom_id, sum(total) FROM sale GROUP BY custom_id;

--2. ��ǰ�� �� �Ǹűݾ�
SELECT p_code ,sum(total) FROM sale GROUP BY p_code;

-- with �Ⱦ���
SELECT p_code ,sum(total) 
	FROM  (SELECT CUSTOM_ID , b.pcode AS p_code,pname,price,quantity , 
		          price*quantity AS total  
			FROM buy# b, product# p        
			WHERE b.pcode = p.pcode)   -- from ���� select ����� �ζ��κ�(1ȸ���)
	GROUP BY p_code;

-- SELECT * FROM sale;  -- �׽�Ʈ��


-- select * from role_sys_privs where role='RESOURCE';  -- �ý������̺�(������ ����)
-- View : �������̺�(������������ ���� �ʴ´�.) �⺻ ���̺�� �̿��ؼ� ����ϰ� ������ select 
--        �Ͽ� �����(������)�� ���̺� ó�� ����� �� �ְ� �Ѵ�.
--        view �� �����ϱ� ���� resource,connect ���� �ܿ� create view ���� �ʿ��մϴ�.
CREATE VIEW v_sale   -- DROP VIEW �� �� ����, ALTER VIEW �� �����ϴ�.
AS
SELECT CUSTOM_ID , b.pcode AS p_code,pname,price,quantity , 
		          price*quantity AS total  
			FROM buy# b, product# p        
			WHERE b.pcode = p.pcode;

SELECT * FROM V_SALE; 
-- ��� �������� �������Է°� ������ ���������� �Ϲ������� select (��������ȸ) �������� ����մϴ�.

SELECT * FROM V_SALE WHERE CUSTOM_ID ='nayeon';


-- �ƿ��� ���� outer join : �ܺ� ���� (+) �����ȣ�� ǥ��
--		    ���������� ���������� �������� �ʴ� ��鵵 ���ΰ���� ���� �մϴ�.

SELECT * FROM "BUY#" b,"CUSTOM#" c WHERE b.CUSTOM_ID = c.CUSTOM_ID ;         --����(equal) ����

DELETE  FROM "BUY#" b WHERE b.CUSTOM_ID ='momo';
SELECT * FROM "BUY#" b,"CUSTOM#" c WHERE b.CUSTOM_ID = c.CUSTOM_ID ;    -- 'momo' ������  buy#���� ���� 

-- custom# ���̺��� momo �ֱ���, buy# ���� momo�� �����ϴ�.(���Ű� �����ϴ�.) -> �����ؼ� join �ϰ� �ʹٸ�
SELECT * FROM "BUY#" b,"CUSTOM#" c WHERE b.CUSTOM_ID(+) = c.CUSTOM_ID;


SELECT c.custom_id AS id, name, reg_date,age, nvl(pcode,'���ž���'),nvl(QUANTITY,0)
FROM "BUY#" b ,"CUSTOM#" c WHERE b.CUSTOM_ID(+) = c.CUSTOM_ID;

--SELECT c.custom_id AS id, name, reg_date,age, nvl(pcode,'���ž���'),nvl(QUANTITY,0)
--FROM  "CUSTOM#" c LEFT OUTER JOIN "BUY#" b on b.CUSTOM_ID = c.CUSTOM_ID;

-- ������ ������ ������ �ִ��� ���� �����մϴ�. �̷��� ���ô�.!!!


